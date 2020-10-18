package com.example.fliplearn.ui.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fliplearn.R
import com.example.fliplearn.model.Constants
import kotlinx.android.synthetic.main.course_adapter_item.view.*

class viewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

class coursesAdapter(val context: Context): RecyclerView.Adapter<viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = layoutInflater.inflate(R.layout.course_adapter_item,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount() = Constants.coursesAvailable.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.itemView.textView.text = Constants.coursesAvailable.get(position)
        if(position==0){
            holder.itemView.imageView.setImageResource(R.drawable.mathematics)
        }
        else if(position==1){
            holder.itemView.imageView.setImageResource(R.drawable.english)
        }
        else if(position==2){
            holder.itemView.imageView.setImageResource(R.drawable.physics)
        }
        else if(position==3){
            holder.itemView.imageView.setImageResource(R.drawable.chemisty)
        }
        else if(position==4){
            holder.itemView.imageView.setImageResource(R.drawable.biology)
        }
        else if(position==5){
            holder.itemView.imageView.setImageResource(R.drawable.computers)
        }
        else if(position==6){
            holder.itemView.imageView.setImageResource(R.drawable.accountancy)
        }
        else if(position==7){
            holder.itemView.imageView.setImageResource(R.drawable.history)
        }
        else{
            holder.itemView.imageView.setImageResource(R.drawable.business_studies)
        }
        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context,youtubePlayListActivity::class.java))
        }
    }
}