package u4;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.json.JSONObject;
import x4.g2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10425a;

    /* renamed from: b, reason: collision with root package name */
    public int f10426b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ d f10427l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ x4.g f10428m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(d dVar, x4.g gVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f10425a = i;
        this.f10427l = dVar;
        this.f10428m = gVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f10425a) {
            case 0:
                return new b(this.f10427l, this.f10428m, cVar, 0);
            default:
                return new b(this.f10427l, this.f10428m, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f10425a) {
        }
        return ((b) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object C;
        p6.x xVar;
        JSONObject jSONObject;
        AlertDialog.Builder builder;
        b5.m mVar;
        d dVar;
        TextView textView;
        String str;
        Object a8;
        int i = this.f10425a;
        p6.x xVar2 = p6.x.f8463a;
        x4.g gVar = this.f10428m;
        u6.a aVar = u6.a.f10762a;
        d dVar2 = this.f10427l;
        switch (i) {
            case 0:
                int i6 = this.f10426b;
                if (i6 == 0) {
                    p6.a.e(obj);
                    v7.e eVar = o7.m0.f8288a;
                    v7.d dVar3 = v7.d.f10884a;
                    s4.e0 e0Var = new s4.e0(dVar2, gVar, (t6.c) null);
                    this.f10426b = 1;
                    C = o7.c0.C(e0Var, dVar3, this);
                    if (C == aVar) {
                        return aVar;
                    }
                } else {
                    if (i6 != 1) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    p6.a.e(obj);
                    C = obj;
                }
                g2 g2Var = (g2) C;
                if (g2Var.b() || (jSONObject = g2Var.f11206d) == null) {
                    xVar = xVar2;
                    if (dVar2.getActivity() instanceof c4.k0) {
                        FragmentActivity activity = dVar2.getActivity();
                        activity.getClass();
                        String string = dVar2.getString(2131951998);
                        string.getClass();
                        ((c4.k0) activity).N(string);
                    }
                } else {
                    if (g2Var.f11204b == 202) {
                        String optString = jSONObject.optString("message", dVar2.getString(2131951998));
                        if ((dVar2.getActivity() instanceof c4.k0) && optString != null) {
                            FragmentActivity activity2 = dVar2.getActivity();
                            activity2.getClass();
                            ((c4.k0) activity2).N(optString);
                        }
                    } else {
                        String valueOf = String.valueOf(jSONObject);
                        if (dVar2.getActivity() != null && !dVar2.requireActivity().isFinishing() && (dVar2.getActivity() instanceof c4.k0)) {
                            FragmentActivity activity3 = dVar2.getActivity();
                            activity3.getClass();
                            ((c4.k0) activity3).Q();
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(dVar2.requireContext());
                            View inflate = dVar2.getLayoutInflater().inflate(2131558497, (ViewGroup) null, false);
                            int i10 = 2131363387;
                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(inflate, 2131363387);
                            if (scrollView != null) {
                                i10 = 2131363723;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363723);
                                if (textView2 != null) {
                                    i10 = 2131364110;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364110);
                                    if (textView3 != null) {
                                        b5.m mVar2 = new b5.m((LinearLayout) inflate, scrollView, textView2, textView3);
                                        textView2.setTypeface(f4.c.f4883x);
                                        JSONObject optJSONObject = new JSONObject(valueOf).optJSONObject("data");
                                        String optString2 = optJSONObject != null ? optJSONObject.optString("content", valueOf) : null;
                                        if (optString2 != null) {
                                            Context requireContext = dVar2.requireContext();
                                            ArrayList arrayList = new ArrayList(3);
                                            TextView.BufferType bufferType = TextView.BufferType.SPANNABLE;
                                            arrayList.add(new d6.c());
                                            arrayList.add(new d6.c());
                                            if (arrayList.isEmpty()) {
                                                androidx.privacysandbox.ads.adservices.customaudience.a.i("No plugins were added to this builder. Use #usePlugin method to add them");
                                            } else {
                                                ArrayList arrayList2 = new ArrayList(arrayList.size());
                                                HashSet hashSet = new HashSet(3);
                                                int size = arrayList.size();
                                                int i11 = 0;
                                                while (true) {
                                                    if (i11 < size) {
                                                        Object obj2 = arrayList.get(i11);
                                                        i11++;
                                                        d6.c cVar = (d6.c) obj2;
                                                        if (!arrayList2.contains(cVar)) {
                                                            if (hashSet.contains(cVar)) {
                                                                a3.b.l(hashSet, "Cyclic dependency chain found: ");
                                                            } else {
                                                                hashSet.add(cVar);
                                                                cVar.getClass();
                                                                hashSet.remove(cVar);
                                                                if (!arrayList2.contains(cVar)) {
                                                                    if (d6.c.class.isAssignableFrom(cVar.getClass())) {
                                                                        arrayList2.add(0, cVar);
                                                                    } else {
                                                                        arrayList2.add(cVar);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        ArrayList arrayList3 = new ArrayList();
                                                        ArrayList arrayList4 = new ArrayList();
                                                        ArrayList arrayList5 = new ArrayList();
                                                        LinkedHashSet linkedHashSet = y8.h.f11830p;
                                                        float f = requireContext.getResources().getDisplayMetrics().density;
                                                        d6.f fVar = new d6.f();
                                                        fVar.f3614d = (int) ((8 * f) + 0.5f);
                                                        fVar.f3611a = (int) ((24 * f) + 0.5f);
                                                        int i12 = (int) ((4 * f) + 0.5f);
                                                        fVar.f3612b = i12;
                                                        int i13 = (int) ((1 * f) + 0.5f);
                                                        fVar.f3613c = i13;
                                                        fVar.f3615e = i13;
                                                        fVar.f = i12;
                                                        e2.d dVar4 = new e2.d(3);
                                                        HashMap hashMap = new HashMap();
                                                        HashMap hashMap2 = new HashMap(3);
                                                        int size2 = arrayList2.size();
                                                        xVar = xVar2;
                                                        int i14 = 0;
                                                        while (i14 < size2) {
                                                            Object obj3 = arrayList2.get(i14);
                                                            int i15 = i14 + 1;
                                                            d6.c cVar2 = (d6.c) obj3;
                                                            cVar2.getClass();
                                                            hashMap.put(b9.v.class, new d6.b(cVar2));
                                                            hashMap.put(b9.u.class, new d6.a(6));
                                                            hashMap.put(b9.e.class, new d6.a(7));
                                                            hashMap.put(b9.b.class, new d6.a(8));
                                                            hashMap.put(b9.d.class, new d6.a(9));
                                                            hashMap.put(b9.f.class, new d6.a(10));
                                                            hashMap.put(b9.l.class, new d6.a(11));
                                                            hashMap.put(b9.k.class, new d6.a(12));
                                                            hashMap.put(b9.c.class, new d6.a(14));
                                                            hashMap.put(b9.r.class, new d6.a(14));
                                                            hashMap.put(b9.p.class, new d6.a(13));
                                                            hashMap.put(b9.w.class, new d6.a(0));
                                                            hashMap.put(b9.h.class, new d6.a(1));
                                                            hashMap.put(b9.t.class, new d6.a(2));
                                                            hashMap.put(b9.g.class, new d6.a(3));
                                                            hashMap.put(b9.s.class, new d6.a(4));
                                                            hashMap.put(b9.m.class, new d6.a(5));
                                                            e6.a aVar2 = new e6.a(1);
                                                            hashMap2.put(b9.u.class, new e6.a(7));
                                                            hashMap2.put(b9.e.class, new e6.a(3));
                                                            hashMap2.put(b9.b.class, new e6.a(0));
                                                            hashMap2.put(b9.d.class, new e6.a(2));
                                                            hashMap2.put(b9.f.class, aVar2);
                                                            hashMap2.put(b9.l.class, aVar2);
                                                            hashMap2.put(b9.p.class, new e6.a(6));
                                                            hashMap2.put(b9.h.class, new e6.a(4));
                                                            hashMap2.put(b9.m.class, new e6.a(5));
                                                            hashMap2.put(b9.w.class, new e6.a(8));
                                                            i14 = i15;
                                                            linkedHashSet = linkedHashSet;
                                                            size2 = size2;
                                                            arrayList2 = arrayList2;
                                                            builder2 = builder2;
                                                            textView3 = textView3;
                                                            dVar2 = dVar2;
                                                            mVar2 = mVar2;
                                                            optString2 = optString2;
                                                            arrayList4 = arrayList4;
                                                            hashMap = hashMap;
                                                            arrayList3 = arrayList3;
                                                        }
                                                        String str2 = optString2;
                                                        builder = builder2;
                                                        ArrayList arrayList6 = arrayList3;
                                                        b5.m mVar3 = mVar2;
                                                        dVar = dVar2;
                                                        ArrayList arrayList7 = arrayList4;
                                                        LinkedHashSet linkedHashSet2 = linkedHashSet;
                                                        textView = textView3;
                                                        HashMap hashMap3 = hashMap;
                                                        ArrayList arrayList8 = arrayList2;
                                                        d6.f fVar2 = new d6.f();
                                                        fVar2.f3611a = fVar.f3611a;
                                                        fVar2.f3612b = fVar.f3612b;
                                                        fVar2.f3613c = fVar.f3613c;
                                                        fVar2.f3614d = fVar.f3614d;
                                                        fVar2.f3615e = fVar.f3615e;
                                                        fVar2.f = fVar.f;
                                                        a3.d dVar5 = new a3.d(DesugarCollections.unmodifiableMap(hashMap2), 19);
                                                        dVar4.f4466b = fVar2;
                                                        dVar4.f4472q = dVar5;
                                                        if (((e1.c0) dVar4.f4467l) == null) {
                                                            dVar4.f4467l = new e1.c0(11);
                                                        }
                                                        if (((e1.c0) dVar4.f4468m) == null) {
                                                            dVar4.f4468m = new e1.c0(18);
                                                        }
                                                        if (((q2.e) dVar4.f4469n) == null) {
                                                            dVar4.f4469n = new q2.e(6);
                                                        }
                                                        if (((e1.c0) dVar4.f4470o) == null) {
                                                            dVar4.f4470o = new e1.c0(15);
                                                        }
                                                        if (((e1.c0) dVar4.f4471p) == null) {
                                                            dVar4.f4471p = new e1.c0(12);
                                                        }
                                                        a4.d0 d0Var = new a4.d0(dVar4);
                                                        LinkedHashSet linkedHashSet3 = y8.h.f11830p;
                                                        ArrayList arrayList9 = new ArrayList();
                                                        arrayList9.addAll(arrayList6);
                                                        Iterator it = linkedHashSet2.iterator();
                                                        while (it.hasNext()) {
                                                            arrayList9.add(y8.h.f11831q.get((Class) it.next()));
                                                        }
                                                        q2.e eVar2 = new q2.e(7);
                                                        new y8.m(new m8.q(26, arrayList7, Collections.EMPTY_MAP));
                                                        List unmodifiableList = DesugarCollections.unmodifiableList(arrayList8);
                                                        Iterator it2 = unmodifiableList.iterator();
                                                        while (it2.hasNext()) {
                                                            ((d6.c) it2.next()).getClass();
                                                        }
                                                        y8.h hVar = new y8.h(arrayList9, eVar2, arrayList7);
                                                        int i16 = 0;
                                                        while (true) {
                                                            int length = str2.length();
                                                            int i17 = i16;
                                                            while (true) {
                                                                if (i17 < length) {
                                                                    str = str2;
                                                                    char charAt = str.charAt(i17);
                                                                    if (charAt != '\n' && charAt != '\r') {
                                                                        i17++;
                                                                        str2 = str;
                                                                    }
                                                                } else {
                                                                    str = str2;
                                                                    i17 = -1;
                                                                }
                                                            }
                                                            if (i17 != -1) {
                                                                hVar.i(str.substring(i16, i17));
                                                                i16 = i17 + 1;
                                                                if (i16 < str.length() && str.charAt(i17) == '\r') {
                                                                    if (str.charAt(i16) == '\n') {
                                                                        i16 = i17 + 2;
                                                                    }
                                                                    str2 = str;
                                                                }
                                                                str2 = str;
                                                            } else {
                                                                if (str.length() > 0 && (i16 == 0 || i16 < str.length())) {
                                                                    hVar.i(str.substring(i16));
                                                                }
                                                                hVar.f(hVar.f11840n);
                                                                m8.q qVar = new m8.q(26, hVar.f11837k, hVar.f11839m);
                                                                hVar.j.getClass();
                                                                y8.m mVar4 = new y8.m(qVar);
                                                                Iterator it3 = hVar.f11841o.iterator();
                                                                while (it3.hasNext()) {
                                                                    ((d9.a) it3.next()).f(mVar4);
                                                                }
                                                                b9.i iVar = (b9.i) hVar.f11838l.f11829b;
                                                                Iterator it4 = arrayList5.iterator();
                                                                if (it4.hasNext()) {
                                                                    it4.next().getClass();
                                                                    com.google.gson.internal.a.o();
                                                                } else {
                                                                    Iterator it5 = unmodifiableList.iterator();
                                                                    while (it5.hasNext()) {
                                                                        ((d6.c) it5.next()).getClass();
                                                                    }
                                                                    y2.s sVar = new y2.s(d0Var, new f0.i(18), new c6.e(), DesugarCollections.unmodifiableMap(hashMap3), new q2.e(5));
                                                                    sVar.E(iVar);
                                                                    Iterator it6 = unmodifiableList.iterator();
                                                                    while (it6.hasNext()) {
                                                                        ((d6.c) it6.next()).getClass();
                                                                    }
                                                                    c6.e eVar3 = (c6.e) sVar.f11757m;
                                                                    SpannableStringBuilder dVar6 = new c6.d(eVar3.f2423a);
                                                                    Iterator it7 = eVar3.f2424b.iterator();
                                                                    while (it7.hasNext()) {
                                                                        c6.c cVar3 = (c6.c) it7.next();
                                                                        dVar6.setSpan(cVar3.f2419a, cVar3.f2420b, cVar3.f2421c, cVar3.f2422d);
                                                                    }
                                                                    if (TextUtils.isEmpty(dVar6) && !TextUtils.isEmpty(str)) {
                                                                        dVar6 = new SpannableStringBuilder(str);
                                                                    }
                                                                    mVar = mVar3;
                                                                    ((TextView) mVar.f1063m).setText(dVar6);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            return null;
                                        }
                                        xVar = xVar2;
                                        builder = builder2;
                                        mVar = mVar2;
                                        dVar = dVar2;
                                        textView = textView3;
                                        d dVar7 = dVar;
                                        ((ScrollView) mVar.f1062l).post(new androidx.browser.trusted.c(24, dVar7, mVar));
                                        TextView textView4 = textView;
                                        textView4.setTypeface(f4.c.f4882w);
                                        textView4.setText(dVar7.getString(R.string.ok));
                                        textView4.setOnClickListener(new a(dVar7, 1));
                                        AlertDialog.Builder builder3 = builder;
                                        builder3.setView((LinearLayout) mVar.f1061b);
                                        AlertDialog create = builder3.create();
                                        FragmentActivity activity4 = dVar7.getActivity();
                                        activity4.getClass();
                                        ((c4.k0) activity4).F = create;
                                        if (!dVar7.requireActivity().isFinishing()) {
                                            Window window = create.getWindow();
                                            if (window != null) {
                                                a4.x.y(window, 0);
                                            }
                                            create.show();
                                        }
                                    }
                                }
                            }
                            com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
                            return null;
                        }
                    }
                    xVar = xVar2;
                }
                return xVar;
            default:
                int i18 = this.f10426b;
                if (i18 == 0) {
                    p6.a.e(obj);
                    Context requireContext2 = dVar2.requireContext();
                    requireContext2.getClass();
                    e1.s0 s0Var = new e1.s0(requireContext2, gVar.f11158a);
                    this.f10426b = 1;
                    a8 = s0Var.a(this);
                    if (a8 == aVar) {
                        return aVar;
                    }
                } else {
                    if (i18 != 1) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    p6.a.e(obj);
                    a8 = ((p6.k) obj).f8444a;
                }
                if (!(a8 instanceof p6.j)) {
                    x4.g gVar2 = (x4.g) a8;
                    String str3 = gVar2.F;
                    if (str3 != null) {
                        a5.e.b(str3, "listado_categoria");
                    }
                    Context requireContext3 = dVar2.requireContext();
                    requireContext3.getClass();
                    FragmentActivity requireActivity = dVar2.requireActivity();
                    requireActivity.getClass();
                    d0.b.j(requireContext3, (c4.k0) requireActivity, new m8.q(17, dVar2, gVar2), gVar2, true);
                }
                Throwable a10 = p6.k.a(a8);
                if (a10 == null) {
                    return xVar2;
                }
                int i19 = s4.y0.f9323l;
                if (d0.b.J(a10)) {
                    if (!(dVar2.getActivity() instanceof c4.k0)) {
                        return xVar2;
                    }
                    FragmentActivity activity5 = dVar2.getActivity();
                    activity5.getClass();
                    ((c4.k0) activity5).J();
                    return xVar2;
                }
                if (!(dVar2.getActivity() instanceof c4.k0)) {
                    return xVar2;
                }
                String message = a10.getMessage();
                if (message == null || message.length() == 0) {
                    FragmentActivity activity6 = dVar2.getActivity();
                    activity6.getClass();
                    String string2 = dVar2.getString(2131951992);
                    string2.getClass();
                    ((c4.k0) activity6).N(string2);
                    return xVar2;
                }
                FragmentActivity activity7 = dVar2.getActivity();
                activity7.getClass();
                String message2 = a10.getMessage();
                message2.getClass();
                ((c4.k0) activity7).N(message2);
                return xVar2;
        }
    }
}
