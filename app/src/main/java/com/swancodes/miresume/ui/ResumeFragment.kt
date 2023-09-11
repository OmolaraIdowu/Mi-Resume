package com.swancodes.miresume.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.swancodes.miresume.databinding.FragmentResumeBinding
import com.swancodes.miresume.viewmodel.ResumeViewModel

class ResumeFragment : Fragment() {
    private lateinit var binding: FragmentResumeBinding
    private val viewModel: ResumeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentResumeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpObserver()

        binding.editButton.setOnClickListener {
            findNavController().navigate(ResumeFragmentDirections.toEditResumeFragment(viewModel.resumeData.value!!))
        }

    }

    private fun setUpObserver() {
        viewModel.resumeData.observe(viewLifecycleOwner) {
            binding.fullName.text = it.fullName
            binding.title.text = it.title
            binding.slackUsername.text = it.slackUsername
            binding.gitHubLink.text = it.githubHandle
            binding.bioContent.text = it.bio
            binding.skillsContent.text = it.skills
            binding.experienceContent.text = it.experience
            binding.educationContent.text = it.education
        }
    }
}