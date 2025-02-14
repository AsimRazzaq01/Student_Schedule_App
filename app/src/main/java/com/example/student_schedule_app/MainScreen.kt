package com.example.student_schedule_app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DisplayHeading(Heading: String){
    // Text with parameter + gui
    Text(Heading, color =(MaterialTheme.colorScheme.primary), fontWeight =
        FontWeight.Bold, style = MaterialTheme.typography.headlineMedium  )
}


@Composable
fun DisplayNormalText(Text1: String){
    // Text with parameter + gui
    Text(Text1, color = Color.Magenta, style = MaterialTheme.typography.bodyLarge )
}


@Composable
fun DisplayStudentName_Credit(student: Student){
    // student parameter + gui
    Surface(modifier = Modifier.padding(20.dp), shape = RoundedCornerShape(10),
            shadowElevation = 30.dp)
    {
        Column {
            var student_credits = student.TotalCredits()

            DisplayHeading("Student Name & Credits !")
            DisplayNormalText("Asim Razzaq")
            DisplayNormalText("my Credits: $student_credits")


        }   // End Column
    }   // End Surface
}   // End Function




@Composable
fun DisplayCourseInfo(courseInfo: CourseInfo){
    // courseInfo parameter + gui

    //local var
    var name = courseInfo.CourseName
    var crDays = courseInfo.days
    var crStart = courseInfo.StartTime
    var crEnd = courseInfo.EndTime

    DisplayNormalText("$name  $crDays  $crStart  $crEnd")
}


@Composable
fun DisplayStudent_Schedule(student: Student){
    // student parameter + gui
    Surface(modifier = Modifier.padding(20.dp), shape = RoundedCornerShape(10),
        shadowElevation = 30.dp)
    {
        Column {

            // Display heading
            DisplayHeading("Student Schedule")

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










@Composable
fun MainScreen(modifier: Modifier){
    Column(modifier) {

//        // create Classes val for CourseInfo (MY ACTUAL CLASSES THIS SEMESTER)
        val class1 = CourseInfo("CSC 329","9:25 am", "10:40 am", "MW", 3 )
        val class2 = CourseInfo("BCS 371","10:50 am", "12:05 pm", "MW", 3 )
        val class3 = CourseInfo("CSC 311","12:15 pm", "1:30 pm", "MW", 3 )
        val class4 = CourseInfo("CSC 499","2:00 pm", "3:00 pm", "W", 3 )
        val class5 = CourseInfo("BCS 325","12:15 pm", "1:30 pm", "TR", 3 )
        val class6 = CourseInfo("CSC 466","4:30 pm", "5:45 pm", "T", 3 )

        // create student -> Which is me and input the classes
        val Asim = Student(
            "Asim Razzaq", "Computer Science", listOf(class1, class2, class3, class4,class5 ,class6)
        )

        // call Function for Top portion
        DisplayStudentName_Credit(Asim)

        // call Function for Bottom Portion of App
        DisplayStudent_Schedule(Asim)










    //Text("Student Schedule App !", fontSize = 30.sp)




    } // End of Column
}  // End of Main func

