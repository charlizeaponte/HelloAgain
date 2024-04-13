package edu.quinnipiac.hackathon.api

import android.os.Bundle
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content

class Prompt {

    companion object {
        val BUNDLE_API = "GEMINI_API_KEY";
        val BUNDLE_NAME = "CONTACT_NAME";
        val BUNDLE_RELATION = "CONTACT_RELATION";
        val BUNDLE_LAST_CONTACT_DATE = "LAST_CONTACT_DATE";
        val BUNDLE_LAST_CONTACT_CONTEXT = "LAST_CONTACT_CONTEXT";
        val BUNDLE_REASON = "REASON";
    }

    suspend fun BuildPrompt(bundle: Bundle) {

    }
}