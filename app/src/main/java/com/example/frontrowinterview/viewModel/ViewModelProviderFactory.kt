package com.example.frontrowinterview.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.frontrowinterview.App
import com.example.frontrowinterview.repo.Repo

class ViewModelProviderFactory (
    val app: App,
    val newsRepository: Repo
        ): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ApiViewModel(newsRepository,app) as T
    }
}
