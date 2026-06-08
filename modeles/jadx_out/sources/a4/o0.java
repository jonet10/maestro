package a4;

import android.os.HandlerThread;
import android.os.Looper;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    public final a3.d f147a;

    /* renamed from: b, reason: collision with root package name */
    public final n f148b;

    /* renamed from: c, reason: collision with root package name */
    public long f149c;

    /* renamed from: d, reason: collision with root package name */
    public long f150d;

    /* renamed from: e, reason: collision with root package name */
    public long f151e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;

    /* renamed from: k, reason: collision with root package name */
    public int f152k;

    /* renamed from: l, reason: collision with root package name */
    public int f153l;

    /* renamed from: m, reason: collision with root package name */
    public int f154m;

    public o0(a3.d dVar) {
        this.f147a = dVar;
        HandlerThread handlerThread = new HandlerThread("Picasso-Stats", 10);
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        StringBuilder sb = t0.f177a;
        c0 c0Var = new c0(looper, 1, false);
        c0Var.sendMessageDelayed(c0Var.obtainMessage(), 1000L);
        this.f148b = new n(handlerThread.getLooper(), this, 1);
    }

    public final p0 a() {
        a3.d dVar = this.f147a;
        return new p0(((u) dVar.f63b).maxSize(), ((u) dVar.f63b).size(), this.f149c, this.f150d, this.f151e, this.f, this.g, this.h, this.i, this.j, this.f152k, this.f153l, this.f154m, System.currentTimeMillis());
    }
}
