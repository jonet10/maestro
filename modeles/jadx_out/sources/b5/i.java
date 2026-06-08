package b5;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import d7.p;
import g5.n;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.v;
import kotlin.jvm.internal.x;
import o7.a0;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i extends v6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f1039a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f1040b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ x f1041l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1042m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ v f1043n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(m mVar, x xVar, x xVar2, ArrayList arrayList, v vVar, t6.c cVar) {
        super(2, cVar);
        this.f1039a = mVar;
        this.f1040b = xVar;
        this.f1041l = xVar2;
        this.f1042m = arrayList;
        this.f1043n = vVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new i(this.f1039a, this.f1040b, this.f1041l, this.f1042m, this.f1043n, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        i iVar = (i) create((a0) obj, (t6.c) obj2);
        p6.x xVar = p6.x.f8463a;
        iVar.invokeSuspend(xVar);
        return xVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction replace;
        FragmentTransaction addToBackStack;
        p6.a.e(obj);
        g5.l lVar = (g5.l) this.f1039a.f1062l;
        ArrayList arrayList = (ArrayList) this.f1040b.f7024a;
        ArrayList arrayList2 = (ArrayList) this.f1041l.f7024a;
        int i = this.f1043n.f7022a;
        arrayList.getClass();
        arrayList2.getClass();
        ArrayList arrayList3 = this.f1042m;
        arrayList3.getClass();
        n nVar = lVar.f5329a;
        if (i <= 1) {
            nVar.f5337a = true;
            if (!arrayList3.isEmpty()) {
                nVar.a(arrayList3, -2);
            }
            if (!arrayList3.isEmpty()) {
                nVar.b(arrayList3, -1);
            }
            if (!arrayList2.isEmpty() && ((x4.j) arrayList2.get(0)).f11229o == 523) {
                if (!arrayList3.isEmpty()) {
                    nVar.b(arrayList3, 558);
                }
                if (!arrayList3.isEmpty()) {
                    nVar.b(arrayList3, 566);
                }
                if (!arrayList3.isEmpty()) {
                    nVar.b(arrayList3, 562);
                }
                if (!arrayList3.isEmpty()) {
                    nVar.b(arrayList3, 564);
                }
                if (!arrayList3.isEmpty()) {
                    nVar.b(arrayList3, 559);
                }
                if (!arrayList3.isEmpty()) {
                    nVar.a(arrayList3, 645);
                }
                if (!arrayList3.isEmpty()) {
                    nVar.b(arrayList3, 560);
                }
                if (!arrayList3.isEmpty()) {
                    nVar.a(arrayList3, 561);
                }
                if (!arrayList3.isEmpty()) {
                    nVar.b(arrayList3, 565);
                }
                if (!arrayList3.isEmpty()) {
                    nVar.a(arrayList3, 593);
                }
                if (!arrayList3.isEmpty()) {
                    nVar.a(arrayList3, 568);
                }
            }
            if (!arrayList3.isEmpty()) {
                Iterator it = arrayList3.iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    p2 p2Var = (p2) next;
                    if (nVar.getContext() != null) {
                        HeaderItem headerItem = new HeaderItem(p2Var.f11329a.f11225b);
                        Context requireContext = nVar.requireContext();
                        requireContext.getClass();
                        e5.g gVar = new e5.g();
                        gVar.f4740a = requireContext;
                        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(gVar);
                        arrayObjectAdapter.addAll(0, p2Var.f11330b);
                        c5.c cVar = new c5.c();
                        cVar.f2417a = p2Var.f11329a;
                        arrayObjectAdapter.add(cVar);
                        nVar.f5338b.add(new ListRow(headerItem, arrayObjectAdapter));
                    } else {
                        nVar.f5337a = false;
                    }
                }
            }
            nVar.getMainFragmentAdapter().getFragmentHost().notifyDataReady(nVar.getMainFragmentAdapter());
        } else {
            nVar.f5337a = false;
            g5.k kVar = new g5.k();
            FragmentActivity activity = nVar.getActivity();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (replace = beginTransaction.replace(2131362197, kVar)) != null && (addToBackStack = replace.addToBackStack(null)) != null) {
                addToBackStack.commit();
            }
        }
        return p6.x.f8463a;
    }
}
