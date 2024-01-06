package com.minthanhtike.vasthivecodetest.save

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun SaveScreenDesign(
    modifier: Modifier = Modifier
) {
    ConstraintLayout(modifier = modifier) {
        val text = createRef()
        Text(text = "Save")
    }
}