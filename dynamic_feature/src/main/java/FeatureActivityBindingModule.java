import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FeatureActivityBindingModule {

//    @ActivityScope
    @ContributesAndroidInjector(modules = FeatureModule.class)
    abstract FeatureActivity featureActivity();
}
