# MaybeNow

`MaybeNow` to prosta aplikacja na Androida, która demonstruje podstawowe funkcje, takie jak nawigacja między ekranami i integracja z zewnętrznym API. Aplikacja została napisana w języku Kotlin.

## Funkcjonalność

Aplikacja składa się z trzech głównych ekranów:

1.  **Ekran Główny (`MainActivity`)**: Punkt startowy aplikacji. Z tego miejsca użytkownik może przejść do menu.
2.  **Menu (`MenuActivity`)**: Ekran menu, z którego można nawigować do różnych funkcji aplikacji lub wrócić do ekranu głównego.
3.  **Ciekawostki o kotach (`CatFactActivity`)**: Ekran, który pobiera i wyświetla losowe ciekawostki o kotach z zewnętrznego API.

## Struktura projektu

Główne komponenty aplikacji to:

*   `MainActivity.kt`: Główna aktywność uruchamiana przy starcie aplikacji.
*   `MenuActivity.kt`: Aktywność zawierająca menu nawigacyjne.
*   `CatFactActivity.kt`: Aktywność odpowiedzialna za wyświetlanie ciekawostek.

Projekt wykorzystuje **View Binding** do bezpiecznego i łatwego dostępu do widoków w layoutach XML.

## Technologie

*   **Język**: Kotlin
*   **Platforma**: Android
*   **Architektura**: Podstawowa architektura oparta na Aktywnościach (Activity).
*   **Biblioteki**:
    *   AndroidX AppCompat
    *   View Binding
    *   OKHttp


---
