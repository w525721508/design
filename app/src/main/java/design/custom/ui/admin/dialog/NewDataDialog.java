package design.custom.ui.admin.dialog;

import android.content.Intent;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;

import design.custom.ui.admin.fragment.DataFragment;
import design.root.base.base.BaseDialog;
import design.root.base.base.BasePresenter;
import design.root.base.databinding.DialogNewDataBinding;
import design.root.base.util.GetPathFromUri;


/**
 * Created by Administrator on 2018/1/24.
 */

public class NewDataDialog extends BaseDialog<BasePresenter, DialogNewDataBinding> {
    private final int RESQUEST = 1000;
    private String imgPath = "";
    private DataFragment dataFragment;

    @Override
    public int getLayoutId() {
        return design.root.base.R.layout.dialog_new_data;
    }

    @Override
    public int getTitle() {
        return super.getTitle();
    }

    @Override
    protected boolean isEasy() {
        return true;
    }

    @Override
    public void initView() {
        mViewBinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case design.root.base.R.id.btn_select: {
                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("*/*");//设置类型，我这里是任意类型，任意后缀的可以这样写。
                        intent.addCategory(Intent.CATEGORY_OPENABLE);
                        startActivityForResult(intent, RESQUEST);
                    }
                    break;
                    case design.root.base.R.id.btn_cancel: {
                        dismiss();
                    }
                    break;
                    case design.root.base.R.id.btn_ok: {
                        if (mViewBinding.etMovieName.getText().toString().equals("")) {
                            ToastUtils.showLong("影片名字不能为空");
                            return;
                        }
                        if (imgPath.equals("")) {
                            ToastUtils.showLong("影片封面不可为空");
                            return;
                        }
//                        ApiFactory.FileApi.upload(imgPath).subscribe(new Consumer<String>() {
//                            @Override
//                            public void accept(String s) throws Exception {
//                                Movie movie = new Movie();
//                                movie.setPicname(s);
//                                movie.setName(mViewBinding.etMovieName.getText().toString());
//                                movie.toAddData();
//                                ApiFactory.MovieApi.superCtrl(movie).subscribe(new
// Consumer<Object>() {
//                                    @Override
//                                    public void accept(Object o) throws Exception {
//                                        ToastUtils.showLong("影片发布成功");
//                                        imgPath = "";
//                                        mViewBinding.etMovieName.setText("");
//                                        dataFragment.setRefresh();
//                                    }
//                                }, throwable -> {
//                                    ToastUtils.showLong("影片发布失败");
//                                });
//                            }
//                        }, throwable -> {
//                            ToastUtils.showLong("封面上传失败");
//                        });


                        dismiss();
                    }
                    break;
                }
            }
        });
    }

    public void setDataFragment(DataFragment dataFragment) {
        this.dataFragment = dataFragment;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESQUEST: {
                if (data != null) {
                    String textPre = data.getData().toString();//得到图片uri地址字符串
                    if (textPre.contains("content://")) { //如果包含有content开头，需要转化为其实际路径，不能用content开头
                        imgPath = GetPathFromUri.getPath(getActivity(), data.getData());
                        mViewBinding.tvImg.setText(imgPath);
                    } else {
                        imgPath = textPre;       //如果用file开头，不用转化
                    }
                }
            }
            break;
        }
    }
}
