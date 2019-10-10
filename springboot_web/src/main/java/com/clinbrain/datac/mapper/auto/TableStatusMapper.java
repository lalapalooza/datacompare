package com.clinbrain.datac.mapper.auto;

import com.clinbrain.datac.model.auto.TableStatus;
import com.clinbrain.datac.model.auto.TableStatusExample;

import java.util.List;
import java.util.Map;

/**
 * VIEW
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-09-18 17:25:59
 */
public interface TableStatusMapper {
    long countByExample(TableStatusExample example);

    List<TableStatus> selectByExample(TableStatusExample example);

    List<Map> selectTotal();

    List<Map> selectSuccessNoDiff();

    List<Map> selectErrorTask();

    List<Map> selectSuccessHasDiff();

}