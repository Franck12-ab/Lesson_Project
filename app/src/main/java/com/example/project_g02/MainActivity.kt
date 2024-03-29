package com.example.project_g02

import android.content.Intent
import android.os.Bundle
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.example.project_g02.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. check shared preferences
        sharedPreferences = getSharedPreferences("NamePrefs", MODE_PRIVATE)

        // 2. check if there is a user in SharedPreferences
        val userExists = sharedPreferences.contains("KEY_USERNAME")
        if (userExists === true) {
            // a user already exists in Sharedpereferences, go to next screen
            val intent: Intent = Intent(this@MainActivity, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
            // return
        } else if (userExists === false) {
            // do nothing
            //Snackbar.show("No user exists")
        }



        binding.btnContinue.setOnClickListener {
            // 1. get the name
            val name: String = binding.etName.text.toString()

            if (name.isEmpty()) {
                val snackbar = Snackbar.make(binding.root, "Please enter your name", Snackbar.LENGTH_LONG)
                snackbar.show()
                return@setOnClickListener  // Exit click listener if name is empty
            }

            // 2. save before going to next screen
            val editor = sharedPreferences.edit()
            editor.putString("KEY_USERNAME", binding.etName.text.toString())
            editor.putInt("KEY_LESSONS_COMPLETED", 0)
            editor.apply()

            // 3. go to next screen
            val intent: Intent = Intent(this@MainActivity, WelcomeActivity::class.java)
            intent.putExtra("EXTRA_NAME", name)
            startActivity(intent)
        }
    }


}
