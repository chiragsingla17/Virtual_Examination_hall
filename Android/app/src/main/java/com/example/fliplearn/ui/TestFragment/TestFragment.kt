package com.example.fliplearn.ui.TestFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fliplearn.R
import kotlinx.android.synthetic.main.fragment_test.view.*

class TestFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_test, container, false)

        view.recyclerView_one.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        view.recyclerView_two.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        view.recyclerView_three.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        view.recyclerView_four.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        view.recyclerView_one.adapter = testAdapter(myObj.getMathsList(),context!!)
        view.recyclerView_two.adapter = testAdapter(myObj.getComputerList(),context!!)
        view.recyclerView_three.adapter = testAdapter(myObj.getPhysicsList(),context!!)
        view.recyclerView_four.adapter = testAdapter(myObj.getChemistryList(),context!!)
        return view

    }
}