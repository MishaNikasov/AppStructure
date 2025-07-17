package com.nikasov.common_android.logger

import com.nikasov.common.logger.Logger
import timber.log.Timber
import javax.inject.Inject

class AndroidLogger @Inject constructor() : Logger {

    override fun d(message: String) {
        debugLog(null, message)
    }

    override fun d(tag: String, message: String) {
        debugLog(tag, message)
    }

    override fun i(message: String) {
        infoLog(null, message)
    }

    override fun i(tag: String, message: String) {
        infoLog(tag, message)
    }

    override fun e(e: Exception, message: String?) {
        errorLog(null, e, message)
    }

    override fun e(tag: String, e: Exception, message: String?) {
        errorLog(tag, e, message)
    }

    private fun debugLog(tag: String?, message: String) {
        tag?.let { Timber.tag(it).d(message) } ?: Timber.d(message)
    }

    private fun infoLog(tag: String?, message: String) {
        tag?.let { Timber.tag(it).i(message) } ?: Timber.i(message)
    }

    private fun errorLog(tag: String?, e: Exception, message: String? = null) {
        if (message != null) {
            tag?.let { Timber.tag(it).e(e, message) } ?: Timber.e(e, message)
        } else {
            tag?.let { Timber.tag(it).e(e) } ?: Timber.e(e)
        }
    }

}