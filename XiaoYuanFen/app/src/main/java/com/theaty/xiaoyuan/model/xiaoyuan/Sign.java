package com.theaty.xiaoyuan.model.xiaoyuan;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Yecal on 2018/12/22.
 * 标签
 * ID、标签名、是否有效、是否用户自定义
 */
@Entity
public class Sign {
    /**
     * ID ,
     */
    @Id
    private Long signId;
    /**
     * 标签名 ,
     */
    private String name;
    /**
     * 是否有效 0：否，1：是,
     */
    private int enabled = 1;
    /**
     * 是否用户自定义 ,
     */
    private int custom = 0;
    @Generated(hash = 1451784665)
    public Sign(Long signId, String name, int enabled, int custom) {
        this.signId = signId;
        this.name = name;
        this.enabled = enabled;
        this.custom = custom;
    }
    @Generated(hash = 2025164192)
    public Sign() {
    }
    public Long getSignId() {
        return this.signId;
    }
    public void setSignId(Long signId) {
        this.signId = signId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEnabled() {
        return this.enabled;
    }
    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    public int getCustom() {
        return this.custom;
    }
    public void setCustom(int custom) {
        this.custom = custom;
    }
}
