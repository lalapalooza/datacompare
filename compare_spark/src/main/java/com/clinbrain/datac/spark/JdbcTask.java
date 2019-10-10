package com.clinbrain.datac.spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * Created by Liaopan on 2019/9/25.
 */
public class JdbcTask {

    public static Dataset<Row> call(SparkSession sparkSession, JdbcModel model) {
        return sparkSession.read().format("jdbc")
                .option("url", model.getJdbcUrl())
                .option("driver", model.getDriver())
                .option("dbtable", "(" + model.getQuery() + ") temp")
                .option("query", model.getQuery())
                .option("user", model.getUser())
                .option("password", model.getPassword()).load();
    }
}
