package edu.quinnipiac.hackathon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.BlockThreshold
import com.google.ai.client.generativeai.type.HarmCategory
import com.google.ai.client.generativeai.type.SafetySetting
import com.google.ai.client.generativeai.type.generationConfig
import com.google.gson.Gson
import com.google.gson.JsonParser
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


    suspend fun getResponses(
        your_name: String,
        contact_name: String,
        relationship: String,
        contact_context: String,
        contacting_reason: String
    ): Array<String> {
        val model = GenerativeModel(
            "gemini-1.0-pro",
            // Retrieve API key as an environmental variable defined in a Build Configuration
            // see https://github.com/google/secrets-gradle-plugin for further instructions
            BuildConfig.GEMINI_API_KEY,
            generationConfig = generationConfig {
                temperature = 0.9f
                topK = 1
                topP = 1f
                maxOutputTokens = 2048
            },
            safetySettings = listOf(
                SafetySetting(HarmCategory.HARASSMENT, BlockThreshold.MEDIUM_AND_ABOVE),
                SafetySetting(HarmCategory.HATE_SPEECH, BlockThreshold.MEDIUM_AND_ABOVE),
                SafetySetting(HarmCategory.SEXUALLY_EXPLICIT, BlockThreshold.MEDIUM_AND_ABOVE),
                SafetySetting(HarmCategory.DANGEROUS_CONTENT, BlockThreshold.MEDIUM_AND_ABOVE),
            ),
        )
        val prompt = """
           You are an AI Assistant helping $your_name reconnect with their $relationship, $contact_name. $your_name has provided some context about $relationship:
           
           $contact_context
           
           $your_name wants to connect with $contact_name because...
           
           $contacting_reason
           
           Come up with at least 20 text messages $your_name can send $contact_name to reconnect. These texts should not be too long, but also not too short. Do not assume anything that wasn't included in the prompt above. These text messages should be complete and ready to copy and paste without editing anything (like placeholders) or finishing sentences. The messages should be conversation starters, as they will most likely be sent to $contact_context out of the blue.

           Format the texts in a JSON format (array of strings). Do not include any additional surrounding syntax for markdown. The format should be just like the following:
           [
               "message", 
               "message",
               "message"
           ]
       """.trimIndent()

        val response = model.generateContent(prompt);
        val stringArray: Array<String> = Gson().fromJson(response.text, Array<String>::class.java)

        return stringArray

    }


}