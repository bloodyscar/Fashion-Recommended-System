package com.example.fashionday.ui.upload

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fashionday.RvClickListener
import com.example.fashionday.data.response.DataItem
import com.example.fashionday.databinding.ItemListPredictionBinding

class UploadAdapter(private val listResPrediction: List<DataItem>) :
    RecyclerView.Adapter<UploadAdapter.ViewHolder>() {

    var listener: RvClickListener? = null

    class ViewHolder(private val binding: ItemListPredictionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataItem, listener: RvClickListener?) {
            binding.apply {
                Glide.with(itemView.context).load(data.photo).into(ivResPred)
                ivResPred.setOnClickListener{
                    listener?.onItemClicked(it, data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemListPredictionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = listResPrediction[position]
        holder.bind(dataItem, listener)
    }

    override fun getItemCount(): Int = listResPrediction.size

}