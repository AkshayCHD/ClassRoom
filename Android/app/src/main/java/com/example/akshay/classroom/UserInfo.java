package com.example.akshay.classroom;

import java.io.Serializable;

/**
 * Created by akshay on 28/7/17.
 */

public class UserInfo implements Serializable{

    public UserInfo(){
        SemValue=1;

    }
    private int SemValue;
    private String SubjectValue;

    public int getSemValues() {
        return SemValue;
    }

    public String getSubjectValues() {
        return SubjectValue;
    }

    public void setSemValues(int semValue) {
        SemValue = semValue;
    }

    public void setSubjectValues(String subjectValue) {
        SubjectValue = subjectValue;
    }
}

