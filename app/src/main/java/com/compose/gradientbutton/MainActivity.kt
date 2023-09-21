package com.compose.gradientbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.gradientbutton.ui.theme.GradientButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GradientButtonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize() ,
                    color = MaterialTheme.colorScheme.background
                )
                Column( modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    val cornerRadius = 16.dp
                    Spacer(modifier = Modifier.height(8.dp))

                    //pink and dark pink
                    val gradientColor = listOf(Color(0xFFff00cc), Color(0xFF333399))
                    GradientButton(
                        gradientColors = gradientColor,
                        cornerRadius = cornerRadius,
                        nameButton = "Style: top Start",
                        roundedCornerShape = RoundedCornerShape(topStart = 30.dp)
                    )

                    //light yellow and dark yellow
                    val gradientColor2 = listOf(Color(0xFFFDEB71), Color(0xFFF8D800))
                    GradientButton(
                        gradientColors = gradientColor2,
                        cornerRadius = cornerRadius,
                        nameButton = "Style: top End",
                        roundedCornerShape = RoundedCornerShape(topEnd = 30.dp)
                    )

                    //blue and dark blue
                    val gradientColor3 = listOf(Color(0xFFABDCFF), Color(0xFF0396FF))
                    GradientButton(
                        gradientColors = gradientColor3,
                        cornerRadius = cornerRadius,
                        nameButton = "Style: top End",
                        roundedCornerShape = RoundedCornerShape(bottomStart = 30.dp)
                    )

                    //orange and dark orange
                    val gradientColor4 = listOf(Color(0xFFFEB692), Color(0xFFEA5455))
                    GradientButton(
                        gradientColors = gradientColor4,
                        cornerRadius = cornerRadius,
                        nameButton = "Style: top End",
                        roundedCornerShape = RoundedCornerShape(bottomEnd = 30.dp)
                    )

                    //lavender and dark lavender
                    val gradientColor5 = listOf(Color(0xFFCE9FFC), Color(0xFF7367F0))
                    GradientButton(
                        gradientColors = gradientColor5,
                        cornerRadius = cornerRadius,
                        nameButton = "Style: top End",
                        roundedCornerShape = RoundedCornerShape(topStart = 30.dp , bottomEnd = 30.dp)
                    )

                    //cyan and dark cyan
                    val gradientColor6 = listOf(Color(0xFF90F7EC), Color(0xFF32CCBC))
                    GradientButton(
                        gradientColors = gradientColor6,
                        cornerRadius = cornerRadius,
                        nameButton = "Style: top End",
                        roundedCornerShape = RoundedCornerShape(bottomStart = 30.dp, topEnd = 30.dp)
                    )

                    //dark cyan and blue
                    val gradientColor7 = listOf(Color(0xFF2AFADF), Color(0xFF4C83FF))
                    GradientButton(
                        gradientColors = gradientColor7,
                        cornerRadius = cornerRadius,
                        nameButton = "Style: top End",
                        roundedCornerShape = RoundedCornerShape(topStart = 30.dp , bottomEnd = 30.dp,bottomStart = 30.dp, topEnd = 30.dp)
                    )

                    //cyan and dark cyan
                    val gradientColor8 = listOf(Color(0xFF90F7EC), Color(0xFF32CCBC))
                    GradientButton(
                        gradientColors = gradientColor8,
                        cornerRadius = cornerRadius,
                        nameButton = "Disabled Button",
                        roundedCornerShape = RoundedCornerShape(bottomStart = 30.dp, topEnd = 30.dp)
                    )

                    //Normal Cyan
                    val gradientColor9 = listOf(Color(0xFF65FDF0), Color(0xFF1D6FA3))
                    GradientButton(
                        gradientColors = gradientColor9,
                        cornerRadius = cornerRadius,
                        nameButton = "No Ripple",
                        roundedCornerShape = RoundedCornerShape(bottomStart = 30.dp, topEnd = 30.dp)
                    )
                }
            }
        }
    }

    private fun Surface(modifier: Modifier , color: Color) {

    }
}

@Composable
fun Greeting(name: String , modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!" ,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GradientButtonTheme {
        Greeting("Android")
    }
}

@Composable
private fun GradientButton(
    gradientColors: List<Color> ,
    cornerRadius: Dp ,
    nameButton: String ,
    roundedCornerShape: RoundedCornerShape
) {

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp , end = 32.dp),
        onClick = {
            //your code
        },

        contentPadding = PaddingValues() ,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(cornerRadius)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(colors = gradientColors) ,
                    shape = roundedCornerShape
                )
                .clip(roundedCornerShape)
                /*.background(
                    brush = Brush.linearGradient(colors = gradientColors),
                    shape = RoundedCornerShape(cornerRadius)
                )*/
                .padding(horizontal = 16.dp , vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = nameButton,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}