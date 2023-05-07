package com.example.externalstorage

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import android.Manifest
import android.content.Intent
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var btn1: Button
    lateinit var btn2:Button
    lateinit var uname:EditText
    lateinit var pwd:EditText
    lateinit var fStream:FileOutputStream
    private var filename="sampleFile.txt"
    private var filepath="myFileStorage"
    lateinit var myExternalFile: File


    var mPermission= arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        uname = findViewById(R.id.edittext1)
        pwd = findViewById(R.id.edittext2)

        btn1.setOnClickListener {

            var username = """
            ${uname.text}
            """.trimIndent()

            val password = pwd.text.toString()
            try {
                if (ContextCompat.checkSelfPermission(
                        this,
                        mPermission[0]
                    ) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(
                        this,
                        mPermission[1]
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(this, mPermission, 23)
                } else {
                    if (username.isEmpty() || password.isEmpty()) {
                        Toast.makeText(
                            this,
                            "either username or password is worng",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        myExternalFile = File(getExternalFilesDir(filepath), filename)
                        fStream = FileOutputStream(myExternalFile)
                        fStream.write(username.toByteArray())
                        fStream.write(password.toByteArray())
                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }


        btn2.setOnClickListener {
            var intent = Intent(this, ReadExternalDetail::class.java)
            startActivity(intent)
        }
    }

}