package com.project.classes;

/* Данный класс хранит данные о людях (сотрудники). */

public class Staff {

    /* Переменная - хранит имя человека (сотрудника). */
    private String name;
    /* Переменная - хранит фамилию человека (сотрудника). */
    private String lastName;
    /* Переменная - хранит номер телефона человека (сотрудника). */
    private String phone;
    /* Переменная - хранит возраст человека (сотрудника). */
    private byte age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }
}
