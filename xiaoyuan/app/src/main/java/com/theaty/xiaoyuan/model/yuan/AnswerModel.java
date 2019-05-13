package com.theaty.xiaoyuan.model.yuan;

/**
 * Created by Yecal on 2019/5/13.
 *  回答表
 */

public class AnswerModel {

    /**
     * id : 回答ID
     * name : 回答内容
     * time : 回答时间
     * question : 所属问题
     * type : 类型
     * enabled : 是否有效
     */

    private int id;
    private String name;
    private int time;
    private QuestionModel question;
    private TypeModel type;
    private boolean enabled = true;

    public AnswerModel(int id, String name, int time) {
        this.id = id;
        this.name = name;
        this.time = time;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public QuestionModel getQuestion() {
        return question;
    }

    public void setQuestion(QuestionModel question) {
        this.question = question;
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
