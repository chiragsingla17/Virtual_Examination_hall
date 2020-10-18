package com.example.fliplearn.ui.TestFragment

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fliplearn.R
import com.example.fliplearn.ui.main.viewHolder
import com.example.fliplearn.ui.onlineTestActivity.onlineTestActivity
import kotlinx.android.synthetic.main.chat_item.view.*
import kotlinx.android.synthetic.main.test_item.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class testAdapter(val list: ArrayList<testModel>,val context: Context): RecyclerView.Adapter<viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = layoutInflater.inflate(R.layout.test_item,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.itemView.testTextView.text = list.get(position).testName
        holder.itemView.testImageView.setImageResource(list.get(position).res)
        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context,onlineTestActivity::class.java))
        }
    }
}