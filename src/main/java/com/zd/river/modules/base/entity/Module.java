package com.zd.river.modules.base.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zd.river.base.RiverBaseEntity;
import com.zd.river.common.constant.CommonConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Exrick
 */
@Data
@Entity
@Table(name = "t_module")
@TableName("t_module")
public class Module extends RiverBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "模块名称")
    private String name;

    @ApiModelProperty(value = "类型 0页面 1具体操作")
    private Integer type;

    @ApiModelProperty(value = "模块标题")
    private String title;

    @ApiModelProperty(value = "页面路径/资源链接url")
    @Column(nullable = false)
    private String path;

    @ApiModelProperty(value = "前端组件")
    private String component;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "说明备注")
    private String description;

    @ApiModelProperty(value = "排序值")
    @Column(precision = 10, scale = 2)
    private BigDecimal sortOrder;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status = CommonConstant.STATUS_NORMAL;

    @ApiModelProperty(value = "网页链接")
    private String url;


}