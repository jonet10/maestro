package t7;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Collection f10323a;

    static {
        try {
            Iterator it = Arrays.asList(new p7.b()).iterator();
            it.getClass();
            f10323a = k7.i.i0(new k7.a(new a7.e(it, 2)));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
