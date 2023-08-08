package com.example.customlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class MyAdapter (private  val ctx:Context,private  val items:List<Model>):BaseAdapter(){


    override fun getCount(): Int {
    return items.size
    }

    override fun getItem(p0: Int): Any {
        return items[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var view=p1
        var viewHolder:ViewHolder

        if (view == null) {
            view = LayoutInflater.from(ctx).inflate(R.layout.listviewitem, p2, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        val item = items[p0]
        viewHolder.title.text=item.title
        viewHolder.description.text=item.description
        viewHolder.imageView.setImageDrawable(ctx.resources.getDrawable(item.img))

        return view as View
    }

}

private class ViewHolder(itemView: View) {
    val imageView=itemView.findViewById<ImageView>(R.id.imageView)
    var title=itemView.findViewById<TextView>(R.id.textView)
    val description=itemView.findViewById<TextView>(R.id.textView2)
}
/*
class MyAdapter(var mCtx:Context,var resources:Int,var items:List<Model>):
ArrayAdapter<Model>(mCtx,resources,items){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater=LayoutInflater.from(mCtx)
        val view:View=layoutInflater.inflate(resources,null)

        val imageView:ImageView =view.findViewById(R.id.imageView)
        val titleTextView:TextView =view.findViewById(R.id.textView)
        val descriptionTextView:TextView =view.findViewById(R.id.textView2)

        val mItem:Model=items[position]
        imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.img))
        titleTextView.text=mItem.title
        descriptionTextView.text=mItem.description

        return view
    }
}

*/
