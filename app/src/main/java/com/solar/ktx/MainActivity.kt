package com.solar.ktx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.solar.ktx.library.asColor
import com.solar.ktx.library.asDrawable
import com.solar.ktx.library.getValue

class MainActivity : AppCompatActivity() {
    val firstName by getValue<String>("firstName") // String?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val color = R.color.design_default_color_background.asColor()
        val drawable = R.drawable.ic_launcher_background.asDrawable()
    }
}