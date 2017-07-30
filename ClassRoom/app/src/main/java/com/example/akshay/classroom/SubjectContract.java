package com.example.akshay.classroom;

import android.provider.BaseColumns;

/**
 * Created by akshay on 27/7/17.
 */

public final class SubjectContract {
    public SubjectContract(){

    }
    public static abstract class SubjectEntry implements BaseColumns{

        public static final int sem1=1;
        public static final int sem2=2;
        public static final int sem3=3;
        public static final int sem4=4;
        public static final int sem5=5;
        public static final int sem6=6;
        public static final int sem7=7;
        public static final int sem8=8;

        public static final int CSE=1;
        public static final int IT=2;
        public static final int EEE=3;
        public static final int ECE=4;
        public static final int BIO=5;
        public static final int MECH=6;



    }
}
