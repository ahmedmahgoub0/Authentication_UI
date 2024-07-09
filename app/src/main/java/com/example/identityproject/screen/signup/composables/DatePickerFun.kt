package com.example.identityproject.screen.signup.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.identityproject.R
import com.example.identityproject.util.convertToDayMonthYearFormat
import java.util.Calendar
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerFun(
    birthDate: String,
    onDateChange: (String) -> Unit
) {
    val openDialog = remember { mutableStateOf(false) }

    if (openDialog.value) {
        val now = Calendar.getInstance()
        now.time = Date()

        val selectableDate: SelectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return utcTimeMillis <= now.timeInMillis
            }
        }

        val datePickerState = rememberDatePickerState(
            initialSelectedDateMillis = now.timeInMillis,
            yearRange = now.get(Calendar.YEAR) - 100..now.get(Calendar.YEAR),
            selectableDates = selectableDate
        )

        DatePickerDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        onDateChange(
                            datePickerState.selectedDateMillis!!.convertToDayMonthYearFormat()
                        )
                    },
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { openDialog.value = false }) { Text("Cancel") }
            }
        ) {
            DatePicker(
                state = datePickerState,
                colors = DatePickerDefaults.colors(
                    selectedDayContentColor = Color.White,
                )
            )
        }
    }

    Row(
        Modifier
            .padding(8.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(100.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = birthDate,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxWidth()
                .weight(1f)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_down_circle),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    openDialog.value = true
                }
        )
    }
}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CustomDatePickerDialog(
//    onDismissRequest: () -> Unit,
//    modifier: Modifier = Modifier,
//    onDateChange: () -> Unit,
//    shape: Shape = DatePickerDefaults.shape,
//    tonalElevation: Dp = DatePickerDefaults.TonalElevation,
//    colors: DatePickerColors = DatePickerDefaults.colors(),
//    properties: DialogProperties = DialogProperties(usePlatformDefaultWidth = false),
//    content: @Composable ColumnScope.() -> Unit
//) {
//    BasicAlertDialog(
//        onDismissRequest = onDismissRequest,
//        modifier = modifier
//            .wrapContentHeight()
//            .padding(16.dp),
//        properties = properties
//    ) {
//        Surface(
//            modifier = Modifier
//                .widthIn(max = 360.dp)
//                .heightIn(max = 568.dp),
//            shape = shape,
//            color = colors.containerColor,
//            tonalElevation = tonalElevation,
//        ) {
//            Column(verticalArrangement = Arrangement.SpaceBetween) {
//                content()
//                // Buttons
//                Box(
//                    modifier = Modifier
//                        .align(Alignment.End)
//                        .padding(PaddingValues(bottom = 8.dp, end = 6.dp))
//                ) {
//                    Row() {
//                        Text(
//                            modifier = Modifier
//                                .padding(end = 4.dp)
//                                .clip(RoundedCornerShape(24.dp))
//                                .clickable { onDismissRequest() }
//                                .padding(8.dp),
//                            text = "Cancel",
//                            color = MaterialTheme.colorScheme.primary,
//                            style = MaterialTheme.typography.titleMedium
//                        )
//                        Text(
//                            modifier = Modifier
//                                .padding(start = 4.dp)
//                                .clip(RoundedCornerShape(24.dp))
//                                .clickable { onDateChange() }
//                                .padding(8.dp),
//                            text = "Cancel",
//                            color = MaterialTheme.colorScheme.primary,
//                            style = MaterialTheme.typography.titleMedium
//                        )
//                    }
//                }
//            }
//        }
//    }
//}