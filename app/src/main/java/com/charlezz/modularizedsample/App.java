package com.charlezz.modularizedsample;

import java.util.ArrayList;

import javax.inject.Inject;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.google.android.play.core.splitcompat.SplitCompatApplication;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class App extends SplitCompatApplication implements HasActivityInjector, HasSupportFragmentInjector {
    @Inject
    private DispatchingAndroidInjector<Activity> dispatchingActivityInjector;
    @Inject
    private DispatchingAndroidInjector<Fragment> dispatchingFagmentInjector;

    private ArrayList<DispatchingAndroidInjector<Activity>> moduleActivityInjectors = new ArrayList<>();
    private ArrayList<DispatchingAndroidInjector<Fragment>> moduleFragmentInjectors = new ArrayList<>();

    private AndroidInjector<Activity> activityInjector = new AndroidInjector<Activity>() {
        @Override
        public void inject(Activity instance) {

        }
    };


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return null;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return null;
    }
}



//class App : SplitCompatApplication(), HasActivityInjector, HasSupportFragmentInjector {
//
//private val activityInjector = AndroidInjector<Activity> { instance ->
//        // maybeInjectでtrueが返却されれればInject成功
//
//        // メインmodule
//        if (dispatchingActivityInjector.maybeInject(instance)) {
//        return@AndroidInjector
//        }
//
//                // 各Feature module
//                moduleActivityInjectors.forEach { injector ->
//                if (injector.maybeInject(instance)) {
//                return@AndroidInjector
//            }
//                    }
//                    throw IllegalStateException("Injector not found for $instance")
//                    }
//
//// 実際にInjectを行う AndroidInjector<Fragment>
//private val fragmentInjector = AndroidInjector<Fragment> { instance ->
//        // maybeInjectでtrueが返却されれればInject成功
//
//        // メインmodule
//        if (dispatchingFragmentInjector.maybeInject(instance)) {
//        return@AndroidInjector
//        }
//
//                // 各Feature module
//                moduleFragmentInjectors.forEach { injector ->
//                if (injector.maybeInject(instance)) {
//                return@AndroidInjector
//            }
//                    }
//                    throw IllegalStateException("Injector not found for $instance")
//                    }
//
//// Feature moduleのInjectorを生成したかの判定用Set
//private val injectedModules = mutableSetOf<FeatureModule>()
//
//        // AppComponentと各Feature moduleのComponentから使用される
//        val appComponent by lazy {
//        DaggerAppComponent.builder().create(this) as AppComponent
//        }
//
//        override fun onCreate() {
//        super.onCreate()
//        Timber.plant(Timber.DebugTree())
//
//        appComponent.inject(this)
//        }
//
//        override fun activityInjector(): AndroidInjector<Activity> {
//        // 実際のInjectorを返す
//        return activityInjector
//        }
//
//        override fun supportFragmentInjector(): AndroidInjector<Fragment> {
//        // 実際のInjectorを返す
//        return fragmentInjector
//        }
//
//        // Feature moduleのInjectorを追加する
//        // Feature moduleがインストール後に使用される直前で呼び出される
//        fun addModuleInjector(module: FeatureModule) {
//        if (injectedModules.contains(module)) {
//        // 追加済みは何もしない
//        return
//        }
//
//        // Feature moduleのInjectorを生成
//        val clazz = Class.forName(module.injectorName)
//        val moduleInjector = clazz.newInstance() as BaseModuleInjector
//        // Feature moduleのInjectorのDispatchingAndroidInjectorをInject
//        moduleInjector.inject(this)
//
//        // リストに追加
//        moduleActivityInjectors.add(moduleInjector.activityInjector())
//        moduleFragmentInjectors.add(moduleInjector.fragmentInjector())
//
//        injectedModules.add(module)
//        }
//        }
//
