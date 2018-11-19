package library.android.service.di.component;

import library.android.service.di.module.AppModule;
import library.android.service.di.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Ahmad.nemati on 3/26/2018.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
    OkHttpClient okhttp();

}

