package com.theaty.xiaoyuan.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.theaty.xiaoyuan.bean.MusicPlayHistory;

import org.droidparts.persist.sql.EntityManager;

import java.util.ArrayList;


/**
 * 音乐播放足迹数据
 */

public class MusicPlayHistoryManager extends EntityManager<MusicPlayHistory> {

	public MusicPlayHistoryManager(Context ctx, SQLiteDatabase db) {
		super(MusicPlayHistory.class, ctx,db);
	}

	/**
	 * 查询所有足迹
	 * @return
	 */
	public ArrayList<MusicPlayHistory>  getMusicHistorys(){
		ArrayList<MusicPlayHistory>  histories=this.readAll(this.select());
		return histories;
	}

	public  void addMusicHistory(MusicPlayHistory history){
		this.create(history);
	}

	/**
	 * 清空
	 */
	public   void  clearMusicHistory(){
		this.delete(this.readAll(this.select()));
	}

}
