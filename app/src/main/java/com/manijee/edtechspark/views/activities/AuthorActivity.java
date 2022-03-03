package com.manijee.edtechspark.views.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.manijee.edtechspark.R;
import com.manijee.edtechspark.model.AllCoursesresponsemodel;
import com.squareup.picasso.Picasso;

public class AuthorActivity extends AppCompatActivity {
    TextView author, Name, profession;
    ImageView Mentorimg;
    AllCoursesresponsemodel.Mentor mentor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
        if (getIntent().getSerializableExtra("Mentor")!= null) {
            mentor = (AllCoursesresponsemodel.Mentor) getIntent().getSerializableExtra("Mentor");
            author = findViewById(R.id.AboutheAuthortxt);
            author.setText(mentor.getBiography());
            Name = findViewById(R.id.Name);
            Name.setText(mentor.getName());
            profession = findViewById(R.id.profession);
            profession.setText(mentor.getSkills());
            Mentorimg = findViewById(R.id.Mentorimg);
            Picasso.get().load(mentor.getImageUrl()).into(Mentorimg);
    }
}
}