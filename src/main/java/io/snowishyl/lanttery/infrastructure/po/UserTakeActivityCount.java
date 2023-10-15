package io.snowishyl.lanttery.infrastructure.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户活动参与次数表(UserTakeActivityCount)表实体类
 *
 * @author makejava
 * @since 2023-10-14 13:03:34
 */
@SuppressWarnings("serial")
@Entity(name = "user_take_activity_count")
public class UserTakeActivityCount implements Serializable {
    //自增ID@TableId(type = IdType.AUTO)
    @Id
    private Long id;
    //用户ID
    private String uid;
    //活动ID
    private Long activityid;
    //可领取次数
    private Integer totalcount;
    //已领取次数
    private Integer leftcount;
    //创建时间
    private Date createtime;
    //更新时间
    private Date updatetime;



}

