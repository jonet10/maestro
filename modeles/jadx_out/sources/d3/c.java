package d3;

import j$.util.DesugarCollections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f3551a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final Map f3552b = DesugarCollections.synchronizedMap(new LinkedHashMap());

    public static a a(d dVar) {
        Map map = f3552b;
        map.getClass();
        Object obj = map.get(dVar);
        if (obj != null) {
            return (a) obj;
        }
        androidx.core.view.contentcapture.a.p(dVar, "Cannot get dependency ", ". Dependencies should be added at class load time.");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a9 A[Catch: all -> 0x00c2, TRY_ENTER, TryCatch #0 {all -> 0x00c2, blocks: (B:11:0x0096, B:22:0x00a9, B:23:0x00c1), top: B:10:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0095 -> B:10:0x0096). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(v6.c r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof d3.b
            if (r0 == 0) goto L13
            r0 = r10
            d3.b r0 = (d3.b) r0
            int r1 = r0.f3550r
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3550r = r1
            goto L18
        L13:
            d3.b r0 = new d3.b
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f3548p
            int r1 = r0.f3550r
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L3d
            if (r1 != r2) goto L36
            java.lang.Object r1 = r0.f3547o
            java.util.Map r4 = r0.f3546n
            java.util.Map r4 = (java.util.Map) r4
            x7.g r5 = r0.f3545m
            d3.d r6 = r0.f3544l
            java.util.Iterator r7 = r0.f3543b
            java.util.Map r8 = r0.f3542a
            java.util.Map r8 = (java.util.Map) r8
            p6.a.e(r10)
            goto L96
        L36:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r10)
            r10 = 0
            return r10
        L3d:
            p6.a.e(r10)
            java.util.Map r10 = d3.c.f3552b
            r10.getClass()
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            int r4 = r10.size()
            int r4 = q6.a0.h0(r4)
            r1.<init>(r4)
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
            r7 = r10
            r4 = r1
        L5c:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto Lc7
            java.lang.Object r10 = r7.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r1 = r10.getKey()
            java.lang.Object r5 = r10.getKey()
            r6 = r5
            d3.d r6 = (d3.d) r6
            java.lang.Object r10 = r10.getValue()
            d3.a r10 = (d3.a) r10
            x7.g r5 = r10.f3540a
            r10 = r4
            java.util.Map r10 = (java.util.Map) r10
            r0.f3542a = r10
            r0.f3543b = r7
            r0.f3544l = r6
            r0.f3545m = r5
            r0.f3546n = r10
            r0.f3547o = r1
            r0.f3550r = r2
            java.lang.Object r10 = r5.lock(r3, r0)
            u6.a r8 = u6.a.f10762a
            if (r10 != r8) goto L95
            return r8
        L95:
            r8 = r4
        L96:
            r6.getClass()     // Catch: java.lang.Throwable -> Lc2
            d3.a r10 = a(r6)     // Catch: java.lang.Throwable -> Lc2
            y1.i r10 = r10.f3541b     // Catch: java.lang.Throwable -> Lc2
            if (r10 == 0) goto La9
            r5.unlock(r3)
            r4.put(r1, r10)
            r4 = r8
            goto L5c
        La9:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lc2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r1 = "Subscriber "
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Lc2
            r0.append(r6)     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r1 = " has not been registered."
            r0.append(r1)     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lc2
            r10.<init>(r0)     // Catch: java.lang.Throwable -> Lc2
            throw r10     // Catch: java.lang.Throwable -> Lc2
        Lc2:
            r10 = move-exception
            r5.unlock(r3)
            throw r10
        Lc7:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: d3.c.b(v6.c):java.lang.Object");
    }
}
