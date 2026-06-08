package androidx.datastore.core;

import d7.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CloseableKt {
    public static final <T extends Closeable, R> R use(T t9, l lVar) {
        t9.getClass();
        lVar.getClass();
        try {
            R r9 = (R) lVar.invoke(t9);
            try {
                t9.close();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            if (th == null) {
                return r9;
            }
            throw th;
        } catch (Throwable th2) {
            try {
                t9.close();
            } catch (Throwable th3) {
                p6.a.a(th2, th3);
            }
            throw th2;
        }
    }
}
