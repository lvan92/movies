package com.example.myapplication.common.view

import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import com.example.myapplication.common.FragmentUtils

abstract class BaseFragment : Fragment() {

    protected val handler = Handler(Looper.getMainLooper())
    private var runnable: Runnable? = null
}