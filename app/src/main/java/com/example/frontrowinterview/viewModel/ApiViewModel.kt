package com.example.frontrowinterview.viewModel

import androidx.lifecycle.*
import com.example.frontrowinterview.App
import com.example.frontrowinterview.models.Users
import com.example.frontrowinterview.models.UsersItem
import com.example.frontrowinterview.repo.Repo
import com.example.frontrowinterview.utils.LoadingState
import kotlinx.coroutines.launch

class ApiViewModel(val repo: Repo,app: App): AndroidViewModel(app) {
    val _registerLiveData = MutableLiveData<List<UsersItem>>()
    val registerLiveData : LiveData<List<UsersItem>>
        get() = _registerLiveData

    val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    fun safeSearchNewsCall() {
        _loadingState.value = LoadingState.LOADING
        repo.getApiCall({
            _registerLiveData.postValue(it)
            _loadingState.value = LoadingState.LOADED
        },{
            _loadingState.value = LoadingState.error(it)
        })
    }
}