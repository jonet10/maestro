package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import q6.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateViewModelFactory_androidKt {
    private static final List<Class<?>> ANDROID_VIEWMODEL_SIGNATURE = m.d0(Application.class, SavedStateHandle.class);
    private static final List<Class<?>> VIEWMODEL_SIGNATURE = a.a.H(SavedStateHandle.class);

    public static final <T> Constructor<T> findMatchingConstructor(Class<T> cls, List<? extends Class<?>> list) {
        cls.getClass();
        list.getClass();
        Object[] constructors = cls.getConstructors();
        constructors.getClass();
        for (Object obj : constructors) {
            Constructor<T> constructor = (Constructor<T>) obj;
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            parameterTypes.getClass();
            List m02 = q6.j.m0(parameterTypes);
            if (list.equals(m02)) {
                return constructor;
            }
            if (list.size() == m02.size() && m02.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final <T extends ViewModel> T newInstance(Class<T> cls, Constructor<T> constructor, Object... objArr) {
        cls.getClass();
        constructor.getClass();
        objArr.getClass();
        try {
            return constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e10) {
            androidx.core.view.contentcapture.a.k("Failed to access ", cls, e10);
            return null;
        } catch (InstantiationException e11) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e11);
        } catch (InvocationTargetException e12) {
            androidx.privacysandbox.ads.adservices.customaudience.a.m("An exception happened in constructor of " + cls, e12.getCause());
            return null;
        }
    }
}
