package c4;

import com.uptodown.activities.FeedActivity;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p0 implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedActivity f1975a;

    public p0(FeedActivity feedActivity) {
        this.f1975a = feedActivity;
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        j5.s sVar = (j5.s) obj;
        boolean z9 = sVar instanceof j5.p;
        FeedActivity feedActivity = this.f1975a;
        if (z9) {
            int i = FeedActivity.S;
            feedActivity.z0().g = true;
            if (feedActivity.Q == null) {
                feedActivity.y0().f9897b.setVisibility(0);
            }
        } else {
            if (sVar instanceof j5.r) {
                int i6 = FeedActivity.S;
                feedActivity.z0().g = false;
                if (feedActivity.Q == null) {
                    feedActivity.Q = new e4.c((ArrayList) ((j5.r) sVar).f6707a, feedActivity.R);
                    feedActivity.y0().f9898l.setAdapter(feedActivity.Q);
                } else {
                    Iterator it = ((ArrayList) ((j5.r) sVar).f6707a).iterator();
                    it.getClass();
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        e4.c cVar2 = feedActivity.Q;
                        cVar2.getClass();
                        cVar2.f4496a.add((x4.d1) next);
                        cVar2.notifyItemInserted(cVar2.getItemCount());
                    }
                }
                e4.c cVar3 = feedActivity.Q;
                if (cVar3 != null) {
                    cVar3.a(false);
                }
                e4.c cVar4 = feedActivity.Q;
                ArrayList arrayList = cVar4 != null ? cVar4.f4496a : null;
                if (arrayList == null || arrayList.isEmpty()) {
                    feedActivity.y0().f9900n.setVisibility(0);
                } else {
                    feedActivity.y0().f9900n.setVisibility(8);
                }
                feedActivity.y0().f9897b.setVisibility(8);
            } else if (!(sVar instanceof j5.q)) {
                com.google.gson.internal.a.b();
                return null;
            }
        }
        return p6.x.f8463a;
    }
}
