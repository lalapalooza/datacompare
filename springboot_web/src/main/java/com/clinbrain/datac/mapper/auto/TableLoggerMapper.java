package com.clinbrain.datac.mapper.auto;

import com.clinbrain.datac.model.auto.TableLogger;
import com.clinbrain.datac.model.auto.TableLoggerExample;
import com.clinbrain.datac.model.auto.TableLoggerWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TableLoggerMapper {
    long countByExample(TableLoggerExample example);

    int deleteByExample(TableLoggerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TableLoggerWithBLOBs record);

    int insertSelective(TableLoggerWithBLOBs record);

    List<TableLoggerWithBLOBs> selectByExampleWithBLOBs(TableLoggerExample example);

    List<TableLogger> selectByExample(TableLoggerExample example);

    TableLoggerWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TableLoggerWithBLOBs record, @Param("example") TableLoggerExample example);

    int updateByExampleWithBLOBs(@Param("record") TableLoggerWithBLOBs record, @Param("example") TableLoggerExample example);

    int updateByExample(@Param("record") TableLogger record, @Param("example") TableLoggerExample example);

    int updateByPrimaryKeySelective(TableLoggerWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TableLoggerWithBLOBs record);

    int updateByPrimaryKey(TableLogger record);
}