package com.example.android_jetpack_ui_template


import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
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
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.android_jetpack_ui_template.CAMERA.Image
import com.example.android_jetpack_ui_template.Sencer.Sencer
import com.example.android_jetpack_ui_template.Service.StartBtn
import com.example.android_jetpack_ui_template.ui.Grid
import com.example.android_jetpack_ui_template.ui.SideMenu
import com.example.android_jetpack_ui_template.ui.components.AccordionMenu
import com.example.android_jetpack_ui_template.ui.components.Blink
import com.example.android_jetpack_ui_template.ui.components.ButtonOrBar
import com.example.android_jetpack_ui_template.ui.components.WebView
import com.example.android_jetpack_ui_template.ui.theme.Android_jetpack_ui_templateTheme

//バッテリー残量
//wi-fiかモバイルネット
//カルーセル
//Canvas グラフ
//Animation SVG
//Animation Compose
//Splash Screen
//ICON
//USB 転送周り

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        スプラッシュスクリーン https://shapeshifter.design/
        installSplashScreen()
//        Service
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
//                0
//            )
//        }

//        CAMERAX
//        if (!hasRequiredPermissions()){
//            ActivityCompat.requestPermissions(
//                this, CAMERA_PERMISSIONS, 0
//            )
//        }
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
//                    Grid()
//                    SideMenu()
//                    StartBtn(startService =  {
//                        startService(it)
//                    })
//                    Blink()
//                      Sencer() // センサーリスト
//                     Image()
                     WebView()

                }

            }
        }
    }

//    CAMERAX
    private fun hasRequiredPermissions(): Boolean {
        return CAMERA_PERMISSIONS.all {
            ContextCompat.checkSelfPermission(
                applicationContext,
                it
            ) == PackageManager.PERMISSION_GRANTED
        }
    }
//CAMERAX
    companion object {
        private val CAMERA_PERMISSIONS = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO
        )
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