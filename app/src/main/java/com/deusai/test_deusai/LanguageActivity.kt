package com.deusai.test_deusai

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deusai.test_deusai.databinding.ActivityLanguageBinding
import java.util.*

class LanguageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLanguageBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding başlatılıyor
        binding = ActivityLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // SharedPreferences başlatılıyor
        sharedPreferences = getSharedPreferences("app_prefs", MODE_PRIVATE)

        setupListeners()
    }

    private fun setupListeners() {
        // Türkçe dil seçimi
        binding.btnTurkish.setOnClickListener {
            setLanguage("tr")
            Toast.makeText(this, "Türkçe Dil Seçildi", Toast.LENGTH_SHORT).show()
        }

        // İngilizce dil seçimi
        binding.btnEnglish.setOnClickListener {
            setLanguage("en")
            Toast.makeText(this, "English Language Selected", Toast.LENGTH_SHORT).show()
        }
    }

    // Seçilen dili SharedPreferences ile kaydet
    private fun setLanguage(languageCode: String) {
        val editor = sharedPreferences.edit()
        editor.putString("language", languageCode)
        editor.apply()

        // Locale oluşturuluyor ve ayarlanıyor
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        // Yeni dildeki konfigürasyonu oluşturuyoruz
        val config = resources.configuration
        config.setLocale(locale)

        // Konfigürasyonun geçerli kontekste uygulanması
        createConfigurationContext(config)

        // Uygulamanın dilini değiştirdikten sonra uygulamayı yeniden başlatmak gerekmiyor.
        // Ancak, dil değişikliğinin tüm uygulamaya yansıması için MainActivity'yi başlatıyoruz.
        navigateToMainScreen()
    }

    private fun navigateToMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Bu Activity'yi sonlandır
    }
}
