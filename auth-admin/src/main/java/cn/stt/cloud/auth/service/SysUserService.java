package cn.stt.cloud.auth.service;


import cn.stt.cloud.auth.entity.SysUser;
import cn.stt.cloud.auth.entity.SysUserRole;

import java.util.List;
import java.util.Set;

/**
 * 用户管理
 */
public interface SysUserService extends CurdService<SysUser> {

	SysUser findByName(String username);

	/**
	 * 查找用户的菜单权限标识集合
	 * @param userName
	 * @return
	 */
	Set<String> findPermissions(String userName);

	/**
	 * 查找用户的角色集合
	 * @param userName
	 * @return
	 */
	List<SysUserRole> findUserRoles(Long userId);

}
