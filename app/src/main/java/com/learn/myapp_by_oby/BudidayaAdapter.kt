package com.learn.myapp_by_oby

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BudidayaAdapter(private var ListBudidaya : ArrayList<Budidaya>) : RecyclerView.Adapter<BudidayaAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    var onItemClick : ((Budidaya) -> Unit)? = null

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgbudidaya : ImageView =itemView.findViewById(R.id.img_item_budidaya)
        val namaBudidaya : TextView = itemView.findViewById(R.id.tv_item_name_tanaman)
        val deskripsiTanaman : TextView = itemView.findViewById(R.id.tv_item_description)

    }

    fun setFilterList(ListBudidaya:ArrayList<Budidaya>){
        this.ListBudidaya = ListBudidaya
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_budidaya,parent, false)
        return  ListViewHolder(view)
    }

    override fun getItemCount(): Int =ListBudidaya.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description,perawatan,jenis,habitat,namaLatin,image) = ListBudidaya[position]
        holder.namaBudidaya.text =name
        holder.deskripsiTanaman.text = description
        holder.imgbudidaya.setImageResource(image)


        //pembuatan detail
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, detailedActivity::class.java)
            intentDetail.putExtra("OBJECT_INTENT", ListBudidaya[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
            //onItemClick?.invoke(Budidaya(name,description,image))

            /*holder.itemView.setOnClickListener {
                val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
                intentDetail.putExtra("key_hero", listHero[holder.adapterPosition])
                holder.itemView.context.startActivity(intentDetail)
            }*/
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Budidaya)
    }
}
