package com.example.srikant.layoutdesign;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.Group;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private Context mContext;
    private List<PostModel> postModelList;
    private PostClickListeners clickListeners;
    PostAdapter(Context context, List<PostModel> list){
        clickListeners = (PostClickListeners)context;
        mContext = context;
        postModelList = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String name = postModelList.get(i).getPersonName();
        String address = postModelList.get(i).getPersonAddress();
        String question = postModelList.get(i).getQuestion();
        String ansContent = postModelList.get(i).getAnsContent();
        String ansHeading = postModelList.get(i).getAnsHeading();
        viewHolder.personName.setText(name);
        viewHolder.personAddress.setText(address);
        viewHolder.answerHeading.setText(ansHeading);
        viewHolder.answerContent.setText(ansContent);
        viewHolder.question.setText(question);
    }

    @Override
    public int getItemCount() {
        return postModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView personName;
        TextView personAddress;
        TextView question;
        TextView answerHeading;
        TextView answerContent;
        TextView askedAns;
        Group personGroup;
        Group answerGroup;
        ImageView addFriend;
        ImageView personImage;
        ImageView ansImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            personAddress = itemView.findViewById(R.id.personAddress);
            personName = itemView.findViewById(R.id.personName);
            question = itemView.findViewById(R.id.question);
            answerContent = itemView.findViewById(R.id.ansContent);
            answerHeading = itemView.findViewById(R.id.ansHeading);
            personGroup = itemView.findViewById(R.id.personGroup);
            answerGroup = itemView.findViewById(R.id.answerGroup);
            addFriend = itemView.findViewById(R.id.addFriend);
            personImage = itemView.findViewById(R.id.personImage);
            ansImage = itemView.findViewById(R.id.ansImage);
            addFriend.setOnClickListener(this);
            ansImage.setOnClickListener(this);
            question.setOnClickListener(this);
            personName.setOnClickListener(this);
            answerHeading.setOnClickListener(this);
            personImage.setOnClickListener(this);
            answerContent.setOnClickListener(this);
            personAddress.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.personName:
                case R.id.personImage:
                case R.id.personAddress:
                    clickListeners.onProfileClick(postModelList.get(getAdapterPosition()).getProfileUrl());
                    break;

                case R.id.ansContent:
                case R.id.ansHeading:
                case R.id.ansImage:
                    clickListeners.onAnswerClick(postModelList.get(getAdapterPosition()).getPostUrl());
                    break;
                case R.id.addFriend:
                    clickListeners.onAddFriendClick();
                    break;
                case R.id.question:
                    clickListeners.onQuestionCLick(postModelList.get(getAdapterPosition()).getPostUrl());
                    break;
            }
        }
    }
}
