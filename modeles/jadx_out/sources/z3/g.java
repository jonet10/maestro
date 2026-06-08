package z3;

import a4.x;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import v3.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g implements v3.e {

    /* renamed from: a, reason: collision with root package name */
    public final f f11946a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f11947b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public final Object f11948c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f11949d = new LinkedHashSet();

    public g(f fVar, j jVar) {
        this.f11946a = fVar;
    }

    public final boolean a(w3.a aVar) {
        boolean add;
        aVar.getClass();
        synchronized (this.f11948c) {
            add = this.f11949d.add(aVar);
        }
        return add;
    }

    public final void b(String str, float f) {
        str.getClass();
        c(this.f11946a, "cueVideo", str, Float.valueOf(f));
    }

    public final void c(f fVar, String str, Object... objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(obj instanceof String ? x.m(new StringBuilder("'"), (String) obj, '\'') : obj.toString());
        }
        this.f11947b.post(new androidx.work.impl.c(fVar, str, arrayList, 5));
    }

    public final void d(String str, float f) {
        str.getClass();
        c(this.f11946a, "loadVideo", str, Float.valueOf(f));
    }

    public final void e() {
        c(this.f11946a, "pauseVideo", new Object[0]);
    }

    public final void f() {
        c(this.f11946a, "playVideo", new Object[0]);
    }
}
