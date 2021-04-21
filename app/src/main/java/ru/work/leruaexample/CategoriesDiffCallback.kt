package ru.work.leruaexample

import androidx.recyclerview.widget.DiffUtil

class CategoriesDiffCallback : DiffUtil.ItemCallback<CategoryElement>() {

    override fun areItemsTheSame(oldItem: CategoryElement, newItem: CategoryElement): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CategoryElement, newItem: CategoryElement): Boolean {
        return oldItem == newItem
    }
}