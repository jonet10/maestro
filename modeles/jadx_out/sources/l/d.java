package l;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;
import c.h;
import c.i;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.core.model.gbc.GoogleBasicConsents;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class d extends Fragment implements c.b {

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f7033p = 0;

    /* renamed from: a, reason: collision with root package name */
    public TextView f7034a;

    /* renamed from: b, reason: collision with root package name */
    public RecyclerView f7035b;

    /* renamed from: l, reason: collision with root package name */
    public c f7036l;

    /* renamed from: m, reason: collision with root package name */
    public h9.d f7037m;

    /* renamed from: n, reason: collision with root package name */
    public n9.a f7038n;

    /* renamed from: o, reason: collision with root package name */
    public n9.a f7039o;

    public final void a() {
        c cVar = this.f7036l;
        if (cVar == null) {
            l.i("viewModel");
            throw null;
        }
        RecyclerView recyclerView = this.f7035b;
        RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        if (adapter == null) {
            com.google.gson.internal.a.i("null cannot be cast to non-null type com.inmobi.cmp.presentation.components.switchlist.SwitchAdapter");
            return;
        }
        ArrayList arrayList = ((h) adapter).f1155a;
        arrayList.getClass();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            i iVar = (i) obj;
            Boolean bool = iVar.f1161b;
            h8.d dVar = iVar.f1160a;
            if (l.a(bool, Boolean.TRUE)) {
                boolean z9 = g.f7044a;
                int i6 = dVar.f5465a;
                GBCConsentValue.GRANTED.getClass();
                g.f7045b.set(i6);
            } else {
                boolean z10 = g.f7044a;
                int i10 = dVar.f5465a;
                GBCConsentValue gBCConsentValue = GBCConsentValue.DENIED;
                gBCConsentValue.getClass();
                if (gBCConsentValue == GBCConsentValue.GRANTED) {
                    g.f7045b.set(i10);
                } else {
                    g.f7045b.unset(i10);
                }
            }
        }
        l9.a aVar = cVar.f7029a;
        boolean z11 = g.f7044a;
        Vector k5 = aVar.k(40);
        Vector vector = g.f7045b;
        vector.getClass();
        if (k5 != null) {
            k5.forEach(new e(0, vector));
        }
        aVar.e(40, vector);
        ChoiceCmpCallback choiceCmpCallback = cVar.f7030b;
        if (choiceCmpCallback == null) {
            return;
        }
        choiceCmpCallback.onGoogleBasicConsentChange(new GoogleBasicConsents(c.a("adStorage", arrayList), c.a("adUserData", arrayList), c.a("adPersonalization", arrayList), c.a("analyticsStorage", arrayList)));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() == null) {
            return;
        }
        ViewModelStore viewModelStore = getViewModelStore();
        viewModelStore.getClass();
        this.f7036l = (c) new ViewModelProvider(viewModelStore, new b6.i(1)).get(c.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View inflate = layoutInflater.inflate(2131558565, viewGroup, false);
        inflate.getClass();
        return inflate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Iterable, java.lang.Object] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Throwable th;
        int i;
        Object obj;
        boolean z9;
        Float f;
        Typeface typeface;
        TextView textView;
        Integer num;
        view.getClass();
        super.onViewCreated(view, bundle);
        this.f7034a = (TextView) view.findViewById(2131363894);
        this.f7035b = (RecyclerView) view.findViewById(2131363325);
        this.f7037m = m9.c.f7860d;
        this.f7038n = o6.e.f8226c;
        this.f7039o = o6.e.f8227d;
        TextView textView2 = this.f7034a;
        if (textView2 != null) {
            c cVar = this.f7036l;
            if (cVar == null) {
                l.i("viewModel");
                throw null;
            }
            String str = cVar.f7031c.f6983b.f6977b;
            if (str.length() == 0) {
                str = getString(2131952053);
                str.getClass();
            }
            textView2.setText(str);
        }
        RecyclerView recyclerView = this.f7035b;
        if (recyclerView == null) {
            i = 1;
            th = null;
        } else {
            c cVar2 = this.f7036l;
            if (cVar2 == null) {
                l.i("viewModel");
                throw null;
            }
            ArrayList arrayList = new ArrayList();
            Vector k5 = cVar2.f7029a.k(40);
            for (k6.b bVar : cVar2.f7031c.f6984c) {
                int intValue = bVar.f6980a.intValue();
                Iterator it = cVar2.f7032d.f7242q.f7197b.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((l8.g) obj).f7194a == intValue) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                l8.g gVar = (l8.g) obj;
                if (gVar != null) {
                    int i6 = gVar.f7194a;
                    String str2 = bVar.f6981b.f6976a;
                    if (str2 == null) {
                        str2 = "";
                    }
                    h8.d dVar = new h8.d(intValue, str2);
                    if (k5 != null && k5.contains(i6)) {
                        Boolean bool = k5.get(i6);
                        if (bool != null) {
                            z9 = bool.booleanValue();
                            arrayList.add(new i(dVar, Boolean.valueOf(z9), 0, 9, null, null, 116));
                        }
                        z9 = false;
                        arrayList.add(new i(dVar, Boolean.valueOf(z9), 0, 9, null, null, 116));
                    } else {
                        if (gVar.f7195b == GBCConsentValue.GRANTED) {
                            z9 = true;
                            arrayList.add(new i(dVar, Boolean.valueOf(z9), 0, 9, null, null, 116));
                        }
                        z9 = false;
                        arrayList.add(new i(dVar, Boolean.valueOf(z9), 0, 9, null, null, 116));
                    }
                }
            }
            th = null;
            h9.d dVar2 = this.f7037m;
            i = 1;
            recyclerView.setAdapter(new h(arrayList, this, (String) null, dVar2 == null ? null : dVar2.i, dVar2 == null ? null : dVar2.f5499e, dVar2 == null ? null : dVar2.f, dVar2 == null ? null : dVar2.f5495a, this.f7038n, this.f7039o, 12));
        }
        h9.d dVar3 = this.f7037m;
        if (dVar3 != null) {
            Integer num2 = dVar3.g;
            if (num2 != null) {
                view.setBackgroundColor(num2.intValue());
            }
            Integer num3 = dVar3.i;
            if (num3 != null) {
                int intValue2 = num3.intValue();
                TextView textView3 = this.f7034a;
                if (textView3 != null) {
                    textView3.setTextColor(intValue2);
                }
            }
        }
        h9.d dVar4 = this.f7037m;
        if (dVar4 != null && (num = dVar4.f5495a) != null) {
            int intValue3 = num.intValue();
            View findViewById = view.findViewById(2131362203);
            if (findViewById != null) {
                findViewById.setBackgroundTintList(ColorStateList.valueOf(intValue3));
            }
        }
        n9.a aVar = this.f7038n;
        TextView[] textViewArr = new TextView[i];
        textViewArr[0] = this.f7034a;
        if (aVar != null && (typeface = aVar.f8119a) != null && (textView = textViewArr[0]) != null) {
            textView.setTypeface(typeface);
        }
        if (aVar != null && (f = aVar.f8120b) != null) {
            float floatValue = f.floatValue();
            TextView textView4 = textViewArr[0];
            if (textView4 != null) {
                textView4.setTextSize(2, floatValue);
            }
        }
        c cVar3 = this.f7036l;
        if (cVar3 == null) {
            l.i("viewModel");
            throw th;
        }
        cVar3.f7029a.g(92, i);
    }

    @Override // c.b
    public final void e(i iVar) {
    }

    @Override // c.b
    public final void f(i iVar) {
    }
}
