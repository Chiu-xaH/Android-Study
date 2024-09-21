package com.example.cameraalbumtest

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import android.provider.MediaStore
import android.util.Log
import android.widget.ImageView
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.FileProvider
import com.example.cameraalbumtest.ui.theme.CameraAlbumTestTheme
import java.io.File

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")

   // val takePhoto = 1
    val fromAlbum = 2
    lateinit var imageUri: Uri
  //  lateinit var outputImage: File

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
     //   val b: Button = findViewById(R.id.b)
        val b: Button = findViewById(R.id.b)

        //b.setOnClickListener {
            // 创建File对象，用于存储拍照后的图片
            //outputImage = File(externalCacheDir, "output_image.jpg")
           // if (outputImage.exists()) {
           //     outputImage.delete()
          //  }
          //  outputImage.createNewFile()
           // imageUri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
           //     FileProvider.getUriForFile(
             //       this,
              //      "com.example.cameraalbumtest.fileprovider",
               //     outputImage
              //  )
           // } else {
           //     Uri.fromFile(outputImage)
          //  }
           // // 启动相机程序
          //  val intent = Intent("android.media.action.IMAGE_CAPTURE")
           // intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
           // startActivityForResult(intent, takePhoto)

      //  }

        b.setOnClickListener {
            val it = Intent(Intent.ACTION_OPEN_DOCUMENT)
            it.addCategory(Intent.CATEGORY_OPENABLE)
            it.type = "image/*"
            startActivityForResult(it, 2)
        }
    }





        fun getBitmapFromUri(uri: Uri) = contentResolver.openFileDescriptor(uri, "r")?.use {
            BitmapFactory.decodeFileDescriptor(it.fileDescriptor)
        }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val iv: ImageView = findViewById(R.id.iv)
        when (requestCode) {

            fromAlbum -> {
             //if (resultCode == Activity.RESULT_OK && data != null) {
              data?.data?.let { uri ->
                val bitmap = getBitmapFromUri(uri)
              iv.setImageBitmap(bitmap)
             // }
             }
             }

          //  takePhoto -> {
                //if (resultCode == Activity.RESULT_OK) {
            //        val bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(imageUri))
            //        iv.setImageBitmap(bitmap)
                //}
            }

        }
    }
  //  }



