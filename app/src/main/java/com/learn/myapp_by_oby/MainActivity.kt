package com.learn.myapp_by_oby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var rv_budidaya_tanaman : RecyclerView
    private val ListBudidaya = ArrayList<Budidaya>()
    //penggunaan search view
    private lateinit var searchview : SearchView
    private lateinit var adapter: BudidayaAdapter

    //btn_share
    /*private lateinit var btnShare : Button*/

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_budidaya_tanaman = findViewById(R.id.rv_budidaya)
        rv_budidaya_tanaman.setHasFixedSize(true)
        searchview = findViewById(R.id.searchview)
        ListBudidaya.addAll(getListBudidaya())
        showRecyleViewBudidaya()
        adapter = BudidayaAdapter(ListBudidaya)
        rv_budidaya_tanaman.adapter = adapter



        searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

        adapter.onItemClick = {
            val intent = Intent(this,detailedActivity::class.java)
            intent.putExtra("budidayaku",it)
            startActivity(intent)
        }


    }

    private fun filterList(query : String?){
        if (query != null){
            val filtelist = ArrayList<Budidaya>()
            for (i in ListBudidaya){
                if (i.nameBudidaya?.lowercase(Locale.ROOT)?.contains(query) == true) {
                    filtelist.add(i)
                }
            }

            if (filtelist.isEmpty()){
                Toast.makeText(this,"Maaf Data Saat ini Belum Tersedia" , Toast.LENGTH_SHORT).show()
            }else{
                adapter.setFilterList(filtelist)


            }
        }
    }

    private fun getListBudidaya() : ArrayList<Budidaya> {
        val namabudidaya = resources.getStringArray(R.array.data_budidaya)
        val deskripsiBudidaya = resources.getStringArray(R.array.data_description)
        val imageBudidaya = resources.obtainTypedArray(R.array.data_imagebudidaya)
        val perawatan = resources.getStringArray(R.array.data_perawatan)
        val jenis = resources.getStringArray(R.array.data_jenis)
        val habitatku = resources.getStringArray(R.array.habitat_detail)
        val namaLatinku = resources.getStringArray(R.array.data_namaLatin)

        val listBudidayaOby = ArrayList<Budidaya>()
        for (i in namabudidaya.indices){
            val budidayaku = Budidaya(namabudidaya[i],deskripsiBudidaya[i],perawatan[i],jenis[i],habitatku[i],namaLatinku[i],imageBudidaya.getResourceId(i,2))
            ListBudidaya.add(budidayaku)
        }
        return listBudidayaOby
    }

    private fun showRecyleViewBudidaya(){
        rv_budidaya_tanaman.layoutManager = LinearLayoutManager(this)
        val ListBudidayaAdapter = BudidayaAdapter(ListBudidaya)
        rv_budidaya_tanaman.adapter = ListBudidayaAdapter
    }
    //fungsi menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_sear ->{
                val btnAbout = Intent(this@MainActivity, ActivityAbout::class.java)
                startActivity(btnAbout)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}