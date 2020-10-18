package com.example.fliplearn.ui.doubts

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fliplearn.R
import com.example.fliplearn.model.Constants
import com.example.fliplearn.model.doubtsModel
import com.jaredrummler.materialspinner.MaterialSpinner
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.doubts_alert_dialog.view.*
import kotlinx.android.synthetic.main.fragment_doubts.view.*


class doubtsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    var uri : Uri? = null
    var imageView : ImageView? = null
    var adapter : doubtsAdapter? = null

    val list = Constants.getDoubts()

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 123) {
            uri = data?.data
            Picasso.get().load(uri).into(imageView)
        }
    }

    fun showAlertDialog(){
        val dialog = AlertDialog.Builder(context)
        val dialogView = LayoutInflater.from(context).inflate(R.layout.doubts_alert_dialog,null)
        dialog.setView(dialogView)
        dialog.setCancelable(true)

        //Set up the view of dialog
        imageView = dialogView.alertDialogImageAdd

        val alertDialog = dialog.create()
        dialogView.alertDialogImageAdd.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 123)
        }
        val spinnerItems = arrayOf("General" , "Mathematics","Physics" ,"Biology","Accountancy" ,"History","Business Studies")
        var selectedItem = 0

        //Set up the spinner android
        dialogView.spinner.setItems("General" , "Mathematics","Physics" ,"Biology","Accountancy" ,"History","Business Studies")
        dialogView.spinner.setOnItemSelectedListener(object : MaterialSpinner.OnItemSelectedListener<String>{
            override fun onItemSelected(view: MaterialSpinner?, position: Int, id: Long, item: String?) {
                selectedItem = position
            }
        })
        dialogView.spinner.selectedIndex = 0


        dialogView.submitButton.setOnClickListener {
            var text : String? = dialogView.doubtTextView.text.toString()
            if(text!!.isEmpty()){
                text = null
            }
            if(text==null && uri==null){
                Toast.makeText(context,"Please insert either Text or image to ask doubt",Toast.LENGTH_SHORT).show()
            }
            else{
                //Add it to the adapter
                adapter?.addList(doubtsModel("250","Gaurish Anand",spinnerItems.get(selectedItem),text,null,R.drawable.gaurish,uri))
                alertDialog.dismiss()
            }
        }
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.show()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_doubts, container, false)
        view.doubtsRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = doubtsAdapter(list,context)
        view.doubtsRecyclerView.adapter = adapter
        view.floatingActionButton.setOnClickListener {
            showAlertDialog()
        }
        return view
    }
}