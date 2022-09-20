package com.example.lemonadeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lemonadeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var clicksUntilJuice = 0

    private var isLemonSelected = false
    private var isSqueezed = false
    private var isDrinked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.image.setOnClickListener {
            changeLemonadeStatus()
        }
    }

    private fun changeLemonadeStatus() {

        if(!isLemonSelected)
        {
            binding.image.setImageResource(R.drawable.lemon_squeeze)
            binding.textview.text = getString(R.string.lemon_squeeze)

            clicksUntilJuice = (Math.random() * (10 - 5 + 1)).toInt() + 5

            isLemonSelected = true
            return
        }

        if(!isSqueezed) {
            if(clicksUntilJuice > 0) {
                clicksUntilJuice--
                binding.textview.text = clicksUntilJuice.toString()
                return
            }

            binding.image.setImageResource(R.drawable.lemon_drink)
            binding.textview.text = getString(R.string.lemon_drink)

            isSqueezed = true
            return
        }

        if(!isDrinked) {

            binding.image.setImageResource(R.drawable.lemon_restart)
            binding.textview.text = getString(R.string.lemon_empty_glass)

            isDrinked = true
            return
        }

        clicksUntilJuice = 0
        isDrinked = false
        isSqueezed = false
        isLemonSelected = false

        binding.image.setImageResource(R.drawable.lemon_tree)
        binding.textview.text = getString(R.string.lemon_select)
    }
}