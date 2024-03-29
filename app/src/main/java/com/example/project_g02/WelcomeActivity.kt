package com.example.project_g02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project_g02.databinding.ActivityWelcome2Binding
import com.google.android.material.snackbar.Snackbar
import android.content.Intent
import android.content.SharedPreferences
import com.example.project_g02.LessonListScreen

class WelcomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityWelcome2Binding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcome2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("NamePrefs", MODE_PRIVATE)

        if (intent == null) {
            // error
            val snackbar = Snackbar.make(binding.root, "ERROR: No intent found", Snackbar.LENGTH_LONG)
            snackbar.show()
        } else {
            // intent exists

            val currUsername = sharedPreferences.getString("KEY_USERNAME", "")
            var lessonsCompleted = sharedPreferences.getInt("KEY_LESSONS_COMPLETED", 0)

            // Display welcome message
            val outputString: String = "Welcome back, $currUsername"
            binding.tvWelcomeBack.text = outputString
            binding.tvLsnCompleted.text = "Lessons Completed: $lessonsCompleted"
            binding.tvLsnRemain.text = "Lessons Remaining: ${5-lessonsCompleted}"
            binding.tvCompletion.text = "You have completed ${lessonsCompleted/5*100}% of the course!"
            }


            binding.btnContinueWelcome.setOnClickListener {
                val intent: Intent = Intent(this@WelcomeActivity, LessonListScreen::class.java)
                startActivity(intent)
            }


            binding.btnDeleteReset.setOnClickListener {
                sharedPreferences.edit().clear().commit();
                val intent: Intent = Intent(this@WelcomeActivity, MainActivity::class.java)
                startActivity(intent)
            }


        }

    }
