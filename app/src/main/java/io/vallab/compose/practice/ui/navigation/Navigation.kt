package io.vallab.compose.practice.ui.navigation

sealed class Navigation(val route: String) {
    data object ProductList : Navigation(PRODUCT_LIST)
    data object ProductDetail : Navigation(PRODUCT_DETAIL)
    data object Cart : Navigation(CART)

    companion object {
        private const val PRODUCT_LIST = "PRODUCT_LIST"
        private const val PRODUCT_DETAIL = "PRODUCT_DETAIL"
        private const val CART = "CART"
    }
}