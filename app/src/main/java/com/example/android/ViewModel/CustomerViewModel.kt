import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.data.Customer
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class CustomerViewModel : ViewModel() {

    private val firestore: FirebaseFirestore = Firebase.firestore
    private val koleksiyon = firestore.collection("koleksiyon1")

    private val _customers = MutableLiveData<Result<List<Customer>>>()
    val customers: LiveData<Result<List<Customer>>> = _customers

    // Coroutine ile müşteri ekleme
    fun addCustomer(customer: Customer) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                koleksiyon.add(customer).await()
                // Başarı durumunda tüm listeyi tekrar al
                getAllCustomers()
            } catch (e: Exception) {
                _customers.postValue(Result.failure(e))
            }
        }
    }

    // Coroutine ile belirli bir müşteriyi getirme
    fun getCustomer(customerId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val document = koleksiyon.document(customerId).get().await()
                if (document.exists()) {
                    val customer = document.toObject(Customer::class.java)
                    if (customer != null) {
                        _customers.postValue(Result.success(listOf(customer))) // Tek müşteriyi listeye çevir
                    } else {
                        _customers.postValue(Result.failure(Exception("Müşteri verisi dönüştürülemedi")))
                    }
                } else {
                    _customers.postValue(Result.failure(Exception("Belge bulunamadı")))
                }
            } catch (e: Exception) {
                _customers.postValue(Result.failure(e))
            }
        }
    }

    // Coroutine ile tüm müşterileri getirme
    fun getAllCustomers() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val querySnapshot = koleksiyon.get().await()
                val customerList = querySnapshot.documents.mapNotNull { it.toObject(Customer::class.java) }
                _customers.postValue(Result.success(customerList)) // Başarı durumu
            } catch (e: Exception) {
                _customers.postValue(Result.failure(e)) // Hata durumu
            }
        }
    }
}
