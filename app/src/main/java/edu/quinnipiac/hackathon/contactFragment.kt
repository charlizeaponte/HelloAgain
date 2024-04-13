package edu.quinnipiac.hackathon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import edu.quinnipiac.hackathon.databinding.FragmentContactBinding


class contactFragment : Fragment() {
   private var  _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentContactBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.conbackbutton.setOnClickListener {
            it.findNavController().navigate(R.id.action_contactFragment_to_infoFragment)
        }
        binding.conForbutton.setOnClickListener {
            it.findNavController().navigate(R.id.action_contactFragment_to_reasonFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}