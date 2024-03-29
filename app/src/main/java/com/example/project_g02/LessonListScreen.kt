package com.example.project_g02

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_g02.adapters.LessonAdapter
import com.example.project_g02.databinding.ActivityLessonListScreenBinding
import com.example.project_g02.models.Lesson


class LessonListScreen : AppCompatActivity() {

    lateinit var binding: ActivityLessonListScreenBinding
    lateinit var myAdapter: LessonAdapter
    private lateinit var sharedPreferences: SharedPreferences

    var lessonList: MutableList<Lesson> = mutableListOf(
        Lesson(
            "Introduction to Learning HTML and CSS",
            "In this lesson, we will introduce you to the basics of HTML and CSS, covering fundamental concepts and principles.",
            "https://www.youtube.com/watch?v=hu-q2zYwEYs&list=PL4cUxeGkcC9ivBf_eKCPIAYXWzLlPAm6G",
            "Length: 19:59 min"
        ),
        Lesson(
            "What is JavaScript?",
            "In this lesson, we will explore the fundamentals of JavaScript, including its syntax, features, and usage in web development.",
            "https://www.youtube.com/watch?v=W6NZfCO5SIk",
            "Length: 48:16 min"
        ),
        Lesson(
            "Variables and Conditionals",
            "In this lesson, we will cover the concepts of variables and conditionals in programming. We'll discuss how variables store data and how conditionals control the flow of a program's execution.",
            "https://www.youtube.com/watch?v=4yOyVkU7pfc",
            "Length: 16:16 min"
        ),
        Lesson(
            "Loops",
            "In this lesson, we will delve into the concept of loops in programming. We'll explore how loops allow us to execute a block of code repeatedly, iterating over a set of data or until a condition is met.",
            "https://www.youtube.com/watch?v=Kn06785pkJg",
            "Length: 10:51 min"
        ),
        Lesson(
            "Functions",
            "In this lesson, we will cover the concept of functions in programming. We'll learn how to define functions to encapsulate reusable blocks of code, and how to call functions to execute specific tasks.",
            "https://www.youtube.com/watch?v=j1laALb8OVM",
            "Length: 1:36:53 min"
        )

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLessonListScreenBinding.inflate(layoutInflater)

        setContentView(binding.root)


        myAdapter = LessonAdapter(lessonList)
        binding.rv.adapter = myAdapter


        binding.rv.layoutManager = LinearLayoutManager(this)


        sharedPreferences = getSharedPreferences("listLesson", MODE_PRIVATE)

        // add a line between each item in the list
        binding.rv.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        myAdapter.onLessonClick = {lesson ->
            val intent = Intent(this@LessonListScreen, LessonDetailScreen::class.java)

            intent.putExtra("lesson", lesson)

            startActivity(intent)

        }


    }
}