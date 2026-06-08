package c4;

import com.uptodown.activities.FollowListActivity;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v0 implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FollowListActivity f2190a;

    public v0(FollowListActivity followListActivity) {
        this.f2190a = followListActivity;
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        j5.s sVar = (j5.s) obj;
        boolean z9 = sVar instanceof j5.p;
        FollowListActivity followListActivity = this.f2190a;
        if (z9) {
            int i = FollowListActivity.S;
            followListActivity.z0().h = true;
            if (followListActivity.Q == null) {
                followListActivity.y0().f9956b.setVisibility(0);
            }
        } else {
            if (sVar instanceof j5.r) {
                int i6 = FollowListActivity.S;
                followListActivity.z0().h = false;
                if (followListActivity.Q == null) {
                    followListActivity.Q = new e4.d((ArrayList) ((j5.r) sVar).f6707a, followListActivity.R);
                    followListActivity.y0().f9957l.setAdapter(followListActivity.Q);
                } else {
                    Iterator it = ((ArrayList) ((j5.r) sVar).f6707a).iterator();
                    it.getClass();
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        e4.d dVar = followListActivity.Q;
                        dVar.getClass();
                        dVar.f4505a.add((x4.w2) next);
                        dVar.notifyItemInserted(dVar.getItemCount());
                    }
                }
                e4.d dVar2 = followListActivity.Q;
                if (dVar2 != null) {
                    dVar2.f4507c = false;
                    dVar2.notifyItemRemoved(dVar2.getItemCount());
                }
                e4.d dVar3 = followListActivity.Q;
                ArrayList arrayList = dVar3 != null ? dVar3.f4505a : null;
                if (arrayList == null || arrayList.isEmpty()) {
                    followListActivity.y0().f9959n.setVisibility(0);
                } else {
                    followListActivity.y0().f9959n.setVisibility(8);
                }
                followListActivity.y0().f9956b.setVisibility(8);
            } else if (!(sVar instanceof j5.q)) {
                com.google.gson.internal.a.b();
                return null;
            }
        }
        return p6.x.f8463a;
    }
}
