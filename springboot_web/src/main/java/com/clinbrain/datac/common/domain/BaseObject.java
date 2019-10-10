package com.clinbrain.datac.common.domain;

/**
 * Created by Liaopan on 2019/7/3.
 */

import com.clinbrain.datac.util.MD5Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class BaseObject {

    private static final Gson GSON =
            new GsonBuilder()
                    .serializeNulls()
                    .disableInnerClassSerialization()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS")
                    .create();

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder()
                .disableInnerClassSerialization()
                .excludeFieldsWithoutExposeAnnotation()
                .setDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS")
                .create();
        return gson.toJson(this);
    }

    public String md5() {
        return MD5Util.encode(GSON.toJson(this));
    }
}

