package c3;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final n1.f f1294a;

    /* renamed from: b, reason: collision with root package name */
    public final f3.j f1295b;

    public o(n1.f fVar, f3.j jVar, t6.h hVar, w0 w0Var) {
        fVar.getClass();
        jVar.getClass();
        hVar.getClass();
        w0Var.getClass();
        this.f1294a = fVar;
        this.f1295b = jVar;
        Log.d("FirebaseSessions", "Initializing Firebase Sessions 3.0.4.");
        fVar.a();
        Context applicationContext = fVar.f7908a.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(w0Var);
            o7.c0.s(o7.c0.b(hVar), null, null, new b.n(this, w0Var, (t6.c) null, 5), 3);
        } else {
            Log.e("FirebaseSessions", "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + '.');
        }
    }
}
