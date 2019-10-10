package com.clinbrain.datac.compare;

import com.clinbrain.datac.compare.define.CompareResult;
import com.clinbrain.datac.util.StringUtils;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Liaopan on 2019/7/19.
 */
public class CompareResultMap implements CompareResult {
    private Map<String, Object> left;
    private String lMessage;
    private Map<String, Object> right;
    private String rMessage;

    public static final class Builder {

        private Map<String, Object> left;
        private String lMessage = "";
        private Map<String, Object> right;
        private String rMessage = "";

        public CompareResultMap.Builder left(Map<String, Object> left) {
            this.left = left;
            return this;
        }

        public CompareResultMap.Builder right(Map<String, Object> right) {
            this.right = right;
            return this;
        }

        public CompareResultMap.Builder lMessage(String msg) {
            this.lMessage = msg;
            return this;
        }

        public CompareResultMap.Builder rMessage(String msg) {
            this.rMessage = msg;
            return this;
        }

        public CompareResultMap builder() {
            return new CompareResultMap(left, right,lMessage,rMessage);
        }
    }

    private CompareResultMap(Map<String, Object> left, Map<String, Object> right,String lMessage,String rMessage) {
        this.left = left;
        this.right = right;
        this.lMessage = lMessage;
        this.rMessage = rMessage;
    }

    public Map<String, Object> getLeft() {
        return this.left;
    }

    public Map<String, Object> getRight() {
        return this.right;
    }

    public String getlMessage() {
        return lMessage;
    }

    public String getrMessage() {
        return rMessage;
    }

    public Pair<List<Object>, List<Object>> leftCompareRight() {
        Iterator<String> iterator = this.left.keySet().iterator();
        List<Object> tempLeft = new ArrayList<>();
        // 比对数据
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object value = this.left.get(key);
            Object remove = this.right.remove(key);
            if(remove == null) { // left 有，right 里没有的值
                tempLeft.add(value);
            }
        }
        //将right 中剩下的项就是left 里面没有的
        return new MutablePair<>(tempLeft,Lists.newArrayList(this.right.values()));
    }

    private int nullSizeTo(Map map) {
        return Optional.ofNullable(map).map(Map::size).orElse(-1);
    }
    @Override
    public boolean isSameSize() {
        return nullSizeTo(this.left) > 0 && nullSizeTo(this.right) > 0
                && nullSizeTo(this.left) == nullSizeTo(this.right);
    }

    @Override
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

    @Override
    public int getLeftSize() {
        return nullSizeTo(this.left);
    }

    @Override
    public int getRightSize() {
        return nullSizeTo(this.right);
    }
}
