package edu.quinnipiac.hackathon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.findNavController
import edu.quinnipiac.hackathon.databinding.FragmentInfoBinding


class infoFragment : Fragment() {
    private var _binding:FragmentInfoBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoBinding.inflate(inflater,container,false)
        val view = binding.root
        return view


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.inBackbutton.setOnClickListener {
            it.findNavController().navigate(R.id.action_infoFragment_to_homeFragment)
        }
        binding.inForbutton.setOnClickListener {

            val action = infoFragmentDirections
                .actionInfoFragmentToContactFragment(
                    view.findViewById<EditText>(R.id.field_your_name).text.toString(),
                    view.findViewById<EditText>(R.id.field_contact_name).text.toString(),
                    view.findViewById<EditText>(R.id.field_relationship).text.toString()
                )



            it.findNavController().navigate(action)

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}