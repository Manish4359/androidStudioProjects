package com.example.externalstorage

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

class ReadExternalDetail : AppCompatActivity() {

    lateinit var fStream: FileInputStream
    private var filename="sampleFile.txt"
    private var filepath="myFileStorage"
    lateinit var myExternalFile: File
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_external_detail)
         var tv=findViewById<TextView>(R.id.tv)
         var back=findViewById<Button>(R.id.btnBack)

        try{
            myExternalFile= File(getExternalFilesDir(filepath),filename)
            fStream=FileInputStream(myExternalFile)
            val sBuffer=StringBuffer()
            var i:Int

            //-1 represents the null condition
            while(fStream.read().also { i=it }!=-1){
                sBuffer.append(i.toChar())
            }
            fStream.close()
            val details=sBuffer.toString().split('\n').toTypedArray()
            tv.setText(sBuffer)

        }
        catch (e:FileNotFoundException){
            e.printStackTrace()
        }
        catch (e:IOException){
            e.printStackTrace()
        }

        back.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}