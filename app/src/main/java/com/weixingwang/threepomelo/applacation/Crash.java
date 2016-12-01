package com.weixingwang.threepomelo.applacation;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/12/1 0001.
 */
public class Crash implements Thread.UncaughtExceptionHandler {
    private  static Crash crash;
    private Context mContext;
    private Thread.UncaughtExceptionHandler ue;
    public static Crash getInstence(){
        if(crash==null){
            synchronized (Crash.class){
                if(crash==null){
                    crash=new Crash();
                }
            }
        }
        return crash;
    }
    public void init(Context context){
        mContext = context;
        ue=Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if(!getBoolean(ex)&&ue!=null){
            crash.uncaughtException(thread,ex);
        }else{
            //SystemClock.sleep(3000);

//            Process.killProcess(Process.myPid());
//            System.exit(1);

        }
    }

    private boolean getBoolean(final Throwable ex) {
        if(ex==null){
            return false;
        }else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Looper.prepare();
                    Toast.makeText(mContext, "系统在开小差......", Toast.LENGTH_SHORT).show();
                    Looper.loop();
                    //保存到本地
                    saveLocal(ex);
                    //上传到服务器
                    putServer(ex);
                }
            }).start();
            return true;
        }

    }

    private void putServer(Throwable ex) {

    }

    private void saveLocal(Throwable ex) {

    }
}
