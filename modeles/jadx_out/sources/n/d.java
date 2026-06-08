package n;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.s;
import c.h;
import c.i;
import f9.q;
import g5.g;
import j9.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.jvm.internal.l;
import o7.a0;
import o7.c0;
import o7.m0;
import u5.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class d extends p9.a implements c.b {
    public Button A;
    public Button B;
    public RecyclerView C;
    public e D;
    public s5.d E;
    public h F;

    /* renamed from: z, reason: collision with root package name */
    public ConstraintLayout f7888z;

    public final ColorStateList a() {
        h9.d dVar = this.f8502s;
        if (dVar == null) {
            return null;
        }
        Integer num = dVar.f5505p;
        Integer num2 = dVar.f5504o;
        if (num2 == null || num == null) {
            return null;
        }
        return new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[]{-16842910}}, new int[]{num2.intValue(), num.intValue()});
    }

    public final void b(LinkedHashSet linkedHashSet) {
        boolean z9;
        Button button = this.B;
        boolean z10 = false;
        if (button != null) {
            if (!linkedHashSet.isEmpty()) {
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    if (((Boolean) it.next()).booleanValue()) {
                        z9 = true;
                        break;
                    }
                }
            }
            z9 = false;
            button.setEnabled(z9);
        }
        Button button2 = this.A;
        if (button2 == null) {
            return;
        }
        if (!linkedHashSet.isEmpty()) {
            Iterator it2 = linkedHashSet.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                } else if (!((Boolean) it2.next()).booleanValue()) {
                    z10 = true;
                    break;
                }
            }
        }
        button2.setEnabled(z10);
    }

    public final ColorStateList c() {
        h9.d dVar = this.f8502s;
        if (dVar == null) {
            return null;
        }
        Integer num = dVar.f5503n;
        Integer num2 = dVar.f5502m;
        if (num2 == null || num == null) {
            return null;
        }
        return new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[]{-16842910}}, new int[]{num2.intValue(), num.intValue()});
    }

    public final void d() {
        h hVar = this.F;
        if (hVar == null) {
            l.i("switchAdapter");
            throw null;
        }
        e eVar = this.D;
        if (eVar == null) {
            l.i("viewModel");
            throw null;
        }
        hVar.f1155a = eVar.b("");
        hVar.a();
        hVar.notifyDataSetChanged();
        SearchView searchView = this.f8497n;
        if (searchView != null) {
            searchView.setQuery("", false);
        }
        e eVar2 = this.D;
        if (eVar2 != null) {
            b(eVar2.c());
        } else {
            l.i("viewModel");
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b
    public final void e(i iVar) {
        String str;
        String str2;
        String str3;
        h8.d dVar = iVar.f1160a;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (!(dVar instanceof h8.i)) {
            if ((dVar instanceof h8.e) && activity.getSupportFragmentManager().findFragmentByTag("k") == null) {
                FragmentTransaction beginTransaction = activity.getSupportFragmentManager().beginTransaction();
                String str4 = dVar.f5466b;
                h8.e eVar = (h8.e) dVar;
                String a8 = eVar.a();
                String b7 = eVar.b();
                s5.d dVar2 = this.E;
                if (dVar2 == null) {
                    l.i("optionsViewModel");
                    throw null;
                }
                String str5 = dVar2.f.e().i;
                s5.d dVar3 = this.E;
                if (dVar3 == null) {
                    l.i("optionsViewModel");
                    throw null;
                }
                String str6 = dVar3.f.e().f5567n;
                int i = dVar.f5465a;
                int i6 = iVar.f1163d;
                e eVar2 = this.D;
                if (eVar2 != null) {
                    beginTransaction.add(d0.b.f(str4, a8, b7, str5, str6, i, i6, true, eVar2.j), "k").commit();
                    return;
                } else {
                    l.i("viewModel");
                    throw null;
                }
            }
            return;
        }
        if (activity.getSupportFragmentManager().findFragmentByTag("d") == null) {
            String str7 = dVar.f5466b;
            h8.i iVar2 = (h8.i) dVar;
            Set set = iVar2.f5481p;
            String str8 = iVar2.j;
            String str9 = iVar2.f5473c;
            e eVar3 = this.D;
            if (eVar3 == null) {
                l.i("viewModel");
                throw null;
            }
            String a10 = eVar3.a(iVar2.f5475e, 1);
            e eVar4 = this.D;
            if (eVar4 == null) {
                l.i("viewModel");
                throw null;
            }
            String a11 = eVar4.a(iVar2.g, 2);
            e eVar5 = this.D;
            if (eVar5 == null) {
                l.i("viewModel");
                throw null;
            }
            String a12 = eVar5.a(iVar2.h, 3);
            e eVar6 = this.D;
            if (eVar6 == null) {
                l.i("viewModel");
                throw null;
            }
            String a13 = eVar6.a(iVar2.i, 4);
            e eVar7 = this.D;
            if (eVar7 == null) {
                l.i("viewModel");
                throw null;
            }
            String a14 = eVar7.a(iVar2.f5479n, 5);
            if (str8.length() == 0) {
                h8.h hVar = (h8.h) q6.l.s0(set);
                str8 = hVar == null ? "" : hVar.f5471a;
            }
            e eVar8 = this.D;
            if (eVar8 == null) {
                l.i("viewModel");
                throw null;
            }
            f fVar = eVar8.f7892d;
            int i10 = iVar2.f5477l;
            if (i10 < 0) {
                str2 = "";
                str = str2;
            } else {
                float f = i10 / 86400.0f;
                if (f >= 1.0f) {
                    StringBuilder sb = new StringBuilder();
                    if (Float.isNaN(f)) {
                        com.google.gson.internal.a.p("Cannot round NaN value.");
                        return;
                    }
                    str = "";
                    sb.append(Math.round(f));
                    sb.append(' ');
                    sb.append(fVar.g().i);
                    str2 = sb.toString();
                } else {
                    str = "";
                    str2 = i10 + ' ' + fVar.g().j;
                }
            }
            e eVar9 = this.D;
            if (eVar9 == null) {
                l.i("viewModel");
                throw null;
            }
            f fVar2 = eVar9.f7892d;
            Boolean bool = iVar2.f5478m;
            String str10 = str2;
            String str11 = l.a(bool, Boolean.TRUE) ? fVar2.g().f5579m : l.a(bool, Boolean.FALSE) ? fVar2.g().f5580n : str;
            g2.c cVar = iVar2.f5480o;
            if (cVar == null || (str3 = Integer.valueOf(cVar.f5111a).toString()) == null) {
                str3 = str;
            }
            int i11 = dVar.f5465a;
            int i12 = iVar.f1163d;
            String str12 = iVar2.f5482q;
            String string = getString(2131952763);
            string.getClass();
            h8.h hVar2 = (h8.h) q6.l.s0(set);
            x5.b bVar = new x5.b(str7, str9, null, a10, a11, a12, a13, a14, str8, str10, str11, str3, i11, i12, str12, string, hVar2 == null ? str : hVar2.f5472b, 4);
            x5.d dVar4 = new x5.d();
            Bundle bundle = new Bundle();
            bundle.putParcelable("partner_detail_args", bVar);
            dVar4.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction().add(dVar4, "d").commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x01fd  */
    @Override // c.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(c.i r10) {
        /*
            Method dump skipped, instructions count: 517
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.d.f(c.i):void");
    }

    public final void g() {
        CharSequence query;
        SearchView searchView = this.f8497n;
        if (searchView == null || (query = searchView.getQuery()) == null) {
            return;
        }
        h hVar = this.F;
        if (hVar == null) {
            l.i("switchAdapter");
            throw null;
        }
        e eVar = this.D;
        if (eVar == null) {
            l.i("viewModel");
            throw null;
        }
        ArrayList b7 = eVar.b(query.toString());
        boolean z9 = query.length() > 0;
        hVar.f1155a = b7;
        if (!z9) {
            hVar.a();
        }
        hVar.notifyDataSetChanged();
    }

    @Override // p9.a, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ViewModelStore viewModelStore = getViewModelStore();
        viewModelStore.getClass();
        this.D = (e) new ViewModelProvider(viewModelStore, new b6.i(3)).get(e.class);
        ViewModelStore viewModelStore2 = activity.getViewModelStore();
        viewModelStore2.getClass();
        this.E = (s5.d) new ViewModelProvider(viewModelStore2, new b6.i(6)).get(s5.d.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View inflate = layoutInflater.inflate(2131558510, viewGroup, false);
        inflate.getClass();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        e eVar = this.D;
        if (eVar == null) {
            l.i("viewModel");
            throw null;
        }
        SearchView searchView = this.f8497n;
        eVar.f7894k = searchView == null ? false : searchView.hasFocus();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object, java.util.Collection] */
    @Override // p9.a, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Throwable th;
        SearchView searchView;
        Float f;
        Typeface typeface;
        Integer num;
        Typeface typeface2;
        Float f10;
        view.getClass();
        super.onViewCreated(view, bundle);
        this.f7888z = (ConstraintLayout) view.findViewById(2131362604);
        this.A = (Button) view.findViewById(2131361989);
        this.B = (Button) view.findViewById(2131361986);
        this.C = (RecyclerView) view.findViewById(2131363362);
        e eVar = this.D;
        if (eVar == null) {
            l.i("viewModel");
            throw null;
        }
        a0 viewModelScope = ViewModelKt.getViewModelScope(eVar);
        v7.e eVar2 = m0.f8288a;
        final int i = 2;
        c0.s(viewModelScope, v7.d.f10884a, null, new s(eVar, (t6.c) null, 24), 2);
        TextView textView = this.f8494b;
        if (textView != null) {
            e eVar3 = this.D;
            if (eVar3 == null) {
                l.i("viewModel");
                throw null;
            }
            textView.setText(eVar3.e().f5542a);
        }
        ImageView imageView = this.f8495l;
        final int i6 = 0;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: n.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ d f7877b;

                {
                    this.f7877b = this;
                }

                /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.Iterable, java.lang.Object] */
                /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Iterable, java.lang.Object] */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LinkedHashMap linkedHashMap;
                    LinkedHashMap linkedHashMap2;
                    int i10 = i6;
                    d dVar = this.f7877b;
                    switch (i10) {
                        case 0:
                            dVar.dismiss();
                            return;
                        case 1:
                            e eVar4 = dVar.D;
                            if (eVar4 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar = eVar4.f7889a;
                            h8.c cVar = mVar.f10737a;
                            if (cVar != null && (linkedHashMap = cVar.h) != null) {
                                for (Map.Entry entry : linkedHashMap.entrySet()) {
                                    if (!((h8.i) entry.getValue()).f5475e.isEmpty()) {
                                        mVar.C.unset(((h8.i) entry.getValue()).f5465a);
                                    }
                                }
                            }
                            for (l8.l lVar : eVar4.f7891c.f7228a) {
                                if (!lVar.g.isEmpty()) {
                                    mVar.D.unset(lVar.f7223a);
                                }
                            }
                            LinkedHashMap g = eVar4.g();
                            if (g != null) {
                                Iterator it = g.entrySet().iterator();
                                while (it.hasNext()) {
                                    mVar.f10750s.unset(Integer.parseInt((String) ((Map.Entry) it.next()).getKey()));
                                }
                            }
                            mVar.f10753w.unsetAllOwnedItems();
                            UUID uuid = q.f5065a;
                            m9.c.f();
                            q.f5066b.h(androidx.lifecycle.l.H(9), "_legitimatePurposesConsents");
                            dVar.d();
                            return;
                        default:
                            e eVar5 = dVar.D;
                            if (eVar5 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar2 = eVar5.f7889a;
                            h8.c cVar2 = mVar2.f10737a;
                            if (cVar2 != null && (linkedHashMap2 = cVar2.h) != null) {
                                for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                                    if (!((h8.i) entry2.getValue()).f5475e.isEmpty()) {
                                        mVar2.C.set(((h8.i) entry2.getValue()).f5465a);
                                    }
                                }
                            }
                            for (l8.l lVar2 : eVar5.f7891c.f7228a) {
                                if (!lVar2.g.isEmpty()) {
                                    mVar2.D.set(lVar2.f7223a);
                                }
                            }
                            LinkedHashMap g3 = eVar5.g();
                            if (g3 != null) {
                                Iterator it2 = g3.entrySet().iterator();
                                while (it2.hasNext()) {
                                    mVar2.f10750s.set(Integer.parseInt((String) ((Map.Entry) it2.next()).getKey()));
                                }
                            }
                            mVar2.f10753w.setAllOwnedItems();
                            UUID uuid2 = q.f5065a;
                            m9.c.f();
                            q.f5066b.h(androidx.lifecycle.l.H(8), "_legitimatePurposesConsents");
                            dVar.d();
                            return;
                    }
                }
            });
            e eVar4 = this.D;
            if (eVar4 == null) {
                l.i("viewModel");
                throw null;
            }
            imageView.setContentDescription(eVar4.e().f5547k);
        }
        e eVar5 = this.D;
        if (eVar5 == null) {
            l.i("viewModel");
            throw null;
        }
        final int i10 = 1;
        if (eVar5.f7891c.f7228a.isEmpty()) {
            th = null;
        } else {
            Toolbar toolbar = this.f8493a;
            final ImageView imageView2 = toolbar == null ? null : (ImageView) toolbar.findViewById(2131363547);
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            View inflate = LayoutInflater.from(getContext()).inflate(2131558670, (ViewGroup) null);
            final CardView cardView = (CardView) inflate.findViewById(2131362071);
            final TextView textView2 = (TextView) inflate.findViewById(2131363987);
            final TextView textView3 = (TextView) inflate.findViewById(2131363989);
            final TextView textView4 = (TextView) inflate.findViewById(2131363990);
            textView2.getClass();
            textView3.getClass();
            textView4.getClass();
            n9.a aVar = this.v;
            TextView[] textViewArr = {textView2, textView3, textView4};
            if (aVar == null || (typeface2 = aVar.f8119a) == null) {
                th = null;
            } else {
                th = null;
                int i11 = 0;
                while (i11 < 3) {
                    TextView textView5 = textViewArr[i11];
                    i11++;
                    if (textView5 != null) {
                        textView5.setTypeface(typeface2);
                    }
                }
            }
            if (aVar != null && (f10 = aVar.f8120b) != null) {
                float floatValue = f10.floatValue();
                int i12 = 0;
                while (i12 < 3) {
                    TextView textView6 = textViewArr[i12];
                    i12++;
                    if (textView6 != null) {
                        textView6.setTextSize(2, floatValue);
                    }
                }
            }
            final PopupWindow popupWindow = new PopupWindow(inflate, 600, -2, true);
            popupWindow.setElevation(10.0f);
            final int i13 = 0;
            textView2.setOnClickListener(new View.OnClickListener() { // from class: n.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i14 = i13;
                    d dVar = this;
                    PopupWindow popupWindow2 = popupWindow;
                    switch (i14) {
                        case 0:
                            popupWindow2.dismiss();
                            TextView textView7 = dVar.f8494b;
                            if (textView7 != null) {
                                textView7.setText(dVar.getString(2131952158));
                            }
                            e eVar6 = dVar.D;
                            if (eVar6 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            eVar6.j = 1;
                            dVar.g();
                            return;
                        case 1:
                            popupWindow2.dismiss();
                            TextView textView8 = dVar.f8494b;
                            if (textView8 != null) {
                                textView8.setText(dVar.getString(2131952159));
                            }
                            e eVar7 = dVar.D;
                            if (eVar7 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            eVar7.j = 2;
                            dVar.g();
                            return;
                        default:
                            popupWindow2.dismiss();
                            TextView textView9 = dVar.f8494b;
                            if (textView9 != null) {
                                textView9.setText(dVar.getString(2131952160));
                            }
                            e eVar8 = dVar.D;
                            if (eVar8 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            eVar8.j = 3;
                            dVar.g();
                            return;
                    }
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: n.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i14 = i10;
                    d dVar = this;
                    PopupWindow popupWindow2 = popupWindow;
                    switch (i14) {
                        case 0:
                            popupWindow2.dismiss();
                            TextView textView7 = dVar.f8494b;
                            if (textView7 != null) {
                                textView7.setText(dVar.getString(2131952158));
                            }
                            e eVar6 = dVar.D;
                            if (eVar6 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            eVar6.j = 1;
                            dVar.g();
                            return;
                        case 1:
                            popupWindow2.dismiss();
                            TextView textView8 = dVar.f8494b;
                            if (textView8 != null) {
                                textView8.setText(dVar.getString(2131952159));
                            }
                            e eVar7 = dVar.D;
                            if (eVar7 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            eVar7.j = 2;
                            dVar.g();
                            return;
                        default:
                            popupWindow2.dismiss();
                            TextView textView9 = dVar.f8494b;
                            if (textView9 != null) {
                                textView9.setText(dVar.getString(2131952160));
                            }
                            e eVar8 = dVar.D;
                            if (eVar8 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            eVar8.j = 3;
                            dVar.g();
                            return;
                    }
                }
            });
            textView4.setOnClickListener(new View.OnClickListener() { // from class: n.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i14 = i;
                    d dVar = this;
                    PopupWindow popupWindow2 = popupWindow;
                    switch (i14) {
                        case 0:
                            popupWindow2.dismiss();
                            TextView textView7 = dVar.f8494b;
                            if (textView7 != null) {
                                textView7.setText(dVar.getString(2131952158));
                            }
                            e eVar6 = dVar.D;
                            if (eVar6 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            eVar6.j = 1;
                            dVar.g();
                            return;
                        case 1:
                            popupWindow2.dismiss();
                            TextView textView8 = dVar.f8494b;
                            if (textView8 != null) {
                                textView8.setText(dVar.getString(2131952159));
                            }
                            e eVar7 = dVar.D;
                            if (eVar7 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            eVar7.j = 2;
                            dVar.g();
                            return;
                        default:
                            popupWindow2.dismiss();
                            TextView textView9 = dVar.f8494b;
                            if (textView9 != null) {
                                textView9.setText(dVar.getString(2131952160));
                            }
                            e eVar8 = dVar.D;
                            if (eVar8 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            eVar8.j = 3;
                            dVar.g();
                            return;
                    }
                }
            });
            if (imageView2 != null) {
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: n.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Integer num2;
                        Integer num3;
                        d dVar = d.this;
                        h9.d dVar2 = dVar.f8502s;
                        if (dVar2 != null && (num3 = dVar2.g) != null) {
                            cardView.setBackgroundTintList(ColorStateList.valueOf(num3.intValue()));
                        }
                        h9.d dVar3 = dVar.f8502s;
                        if (dVar3 != null && (num2 = dVar3.f5500k) != null) {
                            int intValue = num2.intValue();
                            textView2.setTextColor(ColorStateList.valueOf(intValue));
                            textView3.setTextColor(ColorStateList.valueOf(intValue));
                            textView4.setTextColor(ColorStateList.valueOf(intValue));
                        }
                        popupWindow.showAsDropDown(imageView2);
                    }
                });
            }
        }
        SearchView searchView2 = this.f8497n;
        if (searchView2 != null) {
            searchView2.setVisibility(0);
        }
        SearchView searchView3 = this.f8497n;
        if (searchView3 != null) {
            e eVar6 = this.D;
            if (eVar6 == null) {
                l.i("viewModel");
                throw th;
            }
            searchView3.setQueryHint(eVar6.e().f);
        }
        SearchView searchView4 = this.f8497n;
        if (searchView4 != null) {
            searchView4.setOnQueryTextListener(new g(this, 8));
        }
        e eVar7 = this.D;
        if (eVar7 == null) {
            l.i("viewModel");
            throw th;
        }
        ArrayList b7 = eVar7.b("");
        e eVar8 = this.D;
        if (eVar8 == null) {
            l.i("viewModel");
            throw th;
        }
        String str = eVar8.e().f5543b;
        e eVar9 = this.D;
        if (eVar9 == null) {
            l.i("viewModel");
            throw th;
        }
        String str2 = eVar9.e().f5544c;
        h9.d dVar = this.f8502s;
        this.F = new h(b7, (c.b) this, str, str2, (Integer) (dVar == null ? th : dVar.i), (Integer) (dVar == null ? th : dVar.f5499e), (Integer) (dVar == null ? th : dVar.f), (Integer) (dVar == null ? th : dVar.f5495a), this.f8503t, this.v);
        RecyclerView recyclerView = this.C;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            h hVar = this.F;
            if (hVar == null) {
                l.i("switchAdapter");
                throw th;
            }
            recyclerView.setAdapter(hVar);
        }
        Button button = this.B;
        if (button != null) {
            e eVar10 = this.D;
            if (eVar10 == null) {
                l.i("viewModel");
                throw th;
            }
            button.setText(eVar10.e().f5546e);
        }
        e eVar11 = this.D;
        if (eVar11 == null) {
            l.i("viewModel");
            throw th;
        }
        b(eVar11.c());
        Button button2 = this.B;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener(this) { // from class: n.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ d f7877b;

                {
                    this.f7877b = this;
                }

                /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.Iterable, java.lang.Object] */
                /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Iterable, java.lang.Object] */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LinkedHashMap linkedHashMap;
                    LinkedHashMap linkedHashMap2;
                    int i102 = i10;
                    d dVar2 = this.f7877b;
                    switch (i102) {
                        case 0:
                            dVar2.dismiss();
                            return;
                        case 1:
                            e eVar42 = dVar2.D;
                            if (eVar42 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar = eVar42.f7889a;
                            h8.c cVar = mVar.f10737a;
                            if (cVar != null && (linkedHashMap = cVar.h) != null) {
                                for (Map.Entry entry : linkedHashMap.entrySet()) {
                                    if (!((h8.i) entry.getValue()).f5475e.isEmpty()) {
                                        mVar.C.unset(((h8.i) entry.getValue()).f5465a);
                                    }
                                }
                            }
                            for (l8.l lVar : eVar42.f7891c.f7228a) {
                                if (!lVar.g.isEmpty()) {
                                    mVar.D.unset(lVar.f7223a);
                                }
                            }
                            LinkedHashMap g = eVar42.g();
                            if (g != null) {
                                Iterator it = g.entrySet().iterator();
                                while (it.hasNext()) {
                                    mVar.f10750s.unset(Integer.parseInt((String) ((Map.Entry) it.next()).getKey()));
                                }
                            }
                            mVar.f10753w.unsetAllOwnedItems();
                            UUID uuid = q.f5065a;
                            m9.c.f();
                            q.f5066b.h(androidx.lifecycle.l.H(9), "_legitimatePurposesConsents");
                            dVar2.d();
                            return;
                        default:
                            e eVar52 = dVar2.D;
                            if (eVar52 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar2 = eVar52.f7889a;
                            h8.c cVar2 = mVar2.f10737a;
                            if (cVar2 != null && (linkedHashMap2 = cVar2.h) != null) {
                                for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                                    if (!((h8.i) entry2.getValue()).f5475e.isEmpty()) {
                                        mVar2.C.set(((h8.i) entry2.getValue()).f5465a);
                                    }
                                }
                            }
                            for (l8.l lVar2 : eVar52.f7891c.f7228a) {
                                if (!lVar2.g.isEmpty()) {
                                    mVar2.D.set(lVar2.f7223a);
                                }
                            }
                            LinkedHashMap g3 = eVar52.g();
                            if (g3 != null) {
                                Iterator it2 = g3.entrySet().iterator();
                                while (it2.hasNext()) {
                                    mVar2.f10750s.set(Integer.parseInt((String) ((Map.Entry) it2.next()).getKey()));
                                }
                            }
                            mVar2.f10753w.setAllOwnedItems();
                            UUID uuid2 = q.f5065a;
                            m9.c.f();
                            q.f5066b.h(androidx.lifecycle.l.H(8), "_legitimatePurposesConsents");
                            dVar2.d();
                            return;
                    }
                }
            });
        }
        Button button3 = this.A;
        if (button3 != null) {
            e eVar12 = this.D;
            if (eVar12 == null) {
                l.i("viewModel");
                throw th;
            }
            button3.setText(eVar12.e().f5545d);
        }
        Button button4 = this.A;
        if (button4 != null) {
            button4.setOnClickListener(new View.OnClickListener(this) { // from class: n.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ d f7877b;

                {
                    this.f7877b = this;
                }

                /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.Iterable, java.lang.Object] */
                /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Iterable, java.lang.Object] */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LinkedHashMap linkedHashMap;
                    LinkedHashMap linkedHashMap2;
                    int i102 = i;
                    d dVar2 = this.f7877b;
                    switch (i102) {
                        case 0:
                            dVar2.dismiss();
                            return;
                        case 1:
                            e eVar42 = dVar2.D;
                            if (eVar42 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar = eVar42.f7889a;
                            h8.c cVar = mVar.f10737a;
                            if (cVar != null && (linkedHashMap = cVar.h) != null) {
                                for (Map.Entry entry : linkedHashMap.entrySet()) {
                                    if (!((h8.i) entry.getValue()).f5475e.isEmpty()) {
                                        mVar.C.unset(((h8.i) entry.getValue()).f5465a);
                                    }
                                }
                            }
                            for (l8.l lVar : eVar42.f7891c.f7228a) {
                                if (!lVar.g.isEmpty()) {
                                    mVar.D.unset(lVar.f7223a);
                                }
                            }
                            LinkedHashMap g = eVar42.g();
                            if (g != null) {
                                Iterator it = g.entrySet().iterator();
                                while (it.hasNext()) {
                                    mVar.f10750s.unset(Integer.parseInt((String) ((Map.Entry) it.next()).getKey()));
                                }
                            }
                            mVar.f10753w.unsetAllOwnedItems();
                            UUID uuid = q.f5065a;
                            m9.c.f();
                            q.f5066b.h(androidx.lifecycle.l.H(9), "_legitimatePurposesConsents");
                            dVar2.d();
                            return;
                        default:
                            e eVar52 = dVar2.D;
                            if (eVar52 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar2 = eVar52.f7889a;
                            h8.c cVar2 = mVar2.f10737a;
                            if (cVar2 != null && (linkedHashMap2 = cVar2.h) != null) {
                                for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                                    if (!((h8.i) entry2.getValue()).f5475e.isEmpty()) {
                                        mVar2.C.set(((h8.i) entry2.getValue()).f5465a);
                                    }
                                }
                            }
                            for (l8.l lVar2 : eVar52.f7891c.f7228a) {
                                if (!lVar2.g.isEmpty()) {
                                    mVar2.D.set(lVar2.f7223a);
                                }
                            }
                            LinkedHashMap g3 = eVar52.g();
                            if (g3 != null) {
                                Iterator it2 = g3.entrySet().iterator();
                                while (it2.hasNext()) {
                                    mVar2.f10750s.set(Integer.parseInt((String) ((Map.Entry) it2.next()).getKey()));
                                }
                            }
                            mVar2.f10753w.setAllOwnedItems();
                            UUID uuid2 = q.f5065a;
                            m9.c.f();
                            q.f5066b.h(androidx.lifecycle.l.H(8), "_legitimatePurposesConsents");
                            dVar2.d();
                            return;
                    }
                }
            });
        }
        h9.d dVar2 = this.f8502s;
        if (dVar2 != null && (num = dVar2.g) != null) {
            int intValue = num.intValue();
            ConstraintLayout constraintLayout = this.f7888z;
            if (constraintLayout != null) {
                constraintLayout.setBackgroundColor(intValue);
            }
        }
        Button button5 = this.B;
        if (button5 != null) {
            ColorStateList c9 = c();
            if (c9 != null) {
                button5.setTextColor(c9);
            }
            ColorStateList a8 = a();
            if (a8 != null) {
                button5.setBackgroundTintList(a8);
            }
        }
        Button button6 = this.A;
        if (button6 != null) {
            ColorStateList c10 = c();
            if (c10 != null) {
                button6.setTextColor(c10);
            }
            ColorStateList a10 = a();
            if (a10 != null) {
                button6.setBackgroundTintList(a10);
            }
        }
        n9.a aVar2 = this.f8504u;
        TextView[] textViewArr2 = {this.B, this.A};
        if (aVar2 != null && (typeface = aVar2.f8119a) != null) {
            int i14 = 0;
            while (i14 < 2) {
                TextView textView7 = textViewArr2[i14];
                i14++;
                if (textView7 != null) {
                    textView7.setTypeface(typeface);
                }
            }
        }
        if (aVar2 != null && (f = aVar2.f8120b) != null) {
            float floatValue2 = f.floatValue();
            int i15 = 0;
            while (i15 < 2) {
                TextView textView8 = textViewArr2[i15];
                i15++;
                if (textView8 != null) {
                    textView8.setTextSize(2, floatValue2);
                }
            }
        }
        e eVar13 = this.D;
        if (eVar13 == null) {
            l.i("viewModel");
            throw th;
        }
        if (!eVar13.f7894k || (searchView = this.f8497n) == null) {
            return;
        }
        searchView.requestFocus();
    }
}
