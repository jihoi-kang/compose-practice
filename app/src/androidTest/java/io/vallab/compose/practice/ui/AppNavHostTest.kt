package io.vallab.compose.practice.ui

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import io.vallab.compose.practice.ui.navigation.AppNavHost
import io.vallab.compose.practice.ui.navigation.Navigation
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AppNavHostTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController

    @Before
    fun setup() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            AppNavHost(navHostController = navController)
        }
    }

    @Test
    fun 시작화면은_상품목록이다() {
        // given: nothing
        // when
        val actual = navController.currentBackStackEntry?.destination?.route
        assert(actual == Navigation.ProductList.route)
    }

    @Test
    fun 장바구니_버튼을_클릭하면_장바구니_화면으로_이동한다() {
        // given: nothing
        // when
        composeTestRule.onNodeWithContentDescription("장바구니")
            .performClick()

        // then
        val actual = navController.currentBackStackEntry?.destination?.route
        assert(actual == Navigation.Cart.route)
    }

    @Test
    fun 장바구니_버튼을_클릭하고_뒤로가기_버튼을_클릭하면_상품화면으로_돌아온다() {
        // given: nothing
        // when
        composeTestRule.onNodeWithContentDescription("장바구니")
            .performClick()
        composeTestRule.onNodeWithContentDescription("뒤로가기")
            .performClick()

        // then
        val actual = navController.currentBackStackEntry?.destination?.route
        assert(actual == Navigation.ProductList.route)
    }

}