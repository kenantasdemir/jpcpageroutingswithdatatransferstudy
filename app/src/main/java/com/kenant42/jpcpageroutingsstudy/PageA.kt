package com.kenant42.jpcpageroutingsstudy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PageA(navController: NavController,gelenIsim:String,gelenYas:Int,gelenBoy:Float,gelenBekarMi:Boolean) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "PageA",fontSize = 60.sp)

        Text(text = gelenIsim)
        Text(text = gelenYas.toString())
        Text(text = gelenBoy.toString())
        Text(text = gelenBekarMi.toString())

        Button(onClick = {
            navController.navigate("page_b")
        }) {
            Text("Go to PageB")
        }
    }
}