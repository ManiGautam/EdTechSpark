package com.manijee.edtechspark.views.activities;

import static com.manijee.edtechspark.common.Constriants.USERID;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.manijee.edtechspark.R;
import com.manijee.edtechspark.common.PreferenceManager;
import com.manijee.edtechspark.common.Utills;
import com.manijee.edtechspark.model.AllCoursesresponsemodel;
import com.manijee.edtechspark.model.CartRequestmodel;
import com.manijee.edtechspark.model.CartSavedErrorResponsemodel;
import com.manijee.edtechspark.repository.OnAddToCartListner;
import com.manijee.edtechspark.repository.RecyclerItemOnClickListener;
import com.manijee.edtechspark.views.presenters.AllCoursesAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class All_Courses extends AppCompatActivity implements RecyclerItemOnClickListener, OnAddToCartListner {
    ImageButton home,cart;
    AllCoursesViewModel allCoursesViewModel;
    Toolbar toolbar;
    TextView noofitem;
    ProgressBar progressBar;
    RecyclerView recyclerView;
    PreferenceManager preferenceManager;
    List<AllCoursesresponsemodel> courselist;
    AllCoursesresponsemodel course;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_courses);
        noofitem = findViewById(R.id.noofitemno);
        home = findViewById(R.id.Home);
        cart = findViewById(R.id.Cart);

        preferenceManager = PreferenceManager.getInstance(this);
        toolbar = findViewById(R.id.toolbar);
        view = toolbar.getRootView();
        setSupportActionBar(toolbar);
        progressBar = findViewById(R.id.progressBar2);
        progressBar.setVisibility(View.VISIBLE);
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
                    AllCoursesAdapter adapter = new AllCoursesAdapter(All_Courses.this,All_Courses.this,subscibedCourseResponseModels);
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.INVISIBLE);
                }else {
                    progressBar.setVisibility(View.INVISIBLE);
                    Log.i("loding course","course not avalible yet");
                }
            }

       });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (preferenceManager.getInfo(USERID) !=null&&!preferenceManager.getInfo(USERID).isEmpty()){
            cart.setVisibility(View.VISIBLE);
            cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent move = new Intent(All_Courses.this,Cart.class);
                    startActivity(move);
                }
            });
            home.setVisibility(View.VISIBLE);
            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent move = new Intent(All_Courses.this,MainActivity.class);
                    startActivity(move);
                }
            });
        }else {
            cart.setVisibility(View.INVISIBLE);
            home.setVisibility(View.INVISIBLE);
            getMenuInflater().inflate(R.menu.overflowmenu, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.login){
            Intent i = new Intent(All_Courses.this,LoginPage.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.signup){
            Intent i = new Intent(All_Courses.this,CreateUserActivity.class);
            startActivity(i);
        }
        return true;
    }

    @Override
    public void onItemClick(List item) {
progressBar.setVisibility(View.INVISIBLE);
        Intent move = new Intent(All_Courses.this,CourseDescription.class);
        move.putExtra("Course", (Serializable) item);
        startActivity(move);
    }

    @Override
    public void onAddToCartClicked(AllCoursesresponsemodel allCoursesresponsemodel) {
if (preferenceManager.getInfo(USERID) !=null&&!preferenceManager.getInfo(USERID).isEmpty()){
    double total = allCoursesresponsemodel.getUnitPrice()+ Utills.getInstance().taxCalculator(allCoursesresponsemodel.getUnitPrice());
    CartRequestmodel.CartItem cartItem = new CartRequestmodel.CartItem("0",allCoursesresponsemodel.getCourseTopics().get(0).getCourseId(),allCoursesresponsemodel.getUnitPrice(),1, (int) total,"","");
    ArrayList<CartRequestmodel.CartItem> cartItemslist = new ArrayList<>();
    cartItemslist.add(cartItem);
    CartRequestmodel cartRequestmodel = new CartRequestmodel("1",Integer.parseInt(preferenceManager.getInfo(USERID)),"",true,cartItemslist);
    allCoursesViewModel.addthisitemtocart(cartRequestmodel);
    allCoursesViewModel.cartSavedResponsemodel.observe(this, new Observer<CartSavedErrorResponsemodel>() {
        @Override
        public void onChanged(CartSavedErrorResponsemodel cartSavedErrorResponsemodel) {
            Utills.getInstance().ShowMessage(view,cartSavedErrorResponsemodel.title+" Added to your Cart Succesfuly");
            ArrayList<CartSavedErrorResponsemodel.Cart> localresponsecartlist = cartSavedErrorResponsemodel.getErrors().getErrors();
                if (localresponsecartlist!=null&&localresponsecartlist.size()>0){
                    noofitem.setVisibility(View.VISIBLE);
                    noofitem.setText(""+localresponsecartlist.size());
                }
        }
    });


}else {
    Intent move = new Intent(All_Courses.this,LoginPage.class);
    startActivity(move);
}

    }

    @Override
    public void addCoursetoCart(CartRequestmodel cartRequestmodel) {

    }
}