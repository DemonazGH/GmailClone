package com.example.gmailclone.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.gmailclone.model.BottomMenuData

@Composable
fun HomeBottomBar() {
    val items = listOf(BottomMenuData.Mail, BottomMenuData.Meet, BottomMenuData.Add)
    BottomNavigation(
        backgroundColor = Color.White, contentColor = Color.Black
    ) {
        items.forEach {
            BottomNavigationItem(selected = false, onClick = { /*TODO*/ },
                icon = { Icon(imageVector = it.icon, contentDescription = it.title) },
                label = { Text(text = it.title) })
        }
    }
}