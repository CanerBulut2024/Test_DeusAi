package com.deusai.test_deusai

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deusai.test_deusai.databinding.ActivityTipsBinding

class TipsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTipsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding başlatılıyor
        binding = ActivityTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Çevrimdışı erişim için önbellek ipuçları
        binding.btnOfflineCacheTips.setOnClickListener {
            Toast.makeText(this, "Çevrimdışı ipuçları önbelleğe alındı.", Toast.LENGTH_SHORT).show()
            // Önbellek işlemleri burada yapılabilir
        }
    }
}
