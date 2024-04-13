package edu.quinnipiac.hackathon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import edu.quinnipiac.hackathon.databinding.FragmentResponsesBinding

class responsesFragment : Fragment() {
    private var _binding: FragmentResponsesBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResponsesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.resbackbutton.setOnClickListener {
            it.findNavController().navigate(R.id.action_responsesFragment_to_homeFragment)
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}