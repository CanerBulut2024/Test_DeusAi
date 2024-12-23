package com.deusai.test_deusai

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deusai.test_deusai.databinding.ActivityChangePasswordBinding

class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChangePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding başlatılıyor
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Kaydet butonuna tıklama işlemi
        binding.btnSavePassword.setOnClickListener {
            handleChangePassword()
        }
    }

    private fun handleChangePassword() {
        val currentPassword = binding.etCurrentPassword.text.toString()
        val newPassword = binding.etNewPassword.text.toString()
        val confirmPassword = binding.etConfirmPassword.text.toString()

        // Şifre doğrulama
        if (currentPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Lütfen tüm alanları doldurun!", Toast.LENGTH_SHORT).show()
            return
        }

        if (newPassword != confirmPassword) {
            Toast.makeText(this, "Yeni şifreler uyuşmuyor!", Toast.LENGTH_SHORT).show()
            return
        }

        if (newPassword.length < 6) {
            Toast.makeText(this, "Şifre en az 6 karakter olmalı!", Toast.LENGTH_SHORT).show()
            return
        }

        // Şifre değişim işlemi başarılı
        Toast.makeText(this, "Şifre başarıyla güncellendi!", Toast.LENGTH_SHORT).show()
        // Burada backend çağrısı yapabilirsiniz
        finish()
    }
}
