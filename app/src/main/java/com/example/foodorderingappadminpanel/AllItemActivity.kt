package com.example.foodorderingappadminpanel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingappadminpanel.adapter.AddItemAdapter
import com.example.foodorderingappadminpanel.databinding.ActivityAllItemBinding

class AllItemActivity : AppCompatActivity() {
    private val binding: ActivityAllItemBinding by lazy {
        ActivityAllItemBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val foodName = listOf("Burger", "Pizza", "Momo", "Sandwitch", "Burger", "Pizza")
        val foodPrice = listOf("$6", "$10", "$15", "$6", "$10", "$15")
        val menuImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu1,
            R.drawable.menu2
        )

        val adapter = AddItemAdapter(ArrayList(foodName) , ArrayList(foodPrice), ArrayList(menuImage))
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.menuRecyclerView.adapter = adapter

        binding.backButton2.setOnClickListener {
            finish()
        }
    }
}