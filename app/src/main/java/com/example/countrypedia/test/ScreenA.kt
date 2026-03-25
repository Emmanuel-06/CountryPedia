package com.example.countrypedia.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.countrypedia.ui.theme.beVietnamFamily
import com.example.countrypedia.ui.theme.primary

@Composable
fun ScreenA(
    onNavigate: (name: String, dob: String) -> Unit
) {

    var name by remember{
        mutableStateOf("")
    }

    var dob by remember{
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 21.dp)
    ) {
        Text(
            text = "Enter Your Details",
            fontSize = 18.sp,
            fontFamily = beVietnamFamily,
            fontWeight = FontWeight.Bold
        )

       OutlinedTextField(
           value = name,
           onValueChange = {
               name = it
           },
           textStyle = TextStyle(
               fontSize = 16.sp,
               fontFamily = beVietnamFamily,
               fontWeight = FontWeight.Normal
           ),
           placeholder = {
               Text(
                   text = "Input your name",
                   fontSize = 18.sp,
                   fontFamily = beVietnamFamily,
                   fontWeight = FontWeight.Normal
               )
           },
           modifier = Modifier.fillMaxWidth()
       )

        OutlinedTextField(
            value = dob,
            onValueChange = {
                dob = it
            },
            textStyle = TextStyle(
                fontSize = 16.sp,
                fontFamily = beVietnamFamily,
                fontWeight = FontWeight.Normal
            ),
            placeholder = {
                Text(
                    text = "e.g 06062001",
                    fontSize = 18.sp,
                    fontFamily = beVietnamFamily,
                    fontWeight = FontWeight.Normal
                )
            },
            modifier = Modifier.fillMaxWidth()
        )


        Button(
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(primary),
            onClick = {
                      onNavigate(name, dob)
            },
            modifier = Modifier
                .height(54.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Submit",
                fontSize = 16.sp,
                fontFamily = beVietnamFamily,
                fontWeight = FontWeight.Normal
            )
        }
    }

}