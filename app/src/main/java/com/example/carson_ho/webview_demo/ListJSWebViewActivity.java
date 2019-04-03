package com.example.carson_ho.webview_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ListJSWebViewActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Android去调用JS的代码(1)
     */
    private Button mBtnAndroid2Js1;
    /**
     * Android去调用JS的代码(2)
     */
    private Button mBtnAndroid2Js2;
    /**
     * JS通过WebView调用 Android 代码(1)
     */
    private Button mBtnJs2Android1;
    /**
     * JS通过WebView调用 Android 代码(2)
     */
    private Button mBtnJs2Android2;
    /**
     * JS通过WebView调用 Android 代码(3)
     */
    private Button mBtnJs2Android3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jsweb_view);
        initView();
    }

    private void initView() {
        mBtnAndroid2Js1 =  findViewById(R.id.btn_android_2_js_1);
        mBtnAndroid2Js1.setOnClickListener(this);
        mBtnAndroid2Js2 =  findViewById(R.id.btn_android_2_js_2);
        mBtnAndroid2Js2.setOnClickListener(this);
        mBtnJs2Android1 =  findViewById(R.id.btn_js_2_android_1);
        mBtnJs2Android1.setOnClickListener(this);
        mBtnJs2Android2 =  findViewById(R.id.btn_js_2_android_2);
        mBtnJs2Android2.setOnClickListener(this);
        mBtnJs2Android3 =  findViewById(R.id.btn_js_2_android_3);
        mBtnJs2Android3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_android_2_js_1:
                Android2Js1Activity.actionStart(this);
                break;
            case R.id.btn_android_2_js_2:
                Android2JS2Activity.actionStart(this);
                break;
            case R.id.btn_js_2_android_1:
                Js2Android1Activity.actionStart(this);
                break;
            case R.id.btn_js_2_android_2:
                break;
            case R.id.btn_js_2_android_3:
                break;
        }
    }
}
