package com.manijee.edtechspark.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.manijee.edtechspark.R;
import com.manijee.edtechspark.common.Utills;
import com.manijee.edtechspark.model.AllCoursesresponsemodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CourseDescription extends AppCompatActivity {
    Button courselesson,Author;
    TextView description,header,summary;
List<AllCoursesresponsemodel> course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_description);

        if (getIntent().getSerializableExtra("Course")!= null){

            course = (List<AllCoursesresponsemodel>) getIntent().getSerializableExtra("Course");
            Log.i("course",course.get(0).getDescription());
            Author = findViewById(R.id.Abouttheauthor);
            Author.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AllCoursesresponsemodel.Mentor mentor = course.get(0).getMentor();
                    if (mentor != null) {
                        Intent move = new Intent(CourseDescription.this, AuthorActivity.class);
                        move.putExtra("Mentor", (Serializable) course.get(0).getMentor());
startActivity(move);
                    }else {
                        Utills.getInstance().ShowMessage(v.getRootView(),"Mentor Details  not Available of this course");
                    }
                }
            });
            courselesson = findViewById(R.id.Courselesson);
            courselesson.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ArrayList<AllCoursesresponsemodel.CourseTopic> courseTopic = course.get(0).getCourseTopics();
                    if (courseTopic != null && courseTopic.size()>0) {
                      ArrayList<AllCoursesresponsemodel.CourseLesson> courseLesson = course.get(0).getCourseTopics().get(0).getCourseLessons();
                        if (courseLesson != null&&courseLesson.size()>0) {
                            Intent move = new Intent(CourseDescription.this, CourseLesson.class);
                            move.putExtra("Lesson", (Serializable) course);
                            startActivity(move);
                        }
                    }else {
                        Utills.getInstance().ShowMessage(v.getRootView(),"Topics Details not available for this course");
                    }
                }
            });

            description = findViewById(R.id.Description);
            Spanned html = Html.fromHtml(course.get(0).getDescription());
            description.setText(html);
            header = findViewById(R.id.headertxt);
            header.setText(course.get(0).getName());
            summary = findViewById(R.id.summarytxt);
            summary.setText(course.get(0).getSummary());


        }

    }
}