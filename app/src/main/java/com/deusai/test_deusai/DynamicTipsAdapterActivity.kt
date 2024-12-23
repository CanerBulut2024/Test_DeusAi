package com.deusai.test_deusai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.deusai.test_deusai.databinding.ActivityDynamicTipsAdapterBinding

class DynamicTipsAdapterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDynamicTipsAdapterBinding
    private val tipsList = listOf("Tip 1", "Tip 2", "Tip 3") // Example list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDynamicTipsAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView
        binding.recyclerViewTips.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewTips.adapter = DynamicTipsAdapter(tipsList)
    }
}
