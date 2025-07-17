package com.nikasov.common.logger

interface Logger {
    fun d(message: String)
    fun d(tag: String, message: String)
    fun i(message: String)
    fun i(tag: String, message: String)
    fun e(tag: String, e: Exception, message: String?)
    fun e(e: Exception, message: String?)
}