package com.example.gmailclone.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material.icons.sharp.MailOutline
import androidx.compose.material.icons.sharp.VideoCall
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuData(
    val icon: ImageVector,
    val title: String
) {
    object Mail : BottomMenuData(
        icon = Icons.Sharp.MailOutline,
        title = "Mail"
    )

    object Meet : BottomMenuData(
        icon = Icons.Sharp.VideoCall,
        title = "Meet"
    )

    object Add : BottomMenuData(
        icon = Icons.Sharp.Add,
        title = "Add"
    ) {
    }
}