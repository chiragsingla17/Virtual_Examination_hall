package com.example.fliplearn.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fliplearn.R
import com.example.fliplearn.model.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.youtube_view_item.view.*


public interface youtube_adapter_interface{
    fun onClick(position: Int)
}

class youtubeViewAdapter(val context: Context,val myInterface : youtube_adapter_interface): RecyclerView.Adapter<viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = layoutInflater.inflate(R.layout.youtube_view_item,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount() = Constants.mathsVideos.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.itemView.youtubeListTextView.text = Constants.mathsTitle.get(position)
        Picasso.get().load("https://img.youtube.com/vi/" + Constants.mathsVideos.get(position) + "/0.jpg").into(holder.itemView.imageView);
        holder.itemView.setOnClickListener {
            myInterface.onClick(position)
        }
    }
}