package com.nikasov.common.resources

interface StringResources {
    fun getString(id: Int, vararg args: Any): String
}