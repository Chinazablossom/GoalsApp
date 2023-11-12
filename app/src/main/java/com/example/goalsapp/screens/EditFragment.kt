package com.example.goalsapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.goalsapp.R
import com.example.goalsapp.databinding.FragmentEditBinding
import com.example.goalsapp.model.Data
import com.example.goalsapp.viewmodel.GoalsViewModel
import kotlin.random.Random

class EditFragment : Fragment() {
    lateinit var binding: FragmentEditBinding
    private val viewModel: GoalsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            backId.setOnClickListener {
                findNavController().popBackStack(R.id.lisitsFragment, false)
            }

            doneTxt.setOnClickListener {
                val newGoal = Data(
                    goalNameIdEditText.text.toString(),
                    descriptionIdEditText.text.toString(),
                    dueDateIdEditText.text.toString(),
                    Random.nextInt(21, 9999)
                )
                viewModel.addGoal(newGoal)
                findNavController().navigate(R.id.lisitsFragment)
            }


        }
    }


}