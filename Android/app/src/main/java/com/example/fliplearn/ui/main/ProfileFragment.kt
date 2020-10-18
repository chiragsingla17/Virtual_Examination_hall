package com.example.fliplearn.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fliplearn.R
import com.example.fliplearn.ui.auth.LoginActivity
import com.example.fliplearn.ui.profile.coins.CoinTransactionActivity
import com.example.fliplearn.ui.profile.notes.NotesActivity
import com.google.android.material.card.MaterialCardView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*


class ProfileFragment : Fragment() {

    var aboutus: MaterialCardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_profile, container, false)
        v.ivLogout.setOnClickListener(View.OnClickListener { logout: View? ->
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(context, LoginActivity::class.java))
            activity!!.finish()
        })
        v.clcoins.setOnClickListener {
            startActivity(Intent(context, CoinTransactionActivity::class.java))
        }
        aboutus = v.findViewById(R.id.cardAbout)
        aboutus!!.setOnClickListener { v1 ->
            //Start the about us Activity
        }
        v.clnotes.setOnClickListener {
            startActivity(Intent(context, NotesActivity::class.java))
        }

        return v
    }


}