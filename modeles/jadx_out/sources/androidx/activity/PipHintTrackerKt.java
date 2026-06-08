package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import p6.x;
import r7.i;
import r7.k0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PipHintTrackerKt {
    @RequiresApi(26)
    public static final Object trackPipAnimationHintView(final Activity activity, View view, t6.c cVar) {
        Object collect = k0.e(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(view, null)).collect(new i() { // from class: androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$2
            @Override // r7.i
            public final Object emit(Rect rect, t6.c cVar2) {
                Api26Impl.INSTANCE.setPipParamsSourceRectHint(activity, rect);
                return x.f8463a;
            }
        }, cVar);
        return collect == u6.a.f10762a ? collect : x.f8463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect trackPipAnimationHintView$positionInWindow(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
