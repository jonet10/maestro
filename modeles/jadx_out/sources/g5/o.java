package g5;

import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ListRow;
import java.util.ArrayList;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o implements w4.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f5344a;

    public o(q qVar) {
        this.f5344a = qVar;
    }

    @Override // w4.i
    public final void a(x4.g gVar) {
        gVar.getClass();
    }

    @Override // w4.i
    public final void b(p2 p2Var) {
        q qVar = this.f5344a;
        qVar.f5351l.add(p2Var);
        q.a(qVar);
    }

    @Override // w4.i
    public final void d(ArrayList arrayList) {
        arrayList.getClass();
        boolean isEmpty = arrayList.isEmpty();
        q qVar = this.f5344a;
        if (!isEmpty) {
            x4.g gVar = (x4.g) q6.l.q0(arrayList);
            qVar.f5349a = gVar;
            gVar.getClass();
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new e5.q());
            arrayObjectAdapter.add(gVar);
            qVar.f5353n.add(new ListRow(arrayObjectAdapter));
        }
        qVar.getMainFragmentAdapter().getFragmentHost().notifyDataReady(qVar.getMainFragmentAdapter());
    }

    @Override // w4.i
    public final void e(ArrayList arrayList) {
        arrayList.getClass();
        q qVar = this.f5344a;
        qVar.f5352m.addAll(arrayList);
        q.a(qVar);
    }

    @Override // w4.i
    public final void f(p2 p2Var) {
        this.f5344a.f5352m.add(p2Var);
    }

    @Override // w4.i
    public final void h(p2 p2Var) {
        q qVar = this.f5344a;
        qVar.f5351l.add(p2Var);
        q.a(qVar);
    }

    @Override // w4.i
    public final void i(p2 p2Var) {
        this.f5344a.f5351l.add(p2Var);
    }

    @Override // w4.i
    public final void j(ArrayList arrayList) {
        arrayList.getClass();
        q qVar = this.f5344a;
        qVar.f5351l.addAll(arrayList);
        q.a(qVar);
    }

    @Override // w4.i
    public final void k(ArrayList arrayList) {
        arrayList.getClass();
        q qVar = this.f5344a;
        qVar.f5350b = arrayList;
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new e5.h());
        arrayObjectAdapter.addAll(0, arrayList);
        qVar.f5353n.add(new ListRow(arrayObjectAdapter));
    }

    @Override // w4.i
    public final void l(x4.g gVar) {
        gVar.getClass();
    }

    @Override // w4.i
    public final void g() {
    }
}
