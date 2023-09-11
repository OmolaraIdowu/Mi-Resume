package com.swancodes.miresume.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.swancodes.miresume.data.ResumeData

class ResumeViewModel : ViewModel() {

    private val _resumeData = MutableLiveData<ResumeData>()
    val resumeData: LiveData<ResumeData> get() = _resumeData

    private val data: ResumeData = ResumeData(
        fullName = "Omolara Idowu",
        slackUsername = "@Lara",
        title = "Android Developer",
        githubHandle = "https://github.com/OmolaraIdowu",
        bio = "I'm a mobile developer currently seeking a full-time role where I can grow professionally and showcase my talents in creating unforgettable mobile applications. I am passionate about solving real world problems. Strong creative and analytical skills. Team player with an eye for detail.",
        skills = "Material Design,\nMVVM, \nNavigation, \nGit and GitHub, \nWorkManager, \nDependency Injection, \nRetrofit, \nKotlin, \nFirebase",
        education = "2019 - 2022\nTHE POLYTECHNIC, IBADAN\nAccounting" +
                "\n\nClass of 2015\nMATE COMPREHENSIVE HIGH SCHOOL\nCompleted Requirements for High School",
        experience = "ANDROID DEVELOPER INTERN\nKodeCamp\n2022\nCo-acted with a team of android developers to build Garden and iBook app.\n Carried out other version control tasks. Worked on different Android UI screens using material Design. Participated in every tasks given. Was an active member in all weekly sessions." +
                "\n\nFREELANCE\nJunior Android Developer\n2022-Present\nBuilt few learning application for Kotlin called 'Learn Kotlin' that has authentication feature and share feature, 'Countries Of The World' that gets data from an API. Made use of Firebase database for data storage and user authentication"
    )

    init {
        getResumeData()
    }

    private fun getResumeData() {
        _resumeData.value = data
    }

    fun updateResumeInfo(newData: ResumeData) {
        _resumeData.value = newData
        Log.d("ResumeViewModel", "Resume updated: $newData")
    }
}