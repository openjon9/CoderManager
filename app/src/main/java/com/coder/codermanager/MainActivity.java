package com.coder.codermanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.coder.codermanager.Adapter.HomeListAdapter;
import com.coder.codermanager.Data.homeData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private WebView webview;
    public static String Url = "https://my.coder.com.tw/codermanage/Web_Manage/login.php";
    private ListView homelist;
    private HomeListAdapter homeAdapter;
    private MainActivity context;
    private ArrayList<homeData> mlist;
    private TextView UnDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        findview();
        //  webviewSetting();
        //  webview.loadUrl(Url);
        initData();
        init();

    }

    private void initData() {
        mlist = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            mlist.add(new homeData());
        }
    }

    private void init() {

        homeAdapter = new HomeListAdapter(context, mlist);

        View v = getLayoutInflater().inflate(R.layout.homeitem2,null);
        UnDate =(TextView) v.findViewById(R.id.UnDate);

        homelist.addHeaderView(v,new homeData().getUnDate(),false);
        homelist.setAdapter(homeAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void findview() {
        webview = (WebView) findViewById(R.id.webview);

        homelist = (ListView) findViewById(R.id.homelist);
    }

    private void webviewSetting() {
        WebSettings setting = webview.getSettings();
        setting.setJavaScriptEnabled(true);
        setting.setDomStorageEnabled(true);// 开启 DOM storage API 功能
        setting.setDatabaseEnabled(true);//开启 database storage API 功能

        String appCachePath = getApplicationContext().getCacheDir().getAbsolutePath();
        setting.setAppCachePath(appCachePath);
        setting.setAllowFileAccess(true); // 可以读取文件缓存
        setting.setAppCacheEnabled(true);//开启缓存


        //setting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//把html中的内容放大webview等宽的一列中 舊方法有些手機會跑版
        setting.setUseWideViewPort(true);
        setting.setLoadWithOverviewMode(true);//新方法
        // webview.setInitialScale(1);//讓表格完整顯示


        //  setting.setBlockNetworkImage(true);//先不載圖加快速度
        webview.setWebContentsDebuggingEnabled(true);

//        MyWebViewClient mclient = new MyWebViewClient(context, image);
//        MyWebChromeClient mChromeClinet = new MyWebChromeClient(context);
//
        webview.setWebViewClient(new WebViewClient());
//        webview.setWebChromeClient(mChromeClinet);

    }
}
