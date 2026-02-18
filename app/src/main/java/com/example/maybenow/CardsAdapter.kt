package com.example.maybenow.service

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maybenow.R

class CardsAdapter(
    private val onDeleteClick: (Int) -> Unit,
    private val onEditClick: (Int) -> Unit
) : RecyclerView.Adapter<CardsAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = Cards.cards[position]
        holder.bind(card, position, onDeleteClick, onEditClick)
    }

    override fun getItemCount() = Cards.cards.size

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textAsk: TextView = itemView.findViewById(R.id.textAsk)
        private val textAnswer: TextView = itemView.findViewById(R.id.textAnswer)
        private val btnDelete: Button = itemView.findViewById(R.id.btnDelete)
        private val btnEdit: Button = itemView.findViewById(R.id.btnEdit)

        fun bind(card: Card, position: Int, onDelete: (Int) -> Unit, onEdit: (Int) -> Unit) {
            textAsk.text = card.ask
            textAnswer.text = card.answer
            btnDelete.setOnClickListener { onDelete(position) }
            btnEdit.setOnClickListener { onEdit(position) }
        }
    }
}