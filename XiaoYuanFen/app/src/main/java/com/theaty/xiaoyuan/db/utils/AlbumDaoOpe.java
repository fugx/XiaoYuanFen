package com.theaty.xiaoyuan.db.utils;

import android.content.Context;

import com.theaty.xiaoyuan.dao.AlbumDao;
import com.theaty.xiaoyuan.db.DbManager;
import com.theaty.xiaoyuan.model.xiaoyuan.Album;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by Yecal on 2018/12/22.
 */

public class AlbumDaoOpe {
    /**
     * 添加数据至数据库
     *
     * @param context
     * @param album
     */
    public static void insertData(Context context, Album album) {

        DbManager.getDaoSession(context).getAlbumDao().insert(album);
    }


    /**
     * 将数据实体通过事务添加至数据库
     *
     * @param context
     * @param list
     */
    public static void insertData(Context context, List<Album> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        DbManager.getDaoSession(context).getAlbumDao().insertInTx(list);
    }

    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     * 内部代码判断了如果存在就update(entity);不存在就insert(entity)；
     *
     * @param context
     * @param album
     */
    public static void saveData(Context context, Album album) {
        DbManager.getDaoSession(context).getAlbumDao().save(album);
    }

    /**
     * 删除数据至数据库
     *
     * @param context
     * @param album 删除具体内容
     */
    public static void deleteData(Context context, Album album) {
        DbManager.getDaoSession(context).getAlbumDao().delete(album);
    }

    /**
     * 根据id删除数据至数据库
     *
     * @param context
     * @param id      删除具体内容
     */
    public static void deleteByKeyData(Context context, long id) {
        DbManager.getDaoSession(context).getAlbumDao().deleteByKey(id);
    }

    /**
     * 删除全部数据
     *
     * @param context
     */
    public static void deleteAllData(Context context) {
        DbManager.getDaoSession(context).getAlbumDao().deleteAll();
    }

    /**
     * 更新数据
     *
     * @param context
     * @param album
     */
    public static void updateData(Context context, Album album) {
        DbManager.getDaoSession(context).getAlbumDao().update(album);
    }

    /**
     * 查询所有数据
     *
     * @param context
     * @return
     */
    public static List<Album> queryAll(Context context) {
        QueryBuilder<Album> builder = DbManager.getDaoSession(context).getAlbumDao().queryBuilder();

        return builder.build().list();
    }

    /**
     * 根据id，其他的字段类似
     *
     * @param context
     * @param id
     * @return
     */
    public static List<Album> queryForId(Context context, long id) {
        QueryBuilder<Album> builder = DbManager.getDaoSession(context).getAlbumDao().queryBuilder();
        /**
         * 返回当前id的数据集合,当然where(这里面可以有多组，做为条件);
         * 这里build.list()；与where(StudentDao.Properties.Id.eq(id)).list()结果是一样的；
         * 在QueryBuilder类中list()方法return build().list();
         *
         */
        // Query<Student> build = builder.where(StudentDao.Properties.Id.eq(id)).build();
        // List<Student> list = build.list();
        return builder.where(AlbumDao.Properties.AlbumId.eq(id)).list();
    }
}
