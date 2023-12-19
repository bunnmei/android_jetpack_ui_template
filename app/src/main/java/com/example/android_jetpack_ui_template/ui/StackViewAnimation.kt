package com.example.android_jetpack_ui_template.ui

import android.widget.Toast
import androidx.compose.animation.core.EaseInOutExpo
import androidx.compose.animation.core.EaseOutQuad
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun StackViewAnimation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val backStackEntry =
        navController.currentBackStackEntryAsState()
//      easingの説明色々
//    https://developer.android.com/reference/kotlin/androidx/compose/animation/core/package-summary#Ease()
    NavHost(
        navController = navController,
        startDestination = StackViewNavRoute.First.route,
        enterTransition = {
           slideInHorizontally(initialOffsetX = {it}, animationSpec = tween(durationMillis = 200, easing = EaseOutQuad))
        },

        popEnterTransition = {
            slideInHorizontally(animationSpec = tween(durationMillis = 200, easing = EaseInOutExpo))
        },
        exitTransition = {
            slideOutHorizontally(animationSpec =  tween(durationMillis = 150, easing = EaseOutQuad))
        },
        popExitTransition = {
            slideOutHorizontally(targetOffsetX = {it}, animationSpec =  tween(durationMillis = 200, easing = EaseInOutExpo))
        },

    ){
        composable(route = StackViewNavRoute.First.route){
            CenterText(text = "一番目の画面", modifier = modifier){
                navController.navigate(StackViewNavRoute.Second.route)
            }
        }
        composable(route = StackViewNavRoute.Second.route){
            CenterText(text = "二番目の画面", modifier = modifier){
                navController.navigate(StackViewNavRoute.Third.route)
            }
        }
        composable(route = StackViewNavRoute.Third.route){
            CenterText(text = "三番目の画面", modifier = modifier, navi = null)
        }

    }
}

@Composable
fun CenterText(text: String?, modifier: Modifier, navi: (() -> Unit)?) {
    val ctx = LocalContext.current
    Column {
        Spacer(modifier = modifier.weight(1f))

        Row{
            Spacer(modifier = modifier.weight(1f))

            Column {
            Text(text = text ?: "引数に文字が渡されていません。")
                Button(onClick = {
                    if (navi != null) {
                        navi()
                    } else {
                        Toast.makeText(ctx, "最後の画面", Toast.LENGTH_LONG).show()
                    }
                }) {
                    Text(text = "移動")
                }
            }
            Spacer(modifier = modifier.weight(1f))
        }

        Spacer(modifier = modifier.weight(1f))
    }

}

//NavigationRouteの定義

sealed class StackViewNavRoute(
    val route: String,
){
    object First: StackViewNavRoute(route = "first")
    object Second: StackViewNavRoute(route = "second")
    object Third: StackViewNavRoute(route = "third")
}