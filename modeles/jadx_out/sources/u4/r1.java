package u4;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.uptodown.activities.ListsActivity;
import java.util.ArrayList;
import java.util.Iterator;
import x4.o2;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r1 implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10591a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z1 f10592b;

    public /* synthetic */ r1(z1 z1Var, int i) {
        this.f10591a = i;
        this.f10592b = z1Var;
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        boolean z9;
        int i = this.f10591a;
        p6.x xVar = p6.x.f8463a;
        z1 z1Var = this.f10592b;
        switch (i) {
            case 0:
                x4.i0 i0Var = (x4.i0) obj;
                if (i0Var instanceof x4.f0) {
                    z1Var.g(((x4.f0) i0Var).f11150a.f11355b);
                } else if (i0Var instanceof x4.h0) {
                    z1Var.g(((x4.h0) i0Var).f11209a.f11355b);
                } else if (!kotlin.jvm.internal.l.a(i0Var, x4.g0.f11198a) && !kotlin.jvm.internal.l.a(i0Var, x4.e0.f11137a)) {
                    com.google.gson.internal.a.b();
                    return null;
                }
                return xVar;
            case 1:
                z1Var.g(((x4.d0) obj).b());
                return xVar;
            case 2:
                x4.a1 a1Var = (x4.a1) obj;
                if (a1Var instanceof x4.w0) {
                    x4.r rVar = ((x4.w0) a1Var).f11427a;
                    z1Var.g(rVar != null ? rVar.f11355b : null);
                } else if (!kotlin.jvm.internal.l.a(a1Var, x4.x0.f11447a) && !kotlin.jvm.internal.l.a(a1Var, x4.z0.f11478a) && !kotlin.jvm.internal.l.a(a1Var, x4.v0.f11420a) && !(a1Var instanceof x4.y0)) {
                    com.google.gson.internal.a.b();
                    return null;
                }
                return xVar;
            case 3:
                z1Var.g(((x4.u0) obj).b());
                return xVar;
            case 4:
                j5.s sVar = (j5.s) obj;
                if (!(sVar instanceof j5.p)) {
                    if (sVar instanceof j5.r) {
                        if (((Boolean) ((j5.r) sVar).f6707a).booleanValue()) {
                            z1Var.a().f10229b.setImageDrawable(ContextCompat.getDrawable(z1Var.requireContext(), 2131231333));
                            if ((z1Var.getActivity() instanceof c4.k0) && z1Var.d().g) {
                                FragmentActivity activity = z1Var.getActivity();
                                activity.getClass();
                                String string = z1Var.getString(2131951771, z1Var.f10683m.f11225b);
                                string.getClass();
                                ((c4.k0) activity).A(string);
                            }
                        } else {
                            z1Var.a().f10229b.setImageDrawable(ContextCompat.getDrawable(z1Var.requireContext(), 2131231332));
                            if ((z1Var.getActivity() instanceof c4.k0) && z1Var.d().g) {
                                FragmentActivity activity2 = z1Var.getActivity();
                                activity2.getClass();
                                String string2 = z1Var.getString(2131951772, z1Var.f10683m.f11225b);
                                string2.getClass();
                                ((c4.k0) activity2).A(string2);
                            }
                        }
                        if (z1Var.d().g) {
                            z9 = true;
                        } else {
                            z9 = true;
                            z1Var.d().g = true;
                        }
                        if (z1Var.getActivity() instanceof ListsActivity) {
                            FragmentActivity activity3 = z1Var.getActivity();
                            activity3.getClass();
                            ((ListsActivity) activity3).Q = z9;
                        }
                    } else if (!(sVar instanceof j5.q)) {
                        com.google.gson.internal.a.b();
                        return null;
                    }
                }
                return xVar;
            default:
                j5.s sVar2 = (j5.s) obj;
                if (sVar2 instanceof j5.p) {
                    z1Var.a().f10231m.setVisibility(0);
                } else if (sVar2 instanceof j5.r) {
                    a2 a2Var = (a2) ((j5.r) sVar2).f6707a;
                    boolean z10 = a2Var.f10424b;
                    p2 p2Var = a2Var.f10423a;
                    if (!z10) {
                        e4.q0 q0Var = z1Var.f10685o;
                        if (q0Var != null) {
                            ArrayList arrayList = p2Var.f11330b;
                            int i6 = z1Var.f10683m.f11224a;
                            boolean z11 = (i6 == -3 || i6 == -2) ? false : true;
                            arrayList.getClass();
                            int size = q0Var.f4666l.size();
                            Iterator it = arrayList.iterator();
                            it.getClass();
                            while (it.hasNext()) {
                                Object next = it.next();
                                next.getClass();
                                e4.o0 o0Var = new e4.o0();
                                o0Var.f4648a = (x4.g) next;
                                o0Var.f4649b = 0;
                                if (z11) {
                                    int i10 = q0Var.f4667m + 1;
                                    q0Var.f4667m = i10;
                                    o0Var.f4650c = i10;
                                } else {
                                    o0Var.f4650c = 0;
                                }
                                q0Var.f4666l.add(o0Var);
                            }
                            q0Var.notifyItemRangeInserted(size, q0Var.f4666l.size());
                        }
                    } else if (p2Var.f11330b.isEmpty()) {
                        z1Var.a().f10232n.setVisibility(8);
                        z1Var.a().f10234p.setVisibility(0);
                        z1Var.a().f10235q.setVisibility(0);
                    } else {
                        if (z1Var.getActivity() != null && !z1Var.requireActivity().isFinishing()) {
                            String str = p2Var.f11329a.f11225b;
                            if (str == null || str.length() == 0) {
                                z1Var.f10684n = z1Var.getResources().getString(2131952657);
                            } else {
                                z1Var.f10684n = p2Var.f11329a.f11225b;
                            }
                            z1Var.a().f10236r.setText(z1Var.f10684n);
                            p1 p1Var = z1Var.f10686p;
                            o1 o1Var = z1Var.f10688r;
                            o1 o1Var2 = z1Var.f10689s;
                            p1 p1Var2 = z1Var.f10687q;
                            x4.j jVar = p2Var.f11329a;
                            z1Var.f10685o = new e4.q0(p1Var, o1Var, o1Var2, p1Var2, jVar.f11226l, p2Var.f11332d, p2Var.f11333e, jVar.f11225b, false, new o1(z1Var), new p1(z1Var));
                            boolean z12 = p2Var.f11332d != null;
                            z1Var.a().f10232n.addItemDecoration(new l5.k());
                            e4.q0 q0Var2 = z1Var.f10685o;
                            if (q0Var2 != null) {
                                q0Var2.a(p2Var);
                            }
                            z1Var.a().f10232n.setAdapter(z1Var.f10685o);
                            if (z12) {
                                o2 o2Var = p2Var.f11332d;
                                o2Var.getClass();
                                if (o2Var.g != null) {
                                    z1Var.a().f10230l.setVisibility(0);
                                    z1Var.a().f10230l.setOnClickListener(new f(11, p2Var, z1Var));
                                }
                            }
                        }
                        z1Var.a().f10232n.setVisibility(0);
                        z1Var.a().f10234p.setVisibility(8);
                        z1Var.a().f10235q.setVisibility(8);
                    }
                    z1Var.d().f10462e = false;
                    z1Var.a().f10231m.setVisibility(8);
                } else if (!(sVar2 instanceof j5.q)) {
                    com.google.gson.internal.a.b();
                    return null;
                }
                return xVar;
        }
    }
}
