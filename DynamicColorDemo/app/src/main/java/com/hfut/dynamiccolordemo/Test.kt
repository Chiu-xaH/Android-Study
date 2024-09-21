package com.hfut.dynamiccolordemo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp




@Composable
fun PaletteDialogScreen(
    mainViewModel: MainViewModel,
    dynamicColorEnabled: Boolean,
    onChangeDynamicColorEnabled: (Boolean) -> Unit,
    onDismissed: () -> Unit
) {

    var selectedName by remember { mutableStateOf(mainViewModel.currentTheme) }

    AlertDialog(
        onDismissRequest = onDismissed,
        title = {
            Text("Choose Palette")
        },
        text = {
            Column(
                modifier = Modifier.height(240.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text("Dynamic Color Enabled")
                    Spacer(modifier = Modifier.padding(horizontal = 6.dp))
                    Switch(
                        checked = dynamicColorEnabled,
                        onCheckedChange = onChangeDynamicColorEnabled
                    )
                }
                if (!dynamicColorEnabled) {

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(4),
                    ) {
                        items(CatalogTheme.values()) {
                            Column(
                                modifier = Modifier.padding(4.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Surface(
                                    shape = RectangleShape,
                                    border = if (selectedName.value != it.paletteName) null else BorderStroke(
                                        4.dp,
                                        Color.White
                                    ),
                                    modifier = Modifier
                                        .size(48.dp)
                                        .padding(horizontal = 4.dp)
                                        .selectable(
                                            selected = selectedName.value == it.paletteName,
                                            onClick = {
                                                if (selectedName.value != it.paletteName) {
                                                    selectedName.value = it.paletteName
                                                    mainViewModel.setCurrentTheme(it.name)
                                                }
                                            }
                                        ),
                                    color = if (isSystemInDarkTheme()) it.darkColorScheme.primary else it.lightColorScheme.primary
                                ) {}
                                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                                Text(
                                    text = it.paletteName,
                                    style = MaterialTheme.typography.labelMedium
                                )
                            }

                        }
                    }
                }

            }


        },
        confirmButton = {
            TextButton(
                onClick = onDismissed,
            ) {
                Text("Close")
            }
        }
    )
}

@Composable
fun MainScreen( mainViewModel: MainViewModel,
                modifier: Modifier = Modifier,
                dynamicColorEnabled: Boolean,
                onChangeDynamicColorEnabled: (Boolean) -> Unit) {
    var addPaletteDialog by remember { mutableStateOf(false) }
    MainContent(onChangePaletteDialog = { addPaletteDialog = it },
    )

    if (addPaletteDialog) {
        PaletteDialogScreen(
            mainViewModel = mainViewModel,
            dynamicColorEnabled = dynamicColorEnabled,
            onChangeDynamicColorEnabled = onChangeDynamicColorEnabled,
            onDismissed = { addPaletteDialog = false }
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(onChangePaletteDialog: (Boolean) -> Unit) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text("UI 调试 开发") }
            )
        },) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
            //.background()插入背景
        ) {
            Button(onClick = { onChangePaletteDialog(true) }) {
                Text(text = "打开对话框")
            }



        }
    }

}