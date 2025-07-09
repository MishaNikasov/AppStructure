package com.nikasov.appstructure.hub.components

sealed interface HubEvent {
    data object OnClick : HubEvent
}

