package com.learn.myapp_by_oby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.learn.myapp_by_oby.databinding.ActivityDetailedBinding

class detailedActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailedBinding

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val budiyaku = intent.getParcelableExtra<Budidaya>(MainActivity.INTENT_PARCELABLE)
        /*Toast.makeText(this,budiyaku?.description?:"kosong",Toast.LENGTH_SHORT).show()*/
        if (budiyaku != null){

            binding.imageDetail.setImageResource(budiyaku.image)
            binding.tvItemDescriptionDetail.text = budiyaku.description
            binding.tvItemNameDetail.text = budiyaku.nameBudidaya

/*
            val textnamadetail : TextView = findViewById(R.id.tv_item_name_detail)
            val textdeskripsidetal : TextView = findViewById(R.id.tv_item_description_detail)
            val imageDetail : ImageView = findViewById(R.id.image_detail)

            textnamadetail.text = budiyaku.nameBudidaya
            textdeskripsidetal.text = budiyaku.description
            imageDetail.setImageResource(budiyaku.image)*/

        }
        /*val image = findViewById<ImageView>(R.id.image_detail)
        val namabudidaya = findViewById<TextView>(R.id.tv_item_name_detail)
        val deskripsiBudidaya = findViewById<TextView>(R.id.tv_item_description)
        val
*/
        }

    }