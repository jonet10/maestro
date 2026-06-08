package s1;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k implements p2.c, p2.b {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f9137a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayDeque f9138b;

    /* renamed from: c, reason: collision with root package name */
    public final t1.j f9139c;

    public k() {
        t1.j jVar = t1.j.f9533a;
        this.f9137a = new HashMap();
        this.f9138b = new ArrayDeque();
        this.f9139c = jVar;
    }

    public final synchronized void a(Executor executor, p2.a aVar) {
        try {
            executor.getClass();
            if (!this.f9137a.containsKey(d0.b.class)) {
                this.f9137a.put(d0.b.class, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.f9137a.get(d0.b.class)).put(aVar, executor);
        } catch (Throwable th) {
            throw th;
        }
    }
}
