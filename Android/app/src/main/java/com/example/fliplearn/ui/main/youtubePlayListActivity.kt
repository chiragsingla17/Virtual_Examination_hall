package com.example.fliplearn.ui.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fliplearn.R
import com.example.fliplearn.model.Constants
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import kotlinx.android.synthetic.main.activity_youtube_play_list.*
import java.util.*


class youtubePlayListActivity : YouTubeBaseActivity(){

    private val playbackEventListener = object : YouTubePlayer.PlaybackEventListener {
        override fun onBuffering(arg0: Boolean) {}
        override fun onPaused() {}
        override fun onPlaying() {
            Log.i("PUI","PLAYING")
        }
        override fun onSeekTo(arg0: Int) {}
        override fun onStopped() {}
    }
    private val playerStateChangeListener = object : YouTubePlayer.PlayerStateChangeListener {

        override fun onAdStarted() {}
        override fun onError(arg0: YouTubePlayer.ErrorReason) {
            Log.i("PUI","error $arg0")
        }
        override fun onLoaded(arg0: String) {}
        override fun onLoading() {}
        override fun onVideoEnded() {}
        override fun onVideoStarted() {}

    }


    fun initializeCurrentYoutube(youTubePlayerView: YouTubePlayerView,videoKey : String){
        youTubePlayerView.initialize(Constants.youtubeAPIKEY,object : YouTubePlayer.OnInitializedListener{
            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
                Toast.makeText(applicationContext,"Error in loading the video",Toast.LENGTH_SHORT).show()
            }
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {
                p1?.setPlayerStateChangeListener(playerStateChangeListener)
                p1?.setPlaybackEventListener(playbackEventListener)
                p1?.loadVideo(videoKey)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube_play_list)

        /**
         * Initializing current video
         */
        val videoKey = intent.getIntExtra("videoKey",0)

        initializeCurrentYoutube(youtubeView,Constants.mathsVideos.get(videoKey))


//        titleTextView.text = Constants.mathsTitle.get(videoKey)
//        expand_text_view.text = "DESCRIPTION\n${Constants.mathsDesc.get(videoKey)}\n"
//        val descriptionLength = Constants.mathsDesc.get(videoKey).length
//        val spannableText = SpannableString(expand_text_view.text)
//        spannableText.setSpan(RelativeSizeSpan(2f),0,descriptionLength,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//        spannableText.setSpan(ForegroundColorSpan(Color.BLUE),0,descriptionLength,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//        expand_text_view.text = spannableText

        /**
         * Initializing the adapter for down adapter
         */
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = youtubeViewAdapter(this,object : youtube_adapter_interface{
            override fun onClick(position: Int) {
                val intent = Intent(applicationContext,youtubePlayListActivity::class.java)
                intent.putExtra("videoKey",position)
                startActivity(intent)
                finish()
            }
        })
    }
}