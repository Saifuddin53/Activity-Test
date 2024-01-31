//import androidx.compose.material3.icons.Default
//import androidx.compose.material3.icons.filled.*
//import androidx.compose.material3.material3Theme
package com.littlelemon.activitytest

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TimetableScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Date or Day Heading
        Text(
            text = "Monday, January 31, 2024",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Timetable List
        LazyColumn {
            items(lectures) { lecture ->
                LectureItem(lecture = lecture)
            }
        }
    }
}

@Composable
fun LectureItem(lecture: Lecture) {
    var showDialog by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                showDialog = true
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Lecture Name
        Text(
            text = lecture.name,
            modifier = Modifier.weight(1f)
        )

        // Attendance Status (Tick or Cross)
        Image(
            imageVector = if (lecture.attendanceStatus == AttendanceStatus.PRESENT) Icons.Default.Check else Icons.Default.Clear,
            contentDescription = "Attendance Status",
            modifier = Modifier
                .size(24.dp)
                .padding(start = 8.dp)
        )
    }

    if (showDialog) {
        MarkAttendanceDialog(
            onDismiss = { showDialog = false },
            onMarkAttendance = {
                // Handle marking attendance here
                showDialog = false
            }
        )
    }
}

@Composable
fun MarkAttendanceDialog(
    onDismiss: () -> Unit,
    onMarkAttendance: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text("Mark Attendance")
        },
        text = {
            Text("Did you attend this lecture?")
        },
        confirmButton = {
            Button(
                onClick = {
                    onMarkAttendance()
                }
            ) {
                Text("Yes")
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    onDismiss()
                }
            ) {
                Text("No")
            }
        }
    )
}

@Composable
fun TimetableApp() {
    TimetableScreen()
}

@Preview(showBackground = true)
@Composable
fun PreviewTimetableScreen() {
    TimetableApp()
}

data class Lecture(
    val name: String,
    val attendanceStatus: AttendanceStatus
)

enum class AttendanceStatus {
    PRESENT,
    ABSENT
}

val lectures = listOf(
    Lecture(name = "Mathematics", attendanceStatus = AttendanceStatus.PRESENT),
    Lecture(name = "Physics", attendanceStatus = AttendanceStatus.ABSENT),
    Lecture(name = "Chemistry", attendanceStatus = AttendanceStatus.PRESENT),
    // Add more lectures as needed
)

@Preview(showBackground = true)
@Composable
fun PreviewLectureItem() {
    LectureItem(lecture = Lecture(name = "Mathematics", attendanceStatus = AttendanceStatus.PRESENT))
}

fun check() {
    
}
