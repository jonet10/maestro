package com.uptodown.util.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class UsernameTextView extends AppCompatTextView {

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f3452s = 0;

    /* renamed from: a, reason: collision with root package name */
    public ValueAnimator f3453a;

    /* renamed from: b, reason: collision with root package name */
    public float f3454b;

    /* renamed from: l, reason: collision with root package name */
    public int[] f3455l;

    /* renamed from: m, reason: collision with root package name */
    public Integer f3456m;

    /* renamed from: n, reason: collision with root package name */
    public long f3457n;

    /* renamed from: o, reason: collision with root package name */
    public long f3458o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3459p;

    /* renamed from: q, reason: collision with root package name */
    public String f3460q;

    /* renamed from: r, reason: collision with root package name */
    public Handler f3461r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UsernameTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        this.f3461r = new Handler(Looper.getMainLooper());
        this.f3456m = Integer.valueOf(getCurrentTextColor());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public final void a() {
        int color;
        getPaint().setShader(null);
        String str = this.f3460q;
        if (str != null) {
            switch (str.hashCode()) {
                case 110843959:
                    if (str.equals("type1")) {
                        color = ContextCompat.getColor(getContext(), 2131100806);
                        break;
                    }
                    break;
                case 110843960:
                    if (str.equals("type2")) {
                        color = ContextCompat.getColor(getContext(), 2131100808);
                        break;
                    }
                    break;
                case 110843961:
                    if (str.equals("type3")) {
                        color = ContextCompat.getColor(getContext(), 2131100810);
                        break;
                    }
                    break;
            }
            setTextColor(color);
        }
        color = ContextCompat.getColor(getContext(), 2131100790);
        setTextColor(color);
    }

    public final Handler getAnimationHandler() {
        return this.f3461r;
    }

    public final String getUsernameFormat() {
        return this.f3460q;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.getClass();
        if (this.f3455l != null) {
            ValueAnimator valueAnimator = this.f3453a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                a();
            } else {
                float width = getWidth();
                int[] iArr = this.f3455l;
                iArr.getClass();
                float f = this.f3454b;
                getPaint().setShader(new LinearGradient(0.0f, 0.0f, width, 0.0f, iArr, new float[]{0.0f, f, f, f, 1.0f}, Shader.TileMode.CLAMP));
            }
        } else {
            Integer num = this.f3456m;
            if (num != null) {
                num.getClass();
                setTextColor(num.intValue());
            }
        }
        super.onDraw(canvas);
    }

    public final void setAnimationHandler(Handler handler) {
        this.f3461r = handler;
    }

    public final void setTurbo(boolean z9) {
        this.f3459p = z9;
    }

    public final void setUsernameFormat(String str) {
        this.f3460q = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UsernameTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        context.getClass();
    }

    public /* synthetic */ UsernameTextView(Context context, AttributeSet attributeSet, int i, int i6, g gVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UsernameTextView(Context context) {
        this(context, null, 0, 6, null);
        context.getClass();
    }
}
