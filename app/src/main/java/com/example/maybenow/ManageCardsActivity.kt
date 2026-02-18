package com.example.maybenow

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maybenow.service.Card
import com.example.maybenow.service.Cards
import com.example.maybenow.service.CardsAdapter
import android.widget.Button

class ManageCardsActivity : AppCompatActivity() {

    private lateinit var adapter: CardsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_cards)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val btnAdd = findViewById<Button>(R.id.btnAdd)

        // Konfiguracja list
        adapter = CardsAdapter(
            onDeleteClick = { position -> deleteCard(position) },
            onEditClick = { position -> showCardDialog(position) }
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnAdd.setOnClickListener { showCardDialog(null) }
    }

    private fun deleteCard(position: Int) {
        Cards.cards.removeAt(position)
        adapter.notifyItemRemoved(position)
        adapter.notifyItemRangeChanged(position, Cards.cards.size)
    }

    private fun showCardDialog(position: Int?) {
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog_add_card, null) // Stwórz prosty layout z 2x EditText
        val inputAsk = EditText(this).apply { hint = "Pytanie"; setText(position?.let { Cards.cards[it].ask } ?: "") }
        val inputAnswer = EditText(this).apply { hint = "Odpowiedź"; setText(position?.let { Cards.cards[it].answer } ?: "") }

        // Dla uproszczenia używamy prostego układu
        val layout = android.widget.LinearLayout(this)
        layout.orientation = android.widget.LinearLayout.VERTICAL
        layout.addView(inputAsk)
        layout.addView(inputAnswer)
        builder.setView(layout)

        builder.setPositiveButton("Zapisz") { _, _ ->
            val newCard = Card(inputAsk.text.toString(), inputAnswer.text.toString())
            if (position == null) {
                Cards.cards.add(newCard)
                adapter.notifyItemInserted(Cards.cards.size - 1)
            } else {
                Cards.cards[position] = newCard
                adapter.notifyItemChanged(position)
            }
        }
        builder.setNegativeButton("Anuluj", null)
        builder.show()
    }
}