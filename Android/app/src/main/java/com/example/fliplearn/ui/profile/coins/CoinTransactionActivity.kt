package com.example.fliplearn.ui.profile.coins

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fliplearn.R
import com.example.fliplearn.utils.FunctionUtils
import kotlinx.android.synthetic.main.activity_coin_transaction.*

class CoinTransactionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_transaction)
        supportActionBar!!.title = "Your Coins"
        initData()
        swipe_wallet.setOnRefreshListener {
            initData()
        }
    }

    private fun initData() {
        initRecycler(listOf(10, 40, 500, 100, 80, 10, 800, 50, 38, 17), FunctionUtils().getTransactionMethod())
        setBalance(11635)
        swipe_wallet.isRefreshing = false
    }

    @SuppressLint("SetTextI18n")
    private fun setBalance(body: Int) {
        tvBalance.text = body.toString()
    }

    private fun initRecycler(body: List<Int>, transactionMethod: List<String>) {


        rvTransactions.adapter = CoinsAdapter(body,transactionMethod, this)
        rvTransactions.layoutManager = LinearLayoutManager(this)
    }
}