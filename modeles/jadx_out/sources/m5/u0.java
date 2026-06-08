package m5;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import c4.ra;
import com.uptodown.UptodownApp;
import com.uptodown.activities.GdprPrivacySettings;
import com.uptodown.activities.Updates;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class u0 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7602a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7603b;

    public /* synthetic */ u0(Object obj, int i) {
        this.f7602a = i;
        this.f7603b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int bindingAdapterPosition;
        int bindingAdapterPosition2;
        int i = this.f7602a;
        Object obj = this.f7603b;
        switch (i) {
            case 0:
                v0 v0Var = (v0) obj;
                w4.b bVar = v0Var.f7614a;
                if (bVar != null && (bindingAdapterPosition = v0Var.getBindingAdapterPosition()) != -1) {
                    bVar.b(bindingAdapterPosition);
                    break;
                }
                break;
            case 1:
                k1 k1Var = (k1) obj;
                w4.b bVar2 = k1Var.f7444a;
                if (bVar2 != null && (bindingAdapterPosition2 = k1Var.getBindingAdapterPosition()) != -1) {
                    bVar2.b(bindingAdapterPosition2);
                    break;
                }
                break;
            case 2:
                Updates updates = ((l1) obj).f7464a.f2056a;
                float f = UptodownApp.I;
                if (b4.d.t() && b4.d.F(updates)) {
                    int i6 = Updates.n0;
                    r7.o0 o0Var = updates.U0().f1568c;
                    Boolean bool = Boolean.TRUE;
                    o0Var.getClass();
                    o0Var.g(null, bool);
                    break;
                }
                break;
            case 3:
                ((q1) obj).f7538a.getClass();
                break;
            case 4:
                s1 s1Var = (s1) obj;
                TextView textView = s1Var.f7567o;
                Context context = s1Var.f7563b;
                TextView textView2 = s1Var.f7568p;
                int maxLines = textView.getMaxLines();
                TextView textView3 = s1Var.f7567o;
                if (maxLines != Integer.MAX_VALUE) {
                    textView3.setMaxLines(Integer.MAX_VALUE);
                    textView2.setText(context.getString(2131952510));
                    break;
                } else {
                    textView3.setMaxLines(4);
                    textView2.setText(context.getString(2131952511));
                    break;
                }
            case 5:
                ((CheckBox) ((z1) obj).f7653a.f11756l).performClick();
                break;
            case 6:
                ra raVar = (ra) obj;
                raVar.getClass();
                float f10 = UptodownApp.I;
                if (b4.d.t()) {
                    Updates updates2 = raVar.f2056a;
                    int i10 = Updates.n0;
                    updates2.f3365l0.launch(new Intent(updates2.getApplicationContext(), (Class<?>) GdprPrivacySettings.class), b4.d.b(updates2));
                    break;
                }
                break;
            case 7:
                if (((t4.i) obj).f9863l.getVisibility() == 0) {
                    a5.b.h();
                    break;
                }
                break;
            case 8:
                u4.z0 z0Var = (u4.z0) obj;
                float f11 = UptodownApp.I;
                if (b4.d.t()) {
                    z0Var.i().setVisibility(8);
                    z0Var.d().setVisibility(0);
                    z0Var.g().setVisibility(8);
                    z0Var.f10675p = false;
                    z0Var.c();
                    break;
                }
                break;
            case 9:
                u4.m1 m1Var = (u4.m1) obj;
                float f12 = UptodownApp.I;
                if (b4.d.t()) {
                    m1Var.b().f10039l.setVisibility(0);
                    m1Var.b().f10038b.setVisibility(8);
                    m1Var.c();
                    break;
                }
                break;
            case 10:
                ((v5.d) obj).dismiss();
                break;
            default:
                ((z5.c) obj).dismiss();
                break;
        }
    }
}
