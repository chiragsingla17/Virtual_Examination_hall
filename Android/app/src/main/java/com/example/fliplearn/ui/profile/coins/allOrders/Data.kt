package com.example.fliplearn.ui.profile.coins.allOrders

import com.example.fliplearn.ui.profile.coins.allOrders.Buyer
import com.example.fliplearn.ui.profile.coins.allOrders.TransactionId

data class Data(
    val _id: String,
    val amount: Int,
    val buyer: Buyer,
    val completed: Boolean,
    val delivery: Int,
    val orderQuantity: List<OrderQuantity>,
    val transactionId: TransactionId
)