package com.learn.myapp_by_oby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learn.myapp_by_oby.databinding.ActivityAboutBinding

class ActivityAbout : AppCompatActivity() {
    private lateinit var  binding: ActivityAboutBinding

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val aboutme = intent.getParcelableExtra<AboutBobby>(MainActivity.INTENT_PARCELABLE)
        if(aboutme != null){
            binding.imageDetail.setImageResource(R.drawable.oby)
            binding.myname.text = aboutme.nama
            binding.email.text = aboutme.email
        }
    }
}