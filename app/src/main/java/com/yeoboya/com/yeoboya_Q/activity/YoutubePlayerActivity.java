package com.yeoboya.com.yeoboya_Q.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.yeoboya.com.yeoboya_Q.R;

public class YoutubePlayerActivity extends com.yeoboya.com.yeoboya_Q.activity.YouTubeFailureRecoveryActivity
        implements View.OnClickListener {
    private final String TAG = "YoutubePlayerActivity";
    private String mMoveUrl ;//= "H5Uzwn_JioI";
    public YoutubePlayerActivity myActivity;

    private void initUI(Intent paramIntent) {
        if (paramIntent != null) {
            Bundle localBundle = paramIntent.getExtras();
            if (localBundle != null) {
                String str = localBundle.getString("WEB_URL");
                if (!TextUtils.isEmpty(str))
                    this.mMoveUrl = str;
            }
        }
       // findViewById(R.id.pop_youtuve_close).setOnClickListener(this);
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.pop_youtuve_player);
    }


    @Override
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        //setContentView(new findViewById(R.id.pop_youtube));
        setContentView(R.layout.pop_youtube);
        this.myActivity = this;
        setApiKey("AIzaSyCf7-nF1CuCmgg0UUOBAXMglHm73zbHje4");
        ((YouTubePlayerView) findViewById(R.id.pop_youtuve_player)).initialize(getApiKey(), this);
        initUI(getIntent());

    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
                return;
            case R.id.pop_youtuve_close:
                //Intent intent = new Intent(YoutubePlayerActivity.this, Main1Activity.class);
                //startActivity(intent);

                finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void onInitializationFailure(YouTubePlayer.Provider paramProvider, YouTubeInitializationResult paramYouTubeInitializationResult) {
        super.onInitializationFailure(paramProvider, paramYouTubeInitializationResult);
        finish();
    }

    public void onInitializationSuccess(YouTubePlayer.Provider paramProvider, YouTubePlayer paramYouTubePlayer, boolean paramBoolean) {
        if (!paramBoolean)
            paramYouTubePlayer.cueVideo(this.mMoveUrl);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }
}
