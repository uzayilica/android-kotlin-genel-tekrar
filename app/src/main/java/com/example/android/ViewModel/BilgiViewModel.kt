package com.example.android.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.data.User2
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class BilgiViewModel : ViewModel() {
    private var koleksiyon = Firebase.firestore.collection("insan")

    private val _bilgi = MutableLiveData<Result<String>>()
    val bilgi: LiveData<Result<String>> get() = _bilgi

    private val _alinanUser = MutableLiveData<Result<List<User2>>>()
    val alinanuser: LiveData<Result<List<User2>>> get() = _alinanUser

    fun UserEkle(user: User2) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                koleksiyon.document("uzay").set(user).await()
                _bilgi.postValue(Result.success("başarıyla yüklendi"))
            } catch (e: Exception) {
                _bilgi.postValue(Result.failure(e))
            }
        }
    }

    fun VeriCek() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val querySnapshot = koleksiyon.get().await()
                if (!querySnapshot.isEmpty) {
                    val user = querySnapshot.documents.mapNotNull { document ->
                        document.toObject(User2::class.java)
                    }
                    _alinanUser.postValue(Result.success(user))
                } else {
                    _alinanUser.postValue(Result.success(emptyList()))
                }
            } catch (e: Exception) {
                _alinanUser.postValue(Result.failure(e))
            }
        }
    }
}