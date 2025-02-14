package com.example.student_schedule_app

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


// DisplayHeading Function
@Composable
fun DisplayHeading(Heading: String){    // Start Function
    // Text with parameter + gui
    Text(Heading, color =(MaterialTheme.colorScheme.primary), fontWeight =
        FontWeight.Bold, style = MaterialTheme.typography.headlineMedium  )
}   // End Function


// DisplayNormalText Function
@Composable
fun DisplayNormalText(Text1: String){   // Start Function
    // Text with parameter + gui
    Text(Text1, color = Color.Magenta, style = MaterialTheme.typography.bodyLarge )
}   // End Function


// DisplayStudentName_Credit Function
@Composable
fun DisplayStudentName_Credit(student: Student){    // Start Function
    // student parameter + gui
    Surface(modifier = Modifier.padding(20.dp), shape = RoundedCornerShape(10),
            shadowElevation = 30.dp)
    {       // Start Surface
        Column {    // Start Column
            // variable that stores the total credits of the student
            var student_credits = student.TotalCredits()

            // Calling multiple Functions into this "Bubble" - Top
            DisplayHeading(" Student Name & Credits !  ")
            DisplayNormalText("   Asim Razzaq")
            DisplayNormalText("   Credits in progress: $student_credits ")


        }   // End Column
    }   // End Surface
}   // End Function


// DisplayCourseInfo Function
@Composable
fun DisplayCourseInfo(courseInfo: CourseInfo){  // Start Function
    //local var
    var name = courseInfo.CourseName
    var crDays = courseInfo.days
    var crStart = courseInfo.StartTime
    var crEnd = courseInfo.EndTime

    // calling Functions for normal texts
    DisplayNormalText("$name  $crDays  $crStart  $crEnd")

}   // End Function


// DisplayStudent_Schedule Function
@Composable
fun DisplayStudent_Schedule(student: Student){  // Start Function
    // student parameter + gui
    Surface(modifier = Modifier.padding(20.dp), shape = RoundedCornerShape(10),
        shadowElevation = 30.dp)
    {   // Start Surface
        Column {    // Start Column

            // Calling Functions into this "Bubble" - Mid

            // Display heading
            DisplayHeading(" Student Schedule                ")

            // Loop to display the class info
            var stCourses = student.courses.size
            var i = 0
            while (i < stCourses){
                DisplayCourseInfo(student.courses.get(i))
                i++
            }

        }   // End Column
    }   // End Surface
}   // End Function


// DisplayButtons Function
@Composable
fun DisplayButtons(student: Student){   // Start Function
    // student parameter + gui
    Surface(modifier = Modifier.padding(20.dp), shape = RoundedCornerShape(10),
        shadowElevation = 30.dp, )
    {   // Surface start
        Row(modifier = Modifier.padding(20.dp)) {      // Row Start

                //local Var
            val context = LocalContext.current

                // Creating Buttons for this "Bubble" - Bottom

                // First Button - for Total Credits taking
            Button( onClick = {
                Toast.makeText(context, "Total Credits : ${student.TotalCredits()} !", Toast.LENGTH_SHORT).show()
            })
            {
                Text("Total Credits")
            }

            // var for Optimal Study Hours > 2 hr per class well use 3 for this ex
            var studyHours = student.TotalCredits() * 3

                // Second Button - for Optimal Study Hour
            Button( onClick = {
                Toast.makeText(context, "Optimal Study Hours are : ${studyHours} !", Toast.LENGTH_SHORT).show()
            })
            {
                Text("Optimal Study Hours")
            }

        }   // End Row
    }   // End Surface
}   // End Function





// Main Screen Function
@Composable
fun MainScreen(modifier: Modifier){     // Start Function
    Column(modifier) {      // Start Column

//        // create Classes val for CourseInfo (MY ACTUAL CLASSES THIS SEMESTER)
        val class1 = CourseInfo("  CSC 329","09:25 am", "10:40 am", "MW", 3 )
        val class2 = CourseInfo("  BCS 371","10:50 am", "12:05 pm", "MW", 3 )
        val class3 = CourseInfo("  CSC 311","12:15 pm", "01:30 pm", "MW", 3 )
        val class4 = CourseInfo("  CSC 499","   2:00 pm", "03:00 pm", "W  ", 3 )
        val class5 = CourseInfo("  CSC 325","  12:15 pm", "01:30 pm", "TR", 3 )
        val class6 = CourseInfo("  CSC 466","    4:30 pm", "  5:45 pm", "T  ", 3 )

        // create student -> Which is me and input the Courses for my Scheduled Semester !
        val Asim = Student(
            "Asim Razzaq", "Computer Science", listOf(class1, class2, class3, class4,class5 ,class6)
        )

        // call Function - for Top portion of App
        DisplayStudentName_Credit(Asim)

        // call Function - for Mid Portion of App
        DisplayStudent_Schedule(Asim)

        // Call function for Buttons - Bottom Portion of App
        DisplayButtons(Asim)


    } // End of Column
}  // End of Main func

