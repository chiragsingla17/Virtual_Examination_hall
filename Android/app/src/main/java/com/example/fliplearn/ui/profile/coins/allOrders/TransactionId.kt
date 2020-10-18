package com.example.fliplearn.ui.profile.coins.allOrders

data class  TransactionId(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val order: String,
    val paidAmount: Int,
    val receiptNumber: Int,
    val sessionId: String,
    val updatedAt: String
)