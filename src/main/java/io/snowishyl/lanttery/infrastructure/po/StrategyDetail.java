package io.snowishyl.lanttery.infrastructure.po;

import java.util.Date;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 策略明细(StrategyDetail)表实体类
 *
 * @author makejava
 * @since 2023-10-14 12:52:33
 */
@SuppressWarnings("serial")
@Entity(name = "strategy_detail")
public class StrategyDetail implements Serializable {
    //自增ID@TableId(type = IdType.AUTO)
    @Id
    private Long id;
    //策略ID
    private Long strategyid;
    //奖品ID
    private String awardid;
    //奖品描述
    private String awardname;
    //奖品库存
    private Integer awardcount;
    //奖品剩余库存
    private Integer awardsurpluscount;
    //中奖概率
    private Double awardrate;
    //创建时间
    private Date createtime;
    //修改时间
    private Date updatetime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStrategyid() {
        return strategyid;
    }

    public void setStrategyid(Long strategyid) {
        this.strategyid = strategyid;
    }

    public String getAwardid() {
        return awardid;
    }

    public void setAwardid(String awardid) {
        this.awardid = awardid;
    }

    public String getAwardname() {
        return awardname;
    }

    public void setAwardname(String awardname) {
        this.awardname = awardname;
    }

    public Integer getAwardcount() {
        return awardcount;
    }

    public void setAwardcount(Integer awardcount) {
        this.awardcount = awardcount;
    }

    public Integer getAwardsurpluscount() {
        return awardsurpluscount;
    }

    public void setAwardsurpluscount(Integer awardsurpluscount) {
        this.awardsurpluscount = awardsurpluscount;
    }

    public Double getAwardrate() {
        return awardrate;
    }

    public void setAwardrate(Double awardrate) {
        this.awardrate = awardrate;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}

