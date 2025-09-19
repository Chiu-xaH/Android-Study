package org.example.learn

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import learnkmm.composeapp.generated.resources.Res
import learnkmm.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var timeAtLocation by remember { mutableStateOf("No location selected") }
        var input by remember { mutableStateOf("") }
         Column {
             Spacer(modifier = Modifier.height(10.dp))
             Row(
                 modifier = Modifier.fillMaxWidth(),
                 horizontalArrangement = Arrangement.Center
             ) {
                 TextField(
                     modifier = Modifier
                         .weight(1f)
                         .padding(horizontal = 15.dp),
                     value = input,
                     onValueChange = {
                         input = it
                     },
                     label = { Text("输入" ) },
                     singleLine = true,
                     trailingIcon = {
                         IconButton(
                             // shape = RoundedCornerShape(5.dp),
                             onClick = {
                             }) {
                             Icon(Icons.Default.Search, contentDescription = null)
                         }
                     },
                     shape = MaterialTheme.shapes.medium,
                     colors = TextFieldDefaults.textFieldColors(
                         focusedIndicatorColor = Color.Transparent, // 有焦点时的颜色，透明
                         unfocusedIndicatorColor = Color.Transparent, // 无焦点时的颜色，绿色
                     ),
                 )
             }

             RowHor {
                 Text(timeAtLocation)
             }

             Spacer(modifier = Modifier.height(10.dp))
            RowHor {
                Button(onClick = { timeAtLocation = "13:30" }) {
                    Text("Show Time At Location!")
                }
            }
        }
    }
}

fun todayDate() : String {
    fun LocalDateTime.format() = toString().substringBefore('T')

    val now = Clock.System.now()
    val zone = TimeZone.currentSystemDefault()
    return now.toLocalDateTime(zone).format()
}

@Composable
fun RowHor(content : @Composable () -> Unit) {
    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        content()
    }
}