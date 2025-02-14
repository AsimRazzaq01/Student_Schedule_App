package com.example.student_schedule_app

class Student(var name: String,var major: String,var courses: (List<CourseInfo>)   ) {

    //member functions
    fun TotalCredits(): Int {
        var totalcred = courses.sumOf { it.credits }

        return totalcred
    }



}