package com.zd.river.modules.base.entity;

import com.zd.river.base.RiverBaseEntity;
import com.zd.river.common.constant.CommonConstant;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Exrickx
 */
@Data
@Entity
@Table(name = "t_quartz_job")
@TableName("t_quartz_job")
public class QuartzJob extends RiverBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "任务类名")
    private String jobClassName;

    @ApiModelProperty(value = "cron表达式")
    private String cronExpression;

    @ApiModelProperty(value = "参数")
    private String parameter;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "状态 0正常 -1停止")
    private Integer status = CommonConstant.STATUS_NORMAL;
}
