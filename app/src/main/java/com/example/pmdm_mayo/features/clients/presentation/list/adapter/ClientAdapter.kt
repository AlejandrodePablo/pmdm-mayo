package com.example.pmdm_mayo.features.clients.presentation.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.pmdm_mayo.R
import com.example.pmdm_mayo.features.clients.domain.Client

class ClientAdapter: ListAdapter<Client, ClientViewHolder>(ClientDiffUtil()) {

    private var onDeleteClick: ((String) -> Unit)? = null

    fun setOnDeleteClickListener(listener: (String) -> Unit) {
        onDeleteClick = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_client_item, parent, false)
        return ClientViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        holder.bind(getItem(position), onDeleteClick ?: {})
    }
}