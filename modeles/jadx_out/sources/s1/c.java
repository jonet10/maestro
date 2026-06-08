package s1;

import a4.x;
import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class c implements s2.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9118a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9119b;

    public /* synthetic */ c(Object obj, int i) {
        this.f9118a = i;
        this.f9119b = obj;
    }

    @Override // s2.b
    public final Object get() {
        switch (this.f9118a) {
            case 0:
                String str = (String) this.f9119b;
                try {
                    Class<?> cls = Class.forName(str);
                    if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                        return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
                    }
                    throw new l("Class " + str + " is not an instance of com.google.firebase.components.ComponentRegistrar");
                } catch (ClassNotFoundException unused) {
                    Log.w("ComponentDiscovery", "Class " + str + " is not an found.");
                    return null;
                } catch (IllegalAccessException e10) {
                    throw new l(androidx.lifecycle.l.w("Could not instantiate ", str, "."), e10);
                } catch (InstantiationException e11) {
                    throw new l(androidx.lifecycle.l.w("Could not instantiate ", str, "."), e11);
                } catch (NoSuchMethodException e12) {
                    throw new l(x.j("Could not instantiate ", str), e12);
                } catch (InvocationTargetException e13) {
                    throw new l(x.j("Could not instantiate ", str), e13);
                }
            case 1:
                return (ComponentRegistrar) this.f9119b;
            default:
                return new u2.c((n1.f) this.f9119b);
        }
    }
}
