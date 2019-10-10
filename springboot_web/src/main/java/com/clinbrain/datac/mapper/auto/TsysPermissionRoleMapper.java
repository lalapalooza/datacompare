package com.clinbrain.datac.mapper.auto;

import com.clinbrain.datac.model.auto.TsysPermissionRole;
import com.clinbrain.datac.model.auto.TsysPermissionRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TsysPermissionRoleMapper {
    int countByExample(TsysPermissionRoleExample example);

    int deleteByExample(TsysPermissionRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(TsysPermissionRole record);

    int insertSelective(TsysPermissionRole record);

    List<TsysPermissionRole> selectByExample(TsysPermissionRoleExample example);

    TsysPermissionRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TsysPermissionRole record, @Param("example") TsysPermissionRoleExample example);

    int updateByExample(@Param("record") TsysPermissionRole record, @Param("example") TsysPermissionRoleExample example);

    int updateByPrimaryKeySelective(TsysPermissionRole record);

    int updateByPrimaryKey(TsysPermissionRole record);
}