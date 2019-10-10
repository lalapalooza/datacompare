package com.clinbrain.datac.compare.define;

/**
 * Created by Liaopan on 2019/7/8.
 */
public interface CompareInterface {

    CompareResult compare(final String sourceQuery, final String targetQuery) throws Exception;
}
