package ru.work.leruaexample.data.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.work.leruaexample.R

class CategoriesAdapter(
//    private val clickListener: OnRecyclerMovieClicked
) : ListAdapter<CategoryElement, ViewHolder>(CategoriesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            Type.HEADER.ordinal -> ViewHolder.Header(
                inflater.inflate(
                    R.layout.view_holder_category_header,
                    parent,
                    false
                )
            )
            Type.MOVIE.ordinal -> ViewHolder.Category(
                inflater.inflate(
                    R.layout.view_holder_category,
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder.Header -> holder.bind()
            is ViewHolder.Category -> {
                holder.bind(getItem(position) as CategoryElement.Category)
//                holder.itemView.setOnClickListener {
//                    clickListener.onClick(getItem(position))
//                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> Type.HEADER.ordinal
            else -> Type.MOVIE.ordinal
        }
    }

    enum class Type {
        HEADER,
        MOVIE
    }

    interface OnRecyclerMovieClicked {
        fun onClick(movie: CategoryElement)
    }
}

sealed class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    class Category(itemView: View) : ViewHolder(itemView) {
        private val image = itemView.findViewById<ImageView>(R.id.iv_category_image)
        private val title = itemView.findViewById<TextView>(R.id.tv_category_title)

        fun bind(category: CategoryElement.Category) {

            image.load(category.image) {
                error(R.drawable.ic_baseline_error_24)

//                fallback(R.drawable.ic_placeholder_movies_24)
//                transformations(RoundedCornersTransformation(8f))
                crossfade(true)
            }
            title.text = category.title
        }
    }

    class Header(itemView: View) : ViewHolder(itemView) {
        //        private val image = itemView.findViewById<ImageView>(R.id.iv_category_icon)
        private val title = itemView.findViewById<TextView>(R.id.tv_category_title)

        fun bind() {
//            image.setImageResource(R.drawable.ic_baseline_list_24)
//            image.load(R.drawable.ic_baseline_list_24){
//                error(R.drawable.ic_baseline_error_24)
//                crossfade(true)
//            }
            title.text = "Каталог"
        }
    }
}