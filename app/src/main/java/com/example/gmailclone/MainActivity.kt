package com.example.gmailclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.gmailclone.components.GmailDrawerMenu
import com.example.gmailclone.components.HomeBar
import com.example.gmailclone.components.HomeBottomBar
import com.example.gmailclone.components.mailList
import com.example.gmailclone.ui.theme.GmailCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GmailCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.onSurface
                ) {
                    GmailApp()
                }
            }
        }
    }
}

@Composable

fun GmailApp() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val openDiallog = remember {
        mutableStateOf(false)
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { HomeBar(scaffoldState, coroutineScope, openDiallog) },
        drawerContent = {
            GmailDrawerMenu(scrollState)
        },
        drawerGesturesEnabled = true,
        drawerBackgroundColor = Color.White,
        bottomBar = {
            HomeBottomBar()
        },

        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { GmailFab(scrollState) }
//        {
//            FloatingActionButton(
//                onClick = { /*TODO*/ }, shape = MaterialTheme.shapes.large.copy(
//                    CornerSize(percent = 30)
//                ), backgroundColor = MaterialTheme.colors.primary
//            ) {
//
//            }
//        }
    ) {
        mailList(paddingValues = it, scrollState)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GmailCloneTheme {
        GmailApp()
    }
}