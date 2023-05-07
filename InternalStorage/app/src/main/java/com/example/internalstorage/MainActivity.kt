package com.example.internalstorage

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var btn1:Button
    lateinit var btn2: Button
    lateinit var editText:EditText
    lateinit var textView:TextView
    lateinit var data:String
    val file="myData.txt"
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1=findViewById(R.id.btn1)
        btn2=findViewById(R.id.btn2)
        editText=findViewById(R.id.edittext)
        textView=findViewById(R.id.textview)


        var jsonObject = JSONObject();
        jsonObject.put("Name", "manish");
        jsonObject.put("registration", "123456");

        //save the text to a file
        btn1.setOnClickListener {
            data=jsonObject.toString()
            try {
                val fout=openFileOutput(file, MODE_APPEND)
                fout.write(data.toByteArray())
                fout.close()
                Toast.makeText(this,"data saved to my file",Toast.LENGTH_LONG).show()

            }
            catch (e:IOException){
                e.printStackTrace()
            }
        }

        //fetch data from file and show in textview
        btn2.setOnClickListener {

            try{
                val fin=openFileInput(file)
                var c:Int
                var temp=""

                //read the file till the last character
                while(fin.read().also { c=it }!=-1){
                    temp+=c.toChar()
                }
                textView.text = temp
                Toast.makeText(this,"data fetched from my file",Toast.LENGTH_LONG).show()
                fin.close()

            }catch(e:IOException) {
                e.printStackTrace()
            }
        }
    }
}