package com.zhboy.pluginm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zhboy.pluginm.invoke.Invoke

class PluginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //        classLoader.loadClass("name")//加载一个class的具体代码

        Invoke().testInvStart()
    }
}