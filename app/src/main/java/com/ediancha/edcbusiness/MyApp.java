package com.ediancha.edcbusiness;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;
import com.taobao.sophix.PatchStatus;
import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;

/**
 * Created by dengmingzhi on 2017/9/12.
 */

public class MyApp extends Application {
    private static final String HOT_APPID = "24619993-1";
    private static final String HOT_APPSECRET = "36673dd72ba60ed67dd6789f9a5dc61c";
    private static final String HOT_RSA = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCrl31PTofXtf/Q+nxWWkzfJeGQksmbE7EZ6tx1+z4CjMr1j2v23Ah69mnqtLvm1J9qFax0/QSbjGjn6eZaApDp1JQhO5vvCSLx63SO0v4poP1o73mfhkEsidV52IJqqOAcqJv2RS5GyaSOiWVDr9VGiC/2ipFeluj9EAx7AqiJaJ7EPcBT0fbdImzHznbaa4oi1bOyp9ahHkm821BRtNuo94w4POarxtNooruR0Pbxxr/qZ2y7Mdri9sRAtuAW2or7wZQgKqERhEE5S8N5JVGRBgBbAzqsTsHZMbVa1FdBbU2InyLGnq68nnLBGx4uBal9Fl/Kx16lgNhtjWrtCHX7AgMBAAECggEAdnWy8NlKNsVSwjbrN8JHZ5aDTofH3uONVFMrt9enS6NfSn+lDVuCD0GmhX4YapdHJrmnwWwbjjc1BUYY3PMAkC1NxlOcpz0rftAKO7+1749Q4uzQjizlOZY+ZkvuXSwQ7DgK082W0Q/MJwr7eesd1f+W/SFUknSkjHBT7Wg8af9IRwBTsyOMHSfgKS6UmSKwD7MkbyGCuxenQDYCNbJptFrmVDLXsNvMINVwSVRe1algg2CDkGmpH3YLuu2SbWDpy9v6TgCu4btLXGgb/eupcUeKjNwmvcFPQJ9BxrZj+9GhsoOmo39qqGaPBHyOK0vFHB55hd4QMZv5cExe++CZ4QKBgQDt3cpBi1mljbhgCu70xI6lxuLgXkPFBAbUY2kzQQdT58+UCuF/Y8z9HjUSfRU+ZCARVg3vR9CHP8ONYWz3HxyGyxrV4/BICQTV5q/QbMsMvZWQvJl+qCXV6r5qkZxqayLjt7BSRQN4nZzcO/eTJytj0LgkTsn2ffmpjDIVb+ZQRwKBgQC4rEgGYSH6QqY+4tusUeOhPUNOnteH70fViirIpXZsN6K2+iHfFBTsSUmwyHrDhMzrTJM1swoXUIy1iu3Dm1vW/OcTdZXTH6lUPSf/x3AFycT4ei9pcN11Qa4CwdbWcNGLoPdc+HCPF4ICjU/MQWSOdg04W+vmZveJtE6kF1sarQKBgQCrwyg1xEZrwbaNw9dhcD4Bf2h81BTjw1CbNV3V4PNFp3LBWEoVDyAK9zEjtKcOcoalfhp52sW9pFG1WdCxcgnLXAZ4xSvRGJIhU39JZgYJoSzLYyUDzK/llKkDkzn7rnl3LkFoZuVmx4lpjvPrkrFGVoVh0nMMR1NtFwtjZ3ZMKQKBgE1fUSXrGFNEDWcXoTYHcTmi80pDXsYDSLN9GgPK31zjynajQgG25jVBV3CL7nNwdnK3OI4tHzM5elqthISJ2OawOxh6EXXNNCKpJNMTeinSqYX5m1ewA/kWtZNOJ3bc+c5oeHspU+9/x+bN0fsgAsN1ToCocqOrzFaThsdVScRZAoGBAOUTTNHuQIDMZxmwhF4RD/KZvj8dXAjtsIWi98lVt15nCtp1cMG+/3p1vJyE+ouOLCyr2v2MX8kl0O9KQ/Y7pmZqnGXgGz/P+wuw10dTsIXkV0IJ5CK6GMK72GSSaDlE7i0GeomLIPy6fpD2GVNoHfsrZnVQiCELms9loee729WY";

    public interface MsgDisplayListener {
        void handle(int msg, int handleVersion, String info);
    }

    public static MsgDisplayListener msgDisplayListener = null;

    @Override
    public void onCreate() {
        super.onCreate();
        SophixManager.getInstance()
                .setContext(this)
                .setAppVersion(getVersion())
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onLoad(int mode, int code, String info, int handleVersion) {
                        Log.d("热更新", code + "-" + info);
                        if (msgDisplayListener != null) {
                            msgDisplayListener.handle(code, handleVersion, info);
                        }
                    }
                })
                .setAesKey(null)
                .setSecretMetaData(HOT_APPID, HOT_APPSECRET, HOT_RSA)
                .setEnableDebug(true)
                .initialize();

        LeakCanary.install(this);//检测内存泄漏
    }


    private String getVersion() {
        try {
            PackageManager manager = this.getPackageManager();
            PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "1.0.0";
        }
    }
}
