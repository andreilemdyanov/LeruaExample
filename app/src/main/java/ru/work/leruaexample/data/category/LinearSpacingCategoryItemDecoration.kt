package ru.work.leruaexample.data.category

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class LinearSpacingCategoryItemDecoration(private val spacing: Int) :
    RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val lastIndex = state.itemCount - 1
        when {
            parent.getChildLayoutPosition(view) == 0 -> {
                outRect.right = spacing
                outRect.left = spacing * 2
            }
            parent.getChildLayoutPosition(view) == lastIndex -> {
                outRect.left = spacing
                outRect.right = spacing * 2
            }
            else -> {
                outRect.left = spacing
                outRect.right = spacing
            }
        }
    }
}