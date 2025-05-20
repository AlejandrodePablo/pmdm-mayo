package com.example.pmdm_mayo.features.clients.presentation.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.pmdm_mayo.features.clients.domain.Client

class ClientDiffUtil:DiffUtil.ItemCallback<Client>() {
    override fun areItemsTheSame(oldItem: Client, newItem: Client): Boolean {
        return oldItem.dni == newItem.dni
    }

    override fun areContentsTheSame(oldItem: Client, newItem: Client): Boolean {
        return oldItem == newItem
    }
}