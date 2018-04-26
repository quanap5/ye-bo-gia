package com.yeoboya.com.yeoboya_Q.Intro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yeoboya.com.yeoboya_Q.R;

public class IntroFragment extends Fragment
{
  // Store instance variables
  private static final String KEY_CONTENT = "IntroFragment:Content";

  protected static final String btnRing = "intro_img_couplering";
  protected static final String midBG = "intro_img_guideareabgpattern";

  private String mImageName;
  private int mPosition;

  protected static final String[] topImage = { "intro_img_topphoto1", "intro_img_topphoto2", "intro_img_topphoto3", "intro_img_topphoto4" };
  protected static final String [] midImage = { "intro_img_guide1_element", "intro_img_guide2_element", "intro_img_guide3_element", "intro_img_guide4_element" };
  protected static final  String [] btnImage = { "intro_img_blurredbg1", "intro_img_blurredbg2", "intro_img_blurredbg3", "intro_img_blurredbg4" };

  // newInstance constructor for creating fragment with arguments
  public static IntroFragment newInstance(int paramInt, String paramString)
  {
    IntroFragment localIntroFragment = new IntroFragment();
    localIntroFragment.mPosition = paramInt;
    localIntroFragment.mImageName = paramString;
    return localIntroFragment;
  }

  // Store instance variables based on arguments passed
  @Override
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((paramBundle != null) && (paramBundle.containsKey("IntroFragment:Content")))
      this.mImageName = paramBundle.getString("IntroFragment:Content");
  }

  // Inflate the view for the fragment based on layout XML
  @Override
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.intro_page, paramViewGroup, false);
    ((LinearLayout)localView.findViewById(R.id.layout_pager_top)).setBackgroundResource(getResources().getIdentifier("com.yeoboya.com.yeoboya_Q:drawable/" + topImage[this.mPosition], null, null));
    ((ImageView)localView.findViewById(R.id.pager_desc)).setImageResource(getResources().getIdentifier("com.yeoboya.com.yeoboya_Q:drawable/" + midImage[this.mPosition], null, null));
    ((LinearLayout)localView.findViewById(R.id.layout_pager_bottom)).setBackgroundResource(getResources().getIdentifier("com.yeoboya.com.yeoboya_Q:drawable/" + btnImage[this.mPosition], null, null));
    return localView;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("IntroFragment:Content", this.mImageName);
  }
}
