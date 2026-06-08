package c4;

import android.view.View;
import com.uptodown.activities.UserDeviceDetailsActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class dc implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1533a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserDeviceDetailsActivity f1534b;

    public /* synthetic */ dc(UserDeviceDetailsActivity userDeviceDetailsActivity, int i) {
        this.f1533a = i;
        this.f1534b = userDeviceDetailsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int i = this.f1533a;
        UserDeviceDetailsActivity userDeviceDetailsActivity = this.f1534b;
        switch (i) {
            case 0:
                int i6 = UserDeviceDetailsActivity.T;
                userDeviceDetailsActivity.getOnBackPressedDispatcher().onBackPressed();
                break;
            case 1:
                int i10 = UserDeviceDetailsActivity.T;
                userDeviceDetailsActivity.getOnBackPressedDispatcher().onBackPressed();
                break;
            case 2:
                int i11 = UserDeviceDetailsActivity.T;
                boolean booleanValue = ((Boolean) userDeviceDetailsActivity.z0().h.getValue()).booleanValue();
                e4.c1 c1Var = userDeviceDetailsActivity.Q;
                if (booleanValue) {
                    if (c1Var != null && (arrayList2 = c1Var.f4503a) != null && arrayList2.size() > 1) {
                        q6.q.j0(arrayList2, new n5(9));
                    }
                    e4.c1 c1Var2 = userDeviceDetailsActivity.Q;
                    if (c1Var2 != null) {
                        c1Var2.notifyDataSetChanged();
                    }
                    userDeviceDetailsActivity.y0().f9704l.animate().rotation(180.0f).setDuration(200L).start();
                } else {
                    if (c1Var != null && (arrayList = c1Var.f4503a) != null && arrayList.size() > 1) {
                        q6.q.j0(arrayList, new n5(10));
                    }
                    e4.c1 c1Var3 = userDeviceDetailsActivity.Q;
                    if (c1Var3 != null) {
                        c1Var3.notifyDataSetChanged();
                    }
                    userDeviceDetailsActivity.y0().f9704l.animate().rotation(0.0f).setDuration(200L).start();
                }
                r7.o0 o0Var = userDeviceDetailsActivity.z0().h;
                Boolean valueOf = Boolean.valueOf(!((Boolean) userDeviceDetailsActivity.z0().h.getValue()).booleanValue());
                o0Var.getClass();
                o0Var.g(null, valueOf);
                userDeviceDetailsActivity.y0().f9711s.setAdapter(userDeviceDetailsActivity.Q);
                break;
            default:
                int i12 = UserDeviceDetailsActivity.T;
                userDeviceDetailsActivity.Q();
                break;
        }
    }
}
