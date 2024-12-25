package com.example.android.fragmentler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.ViewModel.BilgiViewModel
import com.example.android.data.User2
import com.example.android.databinding.FragmentFirebaseBinding


// FirebaseFragment.kt
class FirebaseFragment : Fragment() {
    private lateinit var binding: FragmentFirebaseBinding
    private lateinit var bilgiViewModel: BilgiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirebaseBinding.inflate(inflater, container, false)
        bilgiViewModel = ViewModelProvider(this)[BilgiViewModel::class.java]

        binding.btnSave.setOnClickListener {
            // Önce veriyi kaydet
            val user = User2(
                // User2 sınıfınızın constructor'ına uygun şekilde verileri doldurun
                // Örnek:
                name = binding.editTextUsername.text.toString(),  // EditText'inizin id'sini kullanın
                phone = binding.editTextPassword.text.toString() // EditText'inizin id'sini kullanın
            )
            bilgiViewModel.UserEkle(user)

            // Sonra verileri çek
            bilgiViewModel.VeriCek()
        }

        // Veri çekme sonucunu dinle
        bilgiViewModel.alinanuser.observe(viewLifecycleOwner) { result ->
            result.onSuccess { persons ->
                binding.textViewAciklama.text = persons.toString()
            }.onFailure { exception ->
                binding.textViewAciklama.text = "Hata: ${exception.message}"
            }
        }

        return binding.root
    }
}