package com.example.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class Color1 : Fragment() {

    lateinit var btnGreen: Button
    lateinit var btnYellow:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View= inflater.inflate(R.layout.fragment_color1, container, false)
        btnGreen=v.findViewById(R.id.green)
        btnGreen.setOnClickListener {
            val mai=activity as ColorFragment
            mai.newColor(Color.GREEN)
        }

        btnYellow=v.findViewById(R.id.yellow)
        btnYellow.setOnClickListener {
            val mai=activity as ColorFragment
            mai.newColor(Color.YELLOW)
        }
        return v


    }


}