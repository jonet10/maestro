package a4;

import android.util.Log;
import com.uptodown.activities.AppDetailActivity;
import e1.c1;
import e1.u4;
import e1.v4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f89a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f90b;

    public f(j0.k kVar, f8.q qVar) {
        this.f89a = 18;
        this.f90b = qVar;
    }

    private final void a() {
        i1.a aVar = (i1.a) this.f90b;
        synchronized (aVar.f5625a) {
            try {
                if (aVar.b()) {
                    Log.e("WakeLock", String.valueOf(aVar.j).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                    aVar.d();
                    if (aVar.b()) {
                        aVar.f5627c = 1;
                        aVar.e();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void b() {
        j1.m mVar = (j1.m) this.f90b;
        synchronized (mVar.f6556l) {
            try {
                j1.c cVar = (j1.c) mVar.f6557m;
                if (cVar != null) {
                    cVar.f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void c() {
        while (true) {
            long a8 = ((m8.m) this.f90b).a(System.nanoTime());
            if (a8 == -1) {
                return;
            }
            if (a8 > 0) {
                long j = a8 / 1000000;
                long j6 = a8 - (1000000 * j);
                synchronized (((m8.m) this.f90b)) {
                    try {
                        ((m8.m) this.f90b).wait(j, (int) j6);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x0322, code lost:
    
        if (r0.N() >= 242600) goto L91;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1088
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.f.run():void");
    }

    public /* synthetic */ f(Object obj, int i) {
        this.f89a = i;
        this.f90b = obj;
    }

    public f(c1 c1Var, boolean z9) {
        this.f89a = 4;
        this.f90b = c1Var;
    }

    public f(u4 u4Var, v4 v4Var) {
        this.f89a = 8;
        this.f90b = u4Var;
    }

    public f(AppDetailActivity appDetailActivity, String str, int i) {
        this.f89a = 2;
        this.f90b = appDetailActivity;
    }
}
