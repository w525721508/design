package design.custom.ui.admin.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import design.custom.R;
import design.custom.databinding.FragmentDataBinding;
import design.custom.ui.admin.adapter.DataFragmentAdapter;
import design.custom.ui.admin.dialog.NewDataDialog;
import design.custom.ui.main.MainPresenter;
import design.custom.ui.main.entity.DataEntity;
import design.root.base.base.BaseActivity;
import design.root.base.base.BaseFragment;
import design.root.base.ui.dialog.SelectDialog;
import design.root.base.util.OnClickListener;

/**
 * Created by Administrator on 2018/1/26.
 */

public class DataFragment extends BaseFragment<MainPresenter,
        FragmentDataBinding> {
    DataFragmentAdapter dataFragmentAdapter;
    List<DataEntity> list;
    private DataFragment dataFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_data;
    }

    @Override
    public void initView() {
        dataFragment = this;
        mViewBinding.ic.tvTitle.setText(getActivity().getResources().getString(R.string
                .menu_updata));
        mViewBinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_new: {
                        NewDataDialog newDataDialog = new NewDataDialog();
                        newDataDialog.setDataFragment(dataFragment);
                        newDataDialog.show((BaseActivity) getActivity());
                    }
                    break;
                    default: {

                    }
                    break;
                }
            }
        });
        list = new ArrayList<>();
        dataFragmentAdapter = new DataFragmentAdapter(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mViewBinding.rlMovies.setLayoutManager(linearLayoutManager);
        mViewBinding.rlMovies.setAdapter(dataFragmentAdapter);
        dataFragmentAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        dataFragmentAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });
        dataFragmentAdapter.setOnItemLongClickListener(new BaseQuickAdapter
                .OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                SelectDialog selectDialog = new SelectDialog();
                selectDialog.setContent("确认删除该电影?");
                selectDialog.setBtnName("删除", "取消");
                selectDialog.setClick(new OnClickListener() {
                    @Override
                    protected void myOnClickListener(View v) {
                        DataEntity dataEntity = list.get(position);
                        dataEntity.toDeleteData();
//                        ApiFactory.MovieApi.superCtrl(dataEntity).subscribe(new
// Consumer<Object>() {
//                            @Override
//                            public void accept(Object o) throws Exception {
//                                ToastUtils.showLong("删除成功");
//                                setRefresh();
//                                selectDialog.dismiss();
//                            }
//                        }, throwable -> {
//                            ToastUtils.showLong("删除失败");
//                            selectDialog.dismiss();
//                        });
                    }
                }, new OnClickListener() {
                    @Override
                    protected void myOnClickListener(View v) {
                        selectDialog.dismiss();
                    }
                });
                selectDialog.show((BaseActivity) getActivity());
                return false;
            }
        });
        setRefresh();
    }

    public void setRefresh() {
//        ApiFactory.MovieApi.getMovies().subscribe(new Consumer<Movie[]>() {
//            @Override
//            public void accept(Movie[] movies) throws Exception {
//                list.clear();
//                for (int i = 0; i < movies.length; i++) {
//                    list.add(movies[i]);
//                }
//                dataFragmentAdapter.setNewData(list);
//            }
//        });
    }

}
