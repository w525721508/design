package design.root.base;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by Administrator on 2018/1/22.
 */

public class App extends Application {
    public String APPID = "test2";
    public static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //初始化工具类
        Utils.init(this);


        //TODO 注意重新配置APPID '8b0ad7c66a'此为基础项目APPID
        CrashReport.initCrashReport(getApplicationContext(), "8b0ad7c66a", false);

        //测试Bugly，请勿打开此注释
//        CrashReport.testJavaCrash();
    }
}
