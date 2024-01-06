package com.minthanhtike.vasthivecodetest.discover

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import kotlinx.coroutines.NonDisposableHandle.parent

@Composable
fun DiscoverScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    DiscoverScreenDesign(modifier = modifier.fillMaxSize().padding(paddingValues))

}