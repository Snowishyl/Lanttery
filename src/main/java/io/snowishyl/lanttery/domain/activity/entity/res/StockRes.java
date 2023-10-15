package io.snowishyl.lanttery.domain.activity.entity.res;

import io.snowishyl.lanttery.common.R;

/**
 * @program: quarkus-lanttery
 * @description: 库存扣减res
 * @author: YxYL
 * @create: 2023-10-14 19:24
 **/

public class StockRes extends R {

    private Integer stock;

    public StockRes(Integer stock) {
        this.stock = stock;
    }

    public StockRes(String code, String msg, Integer stock) {
        super(code, msg);
        this.stock = stock;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
