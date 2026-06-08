package p9;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b2.t1;
import e1.c0;
import f9.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k extends a {
    public static int L;
    public static int M;
    public TextView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public NestedScrollView F;
    public RecyclerView G;
    public s5.d H;
    public boolean I;
    public boolean J;
    public String K;

    /* renamed from: z, reason: collision with root package name */
    public ConstraintLayout f8535z;

    public final void a() {
        if (this.I) {
            NestedScrollView nestedScrollView = this.F;
            if (nestedScrollView != null) {
                nestedScrollView.setVisibility(0);
            }
            RecyclerView recyclerView = this.G;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            this.I = false;
            return;
        }
        UUID uuid = q.f5065a;
        StringBuilder sb = new StringBuilder();
        int i = M;
        if (i == 0) {
            kotlin.jvm.internal.l.i("localSwitchItemType");
            throw null;
        }
        int c9 = c.j.c(i);
        int i6 = 6;
        if (c9 != 5) {
            if (c9 != 6) {
                i6 = 7;
                if (c9 != 7) {
                    i6 = 3;
                }
            } else {
                i6 = 1;
            }
        }
        sb.append(a.a.c(i6));
        sb.append("-id:");
        sb.append(L);
        q.f5066b.h("collapseElement", sb.toString());
        dismiss();
    }

    @Override // p9.a, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ViewModelStore viewModelStore = activity.getViewModelStore();
        viewModelStore.getClass();
        this.H = (s5.d) new ViewModelProvider(viewModelStore, new b6.i(6)).get(s5.d.class);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Context context = getContext();
        i iVar = context == null ? null : new i(context, this);
        if (iVar != null) {
            return iVar;
        }
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.getClass();
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        return layoutInflater.inflate(2131558511, viewGroup, false);
    }

    @Override // p9.a, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        String str;
        view.getClass();
        super.onViewCreated(view, bundle);
        TextView textView = this.f8494b;
        if (textView != null) {
            int i = M;
            if (i == 0) {
                kotlin.jvm.internal.l.i("localSwitchItemType");
                throw null;
            }
            int c9 = c.j.c(i);
            if (c9 != 4) {
                s5.d dVar = this.H;
                if (c9 != 5) {
                    if (c9 != 6) {
                        if (dVar == null) {
                            kotlin.jvm.internal.l.i("viewModel");
                            throw null;
                        }
                        str = dVar.f.e().f5562d;
                    } else {
                        if (dVar == null) {
                            kotlin.jvm.internal.l.i("viewModel");
                            throw null;
                        }
                        str = dVar.f.e().f;
                    }
                } else {
                    if (dVar == null) {
                        kotlin.jvm.internal.l.i("viewModel");
                        throw null;
                    }
                    str = dVar.f.e().f;
                }
            } else {
                s5.d dVar2 = this.H;
                if (dVar2 == null) {
                    kotlin.jvm.internal.l.i("viewModel");
                    throw null;
                }
                str = dVar2.f.e().f5562d;
            }
            textView.setText(str);
        }
        ImageView imageView = this.f8495l;
        final int i6 = 0;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: p9.j

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ k f8534b;

                {
                    this.f8534b = this;
                }

                /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Iterable, java.lang.Object] */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    h8.c cVar;
                    LinkedHashMap linkedHashMap;
                    ArrayList arrayList;
                    int i10;
                    c.i a8;
                    LinkedHashMap linkedHashMap2;
                    c.i a10;
                    LinkedHashMap linkedHashMap3;
                    c.i a11;
                    LinkedHashMap linkedHashMap4;
                    int i11 = i6;
                    k kVar = this.f8534b;
                    switch (i11) {
                        case 0:
                            kVar.a();
                            return;
                        default:
                            NestedScrollView nestedScrollView = kVar.F;
                            if (nestedScrollView != null) {
                                nestedScrollView.setVisibility(8);
                            }
                            RecyclerView recyclerView = kVar.G;
                            if (recyclerView != null) {
                                s5.d dVar3 = kVar.H;
                                if (dVar3 == null) {
                                    kotlin.jvm.internal.l.i("viewModel");
                                    throw null;
                                }
                                h8.i iVar = dVar3.f9337d;
                                u5.m mVar = dVar3.f9334a;
                                int i12 = k.L;
                                int i13 = k.M;
                                if (i13 == 0) {
                                    kotlin.jvm.internal.l.i("localSwitchItemType");
                                    throw null;
                                }
                                boolean z9 = kVar.J;
                                String str2 = kVar.K;
                                if (str2 == null) {
                                    str2 = "";
                                }
                                ArrayList arrayList2 = new ArrayList();
                                int c10 = c.j.c(i13);
                                if (c10 != 4) {
                                    if (c10 != 5) {
                                        if (c10 != 6) {
                                            if (c10 == 7 && (str2.equals("ALL_VENDORS") || str2.equals("IAB_VENDORS"))) {
                                                h8.c cVar2 = mVar.f10737a;
                                                if (cVar2 != null && (linkedHashMap4 = cVar2.h) != null) {
                                                    LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                                                    for (Map.Entry entry : linkedHashMap4.entrySet()) {
                                                        if (((h8.i) entry.getValue()).f5476k == null) {
                                                            linkedHashMap5.put(entry.getKey(), entry.getValue());
                                                        }
                                                    }
                                                    Iterator it = linkedHashMap5.entrySet().iterator();
                                                    while (it.hasNext()) {
                                                        h8.i iVar2 = (h8.i) ((Map.Entry) it.next()).getValue();
                                                        Iterator it2 = iVar2.i.iterator();
                                                        while (it2.hasNext()) {
                                                            if (((Number) it2.next()).intValue() == i12) {
                                                                h8.i iVar3 = iVar2;
                                                                arrayList2.add(new c.i(iVar3, null, 4, 10, iVar2.f5466b, null, 82));
                                                                iVar2 = iVar3;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (iVar != null && (a11 = dVar3.a(str2, iVar.i, i12)) != null) {
                                                    arrayList2.add(a11);
                                                }
                                            }
                                        } else if (str2.equals("ALL_VENDORS") || str2.equals("IAB_VENDORS")) {
                                            h8.c cVar3 = mVar.f10737a;
                                            if (cVar3 != null && (linkedHashMap3 = cVar3.h) != null) {
                                                LinkedHashMap linkedHashMap6 = new LinkedHashMap();
                                                for (Map.Entry entry2 : linkedHashMap3.entrySet()) {
                                                    if (((h8.i) entry2.getValue()).f5476k == null) {
                                                        linkedHashMap6.put(entry2.getKey(), entry2.getValue());
                                                    }
                                                }
                                                Iterator it3 = linkedHashMap6.entrySet().iterator();
                                                while (it3.hasNext()) {
                                                    h8.i iVar4 = (h8.i) ((Map.Entry) it3.next()).getValue();
                                                    Iterator it4 = iVar4.h.iterator();
                                                    while (it4.hasNext()) {
                                                        if (((Number) it4.next()).intValue() == i12) {
                                                            h8.i iVar5 = iVar4;
                                                            arrayList2.add(new c.i(iVar5, null, 4, 10, iVar4.f5466b, null, 82));
                                                            iVar4 = iVar5;
                                                        }
                                                    }
                                                }
                                            }
                                            if (iVar != null && (a10 = dVar3.a(str2, iVar.h, i12)) != null) {
                                                arrayList2.add(a10);
                                            }
                                        }
                                    } else if (str2.equals("ALL_VENDORS") || str2.equals("IAB_VENDORS")) {
                                        h8.c cVar4 = mVar.f10737a;
                                        if (cVar4 != null && (linkedHashMap2 = cVar4.h) != null) {
                                            LinkedHashMap linkedHashMap7 = new LinkedHashMap();
                                            for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                                                if (((h8.i) entry3.getValue()).f5476k == null) {
                                                    linkedHashMap7.put(entry3.getKey(), entry3.getValue());
                                                }
                                            }
                                            Iterator it5 = linkedHashMap7.entrySet().iterator();
                                            while (it5.hasNext()) {
                                                h8.i iVar6 = (h8.i) ((Map.Entry) it5.next()).getValue();
                                                Iterator it6 = iVar6.g.iterator();
                                                while (it6.hasNext()) {
                                                    if (((Number) it6.next()).intValue() == i12) {
                                                        h8.i iVar7 = iVar6;
                                                        arrayList2.add(new c.i(iVar7, null, 4, 10, iVar6.f5466b, null, 82));
                                                        iVar6 = iVar7;
                                                    }
                                                }
                                            }
                                        }
                                        if (iVar != null && (a8 = dVar3.a(str2, iVar.g, i12)) != null) {
                                            arrayList2.add(a8);
                                        }
                                    }
                                    i10 = 0;
                                } else {
                                    ArrayList arrayList3 = new ArrayList();
                                    if ((str2.equals("ALL_VENDORS") || str2.equals("IAB_VENDORS")) && (cVar = mVar.f10737a) != null && (linkedHashMap = cVar.h) != null) {
                                        LinkedHashMap linkedHashMap8 = new LinkedHashMap();
                                        for (Map.Entry entry4 : linkedHashMap.entrySet()) {
                                            if (((h8.i) entry4.getValue()).f5476k == null) {
                                                linkedHashMap8.put(entry4.getKey(), entry4.getValue());
                                            }
                                        }
                                        Iterator it7 = linkedHashMap8.entrySet().iterator();
                                        while (it7.hasNext()) {
                                            h8.i iVar8 = (h8.i) ((Map.Entry) it7.next()).getValue();
                                            if (z9) {
                                                Iterator it8 = iVar8.f5475e.iterator();
                                                while (it8.hasNext()) {
                                                    if (((Number) it8.next()).intValue() == i12) {
                                                        arrayList3.add(new c.i(iVar8, null, 4, 10, iVar8.f5466b, null, 82));
                                                    }
                                                }
                                            } else {
                                                Iterator it9 = iVar8.f5474d.iterator();
                                                while (it9.hasNext()) {
                                                    if (((Number) it9.next()).intValue() == i12) {
                                                        h8.i iVar9 = iVar8;
                                                        arrayList3.add(new c.i(iVar9, null, 4, 10, iVar8.f5466b, null, 82));
                                                        iVar8 = iVar9;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (str2.equals("ALL_VENDORS") || str2.equals("NON_IAB_VENDORS")) {
                                        for (l8.l lVar : dVar3.f9335b.f7239n.f7212t.f7228a) {
                                            if (z9) {
                                                ArrayList arrayList4 = lVar.g;
                                                int size = arrayList4.size();
                                                int i14 = 0;
                                                while (i14 < size) {
                                                    Object obj = arrayList4.get(i14);
                                                    i14++;
                                                    if (((Number) obj).intValue() == i12) {
                                                        arrayList3.add(new c.i(lVar.a(), null, 4, 10, lVar.f7225c, null, 82));
                                                    }
                                                }
                                            } else {
                                                ArrayList arrayList5 = lVar.f;
                                                int size2 = arrayList5.size();
                                                int i15 = 0;
                                                while (i15 < size2) {
                                                    Object obj2 = arrayList5.get(i15);
                                                    i15++;
                                                    if (((Number) obj2).intValue() == i12) {
                                                        arrayList3.add(new c.i(lVar.a(), null, 4, 10, lVar.f7225c, null, 82));
                                                    }
                                                }
                                            }
                                        }
                                        if (str2.equals("ALL_VENDORS") && iVar != null) {
                                            if (z9) {
                                                Iterator it10 = iVar.f5475e.iterator();
                                                while (it10.hasNext()) {
                                                    if (((Number) it10.next()).intValue() == i12) {
                                                        ArrayList arrayList6 = arrayList3;
                                                        arrayList6.add(new c.i(iVar, null, 4, 10, iVar.f5466b, null, 82));
                                                        arrayList3 = arrayList6;
                                                    }
                                                }
                                            } else {
                                                arrayList = arrayList3;
                                                i10 = 0;
                                                Iterator it11 = iVar.f5474d.iterator();
                                                while (it11.hasNext()) {
                                                    if (((Number) it11.next()).intValue() == i12) {
                                                        arrayList.add(new c.i(iVar, null, 4, 10, iVar.f5466b, null, 82));
                                                    }
                                                }
                                                arrayList2.addAll(arrayList);
                                            }
                                        }
                                    }
                                    arrayList = arrayList3;
                                    i10 = 0;
                                    arrayList2.addAll(arrayList);
                                }
                                c0 c0Var = new c0(29);
                                h9.d dVar4 = kVar.f8502s;
                                recyclerView.setAdapter(new c.h(arrayList2, c0Var, (String) null, dVar4 == null ? null : dVar4.i, (Integer) null, (Integer) null, dVar4 == null ? null : dVar4.f5495a, kVar.f8503t, kVar.v, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR));
                                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                                recyclerView.setVisibility(i10);
                            }
                            kVar.I = true;
                            return;
                    }
                }
            });
            s5.d dVar3 = this.H;
            if (dVar3 == null) {
                kotlin.jvm.internal.l.i("viewModel");
                throw null;
            }
            imageView.setContentDescription(dVar3.f.e().f5568o);
        }
        this.f8535z = (ConstraintLayout) view.findViewById(2131362607);
        this.A = (TextView) view.findViewById(2131362092);
        this.B = (TextView) view.findViewById(2131362091);
        this.C = (TextView) view.findViewById(2131362090);
        this.D = (TextView) view.findViewById(2131362093);
        this.E = (TextView) view.findViewById(2131364289);
        this.F = (NestedScrollView) view.findViewById(2131363374);
        this.G = (RecyclerView) view.findViewById(2131363342);
        s5.d dVar4 = this.H;
        if (dVar4 == null) {
            kotlin.jvm.internal.l.i("viewModel");
            throw null;
        }
        String str2 = dVar4.f.e().f5569p;
        if (str2.length() > 0) {
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new UnderlineSpan(), 0, str2.length(), 0);
            TextView textView2 = this.E;
            if (textView2 != null) {
                textView2.setText(spannableString);
            }
        }
        TextView textView3 = this.E;
        final int i10 = 1;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener(this) { // from class: p9.j

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ k f8534b;

                {
                    this.f8534b = this;
                }

                /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Iterable, java.lang.Object] */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    h8.c cVar;
                    LinkedHashMap linkedHashMap;
                    ArrayList arrayList;
                    int i102;
                    c.i a8;
                    LinkedHashMap linkedHashMap2;
                    c.i a10;
                    LinkedHashMap linkedHashMap3;
                    c.i a11;
                    LinkedHashMap linkedHashMap4;
                    int i11 = i10;
                    k kVar = this.f8534b;
                    switch (i11) {
                        case 0:
                            kVar.a();
                            return;
                        default:
                            NestedScrollView nestedScrollView = kVar.F;
                            if (nestedScrollView != null) {
                                nestedScrollView.setVisibility(8);
                            }
                            RecyclerView recyclerView = kVar.G;
                            if (recyclerView != null) {
                                s5.d dVar32 = kVar.H;
                                if (dVar32 == null) {
                                    kotlin.jvm.internal.l.i("viewModel");
                                    throw null;
                                }
                                h8.i iVar = dVar32.f9337d;
                                u5.m mVar = dVar32.f9334a;
                                int i12 = k.L;
                                int i13 = k.M;
                                if (i13 == 0) {
                                    kotlin.jvm.internal.l.i("localSwitchItemType");
                                    throw null;
                                }
                                boolean z9 = kVar.J;
                                String str22 = kVar.K;
                                if (str22 == null) {
                                    str22 = "";
                                }
                                ArrayList arrayList2 = new ArrayList();
                                int c10 = c.j.c(i13);
                                if (c10 != 4) {
                                    if (c10 != 5) {
                                        if (c10 != 6) {
                                            if (c10 == 7 && (str22.equals("ALL_VENDORS") || str22.equals("IAB_VENDORS"))) {
                                                h8.c cVar2 = mVar.f10737a;
                                                if (cVar2 != null && (linkedHashMap4 = cVar2.h) != null) {
                                                    LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                                                    for (Map.Entry entry : linkedHashMap4.entrySet()) {
                                                        if (((h8.i) entry.getValue()).f5476k == null) {
                                                            linkedHashMap5.put(entry.getKey(), entry.getValue());
                                                        }
                                                    }
                                                    Iterator it = linkedHashMap5.entrySet().iterator();
                                                    while (it.hasNext()) {
                                                        h8.i iVar2 = (h8.i) ((Map.Entry) it.next()).getValue();
                                                        Iterator it2 = iVar2.i.iterator();
                                                        while (it2.hasNext()) {
                                                            if (((Number) it2.next()).intValue() == i12) {
                                                                h8.i iVar3 = iVar2;
                                                                arrayList2.add(new c.i(iVar3, null, 4, 10, iVar2.f5466b, null, 82));
                                                                iVar2 = iVar3;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (iVar != null && (a11 = dVar32.a(str22, iVar.i, i12)) != null) {
                                                    arrayList2.add(a11);
                                                }
                                            }
                                        } else if (str22.equals("ALL_VENDORS") || str22.equals("IAB_VENDORS")) {
                                            h8.c cVar3 = mVar.f10737a;
                                            if (cVar3 != null && (linkedHashMap3 = cVar3.h) != null) {
                                                LinkedHashMap linkedHashMap6 = new LinkedHashMap();
                                                for (Map.Entry entry2 : linkedHashMap3.entrySet()) {
                                                    if (((h8.i) entry2.getValue()).f5476k == null) {
                                                        linkedHashMap6.put(entry2.getKey(), entry2.getValue());
                                                    }
                                                }
                                                Iterator it3 = linkedHashMap6.entrySet().iterator();
                                                while (it3.hasNext()) {
                                                    h8.i iVar4 = (h8.i) ((Map.Entry) it3.next()).getValue();
                                                    Iterator it4 = iVar4.h.iterator();
                                                    while (it4.hasNext()) {
                                                        if (((Number) it4.next()).intValue() == i12) {
                                                            h8.i iVar5 = iVar4;
                                                            arrayList2.add(new c.i(iVar5, null, 4, 10, iVar4.f5466b, null, 82));
                                                            iVar4 = iVar5;
                                                        }
                                                    }
                                                }
                                            }
                                            if (iVar != null && (a10 = dVar32.a(str22, iVar.h, i12)) != null) {
                                                arrayList2.add(a10);
                                            }
                                        }
                                    } else if (str22.equals("ALL_VENDORS") || str22.equals("IAB_VENDORS")) {
                                        h8.c cVar4 = mVar.f10737a;
                                        if (cVar4 != null && (linkedHashMap2 = cVar4.h) != null) {
                                            LinkedHashMap linkedHashMap7 = new LinkedHashMap();
                                            for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                                                if (((h8.i) entry3.getValue()).f5476k == null) {
                                                    linkedHashMap7.put(entry3.getKey(), entry3.getValue());
                                                }
                                            }
                                            Iterator it5 = linkedHashMap7.entrySet().iterator();
                                            while (it5.hasNext()) {
                                                h8.i iVar6 = (h8.i) ((Map.Entry) it5.next()).getValue();
                                                Iterator it6 = iVar6.g.iterator();
                                                while (it6.hasNext()) {
                                                    if (((Number) it6.next()).intValue() == i12) {
                                                        h8.i iVar7 = iVar6;
                                                        arrayList2.add(new c.i(iVar7, null, 4, 10, iVar6.f5466b, null, 82));
                                                        iVar6 = iVar7;
                                                    }
                                                }
                                            }
                                        }
                                        if (iVar != null && (a8 = dVar32.a(str22, iVar.g, i12)) != null) {
                                            arrayList2.add(a8);
                                        }
                                    }
                                    i102 = 0;
                                } else {
                                    ArrayList arrayList3 = new ArrayList();
                                    if ((str22.equals("ALL_VENDORS") || str22.equals("IAB_VENDORS")) && (cVar = mVar.f10737a) != null && (linkedHashMap = cVar.h) != null) {
                                        LinkedHashMap linkedHashMap8 = new LinkedHashMap();
                                        for (Map.Entry entry4 : linkedHashMap.entrySet()) {
                                            if (((h8.i) entry4.getValue()).f5476k == null) {
                                                linkedHashMap8.put(entry4.getKey(), entry4.getValue());
                                            }
                                        }
                                        Iterator it7 = linkedHashMap8.entrySet().iterator();
                                        while (it7.hasNext()) {
                                            h8.i iVar8 = (h8.i) ((Map.Entry) it7.next()).getValue();
                                            if (z9) {
                                                Iterator it8 = iVar8.f5475e.iterator();
                                                while (it8.hasNext()) {
                                                    if (((Number) it8.next()).intValue() == i12) {
                                                        arrayList3.add(new c.i(iVar8, null, 4, 10, iVar8.f5466b, null, 82));
                                                    }
                                                }
                                            } else {
                                                Iterator it9 = iVar8.f5474d.iterator();
                                                while (it9.hasNext()) {
                                                    if (((Number) it9.next()).intValue() == i12) {
                                                        h8.i iVar9 = iVar8;
                                                        arrayList3.add(new c.i(iVar9, null, 4, 10, iVar8.f5466b, null, 82));
                                                        iVar8 = iVar9;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (str22.equals("ALL_VENDORS") || str22.equals("NON_IAB_VENDORS")) {
                                        for (l8.l lVar : dVar32.f9335b.f7239n.f7212t.f7228a) {
                                            if (z9) {
                                                ArrayList arrayList4 = lVar.g;
                                                int size = arrayList4.size();
                                                int i14 = 0;
                                                while (i14 < size) {
                                                    Object obj = arrayList4.get(i14);
                                                    i14++;
                                                    if (((Number) obj).intValue() == i12) {
                                                        arrayList3.add(new c.i(lVar.a(), null, 4, 10, lVar.f7225c, null, 82));
                                                    }
                                                }
                                            } else {
                                                ArrayList arrayList5 = lVar.f;
                                                int size2 = arrayList5.size();
                                                int i15 = 0;
                                                while (i15 < size2) {
                                                    Object obj2 = arrayList5.get(i15);
                                                    i15++;
                                                    if (((Number) obj2).intValue() == i12) {
                                                        arrayList3.add(new c.i(lVar.a(), null, 4, 10, lVar.f7225c, null, 82));
                                                    }
                                                }
                                            }
                                        }
                                        if (str22.equals("ALL_VENDORS") && iVar != null) {
                                            if (z9) {
                                                Iterator it10 = iVar.f5475e.iterator();
                                                while (it10.hasNext()) {
                                                    if (((Number) it10.next()).intValue() == i12) {
                                                        ArrayList arrayList6 = arrayList3;
                                                        arrayList6.add(new c.i(iVar, null, 4, 10, iVar.f5466b, null, 82));
                                                        arrayList3 = arrayList6;
                                                    }
                                                }
                                            } else {
                                                arrayList = arrayList3;
                                                i102 = 0;
                                                Iterator it11 = iVar.f5474d.iterator();
                                                while (it11.hasNext()) {
                                                    if (((Number) it11.next()).intValue() == i12) {
                                                        arrayList.add(new c.i(iVar, null, 4, 10, iVar.f5466b, null, 82));
                                                    }
                                                }
                                                arrayList2.addAll(arrayList);
                                            }
                                        }
                                    }
                                    arrayList = arrayList3;
                                    i102 = 0;
                                    arrayList2.addAll(arrayList);
                                }
                                c0 c0Var = new c0(29);
                                h9.d dVar42 = kVar.f8502s;
                                recyclerView.setAdapter(new c.h(arrayList2, c0Var, (String) null, dVar42 == null ? null : dVar42.i, (Integer) null, (Integer) null, dVar42 == null ? null : dVar42.f5495a, kVar.f8503t, kVar.v, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR));
                                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                                recyclerView.setVisibility(i102);
                            }
                            kVar.I = true;
                            return;
                    }
                }
            });
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            TextView textView4 = this.D;
            if (textView4 != null) {
                textView4.setText(arguments.getString("title", ""));
            }
            TextView textView5 = this.C;
            if (textView5 != null) {
                textView5.setText(arguments.getString("description", ""));
            }
            TextView textView6 = this.B;
            if (textView6 != null) {
                textView6.setText(arguments.getString("legal_description", ""));
            }
            TextView textView7 = this.A;
            if (textView7 != null) {
                textView7.setText(arguments.getString("legal_description_label", ""));
            }
            this.J = arguments.getBoolean("legitimate_interest", false);
            this.K = arguments.getString("vendor_type_selected", "");
        }
        h9.d dVar5 = this.f8502s;
        if (dVar5 != null) {
            Integer num = dVar5.i;
            if (num != null) {
                int intValue = num.intValue();
                TextView textView8 = this.D;
                if (textView8 != null) {
                    textView8.setTextColor(intValue);
                }
                TextView textView9 = this.C;
                if (textView9 != null) {
                    textView9.setTextColor(intValue);
                }
                TextView textView10 = this.B;
                if (textView10 != null) {
                    textView10.setTextColor(intValue);
                }
                TextView textView11 = this.A;
                if (textView11 != null) {
                    textView11.setTextColor(intValue);
                }
            }
            Integer num2 = dVar5.f5501l;
            if (num2 != null) {
                int intValue2 = num2.intValue();
                TextView textView12 = this.E;
                if (textView12 != null) {
                    textView12.setTextColor(intValue2);
                }
            }
            Integer num3 = dVar5.g;
            if (num3 != null) {
                int intValue3 = num3.intValue();
                ConstraintLayout constraintLayout = this.f8535z;
                if (constraintLayout != null) {
                    constraintLayout.setBackgroundColor(intValue3);
                }
            }
        }
        t1.f(this.f8503t, this.D);
        t1.f(this.v, this.E, this.C, this.B, this.A);
    }
}
