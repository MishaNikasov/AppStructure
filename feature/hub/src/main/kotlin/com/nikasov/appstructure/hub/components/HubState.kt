package com.nikasov.appstructure.hub.components

data class HubState(
    val isLoading: Boolean = false,
    val error: String? = null
)