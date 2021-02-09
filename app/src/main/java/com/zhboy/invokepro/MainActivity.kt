package com.zhboy.invokepro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * 演示在工程内部反射
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //访问一个非public的类中非public的方法
        val utilsClass = Class.forName("com.zhboy.myapplication.invoke.Invoke")
        val constructor = utilsClass.declaredConstructors[0]//获取到第一个构造函数，用户解除访问限制
        constructor.isAccessible = true//解除类的访问限制

        val utils = constructor.newInstance()
        val testMethod = utilsClass.getDeclaredMethod("testInvStart")
        testMethod.isAccessible = true//访问私有方法的权限

        testMethod.invoke(utils)
    }

}