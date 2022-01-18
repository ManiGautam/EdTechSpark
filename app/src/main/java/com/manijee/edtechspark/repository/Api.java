package com.manijee.edtechspark.repository;

import com.manijee.edtechspark.model.CartRequestmodel;
import com.manijee.edtechspark.model.CartSavedErrorResponsemodel;
import com.manijee.edtechspark.model.CommonResponse;
import com.manijee.edtechspark.model.User;
import com.manijee.edtechspark.model.UserRequestModel;
import com.manijee.edtechspark.model.ValidateUserResponsemodel;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface Api {
    public static final String BASE_URL="http://edtechsparkapi.azurewebsites.net/";

    @POST("api/Auth/CreateUser")
    Call<CommonResponse> createUser(@Body User user);

    @POST("api/Auth/ValidateUser")
    Call<ValidateUserResponsemodel> validateUser(@Body UserRequestModel userRequestModel);

    @POST("api/Cart/SaveCart")
    Call<CartSavedErrorResponsemodel> SaveCart(@Body CartRequestmodel cartRequestmodel);

    @GET("api/Catalog/GetAll")
    Call<List<User>> getAllCatalog(User user);

    @GET("api/Catalog/GetCourseWithLessons/wd")
    Call<List<User>> getCoursewithLesson();

    @GET("api/Category/GetAll")
    Call<List<User>> getAllCategory(User user);

    @POST("api/Category/Add")
    Call<List<User>> addCategory(User user);

    @GET("api/Course/GetAll")
    Call<List<User>> getAllCourses(User user);

    @GET("api/Course/Get")
    Call<List<User>> getCoureswithCategory(User user);

    @POST("api/Course/Add")
    Call<List<User>> addCourse(User user);

    @PUT("api/Course/Update")
    Call<List<User>> updateCourse(User user);

    @DELETE("api/Course/Delete")
    Call<List<User>> deleteCourse(User user);

    @GET("api/Course/GetCourseSubscription")
    Call<List<User>> getCourseSubscriptionbyuseridandcourseid(User user);

    @GET("api/Course/GetSubscribedCourses")
    Call<List<User>> getsubscibedcoursesbyuserid(User user);

    @GET("api/CourseTopic/GetAll")
    Call<List<User>> getallCourseTopic(User user);

    @GET("api/CourseTopic/Get")
    Call<List<User>> getCoursetopicbyid(User user);

    @GET("api/CourseTopic/GetTopicsByCourse")
    Call<List<User>> getcoursetopicbycourseid(User user);

    @POST("api/CourseTopic/Add")
    Call<List<User>> addCoursetopic(User user);

    @PUT("api/CourseTopic/Update")
    Call<List<User>> updateCoursetopic(User user);

    @DELETE("api/CourseTopic/Delete")
    Call<List<User>> deleteCoursetopic(User user);

    @GET("api/CourseLesson/GetAll")
    Call<List<User>> getallcourselesson(User user);

    @GET("api/CourseLesson/Get")
    Call<List<User>> getcourselessonbyid(User user);

    @GET("api/CourseLesson/GetLessonsByTopic")
    Call<List<User>> getcourselessonbycoursetopic(User user);

    @POST("api/CourseLesson/Add")
    Call<List<User>> addCourselesson(User user);

    @PUT("/api/CourseLesson/Update")
    Call<List<User>> updateCourselesson(User user);

    @DELETE("api/CourseLesson/Delete")
    Call<List<User>> deleteCourselesson(User user);

    @GET("api/Mentor/GetAll")
    Call<List<User>> getallMentor(User user);

    @GET("api/Mentor/Get")
    Call<List<User>> getMentorbyid(User user);

    @POST("api/Mentor/Add")
    Call<List<User>> addMentor(User user);

    @PUT("api/Mentor/Update")
    Call<List<User>> updatementor(User user);

    @DELETE("/api/Mentor/Delete")
    Call<List<User>> deletementor(User user);

    @GET("api/Order/GetUserOrders")
    Call<List<User>> getuserorder(User user);

    @GET("api/Order/GetOrderDetails")
    Call<List<User>> getorderdetalis(User user);

    @POST("api/Payment/CreateOrder")
    Call<List<User>> createorder(User user);

    @POST("api/Payment/SavePaymentDetails")
    Call<List<User>> savePaymentDetalies(User user);

}
