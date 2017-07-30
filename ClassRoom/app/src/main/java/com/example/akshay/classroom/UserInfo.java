package com.example.akshay.classroom;

import java.io.Serializable;

/**
 * Created by akshay on 28/7/17.
 */

public class UserInfo implements Serializable{
    private int SemValue;
    private int SubjectValue;

    public int getSemValues() {
        return SemValue;
    }

    public int getSubjectValues() {
        return SubjectValue;
    }

    public void setSemValues(int semValue) {
        SemValue = semValue;
    }

    public void setSubjectValues(int subjectValue) {
        SubjectValue = subjectValue;
    }
}

