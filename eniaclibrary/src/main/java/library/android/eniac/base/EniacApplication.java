package library.android.eniac.base;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.multidex.MultiDex;

import com.orm.SugarContext;
import com.pixplicity.easyprefs.library.Prefs;


import javax.inject.Singleton;

import library.android.eniac.R;
import library.android.eniac.singleton.SingletonContext;
import library.android.eniac.utility.font.CustomViewWithTypefaceSupport;
import library.android.eniac.utility.font.TextField;
import library.android.service.di.component.DaggerNetComponent;
import library.android.service.di.component.NetComponent;
import library.android.service.di.module.AppModule;
import library.android.service.di.module.NetModule;
import library.android.service.generator.SingletonService;
import library.android.service.helper.Const;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class EniacApplication extends Application {
    private NetComponent mNetComponent;


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SingletonContext.Companion.getInstance().setContext(this);
        SingletonService.getInstance().setContext(this);


        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(Const.BASEURL))
                .build();

        SingletonService.getInstance().setNetComponent(mNetComponent).inject();
        SugarContext.init(this);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/iran_sans_normal.ttf")
                .setFontAttrId(R.attr.fontPath)
                .addCustomViewWithSetTypeface(CustomViewWithTypefaceSupport.class)
                .addCustomStyle(TextField.class, R.attr.textFieldStyle)
                .build()
        );
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();



    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }


}
