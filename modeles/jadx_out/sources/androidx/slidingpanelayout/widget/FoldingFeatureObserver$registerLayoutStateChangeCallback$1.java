package androidx.slidingpanelayout.widget;

import android.app.Activity;
import androidx.slidingpanelayout.widget.FoldingFeatureObserver;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import d7.p;
import o7.a0;
import p6.a;
import p6.x;
import r7.h;
import r7.k0;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1", f = "FoldingFeatureObserver.kt", l = {97}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FoldingFeatureObserver$registerLayoutStateChangeCallback$1 extends i implements p {
    final /* synthetic */ Activity $activity;
    int label;
    final /* synthetic */ FoldingFeatureObserver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoldingFeatureObserver$registerLayoutStateChangeCallback$1(FoldingFeatureObserver foldingFeatureObserver, Activity activity, c cVar) {
        super(2, cVar);
        this.this$0 = foldingFeatureObserver;
        this.$activity = activity;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new FoldingFeatureObserver$registerLayoutStateChangeCallback$1(this.this$0, this.$activity, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((FoldingFeatureObserver$registerLayoutStateChangeCallback$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        WindowInfoTracker windowInfoTracker;
        int i = this.label;
        if (i == 0) {
            a.e(obj);
            windowInfoTracker = this.this$0.windowInfoTracker;
            final h windowLayoutInfo = windowInfoTracker.windowLayoutInfo(this.$activity);
            final FoldingFeatureObserver foldingFeatureObserver = this.this$0;
            h h = k0.h(new h() { // from class: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1

                /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
                /* renamed from: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2, reason: invalid class name */
                public static final class AnonymousClass2 implements r7.i {
                    final /* synthetic */ r7.i $this_unsafeFlow$inlined;
                    final /* synthetic */ FoldingFeatureObserver this$0;

                    @e(c = "androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2", f = "FoldingFeatureObserver.kt", l = {138}, m = "emit")
                    /* renamed from: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends v6.c {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(c cVar) {
                            super(cVar);
                        }

                        @Override // v6.a
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(r7.i iVar, FoldingFeatureObserver foldingFeatureObserver) {
                        this.$this_unsafeFlow$inlined = iVar;
                        this.this$0 = foldingFeatureObserver;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
                    @Override // r7.i
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public java.lang.Object emit(java.lang.Object r5, t6.c r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = (androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = new androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            int r1 = r0.label
                            r2 = 1
                            if (r1 == 0) goto L2c
                            if (r1 != r2) goto L25
                            p6.a.e(r6)
                            goto L47
                        L25:
                            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
                            r5 = 0
                            return r5
                        L2c:
                            p6.a.e(r6)
                            r7.i r6 = r4.$this_unsafeFlow$inlined
                            androidx.window.layout.WindowLayoutInfo r5 = (androidx.window.layout.WindowLayoutInfo) r5
                            androidx.slidingpanelayout.widget.FoldingFeatureObserver r1 = r4.this$0
                            androidx.window.layout.FoldingFeature r5 = androidx.slidingpanelayout.widget.FoldingFeatureObserver.access$getFoldingFeature(r1, r5)
                            if (r5 != 0) goto L3c
                            goto L47
                        L3c:
                            r0.label = r2
                            java.lang.Object r5 = r6.emit(r5, r0)
                            u6.a r6 = u6.a.f10762a
                            if (r5 != r6) goto L47
                            return r6
                        L47:
                            p6.x r5 = p6.x.f8463a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, t6.c):java.lang.Object");
                    }
                }

                @Override // r7.h
                public Object collect(r7.i iVar, c cVar) {
                    Object collect = h.this.collect(new AnonymousClass2(iVar, foldingFeatureObserver), cVar);
                    return collect == u6.a.f10762a ? collect : x.f8463a;
                }
            });
            final FoldingFeatureObserver foldingFeatureObserver2 = this.this$0;
            r7.i iVar = new r7.i() { // from class: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$collect$1
                @Override // r7.i
                public Object emit(FoldingFeature foldingFeature, c cVar) {
                    FoldingFeatureObserver.OnFoldingFeatureChangeListener onFoldingFeatureChangeListener;
                    x xVar;
                    FoldingFeature foldingFeature2 = foldingFeature;
                    onFoldingFeatureChangeListener = FoldingFeatureObserver.this.onFoldingFeatureChangeListener;
                    x xVar2 = x.f8463a;
                    if (onFoldingFeatureChangeListener == null) {
                        xVar = null;
                    } else {
                        onFoldingFeatureChangeListener.onFoldingFeatureChange(foldingFeature2);
                        xVar = xVar2;
                    }
                    return xVar == u6.a.f10762a ? xVar : xVar2;
                }
            };
            this.label = 1;
            Object collect = h.collect(iVar, this);
            u6.a aVar = u6.a.f10762a;
            if (collect == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            a.e(obj);
        }
        return x.f8463a;
    }
}
