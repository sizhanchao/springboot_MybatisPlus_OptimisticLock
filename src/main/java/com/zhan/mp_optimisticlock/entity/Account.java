package com.zhan.mp_optimisticlock.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;

import java.math.BigDecimal;

/**
 * @author zhan
 * @since 2019-11-12 11:07
 */
public class Account {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private BigDecimal deposit;
    @Version
    private Integer version;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", deposit=" + deposit +
                ", version=" + version +
                '}';
    }
}
