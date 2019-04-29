import android.app.Activity;
import android.app.Application;
import android.support.annotation.Keep;
import android.support.v4.app.Fragment;

import com.charlezz.core.BaseModuleInjector;
import com.charlezz.modularizedsample.App;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;

@Keep
public class FeatureInjector implements BaseModuleInjector {
    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Override
    public void inject(Application application) {
        DaggerFeatureComponent.builder().appComponent(((App)application).getAppComponent());
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

    @Override
    public DispatchingAndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }
}
