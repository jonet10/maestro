package f3;

import androidx.datastore.core.DataStore;
import c3.h1;
import java.util.concurrent.atomic.AtomicReference;
import o7.c0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final h1 f4866a;

    /* renamed from: b, reason: collision with root package name */
    public final DataStore f4867b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference f4868c;

    public n(t6.h hVar, h1 h1Var, DataStore dataStore) {
        hVar.getClass();
        h1Var.getClass();
        dataStore.getClass();
        this.f4866a = h1Var;
        this.f4867b = dataStore;
        this.f4868c = new AtomicReference();
        c0.s(c0.b(hVar), null, null, new l(this, null, 0), 3);
    }

    public final g a() {
        AtomicReference atomicReference = this.f4868c;
        if (atomicReference.get() == null) {
            Object w2 = c0.w(t6.i.f10314a, new l(this, null, 1));
            while (!atomicReference.compareAndSet(null, w2) && atomicReference.get() == null) {
            }
        }
        Object obj = atomicReference.get();
        obj.getClass();
        return (g) obj;
    }

    public final boolean b() {
        Long l10 = a().f4850e;
        Integer num = a().f4849d;
        if (l10 == null || num == null) {
            return true;
        }
        this.f4866a.getClass();
        return h1.a().f1249c - l10.longValue() >= ((long) num.intValue());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(4:18|19|20|(1:22))|11|12|13))|25|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0025, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        android.util.Log.w("FirebaseSessions", "Failed to update config values: " + r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(f3.g r6, v6.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof f3.m
            if (r0 == 0) goto L13
            r0 = r7
            f3.m r0 = (f3.m) r0
            int r1 = r0.f4865l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4865l = r1
            goto L18
        L13:
            f3.m r0 = new f3.m
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f4863a
            int r1 = r0.f4865l
            r2 = 1
            if (r1 == 0) goto L2e
            if (r1 != r2) goto L27
            p6.a.e(r7)     // Catch: java.io.IOException -> L25
            goto L59
        L25:
            r6 = move-exception
            goto L46
        L27:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            r6 = 0
            return r6
        L2e:
            p6.a.e(r7)
            androidx.datastore.core.DataStore r7 = r5.f4867b     // Catch: java.io.IOException -> L25
            c4.g r1 = new c4.g     // Catch: java.io.IOException -> L25
            r3 = 0
            r4 = 10
            r1.<init>(r6, r3, r4)     // Catch: java.io.IOException -> L25
            r0.f4865l = r2     // Catch: java.io.IOException -> L25
            java.lang.Object r6 = r7.updateData(r1, r0)     // Catch: java.io.IOException -> L25
            u6.a r7 = u6.a.f10762a
            if (r6 != r7) goto L59
            return r7
        L46:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Failed to update config values: "
            r7.<init>(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "FirebaseSessions"
            android.util.Log.w(r7, r6)
        L59:
            p6.x r6 = p6.x.f8463a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.n.c(f3.g, v6.c):java.lang.Object");
    }
}
