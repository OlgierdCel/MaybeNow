package com.example.maybenow.service

class Cards {

    // to jest po to zeby to bylo static
    companion object {
        val cards: MutableList<Card> = mutableListOf(
            Card("Pytanie", "Opowiedz"),
            Card("Working", "Pracować"),
            Card("Standing","stać"),
            Card("showing","pokazywać"),
            Card("Class","Klasa")
        )
    }

    public fun addCard(ask: String, answer: String){
        cards.add(
            Card(ask, answer)
        )
    }

    public fun getCards(): MutableList<Card> {
        return cards
    }

}