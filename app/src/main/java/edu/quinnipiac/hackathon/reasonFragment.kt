package edu.quinnipiac.hackathon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import edu.quinnipiac.hackathon.databinding.FragmentReasonBinding


class reasonFragment : Fragment() {
    private var _binding: FragmentReasonBinding? = null
    private val binding get() = _binding!!
override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     _binding = FragmentReasonBinding.inflate(inflater,container,false)
    val view = binding.root
    return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.reabackbutton.setOnClickListener {
            it.findNavController().navigate(R.id.action_reasonFragment_to_contactFragment)
        }
        binding.reaForbutton.setOnClickListener {
            it.findNavController().navigate(R.id.action_reasonFragment_to_responsesFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}