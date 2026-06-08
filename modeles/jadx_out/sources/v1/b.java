package v1;

import a4.x;
import android.util.Log;
import b2.k1;
import java.util.concurrent.atomic.AtomicReference;
import s1.p;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final c f10788c = new c();

    /* renamed from: a, reason: collision with root package name */
    public final p f10789a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f10790b = new AtomicReference(null);

    public b(p pVar) {
        this.f10789a = pVar;
        pVar.a(new androidx.core.view.inputmethod.a(this, 29));
    }

    public final c a() {
        b bVar = (b) this.f10790b.get();
        return bVar == null ? f10788c : bVar.a();
    }

    public final boolean b() {
        b bVar = (b) this.f10790b.get();
        return bVar != null && bVar.b();
    }

    public final boolean c() {
        b bVar = (b) this.f10790b.get();
        return bVar != null && bVar.c();
    }

    public final void d(String str, long j, k1 k1Var) {
        String j6 = x.j("Deferring native open session: ", str);
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", j6, null);
        }
        this.f10789a.a(new a(str, j, k1Var));
    }
}
