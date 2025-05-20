package com.example.pmdm_mayo.features.sales.domain

data class Sale (val id: Int = 0,
                 val clientDni: String,
                 val concept: String,
                 val total: Double)