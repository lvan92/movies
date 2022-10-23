package com.example.myapplication.common

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.myapplication.common.view.LoadingDialog

fun Fragment.showLoadingOverlay(show: Boolean) {
    showLoadingOverlay(show, childFragmentManager)
}
fun AppCompatActivity.showLoadingOverlay(show: Boolean) {
    showLoadingOverlay(show, supportFragmentManager)
}
fun showLoadingOverlay(show: Boolean, fragmentManager: FragmentManager) {
    val loadingDialog = LoadingDialog.newInstance()
    if(show) {
        loadingDialog.show(fragmentManager, LoadingDialog.TAG)
        fragmentManager.executePendingTransactions()
    } else {
        loadingDialog.dismissAllowingStateLoss()
    }
}
