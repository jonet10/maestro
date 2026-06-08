package p7;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import p6.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class d {
    private static volatile Choreographer choreographer;

    static {
        Object jVar;
        try {
            jVar = new c(a(Looper.getMainLooper()), false);
        } catch (Throwable th) {
            jVar = new j(th);
        }
        if (jVar instanceof j) {
            jVar = null;
        }
    }

    public static final Handler a(Looper looper) {
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        invoke.getClass();
        return (Handler) invoke;
    }
}
