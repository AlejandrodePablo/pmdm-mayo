package com.example.pmdm_mayo.features.clients.presentation.list.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pmdm_mayo.databinding.ViewClientItemBinding
import com.example.pmdm_mayo.features.clients.domain.Client

class ClientViewHolder(val view: View): RecyclerView.ViewHolder(view){
    private val binding = ViewClientItemBinding.bind(view)

    fun bind(client: Client, onDeleteClick: (String) -> Unit) {
        binding.apply {
            clientName.text = client.name
            clientDni.text = client.dni
            clientEmail.text = client.email

            deleteButton.setOnClickListener {
                onDeleteClick(client.dni)
            }
        }
    }
}