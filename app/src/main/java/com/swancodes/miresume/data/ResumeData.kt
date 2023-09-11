package com.swancodes.miresume.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResumeData(
    val fullName: String,
    val title: String,
    val slackUsername: String,
    val githubHandle: String,
    val bio: String,
    val skills: String,
    val education: String,
    val experience: String
): Parcelable
