package com.example.akshay.classroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.akshay.classroom.SubjectContract.SubjectEntry;

public class SelectBranch extends AppCompatActivity implements SubjectsAdapter.ListItemClickListener{

    private RecyclerView mCS_RecyclerView;
    private RecyclerView mIT_RecyclerView;
    private RecyclerView mMECH_RecyclerView;
    private RecyclerView mECE_RecyclerView;
    private RecyclerView mEEE_RecyclerView;
    private RecyclerView mBIO_RecyclerView;


    private SubjectsAdapter mAdapter;

    private UserInfo user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_branch);

        Intent i=getIntent();
        user=(UserInfo)i.getSerializableExtra("Object Passed");

        mCS_RecyclerView=(RecyclerView)findViewById(R.id.ComputerScienceRecyclerView);
        mIT_RecyclerView=(RecyclerView)findViewById(R.id.InformationTechnologyRecyclerView);
        mMECH_RecyclerView=(RecyclerView)findViewById(R.id.MechanicalRecyclerView);
        mECE_RecyclerView=(RecyclerView)findViewById(R.id.ECERecyclerView);
        mEEE_RecyclerView=(RecyclerView)findViewById(R.id.EEERecyclerView);
        mBIO_RecyclerView=(RecyclerView)findViewById(R.id.BiotechRecyclerView);


        //Adding layout managers
        LinearLayoutManager linearlayout=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        mCS_RecyclerView.setLayoutManager(linearlayout);
        linearlayout=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        mIT_RecyclerView.setLayoutManager(linearlayout);
        linearlayout=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        mMECH_RecyclerView.setLayoutManager(linearlayout);
        linearlayout=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        mECE_RecyclerView.setLayoutManager(linearlayout);
        linearlayout=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        mEEE_RecyclerView.setLayoutManager(linearlayout);
        linearlayout=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        mBIO_RecyclerView.setLayoutManager(linearlayout);



        //Adding custom adapters
        mAdapter=new SubjectsAdapter(this,user.getSemValues(),SubjectEntry.CSE, this);
        mCS_RecyclerView.setAdapter(mAdapter);

        mAdapter=new SubjectsAdapter(this,user.getSemValues(),SubjectEntry.IT,this);
        mIT_RecyclerView.setAdapter(mAdapter);
        mAdapter=new SubjectsAdapter(this,user.getSemValues(),SubjectEntry.MECH,this);
        mMECH_RecyclerView.setAdapter(mAdapter);

        mAdapter=new SubjectsAdapter(this,user.getSemValues(),SubjectEntry.ECE,this);
        mECE_RecyclerView.setAdapter(mAdapter);

        mAdapter=new SubjectsAdapter(this,user.getSemValues(),SubjectEntry.EEE,this);
        mEEE_RecyclerView.setAdapter(mAdapter);

        mAdapter=new SubjectsAdapter(this,user.getSemValues(),SubjectEntry.BIO,this);
        mBIO_RecyclerView.setAdapter(mAdapter);


    }

    @Override
    public void onListItemClick(String ClickedItem) {
        user.setSubjectValues(ClickedItem);
        Toast.makeText(this,user.getSubjectValues()+String.valueOf(user.getSemValues()),Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,ViewDocument.class);
        i.putExtra("Object passed",user);
        startActivity(i);
    }


}
