package com.theaty.xiaoyuan.bean;

import org.droidparts.annotation.sql.Column;
import org.droidparts.annotation.sql.Table;
import org.droidparts.model.Entity;


/**
 * 音乐播放足迹
 */
@Table(name = "musicplayhistory")
public class MusicPlayHistory extends Entity {
    //音乐的trace_id
    @Column(name = "music_id",nullable = true)
    public  int  music_id;

    public MusicPlayHistory(int music_id) {
        this.music_id = music_id;
    }
}
