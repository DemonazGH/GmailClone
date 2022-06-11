package com.example.gmailclone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollScope
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gmailclone.model.DrawerMenuData

@Composable
fun GmailDrawerMenu(scrollState: ScrollState) {
    val listMenu = listOf(
        DrawerMenuData.Divider,
        DrawerMenuData.AllInboxes,
        DrawerMenuData.Divider,
        DrawerMenuData.HeaderOne,
        DrawerMenuData.Primary,
        DrawerMenuData.Social,
        DrawerMenuData.Promotions,
        DrawerMenuData.Starred,
        DrawerMenuData.Snoozed,
        DrawerMenuData.Important,
        DrawerMenuData.Sent,
        DrawerMenuData.Schedule,
        DrawerMenuData.Outbox,
        DrawerMenuData.Draft,
        DrawerMenuData.HeaderTwo,
        DrawerMenuData.Divider,
        DrawerMenuData.AllMail,
        DrawerMenuData.Calendar,
        DrawerMenuData.Contacts,
        DrawerMenuData.Setting,
        DrawerMenuData.Help
    )
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        Text(
            text = "MyMail", modifier = Modifier.padding(start = 20.dp, top = 20.dp),
            fontFamily = FontFamily.SansSerif,
            color = Color.Red,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        listMenu.forEach { item ->
            when {
                item.isDivider -> {
                    Divider(modifier = Modifier.padding(bottom = 10.dp, top = 10.dp), color = Color.Black)
                }
                item.isHeader -> {
                    Text(
                        text = item.title!!, fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.primaryVariant,
                        modifier = Modifier.padding(
                            start = 20.dp, bottom = 16.dp,
                            top = 16.dp
                        )
                    )
                }
                else -> {
                    DrawerMenuItem(item = item)
                }
            }
        }
    }
}

@Composable
fun DrawerMenuItem(item: DrawerMenuData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(top = 16.dp)
    ) {
        Image(
            imageVector = item.icon!!,
            contentDescription = item.title!!,
            modifier = Modifier.weight(0.5f)
        )
        Text(text = item.title, modifier = Modifier.weight(2.0f))
    }
}