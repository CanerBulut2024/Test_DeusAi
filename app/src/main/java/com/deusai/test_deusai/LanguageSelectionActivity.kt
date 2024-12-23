package com.deusai.test_deusai

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deusai.test_deusai.databinding.ActivityLanguageSelectionBinding

class LanguageSelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLanguageSelectionBinding
    private lateinit var sharedPreferences: SharedPreferences
    private var selectedLanguage: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLanguageSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("AppPreferences", MODE_PRIVATE)

        val languages = listOf("Türkçe", "English", "Français", "Deutsch", "Español")
        val languageCodes = listOf("tr", "en", "fr", "de", "es")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, languages)
        binding.languageList.adapter = adapter
        binding.languageList.choiceMode = android.widget.ListView.CHOICE_MODE_SINGLE

        binding.languageList.setOnItemClickListener { _, _, position, _ ->
            selectedLanguage = languageCodes[position]
            binding.nextButton.isEnabled = true
        }

        binding.nextButton.setOnClickListener {
            if (selectedLanguage != null) {
                saveLanguagePreference(selectedLanguage!!)
                Toast.makeText(this, "Dil seçimi: $selectedLanguage", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun saveLanguagePreference(language: String) {
        val editor = sharedPreferences.edit()
        editor.putString("selected_language", language)
        editor.putBoolean("is_language_selected", true)
        editor.apply()
    }


}
