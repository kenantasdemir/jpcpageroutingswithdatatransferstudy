package com.kenant42.jpcpageroutingsstudy

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigator
import com.google.gson.Gson

@Composable
fun PageC(navController: NavController,user:User) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "PageC",fontSize = 60.sp)

        Text(text = user.name)
        Text(text = user.age.toString())
        Text(text = user.height.toString())
        Text(text = user.isMarried.toString())

        Button(onClick = {
            navController.navigate("page_b")
        }) {
            Text("Go to PageB")
        }

        Button(onClick = { navController.navigate("page_d") }) {
            Text(text = "Go to PageD")
        }

    }
}