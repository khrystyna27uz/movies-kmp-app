package com.khrystynasika.movievision.movies.data

import com.khrystynasika.movievision.movies.domain.Trailer
import kotlinx.serialization.Serializable

private const val VIDEO_PART_PATH = "https://www.youtube.com/watch?v="

@Serializable
data class TrailerResult(
    val results: List<Result>
) {
    @Serializable
    data class Result(
        val id: String,
        val name: String,
        val key: String,
        val type: String
    )
}


fun TrailerResult.toTrainer(): Trailer {
    val trainer = results.firstOrNull()
    return Trailer(
        title = trainer?.name,
        videoUrl = VIDEO_PART_PATH + { trainer?.key },
        type = trainer?.type
    )
}