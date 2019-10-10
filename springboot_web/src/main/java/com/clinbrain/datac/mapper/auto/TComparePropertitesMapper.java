package com.clinbrain.datac.mapper.auto;

import com.clinbrain.datac.model.auto.TComparePropertites;
import com.clinbrain.datac.model.auto.TComparePropertitesExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TComparePropertitesMapper {
    long countByExample(TComparePropertitesExample example);

    int deleteByExample(TComparePropertitesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TComparePropertites record);

    int insertSelective(TComparePropertites record);

    List<TComparePropertites> selectByExample(TComparePropertitesExample example);

    TComparePropertites selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TComparePropertites record, @Param("example") TComparePropertitesExample example);

    int updateByExample(@Param("record") TComparePropertites record, @Param("example") TComparePropertitesExample example);

    int updateByPrimaryKeySelective(TComparePropertites record);

    int updateByPrimaryKey(TComparePropertites record);

    TComparePropertites selectByPropertyName(String propertyName);
}