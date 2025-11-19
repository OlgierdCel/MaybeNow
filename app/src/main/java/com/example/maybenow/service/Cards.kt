package com.example.maybenow.service

class Cards {

    // to jest po to zeby to bylo static
    companion object {
        val cards: MutableList<Card> = mutableListOf(
            Card("Witaj", "odpowiedz"),
            Card("Szymon", "Gołębiewski"),
            Card("Bartosz","Salak")
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