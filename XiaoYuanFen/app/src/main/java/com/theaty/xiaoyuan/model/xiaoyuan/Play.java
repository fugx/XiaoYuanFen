package com.theaty.xiaoyuan.model.xiaoyuan;

import com.theaty.xiaoyuan.model.utils.StringConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.theaty.xiaoyuan.dao.DaoSession;
import com.theaty.xiaoyuan.dao.MemberDao;
import com.theaty.xiaoyuan.dao.CommentsDao;
import com.theaty.xiaoyuan.dao.SignDao;
import com.theaty.xiaoyuan.dao.TypeDao;
import com.theaty.xiaoyuan.dao.PlayDao;

/**
 * Created by Yecal on 2018/12/22.
 * 活动
 * ID、活动名、标题、时间、地点、是否有效、活动最大人数、活动费用、保险费、活动简介、封面图、链接url、
 * 注意事项、临时群、<标签>、<联系人>、<照片>、<评论>、<参加的用户>、发起用户、活动类别
 */
@Entity
public class Play {
    /**
     * ID ,
     */
    @Id
    private Long playId;
    /**
     * 活动名 ,
     */
    private String name;
    /**
     * 标题 ,
     */
    private String title;
    /**
     * 活动时间 ,
     */
    private Long time;
    /**
     * 地点 ,
     */
    private String area;
    /**
     * 是否有效 0：否，1：是,
     */
    private int enabled = 1;
    /**
     * 活动最大人数 ,
     */
    private int num = 0;
    /**
     * 活动费用 ,
     */
    private Double fee = 0.0;
    /**
     * 保险费 ,
     */
    private Double insurance = 0.0;
    /**
     * 活动简介 ,
     */
    private String introduction;
    /**
     * 封面图 ,
     */
    private String photo;
    /**
     * 链接url ,
     */
    private String url;
    /**
     * 注意事项 ,
     */
    private String note;
    /**
     * 临时群 ,
     */
    private String tempSession;
    /**
     * 标签 ,
     */
    @ToMany(referencedJoinProperty = "signId")
    private List<Sign> signs;
    /**
     * 联系人 ,
     */
    @ToMany(referencedJoinProperty = "memberId")
    private List<Member> connects;
    /**
     * 照片 ,
     */
    @Convert(columnType = String.class, converter = StringConverter.class)
    private List<String> photoes;
    /**
     * 评论 ,
     */
    @ToMany(referencedJoinProperty = "commentsId")
    private List<Comments> comments;
    /**
     * 参加的用户 ,
     */
    @ToMany(referencedJoinProperty = "memberId")
    private List<Member> memberList;
    /**
     * 发起用户 ,
     */
    private Long memberId;
    @ToOne(joinProperty = "memberId")
    private Member member;
    /**
     * 活动类别 ,
     */
    private Long typeId;
    @ToOne(joinProperty = "typeId")
    private Type type;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1885420305)
    private transient PlayDao myDao;
    @Generated(hash = 1521195037)
    public Play(Long playId, String name, String title, Long time, String area, int enabled, int num,
            Double fee, Double insurance, String introduction, String photo, String url, String note,
            String tempSession, List<String> photoes, Long memberId, Long typeId) {
        this.playId = playId;
        this.name = name;
        this.title = title;
        this.time = time;
        this.area = area;
        this.enabled = enabled;
        this.num = num;
        this.fee = fee;
        this.insurance = insurance;
        this.introduction = introduction;
        this.photo = photo;
        this.url = url;
        this.note = note;
        this.tempSession = tempSession;
        this.photoes = photoes;
        this.memberId = memberId;
        this.typeId = typeId;
    }
    @Generated(hash = 1596271462)
    public Play() {
    }
    public Long getPlayId() {
        return this.playId;
    }
    public void setPlayId(Long playId) {
        this.playId = playId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Long getTime() {
        return this.time;
    }
    public void setTime(Long time) {
        this.time = time;
    }
    public String getArea() {
        return this.area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public int getEnabled() {
        return this.enabled;
    }
    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    public int getNum() {
        return this.num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public Double getFee() {
        return this.fee;
    }
    public void setFee(Double fee) {
        this.fee = fee;
    }
    public Double getInsurance() {
        return this.insurance;
    }
    public void setInsurance(Double insurance) {
        this.insurance = insurance;
    }
    public String getIntroduction() {
        return this.introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getNote() {
        return this.note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getTempSession() {
        return this.tempSession;
    }
    public void setTempSession(String tempSession) {
        this.tempSession = tempSession;
    }
    public List<String> getPhotoes() {
        return this.photoes;
    }
    public void setPhotoes(List<String> photoes) {
        this.photoes = photoes;
    }
    public Long getMemberId() {
        return this.memberId;
    }
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public Long getTypeId() {
        return this.typeId;
    }
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
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
    @Generated(hash = 506996655)
    private transient Long type__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 344440077)
    public Type getType() {
        Long __key = this.typeId;
        if (type__resolvedKey == null || !type__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TypeDao targetDao = daoSession.getTypeDao();
            Type typeNew = targetDao.load(__key);
            synchronized (this) {
                type = typeNew;
                type__resolvedKey = __key;
            }
        }
        return type;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1951020613)
    public void setType(Type type) {
        synchronized (this) {
            this.type = type;
            typeId = type == null ? null : type.getTypeId();
            type__resolvedKey = typeId;
        }
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 2027670937)
    public List<Sign> getSigns() {
        if (signs == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SignDao targetDao = daoSession.getSignDao();
            List<Sign> signsNew = targetDao._queryPlay_Signs(playId);
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
    @Generated(hash = 2109728686)
    public List<Member> getConnects() {
        if (connects == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MemberDao targetDao = daoSession.getMemberDao();
            List<Member> connectsNew = targetDao._queryPlay_Connects(playId);
            synchronized (this) {
                if (connects == null) {
                    connects = connectsNew;
                }
            }
        }
        return connects;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 71695848)
    public synchronized void resetConnects() {
        connects = null;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 519636675)
    public List<Comments> getComments() {
        if (comments == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CommentsDao targetDao = daoSession.getCommentsDao();
            List<Comments> commentsNew = targetDao._queryPlay_Comments(playId);
            synchronized (this) {
                if (comments == null) {
                    comments = commentsNew;
                }
            }
        }
        return comments;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 249603048)
    public synchronized void resetComments() {
        comments = null;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1294815695)
    public List<Member> getMemberList() {
        if (memberList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MemberDao targetDao = daoSession.getMemberDao();
            List<Member> memberListNew = targetDao._queryPlay_MemberList(playId);
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
    @Generated(hash = 780012150)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPlayDao() : null;
    }
    public String getPhoto() {
        return this.photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
