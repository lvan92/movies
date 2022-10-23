package com.example.myapplication.fragment.playback

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPlayBackBinding


/**
 * A simple [Fragment] subclass.
 * Use the [PlayBackFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlayBackFragment : Fragment() {
    private lateinit var binding: FragmentPlayBackBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentPlayBackBinding.inflate(inflater, container, false)
        return binding.root
    }

}