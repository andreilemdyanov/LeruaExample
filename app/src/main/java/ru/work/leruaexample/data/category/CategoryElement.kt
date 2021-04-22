package ru.work.leruaexample.data.category

sealed class CategoryElement {
    abstract val id: Int

    data class Category(
        override val id: Int,
        val title: String,
        val image: Int,
    ) : CategoryElement()

    data class Header(
        override val id: Int,
        val title: String,
        val image: Int,
    ) : CategoryElement()

    data class Footer(
        override val id: Int,
        val title: String,
        val image: Int,
    ) : CategoryElement()
}