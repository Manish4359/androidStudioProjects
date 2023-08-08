package com.example.recycler_view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : ComponentActivity() {

    lateinit var arrayList: ArrayList<LinearPojo>
    lateinit var recyclerView:RecyclerView
    var adapterRecycler:AdapterRecycler?=null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        linearListData()
        recyclerView=findViewById(R.id.recyclerView)

        var ll=LinearLayoutManager(this)
        ll.orientation=RecyclerView.VERTICAL
        recyclerView.layoutManager=ll
        adapterRecycler= AdapterRecycler(this,arrayList)
        recyclerView.adapter=adapterRecycler
    }

    fun linearListData(){



        arrayList=ArrayList()

        arrayList.add(LinearPojo("kitkat","4.4"))
        arrayList.add(LinearPojo("marshmallow","6"))
        arrayList.add(LinearPojo("lolipop","5.0"))
        arrayList.add(LinearPojo("oreo","8"))
        arrayList.add(LinearPojo("pie","9"))
        arrayList.add(LinearPojo("Android 10","10"))
        arrayList.add(LinearPojo("Android 11","11"))
        arrayList.add(LinearPojo("Android 11","11"))
        arrayList.add(LinearPojo("Android 11","11"))
        arrayList.add(LinearPojo("Android 11","11"))
        arrayList.add(LinearPojo("Android 11","11"))
        arrayList.add(LinearPojo("Android 11","11"))
        arrayList.add(LinearPojo("Android 11","11"))
        arrayList.add(LinearPojo("Android 11","11"))
        arrayList.add(LinearPojo("Android 11","11"))

    }

}