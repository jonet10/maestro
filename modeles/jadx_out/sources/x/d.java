package x;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import j$.util.Objects;
import r.j;
import y.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f11018a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f11019b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f11020l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Runnable f11021m;

    public /* synthetic */ d(g gVar, j jVar, int i, Runnable runnable) {
        this.f11018a = gVar;
        this.f11019b = jVar;
        this.f11020l = i;
        this.f11021m = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final j jVar = this.f11019b;
        final int i = this.f11020l;
        Runnable runnable = this.f11021m;
        final g gVar = this.f11018a;
        z.c cVar = gVar.f;
        try {
            try {
                y.d dVar = gVar.f11030c;
                Objects.requireNonNull(dVar);
                ((h) cVar).h(new v4.a(dVar, 2));
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) gVar.f11028a.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    ((h) cVar).h(new z.b() { // from class: x.e
                        @Override // z.b
                        public final Object execute() {
                            g.this.f11031d.e(jVar, i + 1, false);
                            return null;
                        }
                    });
                } else {
                    gVar.a(jVar, i);
                }
                runnable.run();
            } catch (z.a unused) {
                gVar.f11031d.e(jVar, i + 1, false);
                runnable.run();
            }
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }
}
