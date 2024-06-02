package com.example.newsapplocal.domain.usecases.app_entry

import com.example.newsapplocal.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}