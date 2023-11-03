package com.example.pocasi

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            val savedDayText = savedInstanceState.getString("dayText")
            val dayTextView = findViewById<TextView>(R.id.dayTextView)
            dayTextView.text = savedDayText
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val dayTextView = findViewById<TextView>(R.id.dayTextView)
        outState.putString("dayText", dayTextView.text.toString())
    }

    fun onCardClick(view: View) {
        val dayTextView = findViewById<TextView>(R.id.dayTextView)
        val tomorrowDayTextView = findViewById<TextView>(R.id.tomorrowDayTextView)
        val dayAfterTextView = findViewById<TextView>(R.id.dayAfterTextView)

        when (view.id) {
            R.id.cardViewTomorrow -> {
                val tempText = dayTextView.text
                dayTextView.text = tomorrowDayTextView.text
                tomorrowDayTextView.text = tempText
            }
            R.id.cardViewDayAfter -> {
                val tempText = dayTextView.text
                dayTextView.text = dayAfterTextView.text
                dayAfterTextView.text = tempText
            }
        }
    }
}
