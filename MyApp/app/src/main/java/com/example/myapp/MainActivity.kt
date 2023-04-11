package com.example.myapp

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    val positiveButtonClick={dialog:DialogInterface,which:Int->
        Toast.makeText(applicationContext,"ok",Toast.LENGTH_SHORT).show()
    }

    val negativeButtonClick={dialog:DialogInterface,which:Int->
        Toast.makeText(applicationContext,"no",Toast.LENGTH_SHORT).show()
    }

    val neutralButtonClick={dialog:DialogInterface,which:Int->
        Toast.makeText(applicationContext,"maybe",Toast.LENGTH_LONG).show()
    }

    fun basicAlert(view: View){

        val builder=AlertDialog.Builder(this)

        with(builder){
            setTitle("Lovely Professional University")
            setMessage("we have a message")
            setPositiveButton("ok",positiveButtonClick)

            //DialogInterface.OnClickListener(function = positiveButtonClick) can also be used

            setNegativeButton("no",negativeButtonClick)
            setNeutralButton("maybe",neutralButtonClick)

            show()
        }
    }

    fun withItems(view: View){
        val items= arrayOf("red","orange","green","white","black")
        val builder = AlertDialog.Builder(this)

        with(builder){
            setTitle("List of items")
            setItems(items){
                dialog,which->Toast.makeText(applicationContext,items[which]+" is clicked",Toast.LENGTH_LONG).show()
            }

            setPositiveButton("ok",positiveButtonClick)
            show()
        }
    }
    fun withMultiChoiceList(view: View){

        val items= arrayOf("apple","amazon","google","microsoft")
        val selectedList=ArrayList<Int>();

        val builder=AlertDialog.Builder(this);

        builder.setTitle("This is list choice box")
        builder.setMultiChoiceItems(items,null){
            dialog,which,isChecked->
            if(isChecked){
                selectedList.add(which)
            }
            else if(selectedList.contains(which)){
                selectedList.remove(Integer.valueOf(which))
            }

        }

        
        builder.setPositiveButton("Done"){
            dialogInterface ,i->
            val selectedStrings=ArrayList<String>();

            for(j in selectedList.indices){
                selectedStrings.add(items[selectedList[j]])
            }
            Toast.makeText(applicationContext,
                "Item selected are: "+Arrays.toString(selectedStrings.toTypedArray()),Toast.LENGTH_SHORT).show()
        }
        builder.show()

    }
    fun withTwoButton(view: View){

        val alertDialog=AlertDialog.Builder(this).create();

        alertDialog.setTitle("Title")
        alertDialog.setMessage("Message")
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE,"Yes"){dialog,which->dialog.dismiss()}
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE,"No"){dialog,which->dialog.dismiss()}
        alertDialog.show()

    }
    fun withEditText(view: View){
        val builder=AlertDialog.Builder(this)
        val inflater=layoutInflater
        builder.setTitle("Edit text")
        val dialogLayout=inflater.inflate(R.layout.alert_dialog_with_edittext,null)
        val editText=dialogLayout.findViewById<EditText>(R.id.editText)
        builder.setView(dialogLayout)
        builder.setPositiveButton("ok"){
            dialogInterface,i->Toast.makeText(applicationContext,"Edit text is:"+editText.text.toString(),Toast.LENGTH_SHORT).show()
        }
        builder.show()

    }

}