package com.manijee.edtechspark.model;

import java.util.ArrayList;
import java.util.Date;

public class SubscibedCourseResponseModel {
    private int id;
    private String name;
    private String summary;
    private String description;
    private int sequence;
    private String imageUrl;
    private String demoUrl;
    private String url;
    private int unitPrice;
    private int difficultyType;
    private Date createdDate;
    private Date updatedDate;
    private boolean isActive;
    private int categoryId;
    private int mentorId;
    private Category category;
    private Mentor mentor;
    private ArrayList<CourseTopic> courseTopics;
    private ArrayList<Subscription> subscriptions;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDemoUrl() {
        return demoUrl;
    }

    public void setDemoUrl(String demoUrl) {
        this.demoUrl = demoUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getDifficultyType() {
        return difficultyType;
    }

    public void setDifficultyType(int difficultyType) {
        this.difficultyType = difficultyType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public ArrayList<CourseTopic> getCourseTopics() {
        return courseTopics;
    }

    public void setCourseTopics(ArrayList<CourseTopic> courseTopics) {
        this.courseTopics = courseTopics;
    }

    public ArrayList<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(ArrayList<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
 class Category{
     private int id;
     private String name;
     private String description;
     private ArrayList<String> courses;

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getDescription() {
         return description;
     }

     public void setDescription(String description) {
         this.description = description;
     }

     public ArrayList<String> getCourses() {
         return courses;
     }

     public void setCourses(ArrayList<String> courses) {
         this.courses = courses;
     }
 }

 class Mentor{
     private int id;
     private String name;
     private String email;
     private String title;
     private String biography;
     private String skills;
     private String imageUrl;
     private boolean isActive;
     private ArrayList<String> courses;
}

 class CourseLesson{
     private int id;
     private String lessonName;
     private String videoPath;
     private String contentPath;
     private String duration;
     private int sequence;
     private boolean isPreview;
     private boolean isActive;
     private int courseTopicId;
     private Date createdDate;
     private Date updatedDate;
     private String courseTopic;

}

 class CourseTopic{
     private int id;
     private String topicName;
     private boolean isActive;
     private int sequence;
     private int courseId;
     private String course;
     private ArrayList<CourseLesson> courseLessons;

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getTopicName() {
         return topicName;
     }

     public void setTopicName(String topicName) {
         this.topicName = topicName;
     }

     public boolean isActive() {
         return isActive;
     }

     public void setActive(boolean active) {
         isActive = active;
     }

     public int getSequence() {
         return sequence;
     }

     public void setSequence(int sequence) {
         this.sequence = sequence;
     }

     public int getCourseId() {
         return courseId;
     }

     public void setCourseId(int courseId) {
         this.courseId = courseId;
     }

     public String getCourse() {
         return course;
     }

     public void setCourse(String course) {
         this.course = course;
     }

     public ArrayList<CourseLesson> getCourseLessons() {
         return courseLessons;
     }

     public void setCourseLessons(ArrayList<CourseLesson> courseLessons) {
         this.courseLessons = courseLessons;
     }
 }

 class Role{
     private int id;
     private String name;
     private ArrayList<String> users;

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public ArrayList<String> getUsers() {
         return users;
     }

     public void setUsers(ArrayList<String> users) {
         this.users = users;
     }
 }

 class User{
     private int id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private boolean emailConfirmed;
    private Date createdDate;
    private ArrayList<String> subscriptions;
    private ArrayList<Role> roles;

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     public String getPassword() {
         return password;
     }

     public void setPassword(String password) {
         this.password = password;
     }

     public String getPhoneNumber() {
         return phoneNumber;
     }

     public void setPhoneNumber(String phoneNumber) {
         this.phoneNumber = phoneNumber;
     }

     public boolean isEmailConfirmed() {
         return emailConfirmed;
     }

     public void setEmailConfirmed(boolean emailConfirmed) {
         this.emailConfirmed = emailConfirmed;
     }

     public Date getCreatedDate() {
         return createdDate;
     }

     public void setCreatedDate(Date createdDate) {
         this.createdDate = createdDate;
     }

     public ArrayList<String> getSubscriptions() {
         return subscriptions;
     }

     public void setSubscriptions(ArrayList<String> subscriptions) {
         this.subscriptions = subscriptions;
     }

     public ArrayList<Role> getRoles() {
         return roles;
     }

     public void setRoles(ArrayList<Role> roles) {
         this.roles = roles;
     }
 }

 class Subscription{
    private int id;
    private int userId;
    private Date subscribedOn;
    private int courseId;
    private String course;
    private User user;

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public int getUserId() {
         return userId;
     }

     public void setUserId(int userId) {
         this.userId = userId;
     }

     public Date getSubscribedOn() {
         return subscribedOn;
     }

     public void setSubscribedOn(Date subscribedOn) {
         this.subscribedOn = subscribedOn;
     }

     public int getCourseId() {
         return courseId;
     }

     public void setCourseId(int courseId) {
         this.courseId = courseId;
     }

     public String getCourse() {
         return course;
     }

     public void setCourse(String course) {
         this.course = course;
     }

     public User getUser() {
         return user;
     }

     public void setUser(User user) {
         this.user = user;
     }
 }

