package com.example.maybenow.service

class Cards {

    // to jest po to zeby to bylo static
    companion object {
        var cards: MutableList<Card> = mutableListOf(
            Card("Pytanie", "Opowiedz"),
            Card("Working", "Pracować"),
            Card("Standing","stać"),
            Card("showing","pokazywać"),
            Card("Class","Klasa")
        )
    }

}