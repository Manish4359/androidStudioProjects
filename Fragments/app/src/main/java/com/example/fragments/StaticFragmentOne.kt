package com.example.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class StaticFragmentOne : Fragment() {

    lateinit var v:View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_static_one, container, false)
        init(container)
        return v
    }

    lateinit var btnListener:backPressCall

    fun init(root:ViewGroup?){
        val b1=v.findViewById<Button>(R.id.send)
        val b2=v.findViewById<Button>(R.id.send2)

        b1.setOnClickListener {
            btnListener.onBackPressCall("Button has been clicked")
        }
        b2.setOnClickListener {
            btnListener.onBackPressCall("")
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        btnListener=try {
            activity as backPressCall
        }
        catch (e:java.lang.ClassCastException){
            throw ClassCastException("class is not cast")
        }
    }


}