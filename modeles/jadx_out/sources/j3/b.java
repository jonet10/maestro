package j3;

import com.google.android.gms.internal.measurement.z3;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends z3 {
    public final Method h;
    public final Method i;
    public final Method j;

    /* renamed from: k, reason: collision with root package name */
    public final Method f6565k;

    public b() {
        super(7);
        this.h = Class.class.getMethod("isRecord", null);
        this.i = Class.class.getMethod("getRecordComponents", null);
        Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
        this.j = cls.getMethod("getName", null);
        this.f6565k = cls.getMethod("getType", null);
    }

    @Override // com.google.android.gms.internal.measurement.z3
    public final boolean A(Class cls) {
        try {
            return ((Boolean) this.h.invoke(cls, null)).booleanValue();
        } catch (ReflectiveOperationException e10) {
            androidx.privacysandbox.ads.adservices.customaudience.a.m("Unexpected ReflectiveOperationException occurred (Gson 2.13.2). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e10);
            return false;
        }
    }

    @Override // com.google.android.gms.internal.measurement.z3
    public final Method o(Class cls, Field field) {
        try {
            return cls.getMethod(field.getName(), null);
        } catch (ReflectiveOperationException e10) {
            androidx.privacysandbox.ads.adservices.customaudience.a.m("Unexpected ReflectiveOperationException occurred (Gson 2.13.2). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e10);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.z3
    public final Constructor q(Class cls) {
        try {
            Object[] objArr = (Object[]) this.i.invoke(cls, null);
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                clsArr[i] = (Class) this.f6565k.invoke(objArr[i], null);
            }
            return cls.getDeclaredConstructor(clsArr);
        } catch (ReflectiveOperationException e10) {
            androidx.privacysandbox.ads.adservices.customaudience.a.m("Unexpected ReflectiveOperationException occurred (Gson 2.13.2). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e10);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.z3
    public final String[] v(Class cls) {
        try {
            Object[] objArr = (Object[]) this.i.invoke(cls, null);
            String[] strArr = new String[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                strArr[i] = (String) this.j.invoke(objArr[i], null);
            }
            return strArr;
        } catch (ReflectiveOperationException e10) {
            androidx.privacysandbox.ads.adservices.customaudience.a.m("Unexpected ReflectiveOperationException occurred (Gson 2.13.2). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e10);
            return null;
        }
    }
}
