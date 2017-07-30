package com.example.akshay.classroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.akshay.classroom.SubjectContract.SubjectEntry;

public class SelectBranch extends AppCompatActivity {

    private RecyclerView mCS_RecyclerView;
    private RecyclerView mIT_RecyclerView;
    private RecyclerView mMECH_RecyclerView;

    private SubjectsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_branch);

        Intent i=getIntent();
        UserInfo user=(UserInfo)i.getSerializableExtra("Object Passed");

        mCS_RecyclerView=(RecyclerView)findViewById(R.id.ComputerScienceRecyclerView);
        mIT_RecyclerView=(RecyclerView)findViewById(R.id.InformationTechnologyRecyclerView);
        mMECH_RecyclerView=(RecyclerView)findViewById(R.id.MechanicalRecyclerView);



        //Adding layout managers
        LinearLayoutManager linearlayout=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        mCS_RecyclerView.setLayoutManager(linearlayout);
        linearlayout=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        mIT_RecyclerView.setLayoutManager(linearlayout);
        linearlayout=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        mMECH_RecyclerView.setLayoutManager(linearlayout);


        //Adding custom adapters
        mAdapter=new SubjectsAdapter(this,user.getSemValues(),SubjectEntry.CSE );
        mCS_RecyclerView.setAdapter(mAdapter);

        mAdapter=new SubjectsAdapter(this,user.getSemValues(),SubjectEntry.IT );
        mIT_RecyclerView.setAdapter(mAdapter);

        mAdapter=new SubjectsAdapter(this,user.getSemValues(),SubjectEntry.MECH);
        mMECH_RecyclerView.setAdapter(mAdapter);
        Log.i("important log message","index 1");

    }
}
