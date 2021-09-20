package com.solar.ktx

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.solar.ktx.library.component.getValue

class MainFragment : Fragment() {
    val firstName by getValue<String>("firstName") // String?

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

        viewLifecycleOwner
    }
}