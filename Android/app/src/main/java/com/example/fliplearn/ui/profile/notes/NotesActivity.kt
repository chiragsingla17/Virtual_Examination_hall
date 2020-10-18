package com.example.fliplearn.ui.profile.notes

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fliplearn.R
import kotlinx.android.synthetic.main.activity_notes.*


class NotesActivity : AppCompatActivity() {

    var listOfNotes: ArrayList<NotesData>? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        val actionBar: android.app.ActionBar? = actionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        progress.visibility = View.VISIBLE
        initData().also {
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed(Runnable {
                initNotes(it!!)
            }, 2000)
        }
    }

    /** AFTER ALL IT'S JUST A PROTOTYPE :)
     * */
    private fun initData(): ArrayList<NotesData>? {
        listOfNotes = ArrayList<NotesData>()

        listOfNotes!!.add(
            NotesData(
                "https://firebasestorage.googleapis.com/v0/b/fliplearn-595fd.appspot.com/o/notes%2FIMG_0098.jpg?alt=media&token=de9b8514-51e5-42fc-af27-11b3da9e3fec",
                "Quadratic equation Question number 4 ex.1.2 Practice",
                "23 July 2020"
            )
        )
        listOfNotes!!.add(
            NotesData(
                "https://firebasestorage.googleapis.com/v0/b/fliplearn-595fd.appspot.com/o/notes%2FIMG_0100.jpg?alt=media&token=ba39bea0-3ac1-455f-8a0e-329844f0622c",
                "Graph of Tan(θ) practice",
                "5 Aug 2020"
            )
        )
        listOfNotes!!.add(
            NotesData(
                "https://firebasestorage.googleapis.com/v0/b/fliplearn-595fd.appspot.com/o/notes%2FIMG_0101.jpg?alt=media&token=9f0f35a2-0c40-4a86-a5bb-003a8b7d66b1",
                "Random Notes Integration",
                "10 Aug 2020"
            )
        )
        listOfNotes!!.add(
            NotesData(
                "https://firebasestorage.googleapis.com/v0/b/fliplearn-595fd.appspot.com/o/notes%2FIMG_0102.jpg?alt=media&token=529468b6-d1b9-4f80-8785-805fa76316a4",
                "Benzene Reaction Organic chemistry",
                "27 Aug 2020"
            )
        )
        listOfNotes!!.add(
            NotesData(
                "https://firebasestorage.googleapis.com/v0/b/fliplearn-595fd.appspot.com/o/notes%2FIMG_0098.jpg?alt=media&token=de9b8514-51e5-42fc-af27-11b3da9e3fec",
                "Reaction Practice Chemistry",
                "2 Sept 2020"
            )
        )
        listOfNotes!!.add(
            NotesData(
                "https://firebasestorage.googleapis.com/v0/b/fliplearn-595fd.appspot.com/o/notes%2FIMG_0103.jpg?alt=media&token=3b4d3c7d-e315-4c5d-8d33-87f59f1e83c7",
                "Quadratic equation Question number 4 ex. 1",
                "8 Sept 2020"
            )
        )
        listOfNotes!!.add(
            NotesData(
                "https://firebasestorage.googleapis.com/v0/b/fliplearn-595fd.appspot.com/o/notes%2FIMG_0104.jpg?alt=media&token=c5b65f4b-e5b7-42bc-ba84-6edd0ba6d9ad",
                "Electricity resistor question solving",
                "20 Sept 2020"
            )
        )
        listOfNotes!!.add(
            NotesData(
                "https://firebasestorage.googleapis.com/v0/b/fliplearn-595fd.appspot.com/o/notes%2FIMG_0105.jpg?alt=media&token=d66f35ca-dd67-4a71-bcb2-6f3c675e5c7f",
                "Hydrocarbons reaction practice",
                "17 Oct 2020"
            )
        )
        return listOfNotes
    }

    private fun initNotes(notes: ArrayList<NotesData>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        recyclerView.adapter = NotesAdapter(this, notes)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        progress.visibility = View.GONE
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.notes_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_add_notes -> {
                startActivity(Intent(this, NoteTakingActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}