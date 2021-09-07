package br.com.safeguardian.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.com.safeguardian.databinding.ActivityPropertyListBinding
import br.com.safeguardian.model.db.CredentialsTable
import br.com.safeguardian.utils.Status
import br.com.safeguardian.viewmodel.CredentialsListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CredentialsListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPropertyListBinding
    private val viewModel: CredentialsListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPropertyListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        save()
    }

    private fun save() {

        viewModel.addItemList(CredentialsTable(
            password = "12345",
                login = "kevin",
            description = "g-mail",
            createdAt = "test",
            lastView = "test",
            updatedAt = "test"
            )).observe(this, Observer {
            it?.let { resourceData ->
                when (resourceData.status) {
                    Status.SUCCESS -> {
                        fetchList()
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

    private fun fetchList() {
        viewModel.getCredentialList().observe(this, Observer {
            it?.let { resourceData ->
                when (resourceData.status) {
                    Status.SUCCESS -> {
                        Toast.makeText(this, "aloha", Toast.LENGTH_LONG).show()
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