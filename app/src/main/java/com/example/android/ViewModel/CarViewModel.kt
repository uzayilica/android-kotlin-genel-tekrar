package com.example.android.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.data.Cars
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CarViewModel : ViewModel() {

    private var firebase = FirebaseFirestore.getInstance().collection("car")

    private var _car = MutableLiveData<Result<List<Cars>>>()
    var car: LiveData<Result<List<Cars>>> = _car

    fun addCar(car: Cars) {
        viewModelScope.launch(Dispatchers.IO) {
            firebase
                .add(car)
                .addOnSuccessListener {
                    // Araba başarıyla eklendiğinde gerekli işlemleri yapabilirsiniz
                }
                .addOnFailureListener { error ->
                    _car.postValue(Result.failure(error))
                }
        }
    }

    fun observeCars() {
        firebase.addSnapshotListener { value, error ->
            if (error != null) {
                _car.postValue(Result.failure(error))
                return@addSnapshotListener
            }
            if (value != null) {
                val cars = value.documents.mapNotNull { it.toObject(Cars::class.java) }
                _car.postValue(Result.success(cars))
            }
        }
    }

    fun observeCars2() {

        val querry = firebase.whereEqualTo("name","honda")
        querry.addSnapshotListener { value, error ->
            if (error != null) {
                _car.postValue(Result.failure(error))
                return@addSnapshotListener
            }
            if (value != null) {
                val cars = value.documents.mapNotNull { it.toObject(Cars::class.java) }
                _car.postValue(Result.success(cars))
            }
        }


    }


}
