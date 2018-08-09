package com.akshay.contentprovider

import android.content.ContentProvider
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import android.widget.SimpleCursorAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cp = contentResolver
        var c = cp.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
        var mya = SimpleCursorAdapter(this@MainActivity,R.layout.cview,c, arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER), intArrayOf(R.id.tv1,R.id.tv2),0 )
        lv.adapter = mya

        ///// all data is shown on list

        val list = mutableListOf<String>()
        while(c.moveToNext()) {
            val index = c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            list.add(c.getString(index))
        }

        /// got list with contact names

        var myad = ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,list)
        actv.setAdapter(myad)
        actv.threshold = 1

        /// set contact names to the AutocompleteTextview


        b1.setOnClickListener {
            var cp = contentResolver
            var c = cp.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME+"=?", arrayOf(actv.text.toString()),ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            var mya = SimpleCursorAdapter(this@MainActivity,R.layout.cview,c, arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER), intArrayOf(R.id.tv1,R.id.tv2),0 )
            lv.adapter = mya


        }
    }
}
