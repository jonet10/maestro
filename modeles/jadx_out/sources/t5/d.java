package t5;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import e4.h1;
import eightbitlab.com.blurview.BlurView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d implements b {

    /* renamed from: a, reason: collision with root package name */
    public final a f10289a;

    /* renamed from: b, reason: collision with root package name */
    public c f10290b;

    /* renamed from: l, reason: collision with root package name */
    public Bitmap f10291l;

    /* renamed from: m, reason: collision with root package name */
    public final BlurView f10292m;

    /* renamed from: n, reason: collision with root package name */
    public final int f10293n;

    /* renamed from: o, reason: collision with root package name */
    public final ViewGroup f10294o;

    /* renamed from: p, reason: collision with root package name */
    public final int[] f10295p = new int[2];

    /* renamed from: q, reason: collision with root package name */
    public final int[] f10296q = new int[2];

    /* renamed from: r, reason: collision with root package name */
    public final h1 f10297r = new h1(this, 2);

    /* renamed from: s, reason: collision with root package name */
    public boolean f10298s;

    /* renamed from: t, reason: collision with root package name */
    public Drawable f10299t;

    public d(BlurView blurView, ViewGroup viewGroup, int i, a aVar) {
        this.f10294o = viewGroup;
        this.f10292m = blurView;
        this.f10293n = i;
        this.f10289a = aVar;
        if (aVar instanceof f) {
            ((f) aVar).f = blurView.getContext();
        }
        a(blurView.getMeasuredWidth(), blurView.getMeasuredHeight());
    }

    public final void a(int i, int i6) {
        d(true);
        a aVar = this.f10289a;
        aVar.getClass();
        float f = i6;
        int ceil = (int) Math.ceil(f / 6.0f);
        BlurView blurView = this.f10292m;
        if (ceil != 0) {
            double d10 = i / 6.0f;
            if (((int) Math.ceil(d10)) != 0) {
                blurView.setWillNotDraw(false);
                int ceil2 = (int) Math.ceil(d10);
                int i10 = ceil2 % 64;
                if (i10 != 0) {
                    ceil2 = (ceil2 - i10) + 64;
                }
                int ceil3 = (int) Math.ceil(f / (r8 / ceil2));
                aVar.a();
                this.f10291l = Bitmap.createBitmap(ceil2, ceil3, Bitmap.Config.ARGB_8888);
                this.f10290b = new c(this.f10291l);
                this.f10298s = true;
                b();
                return;
            }
        }
        blurView.setWillNotDraw(true);
    }

    public final void b() {
        if (this.f10298s) {
            Drawable drawable = this.f10299t;
            if (drawable == null) {
                this.f10291l.eraseColor(0);
            } else {
                drawable.draw(this.f10290b);
            }
            this.f10290b.save();
            ViewGroup viewGroup = this.f10294o;
            int[] iArr = this.f10295p;
            viewGroup.getLocationOnScreen(iArr);
            BlurView blurView = this.f10292m;
            int[] iArr2 = this.f10296q;
            blurView.getLocationOnScreen(iArr2);
            int i = iArr2[0] - iArr[0];
            int i6 = iArr2[1] - iArr[1];
            float height = blurView.getHeight() / this.f10291l.getHeight();
            float width = blurView.getWidth() / this.f10291l.getWidth();
            this.f10290b.translate((-i) / width, (-i6) / height);
            this.f10290b.scale(1.0f / width, 1.0f / height);
            viewGroup.draw(this.f10290b);
            this.f10290b.restore();
            this.f10291l = this.f10289a.c(this.f10291l, 16.0f);
        }
    }

    @Override // t5.b
    public final b d(boolean z9) {
        ViewGroup viewGroup = this.f10294o;
        ViewTreeObserver viewTreeObserver = viewGroup.getViewTreeObserver();
        h1 h1Var = this.f10297r;
        viewTreeObserver.removeOnPreDrawListener(h1Var);
        if (z9) {
            viewGroup.getViewTreeObserver().addOnPreDrawListener(h1Var);
        }
        return this;
    }

    @Override // t5.b
    public final void destroy() {
        d(false);
        this.f10289a.destroy();
        this.f10298s = false;
    }

    @Override // t5.b
    public final boolean draw(Canvas canvas) {
        if (this.f10298s) {
            if (canvas instanceof c) {
                return false;
            }
            BlurView blurView = this.f10292m;
            float height = blurView.getHeight() / this.f10291l.getHeight();
            canvas.save();
            canvas.scale(blurView.getWidth() / this.f10291l.getWidth(), height);
            this.f10289a.b(canvas, this.f10291l);
            canvas.restore();
            int i = this.f10293n;
            if (i != 0) {
                canvas.drawColor(i);
            }
        }
        return true;
    }

    @Override // t5.b
    public final void e() {
        BlurView blurView = this.f10292m;
        a(blurView.getMeasuredWidth(), blurView.getMeasuredHeight());
    }
}
