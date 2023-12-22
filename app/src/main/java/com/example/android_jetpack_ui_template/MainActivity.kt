package com.example.android_jetpack_ui_template

import android.os.Bundle
import android.view.WindowInsets.Side
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_jetpack_ui_template.ui.Grid
import com.example.android_jetpack_ui_template.ui.SideMenu
import com.example.android_jetpack_ui_template.ui.components.AccordionMenu
import com.example.android_jetpack_ui_template.ui.components.ButtonOrBar
import com.example.android_jetpack_ui_template.ui.theme.Android_jetpack_ui_templateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_jetpack_ui_templateTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                    StackViewAnimation()
//                    SwiperTab()
//                    AccordionMenu()
//                    ButtonOrBar()
//                      Grid()
                    SideMenu()
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Android_jetpack_ui_templateTheme {
        Greeting("Android")
    }
}