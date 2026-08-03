package com.example.androidsoneday.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.example.androidsoneday.R
import com.example.androidsoneday.databinding.FragmentABinding

class FragmentA : Fragment(R.layout.fragment_a) {

    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentABinding.bind(view)

        // Register Fragment Result Listener
        setFragmentResultListener("REQUEST_KEY_DATA") { requestKey, bundle ->
            val resultText = bundle.getString("RESULT_TEXT_KEY", "No data")
            binding.tvResult.text = resultText
        }

        // Navigate to FragmentB
        binding.btnNavigate.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentB())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}