package com.chiuxah.xposeddemo

import android.util.Log
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodReplacement
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage


class MainHook : IXposedHookLoadPackage {
    override fun handleLoadPackage(p0: XC_LoadPackage.LoadPackageParam?) {
        if (p0 != null) {
            XposedBridge.log("加载XP模块成功 " + p0.packageName)
            Log.d("YOUR_TAG", "加载XP模块成功 " + p0.packageName )
            if(p0.packageName.equals("com.chiuxah.xposeddemo")) {
                XposedHelpers.findAndHookMethod(
                    "com.chiuxah.xposeddemo.MainActivity",
                    p0.classLoader,
                    "isModuleActive",
                    XC_MethodReplacement.returnConstant(true)
                )
            }
        } else {
            XposedBridge.log("包名为空")
            Log.d("YOUR_TAG", "包名为空")
        }
    }
}