package com.manijee.edtechspark.views.presenters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.manijee.edtechspark.R;
import com.manijee.edtechspark.model.MyOrdersResponseModel;
import com.manijee.edtechspark.repository.RecyclerItemOnClickListener;

import java.util.List;

public class MyordersAdapter extends RecyclerView.Adapter<MyordersAdapter.MyViewHolder>{
    List<MyOrdersResponseModel> orderslist;
    RecyclerItemOnClickListener listener;
    MyOrdersResponseModel myOrdersResponseModel;
    public MyordersAdapter(RecyclerItemOnClickListener listener, List<MyOrdersResponseModel> myorders){
        this.listener=listener;
        this.orderslist=myorders;
    }

    @NonNull
    @Override
    public MyordersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.myordescard,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyordersAdapter.MyViewHolder holder, int position) {
        MyOrdersResponseModel order = orderslist.get(position);
        holder.orderid.setText(myOrdersResponseModel.getOrderId());
        holder.paymentid.setText(myOrdersResponseModel.getPaymentId());
        holder.createddate.setText((CharSequence) myOrdersResponseModel.getCreatedDate());

    }


    @Override
    public int getItemCount() {
        return orderslist.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView orderid;
        TextView paymentid;
        TextView createddate;
        ConstraintLayout card;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            orderid=itemView.findViewById(R.id.orderId);
            paymentid=itemView.findViewById(R.id.Payment);
            createddate = itemView.findViewById(R.id.Date);
            card=itemView.findViewById(R.id.myorderscard);
        }
    }
}
