package com.hfut.mydemo

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.sharp.KeyboardArrowUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.semantics.error
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.WindowCompat
import com.hfut.mydemo.ui.theme.MYDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MYDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        TopAppBar()
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text("肥工课程表") },

                actions = {
                    IconButton(onClick = {
                        //点击按钮做什么daakaifankui

                    }) {
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "主页")
                    }
                }
            )
        },
    ) {innerPadding ->
        ScrollContent(innerPadding)
        edittext()
    //列表
    }
}

@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    val range = 1..100

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(range.count()) { index ->
            Text(text = "")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun edittext() {
    var text by rememberSaveable { mutableStateOf("") }
    var text2 by rememberSaveable { mutableStateOf("") }
    var hidden by rememberSaveable { mutableStateOf(true) }

   Column(modifier = Modifier.fillMaxWidth()) {

       Spacer(modifier = Modifier.height(90.dp))


      Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center) {
          TextField(
              value = text,
              onValueChange = {text = it},
              label = { Text(text = "学号", )},
              singleLine = true,
              // placeholder = { Text("请输入正确格式")},
              shape = MaterialTheme.shapes.medium,
              colors = TextFieldDefaults.textFieldColors(
                  focusedIndicatorColor = Color.Transparent, // 有焦点时的颜色，透明
                  unfocusedIndicatorColor = Color.Transparent, // 无焦点时的颜色，绿色
              ),
              leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Localized description") }
          )
      }

       Spacer(modifier = Modifier.height(30.dp))
       Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center) {
           TextField(
               value = text2,
               onValueChange = {text2 = it},
               label = { Text("密码")},
               singleLine = true,
               colors = TextFieldDefaults.textFieldColors(
                   focusedIndicatorColor = Color.Transparent, // 有焦点时的颜色，透明
                   unfocusedIndicatorColor = Color.Transparent, // 无焦点时的颜色，绿色
               ),
               //supportingText = { Text("提示：不要重复提交登录")},
               visualTransformation = if (hidden) PasswordVisualTransformation()
               else VisualTransformation.None,
               keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
               leadingIcon = { Icon(painterResource(R.drawable.key), contentDescription = "Localized description") },
               trailingIcon = {
                  IconButton(onClick = { hidden = !hidden }) {
                      val icon =
                        if (hidden) painterResource(R.drawable.visibility_off)
                        else painterResource(R.drawable.visibility)
                   val description =
                      if (hidden) "展示密码"
                      else "隐藏密码"
                  Icon(painter = icon, contentDescription = description)


                   }
                },
               shape = MaterialTheme.shapes.medium

               //  visualTransformation =
           )
       }


       Spacer(modifier = Modifier.height(30.dp))

       Row (modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center){



           Button(
               onClick = {
                   val it = Intent(MyApplication.context, SecondActivity::class.java)
                   it.addFlags(FLAG_ACTIVITY_NEW_TASK)
                   MyApplication.context.startActivity(it)
               },

               ) {
               Text("登录")

           }
           Spacer(modifier = Modifier.width(15.dp))

           FilledTonalButton(
               onClick = { /*TODO*/ },

               ) {
               Text("离线课表")

           }
       }

   }



}






