package com.example.techexactly.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.techexactly.data.Application

class ItemDiffCallback : DiffUtil.ItemCallback<Application>() {
    override fun areItemsTheSame(oldItem: Application, newItem: Application): Boolean {
        return oldItem.appId == newItem.appId
    }

    override fun areContentsTheSame(oldItem: Application, newItem: Application): Boolean {
        return oldItem == newItem
    }
}
