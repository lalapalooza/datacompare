package com.clinbrain.datac.mapper.auto;

import com.clinbrain.datac.model.auto.TableConfig;
import com.clinbrain.datac.model.auto.TableConfigExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TableConfigMapper {
    long countByExample(TableConfigExample example);

    int deleteByExample(TableConfigExample example);

    int deleteByPrimaryKey(String id);

    int insert(TableConfig record);

    int insertSelective(TableConfig record);

    List<TableConfig> selectByExample(TableConfigExample example);

    TableConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TableConfig record, @Param("example") TableConfigExample example);

    int updateByExample(@Param("record") TableConfig record, @Param("example") TableConfigExample example);

    int updateByPrimaryKeySelective(TableConfig record);

    int updateByPrimaryKey(TableConfig record);
}