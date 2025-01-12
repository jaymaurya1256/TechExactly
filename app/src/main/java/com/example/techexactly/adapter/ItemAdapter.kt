package com.example.techexactly.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.techexactly.data.Application
import com.example.techexactly.databinding.ItemAppBinding

class ItemAdapter : ListAdapter<Application, ItemAdapter.ItemViewHolder>(ItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemAppBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ItemViewHolder(private val binding: ItemAppBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Application) {
            binding.appName.text = item.appName
            binding.switchOnOff.setChecked(item.switch)
            binding.image.load(item.appIcon)
            binding.switchOnOff.setOnCheckedChangeListener { _, isChecked ->
                item.switch = isChecked
            }
        }
    }
}

