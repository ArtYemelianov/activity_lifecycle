package com.launchmode.artus.launchmode

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

/**
 * Created by artus on 19.07.2018.
 */
abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAGG", javaClass.toString() + "  onCreate "  + toString())
        setContentView(R.layout.activity_main)

        val list: ListView = findViewById(R.id.listview_id)


        val adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_activated_1,
                arrayOf("Default One", "Default Two", "SingleTop", "SingleTask", "SingleInstance"))
        list.adapter = adapter
        list.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            if (position == 0) {
                onStandartOneClicked()
            } else if (position == 1) {
                onStandartTwoClicked()
            } else if (position == 2) {
                onSingleTopClicked()
            } else if (position == 3) {
                onSingleTaskClicked()
            } else if (position == 4) {
                onSingleInstanceClicked()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAGG", javaClass.toString() + " onResume  " + toString())
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAGG", javaClass.toString() + " onPause " + toString())
    }


    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        Log.d("TAGG", javaClass.toString() + " onPostCreate  " + toString())
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAGG", javaClass.toString() + " onStart  " + toString())
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAGG", javaClass.toString() + " onStop " + toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAGG", javaClass.toString() + " onDestroy " + toString())
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("TAGG", javaClass.toString() + " onNewIntent")
    }

    fun onSingleInstanceClicked() {
        var intent = Intent(this, SingleInstanceActivity::class.java)
        startActivity(intent)
    }

    fun onSingleTaskClicked() {
        var intent = Intent(this, SingleTaskActivity::class.java)
        startActivity(intent)
    }

    fun onStandartOneClicked() {
        var intent = Intent(this, StandartActivity::class.java)
        intent.putExtra("name", "One")
        startActivity(intent)
    }

    fun onStandartTwoClicked() {
        var intent = Intent(this, StandartActivity::class.java)
        intent.putExtra("name", "Two")
        startActivity(intent)
    }

    fun onSingleTopClicked() {
        var intent = Intent(this, SingleTopActivity::class.java)
        startActivity(intent)
    }
}