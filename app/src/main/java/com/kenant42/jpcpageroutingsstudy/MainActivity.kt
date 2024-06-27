package com.kenant42.jpcpageroutingsstudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.Navigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson
import com.kenant42.jpcpageroutingsstudy.ui.theme.JpcpageroutingsstudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JpcpageroutingsstudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PageRoutes()
                }
            }
        }
    }
}


@Composable
fun PageRoutes() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "anasayfa") {
        composable("anasayfa") {
            Anasayfa(navController = navController)
        }
        composable("page_a/{isim}/{yas}/{boy}/{bekarMi}",
            arguments = listOf(
                navArgument("isim") { type = NavType.StringType },
                navArgument("yas") { type = NavType.IntType },
                navArgument("boy") { type = NavType.FloatType },
                navArgument("bekarMi") { type = NavType.BoolType }
            )
        ) {
            val isim = it.arguments?.getString("isim")!!
            val yas = it.arguments?.getInt("yas")!!
            val boy = it.arguments?.getFloat("boy")!!
            val bekarMi = it.arguments?.getBoolean("bekarMi")!!

            PageA(navController = navController, isim, yas, boy, bekarMi)
        }
        composable("page_b") {

            PageB(navController = navController)
        }
        composable("page_c/{user}",
            arguments = listOf(
                navArgument("user") { type = NavType.StringType }
            )) {
            val json = it.arguments?.getString("user")
            val userObject = Gson().fromJson(json, User::class.java)
            PageC(navController = navController, userObject)
        }

        composable("page_d") {
            PageD(navController = navController)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JpcpageroutingsstudyTheme {
        PageRoutes()
    }
}