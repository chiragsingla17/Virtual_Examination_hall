package com.example.fliplearn.ui.onlineTestActivity

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fliplearn.R
import com.example.fliplearn.model.onlineTest
import com.example.fliplearn.ui.TestFragment.myObj
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_online_test.*
import kotlinx.android.synthetic.main.test_score.view.*
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.model.SliceValue
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future


class onlineTestActivity : AppCompatActivity() {

    var current = 0
    var list : ArrayList<onlineTest>? = ArrayList()
    var database = FirebaseDatabase.getInstance().reference
    var child = ""
    var optionSelected : ArrayList<Int>? = ArrayList()
    var correctAnswers = 0

    fun getValue(questionNumber : Int, OptionNumber : Int) : String{
        if(OptionNumber==1){
            return list?.get(questionNumber)!!.option1
        }
        else if(OptionNumber==2){
            return list?.get(questionNumber)!!.option2
        }
        else if(OptionNumber==3){
            return list!!.get(questionNumber).option3
        }
        else{
            return list!!.get(questionNumber).option4
        }
    }
    fun setUpQuestion(onlineTest: onlineTest , optionSel : Int,view : View){
        optionSelected?.add(optionSel)

        val correctOption = onlineTest.correctOption
        FirebaseDatabase.getInstance().getReference("Courses/Computers/Tests/Data Structures and Alogrithms/Test${child}/Question${current}").setValue(getValue(current,optionSel))
        current++

        view.setBackgroundColor(Color.parseColor("#FFB6C1"))

        if(correctOption==optionSel){
            correctAnswers++
        }

        if(current==1){
            slider1.setBackgroundColor(Color.parseColor("#000080"))
        }
        else if(current==2){
            slider2.setBackgroundColor(Color.parseColor("#000080"))
        }
        else if(current==3){
            slider3.setBackgroundColor(Color.parseColor("#000080"))
        }
        else if(current==4){
            slider4.setBackgroundColor(Color.parseColor("#000080"))
        }

        Handler().postDelayed(object : Runnable{
            override fun run() {
                if(current==list!!.size){
                    showAlertDialog(correctAnswers.toString())
                }
                else{
                    setUpNextQuestion()
                }
            }
        },1000)
    }
    fun setUpNextQuestion(){
        option1.text = "1. " + list!!.get(current).option1
        option1.setBackgroundResource(R.drawable.rectangle_border)
        option2.text = "2. " + list!!.get(current).option2
        option2.setBackgroundResource(R.drawable.rectangle_border)
        option3.text = "3. " + list!!.get(current).option3
        option3.setBackgroundResource(R.drawable.rectangle_border)
        option4.text = "4. " + list!!.get(current).option4
        option4.setBackgroundResource(R.drawable.rectangle_border)
        questionTextView.text = list!!.get(current).question
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_online_test)
        setUpTheNextQuiz()
    }

    fun setUpTheNextQuiz(){
        try {
            /**
             * Get the count of children
             */
            current = 0
            correctAnswers = 0
            database.child("Courses/Computers/Tests/Data Structures and Alogrithms").addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(p0: DataSnapshot) {
                    child = (p0.childrenCount+1).toString()
                    Log.i("childdd",child)
                }

            })

            optionSelected?.clear()
            list!!.clear()
            list!!.addAll(myObj.getDataForDataStructures())


            setUpNextQuestion()
            option1.setOnClickListener{
                setUpQuestion(list!!.get(current),1,option1)
            }
            option2.setOnClickListener {
                setUpQuestion(list!!.get(current),2,option2)
            }
            option3.setOnClickListener {
                setUpQuestion(list!!.get(current),3,option3)
            }
            option4.setOnClickListener {
                setUpQuestion(list!!.get(current),4,option4)
            }

            val handler = Handler()
            var count = 100
            timerTextView.text = "100s"


            val runnable = object : Runnable{
                override fun run() {
                    timerTextView.text = count.toString() + "s"
                    count--;
                    handler.postDelayed(this,1000)
                }
            }
            val hand = handler.postDelayed(runnable,1000)

        }catch (e : Exception){
            Log.i("my error",e.message.toString())
        }
    }



    fun showAlertDialog(score : String){
        val dialog = AlertDialog.Builder(this)
        val dialogView = LayoutInflater.from(this).inflate(R.layout.test_score,null)
        dialog.setView(dialogView)
        dialog.setCancelable(false)
        val alertDialog = dialog.create()
        dialogView.textScore.text = "Score : ${score}/${list!!.size}"
        dialogView.Next_Quiz.setOnClickListener{
            if(myObj.currentQuiz%2==0){
                finish()
            }
            else{
                alertDialog.dismiss()
                startActivity(Intent(this,onlineTestActivity::class.java))
                finish()
            }
        }

        try {
            //Setting up the pie chart
            val pieData: ArrayList<SliceValue> = myObj.getPieChar_Values()
            val pieChartData = PieChartData(pieData)
            pieChartData.setHasLabels(true)
            dialogView.chart.setPieChartData(pieChartData)


            val myData = myObj.getDataForChats()
            //Setting up the Bar gaph
            val barEntries = myData.second
            val barDataSet = BarDataSet(barEntries, "Past Performaces")
            val labels = myData.first
            val data = BarData(labels,barDataSet)
            dialogView.barGraph.setData(data)

            dialogView.barGraph.setDescription("Percentile vs Performance")  // set the description
            barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            dialogView.barGraph.animateY(5000)
        }catch (e : Exception){
            Log.i("my error",e.message.toString())
        }


        dialogView.resultRecyclerView.layoutManager = LinearLayoutManager(this)
        dialogView.resultRecyclerView.adapter = onlineTestResultAdapter(list!!,optionSelected)
        alertDialog.show()
    }

}