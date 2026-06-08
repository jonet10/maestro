package x4;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.UptodownApp;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11289a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11290b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f11291l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f11292m;

    public /* synthetic */ n(Object obj, Object obj2, Object obj3, int i) {
        this.f11289a = i;
        this.f11290b = obj;
        this.f11291l = obj2;
        this.f11292m = obj3;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Long l10;
        Long l11;
        int i = this.f11289a;
        Object obj = this.f11290b;
        Object obj2 = this.f11291l;
        switch (i) {
            case 0:
                view.getClass();
                float f = UptodownApp.I;
                if (b4.d.t() && (l10 = ((o) obj).f11302c) != null) {
                    ((w4.f) obj2).b(l10.longValue());
                    break;
                }
                break;
            case 1:
                o oVar = (o) obj;
                view.getClass();
                float f10 = UptodownApp.I;
                if (b4.d.t() && (l11 = oVar.f11302c) != null) {
                    j jVar = new j((int) l11.longValue(), oVar.f11303d, 4);
                    jVar.f11227m = true;
                    ((w4.f) obj2).c(jVar);
                    break;
                }
                break;
            default:
                f2 f2Var = (f2) this.f11292m;
                c4.k0 k0Var = (c4.k0) obj2;
                view.getClass();
                Long l12 = (Long) obj;
                if (l12 != null && l12.longValue() > 0) {
                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(k0Var);
                    v7.e eVar = o7.m0.f8288a;
                    o7.c0.s(lifecycleScope, t7.n.f10348a, null, new c4.y(k0Var, l12, f2Var, null, 1), 2);
                    break;
                } else {
                    k0Var.l0(f2Var.f11151a);
                    break;
                }
                break;
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        int i = this.f11289a;
        Object obj = this.f11292m;
        textPaint.getClass();
        switch (i) {
            case 0:
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor((Context) obj, 2131100500));
                textPaint.setTypeface(f4.c.f4882w);
                break;
            case 1:
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor((Context) obj, 2131100500));
                textPaint.setTypeface(f4.c.f4882w);
                break;
            default:
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor((c4.k0) this.f11291l, 2131100500));
                textPaint.setTypeface(f4.c.f4882w);
                textPaint.setUnderlineText(false);
                break;
        }
    }
}
