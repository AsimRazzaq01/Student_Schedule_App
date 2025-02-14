package com.example.student_schedule_app

class Student(var name: String,var major: String,var courses: (List<CourseInfo>)   ) { // Start Class

    //member function to get the Total Credits !
    fun TotalCredits(): Int {   // Start Function
        var totalcred = courses.sumOf { it.credits }

        return totalcred

    }// Start Function
}   // End Class