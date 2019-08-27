package com.theaty.xiaoyuan.model.yuan;

import java.util.ArrayList;

/**
 * Created by Yecal on 2019/5/13.
 *  问题表
 */

public class QuestionModel {

    /**
     * id : 消息ID
     * ques : 问题内容
     * time : 问题提出时间
     * ask : 问题提出人member
     * answer : 问题被提问人member
     * type : 类型
     * enabled : 是否有效
     * answers : [答案1...]
     */

    private int id;
    private String ques;
    private int time;
    private MemberInfoModel ask;
    private AnswerModel answer;
    private TypeModel type;
    private boolean enabled = true;
    private ArrayList<AnswerModel> answers = new ArrayList<>();

    public QuestionModel(int id, String ques, int time) {
        this.id = id;
        this.ques = ques;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
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

    public AnswerModel getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerModel answer) {
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

    public ArrayList<AnswerModel> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<AnswerModel> answers) {
        this.answers = answers;
    }
}
