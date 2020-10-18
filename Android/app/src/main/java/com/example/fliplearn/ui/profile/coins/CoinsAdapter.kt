package com.example.fliplearn.ui.profile.coins

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fliplearn.R
import com.example.fliplearn.utils.FunctionUtils

class CoinsAdapter(
    private val info: List<Int>,
    val transactionMethod: List<String>,
    private val context: Context
) :
    RecyclerView.Adapter<CoinsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvInfo = itemView.findViewById<TextView>(R.id.tvtransaction_info)
        val tvTime = itemView.findViewById<TextView>(R.id.tvTime)
        val tvMoney = itemView.findViewById<TextView>(R.id.tvPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinsAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.coin_transaction_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return info.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CoinsAdapter.ViewHolder, position: Int) {
        holder.tvInfo.text =
            FunctionUtils().getTransactionMethod()[FunctionUtils().getRandomNumber(0,10)]
        holder.tvMoney.text = info[position].toString()
        holder.tvTime.text = System.currentTimeMillis().toString()
    }
}