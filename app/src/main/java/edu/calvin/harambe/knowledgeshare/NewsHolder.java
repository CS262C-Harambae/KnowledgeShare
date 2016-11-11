package edu.calvin.harambe.knowledgeshare;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by cjn8 on 11/9/2016.
 */

public class NewsHolder extends RecyclerView.ViewHolder {
    ImageView colorBar;
    ImageView icon;
    TextView headline;
    TextView sender;
    TextView story;
    public NewsHolder(View v) {
        super(v);
        this.colorBar = (ImageView) v.findViewById(R.id.colorBar);
        this.icon = (ImageView) v.findViewById(R.id.icon);
        this.headline = (TextView) v.findViewById(R.id.headline);
        this.sender = (TextView) v.findViewById(R.id.sender);
        this.story = (TextView) v.findViewById(R.id.story);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewsCardActivity.class);
                intent.putExtra("headlinePass", headline.getText().toString());
                intent.putExtra("senderPass", sender.getText().toString());
                intent.putExtra("storyPass", story.getText().toString());
                v.getContext().startActivity(intent);
            }
        });
    }
}