package com.huize.polaris.colletion.aspect;


import lombok.Data;

@Data
public class PolarisLogMethod {

    /**
     * 平台标识 1:紫微星 2:慧慧 3:移动工作台
     */
    private Integer platform;

    /**
     * 终端类型 1:PC 2:H5
     */
    private Integer clientType;

    /**
     * 报点，即那个方法上报的
     */
    private String reportPoint;

    /**
     * 方法备注
     */
    private String mark;
}
