package com.yeoboya.com.yeoboya_Q;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main1Activity extends AppCompatActivity {
    static final int NUM_OVERLAYS_REQUEST = 1101;
    public static final String TAG = "MainActivity";
    private boolean bmainWebshow = false;
    //private AnimatedImageView mAniImageView = null;
    private String mItembuyMsg;
    private String mKakaoLinkUrl;
    //private BaseXwalkView mMainWebView;
    private LinearLayout mMenubarLayout;
    private String mPushmsg;
    private int mPushnoti;
    //private Random mRand;
    private LinearLayout mSlpahLayout;
    private TextView mSpalshText;
    private ImageView mSplashImg;
    private ImageView mSplashLogo;
    private boolean mSplashShowTime;
    private ImageView mSplashcurple;
    //private Timer m_Timer_C2DM;
    private ImageView mbtnBack;
    private ImageView mbtnFroward;
    private ImageView mbtnHome;
    private ImageView mbtnMore;
    private ImageView mbtnMyInfo;
    private ImageView mbtnReflash;
    //public MainActivity myActivity;
    private int viewclick1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        ImageView img_v = findViewById(R.id.ma_btn_home);
        final LinearLayout ll_v =findViewById(R.id.layout_main_splash);

        img_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main1Activity.this," Click Home",Toast.LENGTH_SHORT).show();
                ll_v.setVisibility(View.VISIBLE);
            }
        });
    }

    private void initUI()
    {
        this.mSlpahLayout = ((LinearLayout)findViewById(R.id.layout_main_splash));
        this.viewclick1 = 0;
        this.mSlpahLayout.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {

            }
        });
        this.mSplashLogo = ((ImageView)findViewById(R.id.layout_main_logo));
        this.mSplashImg = ((ImageView)findViewById(R.id.layout_main_secretimg));
        this.mSplashcurple = ((ImageView)findViewById(R.id.layout_main_secretimg));
        this.mSpalshText = ((TextView)findViewById(R.id.layout_main_secrettext));
        this.mSplashImg.setVisibility(View.VISIBLE);
        this.mSpalshText.setVisibility(View.VISIBLE);
        this.mSplashcurple.setVisibility(View.VISIBLE);
        this.mMenubarLayout = ((LinearLayout)findViewById(R.id.ma_layout_btns));
        this.mbtnHome = ((ImageView)findViewById(R.id.ma_btn_home));
        this.mbtnBack = ((ImageView)findViewById(R.id.ma_btn_back));
        this.mbtnFroward = ((ImageView)findViewById(R.id.ma_btn_forward));
        this.mbtnReflash = ((ImageView)findViewById(R.id.ma_btn_reflash));
        this.mbtnMyInfo = ((ImageView)findViewById(R.id.ma_btn_myinfo));
        this.mbtnMore = ((ImageView)findViewById(R.id.ma_btn_more));

    }



}