package com.example.janken

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val id = intent.getIntExtra("MY_HAND", 0)

        when (id) {
            R.id.gu -> myHandImage.setImageResource(R.drawable.gu)
            R.id.choki -> myHandImage.setImageResource(R.drawable.choki)
            R.id.pa -> myHandImage.setImageResource(R.drawable.pa)
        }
        gu.setOnClickListener { onJankenButttonTapped(it) }
        choki.setOnClickListener { onJankenButttonTapped(it) }
        pa.setOnClickListener { onJankenButttonTapped(it) }

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.edit {
            clear()
        }

    }

    fun onJankenButttonTapped(view: View?) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("MY_HAND", view?.id)
        startActivity(intent)
    }
}
