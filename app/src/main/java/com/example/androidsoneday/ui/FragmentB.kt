package com.example.androidsoneday.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.example.androidsoneday.R
import com.example.androidsoneday.databinding.FragmentBBinding

class FragmentB : Fragment(R.layout.fragment_b) {

    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBBinding.bind(view)

        binding.btnSendBack.setOnClickListener {
            setFragmentResult("REQUEST_KEY_DATA", bundleOf("RESULT_TEXT_KEY" to "Hello from Fragment B!"))
            
            // Go back to FragmentA
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}