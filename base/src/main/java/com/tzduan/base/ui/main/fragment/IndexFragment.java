package com.tzduan.base.ui.main.fragment;


import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import com.tzduan.base.R;
import com.tzduan.base.base.BaseActivity;
import com.tzduan.base.base.BaseFragment;
import com.tzduan.base.databinding.FragmentIndexBinding;
import com.tzduan.base.ui.dialog.LoadingDialog;
import com.tzduan.base.ui.main.MainPresenter;
import com.tzduan.base.ui.main.adapter.IndexFragmentAdapter;

/**
 * Created by Administrator on 2018/1/26.
 */

public class IndexFragment extends BaseFragment<MainPresenter,
        FragmentIndexBinding> {
    IndexFragmentAdapter indexFragmentAdapter;
    LoadingDialog loadingDialog = new LoadingDialog();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_index;
    }

    @Override
    public void initView() {
        mViewBinding.ic.tvTitle.setText("主页");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            list.add("" + i);
        }
        indexFragmentAdapter = new IndexFragmentAdapter(list);
        mViewBinding.rlTest.setAdapter(indexFragmentAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mViewBinding.rlTest.setLayoutManager(linearLayoutManager);
        mViewBinding.rlTest.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));
        mViewBinding.srl.setOnRefreshListener(this::refresh);
        indexFragmentAdapter.setOnLoadMoreListener(this::loadMore, mViewBinding.rlTest);
        indexFragmentAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        indexFragmentAdapter.isFirstOnly(false);
        indexFragmentAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });
    }

    /**
     * 刷新
     */
    private void refresh() {
        indexFragmentAdapter.loadMoreComplete();
        mViewBinding.srl.setRefreshing(false);
        indexFragmentAdapter.loadMoreComplete();
    }

    /**
     * 加载更多
     */
    private void loadMore() {
        loadingDialog.show((BaseActivity) getActivity());
        mViewBinding.rlTest.postDelayed(new Runnable() {
            @Override
            public void run() {
                mViewBinding.srl.setRefreshing(false);
                indexFragmentAdapter.addData("789");
                indexFragmentAdapter.loadMoreComplete();
                LogUtils.e("加载更多");
                loadingDialog.dismiss();
            }
        }, 2000);


    }
}
