package com.example.goalsapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.goalsapp.R
import com.example.goalsapp.adapter.GoalsAdapter
import com.example.goalsapp.databinding.FragmentLisitsBinding
import com.example.goalsapp.viewmodel.GoalsViewModel


class LisitsFragment : Fragment() {
    lateinit var binding: FragmentLisitsBinding
    private val viewModel: GoalsViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLisitsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            recyclerView.adapter
            recyclerView.adapter =
                GoalsAdapter(requireContext(), viewModel.goalsData.value ?: emptyList())
            recyclerView.setHasFixedSize(true)

            addbtn.setOnClickListener {
                findNavController().navigate(R.id.editFragment)
            }
        }


    }

}