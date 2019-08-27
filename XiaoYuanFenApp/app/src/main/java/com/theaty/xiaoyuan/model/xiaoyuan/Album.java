package com.theaty.xiaoyuan.model.xiaoyuan;

import com.theaty.xiaoyuan.model.utils.StringConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.theaty.xiaoyuan.dao.DaoSession;
import com.theaty.xiaoyuan.dao.MemberDao;
import com.theaty.xiaoyuan.dao.AlbumDao;

/**
 * Created by Yecal on 2018/12/22.
 * 相册
 * ID、相册名、是否有效、<照片>、所属用户
 */
@Entity
public class Album {
    /**
     * ID ,
     */
    @Id
    private Long albumId;
    /**
     * 相册名 ,
     */
    private String name;
    /**
     * 是否有效 0：否，1：是,
     */
    private int enabled = 1;
    /**
     * 照片 ,
     */
    @Convert(columnType = String.class, converter = StringConverter.class)
    private List<String> photos;
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
    @Generated(hash = 172302968)
    private transient AlbumDao myDao;
    @Generated(hash = 125735420)
    public Album(Long albumId, String name, int enabled, List<String> photos,
            Long memberId) {
        this.albumId = albumId;
        this.name = name;
        this.enabled = enabled;
        this.photos = photos;
        this.memberId = memberId;
    }
    @Generated(hash = 1609191978)
    public Album() {
    }
    public Long getAlbumId() {
        return this.albumId;
    }
    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
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
    public List<String> getPhotos() {
        return this.photos;
    }
    public void setPhotos(List<String> photos) {
        this.photos = photos;
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
    @Generated(hash = 1023911229)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getAlbumDao() : null;
    }
}
