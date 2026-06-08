package c4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MyDownloads;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class z4 implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2391a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MyDownloads f2392b;

    public /* synthetic */ z4(MyDownloads myDownloads, int i) {
        this.f2391a = i;
        this.f2392b = myDownloads;
    }

    @Override // d7.a
    public final Object invoke() {
        String format;
        int i = this.f2391a;
        int i6 = 3;
        t6.c cVar = null;
        p6.x xVar = p6.x.f8463a;
        MyDownloads myDownloads = this.f2392b;
        switch (i) {
            case 0:
                int i10 = MyDownloads.V;
                View inflate = myDownloads.getLayoutInflater().inflate(2131558738, (ViewGroup) null, false);
                int i11 = 2131362802;
                View findChildViewById = ViewBindings.findChildViewById(inflate, 2131362802);
                if (findChildViewById != null) {
                    i11 = 2131362919;
                    View findChildViewById2 = ViewBindings.findChildViewById(inflate, 2131362919);
                    if (findChildViewById2 != null) {
                        int i12 = 2131362702;
                        View findChildViewById3 = ViewBindings.findChildViewById(findChildViewById2, 2131362702);
                        if (findChildViewById3 != null) {
                            b5.m w2 = b5.m.w(findChildViewById3);
                            i12 = 2131363233;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(findChildViewById2, 2131363233);
                            if (relativeLayout != null) {
                                i12 = 2131363758;
                                TextView textView = (TextView) ViewBindings.findChildViewById(findChildViewById2, 2131363758);
                                if (textView != null) {
                                    i12 = 2131363762;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(findChildViewById2, 2131363762);
                                    if (textView2 != null) {
                                        i12 = 2131363933;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(findChildViewById2, 2131363933);
                                        if (textView3 != null) {
                                            g4.v vVar = new g4.v((RelativeLayout) findChildViewById2, w2, relativeLayout, textView, textView2, textView3, 5);
                                            i11 = 2131362945;
                                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(inflate, 2131362945);
                                            if (nestedScrollView != null) {
                                                i11 = 2131363084;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(inflate, 2131363084);
                                                if (recyclerView != null) {
                                                    i11 = 2131363402;
                                                    SearchView searchView = (SearchView) ViewBindings.findChildViewById(inflate, 2131363402);
                                                    if (searchView != null) {
                                                        i11 = 2131363537;
                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(inflate, 2131363537);
                                                        if (toolbar != null) {
                                                            i11 = 2131364083;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131364083);
                                                            if (textView4 != null) {
                                                                i11 = 2131364446;
                                                                if (((TextView) ViewBindings.findChildViewById(inflate, 2131364446)) != null) {
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        com.google.gson.internal.a.i("Missing required view with ID: ".concat(findChildViewById2.getResources().getResourceName(i12)));
                        break;
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i11)));
                break;
            case 1:
                int i13 = MyDownloads.V;
                o7.c0.s(LifecycleOwnerKt.getLifecycleScope(myDownloads), null, null, new b.n(myDownloads, cVar, 20), 3);
                break;
            case 2:
                int i14 = MyDownloads.V;
                myDownloads.y0(true);
                break;
            case 3:
                int i15 = MyDownloads.V;
                myDownloads.y0(false);
                a5.b.h();
                break;
            default:
                int i16 = MyDownloads.V;
                float f = UptodownApp.I;
                if (!b4.d.p(myDownloads, "downloadApkWorker")) {
                    myDownloads.y0(false);
                    break;
                } else {
                    a5.b.g();
                    ArrayList arrayList = new ArrayList();
                    j5.g l10 = j5.g.D.l(myDownloads);
                    l10.b();
                    Iterator it = l10.P().iterator();
                    it.getClass();
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        x4.r rVar = (x4.r) next;
                        if (rVar.m()) {
                            arrayList.add(rVar);
                        }
                    }
                    l10.c();
                    if (arrayList.size() > 1) {
                        String string = myDownloads.getString(2131951928);
                        string.getClass();
                        format = String.format(string, Arrays.copyOf(new Object[0], 0));
                    } else {
                        String string2 = myDownloads.getString(2131951927);
                        string2.getClass();
                        format = String.format(string2, Arrays.copyOf(new Object[0], 0));
                    }
                    myDownloads.I(format, new z4(myDownloads, 2), new z4(myDownloads, i6));
                    break;
                }
        }
        return xVar;
    }
}
