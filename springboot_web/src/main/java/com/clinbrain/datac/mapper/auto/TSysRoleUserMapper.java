package com.clinbrain.datac.mapper.auto;

import com.clinbrain.datac.model.auto.TSysRoleUser;
import com.clinbrain.datac.model.auto.TSysRoleUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSysRoleUserMapper {
    int countByExample(TSysRoleUserExample example);

    int deleteByExample(TSysRoleUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(TSysRoleUser record);

    int insertSelective(TSysRoleUser record);

    List<TSysRoleUser> selectByExample(TSysRoleUserExample example);

    TSysRoleUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TSysRoleUser record, @Param("example") TSysRoleUserExample example);

    int updateByExample(@Param("record") TSysRoleUser record, @Param("example") TSysRoleUserExample example);

    int updateByPrimaryKeySelective(TSysRoleUser record);

    int updateByPrimaryKey(TSysRoleUser record);
}