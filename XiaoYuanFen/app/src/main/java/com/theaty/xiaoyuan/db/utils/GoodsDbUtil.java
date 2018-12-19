package com.theaty.xiaoyuan.db.utils;

import android.content.Context;
import android.util.Log;

import com.theaty.xiaoyuan.db.DaoManager;
import com.theaty.xiaoyuan.model.xiaoyuan.DaoSession;
import com.theaty.xiaoyuan.model.xiaoyuan.MemberModel;
import com.theaty.xiaoyuan.model.xiaoyuan.MemberModelDao;
import com.theaty.xiaoyuan.system.AppContext;
import com.theaty.xiaoyuan.ui.home.utils.Constant;

import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;

/**
 * Created by alden on 2018/7/1.
 */

public class GoodsDbUtil {
    private static final String TAG = MemberDbUtil.class.getSimpleName();
    private DaoManager mManager;
    private DaoSession mDaoSession;
    private static volatile GoodsDbUtil instance;

    private GoodsDbUtil(Context context) {
        mManager = DaoManager.getInstance();
        mManager.init(context);
        mDaoSession = mManager.getDaoSession();

    }

    public static GoodsDbUtil getInstance() {
        if (instance == null) {
            synchronized (MemberDbUtil.class) {
                if (instance == null) {

                    instance = new GoodsDbUtil(AppContext.getInstance());
                }
            }
        }
        return instance;

    }


    /**
     * 完成MemberModel记录的插入，如果表未创建，先创建MemberModel表
     *
     * @param MemberModel
     * @return
     */
    public boolean insert(MemberModel MemberModel) {
        boolean flag = false;
        flag = mDaoSession.insert(MemberModel) != -1;
        Log.i(TAG, "insert MemberModel :" + flag + "-->" + MemberModel.toString());
        return flag;
    }


    /**
     * 插入多条数据，在子线程操作
     *
     * @param MemberModels
     * @return
     */
    public boolean insertList(final List<MemberModel> MemberModels) {
        boolean flag = false;
        try {
            mDaoSession.runInTx(new Runnable() {
                @Override
                public void run() {
                    for (MemberModel MemberModel : MemberModels) {
                        mDaoSession.insertOrReplace(MemberModel);
                    }
                }
            });
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 删除单条记录
     *
     * @param MemberModel
     * @return
     */
    public boolean delete(MemberModel MemberModel) {
        boolean flag = false;
        try {
            //按照id删除
            mDaoSession.delete(MemberModel);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;

    }

    /**
     * 更新单条记录
     *
     * @param MemberModel
     * @return
     */
    public boolean update(MemberModel MemberModel) {
        boolean flag = false;
        try {
            mDaoSession.update(MemberModel);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<MemberModel> queryAll() {
        return mDaoSession.loadAll(MemberModel.class);

    }
    /**
     * 分页查询
     *
     * @return
     */
    public List<MemberModel> queryOffset(int page) {
        return mDaoSession.queryBuilder(MemberModel.class).offset(page*Constant.PAGE_LIMIT).limit(Constant.PAGE_LIMIT).list();

    }

    /**
     * 删除所有
     *
     * @return
     */
    public boolean deleteAll() {
        boolean flag = false;
        try {
            mDaoSession.deleteAll(MemberModel.class);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 根据主键music_id查询记录
     *
     * @param musicId
     * @return
     */
    public MemberModel queryMusicById(long musicId) {
        return mDaoSession.load(MemberModel.class, musicId);
    }

    /**
     * 使用native sql进行查询操作
     */
    public List<MemberModel> queryMusicByNativeSql(String sql, String[] conditions) {
        return mManager.getDaoSession().queryRaw(MemberModel.class, sql, conditions);
    }

    /**
     * 使用queryMusicByGroup进行查询操作
     */
    public List<MemberModel> queryMusicByGroup() {
        return mManager.getDaoSession().queryBuilder(MemberModel.class).where(new WhereCondition.StringCondition("1 GROUP BY MC_ID")).list();
    }

    /**
     * 使用queryBuilder进行查询
     *
     * @return
     */
    public List<MemberModel> queryMusicByQueryBuilder(long id) {
        QueryBuilder<MemberModel> queryBuilder = mDaoSession.queryBuilder(MemberModel.class);
        return queryBuilder.where(MemberModelDao.Properties.Member_id.eq(id)).list();
    }

    /**
     * 使用queryBuilder进行查询Mc_id,分页查找
     *
     * @return
     */
    public List<MemberModel> queryMusicByMcid(int page, long id) {
        QueryBuilder<MemberModel> queryBuilder = mDaoSession.queryBuilder(MemberModel.class);
        return queryBuilder.where(MemberModelDao.Properties.Member_id.eq(id)).offset(page*Constant.PAGE_LIMIT).limit(Constant.PAGE_LIMIT).list();
    }


}
