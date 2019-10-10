package com.clinbrain.datac.mapper.custom;

import com.clinbrain.datac.model.auto.TsysUser;

/**
 * @ClassName: TsysUserDao
 * @author fuce
 * @date 2018年8月25日
 *
 */
public interface TsysUserDao {
	/**
	 * 根据用户名字查询用户
	 * @param username
	 * @return
	 */
	public TsysUser queryUserName(String username);
}
