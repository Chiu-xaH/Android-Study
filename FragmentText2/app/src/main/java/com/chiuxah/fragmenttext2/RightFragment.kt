package com.chiuxah.fragmenttext2

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chiuxah.fragmenttext2.R

class RightFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (inflater != null) {
            return inflater.inflate(R.layout.right, container, false)
        }

        return TODO("提供返回值")
    }
}