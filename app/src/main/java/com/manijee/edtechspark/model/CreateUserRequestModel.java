package com.manijee.edtechspark.model;

public class CreateUserRequestModel {
    private  static String Name;
    private  static String Email;
    private  static String Password;
    private  static String ConfirmPassword;
    private  static String Contact;

    public CreateUserRequestModel(String name, String email, String password,  String contact) {
        this.Name = name;
        this.Email = email;
        this.Password = password;
        this.Contact = contact;
    }
    public static String getName() {
        return Name;
    }

    public static void setName(String name) {
        Name = name;
    }

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String email) {
        Email = email;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setPassword(String password) {
        Password = password;
    }


    public static String getContact() {
        return Contact;
    }

    public static void setContact(String contact) {
        Contact = contact;
    }
}
