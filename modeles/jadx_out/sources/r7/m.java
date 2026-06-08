package r7;

import androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m implements h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl$data$1$invokeSuspend$$inlined$map$1 f9015a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d7.q f9016b;

    public m(DataStoreImpl$data$1$invokeSuspend$$inlined$map$1 dataStoreImpl$data$1$invokeSuspend$$inlined$map$1, d7.q qVar) {
        this.f9015a = dataStoreImpl$data$1$invokeSuspend$$inlined$map$1;
        this.f9016b = qVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // r7.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(r7.i r9, t6.c r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof r7.l
            if (r0 == 0) goto L13
            r0 = r10
            r7.l r0 = (r7.l) r0
            int r1 = r0.f9009b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9009b = r1
            goto L18
        L13:
            r7.l r0 = new r7.l
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f9008a
            int r1 = r0.f9009b
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            u6.a r6 = u6.a.f10762a
            if (r1 == 0) goto L4f
            if (r1 == r4) goto L43
            if (r1 == r3) goto L3b
            if (r1 != r2) goto L34
            java.lang.Object r9 = r0.f9011m
            s7.l r9 = (s7.l) r9
            p6.a.e(r10)     // Catch: java.lang.Throwable -> L32
            goto L7b
        L32:
            r10 = move-exception
            goto L85
        L34:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r9)
            r9 = 0
            return r9
        L3b:
            java.lang.Object r9 = r0.f9011m
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            p6.a.e(r10)
            goto L9f
        L43:
            r7.i r9 = r0.f9012n
            java.lang.Object r1 = r0.f9011m
            r7.m r1 = (r7.m) r1
            p6.a.e(r10)     // Catch: java.lang.Throwable -> L4d
            goto L62
        L4d:
            r9 = move-exception
            goto L8b
        L4f:
            p6.a.e(r10)
            androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1 r10 = r8.f9015a     // Catch: java.lang.Throwable -> L89
            r0.f9011m = r8     // Catch: java.lang.Throwable -> L89
            r0.f9012n = r9     // Catch: java.lang.Throwable -> L89
            r0.f9009b = r4     // Catch: java.lang.Throwable -> L89
            java.lang.Object r10 = r10.collect(r9, r0)     // Catch: java.lang.Throwable -> L89
            if (r10 != r6) goto L61
            goto L9e
        L61:
            r1 = r8
        L62:
            s7.l r10 = new s7.l
            t6.h r3 = r0.getContext()
            r10.<init>(r9, r3)
            d7.q r9 = r1.f9016b     // Catch: java.lang.Throwable -> L81
            r0.f9011m = r10     // Catch: java.lang.Throwable -> L81
            r0.f9012n = r5     // Catch: java.lang.Throwable -> L81
            r0.f9009b = r2     // Catch: java.lang.Throwable -> L81
            java.lang.Object r9 = r9.invoke(r10, r5, r0)     // Catch: java.lang.Throwable -> L81
            if (r9 != r6) goto L7a
            goto L9e
        L7a:
            r9 = r10
        L7b:
            r9.releaseIntercepted()
            p6.x r9 = p6.x.f8463a
            return r9
        L81:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L85:
            r9.releaseIntercepted()
            throw r10
        L89:
            r9 = move-exception
            r1 = r8
        L8b:
            r7.q0 r10 = new r7.q0
            r10.<init>(r9)
            d7.q r1 = r1.f9016b
            r0.f9011m = r9
            r0.f9012n = r5
            r0.f9009b = r3
            java.lang.Object r10 = r7.k0.c(r10, r1, r9, r0)
            if (r10 != r6) goto L9f
        L9e:
            return r6
        L9f:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: r7.m.collect(r7.i, t6.c):java.lang.Object");
    }
}
