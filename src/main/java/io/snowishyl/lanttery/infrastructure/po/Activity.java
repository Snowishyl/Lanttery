package io.snowishyl.lanttery.infrastructure.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 活动配置(Activity)表实体类
 *
 * @author makejava
 * @since 2023-10-14 12:52:33
 */
@SuppressWarnings("serial")
@Entity(name = "activity")
public class Activity implements Serializable {
    //自增ID
    @Id
    private Long id;

    //活动ID
    private Long activityid;
    //活动名称
    private String activityname;
    //活动描述
    private String activitydesc;
    //开始时间
    private Date begindatetime;
    //结束时间
    private Date enddatetime;
    //库存
    private Integer stockcount;
    //库存剩余
    private Integer stocksurpluscount;
    //每人可参与次数
    private Integer takecount;
    //抽奖策略ID
    private Long strategyid;
    //活动状态：1编辑、2提审、3撤审、4通过、5运行(审核通过后worker扫描状态)、6拒绝、7关闭、8开启
    private Integer state;
    //创建人
    private String creator;
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

    public Long getActivityid() {
        return activityid;
    }

    public void setActivityid(Long activityid) {
        this.activityid = activityid;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    public String getActivitydesc() {
        return activitydesc;
    }

    public void setActivitydesc(String activitydesc) {
        this.activitydesc = activitydesc;
    }

    public Date getBegindatetime() {
        return begindatetime;
    }

    public void setBegindatetime(Date begindatetime) {
        this.begindatetime = begindatetime;
    }

    public Date getEnddatetime() {
        return enddatetime;
    }

    public void setEnddatetime(Date enddatetime) {
        this.enddatetime = enddatetime;
    }

    public Integer getStockcount() {
        return stockcount;
    }

    public void setStockcount(Integer stockcount) {
        this.stockcount = stockcount;
    }

    public Integer getStocksurpluscount() {
        return stocksurpluscount;
    }

    public void setStocksurpluscount(Integer stocksurpluscount) {
        this.stocksurpluscount = stocksurpluscount;
    }

    public Integer getTakecount() {
        return takecount;
    }

    public void setTakecount(Integer takecount) {
        this.takecount = takecount;
    }

    public Long getStrategyid() {
        return strategyid;
    }

    public void setStrategyid(Long strategyid) {
        this.strategyid = strategyid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

