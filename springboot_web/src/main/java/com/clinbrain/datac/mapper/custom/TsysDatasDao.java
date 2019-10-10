package com.clinbrain.datac.mapper.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clinbrain.datac.model.auto.TsysDatas;

public interface TsysDatasDao {
	
	public List<TsysDatas> selectByPrimaryKeys(@Param("ids") List<String> ids);
	
}