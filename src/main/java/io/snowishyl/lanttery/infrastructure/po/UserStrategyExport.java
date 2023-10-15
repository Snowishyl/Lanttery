package io.snowishyl.lanttery.infrastructure.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户策略计算结果表(UserStrategyExport)表实体类
 *
 * @author makejava
 * @since 2023-10-14 13:03:34
 */
@SuppressWarnings("serial")
@Entity(name = "User_strategy_export")
public class UserStrategyExport implements Serializable {
    //自增ID@TableId(type = IdType.AUTO)
    @Id
    private Long id;
    //用户ID
    private String uid;
    //活动ID
    private Long activityid;
    //订单ID
    private Long orderid;
    //策略ID
    private Long strategyid;
    //策略方式（1:单项概率、2:总体概率）
    private Integer strategymode;
    //发放奖品方式（1:即时、2:定时[含活动结束]、3:人工）
    private Integer granttype;
    //发奖时间
    private Date grantdate;
    //发奖状态
    private Integer grantstate;
    //发奖ID
    private String awardid;
    //奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
    private Integer awardtype;
    //奖品名称
    private String awardname;
    //奖品内容「文字描述、Key、码」
    private String awardcontent;
    //防重ID
    private String uuid;
    //消息发送状态（0未发送、1发送成功、2发送失败）
    private Integer mqstate;
    //创建时间
    private Date createtime;
    //更新时间
    private Date updatetime;



}

