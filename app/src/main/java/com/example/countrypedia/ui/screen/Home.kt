package com.example.countrypedia.ui.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.countrypedia.data.model.CountryInfoItem
import com.example.countrypedia.ui.theme.accent
import com.example.countrypedia.ui.theme.beVietnamFamily
import com.example.countrypedia.ui.theme.primary
import com.example.countrypedia.ui.viewmodel.CountryViewModel
import com.example.countrypedia.utils.NetworkResponse
import com.example.countrypedia.utils.navigationBarItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    countryViewModel: CountryViewModel = hiltViewModel(),
    navigateDetails: (String) -> Unit
) {

    val countryInfoState = countryViewModel.countryInfo.collectAsState()

    var userQuery by remember { mutableStateOf("") }

    var selectedIndex by remember { mutableStateOf(0) }

    var keyboardController = LocalSoftwareKeyboardController?.current

    var isInitialLoad by remember { mutableStateOf(true) }
    var isSearching by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = Unit) {
        countryViewModel.getCountryInfo("Russia")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "CountryPedia",
                        fontFamily = beVietnamFamily,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        },
//        bottomBar = {
//            NavigationBar(
//                modifier = Modifier
//                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
//            ) {
//                navigationBarItems.forEachIndexed { index, navigationBar ->
//                    NavigationBarItem(
//                        selected = selectedIndex == index,
//                        onClick = {
//                            selectedIndex = index
//                        },
//                        icon = {
//                            Icon(
//                                imageVector = if (selectedIndex == index) navigationBar.selectedIcon else navigationBar.unSelectedIcon,
//                                contentDescription = null
//                            )
//                        },
//                        label = {
//                            Text(
//                                text = navigationBar.label,
//                                fontSize = 14.sp,
//                                fontFamily = beVietnamFamily,
//                                fontWeight = FontWeight.Normal
//                            )
//                        },
//                        modifier = Modifier
//                    )
//                }
//            }
//        }

    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 21.dp)
        ) {
            Box(
                modifier = Modifier,
            ) {
                when (val countryInfo = countryInfoState.value) {
                    is NetworkResponse.Loading -> {
                        if (isInitialLoad) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                CircularProgressIndicator(
                                    strokeCap = StrokeCap.Round
                                )
                            }
                        } else {
                            CircularProgressIndicator(
                                strokeCap = StrokeCap.Round
                            )
                        }
                    }

                    is NetworkResponse.Success -> {
                        isInitialLoad = false
                        isSearching = false
                        countryInfo.data?.let { country ->
                            CountryDetails(
                                country = country,
                                onCardClicked = navigateDetails
                            )
                            Spacer(modifier = Modifier.height(60.dp))
                        }
                    }

                    is NetworkResponse.Error -> {
                        isInitialLoad = false
                        isSearching = false

                        Text(text = "${countryInfo.message}" ?: "Error")

                    }
                }
            }

            if (keyboardController != null) {
                InputSection(
                    modifier = Modifier.weight(0.7f),
                    keyboardController = keyboardController,
                    userQuery = userQuery,
                    onUserQueryChanged = { userQuery = it },
                    onSubmit = {
                        countryViewModel.getCountryInfo(userQuery)
                        userQuery = ""
                    }

                )
            }
        }
    }

}

@SuppressLint("SuspiciousIndentation")
@Composable
fun CountryDetails(
    country: List<CountryInfoItem>,
    onCardClicked: (String) -> Unit
) {

    val countryItem = country.first()

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = accent,
            contentColor = Color.Black
        ),
        onClick = {
            onCardClicked(countryItem.name.common)
        },
        modifier = Modifier
            .width(300.dp)
            .wrapContentHeight()

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(countryItem.flags.svg)
                        .decoderFactory(SvgDecoder.Factory())
                        .build(),
                    contentDescription = "country flag",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(14.dp))


            Text(
                text = countryItem.name.common,
                fontFamily = beVietnamFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )

            Text(
                text = countryItem.region,
                fontFamily = beVietnamFamily,
                fontWeight = FontWeight.Normal
            )

            Text(
                text = countryItem.subregion,
                fontFamily = beVietnamFamily,
                fontWeight = FontWeight.Normal
            )
        }

    }
}


@Composable
fun InputSection(
    modifier: Modifier,
    keyboardController: SoftwareKeyboardController,
    userQuery: String,
    onUserQueryChanged: (String) -> Unit,
    onSubmit: (String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        OutlinedTextField(
            value = userQuery,
            shape = RoundedCornerShape(8.dp),
            onValueChange = onUserQueryChanged,
            maxLines = 1,
            label = {
                Text(
                    text = "Country Name",
                    fontFamily = beVietnamFamily,
                    fontWeight = FontWeight.Normal
                )
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search,
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    keyboardController.hide()
                }
            ),
            textStyle = TextStyle(
                fontFamily = beVietnamFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Log.d("CHECK", userQuery)

        Button(
            onClick = {
                onSubmit(userQuery)
                keyboardController.hide()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = primary,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .height(52.dp)
                .fillMaxWidth()
        ) {

            Text(
                text = "Get Details",
                fontSize = 16.sp,
                fontFamily = beVietnamFamily,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.width(12.dp))

        }
    }


}
