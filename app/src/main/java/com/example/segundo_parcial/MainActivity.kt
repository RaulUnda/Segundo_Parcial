package com.example.segundo_parcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener(this)
    }

    override fun OnClick(view: View){
        val intent = when(view.id){
            R.id.btnStart -> Intent(this, View2::class.java)
            else -> throw IllegalArgumentException("Invalid Button")
        }
        startActivity(intent)
    }
}