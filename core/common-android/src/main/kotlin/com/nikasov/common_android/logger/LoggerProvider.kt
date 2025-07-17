package com.nikasov.common_android.logger

import androidx.compose.runtime.staticCompositionLocalOf
import com.nikasov.common.logger.DefaultLogger
import com.nikasov.common.logger.Logger

val LocalLogger = staticCompositionLocalOf<Logger> { DefaultLogger }