package br.com.zapgroup.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.com.zapgroup.databinding.ActivityPropertyListBinding
import br.com.zapgroup.utils.Status
import br.com.zapgroup.viewmodel.PropertyListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PropertyListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPropertyListBinding
    private val viewModel: PropertyListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPropertyListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchList()
    }

    private fun fetchList() {
        viewModel.getVivaPropertyList().observe(this, Observer {
            it?.let { resourceData ->
                when (resourceData.status) {
                    Status.SUCCESS -> {
                        binding.listtest.text = resourceData.data?.get(0)?.images ?: ""
                        val i = Intent(this, PropertyDetailActivity::class.java)
                        i.putExtra("EXTRA_ID", resourceData.data?.get(0)?.id)
                        startActivity(i)
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