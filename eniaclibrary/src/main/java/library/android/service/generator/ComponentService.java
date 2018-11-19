package library.android.service.generator;

import library.android.service.di.component.NetComponent;
import library.android.service.scope.CustomScope;

import dagger.Component;

/**
 * Created by Ahmad.nemati on 3/26/2018.
 */
@CustomScope
@Component(dependencies = NetComponent.class)
public interface ComponentService {
    void inject(SingletonService singletonService);
}
