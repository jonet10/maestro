package r0;

import android.content.Context;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final c f8856b;

    /* renamed from: a, reason: collision with root package name */
    public b f8857a;

    static {
        c cVar = new c();
        cVar.f8857a = null;
        f8856b = cVar;
    }

    public static b a(Context context) {
        b bVar;
        c cVar = f8856b;
        synchronized (cVar) {
            try {
                if (cVar.f8857a == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    cVar.f8857a = new b(context);
                }
                bVar = cVar.f8857a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }
}
