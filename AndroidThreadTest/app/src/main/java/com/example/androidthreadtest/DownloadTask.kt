package com.example.androidthreadtest

import android.os.AsyncTask

abstract class DownloadTask : AsyncTask<Unit,Int,Boolean>() {
    override fun onPostExecute(result: Boolean?) {
        //super.onPostExecute(result)
        progressDialog.show()
    }

    override fun doInBackground(vararg params: Unit?): Boolean {
        while (true) {
            val dp = doDownload()
            publishProgress(dp)
            if (dp >= 100) {
                break
            }
        }

    

}