package com.yeoboya.com.yeoboya_Q;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Main3Activity_youtube extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private YouTubePlayerView ytpv;
    private final String API_KEY_YT = "AIzaSyCf7-nF1CuCmgg0UUOBAXMglHm73zbHje4";


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pop_youtube);

        ytpv = (YouTubePlayerView) findViewById(R.id.pop_youtuve_player);
        ytpv.initialize(API_KEY_YT, this);

    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
                return;
            case R.id.pop_youtuve_close:
                finish();
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer ytp, boolean b) {
        // https://www.youtube.com/watch?v=jpLQYuh2U4U
        //https://www.youtube.com/watch?v=H5Uzwn_JioI
        if (!b) {
            ytp.cueVideo("H5Uzwn_JioI");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult result) {
        if (result.isUserRecoverableError()) {
            result.getErrorDialog(this, 1).show();
        } else {
            String error = String.format("Error initializing YouTube player", result.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }
}
