package edu.quinnipiac.hackathon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
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
            val args = requireArguments();

            val action = reasonFragmentDirections
                .actionReasonFragmentToResponsesFragment(
                    view.findViewById<EditText>(R.id.field_contacting_reason).text.toString(),

                    args.getString("contact_context")!!,
                    args.getString("your_name")!!,
                    args.getString("contact_name")!!,
                    args.getString("relationship")!!,

                )



            it.findNavController().navigate(action)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}