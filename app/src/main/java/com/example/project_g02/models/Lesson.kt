package com.example.project_g02.models

import java.io.Serializable

class Lesson: Serializable {
    val lessonName: String
    val lessonDescription: String
    val lessonURL: String
    val lessonDuration: String
    var isCompleted: Boolean

    constructor(
        lessonName: String,
        lessonDescription: String,
        lessonURL: String,
        lessonDuration: String,
    ) {
        this.lessonName = lessonName
        this.lessonDescription = lessonDescription
        this.lessonURL = lessonURL
        this.lessonDuration = lessonDuration
        this.isCompleted = false
    }
}