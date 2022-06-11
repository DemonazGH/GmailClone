package com.example.gmailclone.model

data class MailListData(
    val entryId: Int,
    val userName: String,
    val subject: String,
    val body: String,
    val timeStamp: String = ""
)

