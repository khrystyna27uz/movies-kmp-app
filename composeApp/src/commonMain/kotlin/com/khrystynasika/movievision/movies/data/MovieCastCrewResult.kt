package com.khrystynasika.movievision.movies.data

import com.khrystynasika.movievision.movies.domain.FullCast
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieCastCrewResult(
    val id: Int,
    val cast: List<Cast>,
    val crew: List<Crew>,

    ) {
    @Serializable
    data class Cast(
        val id: Int,
        val character: String,
        val name: String,
        @SerialName("profile_path")
        val profilePath: String?
    )

    @Serializable
    data class Crew(
        val id: Int,
        val job: String,
        val name: String,
        val department: String,
        @SerialName("profile_path")
        val profilePath: String?
    )
}

fun MovieCastCrewResult.Crew.toCrew(): FullCast.Director =
    FullCast.Director(
        job = job,
        name = name,
        description = department,
        image = IMAGE_PATH_PART + profilePath,
    )

fun MovieCastCrewResult.Cast.toCrew(): FullCast.Actor =
    FullCast.Actor(
        image = IMAGE_PATH_PART + profilePath,
        name = name,
        role = character,
    )

fun MovieCastCrewResult.toFullCast(): FullCast =
    FullCast(
        director = crew.map { it.toCrew() }.first(),
        actors = cast.map { it.toCrew() }
    )

