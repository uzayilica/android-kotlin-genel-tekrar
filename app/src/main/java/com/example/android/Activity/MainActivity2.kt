package com.example.android.Activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.ViewModel.MyViewModel
import com.example.android.data.User
import com.example.android.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding : ActivityMain2Binding;
    private lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)


           var username : String = intent.getStringExtra("username")  ?: "boş"
           var password:String = intent.getStringExtra("password")  ?: "4267462"

        binding.textViewAciklama.text="${username}+${password}"

        // getParcelable ile User nesnesini alma
        val user: User? = intent.getParcelableExtra("user", User::class.java)
        user?.let {
            // Kullanıcı bilgilerini kullanabilirsiniz
            Toast.makeText(this, "Kullanıcı Adı: ${it.username}, Yaş: ${it.password}", Toast.LENGTH_SHORT).show()
        } ?: run {
            // Kullanıcı bilgileri yoksa yapılacaklar
            Toast.makeText(this, "Kullanıcı bilgileri bulunamadı.", Toast.LENGTH_SHORT).show()
        }



        binding.btnarttir.setOnClickListener{
            myViewModel.incrementCounter();

        }

        binding.btnazalt.setOnClickListener{
            myViewModel.decrementCounter();

        }

        binding.btnsifirla.setOnClickListener {
            myViewModel.resetCounter();
        }

        myViewModel.counter.observe(this, Observer {
            binding.textViewForViewModel.text = it.toString()
        } )




    }
}