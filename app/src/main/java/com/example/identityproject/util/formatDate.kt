package com.example.identityproject.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale


fun Date.convertToDayMonthYearFormat(): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(this)
}

fun Long.convertToDayMonthYearFormat(): String {
    val date = Date(this)
    return date.convertToDayMonthYearFormat()
}

@RequiresApi(Build.VERSION_CODES.O)
fun LocalDate.toFormattedString(): String {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    return this.format(formatter)
}