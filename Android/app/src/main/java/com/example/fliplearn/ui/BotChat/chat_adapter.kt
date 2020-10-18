package com.example.fliplearn.ui.BotChat

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fliplearn.R
import com.example.fliplearn.model.Constants
import com.example.fliplearn.ui.main.viewHolder
import kotlinx.android.synthetic.main.chat_item.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class chatAdapter(val list: ArrayList<String>,val timeList : ArrayList<String>): RecyclerView.Adapter<viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = layoutInflater.inflate(R.layout.chat_item,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        if(position%2==0){
            //It means message is from the bot, therefore hide personTextView
            holder.itemView.personLinearLayout.visibility = View.GONE
            holder.itemView.botLinearLayout.visibility = View.VISIBLE
            holder.itemView.chatBotTextView.text = list.get(position)
            holder.itemView.personTime.text = timeList.get(position)
            holder.itemView.botTimeTextView.text = timeList.get(position)
        }
        else{
            //It means message is from the user
            holder.itemView.botLinearLayout.visibility = View.GONE
            holder.itemView.personLinearLayout.visibility = View.VISIBLE
            holder.itemView.personTextView.text = list.get(position)
            holder.itemView.botTimeTextView.text = timeList.get(position)
            holder.itemView.personTime.text = timeList.get(position)
        }
    }

    fun updateListAdd(s : String){
        var time = ""
        list.add(s)
        //Find current date and time
        val currentTime = Calendar.getInstance().getTime()
        val dateFormat  = SimpleDateFormat("hh:mm a")
        time = time + dateFormat.format(currentTime)
        Log.i("time list",time)
        timeList.add(time)
        Log.i("list size",list.size.toString())
        notifyDataSetChanged()
    }
}