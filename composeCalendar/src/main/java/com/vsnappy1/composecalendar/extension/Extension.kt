package com.vsnappy1.composecalendar.extension

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import java.util.Calendar


// TODO refactor code to make it more readable
// TODO add sliding effect when next or previous arrow is pressed
// TODO Develop Time Picker

fun Int.isLeapYear(): Boolean {
    // A year is a leap year if it is divisible by 4
    // but not divisible by 100, unless it is also divisible by 400
    return this % 4 == 0 && (this % 100 != 0 || this % 400 == 0)
}

fun Modifier.noRippleClickable(enabled: Boolean = true, onClick: () -> Unit): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
        enabled = enabled
    ) {
        onClick()
    }
}

fun Calendar.isEqual(calendar: Calendar?): Boolean {
    calendar?.let {
        return get(Calendar.YEAR) == it.get(Calendar.YEAR) &&
                get(Calendar.MONTH) == it.get(Calendar.MONTH) &&
                get(Calendar.DAY_OF_MONTH) == it.get(Calendar.DAY_OF_MONTH);
    }
    return false
}