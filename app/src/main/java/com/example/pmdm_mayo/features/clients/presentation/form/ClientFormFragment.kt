package com.example.pmdm_mayo.features.clients.presentation.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pmdm_mayo.databinding.FragmentClientFormBinding
import com.example.pmdm_mayo.features.clients.domain.Client
import com.example.pmdm_mayo.features.clients.presentation.ClientsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ClientFormFragment: Fragment() {
    private var _binding: FragmentClientFormBinding? = null

    private val binding get() = _binding!!

    private val viewModel: ClientsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClientFormBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        binding.btnSave.setOnClickListener {
            val dni = binding.inputDni.text.toString()
            val name = binding.inputName.text.toString()
            val email = binding.inputEmail.text.toString()

            if (dni.isNotBlank() && name.isNotBlank() && email.isNotBlank()) {
                val client = Client(dni, name, email,false)
                viewModel.saveClient(client)
                findNavController().navigateUp()
            }
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}