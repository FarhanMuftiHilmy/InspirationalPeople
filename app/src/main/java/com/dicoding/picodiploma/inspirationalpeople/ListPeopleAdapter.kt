package com.dicoding.picodiploma.inspirationalpeople

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListPeopleAdapter(private val listPeople: ArrayList<People>) :

    RecyclerView.Adapter<ListPeopleAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    //this setonitemclickcallback is basic itemonclicklistener
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_people, viewGroup, false)
        return ListViewHolder(view)
    }
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val people = listPeople[position]
        Glide.with(holder.itemView.context)
            .load(people.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = people.name
        holder.tvInfo.text = people.info
        //this holder is basic itemonclicklistener
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listPeople[holder.adapterPosition])

        }

    }


    override fun getItemCount(): Int {
        return listPeople.size
    }
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvInfo: TextView = itemView.findViewById(R.id.tv_item_info)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

    }

    //this interface is basic itemonclicklistener
    interface OnItemClickCallback {
        fun onItemClicked(data: People)

    }
}
