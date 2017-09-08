package com.example.akshay.classroom;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by akshay on 27/7/17.
 */

public class SubjectsAdapter extends RecyclerView.Adapter<SubjectsAdapter.ButtonViewHolder> {

    private String[] mSubString;
    private TypedArray mImgString;
    final private ListItemClickListener mOnClickListener;

    public SubjectsAdapter(Context context, int semester,int branch,ListItemClickListener listener){
        Resources res = context.getResources();
        if(semester== SubjectContract.SubjectEntry.sem1){
            if ( branch == SubjectContract.SubjectEntry.CSE) {
                mSubString = res.getStringArray(R.array.CSE_Subjects_sem1);

                mImgString = res.obtainTypedArray(R.array.CSE_sem1_Images);

            }
            if ( branch == SubjectContract.SubjectEntry.IT) {
                mSubString = res.getStringArray(R.array.IT_Subjects_sem1);


                mImgString = res.obtainTypedArray(R.array.IT_sem1_Images);
            }
            if(branch==SubjectContract.SubjectEntry.MECH){
                mSubString=res.getStringArray(R.array.MECH_Subjects_sem1);

                mImgString = res.obtainTypedArray(R.array.MECH_sem1_Images);

            }
            if(branch==SubjectContract.SubjectEntry.ECE){
                mSubString=res.getStringArray(R.array.ECE_Subjects_sem1);

                mImgString = res.obtainTypedArray(R.array.ECE_sem1_Images);

            }if(branch==SubjectContract.SubjectEntry.EEE){
                mSubString=res.getStringArray(R.array.EEE_Subjects_sem1);

                mImgString = res.obtainTypedArray(R.array.EEE_sem1_Images);

            }if(branch==SubjectContract.SubjectEntry.BIO){
                mSubString=res.getStringArray(R.array.BIO_Subjects_sem1);

                mImgString = res.obtainTypedArray(R.array.BIO_sem1_Images);

            }
        }else if(semester== SubjectContract.SubjectEntry.sem2){
            if(branch== SubjectContract.SubjectEntry.CSE){

                mSubString=res.getStringArray(R.array.CSE_Subjects_sem2);

                mImgString = res.obtainTypedArray(R.array.CSE_sem1_Images);

            }
            if(branch== SubjectContract.SubjectEntry.IT){
                mSubString=res.getStringArray(R.array.IT_Subjects_sem2);

                mImgString = res.obtainTypedArray(R.array.CSE_sem1_Images);
            }
            if(branch== SubjectContract.SubjectEntry.MECH){
                mSubString=res.getStringArray(R.array.MECH_Subjects_sem2);

                mImgString = res.obtainTypedArray(R.array.CSE_sem1_Images);
            }
            if(branch==SubjectContract.SubjectEntry.ECE){
                mSubString=res.getStringArray(R.array.ECE_Subjects_sem2);

                mImgString = res.obtainTypedArray(R.array.CSE_sem1_Images);

            }if(branch==SubjectContract.SubjectEntry.EEE){
                mSubString=res.getStringArray(R.array.EEE_Subjects_sem2);

                mImgString = res.obtainTypedArray(R.array.CSE_sem1_Images);
            }if(branch==SubjectContract.SubjectEntry.BIO){
                mSubString=res.getStringArray(R.array.BIO_Subjects_sem2);

                mImgString = res.obtainTypedArray(R.array.CSE_sem1_Images);

            }
        }


        mOnClickListener=listener;




    }

    @Override
    public ButtonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflator=LayoutInflater.from(context);
        View view =inflator.inflate(R.layout.subject_list_item,parent,false);
        ButtonViewHolder ViewHolder =new ButtonViewHolder(view);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(ButtonViewHolder holder, int position) {
        holder.bind(mSubString[position]);
        holder.mSubjectImageView.setBackground(mImgString.getDrawable(position));

    }

    @Override
    public int getItemCount() {
        return mSubString.length;
    }


    public interface ListItemClickListener{
        void onListItemClick(String ClickedItem);
    }


    class ButtonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mSubjectTextView;
        ImageView mSubjectImageView;
        public ButtonViewHolder(View itemView) {
            super(itemView);
            mSubjectTextView= itemView.findViewById(R.id.Subject_TextView);
            mSubjectImageView=itemView.findViewById(R.id.subject_imageView);
            mSubjectImageView.setOnClickListener(this);

        }
        void bind(String SubName){
            mSubjectTextView.setText(SubName);

        }


        @Override
        public void onClick(View view) {
            int clickedItemIndex=getAdapterPosition();
            String clickedString=mSubString[clickedItemIndex];
            mOnClickListener.onListItemClick(clickedString);

        }
    }
}
