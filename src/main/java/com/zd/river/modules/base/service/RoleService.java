package com.zd.river.modules.base.service;


import com.zd.river.base.RiverBaseService;
import com.zd.river.modules.base.entity.Role;

import java.util.List;

/**
 * 角色接口
 * @author Exrickx
 */
public interface RoleService extends RiverBaseService<Role,String> {

    /**
     * 获取默认角色
     * @param defaultRole
     * @return
     */
    List<Role> findByDefaultRole(Boolean defaultRole);
}
