package com.example.fliplearn.ui.onlineTestActivity

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fliplearn.R
import com.example.fliplearn.model.onlineTest
import com.example.fliplearn.ui.main.viewHolder
import kotlinx.android.synthetic.main.activity_online_test.*
import kotlinx.android.synthetic.main.activity_online_test.view.*
import kotlinx.android.synthetic.main.chat_item.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList



class onlineTestResultAdapter(val list: ArrayList<onlineTest>, val markedOptions : ArrayList<Int>?): RecyclerView.Adapter<viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = layoutInflater.inflate(R.layout.online_test_result_item,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount() = list.size

    fun getView(position: Int, view1 : View,view2 : View ,view3 : View,view4 : View) : View{
        if(position==1){
            return view1
        }
        else if(position==2){
            return view2
        }
        else if(position==3){
            return view3
        }
        else{
            return view4
        }
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        holder.itemView.option1.text = "1. " + list.get(position).option1
        holder.itemView.option1.setBackgroundResource(R.drawable.rectangle_border)
        holder.itemView.option2.text = "2. " + list.get(position).option2
        holder.itemView.option2.setBackgroundResource(R.drawable.rectangle_border)
        holder.itemView.option3.text = "3. " + list.get(position).option3
        holder.itemView.option3.setBackgroundResource(R.drawable.rectangle_border)
        holder.itemView.option4.text = "4. " + list.get(position).option4
        holder.itemView.option4.setBackgroundResource(R.drawable.rectangle_border)
        holder.itemView.questionTextView.text = "${position+1}) " + list.get(position).question

        if(list.get(position).correctOption==markedOptions!!.get(position)){
            val reqView = getView(list.get(position).correctOption,holder.itemView.option1,holder.itemView.option2,holder.itemView.option3,holder.itemView.option4)
            //00FF00
            reqView.setBackgroundColor(Color.parseColor("#00FF00"))
        }
        else{
            val correctAnsView = getView(list.get(position).correctOption,holder.itemView.option1,holder.itemView.option2,holder.itemView.option3,holder.itemView.option4)
            val wrongAnsView = getView(markedOptions!!.get(position),holder.itemView.option1,holder.itemView.option2,holder.itemView.option3,holder.itemView.option4)
            correctAnsView.setBackgroundColor(Color.parseColor("#00FF00"))
            wrongAnsView.setBackgroundColor(Color.parseColor("#FF0000"))
        }
    }
}