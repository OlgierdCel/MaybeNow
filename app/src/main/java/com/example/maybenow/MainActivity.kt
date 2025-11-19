package com.example.maybenow

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.maybenow.databinding.ActivityMainBinding
import com.example.maybenow.service.Cards
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var i: Int = -1
    private var isAsk: Boolean = true



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Zainicjuj obiekt binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Ustaw widok korzenia z bindingu jako content view
        setContentView(binding.root)

        // zmiana Activity na Menu
        binding.goMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        // dodanie eventu odnośnie przelaczania ask-answer
        binding.card.setOnClickListener {
            showRevers()
        }

        // zmiana karty na nastepna
        binding.goNext.setOnClickListener {
            showNextCards()
        }
        showNextCards()
    }

    fun showRevers(){
        if(isAsk){
            binding.card.text = Cards.cards[i].answer
        }else{
            binding.card.text = Cards.cards[i].ask
        }
        isAsk = !isAsk
    }

    fun showNextCards(){
        i++
        if(Cards.cards.size>=i){
            i = 0
        }
        binding.card.text = Cards.cards[i].ask

    }

}