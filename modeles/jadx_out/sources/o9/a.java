package o9;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;
import l7.u;
import p6.i;
import p6.x;
import q5.g;
import u4.c0;
import u4.f1;
import u4.y1;
import w8.a0;
import w8.j0;
import w8.o;
import w8.v;
import w8.y;
import x8.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends m implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8371a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8372b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Object obj, int i) {
        super(0);
        this.f8371a = i;
        this.f8372b = obj;
    }

    /* JADX WARN: Finally extract failed */
    @Override // d7.a
    public final Object invoke() {
        int A0;
        long size;
        long j;
        int i;
        ArrayList arrayList;
        int i6;
        i iVar;
        i iVar2;
        int i10 = this.f8371a;
        x xVar = x.f8463a;
        Object obj = this.f8372b;
        switch (i10) {
            case 0:
                c cVar = (c) obj;
                cVar.dismiss();
                FragmentActivity activity = cVar.getActivity();
                if (activity != null) {
                    activity.finish();
                }
                return xVar;
            case 1:
                g gVar = (g) obj;
                gVar.dismiss();
                FragmentActivity activity2 = gVar.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
                return xVar;
            case 2:
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) ((c0) obj).invoke()).getViewModelStore();
                viewModelStore.getClass();
                return viewModelStore;
            case 3:
                ViewModelStore viewModelStore2 = ((ViewModelStoreOwner) ((c0) obj).invoke()).getViewModelStore();
                viewModelStore2.getClass();
                return viewModelStore2;
            case 4:
                return (f1) obj;
            case 5:
                ViewModelStore viewModelStore3 = ((ViewModelStoreOwner) ((a) obj).invoke()).getViewModelStore();
                viewModelStore3.getClass();
                return viewModelStore3;
            case 6:
                ViewModelStore viewModelStore4 = ((ViewModelStoreOwner) ((y1) obj).invoke()).getViewModelStore();
                viewModelStore4.getClass();
                return viewModelStore4;
            case 7:
                ViewModelStore viewModelStore5 = ((ViewModelStoreOwner) ((y1) obj).invoke()).getViewModelStore();
                viewModelStore5.getClass();
                return viewModelStore5;
            default:
                y yVar = f.f11557c;
                ClassLoader classLoader = (ClassLoader) obj;
                Enumeration<URL> resources = classLoader.getResources("");
                resources.getClass();
                ArrayList list = Collections.list(resources);
                list.getClass();
                ArrayList arrayList2 = new ArrayList();
                int size2 = list.size();
                boolean z9 = false;
                int i11 = 0;
                while (i11 < size2) {
                    Object obj2 = list.get(i11);
                    i11++;
                    URL url = (URL) obj2;
                    y yVar2 = f.f11557c;
                    url.getClass();
                    if (l.a(url.getProtocol(), "file")) {
                        v vVar = o.f10985a;
                        String str = y.f11004b;
                        String file = new File(url.toURI()).toString();
                        file.getClass();
                        iVar2 = new i(vVar, q1.a.j(file, false));
                    } else {
                        iVar2 = null;
                    }
                    if (iVar2 != null) {
                        arrayList2.add(iVar2);
                    }
                }
                Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
                resources2.getClass();
                ArrayList list2 = Collections.list(resources2);
                list2.getClass();
                ArrayList arrayList3 = new ArrayList();
                int size3 = list2.size();
                int i12 = 0;
                while (i12 < size3) {
                    Object obj3 = list2.get(i12);
                    int i13 = i12 + 1;
                    URL url2 = (URL) obj3;
                    y yVar3 = f.f11557c;
                    url2.getClass();
                    String url3 = url2.toString();
                    url3.getClass();
                    if (u.p0(url3, "jar:file:", z9) && (A0 = l7.m.A0("!", url3, 6)) != -1) {
                        String str2 = y.f11004b;
                        String file2 = new File(URI.create(url3.substring(4, A0))).toString();
                        file2.getClass();
                        y j6 = q1.a.j(file2, z9);
                        v vVar2 = o.f10985a;
                        vVar2.getClass();
                        w8.u f = vVar2.f(j6);
                        try {
                            size = f.size() - 22;
                            j = 0;
                        } finally {
                        }
                        if (size < 0) {
                            throw new IOException("not a zip: size=" + f.size());
                        }
                        i = i13;
                        long max = Math.max(size - 65536, 0L);
                        while (true) {
                            a0 a0Var = new a0(f.c(size));
                            try {
                                long j10 = j;
                                if (a0Var.f() == 101010256) {
                                    int i14 = a0Var.i() & 65535;
                                    int i15 = a0Var.i() & 65535;
                                    long i16 = a0Var.i() & 65535;
                                    arrayList = list2;
                                    if (i16 != (a0Var.i() & 65535) || i14 != 0 || i15 != 0) {
                                        throw new IOException("unsupported zip: spanned");
                                    }
                                    a0Var.skip(4L);
                                    int i17 = a0Var.i() & 65535;
                                    x8.d dVar = new x8.d(i16, a0Var.f() & 4294967295L, i17);
                                    a0Var.j(i17);
                                    a0Var.close();
                                    long j11 = size - 20;
                                    if (j11 > j10) {
                                        a0Var = new a0(f.c(j11));
                                        try {
                                            if (a0Var.f() == 117853008) {
                                                int f10 = a0Var.f();
                                                long h = a0Var.h();
                                                if (a0Var.f() != 1 || f10 != 0) {
                                                    throw new IOException("unsupported zip: spanned");
                                                }
                                                a0Var = new a0(f.c(h));
                                                try {
                                                    int f11 = a0Var.f();
                                                    if (f11 != 101075792) {
                                                        throw new IOException("bad zip: expected " + x8.b.c(101075792) + " but was " + x8.b.c(f11));
                                                    }
                                                    a0Var.skip(12L);
                                                    int f12 = a0Var.f();
                                                    int f13 = a0Var.f();
                                                    long h6 = a0Var.h();
                                                    if (h6 != a0Var.h() || f12 != 0 || f13 != 0) {
                                                        throw new IOException("unsupported zip: spanned");
                                                    }
                                                    a0Var.skip(8L);
                                                    dVar = new x8.d(h6, a0Var.h(), i17);
                                                } finally {
                                                }
                                            }
                                        } finally {
                                        }
                                    }
                                    x8.d dVar2 = dVar;
                                    long j12 = dVar2.f11553b;
                                    ArrayList arrayList4 = new ArrayList();
                                    a0Var = new a0(f.c(j12));
                                    try {
                                        long j13 = dVar2.f11552a;
                                        long j14 = j10;
                                        while (j14 < j13) {
                                            x8.g d10 = x8.b.d(a0Var);
                                            int i18 = size3;
                                            long j15 = j12;
                                            if (d10.g >= j15) {
                                                throw new IOException("bad zip: local file header offset >= central directory offset");
                                            }
                                            y yVar4 = f.f11557c;
                                            if (q1.a.f(d10.f11559a)) {
                                                arrayList4.add(d10);
                                            }
                                            j14++;
                                            size3 = i18;
                                            j12 = j15;
                                        }
                                        i6 = size3;
                                        a0Var.close();
                                        j0 j0Var = new j0(j6, vVar2, x8.b.b(arrayList4));
                                        f.close();
                                        iVar = new i(j0Var, f.f11557c);
                                    } catch (Throwable th) {
                                        try {
                                            throw th;
                                        } finally {
                                        }
                                    }
                                } else {
                                    ArrayList arrayList5 = list2;
                                    int i19 = size3;
                                    a0Var.close();
                                    size--;
                                    if (size < max) {
                                        throw new IOException("not a zip: end of central directory signature not found");
                                    }
                                    list2 = arrayList5;
                                    j = j10;
                                    size3 = i19;
                                }
                            } finally {
                                a0Var.close();
                            }
                        }
                    } else {
                        arrayList = list2;
                        i6 = size3;
                        i = i13;
                        iVar = null;
                    }
                    if (iVar != null) {
                        arrayList3.add(iVar);
                    }
                    list2 = arrayList;
                    i12 = i;
                    size3 = i6;
                    z9 = false;
                }
                return q6.l.A0(arrayList3, arrayList2);
        }
    }
}
