package com.nikasov.design

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable

val Shapes.button: CornerBasedShape @Composable get() = RoundedCornerShape(LocalDimensions.current.buttonShapeCornerRadius)

internal val AppShapes = Shapes(
//    small = RoundedCornerShape(4.dp),
)