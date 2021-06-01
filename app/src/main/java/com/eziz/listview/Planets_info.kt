package com.eziz.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_planets_info.*

class Planets_info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planets_info)

        var bundle: Bundle = intent.extras!!
        var name = bundle.getString("constName")
        var info = bundle.getString("constInfo")
        var picture = bundle.getInt("constPicture")

        info_name.text = name
        info_info.text = info
        info_image.setImageResource(picture)
    }
}