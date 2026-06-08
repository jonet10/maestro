package b5;

import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ListRow;
import d7.p;
import e5.q;
import g5.n;
import java.util.ArrayList;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends v6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1013a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f1014b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1015l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(m mVar, ArrayList arrayList, t6.c cVar, int i) {
        super(2, cVar);
        this.f1013a = i;
        this.f1014b = mVar;
        this.f1015l = arrayList;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1013a) {
            case 0:
                return new e(this.f1014b, this.f1015l, cVar, 0);
            default:
                return new e(this.f1014b, this.f1015l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1013a) {
            case 0:
                e eVar = (e) create(a0Var, cVar);
                x xVar = x.f8463a;
                eVar.invokeSuspend(xVar);
                return xVar;
            default:
                e eVar2 = (e) create(a0Var, cVar);
                x xVar2 = x.f8463a;
                eVar2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1013a) {
            case 0:
                p6.a.e(obj);
                n nVar = ((g5.l) this.f1014b.f1062l).f5329a;
                ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new e5.h());
                arrayObjectAdapter.addAll(0, this.f1015l);
                nVar.f5338b.add(new ListRow(arrayObjectAdapter));
                nVar.getMainFragmentAdapter().getFragmentHost().notifyDataReady(nVar.getMainFragmentAdapter());
                break;
            default:
                p6.a.e(obj);
                n nVar2 = ((g5.l) this.f1014b.f1062l).f5329a;
                ArrayList arrayList = this.f1015l;
                if (!arrayList.isEmpty()) {
                    Object obj2 = arrayList.get(0);
                    obj2.getClass();
                    ArrayObjectAdapter arrayObjectAdapter2 = new ArrayObjectAdapter(new q());
                    arrayObjectAdapter2.add((x4.g) obj2);
                    nVar2.f5338b.add(new ListRow(arrayObjectAdapter2));
                    nVar2.getMainFragmentAdapter().getFragmentHost().notifyDataReady(nVar2.getMainFragmentAdapter());
                }
                break;
        }
        return x.f8463a;
    }
}
