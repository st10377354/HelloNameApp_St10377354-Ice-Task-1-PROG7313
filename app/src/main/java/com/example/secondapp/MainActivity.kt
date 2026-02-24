package com.example.secondapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 1. Initialize the Views using the IDs from your XML
        val edtName = findViewById<EditText>(R.id.edtName)
        val btnClick = findViewById<Button>(R.id.btnClick)
        val btnClear = findViewById<Button>(R.id.btnclear)
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)

        // 2. Set up the Submit Button logic
        btnClick.setOnClickListener {
            val name = edtName.text.toString()
            if (name.isNotEmpty()) {
                txtDisplay.text = "Hello, $name!"
            } else {
                txtDisplay.text = "Please enter a name"
            }
        }

        // 3. Set up the Clear Button logic
        btnClear.setOnClickListener {
            edtName.text.clear()
            txtDisplay.text = ""
        }

        // Window Insets (keep this for edge-to-edge support)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}