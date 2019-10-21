package com.clinbrain.datac.compare.define;

import com.clinbrain.datac.compare.JobConstants;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

/**
 * Created by Liaopan on 2019/7/24.
 */
public interface CompareResult<R> {

    boolean isSuccessed();

    int getLeftSize();

    int getRightSize();

    R getLeft();

    R getRight();

    String getlMessage();

    String getrMessage();

    Pair<List,List> leftCompareRight();

    boolean isSameSize() ;

    void clear();

    public JobConstants.ExecStrategy getType();

}
