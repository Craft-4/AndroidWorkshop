package com.drei.androidworkshop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCounter = findViewById<Button>(R.id.main_btn_counter)
        val tvOutput = findViewById<TextView>(R.id.main_tv_output)

        var counter = 0
        btnCounter.setOnClickListener { _ ->
            val btnText = "${resources.getString(R.string.main_btn_count_title)} ${counter++}"
            tvOutput.text = btnText

            AndroidWorkshopApplication.logEvent("Fabian Button Counter", "ButtonClick")
        }

        findViewById<Button>(R.id.main_btn_launch_activity).setOnClickListener { _ ->
            val webIntent = Intent(this, WebActivity::class.java)
            startActivity(webIntent)
        }


        val firstFragment = FirstFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.container, firstFragment, "FirstFragment")

        fragmentTransaction.commit()

    }

}