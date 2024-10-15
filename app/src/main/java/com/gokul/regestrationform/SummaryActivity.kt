package com.gokul.regestrationform

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.gokul.regestrationform.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var user: User

    private lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retriveUser()
        displayUser()
        setupClickListners()
    }

    private fun retriveUser() {

        user = intent.getSerializableExtra("user") as User

    }

    private fun displayUser() {

        binding.textViewUserFullname.text = user.getFullName()
        binding.textViewEmailAddress.text = user.email
        binding.textViewPhoneNumber.text = user.phoneNumber

    }

    private fun setupClickListners() {

        binding.textViewEmailAddress.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${user.email}")
            startActivity(intent)
        }

        binding.textViewPhoneNumber.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${user.phoneNumber}")
            startActivity(intent)
        }

    }
}