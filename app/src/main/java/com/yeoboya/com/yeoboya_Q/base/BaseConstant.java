package com.yeoboya.com.yeoboya_Q.base;

import android.content.Context;
import android.content.Intent;

public class BaseConstant
{
  public static final int MSG_BACKBTN_WAIT = 10002;
  public static final int MSG_BACKBTN_WAIT_WEB = 10003;
  public static final int MSG_FINISH_ACTIVITY = 10001;
  public static final int MSG_FINISH_POP_ACTIVITY = 10004;
  public static final int MSG_GCMID_WAIT = 10005;
  public static final int MSG_HANDLE_BASE = 10000;
  public static final int MSG_HANDLE_USER_BASE = 20000;
  private static String mBroadcastID = "com.yeoboya.com.yeoboya.MSG";

  public static void SendBroadMsg(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Intent localIntent = new Intent(getBroadcastID());
    localIntent.putExtra("cmd", paramInt1);
    localIntent.putExtra("arg1", paramInt2);
    localIntent.putExtra("arg2", paramInt3);
    localIntent.putExtra("msg", paramString);
    paramContext.sendBroadcast(localIntent);
  }

  public static String getBroadcastID()
  {
    return mBroadcastID;
  }

  public static void setChangeBroadcastID(String paramString)
  {
    mBroadcastID = paramString;
  }
}

