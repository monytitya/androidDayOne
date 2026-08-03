package com.example.androidsoneday.materialui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.androidsoneday.R
import com.example.androidsoneday.databinding.FragmentMaterialShowcaseBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MaterialShowcaseFragment : Fragment(R.layout.fragment_material_showcase) {

    private var _binding: FragmentMaterialShowcaseBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMaterialShowcaseBinding.bind(view)

        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(view, "This is a Material Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action") { /* Action logic */ }
                .show()
        }

        binding.btnDialog.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Material Dialog")
                .setMessage("This is a Material 3 Alert Dialog showcase.")
                .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        binding.fab.setOnClickListener {
            Snackbar.make(view, "FAB Clicked", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}