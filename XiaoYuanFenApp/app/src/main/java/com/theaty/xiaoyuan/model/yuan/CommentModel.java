package com.theaty.xiaoyuan.model.yuan;

/**
 * Created by fu on 2019/9/1.
 *  评论表
 */

public class CommentModel {

    /**
     * id : 评论ID
     * content : 评论内容
     * member : 评论人
     * time : 评论时间
     * act : 所属问题
     * comment : 上级评论
     * type : 类型
     * enable : 是否有效
     */

    private int id;
    private String content;
    private MemberInfoModel member;
    private int time;
    private ActInfoModel act;
    private CommentModel comment;
    private TypeModel type;
    private boolean enable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MemberInfoModel getMember() {
        return member;
    }

    public void setMember(MemberInfoModel member) {
        this.member = member;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public ActInfoModel getAct() {
        return act;
    }

    public void setAct(ActInfoModel act) {
        this.act = act;
    }

    public CommentModel getComment() {
        return comment;
    }

    public void setComment(CommentModel comment) {
        this.comment = comment;
    }

    public TypeModel getType() {
        return type;
    }

    public void setType(TypeModel type) {
        this.type = type;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
