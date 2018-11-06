package com.zd.river.modules.base.serviceimpl;

import com.zd.river.modules.base.dao.ModuleDao;
import com.zd.river.modules.base.entity.Module;
import com.zd.river.modules.base.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 模块接口实现
 * @author Exrick
 */
@Slf4j
@Service
@Transactional
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleDao moduleDao;

    @Override
    public ModuleDao getRepository() {
        return moduleDao;
    }
}