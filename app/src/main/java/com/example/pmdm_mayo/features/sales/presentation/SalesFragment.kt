package com.example.pmdm_mayo.features.sales.presentation

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.pmdm_mayo.databinding.FragmentSalesBinding
import com.example.pmdm_mayo.features.sales.domain.Sale
import org.koin.androidx.viewmodel.ext.android.viewModel

class SalesFragment : Fragment() {

    private var _binding: FragmentSalesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SalesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSalesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupObservers()
        viewModel.fetchClientDnis()
    }

    private fun setupView() {
        binding.btnSaveSale.setOnClickListener {
            val dni = binding.inputClientDni.text.toString()
            val concept = binding.inputConcept.text.toString()
            val total = binding.inputTotal.text.toString().toDoubleOrNull()

            if (dni.isNotBlank() && concept.isNotBlank() && total != null) {
                val sale = Sale(clientDni = dni, concept = concept, total = total)
                viewModel.saveSale(sale)
                findNavController().navigateUp()
            }
        }

        binding.btnBackSale.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setupObservers() {
        viewModel.clientDnis.observe(viewLifecycleOwner, Observer { dnis ->
            val adapter = ArrayAdapter(requireContext(), R.layout.simple_dropdown_item_1line, dnis)
            binding.inputClientDni.setAdapter(adapter)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}