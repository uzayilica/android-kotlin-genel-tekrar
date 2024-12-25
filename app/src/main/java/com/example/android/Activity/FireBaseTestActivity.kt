package com.example.android.Activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.android.R
import com.example.android.databinding.ActivityFireBaseTestBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.getField
import com.google.firebase.ktx.Firebase

class FireBaseTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFireBaseTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFireBaseTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val koleksiyon = FirebaseFirestore.getInstance().collection("koleksiyon1")
        val dokuman = koleksiyon.document("dokuman1")

        // SnapshotListener ile belgeyi dinle
        dokuman.addSnapshotListener { documentSnapshot, e ->
            if (e != null) {
                Log.e("bilgi", "Hata oluştu: ${e.message}")
                return@addSnapshotListener
            }

            if (documentSnapshot != null && documentSnapshot.exists()) {
                val yas = documentSnapshot.getLong("age")
                val sehir = documentSnapshot.getString("city")
                val isim = documentSnapshot.getString("name")

                Log.d("bilgi", "Yaş: $yas, Şehir: $sehir, İsim: $isim")
            } else {
                Log.w("bilgi", "Belge bulunamadı.")
            }
        }
    }
}