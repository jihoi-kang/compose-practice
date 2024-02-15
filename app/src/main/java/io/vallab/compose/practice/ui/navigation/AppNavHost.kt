package io.vallab.compose.practice.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.vallab.compose.practice.ui.cart.CartScreen
import io.vallab.compose.practice.ui.navigation.Navigation
import io.vallab.compose.practice.ui.product.detail.ProductDetailScreen
import io.vallab.compose.practice.ui.product.list.ProductListScreen

@Composable
fun AppNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Navigation.ProductList.route
    ) {
        composable(Navigation.ProductList.route) {
            ProductListScreen(navHostController)
        }
        composable(Navigation.ProductDetail.route) {
            ProductDetailScreen(navHostController)
        }
        composable(Navigation.Cart.route) {
            CartScreen(navHostController)
        }
    }
}