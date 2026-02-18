package com.example.maybenow

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.maybenow.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicjalizacja bindingu do tego layoutu
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obsługa kliknięcia w button go_menu
        binding.goBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.catFact.setOnClickListener {
            val intent = Intent(this, CatFactActivity::class.java)
            startActivity(intent)
        }
        binding.addHand.setOnClickListener {

            val intent = Intent(this, ManageCardsActivity::class.java)
            startActivity(intent)

        }
    }
}