package g4;

import com.uptodown.core.activities.FileExplorerActivity;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5259a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f5260b;

    /* renamed from: l, reason: collision with root package name */
    public int f5261l;

    /* renamed from: m, reason: collision with root package name */
    public Object f5262m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f5263n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f5264o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(r7.h[] hVarArr, int i, AtomicInteger atomicInteger, q7.e eVar, t6.c cVar) {
        super(2, cVar);
        this.f5262m = hVarArr;
        this.f5261l = i;
        this.f5263n = atomicInteger;
        this.f5264o = eVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f5259a) {
            case 0:
                return new t((FileExplorerActivity) this.f5263n, (kotlin.jvm.internal.v) this.f5264o, cVar);
            default:
                return new t((r7.h[]) this.f5262m, this.f5261l, (AtomicInteger) this.f5263n, (q7.e) this.f5264o, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f5259a) {
        }
        return ((t) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00a8 -> B:28:0x00c1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00bd -> B:28:0x00c1). Please report as a decompilation issue!!! */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            int r0 = r10.f5259a
            p6.x r1 = p6.x.f8463a
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            u6.a r3 = u6.a.f10762a
            r4 = 1
            java.lang.Object r5 = r10.f5264o
            java.lang.Object r6 = r10.f5263n
            r7 = 0
            switch(r0) {
                case 0: goto L54;
                default: goto L11;
            }
        L11:
            java.util.concurrent.atomic.AtomicInteger r6 = (java.util.concurrent.atomic.AtomicInteger) r6
            q7.e r5 = (q7.e) r5
            int r0 = r10.f5260b
            if (r0 == 0) goto L26
            if (r0 != r4) goto L21
            p6.a.e(r11)     // Catch: java.lang.Throwable -> L1f
            goto L40
        L1f:
            r11 = move-exception
            goto L4a
        L21:
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r2)
            r1 = r7
            goto L49
        L26:
            p6.a.e(r11)
            java.lang.Object r11 = r10.f5262m     // Catch: java.lang.Throwable -> L1f
            r7.h[] r11 = (r7.h[]) r11     // Catch: java.lang.Throwable -> L1f
            int r0 = r10.f5261l     // Catch: java.lang.Throwable -> L1f
            r11 = r11[r0]     // Catch: java.lang.Throwable -> L1f
            s7.f r2 = new s7.f     // Catch: java.lang.Throwable -> L1f
            r2.<init>(r5, r0)     // Catch: java.lang.Throwable -> L1f
            r10.f5260b = r4     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r11 = r11.collect(r2, r10)     // Catch: java.lang.Throwable -> L1f
            if (r11 != r3) goto L40
            r1 = r3
            goto L49
        L40:
            int r11 = r6.decrementAndGet()
            if (r11 != 0) goto L49
            r5.m(r7)
        L49:
            return r1
        L4a:
            int r0 = r6.decrementAndGet()
            if (r0 != 0) goto L53
            r5.m(r7)
        L53:
            throw r11
        L54:
            com.uptodown.core.activities.FileExplorerActivity r6 = (com.uptodown.core.activities.FileExplorerActivity) r6
            int r0 = r10.f5261l
            r8 = 0
            if (r0 == 0) goto L6c
            if (r0 != r4) goto L67
            int r0 = r10.f5260b
            java.lang.Object r2 = r10.f5262m
            java.util.Iterator r2 = (java.util.Iterator) r2
            p6.a.e(r11)
            goto Lc1
        L67:
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r2)
            r1 = r7
            goto Lc3
        L6c:
            p6.a.e(r11)
            i4.b r11 = r6.V
            if (r11 == 0) goto Lc3
            java.util.ArrayList r11 = r11.a()
            kotlin.jvm.internal.v r5 = (kotlin.jvm.internal.v) r5
            int r0 = r11.size()
            r5.f7022a = r0
            java.util.Iterator r11 = r11.iterator()
            r2 = r11
            r11 = r8
        L85:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto Lc3
            int r0 = r11 + 1
            java.lang.Object r5 = r2.next()
            boolean r9 = r5 instanceof java.io.File
            if (r9 == 0) goto L9c
            java.io.File r5 = (java.io.File) r5
            boolean r5 = com.google.android.gms.internal.measurement.i5.l(r5)
            goto La8
        L9c:
            boolean r9 = r5 instanceof androidx.documentfile.provider.DocumentFile
            if (r9 == 0) goto La7
            androidx.documentfile.provider.DocumentFile r5 = (androidx.documentfile.provider.DocumentFile) r5
            boolean r5 = r5.delete()
            goto La8
        La7:
            r5 = r8
        La8:
            if (r5 == 0) goto Lc1
            v7.e r5 = o7.m0.f8288a
            p7.c r5 = t7.n.f10348a
            g4.o r9 = new g4.o
            r9.<init>(r6, r11, r7)
            r10.f5262m = r2
            r10.f5260b = r0
            r10.f5261l = r4
            java.lang.Object r11 = o7.c0.C(r9, r5, r10)
            if (r11 != r3) goto Lc1
            r1 = r3
            goto Lc3
        Lc1:
            r11 = r0
            goto L85
        Lc3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.t.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(FileExplorerActivity fileExplorerActivity, kotlin.jvm.internal.v vVar, t6.c cVar) {
        super(2, cVar);
        this.f5263n = fileExplorerActivity;
        this.f5264o = vVar;
    }
}
