package com.minthanhtike.vasthivecodetest.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    HomeScreenDesign(modifier = modifier.fillMaxSize().padding(paddingValues))

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreHomeScn() {
}