package design.custom.ui.admin;

import android.support.v4.view.ViewPager;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import design.custom.R;
import design.custom.databinding.ActivityAdminBinding;
import design.custom.ui.admin.fragment.DataFragment;
import design.custom.ui.admin.fragment.UserManagerFragment;
import design.custom.ui.main.MainModel;
import design.custom.ui.main.MainPresenter;
import design.custom.ui.main.adapter.FragmentViewAdapter;
import design.root.base.base.BaseActivity;
import design.root.base.base.BaseFragment;
import design.root.base.entity.TabEntity;

public class AdminActivity extends BaseActivity<MainPresenter, MainModel, ActivityAdminBinding> {
    private int[] titleInts = {R.string.menu_updata, R.string.menu_user};
    private int[] unSelectIconList = {R.mipmap.address01, R.mipmap.email01};
    private FragmentViewAdapter fragmentViewAdapter;
    private int[] selectIconList = {R.mipmap.address02, R.mipmap.email02};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_admin;

    }

    @Override
    public void initView() {
        List<BaseFragment> list = new ArrayList<>();
        list.add(new DataFragment());
        list.add(new UserManagerFragment());

        fragmentViewAdapter = new FragmentViewAdapter(list, getSupportFragmentManager());
        mViewBinding.fragmentContainer.setAdapter(fragmentViewAdapter);
        initMenu();
        mViewBinding.tabLayout.setTabData(mTabEntities);
    }

    private void initMenu() {
        for (int i = 0; i < titleInts.length; i++) {
            mTabEntities.add(new TabEntity(titleInts[i], selectIconList[i], unSelectIconList[i]));
        }
        mViewBinding.tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewBinding.fragmentContainer.setCurrentItem(position);

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
//        mViewBinding.tabLayout.showDot(2);
        mViewBinding.fragmentContainer.addOnPageChangeListener(new ViewPager.OnPageChangeListener
                () {

            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mViewBinding.tabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}