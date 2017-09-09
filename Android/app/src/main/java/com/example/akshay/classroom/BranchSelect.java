package com.example.akshay.classroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class BranchSelect extends Fragment implements SubjectsAdapter.ListItemClickListener {

    private RecyclerView mCS_RecyclerView;
    private RecyclerView mIT_RecyclerView;
    private RecyclerView mMECH_RecyclerView;
    private RecyclerView mECE_RecyclerView;
    private RecyclerView mEEE_RecyclerView;
    private RecyclerView mBIO_RecyclerView;


    private SubjectsAdapter mAdapter;

    private UserInfo user;
    public BranchSelect(){
        user =new UserInfo();

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle args = getArguments();
        user.setSemValues(args.getInt("index", 0)) ;
        View rootView=inflater.inflate(R.layout.activity_select_branch,container,false);
        mCS_RecyclerView=(RecyclerView)rootView.findViewById(R.id.ComputerScienceRecyclerView);
        mIT_RecyclerView=(RecyclerView)rootView.findViewById(R.id.InformationTechnologyRecyclerView);
        mMECH_RecyclerView=(RecyclerView)rootView.findViewById(R.id.MechanicalRecyclerView);
        mECE_RecyclerView=(RecyclerView)rootView.findViewById(R.id.ECERecyclerView);
        mEEE_RecyclerView=(RecyclerView)rootView.findViewById(R.id.EEERecyclerView);
        mBIO_RecyclerView=(RecyclerView)rootView.findViewById(R.id.BiotechRecyclerView);


        //Adding layout managers
        LinearLayoutManager linearlayout=new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        mCS_RecyclerView.setLayoutManager(linearlayout);
        linearlayout=new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        mIT_RecyclerView.setLayoutManager(linearlayout);
        linearlayout=new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        mMECH_RecyclerView.setLayoutManager(linearlayout);
        linearlayout=new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        mECE_RecyclerView.setLayoutManager(linearlayout);
        linearlayout=new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        mEEE_RecyclerView.setLayoutManager(linearlayout);
        linearlayout=new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        mBIO_RecyclerView.setLayoutManager(linearlayout);



        //Adding custom adapters
        mAdapter=new SubjectsAdapter(getActivity(),user.getSemValues(), SubjectContract.SubjectEntry.CSE,  this);
        mCS_RecyclerView.setAdapter(mAdapter);

        mAdapter=new SubjectsAdapter(getActivity(),user.getSemValues(), SubjectContract.SubjectEntry.IT, this);
        mIT_RecyclerView.setAdapter(mAdapter);
        mAdapter=new SubjectsAdapter(getActivity(),user.getSemValues(), SubjectContract.SubjectEntry.MECH, this);
        mMECH_RecyclerView.setAdapter(mAdapter);

        mAdapter=new SubjectsAdapter(getActivity(),user.getSemValues(), SubjectContract.SubjectEntry.ECE, this);
        mECE_RecyclerView.setAdapter(mAdapter);

        mAdapter=new SubjectsAdapter(getActivity(),user.getSemValues(), SubjectContract.SubjectEntry.EEE, this);
        mEEE_RecyclerView.setAdapter(mAdapter);

        mAdapter=new SubjectsAdapter(getActivity(),user.getSemValues(), SubjectContract.SubjectEntry.BIO, this);
        mBIO_RecyclerView.setAdapter(mAdapter);

        return rootView;
    }


    @Override
    public void onListItemClick(String ClickedItem) {
        user.setSubjectValues(ClickedItem);
        Toast.makeText(getActivity(),user.getSubjectValues()+String.valueOf(user.getSemValues()),Toast.LENGTH_SHORT).show();
        Intent i=new Intent(getActivity(),ViewDocument.class);
        i.putExtra("Object passed",user);
        startActivity(i);
    }

}
