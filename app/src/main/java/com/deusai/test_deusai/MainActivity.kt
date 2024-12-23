package com.deusai.test_deusai

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.deusai.test_deusai.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var doubleBackToExitPressedOnce = false // Çıkış için çift geri basma kontrolü

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Özellikleri başlatma
        setupImagePicker() // Resim seçici
        setupFilterButtons() // Filtre butonları
        setupNavigationButtons() // Alt navigasyon butonları

        // "Oluştur" butonuna tıklama işlemi
        binding.btnCreate.setOnClickListener {
            val userInput = binding.etUserInput.text.toString()
            if (userInput.isEmpty()) {
                Toast.makeText(this, "Lütfen bir metin girin!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Girilen Metin: $userInput", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, DynamicTipsAdapterActivity::class.java) // şu kısımda uygulama çöküyor
                startActivity(intent)
                finish()  // Bu Activity'yi kapat
                // Burada girilen metinle işlem yapabilirsiniz
            }
        }
    }

    // Resim seçici başlatma
    private fun setupImagePicker() {
        val imagePickerLauncher = registerForActivityResult(
            ActivityResultContracts.GetContent()
        ) { uri: Uri? ->
            uri?.let {
                Toast.makeText(this, "Resim Seçildi: $it", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnImagePicker.setOnClickListener {
            if (checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                imagePickerLauncher.launch("image/*")
            } else {
                requestPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }
    }

    // İzin kontrolü
    private fun checkPermission(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
    }

    // İzin talebi
    private fun requestPermission(permission: String) {
        ActivityCompat.requestPermissions(this, arrayOf(permission), 100)
    }

    // Filtre butonları oluşturma
    private fun setupFilterButtons() {
        val filters = listOf(
            "Normal" to false,
            "Premium 1" to true,
            "Premium 2" to true,
            "Vintage" to false
        )

        filters.forEach { (filterName, isPremium) ->
            val button = Button(this).apply {
                text = if (isPremium) "$filterName 🔒" else filterName
                isEnabled = !isPremium // Premium olmayanlar aktif
                setOnClickListener {
                    Toast.makeText(this@MainActivity, "$filterName Filtre Seçildi", Toast.LENGTH_SHORT).show()
                }
            }
            binding.filterContainer.addView(button)
        }
    }

    // Alt navigasyon butonlarını ayarlama
    private fun setupNavigationButtons() {
        binding.btnTips.setOnClickListener {
            startActivity(Intent(this, TipsActivity::class.java))
        }

        binding.btnHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.btnUser.setOnClickListener {
            startActivity(Intent(this, UserActivity::class.java))
        }

        binding.btnPremium.setOnClickListener {
            startActivity(Intent(this, PremiumPlanActivity::class.java))
        }
    }

    // Geri tuşuna basıldığında yapılacaklar
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed() // Uygulamadan çık
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Çıkmak için tekrar geri tuşuna basın", Toast.LENGTH_SHORT).show()

        // Kullanıcı ikinci kez basmazsa durumu sıfırla
        Handler(Looper.getMainLooper()).postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }

}
