package androidx.lifecycle.viewmodel.internal;

import androidx.lifecycle.ViewModel;
import androidx.privacysandbox.ads.adservices.customaudience.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class JvmViewModelProviders {
    public static final JvmViewModelProviders INSTANCE = new JvmViewModelProviders();

    private JvmViewModelProviders() {
    }

    public final <T extends ViewModel> T createViewModel(Class<T> cls) {
        cls.getClass();
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(null);
            if (!Modifier.isPublic(declaredConstructor.getModifiers())) {
                a.h(cls, "Cannot create an instance of ");
                return null;
            }
            try {
                T newInstance = declaredConstructor.newInstance(null);
                newInstance.getClass();
                return newInstance;
            } catch (IllegalAccessException e10) {
                androidx.core.view.contentcapture.a.k("Cannot create an instance of ", cls, e10);
                return null;
            } catch (InstantiationException e11) {
                androidx.core.view.contentcapture.a.k("Cannot create an instance of ", cls, e11);
                return null;
            }
        } catch (NoSuchMethodException e12) {
            androidx.core.view.contentcapture.a.k("Cannot create an instance of ", cls, e12);
            return null;
        }
    }
}
