package q5;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;
import b2.t1;
import c.j;
import f9.q;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.l;
import o7.a0;
import o7.c0;
import o7.m0;
import q6.n;
import q6.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g extends p9.a implements c.b {
    public TextView A;
    public TextView B;
    public Button C;
    public RecyclerView D;
    public RecyclerView E;
    public RecyclerView F;
    public FrameLayout G;
    public ConstraintLayout H;
    public View I;
    public View J;
    public View K;
    public i L;

    /* renamed from: z, reason: collision with root package name */
    public TextView f8706z;

    public final c.h a(ArrayList arrayList) {
        h9.d dVar = this.f8502s;
        return new c.h(arrayList, this, (String) null, dVar == null ? null : dVar.i, dVar == null ? null : dVar.f5499e, dVar == null ? null : dVar.f, dVar != null ? dVar.f5495a : null, this.f8503t, this.v, 12);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Iterable, java.lang.Object] */
    @Override // c.b
    public final void f(c.i iVar) {
        Object obj;
        ?? r12;
        h8.d dVar = iVar.f1160a;
        i iVar2 = this.L;
        j8.b bVar = null;
        Object obj2 = null;
        r2 = null;
        r2 = null;
        j8.c cVar = null;
        Object obj3 = null;
        if (iVar2 == null) {
            l.i("viewModel");
            throw null;
        }
        j8.a aVar = iVar2.f8709a;
        int c9 = j.c(iVar.f1163d);
        if (c9 == 10) {
            ?? r13 = aVar.f6719d;
            if (r13 != 0) {
                Iterator it = r13.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((j8.b) next).f6720a.intValue() == dVar.f5465a) {
                        obj3 = next;
                        break;
                    }
                }
                bVar = (j8.b) obj3;
            }
            if (bVar == null) {
                return;
            }
            bVar.f6722c = iVar.f1161b;
            return;
        }
        if (c9 != 11) {
            return;
        }
        ?? r14 = aVar.f6719d;
        if (r14 != 0) {
            Iterator it2 = r14.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (((j8.b) obj).f6720a.intValue() == q6.j.i0(j8.e.f6732b)) {
                    break;
                }
            }
            j8.b bVar2 = (j8.b) obj;
            if (bVar2 != null && (r12 = bVar2.f) != 0) {
                Iterator it3 = r12.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    Object next2 = it3.next();
                    if (((j8.c) next2).f6726b.intValue() == dVar.f5465a) {
                        obj2 = next2;
                        break;
                    }
                }
                cVar = (j8.c) obj2;
            }
        }
        if (cVar == null) {
            return;
        }
        cVar.f6728d = iVar.f1161b;
    }

    @Override // p9.a, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() == null) {
            return;
        }
        ViewModelStore viewModelStore = getViewModelStore();
        viewModelStore.getClass();
        i iVar = (i) new ViewModelProvider(viewModelStore, new b6.i(5)).get(i.class);
        this.L = iVar;
        if (iVar != null) {
            iVar.a(j8.e.f6731a);
        } else {
            l.i("viewModel");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View inflate = layoutInflater.inflate(2131558513, viewGroup, false);
        inflate.getClass();
        return inflate;
    }

    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Iterable, java.lang.Object] */
    @Override // p9.a, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        ArrayList arrayList;
        view.getClass();
        super.onViewCreated(view, bundle);
        TextView textView = this.f8494b;
        if (textView != null) {
            textView.setText(getString(2131951776));
        }
        this.f8706z = (TextView) view.findViewById(2131364205);
        this.D = (RecyclerView) view.findViewById(2131363343);
        this.A = (TextView) view.findViewById(2131364270);
        this.B = (TextView) view.findViewById(2131363718);
        this.C = (Button) view.findViewById(2131361990);
        this.E = (RecyclerView) view.findViewById(2131363350);
        this.F = (RecyclerView) view.findViewById(2131363316);
        this.G = (FrameLayout) view.findViewById(2131362202);
        this.H = (ConstraintLayout) view.findViewById(2131362895);
        this.I = view.findViewById(2131363053);
        this.J = view.findViewById(2131363412);
        this.K = view.findViewById(2131362025);
        ImageView imageView = this.f8495l;
        final int i = 0;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: q5.e

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ g f8703b;

                {
                    this.f8703b = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r2v15, types: [q6.t] */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ArrayList arrayList2;
                    ArrayList arrayList3;
                    int i6;
                    ArrayList arrayList4;
                    ArrayList arrayList5;
                    ArrayList arrayList6;
                    int i10 = i;
                    g gVar = this.f8703b;
                    switch (i10) {
                        case 0:
                            gVar.dismiss();
                            return;
                        default:
                            ArrayList arrayList7 = null;
                            if (l.g.f7044a) {
                                Fragment findFragmentByTag = gVar.getChildFragmentManager().findFragmentByTag("d");
                                l.d dVar = findFragmentByTag instanceof l.d ? (l.d) findFragmentByTag : null;
                                if (dVar != null) {
                                    dVar.a();
                                }
                            }
                            i iVar = gVar.L;
                            if (iVar == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            RecyclerView recyclerView = gVar.D;
                            RecyclerView.Adapter adapter = recyclerView == null ? null : recyclerView.getAdapter();
                            c.h hVar = adapter instanceof c.h ? (c.h) adapter : null;
                            int i11 = 0;
                            if (hVar == null || (arrayList6 = hVar.f1155a) == null) {
                                arrayList2 = null;
                            } else {
                                arrayList2 = new ArrayList(n.i0(arrayList6, 10));
                                int size = arrayList6.size();
                                int i12 = 0;
                                while (i12 < size) {
                                    Object obj = arrayList6.get(i12);
                                    i12++;
                                    arrayList2.add(((c.i) obj).f1161b);
                                }
                            }
                            RecyclerView recyclerView2 = gVar.E;
                            RecyclerView.Adapter adapter2 = recyclerView2 == null ? null : recyclerView2.getAdapter();
                            c.h hVar2 = adapter2 instanceof c.h ? (c.h) adapter2 : null;
                            if (hVar2 == null || (arrayList5 = hVar2.f1155a) == null) {
                                arrayList3 = null;
                            } else {
                                arrayList3 = new ArrayList(n.i0(arrayList5, 10));
                                int size2 = arrayList5.size();
                                int i13 = 0;
                                while (i13 < size2) {
                                    Object obj2 = arrayList5.get(i13);
                                    i13++;
                                    arrayList3.add(((c.i) obj2).f1161b);
                                }
                            }
                            RecyclerView recyclerView3 = gVar.F;
                            RecyclerView.Adapter adapter3 = recyclerView3 == null ? null : recyclerView3.getAdapter();
                            c.h hVar3 = adapter3 instanceof c.h ? (c.h) adapter3 : null;
                            if (hVar3 != null && (arrayList4 = hVar3.f1155a) != null) {
                                arrayList7 = new ArrayList(n.i0(arrayList4, 10));
                                int size3 = arrayList4.size();
                                int i14 = 0;
                                while (i14 < size3) {
                                    Object obj3 = arrayList4.get(i14);
                                    i14++;
                                    arrayList7.add(((c.i) obj3).f1161b);
                                }
                            }
                            ?? r22 = t.f8724a;
                            if (arrayList2 == null) {
                                arrayList2 = r22;
                            }
                            if (arrayList3 == null) {
                                arrayList3 = r22;
                            }
                            ArrayList A0 = q6.l.A0(arrayList3, arrayList2);
                            if (arrayList7 == null) {
                                arrayList7 = r22;
                            }
                            ArrayList A02 = q6.l.A0(arrayList7, A0);
                            iVar.b();
                            i.c();
                            if (!A02.isEmpty()) {
                                int size4 = A02.size();
                                int i15 = 0;
                                while (i15 < size4) {
                                    Object obj4 = A02.get(i15);
                                    i15++;
                                    if (!l.a((Boolean) obj4, Boolean.FALSE)) {
                                        if (!A02.isEmpty()) {
                                            int size5 = A02.size();
                                            int i16 = 0;
                                            while (i16 < size5) {
                                                Object obj5 = A02.get(i16);
                                                i16++;
                                                if (!l.a((Boolean) obj5, Boolean.TRUE)) {
                                                    i6 = 2;
                                                    q.b(5, i6).observe(gVar, new f(gVar, i11));
                                                    return;
                                                }
                                            }
                                        }
                                        i6 = 3;
                                        q.b(5, i6).observe(gVar, new f(gVar, i11));
                                        return;
                                    }
                                }
                            }
                            i6 = 1;
                            q.b(5, i6).observe(gVar, new f(gVar, i11));
                            return;
                    }
                }
            });
        }
        i iVar = this.L;
        if (iVar == null) {
            l.i("viewModel");
            throw null;
        }
        ArrayList a8 = iVar.a(j8.e.f6731a);
        if (a8.isEmpty()) {
            TextView textView2 = this.f8706z;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            RecyclerView recyclerView = this.D;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            View view2 = this.I;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        } else {
            RecyclerView recyclerView2 = this.D;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(a(a8));
            }
            TextView textView3 = this.f8706z;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            RecyclerView recyclerView3 = this.D;
            if (recyclerView3 != null) {
                recyclerView3.setVisibility(0);
            }
            View view3 = this.I;
            if (view3 != null) {
                view3.setVisibility(0);
            }
        }
        i iVar2 = this.L;
        if (iVar2 == null) {
            l.i("viewModel");
            throw null;
        }
        ArrayList arrayList2 = new ArrayList();
        ?? r12 = iVar2.f8709a.f6719d;
        if (r12 == 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Object obj : r12) {
                if (q6.j.T(j8.e.f6732b, ((j8.b) obj).f6720a.intValue())) {
                    arrayList.add(obj);
                }
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            int i6 = 0;
            while (i6 < size) {
                Object obj2 = arrayList.get(i6);
                i6++;
                ?? r10 = ((j8.b) obj2).f;
                if (r10 != 0) {
                    for (j8.c cVar : r10) {
                        int intValue = cVar.f6726b.intValue();
                        String str = cVar.f6729e;
                        if (str == null) {
                            str = "";
                        }
                        arrayList2.add(new c.i(new h8.d(intValue, str), cVar.f6728d, 0, 12, null, null, 116));
                    }
                }
            }
        }
        if (arrayList2.isEmpty()) {
            TextView textView4 = this.A;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            RecyclerView recyclerView4 = this.E;
            if (recyclerView4 != null) {
                recyclerView4.setVisibility(8);
            }
            View view4 = this.J;
            if (view4 != null) {
                view4.setVisibility(8);
            }
        } else {
            RecyclerView recyclerView5 = this.E;
            if (recyclerView5 != null) {
                recyclerView5.setAdapter(a(arrayList2));
            }
            TextView textView5 = this.A;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
            RecyclerView recyclerView6 = this.E;
            if (recyclerView6 != null) {
                recyclerView6.setVisibility(0);
            }
            View view5 = this.J;
            if (view5 != null) {
                view5.setVisibility(0);
            }
        }
        i iVar3 = this.L;
        if (iVar3 == null) {
            l.i("viewModel");
            throw null;
        }
        ArrayList a10 = iVar3.a(j8.e.f6733c);
        if (a10.isEmpty()) {
            TextView textView6 = this.B;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            RecyclerView recyclerView7 = this.F;
            if (recyclerView7 != null) {
                recyclerView7.setVisibility(8);
            }
            View view6 = this.K;
            if (view6 != null) {
                view6.setVisibility(8);
            }
        } else {
            RecyclerView recyclerView8 = this.F;
            if (recyclerView8 != null) {
                recyclerView8.setAdapter(a(a10));
            }
            TextView textView7 = this.B;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
            RecyclerView recyclerView9 = this.F;
            if (recyclerView9 != null) {
                recyclerView9.setVisibility(0);
            }
            View view7 = this.K;
            if (view7 != null) {
                view7.setVisibility(0);
            }
        }
        final int i10 = 1;
        if (l.g.f7044a) {
            getChildFragmentManager().beginTransaction().add(2131362202, new l.d(), "d").addToBackStack(null).commit();
            FrameLayout frameLayout = this.G;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            if (this.L == null) {
                l.i("viewModel");
                throw null;
            }
            if (l.g.f7044a) {
                l9.a aVar = (l9.a) m9.c.v.getValue();
                aVar.getClass();
                aVar.g(92, true);
            }
        } else {
            FrameLayout frameLayout2 = this.G;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
        }
        Button button = this.C;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener(this) { // from class: q5.e

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ g f8703b;

                {
                    this.f8703b = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r2v15, types: [q6.t] */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view22) {
                    ArrayList arrayList22;
                    ArrayList arrayList3;
                    int i62;
                    ArrayList arrayList4;
                    ArrayList arrayList5;
                    ArrayList arrayList6;
                    int i102 = i10;
                    g gVar = this.f8703b;
                    switch (i102) {
                        case 0:
                            gVar.dismiss();
                            return;
                        default:
                            ArrayList arrayList7 = null;
                            if (l.g.f7044a) {
                                Fragment findFragmentByTag = gVar.getChildFragmentManager().findFragmentByTag("d");
                                l.d dVar = findFragmentByTag instanceof l.d ? (l.d) findFragmentByTag : null;
                                if (dVar != null) {
                                    dVar.a();
                                }
                            }
                            i iVar4 = gVar.L;
                            if (iVar4 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            RecyclerView recyclerView10 = gVar.D;
                            RecyclerView.Adapter adapter = recyclerView10 == null ? null : recyclerView10.getAdapter();
                            c.h hVar = adapter instanceof c.h ? (c.h) adapter : null;
                            int i11 = 0;
                            if (hVar == null || (arrayList6 = hVar.f1155a) == null) {
                                arrayList22 = null;
                            } else {
                                arrayList22 = new ArrayList(n.i0(arrayList6, 10));
                                int size2 = arrayList6.size();
                                int i12 = 0;
                                while (i12 < size2) {
                                    Object obj3 = arrayList6.get(i12);
                                    i12++;
                                    arrayList22.add(((c.i) obj3).f1161b);
                                }
                            }
                            RecyclerView recyclerView22 = gVar.E;
                            RecyclerView.Adapter adapter2 = recyclerView22 == null ? null : recyclerView22.getAdapter();
                            c.h hVar2 = adapter2 instanceof c.h ? (c.h) adapter2 : null;
                            if (hVar2 == null || (arrayList5 = hVar2.f1155a) == null) {
                                arrayList3 = null;
                            } else {
                                arrayList3 = new ArrayList(n.i0(arrayList5, 10));
                                int size22 = arrayList5.size();
                                int i13 = 0;
                                while (i13 < size22) {
                                    Object obj22 = arrayList5.get(i13);
                                    i13++;
                                    arrayList3.add(((c.i) obj22).f1161b);
                                }
                            }
                            RecyclerView recyclerView32 = gVar.F;
                            RecyclerView.Adapter adapter3 = recyclerView32 == null ? null : recyclerView32.getAdapter();
                            c.h hVar3 = adapter3 instanceof c.h ? (c.h) adapter3 : null;
                            if (hVar3 != null && (arrayList4 = hVar3.f1155a) != null) {
                                arrayList7 = new ArrayList(n.i0(arrayList4, 10));
                                int size3 = arrayList4.size();
                                int i14 = 0;
                                while (i14 < size3) {
                                    Object obj32 = arrayList4.get(i14);
                                    i14++;
                                    arrayList7.add(((c.i) obj32).f1161b);
                                }
                            }
                            ?? r22 = t.f8724a;
                            if (arrayList22 == null) {
                                arrayList22 = r22;
                            }
                            if (arrayList3 == null) {
                                arrayList3 = r22;
                            }
                            ArrayList A0 = q6.l.A0(arrayList3, arrayList22);
                            if (arrayList7 == null) {
                                arrayList7 = r22;
                            }
                            ArrayList A02 = q6.l.A0(arrayList7, A0);
                            iVar4.b();
                            i.c();
                            if (!A02.isEmpty()) {
                                int size4 = A02.size();
                                int i15 = 0;
                                while (i15 < size4) {
                                    Object obj4 = A02.get(i15);
                                    i15++;
                                    if (!l.a((Boolean) obj4, Boolean.FALSE)) {
                                        if (!A02.isEmpty()) {
                                            int size5 = A02.size();
                                            int i16 = 0;
                                            while (i16 < size5) {
                                                Object obj5 = A02.get(i16);
                                                i16++;
                                                if (!l.a((Boolean) obj5, Boolean.TRUE)) {
                                                    i62 = 2;
                                                    q.b(5, i62).observe(gVar, new f(gVar, i11));
                                                    return;
                                                }
                                            }
                                        }
                                        i62 = 3;
                                        q.b(5, i62).observe(gVar, new f(gVar, i11));
                                        return;
                                    }
                                }
                            }
                            i62 = 1;
                            q.b(5, i62).observe(gVar, new f(gVar, i11));
                            return;
                    }
                }
            });
        }
        h9.d dVar = this.f8502s;
        if (dVar != null) {
            Integer num = dVar.g;
            if (num != null) {
                int intValue2 = num.intValue();
                ConstraintLayout constraintLayout = this.H;
                if (constraintLayout != null) {
                    constraintLayout.setBackgroundColor(intValue2);
                }
            }
            Integer num2 = dVar.i;
            if (num2 != null) {
                int intValue3 = num2.intValue();
                TextView textView8 = this.f8706z;
                if (textView8 != null) {
                    textView8.setTextColor(intValue3);
                }
                TextView textView9 = this.A;
                if (textView9 != null) {
                    textView9.setTextColor(intValue3);
                }
                TextView textView10 = this.B;
                if (textView10 != null) {
                    textView10.setTextColor(intValue3);
                }
            }
            Integer num3 = dVar.f5502m;
            if (num3 != null) {
                int intValue4 = num3.intValue();
                Button button2 = this.C;
                if (button2 != null) {
                    button2.setTextColor(intValue4);
                }
            }
            Integer num4 = dVar.f5504o;
            if (num4 != null) {
                int intValue5 = num4.intValue();
                Button button3 = this.C;
                if (button3 != null) {
                    button3.setBackgroundTintList(ColorStateList.valueOf(intValue5));
                }
            }
        }
        t1.f(this.f8503t, this.f8706z, this.A, this.B);
        t1.f(this.f8504u, this.C);
        i iVar4 = this.L;
        if (iVar4 == null) {
            l.i("viewModel");
            throw null;
        }
        a0 viewModelScope = ViewModelKt.getViewModelScope(iVar4);
        v7.e eVar = m0.f8288a;
        c0.s(viewModelScope, v7.d.f10884a, null, new p9.c(iVar4, (t6.c) null, 2), 2);
    }

    @Override // c.b
    public final void e(c.i iVar) {
    }
}
