package com.deusai.test_deusai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.deusai.test_deusai.databinding.ActivityAboutUsBinding

class AboutUsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding başlatılıyor
        binding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Hakkımızda başlık ve içeriğini dinamik olarak değiştirme (isteğe bağlı)
        binding.tvAboutUsTitle.text = "Hakkımızda"
        binding.tvAboutUsContent.text = "Bu uygulama kullanıcı deneyimini artırmak amacıyla geliştirilmiştir. Kullanıcıların ihtiyaçlarına göre şekillendirilmiş çeşitli özellikler sunulmaktadır."
    }
}
