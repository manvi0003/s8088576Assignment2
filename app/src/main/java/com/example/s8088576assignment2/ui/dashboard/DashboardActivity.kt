package com.example.s8088576assignment2.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.s8088576assignment2.data.Entity
import com.example.s8088576assignment2.databinding.ActivityDashboardBinding
import com.example.s8088576assignment2.ui.details.DetailsActivity
import com.example.s8088576assignment2.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private val dashboardViewModel: DashboardViewModel by viewModels()
    private lateinit var dashboardAdapter: DashboardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val keypass = intent.getStringExtra("KEYPASS")
        setupRecyclerView()

        if (keypass != null) {
            dashboardViewModel.loadDashboardData(keypass)
        } else {
            Toast.makeText(this, "Error: Missing keypass", Toast.LENGTH_LONG).show()
            finish() // Go back if key is missing
        }

        dashboardViewModel.dashboardData.observe(this) { entities ->
            dashboardAdapter.submitList(entities)
        }

        dashboardViewModel.error.observe(this) { error ->
            if (error != null) {
                Toast.makeText(this, error, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setupRecyclerView() {
        dashboardAdapter = DashboardAdapter { entity ->
            navigateToDetails(entity)
        }
        binding.recyclerView.apply {
            adapter = dashboardAdapter
            layoutManager = LinearLayoutManager(this@DashboardActivity)
        }
    }

    private fun navigateToDetails(entity: Entity) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtra("SELECTED_ENTITY", entity)
        }
        startActivity(intent)
    }
}
