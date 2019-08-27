package com.theaty.xiaoyuan.model.xiaoyuan;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.theaty.xiaoyuan.dao.DaoSession;
import com.theaty.xiaoyuan.dao.MemberDao;
import com.theaty.xiaoyuan.dao.CommentsDao;

/**
 * Created by Yecal on 2018/12/22.
 * 活动类别
 * ID、评论标题、是否有效、评论内容、所属用户、
 */
@Entity
public class Comments {
    /**
     * ID ,
     */
    @Id
    private Long commentsId;
    /**
     * 评论标题 ,
     */
    private String title;
    /**
     * 评论内容 ,
     */
    private String content;
    /**
     * 是否有效 0：否，1：是,
     */
    private int enabled = 0;
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
    @Generated(hash = 2111172442)
    private transient CommentsDao myDao;
    @Generated(hash = 1195349011)
    public Comments(Long commentsId, String title, String content, int enabled,
            Long memberId) {
        this.commentsId = commentsId;
        this.title = title;
        this.content = content;
        this.enabled = enabled;
        this.memberId = memberId;
    }
    @Generated(hash = 1094291921)
    public Comments() {
    }
    public Long getCommentsId() {
        return this.commentsId;
    }
    public void setCommentsId(Long commentsId) {
        this.commentsId = commentsId;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
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
    @Generated(hash = 1072831068)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCommentsDao() : null;
    }
}
