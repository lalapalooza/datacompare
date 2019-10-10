package com.clinbrain.datac.compare;

import com.clinbrain.datac.compare.define.CompareResult;
import com.clinbrain.datac.util.StringUtils;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;


/**
 * Created by Liaopan on 2019/7/19.
 */
public class CompareResultCount implements CompareResult<Long> {
    private long left;
    private String lMessage;
    private long right;
    private String rMessage;

    public static final class Builder {

        private long left;
        private String lMessage = "";
        private long right;
        private String rMessage = "";

        public CompareResultCount.Builder left(long left) {
            this.left = left;
            return this;
        }

        public CompareResultCount.Builder right(long right) {
            this.right = right;
            return this;
        }

        public CompareResultCount.Builder lMessage(String msg) {
            this.lMessage = msg;
            return this;
        }

        public CompareResultCount.Builder rMessage(String msg) {
            this.rMessage = msg;
            return this;
        }

        public CompareResultCount builder() {
            return new CompareResultCount(left, right,lMessage,rMessage);
        }
    }

    private CompareResultCount(long left, long right, String lMessage, String rMessage) {
        this.left = left;
        this.right = right;
        this.lMessage = lMessage;
        this.rMessage = rMessage;
    }

    public Long getLeft() {
        return this.left;
    }

    public Long getRight() {
        return this.right;
    }

    public String getlMessage() {
        return lMessage;
    }

    public String getrMessage() {
        return rMessage;
    }

    public Pair<List, List> leftCompareRight() {

        return new MutablePair<>(Lists.newArrayList(),Lists.newArrayList());
    }

    @Override
    public boolean isSameSize() {
        return this.left > 0 && this.right > 0
                && this.left == this.right;
    }

    @Override
    public void clear() {
        this.left = -1;
        this.right = -1;
    }

    public boolean isSuccessed() {
        return (StringUtils.isEmpty(this.getlMessage()) && StringUtils.isEmpty(this.getrMessage())) ;
    }

    @Override
    public int getLeftSize() {
        return Long.valueOf(this.left).intValue();
    }

    @Override
    public int getRightSize() {
        return Long.valueOf(this.right).intValue();
    }
}
