package com.clinbrain.datac.compare;

import com.clinbrain.datac.compare.define.CompareResult;
import com.clinbrain.datac.util.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Optional;

/**
 * Created by Liaopan on 2019/7/5.
 */
public class CompareResultList implements CompareResult<List> {

    private List left;
    private String lMessage;
    private List right;
    private String rMessage;

    public static final class Builder {

        private List left;
        private String lMessage = "";
        private List right;
        private String rMessage = "";

        public Builder left(List left) {
            this.left = left;
            return this;
        }

        public Builder right(List right) {
            this.right = right;
            return this;
        }

        public Builder lMessage(String msg) {
            this.lMessage = msg;
            return this;
        }

        public Builder rMessage(String msg) {
            this.rMessage = msg;
            return this;
        }

        public CompareResultList builder() {
            return new CompareResultList(left, right,lMessage,rMessage);
        }
    }

    private CompareResultList(List left, List right, String lMessage, String rMessage) {
        this.left = left;
        this.right = right;
        this.lMessage = lMessage;
        this.rMessage = rMessage;
    }

    public List getLeft() {
        return this.left;
    }

    public List getRight() {
        return this.right;
    }

    public String getlMessage() {
        return lMessage;
    }

    public String getrMessage() {
        return rMessage;
    }

    public int getLeftSize(){
        return this.left.size();
    }
    public int getRightSize(){
        return this.right.size();
    }

    public Pair<List, List> leftCompareRight() {

        List tempLeft = (List) CollectionUtils.subtract(this.left,this.right);
        List tempRight= (List) CollectionUtils.subtract(this.right,this.left);
        return new MutablePair<>(tempLeft,tempRight);
    }

    public boolean isSameSize() {
        return nullSizeTo(this.left) > 0 && nullSizeTo(this.right) > 0
                && nullSizeTo(this.left) == nullSizeTo(this.right);
    }

    private int nullSizeTo(List list) {
        return Optional.ofNullable(list).map(List::size).orElse(-1);
    }

    public void clear() {
        if(this.left != null) {
            this.left.clear();
            this.left = null;
        }

        if(this.right != null) {
            this.right.clear();
            this.right = null;
        }
    }

    public boolean isSuccessed() {
        return (StringUtils.isEmpty(this.getlMessage()) && StringUtils.isEmpty(this.getrMessage())) ;
    }

}
