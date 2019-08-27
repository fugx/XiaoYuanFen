package com.theaty.xiaoyuan.model.xiaoyuan;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.theaty.xiaoyuan.dao.DaoSession;
import com.theaty.xiaoyuan.dao.MemberDao;
import com.theaty.xiaoyuan.dao.MessageDao;

/**
 * Created by Yecal on 2018/12/22.
 * 用户消息
 * ID、消息标题、是否有效、是否系统、消息内容、所属用户、
 */
@Entity
public class Message {
    /**
     * ID ,
     */
    @Id
    private Long messageId;
    /**
     * 消息标题 ,
     */
    private String name;
    /**
     * 消息内容 ,
     */
    private String content;
    /**
     * 是否有效 0：否，1：是,
     */
    private int enabled = 1;
    /**
     * 是否系统消息 0：否，1：是,
     */
    private int system = 1;
    /**
     * 所属用户 ,
     */
    private Long memberId;
    @ToOne(joinProperty = "memberId")
    private Member member;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 859287859)
    private transient MessageDao myDao;
    @Generated(hash = 1711019957)
    public Message(Long messageId, String name, String content, int enabled,
            int system, Long memberId) {
        this.messageId = messageId;
        this.name = name;
        this.content = content;
        this.enabled = enabled;
        this.system = system;
        this.memberId = memberId;
    }
    @Generated(hash = 637306882)
    public Message() {
    }
    public Long getMessageId() {
        return this.messageId;
    }
    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getEnabled() {
        return this.enabled;
    }
    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    public int getSystem() {
        return this.system;
    }
    public void setSystem(int system) {
        this.system = system;
    }
    public Long getMemberId() {
        return this.memberId;
    }
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    @Generated(hash = 336831450)
    private transient Long member__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1904522975)
    public Member getMember() {
        Long __key = this.memberId;
        if (member__resolvedKey == null || !member__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MemberDao targetDao = daoSession.getMemberDao();
            Member memberNew = targetDao.load(__key);
            synchronized (this) {
                member = memberNew;
                member__resolvedKey = __key;
            }
        }
        return member;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2024290921)
    public void setMember(Member member) {
        synchronized (this) {
            this.member = member;
            memberId = member == null ? null : member.getMemberId();
            member__resolvedKey = memberId;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 747015224)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMessageDao() : null;
    }
}
