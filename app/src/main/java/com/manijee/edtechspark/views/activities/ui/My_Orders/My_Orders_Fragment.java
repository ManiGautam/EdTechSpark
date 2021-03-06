package com.manijee.edtechspark.views.activities.ui.My_Orders;

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

import com.manijee.edtechspark.databinding.FragmentMyordersBinding;
import com.manijee.edtechspark.model.MyOrdersResponseModel;
import com.manijee.edtechspark.repository.RecyclerItemOnClickListener;
import com.manijee.edtechspark.views.presenters.MyordersAdapter;

import java.util.List;


public class My_Orders_Fragment extends Fragment implements RecyclerItemOnClickListener {

    private My_Orders_ViewModel myOrdersViewModel;
    List<MyOrdersResponseModel> orderslist;
    RecyclerView recyclerView;
    private FragmentMyordersBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myOrdersViewModel =
                new ViewModelProvider(this).get(My_Orders_ViewModel.class);

        binding = FragmentMyordersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = binding.orderviewer;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       // final TextView textView = binding.textSlideshow;
        myOrdersViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
         //       textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myOrdersViewModel.getordersbyuserid("3");
        myOrdersViewModel.orderslist.observe(getViewLifecycleOwner(), new Observer<List<MyOrdersResponseModel>>() {
            @Override
            public void onChanged(List<MyOrdersResponseModel> myOrdersResponseModels) {
                if (myOrdersResponseModels != null) {
//                for (MyOrdersResponseModel orders:myOrdersResponseModels){
//
//                }
                    MyordersAdapter myordersAdapter = new MyordersAdapter(My_Orders_Fragment.this,myOrdersResponseModels);
                    recyclerView.setAdapter(myordersAdapter);
                } else {
                    Log.i("orders", "orders not avalible yet");
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