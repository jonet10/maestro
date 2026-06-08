package c4;

import android.content.Context;
import android.widget.Filter;
import com.uptodown.activities.SearchActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o9 extends Filter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchActivity f1960a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p9 f1961b;

    public o9(SearchActivity searchActivity, p9 p9Var) {
        this.f1960a = searchActivity;
        this.f1961b = p9Var;
    }

    @Override // android.widget.Filter
    public final CharSequence convertResultToString(Object obj) {
        obj.getClass();
        String str = ((x4.z1) obj).f11479a;
        str.getClass();
        return str;
    }

    @Override // android.widget.Filter
    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        charSequence.getClass();
        e1.c0 c0Var = j5.g.D;
        Context applicationContext = this.f1960a.getApplicationContext();
        applicationContext.getClass();
        j5.g l10 = c0Var.l(applicationContext);
        l10.b();
        ArrayList V = l10.V();
        l10.c();
        if (charSequence.length() > 0) {
            ArrayList arrayList = new ArrayList();
            int size = V.size();
            for (int i = 0; i < size; i++) {
                String str = ((x4.z1) V.get(i)).f11479a;
                if (str != null && l7.m.q0(str, charSequence, false)) {
                    arrayList.add(V.get(i));
                }
            }
            V = arrayList;
        }
        Filter.FilterResults filterResults = new Filter.FilterResults();
        filterResults.values = V;
        filterResults.count = V.size();
        return filterResults;
    }

    @Override // android.widget.Filter
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        charSequence.getClass();
        filterResults.getClass();
        p9 p9Var = this.f1961b;
        p9Var.clear();
        Object obj = filterResults.values;
        obj.getClass();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            p9Var.add((x4.z1) it.next());
        }
        int i = filterResults.count;
        p9 p9Var2 = this.f1960a.T;
        if (i > 0) {
            p9Var2.getClass();
            p9Var2.notifyDataSetChanged();
        } else {
            p9Var2.getClass();
            p9Var2.notifyDataSetInvalidated();
        }
    }
}
