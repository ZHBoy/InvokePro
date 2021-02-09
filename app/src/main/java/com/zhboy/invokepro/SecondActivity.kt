package com.zhboy.invokepro

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dalvik.system.DexClassLoader
import okio.buffer
import okio.sink
import okio.source
import java.io.File

/**
 * 演示在工程内部反射
 */
class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //复制一份apk到我的缓存里
        val pluginApk = File( "$cacheDir/pluginm-debug.apk")

        //通过okio找到插件APK,并复制到新的目录下
        val source = assets.open("apk/pluginm-debug.apk").source()
        val sink = pluginApk.sink().buffer()
        sink.writeAll(source)

        Log.i("pluginApk.path","pluginApk.path: ${pluginApk.path}")
        Log.i("pluginApk.path","cacheDir.path: ${cacheDir.path}")

        //optimizedDirectory 优化后的odex要放在哪里,放到缓存下面就可以
        val mDexClassLoader = DexClassLoader(pluginApk.path, cacheDir.path, null, null)

        val utilsClass = mDexClassLoader.loadClass("com.zhboy.pluginm.invoke.Invoke")
        val constructor = utilsClass.declaredConstructors[0]//获取到第一个构造函数，用户解除访问限制

        val utils = constructor.newInstance()
        val testMethod = utilsClass.getDeclaredMethod("testInvStart")

        testMethod.invoke(utils)
    }

}