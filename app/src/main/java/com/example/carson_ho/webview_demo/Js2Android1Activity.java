package com.example.carson_ho.webview_demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.carson_ho.webview_demo.bean.AndroidtoJs;

public class Js2Android1Activity extends AppCompatActivity {

    public static void actionStart(Context context){
        Intent intent=new Intent(context, Js2Android1Activity.class);
        context.startActivity(intent );
    }
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js2_android1);
        initView();
    }

    private void initView() {
        mWebView =  findViewById(R.id.web_view);
        WebSettings webSettings = mWebView.getSettings();
        // 设置与Js交互的权限
        webSettings.setJavaScriptEnabled(true);

        // 通过addJavascriptInterface()将Java对象映射到JS对象
        //参数1：Javascript对象名
        //参数2：Java对象名
        mWebView.addJavascriptInterface(new AndroidtoJs(), "test");//AndroidtoJS类对象映射到js的test对象
        // 加载JS代码
        // 格式规定为:file:///android_asset/文件名.html
        mWebView.loadUrl("file:///android_asset/js_2_android.html");
    }
}
