package c4;

import android.widget.TextView;
import com.uptodown.activities.UserCommentsActivity;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class wb implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserCommentsActivity f2278a;

    public wb(UserCommentsActivity userCommentsActivity) {
        this.f2278a = userCommentsActivity;
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        j5.s sVar = (j5.s) obj;
        boolean z9 = sVar instanceof j5.p;
        UserCommentsActivity userCommentsActivity = this.f2278a;
        if (z9) {
            int i = UserCommentsActivity.S;
            userCommentsActivity.y0().f9646b.setVisibility(0);
        } else {
            if (sVar instanceof j5.r) {
                ac acVar = (ac) ((j5.r) sVar).f6707a;
                x4.w2 w2Var = acVar.f1395a;
                ArrayList arrayList = acVar.f1396b;
                x4.w2 w2Var2 = acVar.f1395a;
                if (w2Var == null || !acVar.f1397c) {
                    int i6 = UserCommentsActivity.S;
                    userCommentsActivity.y0().f9649n.setTypeface(f4.c.f4883x);
                    userCommentsActivity.y0().f9649n.setVisibility(0);
                } else {
                    x4.w2 h = x4.u2.h(userCommentsActivity);
                    if (kotlin.jvm.internal.l.a(h != null ? h.f11431a : null, w2Var2.f11431a)) {
                        int i10 = UserCommentsActivity.S;
                        userCommentsActivity.y0().f9650o.setText(userCommentsActivity.getString(2131952503));
                    } else {
                        int i11 = UserCommentsActivity.S;
                        TextView textView = userCommentsActivity.y0().f9650o;
                        String string = userCommentsActivity.getString(2131952747);
                        string.getClass();
                        textView.setText(String.format(string, Arrays.copyOf(new Object[]{w2Var2.f11434m}, 1)));
                    }
                    if (!arrayList.isEmpty()) {
                        e4.b1 b1Var = userCommentsActivity.Q;
                        if (b1Var == null) {
                            userCommentsActivity.Q = new e4.b1(arrayList, userCommentsActivity.R);
                            userCommentsActivity.y0().f9647l.setAdapter(userCommentsActivity.Q);
                        } else {
                            b1Var.f4493a.addAll(arrayList);
                            b1Var.notifyDataSetChanged();
                        }
                    }
                    e4.b1 b1Var2 = userCommentsActivity.Q;
                    if (b1Var2 != null) {
                        b1Var2.f4495c = false;
                        b1Var2.notifyItemRemoved(b1Var2.getItemCount());
                    }
                }
                userCommentsActivity.y0().f9646b.setVisibility(8);
            } else if (!(sVar instanceof j5.q)) {
                com.google.gson.internal.a.b();
                return null;
            }
        }
        return p6.x.f8463a;
    }
}
