package c4;

import com.uptodown.activities.RecommendedActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d8 implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1516a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecommendedActivity f1517b;

    public /* synthetic */ d8(RecommendedActivity recommendedActivity, int i) {
        this.f1516a = i;
        this.f1517b = recommendedActivity;
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        int i = this.f1516a;
        p6.x xVar = p6.x.f8463a;
        RecommendedActivity recommendedActivity = this.f1517b;
        switch (i) {
            case 0:
                j5.s sVar = (j5.s) obj;
                if (sVar instanceof j5.p) {
                    if (recommendedActivity.f3340c0 != null) {
                        return xVar;
                    }
                    recommendedActivity.N0().f10000b.setVisibility(0);
                    return xVar;
                }
                if (!(sVar instanceof j5.r)) {
                    if (!(sVar instanceof j5.q)) {
                        com.google.gson.internal.a.b();
                        return null;
                    }
                    e4.e1 e1Var = recommendedActivity.f3340c0;
                    if (e1Var == null) {
                        return xVar;
                    }
                    e1Var.d(false);
                    return xVar;
                }
                ArrayList arrayList = (ArrayList) ((j5.r) sVar).f6707a;
                if (arrayList.isEmpty() && recommendedActivity.f3340c0 == null) {
                    recommendedActivity.N0().f10006q.setVisibility(0);
                    recommendedActivity.N0().f10004o.setVisibility(0);
                } else {
                    int i6 = RecommendedActivity.f3338g0;
                    recommendedActivity.N0().f10002m.setVisibility(0);
                    recommendedActivity.N0().f10005p.setVisibility(0);
                    e4.e1 e1Var2 = recommendedActivity.f3340c0;
                    if (e1Var2 == null) {
                        recommendedActivity.f3340c0 = new e4.e1(arrayList, recommendedActivity, recommendedActivity.f3341d0);
                        recommendedActivity.N0().f10001l.setAdapter(recommendedActivity.f3340c0);
                    } else {
                        e1Var2.f4519a.addAll(arrayList);
                        e1Var2.notifyDataSetChanged();
                        e4.e1 e1Var3 = recommendedActivity.f3340c0;
                        if (e1Var3 != null) {
                            e1Var3.d(false);
                        }
                    }
                }
                int i10 = RecommendedActivity.f3338g0;
                recommendedActivity.N0().f10000b.setVisibility(8);
                return xVar;
            default:
                boolean booleanValue = ((Boolean) obj).booleanValue();
                int i11 = RecommendedActivity.f3338g0;
                recommendedActivity.N0().f10002m.setChecked(!booleanValue);
                if (booleanValue) {
                    recommendedActivity.N0().f10005p.setText(recommendedActivity.getString(2131952498));
                } else {
                    recommendedActivity.N0().f10005p.setText(recommendedActivity.getString(2131952501));
                }
                return xVar;
        }
    }
}
