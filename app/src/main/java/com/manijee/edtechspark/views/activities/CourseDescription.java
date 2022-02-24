package com.manijee.edtechspark.views.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.manijee.edtechspark.R;
import com.manijee.edtechspark.model.AllCoursesresponsemodel;

import java.util.List;

public class CourseDescription extends AppCompatActivity {
List<AllCoursesresponsemodel> course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_description);
        if (getIntent().getSerializableExtra("Course")!= null){

            course = (List<AllCoursesresponsemodel>) getIntent().getSerializableExtra("Course");
            Log.i("course",course.get(0).getDescription());
        }

    }
}