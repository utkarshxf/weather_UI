package com.example.weather_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_ui.ui.theme.DarkBlue
import com.example.weather_ui.ui.theme.LightGray
import com.example.weather_ui.ui.theme.VeryLightGray
import com.example.weather_ui.ui.theme.Weather_UITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Weather_UITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeatherPage()
                }
            }
        }
    }
}

@Composable
fun WeatherPage() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 64.dp, start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        headerImage()
        MainInfo()
        InfoTable()

    }
}

@Composable
fun InfoTable() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(
                VeryLightGray
            )
    ) {
        Row(Modifier.padding(16.dp)){
            InfoItem(
                iconRes = R.drawable.ic_humidity,
                title = "Humidity",
                sustitle = "85%",
                modifier = Modifier.weight(1f)
            )
            InfoItem(
                iconRes = R.drawable.ic_sun_full,
                title = "UV Index",
                sustitle = "2 of 10",
                modifier = Modifier.weight(1f)
            )
        }
        Divider(color = LightGray)
        Row(Modifier.padding(16.dp)) {
            InfoItem(
                iconRes = R.drawable.ic_sun_full,
                title = "Sunrise",
                sustitle = "7:30 AM",
                modifier = Modifier.weight(1f)
            )
            InfoItem(
                iconRes = R.drawable.ic_sun_half,
                title = "Sunset",
                sustitle = "4:28 PM",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun InfoItem(iconRes:Int,title:String,sustitle:String,modifier: Modifier) {
    Row(modifier = modifier) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 8.dp)
                .width(40.dp)
        )
        Column() {
            Text(title, color = Color.Gray)
            Text(sustitle, color = Color.DarkGray, fontWeight = FontWeight.Bold)
        }
    }

}

@Composable
fun headerImage(){
    Image(
        painter = painterResource(id = R.drawable.ic_couple),
        contentDescription = null,
        modifier = Modifier.width(200.dp)
    )
}

@Composable
fun MainInfo() {
    Column(
        modifier = Modifier.padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "11°", color = DarkBlue, fontSize = 48.sp, fontWeight = FontWeight.Bold)
        Text(
            text = "New York City,NY",
            color = DarkBlue,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "Rainy to partly cloudy.\nWinds WSW at 10 to 15 km/h",
            color = Color.Gray,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 24.dp)
        )
    }
}
@Preview(showBackground = true, widthDp = 300, heightDp = 800)
@Composable
fun GreetingPreview() {
    Weather_UITheme {
        WeatherPage()
    }
}