package com.theaty.xiaoyuan.db.utils;

import android.content.Context;

import com.theaty.xiaoyuan.dao.SignDao;
import com.theaty.xiaoyuan.db.DbManager;
import com.theaty.xiaoyuan.model.xiaoyuan.Sign;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by Yecal on 2018/12/22.
 */

public class SignDaoOpe {
    /**
     * 添加数据至数据库
     *
     * @param context
     * @param sign
     */
    public static void insertData(Context context, Sign sign) {

        DbManager.getDaoSession(context).getSignDao().insert(sign);
    }


    /**
     * 将数据实体通过事务添加至数据库
     *
     * @param context
     * @param list
     */
    public static void insertData(Context context, List<Sign> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        DbManager.getDaoSession(context).getSignDao().insertInTx(list);
    }

    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     * 内部代码判断了如果存在就update(entity);不存在就insert(entity)；
     *
     * @param context
     * @param sign
     */
    public static void saveData(Context context, Sign sign) {
        DbManager.getDaoSession(context).getSignDao().save(sign);
    }

    /**
     * 删除数据至数据库
     *
     * @param context
     * @param sign 删除具体内容
     */
    public static void deleteData(Context context, Sign sign) {
        DbManager.getDaoSession(context).getSignDao().delete(sign);
    }

    /**
     * 根据id删除数据至数据库
     *
     * @param context
     * @param id      删除具体内容
     */
    public static void deleteByKeyData(Context context, long id) {
        DbManager.getDaoSession(context).getSignDao().deleteByKey(id);
    }

    /**
     * 删除全部数据
     *
     * @param context
     */
    public static void deleteAllData(Context context) {
        DbManager.getDaoSession(context).getSignDao().deleteAll();
    }

    /**
     * 更新数据
     *
     * @param context
     * @param sign
     */
    public static void updateData(Context context, Sign sign) {
        DbManager.getDaoSession(context).getSignDao().update(sign);
    }

    /**
     * 查询所有数据
     *
     * @param context
     * @return
     */
    public static List<Sign> queryAll(Context context) {
        QueryBuilder<Sign> builder = DbManager.getDaoSession(context).getSignDao().queryBuilder();

        return builder.build().list();
    }

    /**
     * 根据id，其他的字段类似
     *
     * @param context
     * @param id
     * @return
     */
    public static List<Sign> queryForId(Context context, long id) {
        QueryBuilder<Sign> builder = DbManager.getDaoSession(context).getSignDao().queryBuilder();
        /**
         * 返回当前id的数据集合,当然where(这里面可以有多组，做为条件);
         * 这里build.list()；与where(StudentDao.Properties.Id.eq(id)).list()结果是一样的；
         * 在QueryBuilder类中list()方法return build().list();
         *
         */
        // Query<Student> build = builder.where(StudentDao.Properties.Id.eq(id)).build();
        // List<Student> list = build.list();
        return builder.where(SignDao.Properties.SignId.eq(id)).list();
    }
}
