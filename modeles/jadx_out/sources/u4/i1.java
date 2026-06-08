package u4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import c4.c3;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.activities.MainActivity;
import java.util.ArrayList;
import java.util.Iterator;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i1 implements w4.i, w4.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m1 f10506a;

    public /* synthetic */ i1(m1 m1Var) {
        this.f10506a = m1Var;
    }

    @Override // w4.i
    public void a(x4.g gVar) {
        gVar.getClass();
        e4.h hVar = this.f10506a.f10538b;
        if (hVar != null) {
            Iterator it = hVar.f4544e.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i6 = i + 1;
                e4.g gVar2 = (e4.g) it.next();
                if (gVar2 != null && gVar2.f4533b == 0) {
                    ArrayList arrayList = ((e4.f) gVar2.a()).f4524a;
                    if (arrayList == null) {
                        kotlin.jvm.internal.l.i("homeFeatures");
                        throw null;
                    }
                    arrayList.add(gVar);
                    hVar.notifyItemChanged(i);
                    return;
                }
                i = i6;
            }
        }
    }

    @Override // w4.i
    public void b(p2 p2Var) {
        e4.h hVar = this.f10506a.f10538b;
        if (hVar != null) {
            hVar.c(p2Var, hVar.f);
        }
    }

    @Override // w4.l
    public void c(x4.g gVar) {
        m1 m1Var = this.f10506a;
        if (m1Var.getActivity() instanceof MainActivity) {
            long j = gVar.f11158a;
            int i = gVar.f11191w0;
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(m1Var);
            v7.e eVar = o7.m0.f8288a;
            o7.c0.s(lifecycleScope, v7.d.f10884a, null, new c4.j0(m1Var, j, "impress", i, null, 10), 2);
        }
    }

    @Override // w4.i
    public void d(ArrayList arrayList) {
        arrayList.getClass();
        this.f10506a.f10539l = arrayList;
    }

    @Override // w4.i
    public void e(ArrayList arrayList) {
        ArrayList arrayList2;
        arrayList.getClass();
        int size = arrayList.size();
        m1 m1Var = this.f10506a;
        if (size > 3) {
            ArrayList arrayList3 = new ArrayList();
            m1Var.f10542o = arrayList3;
            arrayList3.add(arrayList.get(0));
            ArrayList arrayList4 = m1Var.f10542o;
            arrayList4.getClass();
            arrayList4.add(arrayList.get(1));
            ArrayList arrayList5 = m1Var.f10542o;
            arrayList5.getClass();
            arrayList5.add(arrayList.get(2));
        } else {
            m1Var.f10542o = arrayList;
        }
        e4.h hVar = m1Var.f10538b;
        if (hVar == null || (arrayList2 = m1Var.f10542o) == null || arrayList2.isEmpty()) {
            return;
        }
        Object obj = arrayList2.get(0);
        obj.getClass();
        hVar.c((p2) obj, hVar.f4546l);
        if (arrayList2.size() > 1) {
            Object obj2 = arrayList2.get(1);
            obj2.getClass();
            hVar.c((p2) obj2, hVar.f4547m);
        }
        if (arrayList2.size() > 2) {
            Object obj3 = arrayList2.get(2);
            obj3.getClass();
            hVar.c((p2) obj3, hVar.f4548n);
        }
    }

    @Override // w4.i
    public void f(p2 p2Var) {
        this.f10506a.f10541n = p2Var;
    }

    @Override // w4.i
    public void g() {
        m1 m1Var = this.f10506a;
        int i = 1;
        if (m1Var.f10539l.isEmpty()) {
            m1Var.b().f10040m.setVisibility(8);
            m1Var.b().f10038b.setVisibility(0);
        } else {
            e4.h hVar = m1Var.f10538b;
            if (hVar != null) {
                ArrayList arrayList = m1Var.f10539l;
                p2 p2Var = m1Var.f10541n;
                p2 p2Var2 = m1Var.f10543p;
                String string = m1Var.getString(2131952668);
                string.getClass();
                arrayList.getClass();
                hVar.f4544e = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                e4.f fVar = new e4.f();
                fVar.f4526c = string;
                fVar.f4524a = arrayList;
                fVar.f4525b = arrayList2;
                e4.g gVar = new e4.g();
                gVar.f4532a = fVar;
                gVar.f4533b = 0;
                hVar.f4544e.add(gVar);
                hVar.b(p2Var);
                hVar.f4544e.add(null);
                hVar.f = hVar.f4544e.size() - 1;
                hVar.b(p2Var2);
                hVar.f4544e.add(null);
                hVar.f4547m = hVar.f4544e.size() - 1;
                hVar.f4544e.add(null);
                hVar.g = hVar.f4544e.size() - 1;
                hVar.f4544e.add(null);
                hVar.f4548n = hVar.f4544e.size() - 1;
                hVar.f4544e.add(null);
                hVar.h = hVar.f4544e.size() - 1;
                hVar.f4544e.add(null);
                hVar.i = hVar.f4544e.size() - 1;
                hVar.f4544e.add(null);
                hVar.j = hVar.f4544e.size() - 1;
                hVar.f4544e.add(null);
                hVar.f4545k = hVar.f4544e.size() - 1;
            }
            m1Var.b().f10040m.setAdapter(m1Var.f10538b);
            m1Var.b().f10040m.setVisibility(0);
            m1Var.b().f10038b.setVisibility(8);
        }
        m1Var.b().f10039l.setVisibility(8);
        if (m1Var.getActivity() == null || !(m1Var.getActivity() instanceof MainActivity)) {
            return;
        }
        if (m1Var.f10544q) {
            m1Var.f10544q = false;
            FragmentActivity activity = m1Var.getActivity();
            activity.getClass();
            ((MainActivity) activity).l1();
        }
        if (z3.f2928c) {
            e4.h hVar2 = m1Var.f10538b;
            ArrayList arrayList3 = hVar2 != null ? hVar2.f4544e : null;
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                FragmentActivity activity2 = m1Var.getActivity();
                activity2.getClass();
                MainActivity mainActivity = (MainActivity) activity2;
                RelativeLayout relativeLayout = mainActivity.f3311i0;
                if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
                    return;
                }
                RelativeLayout relativeLayout2 = mainActivity.f3311i0;
                relativeLayout2.getClass();
                relativeLayout2.setVisibility(8);
                return;
            }
        }
        FragmentActivity activity3 = m1Var.getActivity();
        activity3.getClass();
        MainActivity mainActivity2 = (MainActivity) activity3;
        int i6 = 4;
        if (mainActivity2.f3311i0 == null) {
            mainActivity2.f3311i0 = (RelativeLayout) mainActivity2.findViewById(2131363145);
            View inflate = LayoutInflater.from(mainActivity2).inflate(2131558544, (ViewGroup) mainActivity2.f3311i0, false);
            RelativeLayout relativeLayout3 = mainActivity2.f3311i0;
            relativeLayout3.getClass();
            relativeLayout3.addView(inflate);
            RelativeLayout relativeLayout4 = mainActivity2.f3311i0;
            relativeLayout4.getClass();
            ((TextView) relativeLayout4.findViewById(2131364015)).setTypeface(f4.c.f4882w);
            RelativeLayout relativeLayout5 = mainActivity2.f3311i0;
            relativeLayout5.getClass();
            ((TextView) relativeLayout5.findViewById(2131364022)).setTypeface(f4.c.f4882w);
            RelativeLayout relativeLayout6 = mainActivity2.f3311i0;
            relativeLayout6.getClass();
            TextView textView = (TextView) relativeLayout6.findViewById(2131364501);
            textView.setTypeface(f4.c.f4883x);
            textView.setOnClickListener(new c3(i, mainActivity2));
            RelativeLayout relativeLayout7 = mainActivity2.f3311i0;
            relativeLayout7.getClass();
            TextView textView2 = (TextView) relativeLayout7.findViewById(2131363916);
            textView2.setTypeface(f4.c.f4883x);
            textView2.setOnClickListener(new c3(2, mainActivity2));
            RelativeLayout relativeLayout8 = mainActivity2.f3311i0;
            relativeLayout8.getClass();
            TextView textView3 = (TextView) relativeLayout8.findViewById(2131363841);
            textView3.setTypeface(f4.c.f4883x);
            textView3.setOnClickListener(new c3(3, mainActivity2));
            RelativeLayout relativeLayout9 = mainActivity2.f3311i0;
            relativeLayout9.getClass();
            ((TextView) relativeLayout9.findViewById(2131364273)).setTypeface(f4.c.f4882w);
            RelativeLayout relativeLayout10 = mainActivity2.f3311i0;
            relativeLayout10.getClass();
            ((LinearLayout) relativeLayout10.findViewById(2131362634)).setOnClickListener(new c3(i6, mainActivity2));
            RelativeLayout relativeLayout11 = mainActivity2.f3311i0;
            relativeLayout11.getClass();
            TextView textView4 = (TextView) relativeLayout11.findViewById(2131364215);
            textView4.setTypeface(f4.c.f4882w);
            textView4.setOnClickListener(new c3(5, mainActivity2));
            RelativeLayout relativeLayout12 = mainActivity2.f3311i0;
            relativeLayout12.getClass();
            mainActivity2.f3313k0 = (ProgressBar) relativeLayout12.findViewById(2131363001);
            RelativeLayout relativeLayout13 = mainActivity2.f3311i0;
            relativeLayout13.getClass();
            ((RelativeLayout) relativeLayout13.findViewById(2131363148)).setOnClickListener(new c4.e(8));
        }
        RelativeLayout relativeLayout14 = mainActivity2.f3311i0;
        relativeLayout14.getClass();
        relativeLayout14.setVisibility(0);
        ProgressBar progressBar = mainActivity2.f3313k0;
        progressBar.getClass();
        progressBar.setVisibility(4);
    }

    @Override // w4.i
    public void h(p2 p2Var) {
        e4.h hVar = this.f10506a.f10538b;
        if (hVar != null) {
            hVar.c(p2Var, hVar.g);
        }
    }

    @Override // w4.i
    public void i(p2 p2Var) {
        this.f10506a.f10543p = p2Var;
    }

    @Override // w4.i
    public void j(ArrayList arrayList) {
        e4.h hVar;
        arrayList.getClass();
        m1 m1Var = this.f10506a;
        m1Var.f10540m = arrayList;
        if (arrayList.isEmpty() || (hVar = m1Var.f10538b) == null) {
            return;
        }
        ArrayList arrayList2 = m1Var.f10540m;
        arrayList2.getClass();
        Iterator it = arrayList2.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            p2 p2Var = (p2) next;
            int i = p2Var.f11329a.f11224a;
            if (i == 521) {
                hVar.c(p2Var, hVar.i);
            } else if (i == 523) {
                hVar.c(p2Var, hVar.j);
            } else if (i != 524) {
                hVar.b(p2Var);
            } else {
                hVar.c(p2Var, hVar.f4545k);
            }
        }
    }

    @Override // w4.i
    public void k(ArrayList arrayList) {
        arrayList.getClass();
    }

    @Override // w4.i
    public void l(x4.g gVar) {
        gVar.getClass();
        e4.h hVar = this.f10506a.f10538b;
        if (hVar != null) {
            e4.g gVar2 = new e4.g();
            gVar2.f4532a = gVar;
            gVar2.f4533b = 3;
            hVar.f4544e.set(hVar.h, gVar2);
            hVar.notifyItemChanged(hVar.h);
        }
    }
}
