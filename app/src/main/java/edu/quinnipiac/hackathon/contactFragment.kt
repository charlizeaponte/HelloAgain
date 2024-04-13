package edu.quinnipiac.hackathon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
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

        val name = requireArguments().getString("contact_name").orEmpty()

        view.findViewById<TextView>(R.id.about_name_title).setText("About $name")

        binding.conbackbutton.setOnClickListener {

           it.findNavController().navigate(R.id.action_contactFragment_to_infoFragment)
        }
        binding.conForbutton.setOnClickListener {
            val args = requireArguments();

            val action = contactFragmentDirections
                .actionContactFragmentToReasonFragment(
                    args.getString("your_name")!!,
                    args.getString("contact_name")!!,
                    args.getString("relationship")!!,
                    view.findViewById<EditText>(R.id.field_contact_context).text.toString()
                )



            it.findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}