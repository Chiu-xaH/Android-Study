package com.example.contactstest

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri

abstract class MyProvider : ContentProvider() {

    private val data0 = 0
    private val data1 = 1
    private val data2 = 2
    private val data3 = 3

    private val uri = UriMatcher(UriMatcher.NO_MATCH)

    init {
        uri.addURI("com.example.contactstest.provider","table1",data0)
        uri.addURI("com.example.contactstest.provider","table1/#",data1)
        uri.addURI("com.example.contactstest.provider","table2",data2)
        uri.addURI("com.example.contactstest.provider","table2/#",data3)
    }
    
    override fun onCreate(): Boolean {
        return false
    }

    override fun query( uri: Uri,projection : Array<out String>?, selection : String?, selectionArgs: Array<out String>?, sortOrder : String?): Cursor? {
        data0 -> {
            //
        }
        data1 -> {

        }
        data2 -> {

        }
        data3 -> {

        }
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        return 0
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        return null
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        return 0
    }

    override fun getType(p0: Uri): String? = when (uri.match(uri)){
        data0 -> "vnd.android"
        data1 ->
        data2 ->
        data3 ->

            return null
    }
}