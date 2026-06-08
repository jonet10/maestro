package s0;

import android.os.IBinder;
import android.os.IInterface;
import java.lang.reflect.Field;
import k0.y;
import y2.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends w0.b implements a {
    public final Object j;

    public b(Object obj) {
        super("com.google.android.gms.dynamic.IObjectWrapper", 2);
        this.j = obj;
    }

    public static a I(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
        return queryLocalInterface instanceof a ? (a) queryLocalInterface : new c(iBinder, "com.google.android.gms.dynamic.IObjectWrapper", 3);
    }

    public static Object J(a aVar) {
        if (aVar instanceof b) {
            return ((b) aVar).j;
        }
        IBinder asBinder = aVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            int length = declaredFields.length;
            n.a(String.valueOf(length).length() + 53, length, "Unexpected number of IObjectWrapper declared fields: ");
            return null;
        }
        y.g(field);
        if (field.isAccessible()) {
            com.google.gson.internal.a.p("IObjectWrapper declared field not private!");
            return null;
        }
        field.setAccessible(true);
        try {
            return field.get(asBinder);
        } catch (IllegalAccessException e10) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e10);
        } catch (NullPointerException e11) {
            throw new IllegalArgumentException("Binder object is null.", e11);
        }
    }
}
