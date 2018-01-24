package design.com.design.ui.main;

import android.databinding.DataBindingUtil;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import design.com.design.R;
import design.com.design.base.BaseActivity;
import design.com.design.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<MainPresenter, MainModel, ActivityMainBinding>
        implements NavigationView.OnNavigationItemSelectedListener, MainContract.View {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void initView() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout
                .activity_main);
        mPresenter.init();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_camera: {

            }
            break;
            case R.id.nav_gallery: {

            }
            break;
            case R.id.nav_slideshow: {

            }
            break;
            case R.id.nav_manage: {

            }
            break;
            case R.id.nav_chage_pwd: {

            }
            break;
            case R.id.nav_check_update: {

            }
            break;
            case R.id.nav_log_out: {

            }
            break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void error(String errorMsg) {

    }
}
