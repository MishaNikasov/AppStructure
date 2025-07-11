package com.nikasov.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.nikasov.design.Blush
import com.nikasov.design.Brown
import com.nikasov.design.Bubblegum
import com.nikasov.design.Cocoa
import com.nikasov.design.Coral
import com.nikasov.design.Green
import com.nikasov.design.Green400
import com.nikasov.design.Green500
import com.nikasov.design.Green600
import com.nikasov.design.Peach
import com.nikasov.design.Pink
import com.nikasov.design.Primary100
import com.nikasov.design.Primary100Alt
import com.nikasov.design.Primary200
import com.nikasov.design.Primary300
import com.nikasov.design.Primary400
import com.nikasov.design.Primary500
import com.nikasov.design.Primary600
import com.nikasov.design.Primary700
import com.nikasov.design.Primary800
import com.nikasov.design.Primary900
import com.nikasov.design.Purple
import com.nikasov.design.Red
import com.nikasov.design.Sand100
import com.nikasov.design.Sand200
import com.nikasov.design.Sand300
import com.nikasov.design.Sand400
import com.nikasov.design.Sand50
import com.nikasov.design.Sand500
import com.nikasov.design.Sand600
import com.nikasov.design.Sand700
import com.nikasov.design.Sand800
import com.nikasov.design.Sand900
import com.nikasov.design.Sky
import com.nikasov.design.Sunshine
import com.nikasov.design.Vanilla
import com.nikasov.design.Yellow

@Immutable
data class AppColors(
    // Primary
    val primary900: Color = Primary900,
    val primary800: Color = Primary800,
    val primary700: Color = Primary700,
    val primary600: Color = Primary600,
    val primary500: Color = Primary500,
    val primary400: Color = Primary400,
    val primary300: Color = Primary300,
    val primary200: Color = Primary200,
    val primary100: Color = Primary100,
    val primary100Alt: Color = Primary100Alt,

    // Green
    val green600: Color = Green600,
    val green500: Color = Green500,
    val green400: Color = Green400,

    // Sand
    val sand900: Color = Sand900,
    val sand800: Color = Sand800,
    val sand700: Color = Sand700,
    val sand600: Color = Sand600,
    val sand500: Color = Sand500,
    val sand400: Color = Sand400,
    val sand300: Color = Sand300,
    val sand200: Color = Sand200,
    val sand100: Color = Sand100,
    val sand50: Color = Sand50,

    // Additional
    val transparent: Color = Color.Transparent,
    val black: Color = Color.Black,
    val white: Color = Color.White,
    val green: Color = Green,
    val sunshine: Color = Sunshine,
    val yellow: Color = Yellow,
    val vanilla: Color = Vanilla,
    val sky: Color = Sky,
    val purple: Color = Purple,
    val bubblegum: Color = Bubblegum,
    val pink: Color = Pink,
    val coral: Color = Coral,
    val red: Color = Red,
    val brown: Color = Brown,
    val cocoa: Color = Cocoa,
    val peach: Color = Peach,
    val blush: Color = Blush,
)