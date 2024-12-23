package com.deusai.test_deusai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.deusai.test_deusai.databinding.ActivityDynamicTipsBinding

class DynamicTipsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDynamicTipsBinding // ViewBinding initialization
    private val tipsList = listOf("Tip 1", "Tip 2", "Tip 3") // Example tips list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDynamicTipsBinding.inflate(layoutInflater) // Inflating with ViewBinding
        setContentView(binding.root)

        // Set up RecyclerView
        binding.recyclerViewTips.layoutManager = LinearLayoutManager(this) // Use recyclerViewTips
        binding.recyclerViewTips.adapter = DynamicTipsAdapter(tipsList) // Adapter initialization
    }
}
