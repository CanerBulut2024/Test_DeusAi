package com.deusai.test_deusai

import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deusai.test_deusai.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Kayıt Ol Butonu
        binding.btnRegisterConfirm.setOnClickListener {
            val username = binding.etRegisterUsername.text.toString().trim()
            val email = binding.etRegisterEmail.text.toString().trim()
            val password = binding.etRegisterPassword.text.toString().trim()
            val confirmPassword = binding.etRegisterConfirmPassword.text.toString().trim()

            // Alanların boş olup olmadığını kontrol et
            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Tüm alanları doldurun.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // E-posta doğrulaması
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Geçerli bir e-posta adresi girin.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Şifre doğrulaması
            if (password != confirmPassword) {
                Toast.makeText(this, "Şifreler eşleşmiyor.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Şifre uzunluğunu kontrol et
            if (password.length < 6) {
                Toast.makeText(this, "Şifre en az 6 karakter olmalı.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Başarılı Kayıt
            Toast.makeText(this, "Kayıt başarılı!", Toast.LENGTH_SHORT).show()
            finish() // Aktiviteyi bitir ve önceki ekrana dön
        }
    }
}
