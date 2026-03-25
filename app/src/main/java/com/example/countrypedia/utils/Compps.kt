package com.example.countrypedia.utils

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.countrypedia.ui.theme.beVietnamFamily
import com.example.countrypedia.ui.theme.primary


@Composable
fun Compps(){

    var openDialog by remember{
        mutableStateOf(false)
    }

//    var checkBoxItems = listOf<>("Blue", "Yellow", "Green", "Purple")
    var checkBoxStates = remember{
        mutableStateMapOf<String, Boolean>()
    }

    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Button(
            onClick = {
                openDialog = true
            },
            modifier = Modifier.size(height = 54.dp, width = 240.dp),
            shape = RoundedCornerShape(6.dp)
        ) {
            Text(
                text = "Open Dialog",
                fontFamily = beVietnamFamily,
                fontSize = 18.sp,
                color = Color.White
            )

        }

    }

    if(openDialog){
        AlertDialog(
            onDismissRequest = { openDialog = false },
            confirmButton = {
                Button(
                    onClick = {
                        Toast.makeText(context, "Viola!, You made it", Toast.LENGTH_LONG).show()
                    },
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(primary)
                ) {
                    Text(
                        text = "Proceed",
                        fontFamily = beVietnamFamily,
                        fontSize = 16.sp,
                        color = Color.White
                    )

                }

            },
            shape = RoundedCornerShape(10.dp),
            containerColor = Color.White,
            text = {
                Text(
                    text = "Are you sure you want to sleep now?",
                    fontFamily = beVietnamFamily,
                    fontWeight = FontWeight.Normal
                )
            },
            title = {
                Text(
                    text = "Confirm Sleep",
                    fontFamily = beVietnamFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        )
    }





}