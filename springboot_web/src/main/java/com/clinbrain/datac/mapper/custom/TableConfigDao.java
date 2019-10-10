package com.clinbrain.datac.mapper.custom;

import com.clinbrain.datac.model.auto.TableConfig;

import java.util.List;

/**
 * Created by Liaopan on 2019/7/4.
 */
public interface TableConfigDao {

  public List<TableConfig> selectAll();
}
