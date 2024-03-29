package com.example.project_g02.models

class LessonDetail {
    val videoTitle: String
    val videoDescription: String
    val videoURL: String
    val videoDuration: String
    var isCompleted: Boolean

    constructor(
        videoTitle: String,
        videoDescription: String,
        videoURL: String,
        videoDuration: String,
        isCompleted: Boolean = false
    ) {
        this.videoTitle = videoTitle
        this.videoDescription = videoDescription
        this.videoURL = videoURL
        this.videoDuration = videoDuration
        this.isCompleted = isCompleted
    }

    override fun toString(): String {
        return "LessonDetail(videoTitle='$videoTitle', videoDescription='$videoDescription', videoURL='$videoURL', videoDuration='$videoDuration', isCompleted=$isCompleted)"
    }


}