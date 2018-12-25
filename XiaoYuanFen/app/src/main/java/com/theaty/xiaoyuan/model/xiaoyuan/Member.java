package com.theaty.xiaoyuan.model.xiaoyuan;

import com.theaty.xiaoyuan.model.utils.StringConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.theaty.xiaoyuan.dao.DaoSession;
import com.theaty.xiaoyuan.dao.MessageDao;
import com.theaty.xiaoyuan.dao.AlbumDao;
import com.theaty.xiaoyuan.dao.MemberDao;
import com.theaty.xiaoyuan.dao.PlayDao;
import com.theaty.xiaoyuan.dao.SignDao;

/**
 * Created by Yecal on 2018/12/22.
 * 用户/会员基本信息
 * ID、用户名(昵称)、用户密码、用户头像、姓名、性别、生日、所在地、电话、QQ、微信、
 * <生活照片>、<标签>、<发布的活动>、<收藏的活动>、<参加过的活动>、<我关注的用户>、<关注我的用户>、<相册>、<消息>、设置、/////是否会员、
 */
@Entity
public class Member {
    /**
     * 用户id' ,
     */
    @Id
    private Long memberId;
    /**
     * 用户名（昵称） ,
     */
    private String nick;
    /**
     * 用户密码 ,
     */
    public String password;
    /**
     * 用户头像' ,
     */
    public String head;
    /**
     * 用户姓名 ,
     */
    private String name;
    /**
     * 用户性别 ,
     */
    private String gender;
    /**
     * 用户生日 ,
     */
    private Long age;
    /**
     * 用户所在地 ,
     */
    private String area;
    /**
     * 用户电话 ,
     */
    private String phone;
    /**
     * 用户QQ ,
     */
    private String QQ;
    /**
     * 用户微信 ,
     */
    private String wechat;
    /**
     * 生活照片 ,
     */
    @Convert(columnType = String.class, converter = StringConverter.class)
    private List<String> photoes = new ArrayList<>();
    /**
     * 标签 ,
     */
    @ToMany(referencedJoinProperty = "signId")
    private List<Sign> signs;
    /**
     * 发布的活动 ,
     */
    @ToMany(referencedJoinProperty = "playId")
    private List<Play> publishPlays;
    /**
     * 收藏的活动 ,
     */
    @ToMany(referencedJoinProperty = "playId")
    private List<Play> collectPlays;
    /**
     * 参加过的活动 ,
     */
    @ToMany(referencedJoinProperty = "playId")
    private List<Play> joinPlays;
    /**
     * 我关注的用户 ,
     */
    @ToMany(referencedJoinProperty = "memberId")
    private List<Member> focus;
    /**
     * 关注我的用户 ,
     */
    @ToMany(referencedJoinProperty = "memberId")
    private List<Member> funs;
    /**
     * 相册 ,
     */
    @ToMany(referencedJoinProperty = "albumId")
    private List<Album> albums;
    /**
     * 消息 ,
     */
    @ToMany(referencedJoinProperty = "messageId")
    private List<Message> messages;
    /**
     * 设置 ,
     */
//    private Setting setting;
    /**
     * 是否会员 0：否，1：是,
     */
    private int vip = 0;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1200613910)
    private transient MemberDao myDao;
    @Generated(hash = 1762575099)
    public Member(Long memberId, String nick, String password, String head,
            String name, String gender, Long age, String area, String phone,
            String QQ, String wechat, List<String> photoes, int vip) {
        this.memberId = memberId;
        this.nick = nick;
        this.password = password;
        this.head = head;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.area = area;
        this.phone = phone;
        this.QQ = QQ;
        this.wechat = wechat;
        this.photoes = photoes;
        this.vip = vip;
    }
    @Generated(hash = 367284327)
    public Member() {
    }
    public Long getMemberId() {
        return this.memberId;
    }
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public String getNick() {
        return this.nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getHead() {
        return this.head;
    }
    public void setHead(String head) {
        this.head = head;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return this.gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Long getAge() {
        return this.age;
    }
    public void setAge(Long age) {
        this.age = age;
    }
    public String getArea() {
        return this.area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getQQ() {
        return this.QQ;
    }
    public void setQQ(String QQ) {
        this.QQ = QQ;
    }
    public String getWechat() {
        return this.wechat;
    }
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
    public List<String> getPhotoes() {
        return this.photoes;
    }
    public void setPhotoes(List<String> photoes) {
        this.photoes = photoes;
    }
    public int getVip() {
        return this.vip;
    }
    public void setVip(int vip) {
        this.vip = vip;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1705938069)
    public List<Sign> getSigns() {
        if (signs == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SignDao targetDao = daoSession.getSignDao();
            List<Sign> signsNew = targetDao._queryMember_Signs(memberId);
            synchronized (this) {
                if (signs == null) {
                    signs = signsNew;
                }
            }
        }
        return signs;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 324125799)
    public synchronized void resetSigns() {
        signs = null;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 792952635)
    public List<Play> getPublishPlays() {
        if (publishPlays == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PlayDao targetDao = daoSession.getPlayDao();
            List<Play> publishPlaysNew = targetDao
                    ._queryMember_PublishPlays(memberId);
            synchronized (this) {
                if (publishPlays == null) {
                    publishPlays = publishPlaysNew;
                }
            }
        }
        return publishPlays;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1556075597)
    public synchronized void resetPublishPlays() {
        publishPlays = null;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1616775517)
    public List<Play> getCollectPlays() {
        if (collectPlays == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PlayDao targetDao = daoSession.getPlayDao();
            List<Play> collectPlaysNew = targetDao
                    ._queryMember_CollectPlays(memberId);
            synchronized (this) {
                if (collectPlays == null) {
                    collectPlays = collectPlaysNew;
                }
            }
        }
        return collectPlays;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1765761425)
    public synchronized void resetCollectPlays() {
        collectPlays = null;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 730027042)
    public List<Play> getJoinPlays() {
        if (joinPlays == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PlayDao targetDao = daoSession.getPlayDao();
            List<Play> joinPlaysNew = targetDao._queryMember_JoinPlays(memberId);
            synchronized (this) {
                if (joinPlays == null) {
                    joinPlays = joinPlaysNew;
                }
            }
        }
        return joinPlays;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 754577062)
    public synchronized void resetJoinPlays() {
        joinPlays = null;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1388805174)
    public List<Member> getFocus() {
        if (focus == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MemberDao targetDao = daoSession.getMemberDao();
            List<Member> focusNew = targetDao._queryMember_Focus(memberId);
            synchronized (this) {
                if (focus == null) {
                    focus = focusNew;
                }
            }
        }
        return focus;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1042390454)
    public synchronized void resetFocus() {
        focus = null;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1621924844)
    public List<Member> getFuns() {
        if (funs == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MemberDao targetDao = daoSession.getMemberDao();
            List<Member> funsNew = targetDao._queryMember_Funs(memberId);
            synchronized (this) {
                if (funs == null) {
                    funs = funsNew;
                }
            }
        }
        return funs;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 527404480)
    public synchronized void resetFuns() {
        funs = null;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 685190815)
    public List<Album> getAlbums() {
        if (albums == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AlbumDao targetDao = daoSession.getAlbumDao();
            List<Album> albumsNew = targetDao._queryMember_Albums(memberId);
            synchronized (this) {
                if (albums == null) {
                    albums = albumsNew;
                }
            }
        }
        return albums;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 320857755)
    public synchronized void resetAlbums() {
        albums = null;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1540963386)
    public List<Message> getMessages() {
        if (messages == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MessageDao targetDao = daoSession.getMessageDao();
            List<Message> messagesNew = targetDao._queryMember_Messages(memberId);
            synchronized (this) {
                if (messages == null) {
                    messages = messagesNew;
                }
            }
        }
        return messages;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1942469556)
    public synchronized void resetMessages() {
        messages = null;
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
    @Generated(hash = 1742104579)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMemberDao() : null;
    }

}
