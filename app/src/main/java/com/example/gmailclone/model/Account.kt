package com.example.gmailclone.model

data class Account(
    val icon: Int? = null,
    val userName: String,
    val userEmail: String,
    val unreadMails: Int
)
