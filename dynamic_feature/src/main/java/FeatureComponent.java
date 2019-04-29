import com.charlezz.modularizedsample.AppComponent;
import com.charlezz.modularizedsample.ModuleScope;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(
        dependencies = {AppComponent.class},
        modules = {
                AndroidSupportInjectionModule.class,
                FeatureActivityBindingModule.class
        }
)
@ModuleScope
public interface FeatureComponent {
    void inject(FeatureInjector injector);
}
