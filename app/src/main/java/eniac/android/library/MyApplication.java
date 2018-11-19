package eniac.android.library;

import android.app.Application;
import android.content.Context;
import library.android.eniac.base.EniacApplication;

public class MyApplication extends EniacApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }


}
