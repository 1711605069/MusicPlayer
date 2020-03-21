package com.qlj.musicplayer.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.qlj.musicplayer.base.BasePagerAdapter;
import com.qlj.musicplayer.fragment.AlbumCategoryFragment;
import com.qlj.musicplayer.util.Constants;

/**
 * 作者：Stran on 2017/3/23 03:31
 * 描述：${TODO}
 * 邮箱：strangermy@outlook.com
 *
 * @author Stran
 */
public class AlbumCategoryPagerAdapter
        extends BasePagerAdapter {


    public AlbumCategoryPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return AlbumCategoryFragment.newInstance(position);
    }


    @Override
    public int getCount() {
        return Constants.NUMBER_TWO;
    }


}
