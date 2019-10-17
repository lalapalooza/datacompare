package com.clinbrain.datac.spark;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import cn.hutool.json.JSONUtil;

/**
 * Created by Liaopan on 2019/9/25.
 */
public class DataCompareTask {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("参数设置错误,参数格式: jdbc:mysql://server:port~com.mysql.jdbc.Driver~scheme.table~select query~user~password");
            System.exit(2);
        }
        Long id = null;
        String source = args[0];
        String target = args[1];
        if (args.length == 2) {
            source = args[0];
            target = args[1];
        }

        if (args.length == 3) {
            source = args[0];
            target = args[1];
            id = Long.parseLong(args[2]);
            updateStatus(id);
        }
        System.out.println("source:" + source);
        System.out.println("target:" + target);

        long sourceCount = -1L;
        long targetCount = -1L;
        long sourceDiffCount = 0L;
        long targetDiffCount = 0L;
        List<String> sourceList = null;
        List<String> targetList = null;

        SparkSession sparkSession = SparkSession.builder()
                //.master("local[*]")
                .appName("data-compare sql query")
                .config("spark.sql.broadcastTimeout", "36000")
                .getOrCreate();
        String errMsg = null;
        try {

            JdbcModel sourceModel = new JdbcModel(source.split("~"));
            JdbcModel targetModel = new JdbcModel(target.split("~"));

            Dataset<Row> dataset = JdbcTask.call(sparkSession, sourceModel);
            Dataset<Row> tdataset = JdbcTask.call(sparkSession, targetModel);

            sourceCount = dataset.count();
            targetCount = tdataset.count();

            if (sourceCount > -1 && targetCount > -1 ) { // 计算差值
                Dataset<Row> sourceDiff = dataset.except(tdataset);
                sourceDiffCount = sourceDiff.count();
                if (sourceDiffCount > 2000) {
                    sourceDiff = sourceDiff.limit(100);
                }
                Dataset<Row> targetDiff = tdataset.except(dataset);
                targetDiffCount = targetDiff.count();
                if (targetDiffCount > 2000) {
                    targetDiff = targetDiff.limit(100);
                }
                sourceList = sourceDiff.toJSON().collectAsList();
                targetList = targetDiff.toJSON().collectAsList();
            }
        } catch (Exception e) {
            errMsg = e.getMessage();
            throw new RuntimeException(e);
        } finally {
            sparkSession.stop();
            if(id != null) {
                updateLogger(id, sourceCount, targetCount, sourceDiffCount, sourceList, targetDiffCount, targetList, errMsg);
            }
        }
    }

    private static void updateStatus(Long id) {
        QueryRunner q = new QueryRunner();
        try {
            q.update(JdbcUtil.getConnect(),"update table_logger set status = 1 where id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void updateLogger(long id,long sourceDataCount,long targetDataCount,long sourceDiffCount,
                              List<String> sourceData,long targetDiffCount , List<String> targetData,
                              String errorMessage) {
        String sql =  "update table_logger set source_data = ? , target_data = ? , source_batch = ?, target_batch = ? ," +
                "status = ? , message = ? where id = ?";
        QueryRunner q = new QueryRunner();
        try {
            q.execute(JdbcUtil.getConnect(),sql,sourceData == null || sourceData.isEmpty() ? null : sourceDiffCount + "|" +JSONUtil.toJsonStr(sourceData),
                    targetData == null || targetData.isEmpty() ? null : targetDiffCount + "|" + JSONUtil.toJsonStr(targetData),
                    sourceDataCount,
                    targetDataCount,
                    errorMessage == null ? 0 : -1,
                    errorMessage, id);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}