package com.akshay.contentprovider


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contact.setOnClickListener {
            val i= Intent(this,ContactActivity::class.java)
            startActivity(i)
        }

        msz.setOnClickListener {
            val i= Intent(this,MessageActivity::class.java)
            startActivity(i)
        }

        call.setOnClickListener {
            val i= Intent(this,CallActivity::class.java)
            startActivity(i)
        }

    }
}
