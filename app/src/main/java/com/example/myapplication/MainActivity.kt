package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils.substring
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.Nullable
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ru1 = findViewById<Button>(R.id.ru1)
        val ru2 = findViewById<Button>(R.id.ru2)
        val do1 = findViewById<Button>(R.id.do1)
        val do2 = findViewById<Button>(R.id.do2)
        val eu1 = findViewById<Button>(R.id.fu1)
        val eu2 = findViewById<Button>(R.id.fu2)
        val done = findViewById<Button>(R.id.buttonDone)

        val textView = findViewById<TextView>(R.id.textView)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val textView3 = findViewById<TextView>(R.id.textView3)
        val inputText = findViewById<EditText>(R.id.inputText)

        var from = "ru"
        var to = "do"
        var output = 0.0

        ru1.setOnClickListener {
            from = "ru"
            textView.text = "Рубль"
        }

        do1.setOnClickListener {
            from = "do"
            textView.text = "Доллар"
        }
        eu1.setOnClickListener {
            from = "eu"
            textView.text = "Евро"
        }

        ru2.setOnClickListener {
            to = "ru"
            textView2.text = "Рубль"
        }

        do2.setOnClickListener {
            to = "do"
            textView2.text = "Доллар"
        }

        eu2.setOnClickListener {
            to = "eu"
            textView2.text = "Евро"
        }

        done.setOnClickListener{
            val input = inputText.text.toString().toDouble()
            when (from){
                "do" -> when (to) {
                    "do" -> output = input
                    "ru" -> output = input * 74
                    "eu" -> output = input * 0.88
                }
                "ru" -> when (to) {
                    "do" -> output = input / 74
                    "ru" -> output = input
                    "eu" -> output = input / 78
                }
                "eu" -> when (to) {
                    "do" -> output = input / 0.88
                    "ru" -> output = input * 78
                    "eu" -> output = input
                }
            }
            output = output.toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
            textView3.text = output.toString()
        }
    }
}
