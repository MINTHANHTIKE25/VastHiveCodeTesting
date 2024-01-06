package com.minthanhtike.vasthivecodetest.navigation

import com.minthanhtike.vasthivecodetest.common.Constants

sealed class Screens(val route:String){
    object Home : Screens(route = Constants.HOME)
    object Discover : Screens(route = Constants.DISCOVER)
    object Save : Screens(route = Constants.SAVE)
    object Account : Screens(route = Constants.ACCOUNT)
}
