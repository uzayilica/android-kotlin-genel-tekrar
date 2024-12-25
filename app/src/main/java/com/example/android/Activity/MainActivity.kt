package com.example.android.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.R
import com.example.android.data.User
import com.example.android.Adapter.UserAdapter
import com.example.android.Adapter.UserAdapter2
import com.example.android.Adapter.UserAdapter3
import com.example.android.Adapter.UserAdapter4
import com.example.android.databinding.ActivityMainBinding
import com.example.android.fragmentler.FragmentBir
import com.example.android.fragmentler.FragmentIki
import com.example.android.mainActivity4.MainActivity4
import com.example.android.mainActivity5.MainActivity5

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)






        var liste = mutableListOf(
            User(1, "uzay", "4267462"),
            User(2, "aygun", "4267462"),
            User(3, "bora", "4267462"),
            User(4, "uzay", "4267462"),
            User(5, "aygun", "4267462"),
            User(6, "bora", "4267462"),
        )

        var userAdapter= UserAdapter(this,liste)
        binding.recyclerViewUser.layoutManager=LinearLayoutManager(this)
        binding.recyclerViewUser.adapter=userAdapter

        var userAdapter2= UserAdapter2(this,liste)
        binding.recyclerViewUser2.layoutManager=LinearLayoutManager(this)
        binding.recyclerViewUser2.adapter=userAdapter2


        var userAdapter3= UserAdapter3(this)
        var listeyeni = mutableListOf(
            User(1, "uzay", "4267462"),
            User(2, "aygun", "4267462"),
            User(3, "bora", "4267462"),
            User(4, "uzay", "4267462"),
            User(5, "aygun", "4267462"),
            User(6, "bora", "4267462"),
        )
        userAdapter3.setUserList(listeyeni)
        binding.recyclerViewUser3.layoutManager=LinearLayoutManager(this)
        binding.recyclerViewUser3.adapter=userAdapter3



        var userAdapter4= UserAdapter4(this)
        var listeyeni4 = mutableListOf(
            User(1, "uzay", "4267462"),
            User(2, "aygun", "4267462"),
            User(3, "bora", "4267462"),
            User(4, "uzay", "4267462"),
            User(5, "aygun", "4267462"),
            User(6, "bora", "4267462"),
        )
        userAdapter4.setUserList(listeyeni4)
        userAdapter4.attachItemTouchHelper(binding.recyclerViewUser4)
        binding.recyclerViewUser4.layoutManager=LinearLayoutManager(this)
        binding.recyclerViewUser4.adapter=userAdapter4


        binding.radiogrup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton: RadioButton = findViewById(checkedId)
            val selectedText = radioButton.text.toString()
            when(checkedId){
                R.id.radiosecenek1 ->{
                    binding.checkbox1.text="istanbul"
                    binding.checkbox2.text="ankara"
                    binding.checkbox3.text="izmir"
                    binding.checkbox4.text="bursa"
                    binding.checkbox5.text="trabzon"
                    ToastOlustur(selectedText)
                }
                R.id.radiosecenek2 ->{
                        binding.checkbox1.text="bakü"
                        binding.checkbox2.text="lenkeren"
                        binding.checkbox3.text="masallı"
                        binding.checkbox4.text="gence"
                        binding.checkbox5.text="şeki"
                    ToastOlustur(selectedText)
                }
                R.id.radiosecenek3 ->{
                    binding.checkbox1.text="Girne"
                        binding.checkbox2.text="gazimağusa"
                        binding.checkbox3.text="lefke"
                        binding.checkbox4.text="lefkoşa"
                        binding.checkbox5.text="Geçitkale"
                    ToastOlustur(selectedText)
                }

                else->ToastOlustur("Seçim Yapılmadı")
            }
        }

        binding.checkbox1.setOnClickListener {
            Toast.makeText(this@MainActivity,"Tıklandı ${ binding.checkbox1.text}",Toast.LENGTH_SHORT ).show()

        }

        binding.checkbox2.setOnClickListener {
            Toast.makeText(this@MainActivity,"Tıklandı ${ binding.checkbox2.text}",Toast.LENGTH_SHORT ).show()
        }

        binding.checkbox3.setOnClickListener {
            Toast.makeText(this@MainActivity,"Tıklandı ${ binding.checkbox3.text}",Toast.LENGTH_SHORT ).show()
        }

        binding.checkbox4.setOnClickListener {
            Toast.makeText(this@MainActivity,"Tıklandı ${ binding.checkbox4.text}",Toast.LENGTH_SHORT ).show()
        }

        binding.checkbox5.setOnClickListener {
            Toast.makeText(this@MainActivity,"Tıklandı ${ binding.checkbox5.text}",Toast.LENGTH_SHORT ).show()
        }

        binding.btnAlertOlustur.setOnClickListener {
            AlertDialog.Builder(this)
                .apply {
                   setTitle("Onaylıyor musunuz?")
                    setPositiveButton("evet",DialogInterface.OnClickListener { dialog, which ->
                        ToastOlustur("Kabul Ettiniz")
                    })
                    setNegativeButton("hayır",DialogInterface.OnClickListener { dialog, which ->
                        ToastOlustur("reddetiniz")
                        dialog.dismiss()
                    })
                    setPositiveButtonIcon(ContextCompat.getDrawable(this@MainActivity,
                        R.drawable.az
                    ))
                    setNegativeButtonIcon(ContextCompat.getDrawable(this@MainActivity,
                        R.drawable.az
                    ))
                }
                .create()
                .show()
        }


        binding.btnFragmentDegistir.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView, FragmentBir())
                .addToBackStack(null).commit()
        }


        binding.btnFragmentDegistir2.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView, FragmentIki())
                .addToBackStack(null).commit()
        }

        val bundle = Bundle()
        bundle.putInt("sayi",5)


        binding.btnFragmentDegistir3.setOnClickListener {
            findNavController(R.id.fragmentContainerView).navigate(R.id.action_fragmentBir_to_fragmentIki,bundle)
        }


        binding.btnNavViewGor.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        binding.navviewSon.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.fragmentBir -> {
                    Toast.makeText(this@MainActivity, "Menü 1'e tıklandı", Toast.LENGTH_SHORT).show()
                    // Burada fragment geçişi yapabilirsiniz
                    findNavController(R.id.fragmentContainerView).navigate(menuItem.itemId) // itemId'yi doğrudan kullan
                    true // Seçim yapıldığını belirtmek için true döndürün
                }
                R.id.fragmentIki -> {
                    Toast.makeText(this@MainActivity, "Menü 2'ye tıklandı", Toast.LENGTH_SHORT).show()
                    // Burada başka bir işlem yapabilirsiniz
                    findNavController(R.id.fragmentContainerView).navigate(menuItem.itemId)
                    true // Seçim yapıldığını belirtmek için true döndürün
                }
                else -> false // Diğer durumlar için false döndürün
            }
        }



    binding.btnmain3egit.setOnClickListener{
        startActivity(Intent(this@MainActivity, MainActivity3::class.java))

    }



        binding.btnmain4egit.setOnClickListener{
            startActivity(Intent(this@MainActivity, MainActivity4::class.java))

        }

        binding.btnmain5egit.setOnClickListener {
            startActivity(Intent(this@MainActivity, MainActivity5::class.java))
        }

        binding.btnmain6egit.setOnClickListener {
            startActivity(Intent(this@MainActivity, MainActivity6::class.java))
        }
        binding.btnmain7egit.setOnClickListener {
            startActivity(Intent(this@MainActivity, MainActivity7::class.java))
        }

        binding.btnmain8egit.setOnClickListener {
            startActivity(Intent(this@MainActivity, MainActivity8::class.java))
        }

        binding.btnmain9egit.setOnClickListener {
            startActivity(Intent(this@MainActivity, MainActivity9::class.java))
        }

        binding.btnFirebaseDegistir.setOnClickListener {
            startActivity(Intent(this@MainActivity, FireBaseTestActivity::class.java))
        }

        binding.btnFirebaseDegistir2.setOnClickListener {
            startActivity(Intent(this@MainActivity, SonActivity::class.java))
        }

    }
    fun ToastOlustur(metin:String){
        Toast.makeText(this@MainActivity, metin,Toast.LENGTH_SHORT).show();
    }
    }
