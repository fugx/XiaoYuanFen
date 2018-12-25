package com.theaty.xiaoyuan.model.xiaoyuan;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.theaty.xiaoyuan.dao.DaoSession;
import com.theaty.xiaoyuan.dao.MemberDao;
import com.theaty.xiaoyuan.dao.PlayDao;
import com.theaty.xiaoyuan.dao.TypeDao;

/**
 * Created by Yecal on 2018/12/22.
 * 活动类别
 * ID、类别名、标题、是否有效、<子类别>、<活动>、<用户>、父类别
 */
@Entity
public class Type {
    /**
     * ID ,
     */
    @Id
    private Long typeId;
    /**
     * 类别名 ,
     */
    private String name;
    /**
     * 是否有效 0：否，1：是,
     */
    private int enabled = 1;
    /**
     * 子类别 ,
     */
    @ToMany(referencedJoinProperty = "typeId")
    private List<Type> child;
    /**
     * 活动 ,
     */
    @ToMany(referencedJoinProperty = "playId")
    private List<Play> playList;
    /**
     * 用户 ,
     */
    @ToMany(referencedJoinProperty = "memberId")
    private List<Member> memberList;
    /**
     * 父类别 ,
     */
    private Long fatherId;
    @ToOne(joinProperty = "fatherId")
    private Type father;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1125686680)
    private transient TypeDao myDao;
    @Generated(hash = 282645396)
    public Type(Long typeId, String name, int enabled, Long fatherId) {
        this.typeId = typeId;
        this.name = name;
        this.enabled = enabled;
        this.fatherId = fatherId;
    }
    @Generated(hash = 1782799822)
    public Type() {
    }
    public Long getTypeId() {
        return this.typeId;
    }
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
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
    public Long getFatherId() {
        return this.fatherId;
    }
    public void setFatherId(Long fatherId) {
        this.fatherId = fatherId;
    }
    @Generated(hash = 2100996716)
    private transient Long father__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 438099919)
    public Type getFather() {
        Long __key = this.fatherId;
        if (father__resolvedKey == null || !father__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TypeDao targetDao = daoSession.getTypeDao();
            Type fatherNew = targetDao.load(__key);
            synchronized (this) {
                father = fatherNew;
                father__resolvedKey = __key;
            }
        }
        return father;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 139142688)
    public void setFather(Type father) {
        synchronized (this) {
            this.father = father;
            fatherId = father == null ? null : father.getTypeId();
            father__resolvedKey = fatherId;
        }
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 83022543)
    public List<Type> getChild() {
        if (child == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TypeDao targetDao = daoSession.getTypeDao();
            List<Type> childNew = targetDao._queryType_Child(typeId);
            synchronized (this) {
                if (child == null) {
                    child = childNew;
                }
            }
        }
        return child;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1024800465)
    public synchronized void resetChild() {
        child = null;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1622188772)
    public List<Play> getPlayList() {
        if (playList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PlayDao targetDao = daoSession.getPlayDao();
            List<Play> playListNew = targetDao._queryType_PlayList(typeId);
            synchronized (this) {
                if (playList == null) {
                    playList = playListNew;
                }
            }
        }
        return playList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 640270382)
    public synchronized void resetPlayList() {
        playList = null;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 740775911)
    public List<Member> getMemberList() {
        if (memberList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MemberDao targetDao = daoSession.getMemberDao();
            List<Member> memberListNew = targetDao._queryType_MemberList(typeId);
            synchronized (this) {
                if (memberList == null) {
                    memberList = memberListNew;
                }
            }
        }
        return memberList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1794216443)
    public synchronized void resetMemberList() {
        memberList = null;
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
    @Generated(hash = 627329482)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTypeDao() : null;
    }
}
