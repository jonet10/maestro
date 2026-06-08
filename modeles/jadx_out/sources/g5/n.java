package g5;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import java.util.ArrayList;
import java.util.Iterator;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n extends RowsSupportFragment {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5337a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayObjectAdapter f5338b;

    public n() {
        ListRowPresenter listRowPresenter = new ListRowPresenter(0);
        listRowPresenter.setShadowEnabled(false);
        listRowPresenter.setSelectEffectEnabled(false);
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(listRowPresenter);
        this.f5338b = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
    }

    public final void a(ArrayList arrayList, int i) {
        Iterator it = arrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            p2 p2Var = (p2) next;
            if (p2Var.f11329a.f11224a == i) {
                if (getContext() != null) {
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
                    this.f5338b.add(new ListRow(headerItem, arrayObjectAdapter));
                } else {
                    this.f5337a = false;
                }
                arrayList.remove(p2Var);
                return;
            }
        }
    }

    public final void b(ArrayList arrayList, int i) {
        Iterator it = arrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            p2 p2Var = (p2) next;
            if (p2Var.f11329a.f11224a == i) {
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
                    this.f5338b.add(new ListRow(headerItem, arrayObjectAdapter));
                } else {
                    this.f5337a = false;
                }
                arrayList.remove(p2Var);
                return;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f5337a) {
            return;
        }
        this.f5338b.clear();
        l lVar = new l(this);
        if (getContext() != null) {
            Context requireContext = requireContext();
            requireContext.getClass();
            b5.m mVar = new b5.m(requireContext, lVar);
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
            lifecycleScope.getClass();
            o7.c0.s(lifecycleScope, null, null, new b.s(mVar, (t6.c) null, 1), 3);
        }
    }

    @Override // androidx.leanback.app.RowsSupportFragment, androidx.leanback.app.BaseRowSupportFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        setOnItemViewClickedListener(new androidx.core.view.inputmethod.a(this, 21));
    }
}
