package androidx.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import d7.p;
import kotlin.jvm.internal.m;
import p6.x;
import q7.r;
import q7.s;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", l = {85}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends i implements p {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PipHintTrackerKt$trackPipAnimationHintView$flow$1(View view, t6.c cVar) {
        super(2, cVar);
        this.$view = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(s sVar, View view, int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15) {
        Rect trackPipAnimationHintView$positionInWindow;
        if (i == i12 && i10 == i14 && i6 == i13 && i11 == i15) {
            return;
        }
        trackPipAnimationHintView$positionInWindow = PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(view);
        ((r) sVar).p(trackPipAnimationHintView$positionInWindow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(s sVar, View view) {
        Rect trackPipAnimationHintView$positionInWindow;
        trackPipAnimationHintView$positionInWindow = PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(view);
        ((r) sVar).p(trackPipAnimationHintView$positionInWindow);
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, cVar);
        pipHintTrackerKt$trackPipAnimationHintView$flow$1.L$0 = obj;
        return pipHintTrackerKt$trackPipAnimationHintView$flow$1;
    }

    @Override // d7.p
    public final Object invoke(s sVar, t6.c cVar) {
        return ((PipHintTrackerKt$trackPipAnimationHintView$flow$1) create(sVar, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.view.View$OnAttachStateChangeListener, androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1] */
    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Rect trackPipAnimationHintView$positionInWindow;
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            final s sVar = (s) this.L$0;
            final View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: androidx.activity.f
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
                    PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$0(s.this, view, i6, i10, i11, i12, i13, i14, i15, i16);
                }
            };
            final View view = this.$view;
            final ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.activity.g
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$1(s.this, view);
                }
            };
            ?? r42 = new View.OnAttachStateChangeListener() { // from class: androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    Rect trackPipAnimationHintView$positionInWindow2;
                    s sVar2 = s.this;
                    trackPipAnimationHintView$positionInWindow2 = PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(view);
                    ((r) sVar2).p(trackPipAnimationHintView$positionInWindow2);
                    view.getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
                    view.addOnLayoutChangeListener(onLayoutChangeListener);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                    view2.getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
                    view2.removeOnLayoutChangeListener(onLayoutChangeListener);
                }
            };
            if (Api19Impl.INSTANCE.isAttachedToWindow(this.$view)) {
                trackPipAnimationHintView$positionInWindow = PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(this.$view);
                ((r) sVar).p(trackPipAnimationHintView$positionInWindow);
                this.$view.getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
                this.$view.addOnLayoutChangeListener(onLayoutChangeListener);
            }
            this.$view.addOnAttachStateChangeListener(r42);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$view, onScrollChangedListener, onLayoutChangeListener, r42);
            this.label = 1;
            Object o10 = d0.b.o(sVar, anonymousClass1, this);
            u6.a aVar = u6.a.f10762a;
            if (o10 == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return x.f8463a;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    /* renamed from: androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends m implements d7.a {
        final /* synthetic */ PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 $attachStateChangeListener;
        final /* synthetic */ View.OnLayoutChangeListener $layoutChangeListener;
        final /* synthetic */ ViewTreeObserver.OnScrollChangedListener $scrollChangeListener;
        final /* synthetic */ View $view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener, View.OnLayoutChangeListener onLayoutChangeListener, PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1) {
            super(0);
            this.$view = view;
            this.$scrollChangeListener = onScrollChangedListener;
            this.$layoutChangeListener = onLayoutChangeListener;
            this.$attachStateChangeListener = pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m5invoke() {
            this.$view.getViewTreeObserver().removeOnScrollChangedListener(this.$scrollChangeListener);
            this.$view.removeOnLayoutChangeListener(this.$layoutChangeListener);
            this.$view.removeOnAttachStateChangeListener(this.$attachStateChangeListener);
        }

        @Override // d7.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m5invoke();
            return x.f8463a;
        }
    }
}
