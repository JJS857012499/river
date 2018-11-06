package com.zd.river.modules.base.controller.manage;

import com.zd.river.base.RiverBaseController;
import com.zd.river.modules.base.entity.Module;
import com.zd.river.modules.base.service.ModuleService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Exrick
 */
@Slf4j
@RestController
@Api(description = "模块管理接口")
@RequestMapping("/river/module")
@Transactional
public class ModuleController extends RiverBaseController<Module, String>{

    @Autowired
    private ModuleService moduleService;

    @Override
    public ModuleService getService() {
        return moduleService;
    }

}
