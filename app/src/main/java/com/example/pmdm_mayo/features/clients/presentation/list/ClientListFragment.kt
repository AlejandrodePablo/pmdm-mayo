package com.example.pmdm_mayo.features.clients.presentation.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pmdm_mayo.databinding.FragmentClientListBinding
import com.example.pmdm_mayo.features.clients.presentation.list.adapter.ClientAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClientListFragment : Fragment() {

    private var _binding: FragmentClientListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ClientsListViewModel by viewModel()
    private val adapter = ClientAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClientListBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    private fun setupView() {
        // Título en la toolbar
        binding.clientsToolbar.toolbar.title = "Clientes"

        // RecyclerView y adapter
        binding.clientListRecyclerview.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.clientListRecyclerview.adapter = adapter

        // Callback de eliminar
        adapter.setOnDeleteClickListener { dni ->
            viewModel.removeClient(dni)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.fetchClients()
    }

    private fun setupObservers() {
        val clientObserver = Observer<ClientsListViewModel.UiState> {
            it.clients.let {
                adapter.submitList(it?.toList())
            }
            if (it.error) {
                Log.d("@dev", "Error")
            }
            if (it.isLoading) {
                Log.d("@dev", "Loading")
            } else {
                Log.d("@dev", "Loaded")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, clientObserver)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}