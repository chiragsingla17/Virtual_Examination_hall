package com.example.fliplearn.ui.BotChat

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fliplearn.R
import com.example.fliplearn.model.Constants
import kotlinx.android.synthetic.main.activity_chat_bot.*

class ChatBotActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_bot)

        val list = ArrayList<String>()
        val timeList = ArrayList<String>()
        chatBotRecylerView.layoutManager = LinearLayoutManager(this)
        val adapter = chatAdapter(list,timeList)
        chatBotRecylerView.adapter = adapter

        adapter.updateListAdd(Constants.botAnswers.get(0))
        var size = 1

        sendButton.setOnClickListener {
            val text = textMessageBox.text.toString()
            if(!text.isEmpty()){
                adapter.updateListAdd(text)
                chatBotRecylerView.smoothScrollToPosition(size);
                size++;
                textMessageBox.setText("")
                myGif.visibility = View.VISIBLE
                Handler().postDelayed(object : Runnable{
                    override fun run() {
                        myGif.visibility = View.GONE
                        adapter.updateListAdd(Constants.botAnswers.get(size))
                        chatBotRecylerView.smoothScrollToPosition(list.size);
                        size++;
                    }
                },1000)
            }
        }
    }
}