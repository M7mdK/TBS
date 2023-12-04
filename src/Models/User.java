package Models;

import java.util.ArrayList;

import static jdk.nashorn.internal.objects.NativeString.toLowerCase;

public class User {
    private String firstName, lastName, city, phoneNumber;
    private String userName, password;
    private int userId, age;
    private static int count = 2;//Used to auto-generate userId (User id=1 is reserved for the Admin)
    //private ArrayList<Trip> tripsList;

    public User(String firstName, String lastName, String password, String phoneNumber, int age, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.age = age;

        userId = count;
        count++;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setUserId(int id) {
        this.userId= id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public int getUserId() {
        return userId;
    }

    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userId=" + userId +
                ", age=" + age +
                '}';
    }
}
