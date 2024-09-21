package com.example.constumlibrary

import android.content.Context
import android.content.Intent
import android.content.pm.PermissionInfo
import androidx.fragment.app.FragmentActivity

object PermissonX {
    private const val TAG = "InvisibleFragment"

    fun request(
        activity : FragmentActivity,
        vararg permissions : String,
        callback : PermissionCallBack) {
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment =
            if(existedFragment != null) existedFragment as InvisibleFragment
            else {
                val invisibleFragment = InvisibleFragment()
                fragmentManager.beginTransaction().add(invisibleFragment,TAG).commitNow()
                invisibleFragment
            }
        fragment.requestNow(callback,*permissions)
    }
}


object StartUri {
    fun StartUri(Uri : String,context : Context) {
        val it = Intent(Intent.ACTION_VIEW, android.net.Uri.parse(Uri))
        it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(it)
    }
}