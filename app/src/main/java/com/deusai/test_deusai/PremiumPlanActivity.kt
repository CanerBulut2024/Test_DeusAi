package com.deusai.test_deusai

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deusai.test_deusai.databinding.ActivityPremiumPlanBinding

class PremiumPlanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPremiumPlanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding başlatılıyor
        binding = ActivityPremiumPlanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Aylık plan seçimi
        binding.btnMonthlyPlan.setOnClickListener {
            Toast.makeText(this, "Aylık Premium Planı Seçildi", Toast.LENGTH_SHORT).show()
            // İşlem yapılabilir (örneğin, ödeme entegrasyonu)
        }

        // Yıllık plan seçimi
        binding.btnYearlyPlan.setOnClickListener {
            Toast.makeText(this, "Yıllık Premium Planı Seçildi", Toast.LENGTH_SHORT).show()
            // İşlem yapılabilir (örneğin, ödeme entegrasyonu)
        }

        // Plan detaylarını göster
        binding.btnPlanDetails.setOnClickListener {
            Toast.makeText(this, "Premium Plan Detayları", Toast.LENGTH_SHORT).show()
            // Kullanıcıya daha fazla bilgi gösterilebilir
        }
    }
}
