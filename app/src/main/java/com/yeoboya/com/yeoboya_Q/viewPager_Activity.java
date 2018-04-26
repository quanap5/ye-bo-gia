package com.yeoboya.com.yeoboya_Q;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.yeoboya.com.yeoboya_Q.Intro.IntroPageAdapter;
import com.yeoboya.com.yeoboya_Q.activity.YoutubePlayerActivity;
import com.yeoboya.com.yeoboya_Q.base.BaseBroadcast;

public class viewPager_Activity extends AppCompatActivity {
    private static final int REQUEST_CODE_YOU = 1001 ;
    private static final int MESSAGE_TURNON_YOUTUBE = 20002 ;


    int mCurrentPage = 0;

    private final int mPagerWaitTime = 5000;
    Button mbtn_JoinUs;
    Button mbtn_Login;
    ImageView mimg_Between;

    FragmentPagerAdapter adapterViewPager;
    public Handler mHandler;
    private String str = "33wijjmPB9g";//H5Uzwn_JioI";
    Message msg= new Message();

    private boolean mAutopageComplite = false;
    private BaseBroadcast mBraodcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        mimg_Between = ((ImageView) findViewById(R.id.img_between));
        mbtn_Login = ((Button) findViewById(R.id.btn_intro_login));
        mbtn_JoinUs = ((Button) findViewById(R.id.btn_intro_joinus));

       // mAdapter = new IntroPageAdapter(getSupportFragmentManager());



        initHandler();
        mbtn_Login.setEnabled(true);
        mbtn_JoinUs.setEnabled(true);

        mbtn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(viewPager_Activity.this,"Click login button", Toast.LENGTH_LONG).show();
                btnLogin();
            }
        });
        mbtn_JoinUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(viewPager_Activity.this,"Click register button", Toast.LENGTH_LONG).show();
                btnJoinUs();
            }
        });

        ViewPager viewPager = findViewById(R.id.pager_intro);
        adapterViewPager = new IntroPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);

        msg.what = MESSAGE_TURNON_YOUTUBE;
        mHandler.sendMessageDelayed(msg, 2000);

    }

    private void initHandler() {
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case MESSAGE_TURNON_YOUTUBE:
                        OnMessage();
                }
            }
        };

    }

   private void OnMessage() {
        showYoutubePlayer(str);
    }

    private  void btnLogin(){
        Intent localIntent = new Intent(viewPager_Activity.this, Main32Activity.class);
        localIntent.putExtra("WEB_URL", MainConstant.URL_LOGIN);
        startActivity(localIntent);
        //finish();
    }
    private  void btnJoinUs(){
        Intent localIntent = new Intent(viewPager_Activity.this, Main32Activity.class);
        localIntent.putExtra("WEB_URL", MainConstant.URL_JOINUS);
        startActivity(localIntent);
        //finish();
    }
    public void showYoutubePlayer(String paramString){
        Intent localIntent = new Intent(viewPager_Activity.this, YoutubePlayerActivity.class);
        localIntent.putExtra("WEB_URL", paramString);
        startActivityForResult(localIntent,REQUEST_CODE_YOU );

    }


    private void ChangePage(int paramInt) {
        this.mCurrentPage = paramInt;
        this.mHandler.removeMessages(20002);
        if ((!this.mAutopageComplite) && (this.mCurrentPage == -1 + this.adapterViewPager.getCount()))
            this.mAutopageComplite = true;
        if (!this.mAutopageComplite)
            this.mHandler.sendEmptyMessageDelayed(20002, 5000L);
    }

    protected void onDestroy() {
       // this.mBraodcast.Destroy();
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        //this.mHandler.removeMessages(20002);
    }

    protected void onResume() {
        super.onResume();
        //this.mHandler.sendEmptyMessageDelayed(20002, 5000L);
    }

    public class mBroadcastListener implements BaseBroadcast.IBaseBroadcast {
        public mBroadcastListener() {
        }

        public void onRecvBroadcast(Message paramMessage) {
            //viewPager_Activity.this.mHandler.sendMessage(paramMessage);
        }
    }

    public class mPagerListener implements ViewPager.OnPageChangeListener {
        public mPagerListener() {
        }

        public void onPageScrollStateChanged(int paramInt) {
        }

        public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
        }

        public void onPageSelected(int paramInt) {
            //viewPager_Activity.this.ChangePage(paramInt);
        }
    }




}
