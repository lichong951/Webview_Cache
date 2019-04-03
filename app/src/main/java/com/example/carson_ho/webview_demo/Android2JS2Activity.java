package com.example.carson_ho.webview_demo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

/**
 * 1、因为该方法的执行不会使页面刷新，而第一种方法（loadUrl ）的执行则会。
 * 2、 Android 4.4 后才可使用
 */
public class Android2JS2Activity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 点我调用JS
     */
    private Button mBtnAndroid2Js;
    private WebView mWebView;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, Android2JS2Activity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android2_js2);
        initView();
    }

    private void initView() {
        mBtnAndroid2Js = findViewById(R.id.btn_android_2_js);
        mBtnAndroid2Js.setOnClickListener(this);
        mWebView = findViewById(R.id.web_view);

        WebSettings webSettings = mWebView.getSettings();
        // 设置与Js交互的权限
        webSettings.setJavaScriptEnabled(true);
        // 设置允许JS弹窗
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        // 先载入JS代码
        // 格式规定为:file:///android_asset/文件名.html
        mWebView.loadUrl("file:///android_asset/android_2_js1.html");


        // 由于设置了弹窗检验调用结果,所以需要支持js对话框
        // webview只是载体，内容的渲染需要使用webviewChromClient类去实现
        // 通过设置WebChromeClient对象处理JavaScript的对话框
        //设置响应js 的Alert()函数
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                AlertDialog.Builder b = new AlertDialog.Builder(Android2JS2Activity.this);
                b.setTitle("Alert");
                b.setMessage(message);
                b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        result.confirm();
                    }
                });
                b.setCancelable(false);
                b.create().show();
                return true;
            }

        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_android_2_js:
                // 通过Handler发送消息
                mWebView.post(new Runnable() {
                    @Override
                    public void run() {
                        // 注意调用的JS方法名要对应上
                        // 调用javascript的callJS()方法
                        // 只需要将第一种方法的loadUrl()换成下面该方法即可
                        String data = "Hello World！";
                        mWebView.evaluateJavascript("javascript:callJS2('" + data + "')", new ValueCallback<String>() {
                            @Override
                            public void onReceiveValue(String s) {
                                Log.d("Android2Js", String.valueOf(s));
                            }
                        });
                    }
                });

//                        // Android版本变量
//                        final int version = Build.VERSION.SDK_INT;
//// 因为该方法在 Android 4.4 版本才可使用，所以使用时需进行版本判断
//                        if (version < 18) {
//                            mWebView.loadUrl("javascript:callJS()");
//                        } else {
//                            mWebView.evaluateJavascript("javascript:callJS()", new ValueCallback<String>() {
//                                @Override
//                                public void onReceiveValue(String value) {
//                                    //此处为 js 返回的结果
//                                }
//                            });
//                        }

                break;
        }
    }
}
