package com.selcannarin.rijksamsterdammuseumapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.selcannarin.rijksamsterdammuseumapp.R
import com.selcannarin.rijksamsterdammuseumapp.data.model.artobject.ArtObject
import com.selcannarin.rijksamsterdammuseumapp.databinding.ItemArtobjectBinding
import com.selcannarin.rijksamsterdammuseumapp.util.loadUrl

class ArtObjectAdapter(
    private val artObjectList: List<ArtObject>,
    private val onClickListener: OnClickListener
) : ListAdapter<ArtObject, ArtObjectAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_artobject, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return artObjectList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(artObjectList[position])
        holder.itemView.setOnClickListener {
            onClickListener.clickListener(artObjectList[position].objectNumber)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemArtobjectBinding.bind(itemView)
        fun bind(artObject: ArtObject) {
            binding.textViewMaker.text = "Maker: ${artObject.principalOrFirstMaker}"
            binding.textViewTitle.text = artObject.title
            artObject.webImage.let { binding.imageViewArtwork.loadUrl(it.url) }

        }
    }

    class DiffCallback : DiffUtil.ItemCallback<ArtObject>() {
        override fun areItemsTheSame(oldItem: ArtObject, newItem: ArtObject): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ArtObject, newItem: ArtObject): Boolean {
            return oldItem == newItem
        }
    }

    class OnClickListener(val clickListener: (artObjectNumber: String) -> Unit) {
        fun onClick(artObjectNumber: String) = clickListener(artObjectNumber)
    }
}