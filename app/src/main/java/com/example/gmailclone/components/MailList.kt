package com.example.gmailclone.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material.icons.twotone.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gmailclone.mailingList
import com.example.gmailclone.model.MailListData


@Composable
fun mailList(paddingValues: PaddingValues, scrollState: ScrollState) {
    Box(modifier = Modifier.padding(paddingValues)) {
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .scrollable(scrollState, orientation = Orientation.Vertical)) {
            items(mailingList) { mailData ->
                mailItem(mailListData = mailData)
            }
        }
    }
}


@Composable
fun mailItem(mailListData: MailListData, modifier: Modifier = Modifier) {
    Row(modifier = Modifier.padding(bottom = 8.dp)) {
        Card(
            modifier
                .padding(end = 8.dp)
                .size(40.dp)
                .clip(CircleShape),
            backgroundColor = Color.LightGray
        ) {
            Text(
                text = mailListData.userName.first().toString(),
                textAlign = TextAlign.Center, modifier = modifier.padding(6.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column(modifier = Modifier.weight(2f)) {
            Text(
                text = mailListData.userName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = mailListData.subject,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = mailListData.body,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light
            )
        }
        Column {
            Text(
                text = mailListData.timeStamp, modifier = Modifier.padding(end = 1.dp),
                textAlign = TextAlign.Justify
            )
            IconButton(
                onClick = { Icons.Default.Star },
                modifier = Modifier
                    .size(50.dp)
                    .padding(top = 16.dp)
            ) {

                Icon(imageVector = Icons.Default.StarOutline, contentDescription = "Unstarred")
            }
        }

    }
}