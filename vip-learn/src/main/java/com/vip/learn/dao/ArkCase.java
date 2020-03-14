package com.vip.learn.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 专案详情
 * </p>
 *
 * @author Mars
 * @since 2019-12-27
 */
@Data
@Accessors(chain = true)
@TableName("ark_case")
public class ArkCase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 租户-code，关联ark_tetant
     */
    private Integer tenantCode;

    /**
     * 业务中心 10-成都中心
     */
    private Integer businessCenter;

    /**
     * 专案名
     */
    private String caseName;

    /**
     * 专案编号
     */
    private String caseNumber;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 包含商机来源，多个以逗号隔开
     */
    private String oppotunitySource;

    /**
     * 专案状态 1-未开始 2-进行中 3-已结束
     */
    private Integer status;

    /**
     * 专案类型:
     */
    private Integer typeId;

    /**
     * 项目
     */
    private Integer itemId;

    /**
     * 绑定号码
     */
    private Integer bindNumber;

    /**
     * 折算系数
     */
    private Integer conversionCoefficient;

    /**
     * 冷冻周期
     */
    private Integer freezeDays;

    /**
     * 奖励系数
     */
    private Integer rewardCoefficient;

    /**
     * 专案简介
     */
    private String remark;

    /**
     * 软删除
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}
