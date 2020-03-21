package com.qlj.musicplayer.fragment.dialogfrag;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.qlj.musicplayer.R;
import com.qlj.musicplayer.base.BaseDialogFragment;
import com.qlj.musicplayer.util.AnimationUtil;
import com.qlj.musicplayer.util.ImageUitl;
import com.qlj.musicplayer.util.LogUtil;
import com.qlj.musicplayer.view.ZoomImageView;

/**
 * Author：Sid
 * Des：${TODO}
 * Time:2017/5/30 13:27
 *
 * @author Stran
 */
public class PreviewBigPicDialogFragment
        extends BaseDialogFragment {
    private static final String TAG = "====" + PreviewBigPicDialogFragment.class.getSimpleName() + "    ";
    private View mView;

    @Override
    public View getViews() {
        mView = LinearLayout.inflate(getActivity(), R.layout.top_dialog_fragment, null);
        initView();
        return mView;
    }

    public static PreviewBigPicDialogFragment newInstance(String url) {
        PreviewBigPicDialogFragment fragment = new PreviewBigPicDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    private void initView() {
        ZoomImageView view = mView.findViewById(R.id.zoom_view);
//        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        String url = getArguments().getString("url");
        LogUtil.d(TAG, url);
        ImageUitl.loadPlaceholder(getContext(), url, view);
        view.setOnClickListener(view1 -> PreviewBigPicDialogFragment.this.dismiss());
        AnimationUtil.applyBobbleAnim(view);


    }


}
