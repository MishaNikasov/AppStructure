package com.nikasov.common.logger

object DefaultLogger : Logger {
    override fun d(message: String) {
        println("DEBUG: $message")
    }

    override fun d(tag: String, message: String) {
        println("DEBUG [$tag]: $message")
    }

    override fun i(message: String) {
        println("INFO: $message")
    }

    override fun i(tag: String, message: String) {
        println("INFO [$tag]: $message")
    }

    override fun e(e: Exception, message: String?) {
        println("ERROR: ${e.message}${if (message != null) " - $message" else ""}")
        e.printStackTrace()
    }

    override fun e(tag: String, e: Exception, message: String?) {
        println("ERROR [$tag]: ${e.message}${if (message != null) " - $message" else ""}")
        e.printStackTrace()
    }
}