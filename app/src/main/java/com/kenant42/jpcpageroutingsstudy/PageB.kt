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
import com.google.gson.Gson

@Composable
fun PageB(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "PageB",fontSize = 60.sp)

        Button(onClick = {
            val userObject = User("Kenan", 24, 1.70f, false)
            val userJson = Gson().toJson(userObject)
            navController.navigate("page_c/$userJson")
        }) {
            Text("Go to PageC")
        }
        val activity = (LocalContext.current as Activity)
        BackHandler (onBack = {
            activity.finish()
        })
    }
}