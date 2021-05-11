package br.com.zapgroup.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import br.com.zapgroup.databinding.ActivityPropertyDetailBinding
import br.com.zapgroup.utils.Status
import br.com.zapgroup.viewmodel.PropertyDetailViewModel
import br.com.zapgroup.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PropertyDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPropertyDetailBinding
    private val viewModel: PropertyDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPropertyDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getById()
    }

    private fun getById() {
        val id = intent.getStringExtra("EXTRA_ID") ?: ""

        viewModel.getById(id).observe(this, Observer {
            it?.let { resourceData ->
                when (resourceData.status) {
                    Status.SUCCESS -> {
                        binding.detailtest.text = resourceData.data?.images ?: ""
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, "Err", Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        Toast.makeText(this, "load", Toast.LENGTH_LONG).show()
                    }
                }
            }
        })
    }
}