package com.example.fliplearn.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fliplearn.R
import com.example.fliplearn.ui.TestFragment.myObj
import com.example.fliplearn.ui.TestFragment.testAdapter
import com.example.fliplearn.ui.profile.notes.NotesAdapter
import com.example.fliplearn.ui.profile.notes.NotesData
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun initData(): ArrayList<NotesData> {

        var listOfNotes: ArrayList<NotesData>? = null;
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


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        /**
         * Setting up the course Adapter
         */
        view.coursesRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        view.coursesRecyclerView.adapter = coursesAdapter(context!!)


        view.notesRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        view.testRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        view.testRecyclerView.adapter = testAdapter(myObj.getRandomTest(),context!!)
        view.notesRecyclerView.adapter = NotesAdapter(context!!, initData())
        return view
    }
}