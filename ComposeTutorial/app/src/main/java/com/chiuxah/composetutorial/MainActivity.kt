package com.chiuxah.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.foundation.clickable
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chiuxah.composetutorial.ui.theme.ComposeTutorialTheme
import com.example.compose.tutorial.SampleData
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.compose.tutorial.SampleData.conversationSample

//如果未来的我又来查看这个项目了，别骂了别骂了-l-，真的学点忘点，您嘞再好好复习一下
data class Message(val name : String, val body : String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                       // conversation(SampleData.conversationSample)
                        test()
               //     CourseTable()

                }
            }
        } } }
@Composable//创建显示多条消息的函数
fun conversation(messsage : List<Message>) {
    LazyColumn {
        //lazyColumn相当于rv
        items(messsage) { message ->
            fuck(message)
        }
    }
}
@Composable
fun fuck(msg : Message) {//布局
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.touxiang),
            contentDescription = "头像",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
            //设置边框，圆形，颜色
        )

        //两者水平间距
        Spacer(modifier = Modifier.width(8.dp))

        //判断这个变量是否展开
        var expand by remember { mutableStateOf(false) }
        //remember函数可以将本地状态存储在内存中，并跟踪括号内方法变化，变化时自动化重绘可组合项

        //clickable方法提供了点击事件条件
        Column(modifier = Modifier.clickable { expand = !expand }) {
            Text(
                text = msg.name,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodySmall
            )
            //添加垂直空格
            Spacer(modifier = Modifier.height(4.dp))

            //渐变动画包装，替换颜色
            val colorbian by animateColorAsState(if (expand) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface)

            Surface(
                shape = MaterialTheme.shapes.small,
                shadowElevation = 8.dp,
                tonalElevation = 50.dp,
                color = colorbian,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
                //这个我也不知道干啥的，反正调了会改间距，但是删了就没渐变动画了，奇怪
            ) {
                Text(
                    text = msg.body,
                    style = MaterialTheme.typography.bodyLarge, //设置排版typography，查看源文档可选
                    modifier = Modifier.padding(all = 4.dp),
                    //控制阴影8dp，颜色深浅50dp
                    maxLines = if (expand) Int.MAX_VALUE else 1
                    //maxlines方法，如果点击了，则执行最大化，否则只显示一行
                )
            }
        }

    }



}
@Composable
fun bar() {
    Column() {
        Text("hi")
        var selecteditem by remember { mutableStateOf(0) }
        val items = listOf("选项卡1","选项卡2","选项卡3")

        NavigationBar{
            items.forEachIndexed {index, item ->
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Warning,contentDescription = item)},
                    label = { Text(item)},
                    selected = selecteditem == index,
                    onClick = {selecteditem = index}
                )
            }

        }
    }

}



