package androidx.lifecycle;

import d7.p;
import o7.c0;
import o7.e1;
import o7.m0;
import o7.u1;
import o7.x;
import t7.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {
    private BlockRunner<T> blockRunner;
    private EmittedSource emittedSource;

    public CoroutineLiveData(t6.h hVar, long j, p pVar) {
        hVar.getClass();
        pVar.getClass();
        u1 u1Var = new u1((e1) hVar.get(x.f8327b));
        v7.e eVar = m0.f8288a;
        this.blockRunner = new BlockRunner<>(this, pVar, j, c0.b(n.f10348a.f8468l.plus(hVar).plus(u1Var)), new b(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final p6.x _init_$lambda$0(CoroutineLiveData coroutineLiveData) {
        coroutineLiveData.blockRunner = null;
        return p6.x.f8463a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object clearSource$lifecycle_livedata(t6.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.lifecycle.CoroutineLiveData$clearSource$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.lifecycle.CoroutineLiveData$clearSource$1 r0 = (androidx.lifecycle.CoroutineLiveData$clearSource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.lifecycle.CoroutineLiveData$clearSource$1 r0 = new androidx.lifecycle.CoroutineLiveData$clearSource$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L2c
            if (r1 != r2) goto L25
            p6.a.e(r5)
            goto L3e
        L25:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            r5 = 0
            return r5
        L2c:
            p6.a.e(r5)
            androidx.lifecycle.EmittedSource r5 = r4.emittedSource
            if (r5 == 0) goto L3e
            r0.label = r2
            java.lang.Object r5 = r5.disposeNow(r0)
            u6.a r0 = u6.a.f10762a
            if (r5 != r0) goto L3e
            return r0
        L3e:
            r5 = 0
            r4.emittedSource = r5
            p6.x r5 = p6.x.f8463a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.CoroutineLiveData.clearSource$lifecycle_livedata(t6.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
    
        if (r7 != r4) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        if (clearSource$lifecycle_livedata(r0) == r4) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emitSource$lifecycle_livedata(androidx.lifecycle.LiveData<T> r6, t6.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.lifecycle.CoroutineLiveData$emitSource$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.lifecycle.CoroutineLiveData$emitSource$1 r0 = (androidx.lifecycle.CoroutineLiveData$emitSource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.lifecycle.CoroutineLiveData$emitSource$1 r0 = new androidx.lifecycle.CoroutineLiveData$emitSource$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            int r1 = r0.label
            r2 = 2
            r3 = 1
            u6.a r4 = u6.a.f10762a
            if (r1 == 0) goto L39
            if (r1 == r3) goto L31
            if (r1 != r2) goto L2a
            p6.a.e(r7)
            goto L53
        L2a:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            r6 = 0
            return r6
        L31:
            java.lang.Object r6 = r0.L$0
            androidx.lifecycle.LiveData r6 = (androidx.lifecycle.LiveData) r6
            p6.a.e(r7)
            goto L47
        L39:
            p6.a.e(r7)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r5.clearSource$lifecycle_livedata(r0)
            if (r7 != r4) goto L47
            goto L52
        L47:
            r7 = 0
            r0.L$0 = r7
            r0.label = r2
            java.lang.Object r7 = androidx.lifecycle.CoroutineLiveDataKt.addDisposableSource(r5, r6, r0)
            if (r7 != r4) goto L53
        L52:
            return r4
        L53:
            androidx.lifecycle.EmittedSource r7 = (androidx.lifecycle.EmittedSource) r7
            r5.emittedSource = r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.CoroutineLiveData.emitSource$lifecycle_livedata(androidx.lifecycle.LiveData, t6.c):java.lang.Object");
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.maybeRun();
        }
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.cancel();
        }
    }

    public /* synthetic */ CoroutineLiveData(t6.h hVar, long j, p pVar, int i, kotlin.jvm.internal.g gVar) {
        this((i & 1) != 0 ? t6.i.f10314a : hVar, (i & 2) != 0 ? CoroutineLiveDataKt.DEFAULT_TIMEOUT : j, pVar);
    }
}
