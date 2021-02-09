package com.zhboy.pluginm.invoke;

import android.util.Log;

/**
 * @author: zhou_hao
 * @date: 2021/1/29
 * @description: 插件类，要提供给app使用
 **/
public class Invoke {

    public Invoke() {

    }

    public void testInvStart() {
        Log.i("Invoke", "插件被加载成功了，开始启动");
    }
}
