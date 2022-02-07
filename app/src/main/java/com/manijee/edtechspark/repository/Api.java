package com.manijee.edtechspark.repository;

import com.manijee.edtechspark.model.CartRequestmodel;
import com.manijee.edtechspark.model.CartSavedErrorResponsemodel;
import com.manijee.edtechspark.model.CreateUserRequestModel;
import com.manijee.edtechspark.model.SubscibedCourseResponseModel;
import com.manijee.edtechspark.model.ValidateUserRequestModel;
import com.manijee.edtechspark.model.ValidateUserResponsemodel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {
    public static final String BASE_URL = "http://edtechsparkapi.azurewebsites.net/";

    @POST("api/Auth/CreateUser")
    Call<ResponseBody> createUser(@Body CreateUserRequestModel createUserRequestModel);

    @POST("api/Auth/ValidateUser")
    Call<ValidateUserResponsemodel> validateUser(@Body ValidateUserRequestModel userRequestModel);

    @GET("api/Course/GetSubscribedCourses/{UserId}")
    Call<List<SubscibedCourseResponseModel>> getsubscibedcoursesbyuserid(@Path("UserId") String UserId);

    @POST("api/Cart/SaveCart")
    Call<CartSavedErrorResponsemodel> SaveCart(@Body CartRequestmodel cartRequestmodel);

    @GET("api/Catalog/GetAll")
    Call<List<CreateUserRequestModel>> getAllCatalog(CreateUserRequestModel createUserRequestModel);

    @GET("api/Catalog/GetCourseWithLessons")
    Call<List<CreateUserRequestModel>> getCoursewithLesson();

    @GET("api/Category/GetAll")
    Call<List<CreateUserRequestModel>> getAllCategory(CreateUserRequestModel createUserRequestModel);

    @POST("api/Category/Add")
    Call<List<CreateUserRequestModel>> addCategory(CreateUserRequestModel createUserRequestModel);

    @GET("api/Course/GetAll")
    Call<List<CreateUserRequestModel>> getAllCourses(CreateUserRequestModel createUserRequestModel);

    @GET("api/Course/Get")
    Call<List<CreateUserRequestModel>> getCoureswithCategory(CreateUserRequestModel createUserRequestModel);

    @POST("api/Course/Add")
    Call<List<CreateUserRequestModel>> addCourse(CreateUserRequestModel createUserRequestModel);

    @PUT("api/Course/Update")
    Call<List<CreateUserRequestModel>> updateCourse(CreateUserRequestModel createUserRequestModel);

    @DELETE("api/Course/Delete")
    Call<List<CreateUserRequestModel>> deleteCourse(CreateUserRequestModel createUserRequestModel);

    @GET("api/Course/GetCourseSubscription")
    Call<List<CreateUserRequestModel>> getCourseSubscriptionbyuseridandcourseid(CreateUserRequestModel createUserRequestModel);

    @GET("api/CourseTopic/GetAll")
    Call<List<CreateUserRequestModel>> getallCourseTopic(CreateUserRequestModel createUserRequestModel);

    @GET("api/CourseTopic/Get")
    Call<List<CreateUserRequestModel>> getCoursetopicbyid(CreateUserRequestModel createUserRequestModel);

    @GET("api/CourseTopic/GetTopicsByCourse")
    Call<List<CreateUserRequestModel>> getcoursetopicbycourseid(CreateUserRequestModel createUserRequestModel);

    @POST("api/CourseTopic/Add")
    Call<List<CreateUserRequestModel>> addCoursetopic(CreateUserRequestModel createUserRequestModel);

    @PUT("api/CourseTopic/Update")
    Call<List<CreateUserRequestModel>> updateCoursetopic(CreateUserRequestModel createUserRequestModel);

    @DELETE("api/CourseTopic/Delete")
    Call<List<CreateUserRequestModel>> deleteCoursetopic(CreateUserRequestModel createUserRequestModel);

    @GET("api/CourseLesson/GetAll")
    Call<List<CreateUserRequestModel>> getallcourselesson(CreateUserRequestModel createUserRequestModel);

    @GET("api/CourseLesson/Get")
    Call<List<CreateUserRequestModel>> getcourselessonbyid(CreateUserRequestModel createUserRequestModel);

    @GET("api/CourseLesson/GetLessonsByTopic")
    Call<List<CreateUserRequestModel>> getcourselessonbycoursetopic(CreateUserRequestModel createUserRequestModel);

    @POST("api/CourseLesson/Add")
    Call<List<CreateUserRequestModel>> addCourselesson(CreateUserRequestModel createUserRequestModel);

    @PUT("/api/CourseLesson/Update")
    Call<List<CreateUserRequestModel>> updateCourselesson(CreateUserRequestModel createUserRequestModel);

    @DELETE("api/CourseLesson/Delete")
    Call<List<CreateUserRequestModel>> deleteCourselesson(CreateUserRequestModel createUserRequestModel);

    @GET("api/Mentor/GetAll")
    Call<List<CreateUserRequestModel>> getallMentor(CreateUserRequestModel createUserRequestModel);

    @GET("api/Mentor/Get")
    Call<List<CreateUserRequestModel>> getMentorbyid(CreateUserRequestModel createUserRequestModel);

    @POST("api/Mentor/Add")
    Call<List<CreateUserRequestModel>> addMentor(CreateUserRequestModel createUserRequestModel);

    @PUT("api/Mentor/Update")
    Call<List<CreateUserRequestModel>> updatementor(CreateUserRequestModel createUserRequestModel);

    @DELETE("/api/Mentor/Delete")
    Call<List<CreateUserRequestModel>> deletementor(CreateUserRequestModel createUserRequestModel);

    @GET("api/Order/GetUserOrders")
    Call<List<CreateUserRequestModel>> getuserorder(CreateUserRequestModel createUserRequestModel);

    @GET("api/Order/GetOrderDetails")
    Call<List<CreateUserRequestModel>> getorderdetalis(CreateUserRequestModel createUserRequestModel);

    @POST("api/Payment/CreateOrder")
    Call<List<CreateUserRequestModel>> createorder(CreateUserRequestModel createUserRequestModel);

    @POST("api/Payment/SavePaymentDetails")
    Call<List<CreateUserRequestModel>> savePaymentDetalies(CreateUserRequestModel createUserRequestModel);

}
