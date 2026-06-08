package c4;

import com.uptodown.activities.AppFilesActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppFilesActivity f1655a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1656b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(AppFilesActivity appFilesActivity, ArrayList arrayList, t6.c cVar) {
        super(2, cVar);
        this.f1655a = appFilesActivity;
        this.f1656b = arrayList;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new h(this.f1655a, this.f1656b, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        h hVar = (h) create((o7.a0) obj, (t6.c) obj2);
        p6.x xVar = p6.x.f8463a;
        hVar.invokeSuspend(xVar);
        return xVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        p6.a.e(obj);
        int i = AppFilesActivity.S;
        AppFilesActivity appFilesActivity = this.f1655a;
        appFilesActivity.z0().f9680m.setAdapter(new e4.a(this.f1656b, appFilesActivity.R));
        appFilesActivity.z0().f9679l.setVisibility(8);
        return p6.x.f8463a;
    }
}
