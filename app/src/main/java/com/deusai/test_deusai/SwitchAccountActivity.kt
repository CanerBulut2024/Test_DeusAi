package com.deusai.test_deusai

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deusai.test_deusai.databinding.ActivitySwitchAccountBinding

class SwitchAccountActivity : AppCompatActivity() {
  //
    private lateinit var binding: ActivitySwitchAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding başlatılıyor
        binding = ActivitySwitchAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()
    }

    private fun setupListeners() {
        // Mevcut hesap seçimi
        binding.btnExistingAccount.setOnClickListener {
            Toast.makeText(this, "Mevcut hesap seçildi", Toast.LENGTH_SHORT).show()
            // Hesap değiştirme işlemi yapılabilir (örneğin, giriş yapma işlemi vb.)
        }

        // Yeni hesap ekleme
        binding.btnAddNewAccount.setOnClickListener {
            Toast.makeText(this, "Yeni hesap ekleme ekranına yönlendiriliyor", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))
            // Yeni hesap ekleme işlemi yapılabilir (örneğin, yeni kullanıcı kaydı vb.)
        }
    }
}
