package com.deusai.test_deusai

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deusai.test_deusai.databinding.ActivityPasswordResetBinding

class PasswordResetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPasswordResetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordResetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnResetPassword.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()

            if (email.isEmpty()) {
                Toast.makeText(this, "Lütfen e-posta adresinizi girin.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Burada e-posta doğrulama ve şifre sıfırlama işlemi yapılabilir
            // Örneğin, e-posta gönderme işlemi simüle edilebilir

            Toast.makeText(this, "Şifre sıfırlama bağlantısı gönderildi.", Toast.LENGTH_SHORT).show()
            finish()  // Ekranı kapatıp bir önceki ekrana dönüyoruz
        }
    }
}
