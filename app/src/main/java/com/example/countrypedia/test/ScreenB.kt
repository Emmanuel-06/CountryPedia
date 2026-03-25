package com.example.countrypedia.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.countrypedia.ui.theme.beVietnamFamily

@Composable
fun ScreenB(
    name: String?,
    dob: String?
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        name?.let{
            Text(
                text = "Hello, $it",
                fontSize = 24.sp,
                fontFamily = beVietnamFamily,
                fontWeight = FontWeight.Normal
            )
        }

        dob?.let{
            Text(
                text = "Here is your StaffId: $it",
                fontSize = 18.sp,
                fontFamily = beVietnamFamily,
                fontWeight = FontWeight.Bold
            )
        }

    }

}