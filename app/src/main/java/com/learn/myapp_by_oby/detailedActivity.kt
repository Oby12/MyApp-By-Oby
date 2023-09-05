package com.learn.myapp_by_oby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.learn.myapp_by_oby.databinding.ActivityDetailedBinding

class detailedActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailedBinding
    private lateinit var btnShare : Button

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnShare = findViewById(R.id.btn_share)

        btnShare.setOnClickListener{
            shareContent()
        }


        val budiyaku = intent.getParcelableExtra<Budidaya>(MainActivity.INTENT_PARCELABLE)
        /*Toast.makeText(this,budiyaku?.description?:"kosong",Toast.LENGTH_SHORT).show()*/
        if (budiyaku != null){

            binding.imageDetail.setImageResource(budiyaku.image)
            binding.tvItemDescriptionDetail.text = budiyaku.description
            binding.tvItemNameDetail.text = budiyaku.nameBudidaya
            binding.tvPerawatan.text = budiyaku.perawatan
            binding.jenisDetail.text = budiyaku.jenis
            binding.tvTextHabitatDetailLengkap.text = budiyaku.habitat
            binding.tvTextNamaLatin.text = budiyaku.namaLatin

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
    private fun shareContent() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        val content = "Ini adalah konten yang akan Anda bagikan."
        shareIntent.putExtra(Intent.EXTRA_TEXT, content)

        // Membuka dialog berbagi
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }

}