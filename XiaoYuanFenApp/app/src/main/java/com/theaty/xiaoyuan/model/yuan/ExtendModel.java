package com.theaty.xiaoyuan.model.yuan;

/**
 * Created by fu on 2019/9/1.
 *  用户信息拓展
 */

public class ExtendModel {

    /**
     * id : 表ID
     * member : 用户memberInfo
     * job : 从事行业
     * intersted : 兴趣爱好
     * love : 爱情观
     * hope : 对另一半的期许
     */

    private String id;
    private MemberInfoModel member;
    private String job;
    private String intersted;
    private String love;
    private String hope;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MemberInfoModel getMember() {
        return member;
    }

    public void setMember(MemberInfoModel member) {
        this.member = member;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIntersted() {
        return intersted;
    }

    public void setIntersted(String intersted) {
        this.intersted = intersted;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getHope() {
        return hope;
    }

    public void setHope(String hope) {
        this.hope = hope;
    }
}
