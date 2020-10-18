package com.example.fliplearn.ui.onlineTestActivity

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.Toast
import com.example.fliplearn.R
import com.example.fliplearn.R.color
import com.example.fliplearn.model.doubtsModel
import com.example.fliplearn.model.onlineTest
import com.example.fliplearn.ui.TestFragment.myObj
import com.jaredrummler.materialspinner.MaterialSpinner
import kotlinx.android.synthetic.main.activity_online_test.*
import kotlinx.android.synthetic.main.doubts_alert_dialog.view.*
import kotlinx.android.synthetic.main.test_score.view.*
import java.util.*

class onlineTestActivity : AppCompatActivity() {


    var current = 0
    val list = myObj.getDataForTest()

    var correctAnswers = 0


    fun setColour(s : String){
        Log.i("colour",s)
        if(current==1){
            slider1.setBackgroundColor(Color.parseColor(s))
        }
        else if(current==2){
            slider2.setBackgroundColor(Color.parseColor(s))
        }
        else if(current==3){
            slider3.setBackgroundColor(Color.parseColor(s))
        }
        else if(current==4){
            slider4.setBackgroundColor(Color.parseColor(s))
        }
        else if(current==5){
            slider5.setBackgroundColor(Color.parseColor(s))
        }
        else{
            slider6.setBackgroundColor(Color.parseColor(s))
        }
    }

    fun setUpQuestion(onlineTest: onlineTest , optionSelected : Int,view : View){
        val correctOption = onlineTest.correctOption
        current++

        if(correctOption!=optionSelected){
            view.setBackgroundColor(Color.parseColor("#FF0000"))
            if(correctOption==1){
                option1.setBackgroundColor(Color.parseColor("#00FF00"))
            }
            else if(correctOption==2){
                option2.setBackgroundColor(Color.parseColor("#00FF00"))
            }
            else if(correctOption==3){
                option3.setBackgroundColor(Color.parseColor("#00FF00"))
            }
            else{
                option4.setBackgroundColor(Color.parseColor("#00FF00"))
            }
            setColour("#FF0000")
        }
        else{
            correctAnswers++
            setColour("#00FF00")
            view.setBackgroundColor(Color.parseColor("#00FF00"))
        }

        Handler().postDelayed(object : Runnable{
            override fun run() {
                if(current==6){
                    showAlertDialog(correctAnswers.toString())
                }
                else{
                    setUpNextQuestion()
                }
            }
        },1000)
    }


    fun setUpNextQuestion(){
        option1.text = "1. " + list.get(current).option1
        option1.setBackgroundResource(R.drawable.rectangle_border)
        option2.text = "2. " + list.get(current).option2
        option2.setBackgroundResource(R.drawable.rectangle_border)
        option3.text = "3. " + list.get(current).option3
        option3.setBackgroundResource(R.drawable.rectangle_border)
        option4.text = "4. " + list.get(current).option4
        option4.setBackgroundResource(R.drawable.rectangle_border)
        questionTextView.text = list.get(current).question
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_online_test)
        setUpNextQuestion()
        option1.setOnClickListener{
            setUpQuestion(list.get(current),1,option1)
        }
        option2.setOnClickListener {
            setUpQuestion(list.get(current),2,option2)
        }
        option3.setOnClickListener {
            setUpQuestion(list.get(current),3,option3)
        }
        option4.setOnClickListener {
            setUpQuestion(list.get(current),4,option4)
        }

        val handler = Handler()
        var count = 100
        val runnable = object : Runnable{
            override fun run() {
                timerTextView.text = count.toString() + "s"
                count--;
                handler.postDelayed(this,1000)
            }
        }
        handler.postDelayed(runnable,1000)
    }

    fun showAlertDialog(score : String){
        val dialog = AlertDialog.Builder(this)
        val dialogView = LayoutInflater.from(this).inflate(R.layout.test_score,null)
        dialog.setView(dialogView)
        dialog.setCancelable(true)
        val alertDialog = dialog.create()
        dialogView.textScore.text = "Score : ${score}/6"
        dialogView.submitButtonBB.setOnClickListener{
            finish()
        }
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.setOnDismissListener{
            finish()
        }
        alertDialog.show()
    }

}