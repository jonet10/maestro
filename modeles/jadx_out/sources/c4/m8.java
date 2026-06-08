package c4;

import android.content.Context;
import com.uptodown.activities.RepliesActivity;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m8 implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RepliesActivity f1872a;

    public m8(RepliesActivity repliesActivity) {
        this.f1872a = repliesActivity;
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        j5.s sVar = (j5.s) obj;
        boolean z9 = sVar instanceof j5.p;
        RepliesActivity repliesActivity = this.f1872a;
        if (z9) {
            if (repliesActivity.Q == null) {
                repliesActivity.y0().f10027p.setVisibility(0);
            }
        } else if (sVar instanceof j5.r) {
            r8 r8Var = (r8) ((j5.r) sVar).f6707a;
            boolean z10 = r8Var.f2054b;
            ArrayList arrayList = r8Var.f2053a;
            if (z10) {
                e4.h0 h0Var = repliesActivity.Q;
                if (h0Var != null) {
                    ArrayList arrayList2 = h0Var.f4549a;
                    arrayList.getClass();
                    Iterator it = arrayList.iterator();
                    it.getClass();
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        arrayList2.add((x4.d2) next);
                        h0Var.notifyItemInserted(arrayList2.size() - 1);
                    }
                }
            } else if (arrayList.isEmpty()) {
                repliesActivity.y0().f10036z.setVisibility(0);
                repliesActivity.y0().v.setVisibility(8);
            } else {
                Context applicationContext = repliesActivity.getApplicationContext();
                applicationContext.getClass();
                repliesActivity.Q = new e4.h0(arrayList, applicationContext, repliesActivity.R);
                repliesActivity.y0().v.setAdapter(repliesActivity.Q);
            }
            repliesActivity.y0().f10029r.setVisibility(0);
            repliesActivity.y0().f10027p.setVisibility(8);
            e4.h0 h0Var2 = repliesActivity.Q;
            if (h0Var2 != null) {
                h0Var2.a(false);
            }
        } else {
            if (!(sVar instanceof j5.q)) {
                com.google.gson.internal.a.b();
                return null;
            }
            e4.h0 h0Var3 = repliesActivity.Q;
            if (h0Var3 != null) {
                h0Var3.a(false);
            }
        }
        return p6.x.f8463a;
    }
}
