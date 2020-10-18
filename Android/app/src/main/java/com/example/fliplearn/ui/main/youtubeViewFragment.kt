package com.example.fliplearn.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.example.fliplearn.R
import com.example.fliplearn.model.Constants
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import kotlinx.android.synthetic.main.fragment_youtube_view.*
import kotlinx.android.synthetic.main.fragment_youtube_view.view.*


class youtubeViewFragment : Fragment() {

    private val API_KEY = Constants.youtubeAPIKEY
    private val VIDEO_ID = "8PTOkwze0Vw"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView =  inflater.inflate(R.layout.fragment_youtube_view, container, false)

//        rootView.youtube_view.initialize(API_KEY,object : YouTubePlayer.OnInitializedListener{
//            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {
//                p1?.loadVideo(VIDEO_ID);
//            }
//            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
//                Toast.makeText(context,"Error in Loading Video",Toast.LENGTH_SHORT).show()
//            }
//        })
        return rootView
    }
}