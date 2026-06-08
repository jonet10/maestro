package c4;

import android.widget.TextView;
import com.uptodown.activities.SecurityActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ga extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1645a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SecurityActivity f1646b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ga(SecurityActivity securityActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f1645a = i;
        this.f1646b = securityActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1645a) {
            case 0:
                return new ga(this.f1646b, cVar, 0);
            default:
                return new ga(this.f1646b, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1645a) {
            case 0:
                ga gaVar = (ga) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                gaVar.invokeSuspend(xVar);
                return xVar;
            default:
                ga gaVar2 = (ga) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                gaVar2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f1645a;
        p6.x xVar = p6.x.f8463a;
        SecurityActivity securityActivity = this.f1646b;
        switch (i) {
            case 0:
                p6.a.e(obj);
                int i6 = SecurityActivity.f3349g0;
                securityActivity.N0().f10211b.setVisibility(8);
                TextView textView = securityActivity.N0().f10216p;
                long t9 = com.google.android.gms.internal.measurement.z3.t(0L, securityActivity, "last_analysis_timestamp");
                textView.setText(securityActivity.getString(2131952721, String.valueOf(t9 <= 0 ? null : new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault()).format(new Date(t9)))));
                break;
            default:
                p6.a.e(obj);
                if (securityActivity.N0().f10211b.getVisibility() == 8) {
                    securityActivity.O0();
                    securityActivity.P0();
                    break;
                }
                break;
        }
        return xVar;
    }
}
