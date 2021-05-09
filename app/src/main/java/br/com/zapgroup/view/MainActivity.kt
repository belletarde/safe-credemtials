package br.com.zapgroup.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import br.com.zapgroup.databinding.ActivityMainBinding
import br.com.zapgroup.di.netModule
import br.com.zapgroup.utils.Status
import br.com.zapgroup.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.loadingState.observe(this, Observer { result ->
            Toast.makeText(this, "Err", Toast.LENGTH_LONG).show()
        })

    }

    override fun onResume() {
        super.onResume()
        viewModel.getList()
    }
}