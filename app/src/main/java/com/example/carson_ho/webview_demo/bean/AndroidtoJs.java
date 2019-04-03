package com.example.carson_ho.webview_demo.bean;

import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * 说明：
 * Created by lic-w
 *
 * @email lic-w@glodon.com
 * @date 2019/3/25 17:06
 **/
public class AndroidtoJs {
    public static String TAG="AndroidtoJs";
    // 定义JS需要调用的方法
    // 被JS调用的方法必须加入@JavascriptInterface注解
    @JavascriptInterface
    public void hello(String msg) {
        Log.d(TAG,"JS调用了Android的hello方法");
        System.out.println("JS调用了Android的hello方法");
    }
}
