package io.snowishyl.lanttery.infrastructure.po;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户参与活动记录表(UserTakeActivity)表实体类
 *
 * @author makejava
 * @since 2023-10-14 13:03:34
 */
@SuppressWarnings("serial")
@Entity(name = "user_take_activity")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserTakeActivity implements Serializable {
    //自增ID@TableId(type = IdType.AUTO)
    @Id
    private Long id;
    //用户ID
    private String uid;
    //活动领取ID
    private Long takeid;
    //活动ID
    private Long activityid;
    //活动名称
    private String activityname;
    //活动领取时间
    private Date takedate;
    //领取次数
    private Integer takecount;
    //抽奖策略ID
    private Integer strategyid;
    //活动单使用状态 0未使用、1已使用
    private Integer state;
    //防重ID
    private String uuid;
    //创建时间
    private Date createtime;
    //更新时间
    private Date updatetime;



}

