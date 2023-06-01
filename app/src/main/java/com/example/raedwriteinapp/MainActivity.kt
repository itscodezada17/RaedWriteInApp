package com.example.raedwriteinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.raedwriteinapp.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.writebutton.setOnClickListener {
        val dataDir = ContextCompat.getDataDir(this)
        val file = File(dataDir, "file.txt")
        file.writeText(binding.editTextFile.text.toString())
        }

        binding.readButton.setOnClickListener {
            val dataDir = ContextCompat.getDataDir(this)
            val file = File(dataDir, "file.txt")
            if(file.exists()) {
                binding.readText.text=file.readText()
            }


        }




    }
}