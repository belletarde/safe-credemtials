package br.com.zapgroup.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zapgroup.databinding.ActivityPropertyDetailBinding

class PropertyDetail : AppCompatActivity() {
    private lateinit var binding: ActivityPropertyDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPropertyDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}