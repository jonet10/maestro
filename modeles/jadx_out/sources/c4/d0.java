package c4;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import com.uptodown.activities.MyDownloads;
import com.uptodown.core.activities.InstallerActivity;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1490a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f1491b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f1492l;

    /* renamed from: m, reason: collision with root package name */
    public Object f1493m;

    /* renamed from: n, reason: collision with root package name */
    public Serializable f1494n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f1495o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f1496p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f1497q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(k0 k0Var, String str, x4.r rVar, File file, String str2, boolean z9, t6.c cVar) {
        super(2, cVar);
        this.f1493m = k0Var;
        this.f1494n = str;
        this.f1496p = rVar;
        this.f1497q = file;
        this.f1495o = str2;
        this.f1492l = z9;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1490a) {
            case 0:
                return new d0((k0) this.f1493m, (String) this.f1494n, (x4.r) this.f1496p, (File) this.f1497q, (String) this.f1495o, this.f1492l, cVar);
            default:
                return new d0(this.f1492l, (o5) this.f1495o, (MyDownloads) this.f1496p, (m5) this.f1497q, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1490a) {
        }
        return ((d0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r17v0, types: [t6.c] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Object, r7.o0] */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object D;
        k0 k0Var;
        ArrayList arrayList;
        ArrayList arrayList2;
        p6.x xVar;
        o7.b0 b0Var;
        int i;
        Drawable drawable;
        File[] listFiles;
        File file;
        String str;
        int i6 = this.f1490a;
        boolean z9 = this.f1492l;
        u6.a aVar = u6.a.f10762a;
        p6.x xVar2 = p6.x.f8463a;
        Object obj2 = null;
        Object obj3 = this.f1495o;
        boolean z10 = true;
        Object obj4 = this.f1496p;
        Object obj5 = this.f1497q;
        switch (i6) {
            case 0:
                k0 k0Var2 = (k0) this.f1493m;
                int i10 = this.f1491b;
                if (i10 == 0) {
                    p6.a.e(obj);
                    b5.m mVar = new b5.m(k0Var2, obj2, (String) this.f1494n, 22);
                    this.f1491b = 1;
                    D = mVar.D(this);
                    if (D == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    p6.a.e(obj);
                    D = ((p6.k) obj).f8444a;
                }
                x4.r rVar = (x4.r) obj4;
                File file2 = (File) obj5;
                String str2 = (String) obj3;
                if (D instanceof p6.j) {
                    k0Var = k0Var2;
                } else {
                    x4.f2 f2Var = (x4.f2) D;
                    int i11 = f2Var.f11154m;
                    boolean z11 = this.f1492l;
                    if (i11 > 0) {
                        Long l10 = rVar != null ? new Long(rVar.f11361q) : null;
                        c0 c0Var = new c0(k0Var2, file2, str2, z11, rVar);
                        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(k0Var2);
                        v7.e eVar = o7.m0.f8288a;
                        k0Var = k0Var2;
                        o7.c0.s(lifecycleScope, t7.n.f10348a, null, new w(k0Var2, f2Var, l10, c0Var, (t6.c) null), 2);
                    } else {
                        k0Var = k0Var2;
                        file2.getClass();
                        String absolutePath = file2.getAbsolutePath();
                        absolutePath.getClass();
                        Intent intent = new Intent(k0Var, (Class<?>) InstallerActivity.class);
                        intent.putExtra("realPath", absolutePath);
                        intent.putExtra("requireUserAction", z11);
                        intent.putExtra("backgroundInstallation", false);
                        intent.addFlags(268435456);
                        if (str2 != null && str2.length() != 0) {
                            intent.putExtra("newFeatures", str2);
                        }
                        k0Var.startActivity(intent);
                        k0Var.X(rVar);
                    }
                }
                File file3 = (File) obj5;
                String str3 = (String) obj3;
                x4.r rVar2 = (x4.r) obj4;
                if (p6.k.a(D) != null) {
                    file3.getClass();
                    String absolutePath2 = file3.getAbsolutePath();
                    absolutePath2.getClass();
                    Intent intent2 = new Intent(k0Var, (Class<?>) InstallerActivity.class);
                    intent2.putExtra("realPath", absolutePath2);
                    intent2.putExtra("requireUserAction", z9);
                    intent2.putExtra("backgroundInstallation", false);
                    intent2.addFlags(268435456);
                    if (str3 != null && str3.length() != 0) {
                        intent2.putExtra("newFeatures", str3);
                    }
                    k0Var.startActivity(intent2);
                    k0Var.X(rVar2);
                }
                return xVar2;
            default:
                m5 m5Var = (m5) obj5;
                MyDownloads myDownloads = (MyDownloads) obj4;
                o5 o5Var = (o5) obj3;
                ?? r12 = o5Var.f1946a;
                int i12 = this.f1491b;
                File file4 = null;
                if (i12 == 0) {
                    p6.a.e(obj);
                    if (z9) {
                        r12.getClass();
                        r12.g(null, j5.p.f6705a);
                    }
                    arrayList = new ArrayList();
                    arrayList2 = new ArrayList();
                    j5.g l11 = j5.g.D.l(myDownloads);
                    l11.b();
                    Iterator it = l11.P().iterator();
                    it.getClass();
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        x4.r rVar3 = (x4.r) next;
                        if (rVar3.p()) {
                            if (rVar3.m()) {
                                arrayList.add(rVar3);
                            } else if (rVar3.F.size() == 0) {
                                v6.f.a(l11.j(rVar3));
                            } else {
                                int size = rVar3.F.size();
                                ArrayList arrayList3 = rVar3.F;
                                if (size != 1) {
                                    if (((x4.j0) arrayList3.get(0)).f11240q != null) {
                                        String str4 = ((x4.j0) rVar3.F.get(0)).f11240q;
                                        str4.getClass();
                                        file = new File(str4).getParentFile();
                                    } else {
                                        file = file4;
                                    }
                                    if (file == null || file.exists()) {
                                        Iterator it2 = rVar3.F.iterator();
                                        it2.getClass();
                                        while (it2.hasNext()) {
                                            Object next2 = it2.next();
                                            next2.getClass();
                                            x4.j0 j0Var = (x4.j0) next2;
                                            if (j0Var.f11240q == null) {
                                                l11.j(rVar3);
                                            } else {
                                                String str5 = j0Var.f11240q;
                                                str5.getClass();
                                                if (!new File(str5).exists()) {
                                                    l11.j(rVar3);
                                                }
                                            }
                                            Iterator it3 = rVar3.F.iterator();
                                            it3.getClass();
                                            while (it3.hasNext()) {
                                                Object next3 = it3.next();
                                                next3.getClass();
                                                x4.j0 j0Var2 = (x4.j0) next3;
                                                if (j0Var2.f11240q != null) {
                                                    String str6 = j0Var2.f11240q;
                                                    str6.getClass();
                                                    File file5 = new File(str6);
                                                    if (file5.exists()) {
                                                        file5.delete();
                                                    }
                                                }
                                            }
                                        }
                                        arrayList2.add(rVar3);
                                    } else {
                                        v6.f.a(l11.j(rVar3));
                                    }
                                } else if (((x4.j0) arrayList3.get(0)).f11240q == null) {
                                    v6.f.a(l11.j(rVar3));
                                } else {
                                    String str7 = ((x4.j0) rVar3.F.get(0)).f11240q;
                                    str7.getClass();
                                    File file6 = new File(str7);
                                    if (file6.exists()) {
                                        rVar3.h(myDownloads, file6);
                                        arrayList2.add(rVar3);
                                    } else {
                                        v6.f.a(l11.j(rVar3));
                                    }
                                }
                            }
                            file4 = null;
                        }
                    }
                    l11.c();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                    String str8 = ".";
                    if (externalStoragePublicDirectory.exists() && externalStoragePublicDirectory.canRead() && externalStoragePublicDirectory.isDirectory() && (listFiles = externalStoragePublicDirectory.listFiles()) != null) {
                        int length = listFiles.length;
                        int i13 = 0;
                        while (i13 < length) {
                            File file7 = listFiles[i13];
                            p6.x xVar3 = xVar2;
                            String name = file7.getName();
                            name.getClass();
                            File[] fileArr = listFiles;
                            int i14 = i13;
                            if ((l7.u.k0(name, ".apk", false) || l7.u.k0(name, ".xapk", true) || l7.u.k0(name, ".apks", true) || l7.u.k0(name, ".apkm", true) || l7.u.k0(name, ".zip", true)) && !l7.u.p0(name, ".", false)) {
                                arrayList5.add(file7);
                            }
                            i13 = i14 + 1;
                            listFiles = fileArr;
                            xVar2 = xVar3;
                        }
                    }
                    xVar = xVar2;
                    Iterator it4 = arrayList5.iterator();
                    it4.getClass();
                    while (it4.hasNext()) {
                        Object next4 = it4.next();
                        next4.getClass();
                        File file8 = (File) next4;
                        String name2 = file8.getName();
                        name2.getClass();
                        if (!l7.u.k0(name2, ".zip", false) || e1.c0.n(file8)) {
                            x4.r rVar4 = new x4.r();
                            String name3 = file8.getName();
                            name3.getClass();
                            int A0 = l7.m.A0(str8, name3, 6);
                            if (A0 != -1) {
                                name3 = name3.substring(0, A0);
                            }
                            rVar4.f11366w = name3;
                            String name4 = file8.getName();
                            name4.getClass();
                            int A02 = l7.m.A0(str8, name4, 6);
                            if (A02 == -1) {
                                i = 0;
                            } else {
                                i = 0;
                                name4 = name4.substring(0, A02);
                            }
                            rVar4.f11355b = name4;
                            rVar4.f11357m = i;
                            rVar4.f11369z = -1L;
                            String absolutePath3 = file8.getAbsolutePath();
                            absolutePath3.getClass();
                            PackageManager packageManager = myDownloads.getPackageManager();
                            packageManager.getClass();
                            PackageInfo d10 = n4.i.d(packageManager, absolutePath3, 128);
                            if ((d10 != null ? d10.applicationInfo : null) != null) {
                                ApplicationInfo applicationInfo = d10.applicationInfo;
                                applicationInfo.getClass();
                                applicationInfo.sourceDir = absolutePath3;
                                ApplicationInfo applicationInfo2 = d10.applicationInfo;
                                applicationInfo2.getClass();
                                applicationInfo2.publicSourceDir = absolutePath3;
                                ApplicationInfo applicationInfo3 = d10.applicationInfo;
                                applicationInfo3.getClass();
                                drawable = applicationInfo3.loadIcon(myDownloads.getPackageManager());
                            } else {
                                drawable = null;
                            }
                            rVar4.E = drawable;
                            x4.j0 j0Var3 = new x4.j0();
                            j0Var3.f11240q = file8.getAbsolutePath();
                            j0Var3.f11237n = file8.length();
                            j0Var3.f11238o = file8.length();
                            rVar4.F.add(j0Var3);
                            rVar4.h(myDownloads, file8);
                            arrayList4.add(rVar4);
                            str8 = str8;
                        }
                    }
                    arrayList2.addAll(arrayList4);
                    if (o5Var.g) {
                        b0Var = null;
                        o5Var.f1949d.f(arrayList);
                        o5Var.f1948c.f(arrayList2);
                        str = o5Var.f1950e;
                        if (str != null || str.length() <= 0) {
                            o5.b(o5Var, arrayList2, m5Var);
                            j5.r rVar5 = new j5.r(new l5(arrayList2, arrayList));
                            r12.getClass();
                            r12.g(b0Var, rVar5);
                        } else {
                            String str9 = o5Var.f1950e;
                            o7.a0 viewModelScope = ViewModelKt.getViewModelScope(o5Var);
                            v7.e eVar2 = o7.m0.f8288a;
                            o7.c0.s(viewModelScope, v7.d.f10884a, b0Var, new b5.l((Object) o5Var, (Object) str9, (Object) m5Var, (t6.c) b0Var, 8), 2);
                        }
                        return xVar;
                    }
                    this.f1493m = arrayList;
                    this.f1494n = arrayList2;
                    z10 = true;
                    this.f1491b = 1;
                    v7.e eVar3 = o7.m0.f8288a;
                    b0Var = null;
                    Object C = o7.c0.C(new xc(myDownloads, 0 == true ? 1 : 0, 1 == true ? 1 : 0), v7.d.f10884a, this);
                    if (C != aVar) {
                        C = xVar;
                    }
                    if (C == aVar) {
                        return aVar;
                    }
                } else {
                    if (i12 != 1) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    arrayList2 = (ArrayList) this.f1494n;
                    arrayList = (ArrayList) this.f1493m;
                    p6.a.e(obj);
                    xVar = xVar2;
                    b0Var = null;
                }
                o5Var.g = z10;
                o5Var.f1949d.f(arrayList);
                o5Var.f1948c.f(arrayList2);
                str = o5Var.f1950e;
                if (str != null) {
                }
                o5.b(o5Var, arrayList2, m5Var);
                j5.r rVar52 = new j5.r(new l5(arrayList2, arrayList));
                r12.getClass();
                r12.g(b0Var, rVar52);
                return xVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(boolean z9, o5 o5Var, MyDownloads myDownloads, m5 m5Var, t6.c cVar) {
        super(2, cVar);
        this.f1492l = z9;
        this.f1495o = o5Var;
        this.f1496p = myDownloads;
        this.f1497q = m5Var;
    }
}
