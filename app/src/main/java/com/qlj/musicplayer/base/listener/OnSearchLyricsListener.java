package com.qlj.musicplayer.base.listener;

import com.qlj.musicplayer.model.qq.SongLrc;

import java.util.List;

/**
 * @author luoshipeng
 * createDate：2019/12/10 0010 14:31
 * className   OnAlbumDetailListener
 * Des：TODO
 */
public interface OnSearchLyricsListener {
    void searchResult(List<SongLrc> songLrcList);
}
