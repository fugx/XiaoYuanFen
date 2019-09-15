package com.theaty.xiaoyuan.model.yuan;

import java.util.ArrayList;

/**
 * Created by Yecal on 2019/5/13.
 *  活动表
 */

public class ActInfoModel {

    /**
     * id : 活动ID
     * name : 活动标题
     * detail : 活动简介
     * area : 活动费用
     * money : 活动地点
     * good : 赞赏量评分
     * url : 活动原文链接
     * photo : 活动宣传图
     * time : 活动时间
     * start : 活动开始时间
     * end : 活动结束时间
     * member : 活动发起者
     * members : [参与用户1...]
     * max : 人数上限
     * sign : [标签1...]
     * albumModel : 相册
     * comments : [评论1...]
     * enabled : 活动是否有效
     * recommend : 活动是否推荐
     */

    private int id;
    private String name;
    private String detail;
    private String area;
    private double money = 0.0;
    private double good;
    private String url;
    private String photo;
    private int time;
    private int start;
    private int end;
    private MessageModel leader;
    private ArrayList<MemberInfoModel> members = new ArrayList<>();
    private int max;
    private ArrayList<SignModel> sign = new ArrayList<>();
    private ArrayList<CommentModel> comments = new ArrayList<>();
    private AlbumModel albumModel;
    private boolean enabled = true;
    private boolean recommend = false;

    public ActInfoModel(int id, String name, String detail) {
        this.id = id;
        this.name = name;
        this.detail = detail;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getGood() {
        return good;
    }

    public void setGood(double good) {
        this.good = good;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public MessageModel getLeader() {
        return leader;
    }

    public void setLeader(MessageModel leader) {
        this.leader = leader;
    }

    public ArrayList<MemberInfoModel> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<MemberInfoModel> members) {
        this.members = members;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public ArrayList<SignModel> getSign() {
        return sign;
    }

    public void setSign(ArrayList<SignModel> sign) {
        this.sign = sign;
    }

    public AlbumModel getAlbumModel() {
        return albumModel;
    }

    public void setAlbumModel(AlbumModel albumModel) {
        this.albumModel = albumModel;
    }

    public ArrayList<CommentModel> getComments() {
        return comments;
    }

    public void setComments(ArrayList<CommentModel> comments) {
        this.comments = comments;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }
}
