package com.yeoboya.com.yeoboya_Q.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;

public class BaseBroadcast
{
  private BroadcastReceiver finishedReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      Message localMessage = new Message();
      localMessage.what = paramIntent.getIntExtra("cmd", 0);
      localMessage.arg1 = paramIntent.getIntExtra("arg1", 0);
      localMessage.arg2 = paramIntent.getIntExtra("arg2", 0);
      localMessage.obj = paramIntent.getStringExtra("msg");
      if (BaseBroadcast.this.mCallback != null)
        BaseBroadcast.this.mCallback.onRecvBroadcast(localMessage);
    }
  };
  IBaseBroadcast mCallback;
  Context mContext;

  public BaseBroadcast(Context paramContext, IBaseBroadcast paramIBaseBroadcast)
  {
    this.mContext = paramContext;
    this.mCallback = paramIBaseBroadcast;
    registerFinishedReceiver();
  }

  private void registerFinishedReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter(BaseConstant.getBroadcastID());
    this.mContext.registerReceiver(this.finishedReceiver, localIntentFilter);
  }

  private void unregisterFinishedReceiver()
  {
    this.mContext.unregisterReceiver(this.finishedReceiver);
  }

  public void Destroy()
  {
    unregisterFinishedReceiver();
  }

  public void KillApp()
  {
    try
    {
      Intent localIntent = new Intent(BaseConstant.getBroadcastID());
      localIntent.putExtra("cmd", 10001);
      this.mContext.sendBroadcast(localIntent);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void SendBroadcast(int paramInt)
  {
    try
    {
      Intent localIntent = new Intent(BaseConstant.getBroadcastID());
      localIntent.putExtra("cmd", paramInt);
      this.mContext.sendBroadcast(localIntent);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static abstract interface IBaseBroadcast
  {
    public abstract void onRecvBroadcast(Message paramMessage);
  }
}
