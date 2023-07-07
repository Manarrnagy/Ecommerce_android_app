package com.example.ecommerce_android_app.ui.theme.screens.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import com.example.ecommerce_android_app.R
import com.example.ecommerce_android_app.ui.theme.screens.home.HomeActivity

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed(
            object:Runnable{
                override fun run() {
                    val intent = Intent(this@SplashActivity, HomeActivity::class.java)
                    startActivity(intent)
                }
            },
            2000)
    }
//        setContent {
//            Ecommerce_android_appTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//        }


}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Ecommerce_android_appTheme {
//        Greeting("Android")
//    }
//}