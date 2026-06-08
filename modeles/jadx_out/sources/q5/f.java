package q5;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.l;
import q6.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class f implements Observer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8704a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p9.a f8705b;

    public /* synthetic */ f(p9.a aVar, int i) {
        this.f8704a = i;
        this.f8705b = aVar;
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [java.lang.Object, java.util.Map] */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        TextView textView;
        ArrayList arrayList;
        int i = this.f8704a;
        p9.a aVar = this.f8705b;
        switch (i) {
            case 0:
                g gVar = (g) aVar;
                FragmentActivity activity = gVar.getActivity();
                if (activity == null) {
                    return;
                }
                t0.f.b(activity, new o9.a(gVar, 1));
                return;
            default:
                x5.d dVar = (x5.d) aVar;
                h9.f fVar = (h9.f) obj;
                x5.e eVar = dVar.U;
                if (eVar == null) {
                    l.i("viewModel");
                    throw null;
                }
                fVar.getClass();
                ArrayList arrayList2 = eVar.f11514d;
                arrayList2.clear();
                ArrayList arrayList3 = fVar.f5511a;
                int size = arrayList3.size();
                int i6 = 0;
                while (i6 < size) {
                    Object obj2 = arrayList3.get(i6);
                    i6++;
                    h9.h hVar = (h9.h) obj2;
                    String str = hVar.f5532a;
                    String str2 = hVar.f5533b;
                    String valueOf = String.valueOf(hVar.f5534c);
                    String str3 = hVar.f5535d;
                    ArrayList arrayList4 = hVar.f5536e;
                    int size2 = arrayList4.size();
                    String str4 = "";
                    int i10 = 0;
                    int i11 = 0;
                    while (i10 < size2) {
                        Object obj3 = arrayList4.get(i10);
                        int i12 = i10 + 1;
                        int i13 = i11 + 1;
                        if (i11 < 0) {
                            m.h0();
                            throw null;
                        }
                        int intValue = ((Number) obj3).intValue();
                        h8.c cVar = eVar.f11511a.f10737a;
                        if (cVar == null) {
                            arrayList = arrayList3;
                        } else {
                            arrayList = arrayList3;
                            h8.f fVar2 = (h8.f) cVar.f5462d.get(String.valueOf(intValue));
                            if (fVar2 != null) {
                                String g = l.g(String.format("• %s.", Arrays.copyOf(new Object[]{fVar2.f5466b}, 1)), str4);
                                if (i11 != arrayList4.size() - 1) {
                                    g = l.g("\n", g);
                                }
                                str4 = g;
                            }
                        }
                        i11 = i13;
                        i10 = i12;
                        arrayList3 = arrayList;
                    }
                    arrayList2.add(new p9.g(str, str2, valueOf, str3, str4));
                }
                x5.e eVar2 = dVar.U;
                if (eVar2 == null) {
                    l.i("viewModel");
                    throw null;
                }
                if (eVar2.f11514d.isEmpty()) {
                    TextView textView2 = dVar.R;
                    if (textView2 != null) {
                        x5.b bVar = dVar.T;
                        if (bVar == null) {
                            l.i("args");
                            throw null;
                        }
                        textView2.setText(bVar.f11506y);
                    }
                    Context context = dVar.getContext();
                    if (context == null || (textView = dVar.R) == null) {
                        return;
                    }
                    textView.setTextColor(ContextCompat.getColor(context, 2131099741));
                    return;
                }
                FragmentActivity activity2 = dVar.getActivity();
                if (activity2 != null && activity2.getSupportFragmentManager().findFragmentByTag("d") == null) {
                    FragmentTransaction beginTransaction = activity2.getSupportFragmentManager().beginTransaction();
                    x5.e eVar3 = dVar.U;
                    if (eVar3 == null) {
                        l.i("viewModel");
                        throw null;
                    }
                    v5.b bVar2 = new v5.b(eVar3.f11514d);
                    v5.d dVar2 = new v5.d();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("partner_disclosure_args", bVar2);
                    dVar2.setArguments(bundle);
                    beginTransaction.add(dVar2, "d").commit();
                    return;
                }
                return;
        }
    }
}
