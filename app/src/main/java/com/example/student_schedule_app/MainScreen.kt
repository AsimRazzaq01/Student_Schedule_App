package com.example.student_schedule_app

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.sp


@Composable
fun DisplaHeading(Heading: String){
    // Text with parameter + gui
    Text(Heading, color =(MaterialTheme.colorScheme.primary), fontWeight =
        FontWeight.Bold, style = MaterialTheme.typography.headlineMedium  )
}


@Composable
fun DisplaNormalText(Text1: String){
    // Text with parameter + gui
    Text(Text1, color = Color.Magenta, style = MaterialTheme.typography.bodyLarge )
}




@Composable
fun MainScreen(modifier: Modifier){
    Column(modifier) {


        DisplaHeading("Student Name & Credits !")
        DisplaNormalText("Asim Razzaq")
        DisplaNormalText("my Credits: ?")










    //Text("Student Schedule App !", fontSize = 30.sp)




    } // End of Column
}  // End of Main func

