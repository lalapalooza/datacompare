package com.clinbrain.datac.compare;

import com.clinbrain.datac.compare.define.CompareResult;
import com.clinbrain.datac.compare.resultHandler.MapClassResultHandler;
import com.github.rholder.retry.RetryException;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.dbutils.QueryRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Liaopan on 2019/7/17.
 */
public class CompareColumnsReturnMap extends BaseCompare {
    private static final Logger LOG = LoggerFactory.getLogger(CompareColumnsReturnMap.class);
    private static final ExecutorService cachedThreadPool = Executors.newFixedThreadPool(20,
            new ThreadFactoryBuilder().setNameFormat("query-exec-%d").build());

    @Override
    public CompareResult compare(final String sourceQuery, final String targetQuery) throws Exception {

        CompareResultMap resultList = null;
        try(Connection sc = source.getConnection();Connection tc = target.getConnection()) {
            QueryRunner sourceR = new QueryRunner(statementConfiguration);
            QueryRunner targetR = new QueryRunner(statementConfiguration);
            LOG.info("====执行查询sql====");
            LOG.info("-》 source:" + sourceQuery);
            LOG.info("-》 target:" + targetQuery);
            LOG.info("==========end====");
            final CompareResultMap.Builder builder = new CompareResultMap.Builder();

            final CountDownLatch latch = new CountDownLatch(2);

            final String logFile = MDC.get("logFileName");

            cachedThreadPool.submit(() -> {
                MDC.put("logFileName", logFile);
                try {
                    retryer.call(() -> {
                        MDC.put("logFileName", logFile);
                        LOG.info("提交源端查询");
                        try {
                            invalidate(sc);
                            builder.left(sourceR.query(sc, sourceQuery, new MapClassResultHandler("源")));
                        } catch (SQLException e) {
                            LOG.error("源表查询出错", e);
                            builder.left(Maps.newHashMap());
                            builder.lMessage(e.getMessage());
                            throw new SQLException(e.getMessage());
                        }
                        return true;
                    });
                } catch (RetryException | ExecutionException e) {
                    LOG.error("源查询重试后出错", e);
                } finally {
                    MDC.remove("logFileName");
                    latch.countDown();

                }
            });
            cachedThreadPool.submit(() -> {
                MDC.put("logFileName", logFile);
                try {
                    retryer.call(() -> {
                        MDC.put("logFileName", logFile);
                        LOG.info("提交目标端查询");
                        try {
                            invalidate(tc);
                            builder.right(targetR.query(tc, targetQuery, new MapClassResultHandler("目标")));
                        } catch (SQLException e) {
                            LOG.error("目标表查询出错", e);
                            builder.right(Maps.newHashMap());
                            builder.rMessage(e.getMessage());
                            throw new SQLException(e.getMessage());
                        }
                        return true;
                    });
                } catch (RetryException | ExecutionException e) {
                    LOG.error("目标查询重试后出错", e);
                } finally {
                    MDC.remove("logFileName");
                    latch.countDown();
                }
            });

            latch.await();
            // 比对数据
            resultList = builder.builder();
        }
            return resultList;

    }
}
