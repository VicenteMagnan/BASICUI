package com.example.basicui

import android.content.res.ColorStateList
import android.graphics.Color.blue
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.basicui.databinding.FragmentMainBinding
import android.widget.TextView
import com.google.android.material.chip.Chip
import com.google.android.material.slider.Slider
import splitties.toast.longToast
import splitties.toast.toast

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        longToast(R.string.text_fragment_created)

        binding.buttonToast.setOnClickListener {
            toast(R.string.text_short_message)
        }

        view.findViewById<Slider>(R.id.slider).addOnChangeListener { slider, value, fromUser ->
            val textView = binding.textviewMain
            textView.text = value.toString()
        }

        view.findViewById<Chip>(R.id.chipBlue).setOnCheckedChangeListener{chip, isChecked ->
            chip as Chip
            if (isChecked) {
                chip.setChipBackgroundColorResource(R.color.blue)
            } else {
                chip.setChipBackgroundColorResource(R.color.black)
            }
        }

        view.findViewById<Chip>(R.id.chipRed).setOnCheckedChangeListener{chip, isChecked ->
            chip as Chip
            if (isChecked) {
                chip.setChipBackgroundColorResource(R.color.red)
            } else {
                chip.setChipBackgroundColorResource(R.color.black)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}