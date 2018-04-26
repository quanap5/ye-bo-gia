package com.yeoboya.com.yeoboya_Q.activity;

import android.content.Intent;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

public abstract class YouTubeFailureRecoveryActivity extends YouTubeBaseActivity
  implements YouTubePlayer.OnInitializedListener
{
  private static String API_KEY;
  private static final int RECOVERY_DIALOG_REQUEST = 1;

  public String getApiKey()
  {
    return API_KEY;
  }

  protected abstract YouTubePlayer.Provider getYouTubePlayerProvider();

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
      getYouTubePlayerProvider().initialize(API_KEY, this);
  }

  public void onInitializationFailure(YouTubePlayer.Provider paramProvider, YouTubeInitializationResult paramYouTubeInitializationResult)
  {
    if (paramYouTubeInitializationResult.isUserRecoverableError())
    {
      paramYouTubeInitializationResult.getErrorDialog(this, 1).show();
      return;
    }
    String str = "Error to load youtube";
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramYouTubeInitializationResult.toString();
    Toast.makeText(this, String.format(str, arrayOfObject), Toast.LENGTH_LONG).show();
  }

  public void setApiKey(String paramString)
  {
    API_KEY = paramString;
  }
}
