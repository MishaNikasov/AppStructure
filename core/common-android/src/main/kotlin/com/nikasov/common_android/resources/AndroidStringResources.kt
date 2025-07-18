package com.nikasov.common_android.resources

import android.content.Context
import com.nikasov.common.resources.StringResources
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AndroidStringResources @Inject constructor(
    @ApplicationContext private val context: Context
) : StringResources {
    override fun getString(id: Int, vararg args: Any): String {
        return context.getString(id, *args)
    }
}