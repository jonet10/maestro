package c4;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.PublicProfileActivity;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p7 implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f1987a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f1988b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ x4.w2 f1989l;

    public p7(PublicProfileActivity publicProfileActivity, kotlin.jvm.internal.x xVar, x4.w2 w2Var) {
        this.f1987a = publicProfileActivity;
        this.f1988b = xVar;
        this.f1989l = w2Var;
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        j5.s sVar = (j5.s) obj;
        if (!(sVar instanceof j5.p)) {
            if (sVar instanceof j5.r) {
                Object obj2 = ((j5.r) sVar).f6707a;
                boolean isEmpty = ((Collection) obj2).isEmpty();
                PublicProfileActivity publicProfileActivity = this.f1987a;
                if (isEmpty) {
                    x4.w2 w2Var = (x4.w2) this.f1988b.f7024a;
                    String str = w2Var != null ? w2Var.f11431a : null;
                    x4.w2 w2Var2 = this.f1989l;
                    if (kotlin.jvm.internal.l.a(str, w2Var2 != null ? w2Var2.f11431a : null)) {
                        int i = PublicProfileActivity.R;
                        ((LinearLayout) publicProfileActivity.y0().H.f4466b).setVisibility(0);
                        ((RecyclerView) publicProfileActivity.y0().H.f4469n).setVisibility(8);
                        ((RelativeLayout) publicProfileActivity.y0().H.f4467l).setVisibility(0);
                        ((TextView) publicProfileActivity.y0().H.f4470o).setOnClickListener(new j7(publicProfileActivity, 5));
                    }
                } else {
                    int i6 = PublicProfileActivity.R;
                    ((RecyclerView) publicProfileActivity.y0().H.f4469n).setAdapter(new e4.g0((ArrayList) obj2, new m7(publicProfileActivity, sVar, 1)));
                    ((LinearLayout) publicProfileActivity.y0().H.f4466b).setVisibility(0);
                    ((RecyclerView) publicProfileActivity.y0().H.f4469n).setVisibility(0);
                    ((RelativeLayout) publicProfileActivity.y0().H.f4467l).setVisibility(8);
                    ((RelativeLayout) publicProfileActivity.y0().H.f4468m).setOnClickListener(new j7(publicProfileActivity, 4));
                }
                int i10 = PublicProfileActivity.R;
                publicProfileActivity.y0().f9968q.setVisibility(8);
            } else if (!(sVar instanceof j5.q)) {
                com.google.gson.internal.a.b();
                return null;
            }
        }
        return p6.x.f8463a;
    }
}
