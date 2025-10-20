package com.example.s8088576assignment2.ui.details

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.semantics.text
import com.example.s8088576assignment2.data.Entity
import com.example.s8088576assignment2.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val entity = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("SELECTED_ENTITY", Entity::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("SELECTED_ENTITY") as? Entity
        }

        entity?.let {
            binding.detailProperty1TextView.text = it.property1
            binding.detailProperty2TextView.text = it.property2
            binding.descriptionTextView.text = it.description
        }
    }
}
