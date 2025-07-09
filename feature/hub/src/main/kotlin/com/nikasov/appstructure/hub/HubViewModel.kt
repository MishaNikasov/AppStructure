package com.nikasov.appstructure.hub

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.nikasov.appstructure.hub.components.HubEvent
import com.nikasov.appstructure.hub.components.HubState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class HubViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state: MutableStateFlow<HubState> = MutableStateFlow(HubState())

    val state: StateFlow<HubState> = _state.asStateFlow()

    fun eventHandler(action: HubEvent) {
        when (action) {
            is HubEvent.OnClick -> {

            }
        }
    }

}