package com.manijee.edtechspark.views.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.manijee.edtechspark.R;
import com.manijee.edtechspark.model.AllCoursesresponsemodel;

import java.util.ArrayList;

public class CourseLesson extends AppCompatActivity {
    ArrayList<AllCoursesresponsemodel.CourseLesson> courseLesson;
TextView header1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_lesson);
        if (getIntent().getSerializableExtra("Lesson")!= null) {

            courseLesson = (ArrayList<AllCoursesresponsemodel.CourseLesson>) getIntent().getSerializableExtra("Lesson");
            StringBuffer sb = new StringBuffer();
            for (AllCoursesresponsemodel.CourseLesson course:courseLesson) {
                sb.append(course.getCourseTopic());
            }
                    header1 = findViewById(R.id.GettingStarted);
header1.setText(sb);
        }
    }
}