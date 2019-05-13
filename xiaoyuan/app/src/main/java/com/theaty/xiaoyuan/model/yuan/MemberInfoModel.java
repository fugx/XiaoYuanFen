package com.theaty.xiaoyuan.model.yuan;

import java.util.ArrayList;

/**
 * Created by fu on 2019/5/11.
 * 用户表
 */

public class MemberInfoModel {

    /**
     * id : 用户ID
     * name : 用户名
     * nick : 昵称
     * level : 用户等级(0:无等级，1......9)
     * password : 密码
     * team : 归属团队memberInfo
     * good : 赞赏量
     * type : 类型
     * age : 年龄
     * gender : 性别
     * job : 从事行业
     * birthday : 生日
     * intersted : 兴趣爱好
     * detail : 自我简介
     * sign : [标签1...]
     * albumModel : [相册1...]
     * act : [发起的活动1...]
     * join : [参加的活动1...]
     * collect : [收藏的活动1...]
     * focus : [我的关注1...]
     * questions : [问题1...]
     * funs : [粉丝1...]
     * love : [我喜欢的1...]
     * enabled : 是否有效
     * matching : 用户是否参与互动匹配
     * key : 用户每次登录随机生成的值
     */

    private int id;
    private String name;
    private String nick;
    private int level;
    private String password;
    private MemberInfoModel team;
    private int good;
    private String type;
    private int age;
    private String gender;
    private String job;
    private int birthday;
    private String intersted;
    private String detail;
    private ArrayList<SignModel> sign;
    private ArrayList<AlbumModel> albumModel;
    private ArrayList<ActivityInfoModel> act = new ArrayList<>();
    private ArrayList<ActivityInfoModel> join = new ArrayList<>();
    private ArrayList<ActivityInfoModel> collect = new ArrayList<>();
    private ArrayList<MemberInfoModel> focus = new ArrayList<>();
    private ArrayList<QuestionModel> questions = new ArrayList<>();
    private ArrayList<MemberInfoModel> funs = new ArrayList<>();
    private ArrayList<MemberInfoModel> love = new ArrayList<>();
    private boolean enabled = true;
    private boolean matching = false;
    private String key;

    public MemberInfoModel(int id, String name, String nick, String password, String detail, String enabled, String matching) {
        this.id = id;
        this.name = name;
        this.nick = nick;
        this.level = 0;
        this.password = password;
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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MemberInfoModel getTeam() {
        return team;
    }

    public void setTeam(MemberInfoModel team) {
        this.team = team;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public String getIntersted() {
        return intersted;
    }

    public void setIntersted(String intersted) {
        this.intersted = intersted;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public ArrayList<SignModel> getSign() {
        return sign;
    }

    public void setSign(ArrayList<SignModel> sign) {
        this.sign = sign;
    }

    public ArrayList<AlbumModel> getAlbumModel() {
        return albumModel;
    }

    public void setAlbumModel(ArrayList<AlbumModel> albumModel) {
        this.albumModel = albumModel;
    }

    public ArrayList<ActivityInfoModel> getAct() {
        return act;
    }

    public void setAct(ArrayList<ActivityInfoModel> act) {
        this.act = act;
    }

    public ArrayList<ActivityInfoModel> getJoin() {
        return join;
    }

    public void setJoin(ArrayList<ActivityInfoModel> join) {
        this.join = join;
    }

    public ArrayList<ActivityInfoModel> getCollect() {
        return collect;
    }

    public void setCollect(ArrayList<ActivityInfoModel> collect) {
        this.collect = collect;
    }

    public ArrayList<MemberInfoModel> getFocus() {
        return focus;
    }

    public void setFocus(ArrayList<MemberInfoModel> focus) {
        this.focus = focus;
    }

    public ArrayList<QuestionModel> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<QuestionModel> questions) {
        this.questions = questions;
    }

    public ArrayList<MemberInfoModel> getFuns() {
        return funs;
    }

    public void setFuns(ArrayList<MemberInfoModel> funs) {
        this.funs = funs;
    }

    public ArrayList<MemberInfoModel> getLove() {
        return love;
    }

    public void setLove(ArrayList<MemberInfoModel> love) {
        this.love = love;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isMatching() {
        return matching;
    }

    public void setMatching(boolean matching) {
        this.matching = matching;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
