package com.khrystynasika.movievision.util

import kotlinx.datetime.Clock
import kotlinx.datetime.DatePeriod
import kotlinx.datetime.LocalDate
import kotlinx.datetime.Month
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import kotlinx.datetime.toLocalDateTime

fun getMovieCurrentDate(): String {
    val currentDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    return formatMovieDate(currentDate)
}

fun getMovieYearsAgo(years: Int): String {
    val currentDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    val newDate = currentDate - DatePeriod(years = years)
    return formatMovieDate(newDate)
}

fun getMovieMonthsAgo(months: Int): String {
    val currentDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    val newDate = currentDate - DatePeriod(months = months)
    return formatMovieDate(newDate)
}


fun getStartOfLastYear(): String {
    val currentDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    val newDate = currentDate - DatePeriod(years = 1)

    // Get start of last year date: current year - 1 + 1st of January
    return formatMovieDate(LocalDate(year = newDate.year, month = Month.JANUARY, dayOfMonth = 1))
}

fun getEndOfLastYear(): String {
    val currentDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    val newDate = currentDate - DatePeriod(years = 1)

    // Get last year date: current year - 1 + 1st of January
    return formatMovieDate(LocalDate(year = newDate.year, month = Month.DECEMBER, dayOfMonth = 31))
}

fun formatMovieDate(date: LocalDate): String {
    return "${date.year}−${
        date.monthNumber.toString().padStart(2, '0')
    }−${date.dayOfMonth.toString().padStart(2, '0')}"
}