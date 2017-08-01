package com.example.akshay.classroom;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void SemButtonClicked(View view) {

        UserInfo user=new UserInfo();
        switch (view.getId()){

            case R.id.SemOneButton:

                user.setSemValues(SubjectContract.SubjectEntry.sem1);

                break;
            case R.id.SemTwoButton:
                user.setSemValues(SubjectContract.SubjectEntry.sem2);

                break;

        }
        Intent i=new Intent(this,SelectBranch.class);
        i.putExtra("Object Passed", user);
        startActivity(i);


    }
}
