package com.example.s8088576assignment2.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.semantics.setText
import androidx.compose.ui.semantics.text
import com.example.s8088576assignment2.databinding.ActivityLoginBinding
import com.example.s8088576assignment2.ui.dashboard.DashboardActivity
import com.example.s8088576assignment2.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set default values for speed
        binding.usernameEditText.setText("manu") // Set your first name
        binding.passwordEditText.setText("8088576") // Set your student ID

        binding.loginButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()
            // IMPORTANT: Change "footscray" to your campus: "sydney" or "br" if needed
            authViewModel.login("footscray", username, password)
        }

        authViewModel.loginResult.observe(this) { keypass ->
            if (keypass != null) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, DashboardActivity::class.java).apply {
                    putExtra("KEYPASS", keypass)
                }
                startActivity(intent)
                finish()
            }
        }

        authViewModel.error.observe(this) { errorMessage ->
            if (errorMessage != null) {
                Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
            }
        }
    }
}
