package com.example.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 完成服务端对客户信息的共享
 * 注意事项：
 * 1.客户端（别的应用程序）想调用服务端方法接口的时候，aidl包名和文件名必须一致（直接从服务端把aidl文件复制到服务端即可）
 * 2.AndroidManifest.xml注册时需要注意Service里面这两个方法一定要添加上
 * android:exported="true"
 * android:process=":remote"
 */

public class IRemoteService extends Service {
    String TAG = getClass().getSimpleName();

    /**
     * 当客户端绑定到该服务的时候 会执行
     *
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    private IBinder iBinder = new IImoocAidl.Stub() {

        @Override
        public int add(int num1, int num2) throws RemoteException {
            Log.d(TAG, "add: 收到了远程的骑牛，输入的参数是：" + num1 + "和" + num2);
            return num1 + num2;
        }
    };
}
