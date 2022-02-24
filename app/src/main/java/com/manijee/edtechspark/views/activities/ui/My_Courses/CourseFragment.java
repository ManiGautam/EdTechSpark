package com.manijee.edtechspark.views.activities.ui.My_Courses;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.manijee.edtechspark.common.PreferenceManager;
import com.manijee.edtechspark.databinding.FragmentMycoursesBinding;
import com.manijee.edtechspark.model.SubscibedCourseResponseModel;
import com.manijee.edtechspark.repository.RecyclerItemOnClickListener;
import com.manijee.edtechspark.views.presenters.CourseAdapter;

import java.util.List;

public class CourseFragment extends Fragment implements RecyclerItemOnClickListener {

    private CourseViewModel courseViewModel;
    private FragmentMycoursesBinding binding;
    RecyclerView recyclerView;
    List<SubscibedCourseResponseModel> courselist;
    SubscibedCourseResponseModel subscibedCourseResponseModel;
    PreferenceManager preferenceManager;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        preferenceManager = new PreferenceManager();
        courseViewModel = new ViewModelProvider(this).get(CourseViewModel.class);


        binding = FragmentMycoursesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = binding.courseviwers;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       // final TextView textView = binding.textHome;
        courseViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        courseViewModel.getSubcibedCourseList("3");
        courseViewModel.courselist.observe(getViewLifecycleOwner(), new Observer<List<SubscibedCourseResponseModel>>() {
            @Override
            public void onChanged(List<SubscibedCourseResponseModel> subscibedCourseResponseModels) {
                if (subscibedCourseResponseModels != null){
                    CourseAdapter adapter = new CourseAdapter(CourseFragment.this,subscibedCourseResponseModels);
                    recyclerView.setAdapter(adapter);
                    //recyclerView.notifyAll();
            }else {
                    Log.i("loding course","course not avalible yet");
                }
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void onItemClick(List item) {

    }
}

//    @Override
//    public void onSuccess(Response response) {
//        List<SubscibedCourseResponseModel> localcourselist = (List<SubscibedCourseResponseModel>) response.body();
//        for (SubscibedCourseResponseModel s:localcourselist) {
//            Log.i("Course name",""+s.getName()+"Unit Price"+s.getUnitPrice());
//        }
//    }
//
//    @Override
//    public void onFail(String msg) {
//        Log.i("error to fetch course",""+msg);
//    }
//}