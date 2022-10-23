package com.example.myapplication.common.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.example.myapplication.R

class LoadingDialog: DialogFragment() {

    companion object {
        const val TAG: String = "LoadingDialog"
        fun newInstance(): LoadingDialog {
            return LoadingDialog()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.Theme_MyApplication_Dialog)
        isCancelable = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.spinner_bar, container, false)
    }

    override fun onStart() {
        super.onStart()
        val window = dialog!!.window
        val windowParams =window!!.attributes
        windowParams.dimAmount =0.5f
        windowParams.flags =windowParams.flags or WindowManager.LayoutParams.FLAG_DIM_BEHIND
        window.attributes =windowParams
    }
}