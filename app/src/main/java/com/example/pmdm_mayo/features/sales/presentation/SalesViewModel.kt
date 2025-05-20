package com.example.pmdm_mayo.features.sales.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pmdm_mayo.features.clients.domain.GetClientsUseCase
import com.example.pmdm_mayo.features.sales.domain.Sale
import com.example.pmdm_mayo.features.sales.domain.SaveSaleUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SalesViewModel(
    private val saveSaleUseCase: SaveSaleUseCase,
    private val getClientsUseCase: GetClientsUseCase
) : ViewModel() {

    private val _clientDnis = MutableLiveData<List<String>>()
    val clientDnis: LiveData<List<String>> get() = _clientDnis

    fun fetchClientDnis() {
        viewModelScope.launch(Dispatchers.IO) {
            val clients = getClientsUseCase()
            val dnis = clients.map { it.dni }
            _clientDnis.postValue(dnis)
        }
    }

    fun saveSale(sale: Sale) {
        viewModelScope.launch(Dispatchers.IO) {
            saveSaleUseCase(sale)
        }
    }
}
