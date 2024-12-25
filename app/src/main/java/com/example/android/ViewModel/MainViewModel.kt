package com.example.android.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.data.User2
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class MainViewModel : ViewModel() {


    private val koleksiyon  = Firebase.firestore.collection("persons")

    private val _saveStatus = MutableLiveData<Result<String>>();
    val saveStatus: LiveData<Result<String>> get() = _saveStatus


    fun kelimeKaydet(user: User2) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                koleksiyon.add(user).await()
                _saveStatus.postValue(Result.success("Başarıyla eklendi"))
            } catch (e: Exception) {
                _saveStatus.postValue(Result.failure(e))
            }
        }
    }
}