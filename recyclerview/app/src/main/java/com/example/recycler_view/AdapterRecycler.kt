package com.example.recycler_view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterRecycler(context:Context,arrayList:ArrayList<LinearPojo>):
    RecyclerView.Adapter<AdapterRecycler.MyHolder>() {

    var context:Context
    var arrayList:ArrayList<LinearPojo>

    init{
        this.context=context
        this.arrayList=arrayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRecycler.MyHolder {
        val view:View=LayoutInflater.from(context).inflate(R.layout.recycle_list,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterRecycler.MyHolder, position: Int) {
        holder.versionName.text=arrayList[position].versionName
        holder.version.text=arrayList[position].version
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class MyHolder(view: View):RecyclerView.ViewHolder(view){

        var versionName:TextView
        var version:TextView

        init{
            versionName=view.findViewById(R.id.versionName)
            version=view.findViewById(R.id.version)
        }

    }



}