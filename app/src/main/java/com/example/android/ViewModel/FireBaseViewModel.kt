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

class FireBaseViewModel : ViewModel() {

    private val firestore = Firebase.firestore
    private val userCollection = firestore.collection("users") // Koleksiyon yolu

    private val _user = MutableLiveData<Result<List<User2>>>()
    val user: LiveData<Result<List<User2>>> get() = _user

    fun addUser(user2: User2) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Yeni kullanıcıyı Firestore'a ekleme
                userCollection.add(user2).addOnSuccessListener {
                    // Başarılı ekleme işlemi sonrası işlem yapılabilir
                }.addOnFailureListener { exception ->
                    _user.postValue(Result.failure(exception))
                }
            } catch (e: Exception) {
                _user.postValue(Result.failure(e))
            }
        }
    }

    fun observeUsers() {
        // Kullanıcıları dinlemek için snapshot listener
        userCollection.addSnapshotListener { snapshot, error ->
            if (error != null) {
                _user.postValue(Result.failure(error))
                return@addSnapshotListener
            }
            if (snapshot != null) {
                val users = snapshot.documents.mapNotNull { it.toObject(User2::class.java) }
                _user.postValue(Result.success(users))
            }
        }
    }
}
