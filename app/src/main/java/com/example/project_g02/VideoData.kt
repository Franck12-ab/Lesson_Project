package com.example.project_g02

import java.io.Serializable

data class VideoData (
    val videoTitle: String,
    val videoDescription: String,
    val videoURL: String,
    val videoDuration: String,
    var isCompleted: Boolean = false
) : Serializable {
    override fun toString(): String {
        return "VideoMetaData(videoTitle='$videoTitle', videoDescription='$videoDescription', videoURL='$videoURL', videoDuration='$videoDuration', isCompleted=$isCompleted)"
    }
}
