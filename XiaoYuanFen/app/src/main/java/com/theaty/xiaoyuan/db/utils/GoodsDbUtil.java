package com.theaty.xiaoyuan.db.utils;

import android.content.Context;
import android.util.Log;

import com.theaty.xiaoyuan.db.DaoManager;
import com.theaty.xiaoyuan.model.xiaoyuan.DaoSession;
import com.theaty.xiaoyuan.model.xiaoyuan.GoodsModel;
import com.theaty.xiaoyuan.model.xiaoyuan.GoodsModelDao;
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
     * @param goodsModel
     * @return
     */
    public boolean insert(GoodsModel goodsModel) {
        boolean flag = false;
        flag = mDaoSession.insert(goodsModel) != -1;
        Log.i(TAG, "insert MemberModel :" + flag + "-->" + goodsModel.toString());
        return flag;
    }


    /**
     * 插入多条数据，在子线程操作
     *
     * @param goodsModels
     * @return
     */
    public boolean insertList(final List<GoodsModel> goodsModels) {
        boolean flag = false;
        try {
            mDaoSession.runInTx(new Runnable() {
                @Override
                public void run() {
                    for (GoodsModel MemberModel : goodsModels) {
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
     * @param goodsModel
     * @return
     */
    public boolean delete(GoodsModel goodsModel) {
        boolean flag = false;
        try {
            //按照id删除
            mDaoSession.delete(goodsModel);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;

    }

    /**
     * 更新单条记录
     *
     * @param goodsModel
     * @return
     */
    public boolean update(GoodsModel goodsModel) {
        boolean flag = false;
        try {
            mDaoSession.update(goodsModel);
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
    public List<GoodsModel> queryAll() {
        return mDaoSession.loadAll(GoodsModel.class);

    }
    /**
     * 分页查询
     *
     * @return
     */
    public List<GoodsModel> queryOffset(int page) {
        return mDaoSession.queryBuilder(GoodsModel.class).offset(page*Constant.PAGE_LIMIT).limit(Constant.PAGE_LIMIT).list();

    }

    /**
     * 删除所有
     *
     * @return
     */
    public boolean deleteAll() {
        boolean flag = false;
        try {
            mDaoSession.deleteAll(GoodsModel.class);
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
    public GoodsModel queryMusicById(long musicId) {
        return mDaoSession.load(GoodsModel.class, musicId);
    }

    /**
     * 使用native sql进行查询操作
     */
    public List<GoodsModel> queryMusicByNativeSql(String sql, String[] conditions) {
        return mManager.getDaoSession().queryRaw(GoodsModel.class, sql, conditions);
    }

    /**
     * 使用queryMusicByGroup进行查询操作
     */
    public List<GoodsModel> queryMusicByGroup() {
        return mManager.getDaoSession().queryBuilder(GoodsModel.class).where(new WhereCondition.StringCondition("1 GROUP BY MC_ID")).list();
    }

    /**
     * 使用queryBuilder进行查询
     *
     * @return
     */
    public List<GoodsModel> queryMusicByQueryBuilder(long id) {
        QueryBuilder<GoodsModel> queryBuilder = mDaoSession.queryBuilder(GoodsModel.class);
        return queryBuilder.where(GoodsModelDao.Properties.Goods_id.eq(id)).list();
    }

    /**
     * 使用queryBuilder进行查询Mc_id,分页查找
     *
     * @return
     */
    public List<GoodsModel> queryMusicByMcid(int page, long id) {
        QueryBuilder<GoodsModel> queryBuilder = mDaoSession.queryBuilder(GoodsModel.class);
        return queryBuilder.where(GoodsModelDao.Properties.Goods_id.eq(id)).offset(page*Constant.PAGE_LIMIT).limit(Constant.PAGE_LIMIT).list();
    }


}
