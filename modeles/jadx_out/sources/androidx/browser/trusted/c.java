package androidx.browser.trusted;

import s1.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f324a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f325b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f326l;

    public /* synthetic */ c(int i, Object obj, Object obj2) {
        this.f324a = i;
        this.f325b = obj;
        this.f326l = obj2;
    }

    private final void a() {
        n nVar = (n) this.f325b;
        s2.b bVar = (s2.b) this.f326l;
        synchronized (nVar) {
            try {
                if (nVar.f9144b == null) {
                    nVar.f9143a.add(bVar);
                } else {
                    nVar.f9144b.add(bVar.get());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0356  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1082
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.browser.trusted.c.run():void");
    }
}
