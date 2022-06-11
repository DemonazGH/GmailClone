package com.example.gmailclone

import com.example.gmailclone.model.Account
import com.example.gmailclone.model.MailListData

val mailingList = listOf(
    MailListData(
        entryId = 1,
        userName = "Christy",
        subject = "Weekly Android News",
        body = "Hello Christy we have got exciting addition  to the android api",
        timeStamp = "20:10"
    ),
     MailListData(
        entryId = 2,
        userName = "Agatha",
        subject = "Job Application",
        body = "This is regarding a job opportunity I found on your website.",
        timeStamp = "20:10"
    ),
    MailListData(
        entryId = 3,
        userName = "Cecilia",
        subject = "Flutter News",
        body = "Hello Cecilia we have got exciting addition  to the Flutter api",
        timeStamp = "20:10"
    ),
    MailListData(
        entryId = 4,
        userName = "Angelo",
        subject = "Email regarding job opportunity",
        body = "This is regarding a job opportunity for the profile or android developer in our organisation.",
        timeStamp = "21:10"
    ),
    MailListData(
        entryId = 5,
        userName = "Sam",
        subject = "New Event has been created",
        body = "A new event has been added to your dashboard go check it out",
        timeStamp = "20:10"
    ),
    MailListData(
        entryId = 6,
        userName = "Medium",
        subject = "JetPack compose for beginners",
        body = "This article will teach you all the basics of jetpack compose.",
        timeStamp = "20:10"
    ),
    MailListData(
        entryId = 7,
        userName = "Netflix",
        subject = "A new Device is using your account",
        body = "If you did not sign in with a new device then go to settings and reset your password",
        timeStamp = "20:10"
    ),
    MailListData(
        entryId = 8,
        userName = "Collins",
        subject = "A request for partnership",
        body = "This is a follow up email about the partnership request",
        timeStamp = "20:50"
    ),
    MailListData(
        entryId = 9,
        userName = "Amazon",
        subject = "Your account has been created",
        body = "If you did not sign in with a new device then go to settings and reset your password",
        timeStamp = "20:10"
    ),
    MailListData(
        entryId = 10,
        userName = "Jobs",
        subject = "New opportunity that suits you",
        body = "We have an opening that suits your profile kindly check it out and indicate your interest",
        timeStamp = "20:10"
    )
)

val accountLists = mutableListOf<Account>(
    Account(
        icon = R.drawable.lamp,
        userName = "Dzmitry Salavei",
        userEmail = "dimos77@tut.by",
        unreadMails = 324
    ),
    Account(
        userName = "Satanic Warmaster",
        userEmail = "satanwarmaster@yahoo.com",
        unreadMails = 666
    ),
    Account(
        userName = "Belzebub Infernalis",
        userEmail = "boob666@gmail.com",
        unreadMails = 123
    )
)