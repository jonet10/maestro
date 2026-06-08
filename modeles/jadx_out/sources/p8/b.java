package p8;

import java.io.IOException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends RuntimeException {

    /* renamed from: b, reason: collision with root package name */
    public static final Method f8478b;

    /* renamed from: a, reason: collision with root package name */
    public IOException f8479a;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            method = null;
        }
        f8478b = method;
    }

    public b(IOException iOException) {
        super(iOException);
        this.f8479a = iOException;
    }
}
