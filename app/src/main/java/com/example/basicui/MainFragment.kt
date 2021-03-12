package com.example.basicui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.android.material.slider.Slider
import splitties.toast.longToast
import splitties.toast.toast

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        longToast(R.string.text_fragment_created)

        view.findViewById<Button>(R.id.button_toast).setOnClickListener {
            toast(R.string.text_short_message)
        }

        view.findViewById<Button>(R.id.button_main).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        view.findViewById<Slider>(R.id.slider).addOnChangeListener { slider, value, fromUser ->
            val textView = view.findViewById<TextView>(R.id.textview_main)
            textView.text = value.toString()
        }
    }
}