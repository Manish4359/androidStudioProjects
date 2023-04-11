package com.example.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class StaticFragmentTwo : Fragment() {

    lateinit var v:View
    lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_static_two, container, false)
        return v
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    fun onFragmentInteraction(msg:String){
        textView=v.findViewById(R.id.tv)
        textView.setText(msg)
    }
}