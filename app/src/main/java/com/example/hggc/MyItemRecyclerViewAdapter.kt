package com.example.hggc

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.hggc.placeholder.PlaceholderContent.PlaceholderItem
import com.example.hggc.databinding.FragmentItemPolBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(

    private val values: List<PlaceholderItem>,
    private val listener: OnItemClickListener // Add the listener as a parameter
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentItemPolBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content
        holder.detailsView.text = item.details

        // Set the click listener on the ViewHolder
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemPolBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content
        val detailsView: TextView = binding.detailsTextView

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

    // Interface for item click listener
    interface OnItemClickListener {
        fun onItemClick(position: Int)

    }

    fun getItemAtPosition(position: Int): PlaceholderItem {
        return values[position]
    }

}
