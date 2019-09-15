package com.theaty.xiaoyuan.model.yuan;

/**
 * Created by Yecal on 2019/5/13.
 *  消息表
 */

public class MessageModel {

    /**
     * id : 消息ID
     * name : 消息标题
     * time : 消息发送时间
     * ask : 消息发送人member
     * answer : 消息被通知人member
     * type : 类型
     * enabled : 是否已读
     */

    private int id;
    private String title;
    private String content;
    private int time;
    private MemberInfoModel ask;
    private MemberInfoModel answer;
    private TypeModel type;
    private boolean enabled = true;

    public MessageModel(int id, String name, int time) {
        this.id = id;
        this.title = name;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public MemberInfoModel getAsk() {
        return ask;
    }

    public void setAsk(MemberInfoModel ask) {
        this.ask = ask;
    }

    public MemberInfoModel getAnswer() {
        return answer;
    }

    public void setAnswer(MemberInfoModel answer) {
        this.answer = answer;
    }

    public TypeModel getType() {
        return type;
    }

    public void setType(TypeModel type) {
        this.type = type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
