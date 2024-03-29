package com.example.project_g02

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.project_g02.databinding.ActivityLessonDetailScreenBinding
import com.example.project_g02.models.Lesson


class LessonDetailScreen : AppCompatActivity() {
    lateinit var binding: ActivityLessonDetailScreenBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLessonDetailScreenBinding.inflate(layoutInflater)

        val lesson: Lesson = intent.getSerializableExtra("lesson") as Lesson

        sharedPreferences = getSharedPreferences("listLesson", MODE_PRIVATE)

        setContentView(binding.root)

        binding.button5.setOnClickListener {
            val intent: Intent = Intent(this@LessonDetailScreen, LessonListScreen::class.java)
            startActivity(intent)
        }

        binding.tvvideoTitle.text = lesson.lessonName
        binding.videoDescription.text = lesson.lessonDescription
        binding.lengthDetail.text = lesson.lessonDuration

        binding.btnWatch.setOnClickListener {
            val videoUrl = lesson.lessonURL
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl))
            startActivity(intent)

        }

        binding.completionButton.setOnClickListener {
            binding.completionStatus.visibility = View.VISIBLE

            lesson.isCompleted = true
//            val intent = Intent()
//            intent.putExtra("updatedLesson", lesson)
//            setResult(Activity.RESULT_OK, intent)

        }

    }
}
