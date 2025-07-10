package com.nikasov.design

import androidx.compose.material3.Typography
import androidx.compose.ui.unit.sp

val Typography.displayHuge
    get() = displayLarge.copy(
        fontSize = 44.sp,
        lineHeight = 48.sp
    )

//private val interFontFamily = FontFamily(
//    Font(R.font.inter_regular),
//    Font(R.font.inter_light, weight = FontWeight.Light),
//    Font(R.font.inter_medium, weight = FontWeight.Medium),
//    Font(R.font.inter_semibold, weight = FontWeight.SemiBold)
//)

internal val AppTypography = Typography(
//    displayLarge = TextStyle(fontFamily = interFontFamily, fontSize = 34.sp, lineHeight = 41.sp, lineBreak = LineBreak.Heading, hyphens = Hyphens.Auto),
//    displayMedium = TextStyle(fontFamily = interFontFamily, fontSize = 28.sp, lineHeight = 34.sp, lineBreak = LineBreak.Heading, hyphens = Hyphens.Auto)
)