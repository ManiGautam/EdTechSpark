package com.manijee.edtechspark.views.activities.ui.My_Orders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.manijee.edtechspark.databinding.FragmentMyordersBinding;


public class My_Orders_Fragment extends Fragment {

    private My_Orders_ViewModel myOrdersViewModel;
    private FragmentMyordersBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myOrdersViewModel =
                new ViewModelProvider(this).get(My_Orders_ViewModel.class);

        binding = FragmentMyordersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

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
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}