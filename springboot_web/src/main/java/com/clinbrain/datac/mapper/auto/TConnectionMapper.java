package com.clinbrain.datac.mapper.auto;

import com.clinbrain.datac.model.auto.TConnection;
import com.clinbrain.datac.model.auto.TConnectionExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TConnectionMapper {
    long countByExample(TConnectionExample example);

    int deleteByExample(TConnectionExample example);

    int deleteByPrimaryKey(String connectionCode);

    int insert(TConnection record);

    int insertSelective(TConnection record);

    List<TConnection> selectByExample(TConnectionExample example);

    TConnection selectByPrimaryKey(String connectionCode);

    int updateByExampleSelective(@Param("record") TConnection record, @Param("example") TConnectionExample example);

    int updateByExample(@Param("record") TConnection record, @Param("example") TConnectionExample example);

    int updateByPrimaryKeySelective(TConnection record);

    int updateByPrimaryKey(TConnection record);
}