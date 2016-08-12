package com.travel.bean;

public class User {
    private int id;
    private String name;
    private int level;
    private int grade;
    private String phone;
    private String email;
    private String avatar;
    private Long lastVisit;
    private String lastIp;
    private String deviceType;
    private long createTime;
    private long updateTime;
    private String openId;
    private String sex;
    private String city;
    private String country;
    private String province;
    private Long subTime;
    private String subscribe;

    public String  getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Long getSubTime() {
        return subTime;
    }

    public void setSubTime(Long subTime) {
        this.subTime = subTime;
    }

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    public User(int id, String name, int level, int grade, String phone, String email, String avatar, Long lastVisit, String lastIp, String deviceType, long createTime, long updateTime) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.grade = grade;
        this.phone = phone;
        this.email = email;
        this.avatar = avatar;
        this.lastVisit = lastVisit;
        this.lastIp = lastIp;
        this.deviceType = deviceType;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Long lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", level=" + level + ", grade=" + grade + ", phone=" + phone
                + ", email=" + email + ", avatar=" + avatar + ", lastVisit=" + lastVisit + ", lastIp=" + lastIp
                + ", deviceType=" + deviceType + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
    }

}
