package com.manijee.edtechspark.model;


import java.io.Serializable;
import java.util.ArrayList;

public class AllCoursesresponsemodel implements Serializable {
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
    private String createdDate;
    private String updatedDate;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
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

    public class Category{
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

    public class Mentor{
        private int id;
        private String name;
        private String email;
        private String title;
        private String biography;
        private String skills;
        private String imageUrl;
        private boolean isActive;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBiography() {
            return biography;
        }

        public void setBiography(String biography) {
            this.biography = biography;
        }

        public String getSkills() {
            return skills;
        }

        public void setSkills(String skills) {
            this.skills = skills;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        public ArrayList<String> getCourses() {
            return courses;
        }

        public void setCourses(ArrayList<String> courses) {
            this.courses = courses;
        }
    }

    public class CourseLesson{
        private int id;
        private String lessonName;
        private String videoPath;
        private String contentPath;
        private String duration;
        private int sequence;
        private boolean isPreview;
        private boolean isActive;
        private int courseTopicId;
        private String createdDate;
        private String updatedDate;
        private String courseTopic;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLessonName() {
            return lessonName;
        }

        public void setLessonName(String lessonName) {
            this.lessonName = lessonName;
        }

        public String getVideoPath() {
            return videoPath;
        }

        public void setVideoPath(String videoPath) {
            this.videoPath = videoPath;
        }

        public String getContentPath() {
            return contentPath;
        }

        public void setContentPath(String contentPath) {
            this.contentPath = contentPath;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public int getSequence() {
            return sequence;
        }

        public void setSequence(int sequence) {
            this.sequence = sequence;
        }

        public boolean isPreview() {
            return isPreview;
        }

        public void setPreview(boolean preview) {
            isPreview = preview;
        }

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        public int getCourseTopicId() {
            return courseTopicId;
        }

        public void setCourseTopicId(int courseTopicId) {
            this.courseTopicId = courseTopicId;
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public String getUpdatedDate() {
            return updatedDate;
        }

        public void setUpdatedDate(String updatedDate) {
            this.updatedDate = updatedDate;
        }

        public String getCourseTopic() {
            return courseTopic;
        }

        public void setCourseTopic(String courseTopic) {
            this.courseTopic = courseTopic;
        }
    }

    public class CourseTopic{
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

    public class Role{
        public int id;
        public String name;
        public ArrayList<String> users;
    }

    public class User{
        private int id;
        private String name;
        private String email;
        private String password;
        private String phoneNumber;
        private boolean emailConfirmed;
        private String createdDate;
        private ArrayList<String> subscriptions;
        private ArrayList<Role> roles;

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

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
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

    public class Subscription{
        private int id;
        private int userId;
        private String subscribedOn;
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

        public String getSubscribedOn() {
            return subscribedOn;
        }

        public void setSubscribedOn(String subscribedOn) {
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

}
