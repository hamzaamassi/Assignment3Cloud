package com.example.assignment3cloud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignment3cloud.databinding.ActivityMainBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.FirebaseAnalytics.Param
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var analytics: FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        analytics = Firebase.analytics

        binding.btn1.setOnClickListener {
            selectContentEvent("image1","imageView","image")
        }
        binding.btn2.setOnClickListener {
            trackScreenEvent()
        }
    }

    private fun trackScreenEvent() {
        analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW){
            param(Param.SCREEN_NAME,"main")
            param(Param.SCREEN_CLASS,"MainActivity")
        }
    }

    private fun selectContentEvent(id: String, name: String, contentType: String) {
        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT) {
            param(Param.ITEM_ID, id)
            param(Param.ITEM_NAME, name)
            param(Param.CONTENT_TYPE, contentType)

        }
    }


}
