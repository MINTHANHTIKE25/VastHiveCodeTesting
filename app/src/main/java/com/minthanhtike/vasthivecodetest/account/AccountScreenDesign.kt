package com.minthanhtike.vasthivecodetest.account

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import kotlinx.coroutines.NonDisposableHandle.parent

@Composable
fun AccountScreenDesign(
    modifier:Modifier=Modifier
) {
    ConstraintLayout(modifier = modifier) {
        val text = createRef()
        Text(text = "Account")
    }
}

@Preview
@Composable
fun PrevAccountScn() {
    AccountScreenDesign()
}