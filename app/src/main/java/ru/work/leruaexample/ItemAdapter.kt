package ru.work.leruaexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load

class ItemAdapter(
//    private val clickListener: OnRecyclerMovieClicked
) : ListAdapter<Item, ItemViewHolder>(ItemsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(
            inflater.inflate(
                R.layout.view_holder_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    interface OnRecyclerMovieClicked {
        fun onClick(movie: CategoryElement)
    }
}

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val image = itemView.findViewById<ImageView>(R.id.iv_item_image)
    private val price = itemView.findViewById<TextView>(R.id.tv_item_price)
    private val title = itemView.findViewById<TextView>(R.id.tv_item_title)

    fun bind(item: Item) {

        image.load(item.image) {
            error(R.drawable.ic_baseline_error_24)

//                fallback(R.drawable.ic_placeholder_movies_24)
//                transformations(RoundedCornersTransformation(8f))
            crossfade(true)
        }
        price.text = item.price
        title.text = item.title
    }
}