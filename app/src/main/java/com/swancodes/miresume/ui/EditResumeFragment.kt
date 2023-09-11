package com.swancodes.miresume.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.swancodes.miresume.data.ResumeData
import com.swancodes.miresume.databinding.FragmentEditResumeBinding
import com.swancodes.miresume.viewmodel.ResumeViewModel

class EditResumeFragment : Fragment() {
    private lateinit var binding: FragmentEditResumeBinding
    private val viewModel: ResumeViewModel by activityViewModels()
    private val args: EditResumeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEditResumeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.data.let {
            binding.nameEditText.setText(it.fullName)
            binding.titleEditText.setText(it.title)
            binding.usernameEditText.setText(it.slackUsername)
            binding.githubEditText.setText(it.githubHandle)
            binding.bioEditText.setText(it.bio)
            binding.skillsEditText.setText(it.skills)
            binding.experienceEditText.setText(it.experience)
            binding.educationEditText.setText(it.education)
        }

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.saveText.setOnClickListener {
            updateData()
        }
    }

    private fun updateData() {
        val fullName = binding.nameEditText.text.toString()
        val title = binding.titleEditText.text.toString()
        val username = binding.usernameEditText.text.toString()
        val github = binding.githubEditText.text.toString()
        val bio = binding.bioEditText.text.toString()
        val skills = binding.skillsEditText.text.toString()
        val experience = binding.experienceEditText.text.toString()
        val education = binding.educationEditText.text.toString()

        val updatedData =
            ResumeData(fullName, title, username, github, bio, skills, experience, education)
        viewModel.updateResumeInfo(updatedData)
        Toast.makeText(requireContext(), "Resume successfully updated", Toast.LENGTH_SHORT)
            .show()
        findNavController().navigateUp()
    }
}