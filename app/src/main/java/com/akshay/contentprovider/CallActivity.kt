package com.akshay.contentprovider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.CallLog
import android.provider.ContactsContract
import android.widget.SimpleCursorAdapter
import kotlinx.android.synthetic.main.activity_call.*

class CallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)

        var call = contentResolver
        var c = call.query(CallLog.Calls.CONTENT_URI, null, null, null, null)
        var mya = SimpleCursorAdapter(this,R.layout.cview,c, arrayOf(CallLog.Calls.DURATION,CallLog.Calls.NUMBER), intArrayOf(R.id.tv1,R.id.tv2),0)
        lv.adapter = mya
    }
}
