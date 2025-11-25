package com.example.maybenow

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.maybenow.databinding.DogFactBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class CatFactActivity : AppCompatActivity() {

    private lateinit var binding: DogFactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicjalizacja bindingu do dog_fact.xml
        binding = DogFactBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Obsługa kliknięcia przycisku go_menu
        binding.goMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        lifecycleScope.launch {
            val fact = getCatFact()
            binding.fact.text = fact
        }

    }

    suspend fun getCatFact(): String = withContext(Dispatchers.IO) {
        val client = OkHttpClient()

        // podstawowy endpoint API MeowFacts
        val url = "https://meowfacts.herokuapp.com/"

        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                return@withContext "Błąd: kod ${response.code}"
            }
            val body = response.body?.string() ?: return@withContext "Brak danych"

            // odpowiedź wygląda jak:
            // {
            //   "data": [
            //     "Some cat fact."
            //   ]
            // }
            val json = JSONObject(body)
            val dataArray = json.getJSONArray("data")

            if (dataArray.length() == 0) {
                return@withContext "Brak ciekawostek"
            }

            return@withContext dataArray.getString(0)
        }
    }





}
