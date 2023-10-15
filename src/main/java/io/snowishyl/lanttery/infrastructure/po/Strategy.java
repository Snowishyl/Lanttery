package io.snowishyl.lanttery.infrastructure.po;
import java.util.Date;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 策略配置(Strategy)表实体类
 *
 * @author makejava
 * @since 2023-10-14 12:52:33
 */
@SuppressWarnings("serial")@Entity

public class Strategy implements Serializable {
    //自增ID@TableId(type = IdType.AUTO)
    @Id
    private Long id;
    //策略ID
    private Long strategyid;
    //策略描述
    private String strategydesc;
    //策略方式（1:单项概率、2:总体概率）
    private Integer strategymode;
    //发放奖品方式（1:即时、2:定时[含活动结束]、3:人工）
    private Integer granttype;
    //发放奖品时间
    private Date grantdate;
    //扩展信息
    private String extinfo;
    //创建时间
    private Date createtime;
    //修改时间
    private Date updatetime;



}

