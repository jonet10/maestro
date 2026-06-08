package c4;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class v4 implements DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2199a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2200b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Context f2201l;

    public /* synthetic */ v4(Object obj, Context context, int i) {
        this.f2199a = i;
        this.f2200b = obj;
        this.f2201l = context;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        int i = this.f2199a;
        Context context = this.f2201l;
        Object obj = this.f2200b;
        switch (i) {
            case 0:
                w4 w4Var = (w4) context;
                if (!((kotlin.jvm.internal.u) obj).f7021a) {
                    w4Var.H0();
                    break;
                }
                break;
            default:
                u4.f0 f0Var = (u4.f0) obj;
                int intValue = ((Number) f0Var.G().S.getValue()).intValue();
                x4.w2 h = x4.u2.h(context);
                if ((h != null ? h.f11431a : null) != null) {
                    String str = h.f11431a;
                    str.getClass();
                    if (str.length() > 0) {
                        r7.o0 o0Var = f0Var.G().S;
                        Integer valueOf = Integer.valueOf(intValue);
                        o0Var.getClass();
                        o0Var.g(null, valueOf);
                        t4.b bVar = f0Var.f10473b;
                        if (intValue == 1) {
                            bVar.getClass();
                            ((ImageView) bVar.H.f8817l).setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                            t4.b bVar2 = f0Var.f10473b;
                            bVar2.getClass();
                            ((ImageView) bVar2.H.f8818m).setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
                            t4.b bVar3 = f0Var.f10473b;
                            bVar3.getClass();
                            ((ImageView) bVar3.H.f8819n).setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
                            t4.b bVar4 = f0Var.f10473b;
                            bVar4.getClass();
                            ((ImageView) bVar4.H.f8820o).setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
                            t4.b bVar5 = f0Var.f10473b;
                            bVar5.getClass();
                            ((ImageView) bVar5.H.f8821p).setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
                            break;
                        } else if (intValue == 2) {
                            bVar.getClass();
                            ((ImageView) bVar.H.f8817l).setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                            t4.b bVar6 = f0Var.f10473b;
                            bVar6.getClass();
                            ((ImageView) bVar6.H.f8818m).setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                            t4.b bVar7 = f0Var.f10473b;
                            bVar7.getClass();
                            ((ImageView) bVar7.H.f8819n).setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
                            t4.b bVar8 = f0Var.f10473b;
                            bVar8.getClass();
                            ((ImageView) bVar8.H.f8820o).setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
                            t4.b bVar9 = f0Var.f10473b;
                            bVar9.getClass();
                            ((ImageView) bVar9.H.f8821p).setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
                            break;
                        } else if (intValue == 3) {
                            bVar.getClass();
                            ((ImageView) bVar.H.f8817l).setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                            t4.b bVar10 = f0Var.f10473b;
                            bVar10.getClass();
                            ((ImageView) bVar10.H.f8818m).setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                            t4.b bVar11 = f0Var.f10473b;
                            bVar11.getClass();
                            ((ImageView) bVar11.H.f8819n).setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                            t4.b bVar12 = f0Var.f10473b;
                            bVar12.getClass();
                            ((ImageView) bVar12.H.f8820o).setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
                            t4.b bVar13 = f0Var.f10473b;
                            bVar13.getClass();
                            ((ImageView) bVar13.H.f8821p).setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
                            break;
                        } else if (intValue == 4) {
                            bVar.getClass();
                            ((ImageView) bVar.H.f8817l).setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                            t4.b bVar14 = f0Var.f10473b;
                            bVar14.getClass();
                            ((ImageView) bVar14.H.f8818m).setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                            t4.b bVar15 = f0Var.f10473b;
                            bVar15.getClass();
                            ((ImageView) bVar15.H.f8819n).setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                            t4.b bVar16 = f0Var.f10473b;
                            bVar16.getClass();
                            ((ImageView) bVar16.H.f8820o).setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                            t4.b bVar17 = f0Var.f10473b;
                            bVar17.getClass();
                            ((ImageView) bVar17.H.f8821p).setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
                            break;
                        } else if (intValue == 5) {
                            bVar.getClass();
                            ((ImageView) bVar.H.f8817l).setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                            t4.b bVar18 = f0Var.f10473b;
                            bVar18.getClass();
                            ((ImageView) bVar18.H.f8818m).setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                            t4.b bVar19 = f0Var.f10473b;
                            bVar19.getClass();
                            ((ImageView) bVar19.H.f8819n).setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                            t4.b bVar20 = f0Var.f10473b;
                            bVar20.getClass();
                            ((ImageView) bVar20.H.f8820o).setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                            t4.b bVar21 = f0Var.f10473b;
                            bVar21.getClass();
                            ((ImageView) bVar21.H.f8821p).setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                            break;
                        } else {
                            bVar.getClass();
                            ((ImageView) bVar.H.f8817l).setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
                            t4.b bVar22 = f0Var.f10473b;
                            bVar22.getClass();
                            ((ImageView) bVar22.H.f8818m).setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
                            t4.b bVar23 = f0Var.f10473b;
                            bVar23.getClass();
                            ((ImageView) bVar23.H.f8819n).setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
                            t4.b bVar24 = f0Var.f10473b;
                            bVar24.getClass();
                            ((ImageView) bVar24.H.f8820o).setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
                            t4.b bVar25 = f0Var.f10473b;
                            bVar25.getClass();
                            ((ImageView) bVar25.H.f8821p).setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
                            break;
                        }
                    }
                }
                break;
        }
    }
}
