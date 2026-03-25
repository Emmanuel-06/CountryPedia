package com.example.countrypedia.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.countrypedia.data.model.CountryInfoItem
import com.example.countrypedia.ui.theme.beVietnamFamily
import com.example.countrypedia.ui.theme.primary
import com.example.countrypedia.ui.viewmodel.CountryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    popBackStack: () -> Unit,
    countryViewModel: CountryViewModel = hiltViewModel(),
    countryId: String,
) {
    val countryInfoState = countryViewModel.countryInfo.collectAsState()

    val countryInfo = countryInfoState.value.data?.get(0)

    LaunchedEffect(key1 = countryId) {
        countryViewModel.getCountryInfo(countryId)
    }

//    val countryDetail = countryInfo?.filter { country ->
//        country.name.common == countryId
//    }


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Country Details",
                        fontFamily = beVietnamFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = popBackStack,
                        Modifier
                            .padding(start = 8.dp)

                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
                            contentDescription = null,
                            Modifier.size(36.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = primary,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },
        containerColor = Color.Black.copy(alpha = 0.03f)
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .height(70.dp)
                .background(primary)
        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(paddingValues)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.SpaceAround
        ){
            Column(
                modifier = Modifier
                    .wrapContentHeight()
            ) {
                countryInfo?.let {
                    CountryDetailsHeaderCard(
                        countryItem = countryInfo
                    )
                    BodyContent(countryItem = countryInfo)
                }
            }
            Spacer(modifier = Modifier.height(18.dp))

            Button(
                onClick = {
                    popBackStack()
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
                    text = "Go Back",
                    fontSize = 16.sp,
                    fontFamily = beVietnamFamily,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.width(12.dp))

            }
        }
    }
}


@Composable
fun CountryDetailsHeaderCard(
    countryItem: CountryInfoItem,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = modifier
            .padding(vertical = 24.dp)
            .height(100.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 45.dp,
                spotColor = Color.Black.copy(0.6f),
                shape = RoundedCornerShape(8.dp),
                clip = true
            )
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier.padding(18.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f)
            ) {
                Text(
                    text = countryItem.name.common,
                    fontFamily = beVietnamFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Text(
                    text = countryItem.capital[0],
                    fontFamily = beVietnamFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            }

            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(countryItem.flags.svg)
                    .decoderFactory(SvgDecoder.Factory())
                    .build(),
                contentDescription = "country flag",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}


@Composable
fun BodyContent(
    modifier: Modifier = Modifier,
    countryItem: CountryInfoItem,
) {
    val countryBodyDetails = listOf(
        "Continent" to countryItem.continents[0],
        "Region" to countryItem.region,
//        "Languages" to countryItem.languages[0],
//        "Currencies" to countryItem.currencies.NGN,
        "Denonyms(Female)" to countryItem.demonyms.eng.f,
        "Denonyms(Male)" to countryItem.demonyms.eng.m,
        "Population" to countryItem.population.toString(),
        "Timezones" to countryItem.timezones[0],
        "Sub Region" to countryItem.subregion,
    )


    Column {
        countryBodyDetails.forEach {
            BodyContentItem(
                label = it.first,
                value = it.second,
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(8.dp))

            HorizontalDivider(
                modifier
                    .height(1.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}


@Composable
fun BodyContentItem(
    label: String,
    value: String,
    modifier: Modifier,
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        Text(
            text = label.uppercase(),
            fontFamily = beVietnamFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = Color.Black.copy(0.4f)
        )
        Text(
            text = value,
            fontFamily = beVietnamFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}