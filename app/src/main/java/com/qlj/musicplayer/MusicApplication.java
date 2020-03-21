package com.qlj.musicplayer;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import androidx.multidex.MultiDex;

import com.qlj.musicplayer.model.greendao.AlbumInfoDao;
import com.qlj.musicplayer.model.greendao.DaoMaster;
import com.qlj.musicplayer.model.greendao.DaoSession;
import com.qlj.musicplayer.model.greendao.DaoUpgradeHelper;
import com.qlj.musicplayer.model.greendao.MusicBeanDao;
import com.qlj.musicplayer.model.greendao.MusicInfoDao;
import com.qlj.musicplayer.model.greendao.PlayListBeanDao;
import com.qlj.musicplayer.model.greendao.SearchHistoryBeanDao;
import com.qlj.musicplayer.util.CrashHandler;

/**
 * 作者：Stran on 2017/3/23 15:12
 * 描述：${TODO}
 * 邮箱：strangermy@outlook.com
 *
 * @author Stran
 */
public class MusicApplication
        extends Application {
    private static MusicApplication appContext;
    public static boolean isShowLog = true;


    private DaoSession mDaoSession;
    private static MusicBeanDao musicBeanDao;

    public static MusicApplication getIntstance() {
        if (appContext == null) {
            appContext = new MusicApplication();
        }
        return appContext;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
//        StatService.setDebugOn(true);
        CrashHandler.getInstance()
                .init();
        setUpDataBase();
        MultiDex.install(this);
    }

    private void setUpDataBase() {
        DaoUpgradeHelper helper = new DaoUpgradeHelper(this, "favorite-db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();

    }

    public MusicBeanDao getMusicDao() {
        if (musicBeanDao == null) {
            synchronized ("MusicApplication.class") {
                if (musicBeanDao == null) {
                    musicBeanDao = mDaoSession.getMusicBeanDao();
                }
            }
        }
        return musicBeanDao;

    }

    public MusicInfoDao getMusicInfoDao() {
        return mDaoSession.getMusicInfoDao();
    }

    public SearchHistoryBeanDao getSearchDao() {
        return mDaoSession.getSearchHistoryBeanDao();
    }

    public PlayListBeanDao getPlayListDao() {
        return mDaoSession.getPlayListBeanDao();
    }

    public AlbumInfoDao getAlbumDao() {
        return mDaoSession.getAlbumInfoDao();
    }
}
