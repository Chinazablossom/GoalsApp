package com.example.goalsapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.goalsapp.databinding.FragmentGoalsBinding
import com.example.goalsapp.viewmodel.GoalsViewModel


class GoalsFragment : Fragment() {
    lateinit var binding: FragmentGoalsBinding
    private val viewModel: GoalsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGoalsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel.goalsData.observe(viewLifecycleOwner) { goalsList ->
                val goal = goalsList.find {
                    it.goalName == arguments?.getString("head") && it.description == arguments?.getString(
                        "description"
                    ) && it.dueDate == arguments?.getString("dueDate")
                }
                goal?.let {
                    binding.goalName.text = it.goalName
                    binding.descriptionTv.text = it.description
                    binding.dueDateTv.text = it.dueDate
                }
            }

        }

    }


}