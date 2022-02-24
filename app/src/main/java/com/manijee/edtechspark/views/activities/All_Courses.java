package com.manijee.edtechspark.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.manijee.edtechspark.R;
import com.manijee.edtechspark.model.AllCoursesresponsemodel;
import com.manijee.edtechspark.repository.RecyclerItemOnClickListener;
import com.manijee.edtechspark.views.presenters.AllCoursesAdapter;

import java.io.Serializable;
import java.util.List;

public class All_Courses extends AppCompatActivity implements RecyclerItemOnClickListener {
    AllCoursesViewModel allCoursesViewModel;
    RecyclerView recyclerView;
    List<AllCoursesresponsemodel> courselist;
    AllCoursesresponsemodel course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_courses);
        allCoursesViewModel = new ViewModelProvider(this).get(AllCoursesViewModel.class);
        recyclerView = findViewById(R.id.allcourse);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        allCoursesViewModel.getallCourseList();
        allCoursesViewModel.courselist.observe(this, new Observer<List<AllCoursesresponsemodel>>() {
            @Override
            public void onChanged(List<AllCoursesresponsemodel> subscibedCourseResponseModels) {
                if (subscibedCourseResponseModels != null){
//                for (S course:subscibedCourseResponseModels){
//                    Log.i("Course Name",course.getName());
//
//                }
                    AllCoursesAdapter adapter = new AllCoursesAdapter(All_Courses.this,subscibedCourseResponseModels);
                    recyclerView.setAdapter(adapter);
                }else {
                    Log.i("loding course","course not avalible yet");
                }
            }

       });

    }

    @Override
    public void onItemClick(List item) {

        Intent move = new Intent(All_Courses.this,CourseDescription.class);
        move.putExtra("Course", (Serializable) item);
        startActivity(move);
    }
}