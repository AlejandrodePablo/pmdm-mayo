package com.example.pmdm_mayo.features.clients.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pmdm_mayo.features.clients.domain.Client
import com.example.pmdm_mayo.features.clients.domain.DeleteClientUseCase
import com.example.pmdm_mayo.features.clients.domain.GetClientsUseCase
import com.example.pmdm_mayo.features.clients.domain.SaveClientUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ClientsViewModel(
    private val getClients: GetClientsUseCase,
    private val deleteClient: DeleteClientUseCase,
    private val saveClientUseCase: SaveClientUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState

    fun fetchClients() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val clients = getClients()
            _uiState.postValue(
                UiState(
                    clients = clients,
                    error = false
                )
            )
        }
    }

    fun removeClient(dni: String) {
        viewModelScope.launch {
            deleteClient(dni)
            fetchClients()
        }
    }

    fun saveClient(client: Client) {
        viewModelScope.launch(Dispatchers.IO) {
            saveClientUseCase(client)
        }
    }


    data class UiState(
        val isLoading: Boolean = false,
        val error: Boolean = false,
        val clients: List<Client>? = null
    )
}