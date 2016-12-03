# AIDL
关于利用AIDL访问其他进程的实例
#Demo介绍
1.aidlserver是服务端，利用aidl接口定义了方法add，然后在实现Service的类里面复写了add的方法体（实现了两个数num1和num2相加功能。）  
2.在aidlclient（“客户端”）里面先用自定义的bindService()方法，启动远程服务（跟aidlserver绑定通信，具体看实现）。然后利用IImoocAidl里面的add方法实现了两个数的相加，并输出结果
#注意事项
1.客户端（别的应用程序）想调用服务端方法接口的时候，aidl包名和文件名必须一致（直接从服务端把aidl文件复制到服务端即可）  
2.AndroidManifest.xml注册时需要注意Service里面这两个方法一定要添加上  
android:exported="true"  
android:process=":remote"  
因为这两个坑，花了不少时间在里面。
