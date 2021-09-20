package com.solar.ktx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.solar.ktx.library.component.getValue
import com.solar.ktx.library.component.intentToCall
import com.solar.ktx.library.component.requestLocationPermission
import com.solar.ktx.library.component.start

class MainActivity : AppCompatActivity() {
    val firstName by getValue<String>("firstName") // String?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val color = R.color.design_default_color_background.asColor()
        val drawable = R.drawable.ic_launcher_background.asDrawable()


        requestLocationPermission(0)

        intentToCall("010-1234-5678")
        start<MainActivity>("t" to 2)
        
        start<MainActivity>()
    }
}