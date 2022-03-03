package com.manijee.edtechspark.repository;

import com.manijee.edtechspark.model.AllCoursesresponsemodel;
import com.manijee.edtechspark.model.CartRequestmodel;

public interface OnAddToCartListner {
void onAddToCartClicked(AllCoursesresponsemodel allCoursesresponsemodel);
 void addCoursetoCart(CartRequestmodel cartRequestmodel);

}
