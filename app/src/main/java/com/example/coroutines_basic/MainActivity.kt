package com.example.coroutines_basic

import android.annotation.SuppressLint
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
      private  val  TAG : String = "KOTLINFUN"
    lateinit var Number : TextView
    lateinit var Btn_increment : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Number = findViewById(R.id.Number)
        Btn_increment = findViewById(R.id.Btn_increment)

       Btn_increment.setOnClickListener {
          updatecounter(view = it)
           Log.d(TAG, Thread.currentThread().name)
       }

        Btn_longtask.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                Log.d(TAG , "1-${Thread.currentThread().name}")
            }

            GlobalScope.launch (Dispatchers.Main){
                Log.d(TAG , "2-${Thread.currentThread().name}")

            }

            MainScope().launch(Dispatchers.Default) {
                Log.d(TAG , "3-${Thread.currentThread().name}")

            }



        }
    }


    @SuppressLint("SetTextI18n")
    private fun updatecounter(view: View) {
        Number.text = "${Number.text.toString().toInt() + 1}"
        Log.d(TAG, Thread.currentThread().name)
    }


    fun longruningtask():Unit {

        for (i in 0 until 1000000000L){

        }

    }


  }