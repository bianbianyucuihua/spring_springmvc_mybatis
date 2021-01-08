package com.hongyi.pojo;

import java.util.*;

public class User {
    private Integer id;
    private String name;
    private Double money;
    private Double score;
    private Date birthday;
    private List list;
    private Set set;
    private Map<String,Object> map;
    private Properties p;

    public User(){}
    public User(Integer id, String name, Double money,Double score, Date birthday) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.birthday = birthday;
        this.score=score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Properties getP() {
        return p;
    }

    public void setP(Properties p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", score=" + score +
                ", birthday=" + birthday +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", p=" + p +
                '}';
    }
}
