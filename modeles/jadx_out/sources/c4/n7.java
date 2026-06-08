package c4;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.PublicProfileActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n7 implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f1908a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f1909b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ x4.w2 f1910l;

    public n7(PublicProfileActivity publicProfileActivity, kotlin.jvm.internal.x xVar, x4.w2 w2Var) {
        this.f1908a = publicProfileActivity;
        this.f1909b = xVar;
        this.f1910l = w2Var;
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        j5.s sVar = (j5.s) obj;
        boolean z9 = sVar instanceof j5.p;
        int i = 0;
        PublicProfileActivity publicProfileActivity = this.f1908a;
        if (z9) {
            int i6 = PublicProfileActivity.R;
            publicProfileActivity.y0().f9968q.setVisibility(0);
        } else {
            if (sVar instanceof j5.r) {
                u7 u7Var = (u7) ((j5.r) sVar).f6707a;
                ArrayList arrayList = u7Var.f2168a;
                ArrayList arrayList2 = u7Var.f2169b;
                boolean isEmpty = arrayList.isEmpty();
                x4.w2 w2Var = this.f1910l;
                kotlin.jvm.internal.x xVar = this.f1909b;
                if (isEmpty) {
                    x4.w2 w2Var2 = (x4.w2) xVar.f7024a;
                    if (kotlin.jvm.internal.l.a(w2Var2 != null ? w2Var2.f11431a : null, w2Var != null ? w2Var.f11431a : null)) {
                        int i10 = PublicProfileActivity.R;
                        ((RecyclerView) publicProfileActivity.y0().f9969r.f4469n).setVisibility(8);
                        ((RelativeLayout) publicProfileActivity.y0().f9969r.f4467l).setVisibility(0);
                        ((TextView) publicProfileActivity.y0().f9969r.f4470o).setOnClickListener(new j7(publicProfileActivity, 2));
                    }
                } else {
                    int i11 = PublicProfileActivity.R;
                    ((RecyclerView) publicProfileActivity.y0().f9969r.f4469n).setAdapter(new e4.g0(u7Var.f2168a, new m7(publicProfileActivity, sVar, i)));
                    ((LinearLayout) publicProfileActivity.y0().f9969r.f4466b).setVisibility(0);
                    ((RelativeLayout) publicProfileActivity.y0().f9969r.f4468m).setOnClickListener(new t(publicProfileActivity, xVar, w2Var, 6));
                }
                if (arrayList2.isEmpty()) {
                    x4.w2 w2Var3 = (x4.w2) xVar.f7024a;
                    if (kotlin.jvm.internal.l.a(w2Var3 != null ? w2Var3.f11431a : null, w2Var != null ? w2Var.f11431a : null)) {
                        int i12 = PublicProfileActivity.R;
                        ((LinearLayout) publicProfileActivity.y0().f9970s.f4466b).setVisibility(0);
                        ((RecyclerView) publicProfileActivity.y0().f9970s.f4469n).setVisibility(8);
                        ((RelativeLayout) publicProfileActivity.y0().f9970s.f4467l).setVisibility(0);
                        ((TextView) publicProfileActivity.y0().f9970s.f4470o).setOnClickListener(new j7(publicProfileActivity, 3));
                    }
                } else {
                    int i13 = PublicProfileActivity.R;
                    RecyclerView recyclerView = (RecyclerView) publicProfileActivity.y0().f9970s.f4469n;
                    b5.m mVar = new b5.m(publicProfileActivity, sVar, xVar, 4);
                    arrayList2.getClass();
                    e4.j1 j1Var = new e4.j1();
                    j1Var.f4573a = arrayList2;
                    j1Var.f4574b = mVar;
                    j1Var.f4575c = arrayList2.size() - 1;
                    recyclerView.setAdapter(j1Var);
                    ((LinearLayout) publicProfileActivity.y0().f9970s.f4466b).setVisibility(0);
                    ((RelativeLayout) publicProfileActivity.y0().f9970s.f4468m).setOnClickListener(new c.e(16, publicProfileActivity, xVar));
                }
                int i14 = PublicProfileActivity.R;
                publicProfileActivity.y0().f9968q.setVisibility(8);
            } else if (!(sVar instanceof j5.q)) {
                com.google.gson.internal.a.b();
                return null;
            }
        }
        return p6.x.f8463a;
    }
}
