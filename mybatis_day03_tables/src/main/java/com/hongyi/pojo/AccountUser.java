package com.hongyi.pojo;

public class AccountUser extends User{
    private Integer aid;
    private Double money;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return super.toString()+"AccountUser{" +
                "aid=" + aid +
                ", money=" + money +
                '}';
    }
}
