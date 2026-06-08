package g5;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import java.util.ArrayList;
import java.util.Iterator;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q extends RowsSupportFragment {

    /* renamed from: a, reason: collision with root package name */
    public x4.g f5349a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f5350b = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f5351l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f5352m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    public final ArrayObjectAdapter f5353n;

    /* renamed from: o, reason: collision with root package name */
    public int f5354o;

    public q() {
        ListRowPresenter listRowPresenter = new ListRowPresenter(0);
        listRowPresenter.setShadowEnabled(false);
        listRowPresenter.setSelectEffectEnabled(false);
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(listRowPresenter);
        this.f5353n = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
    }

    public static final void a(q qVar) {
        int i = qVar.f5354o;
        if (i < 3) {
            qVar.f5354o = i + 1;
            return;
        }
        ArrayList arrayList = qVar.f5351l;
        ArrayList arrayList2 = qVar.f5352m;
        if (!arrayList2.isEmpty()) {
            Object obj = arrayList2.get(0);
            obj.getClass();
            qVar.c((p2) obj);
        }
        if (!arrayList.isEmpty()) {
            qVar.b(arrayList, -2);
        }
        if (!arrayList2.isEmpty() && arrayList2.size() > 1) {
            Object obj2 = arrayList2.get(1);
            obj2.getClass();
            qVar.c((p2) obj2);
        }
        if (!arrayList.isEmpty()) {
            qVar.b(arrayList, -1);
        }
        if (!arrayList2.isEmpty() && arrayList2.size() > 2) {
            Object obj3 = arrayList2.get(2);
            obj3.getClass();
            qVar.c((p2) obj3);
        }
        if (!arrayList.isEmpty()) {
            qVar.b(arrayList, 521);
        }
        if (!arrayList.isEmpty()) {
            qVar.b(arrayList, 523);
        }
        if (!arrayList.isEmpty()) {
            qVar.b(arrayList, 524);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            p2 p2Var = (p2) next;
            if (qVar.getContext() != null) {
                HeaderItem headerItem = new HeaderItem(p2Var.f11329a.f11225b);
                Context requireContext = qVar.requireContext();
                requireContext.getClass();
                e5.g gVar = new e5.g();
                gVar.f4740a = requireContext;
                ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(gVar);
                arrayObjectAdapter.addAll(0, p2Var.f11330b);
                c5.c cVar = new c5.c();
                cVar.f2417a = p2Var.f11329a;
                arrayObjectAdapter.add(cVar);
                qVar.f5353n.add(new ListRow(headerItem, arrayObjectAdapter));
            }
        }
    }

    public final void b(ArrayList arrayList, int i) {
        Iterator it = arrayList.iterator();
        int i6 = 0;
        while (true) {
            if (!it.hasNext()) {
                i6 = -1;
                break;
            }
            int i10 = i6 + 1;
            p2 p2Var = (p2) it.next();
            if (p2Var.f11329a.f11224a != i) {
                i6 = i10;
            } else if (getContext() != null) {
                HeaderItem headerItem = new HeaderItem(p2Var.f11329a.f11225b);
                Context requireContext = requireContext();
                requireContext.getClass();
                e5.j jVar = new e5.j();
                jVar.f4742a = requireContext;
                ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(jVar);
                arrayObjectAdapter.addAll(0, p2Var.f11330b);
                c5.c cVar = new c5.c();
                cVar.f2417a = p2Var.f11329a;
                arrayObjectAdapter.add(cVar);
                this.f5353n.add(new ListRow(headerItem, arrayObjectAdapter));
            }
        }
        if (i6 >= 0) {
            arrayList.remove(i6);
        }
    }

    public final void c(p2 p2Var) {
        if (getContext() != null) {
            HeaderItem headerItem = new HeaderItem(p2Var.f11329a.f11225b);
            Context requireContext = requireContext();
            requireContext.getClass();
            e5.i iVar = new e5.i();
            iVar.f4741a = requireContext;
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(iVar);
            arrayObjectAdapter.addAll(0, p2Var.f11330b);
            c5.c cVar = new c5.c();
            cVar.f2417a = p2Var.f11329a;
            arrayObjectAdapter.add(cVar);
            this.f5353n.add(new ListRow(headerItem, arrayObjectAdapter));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f5349a != null && !this.f5350b.isEmpty()) {
            getMainFragmentAdapter().getFragmentHost().notifyDataReady(getMainFragmentAdapter());
            return;
        }
        o oVar = new o(this);
        if (getContext() != null) {
            Context requireContext = requireContext();
            requireContext.getClass();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            viewLifecycleOwner.getClass();
            new s4.s(requireContext, oVar, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner));
        }
    }

    @Override // androidx.leanback.app.RowsSupportFragment, androidx.leanback.app.BaseRowSupportFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        setOnItemViewClickedListener(new androidx.core.view.inputmethod.a(this, 22));
    }
}
