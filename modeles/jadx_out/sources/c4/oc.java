package c4;

import android.widget.TextView;
import com.uptodown.activities.UserDevicesActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class oc implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserDevicesActivity f1966a;

    public oc(UserDevicesActivity userDevicesActivity) {
        this.f1966a = userDevicesActivity;
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        j5.s sVar = (j5.s) obj;
        boolean a8 = kotlin.jvm.internal.l.a(sVar, j5.p.f6705a);
        UserDevicesActivity userDevicesActivity = this.f1966a;
        if (a8) {
            userDevicesActivity.y0().f9764b.setVisibility(0);
            userDevicesActivity.y0().f9765l.setVisibility(8);
        } else {
            if (sVar instanceof j5.r) {
                rc rcVar = (rc) ((j5.r) sVar).f6707a;
                x4.z2 z2Var = rcVar.f2058a;
                ArrayList arrayList = rcVar.f2059b;
                int i = UserDevicesActivity.R;
                userDevicesActivity.y0().f9771r.f9676o.setTypeface(f4.c.f4882w);
                userDevicesActivity.y0().f9771r.f9675n.setTypeface(f4.c.f4883x);
                userDevicesActivity.y0().f9771r.f9676o.setText(z2Var.f11483l);
                TextView textView = userDevicesActivity.y0().f9771r.f9675n;
                long j = z2Var.f11488q;
                textView.setText(j > 0 ? new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date(j)) : null);
                userDevicesActivity.y0().f9771r.f9672b.setOnClickListener(new c.e(19, userDevicesActivity, z2Var));
                if (arrayList.isEmpty()) {
                    userDevicesActivity.y0().f9768o.setVisibility(8);
                } else {
                    userDevicesActivity.y0().f9766m.setAdapter(new e4.d1(arrayList, new android.support.v4.media.g(4, userDevicesActivity, sVar)));
                }
                userDevicesActivity.y0().f9764b.setVisibility(8);
                userDevicesActivity.y0().f9765l.setVisibility(0);
            } else if (!kotlin.jvm.internal.l.a(sVar, j5.q.f6706a)) {
                com.google.gson.internal.a.b();
                return null;
            }
        }
        return p6.x.f8463a;
    }
}
