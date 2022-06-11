package com.example.gmailclone.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.twotone.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.gmailclone.R
import com.example.gmailclone.accountLists
import com.example.gmailclone.model.Account

@Composable
fun AccDialog(openDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest = { openDialog.value = false },
        properties = DialogProperties(dismissOnClickOutside = false)
    ) {
        AccountDialogUI(modifier = Modifier, openDialog = openDialog)
    }
}

@Composable
fun AccountDialogUI(modifier: Modifier = Modifier, openDialog: MutableState<Boolean>) {
    Card(backgroundColor = Color.Blue) {
        Column(
            modifier
                .background(Color.White)
                .padding(bottom = 16.dp)
        ) {
            Row(
                modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    openDialog.value = false
                }) {
                    Icon(Icons.Default.Close, contentDescription = "",
                    tint = Color.Black)
                }
                Image(
                    painter = painterResource(id = R.drawable.google2_0_0),
                    contentDescription = "Google",
                    modifier
                        .size(50.dp)
                        .weight(2.0f)
                        .padding(end = 1.dp)
                )
            }
            AccountItem(item = accountLists[0])
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(
                    modifier.requiredWidth(150.dp), shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, color = Gray)
                ) {
                    Text(
                        text = "666 ROCKS",
                        modifier.padding(8.dp),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier.width(10.dp))
            }
            Divider(modifier.padding(top = 16.dp))
            accountLists.slice(1..2).forEach { AccountItem(item = it) }
            Column {
                ActionWithAccounts(
                    icon = Icons.TwoTone.SwitchAccount,
                    title = "Add Another Account",

                )
                ActionWithAccounts(
                    icon = Icons.TwoTone.ManageAccounts,
                    title = "Manage Accounts on this Device"
                )
            }
            Divider(modifier.padding(top = 16.dp, bottom = 16.dp))
            Row(
                modifier
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "Privacy Policy", color = MaterialTheme.colors.primary)
                Card(
                    modifier
                        .padding(top = 10.dp)
                        .size(5.dp),
                    shape = CircleShape,
                    backgroundColor = Black
                ) {}


                Text(text = "Terms Of Service ", color = MaterialTheme.colors.primary)
            }
        }
    }
}

@Composable
fun AccountItem(item: Account) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp)
    ) {
        if (item.icon != null) {
            Image(
                painter = painterResource(id = item.icon), contentDescription = "logo",
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape)
             //   colorFilter = ColorFilter.tint(Black)
            )
        } else {
            Card(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(40.dp)
                    .clip(CircleShape),
                backgroundColor = Color.LightGray
            ) {
                Text(
                    text = item.userName.first().toString(),

                    textAlign = TextAlign.Center, modifier = Modifier.padding(6.dp),
                    color = MaterialTheme.colors.primary
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(2.0f)
                .padding(start = 16.dp, bottom = 16.dp)
        ) {
            Text(
                text = item.userName,
                //    modifier = Modifier.padding(start = 10.dp),
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = item.userEmail,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colors.primary
            )
        }
        Text(text = "${item.unreadMails}+", Modifier.padding(end = 16.dp), color = MaterialTheme.colors.primary)
    }
}

@Composable
fun ActionWithAccounts(icon: ImageVector, title: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 16.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                icon, contentDescription = "Add",
                Modifier.size(20.dp),
                tint = MaterialTheme.colors.primary
            )
        }
        Text(
            text = title,
            Modifier.padding(start = 16.dp),
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.primary
        )
    }
}

//
//@Preview
//@Composable
//fun DefaultPreview() {
//    GmailCloneTheme {
//        AccountDialogUI(Modifier, openDialog = mutableStateOf(true))
//    }
//}