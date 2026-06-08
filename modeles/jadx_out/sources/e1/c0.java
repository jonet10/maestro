package e1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import com.google.android.gms.internal.measurement.a8;
import com.google.android.gms.internal.measurement.f7;
import com.google.android.gms.internal.measurement.g7;
import com.google.android.gms.internal.measurement.i8;
import com.google.android.gms.internal.measurement.k8;
import com.google.android.gms.internal.measurement.q8;
import com.google.android.gms.internal.measurement.y7;
import com.google.firebase.components.ComponentRegistrar;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class c0 implements v, w4.f, h2.a, p2.a, c.b {

    /* renamed from: r, reason: collision with root package name */
    public static volatile c0 f3840r;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3842a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ c0 f3833b = new c0(0);

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ c0 f3834l = new c0(1);

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ c0 f3835m = new c0(2);

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ c0 f3836n = new c0(3);

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ c0 f3837o = new c0(4);

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ c0 f3838p = new c0(5);

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ c0 f3839q = new c0(6);

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ c0 f3841s = new c0(28);

    public c0(TvAppDetailFragment tvAppDetailFragment) {
        this.f3842a = 10;
    }

    public static boolean g(File file) {
        try {
            Enumeration<? extends ZipEntry> entries = new ZipFile(file).entries();
            while (entries.hasMoreElements()) {
                String name = entries.nextElement().getName();
                name.getClass();
                if (l7.u.k0(name, ".obb", false)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static Object h(Context context, String str, n4.c cVar) {
        v7.e eVar = o7.m0.f8288a;
        Object C = o7.c0.C(new j5.i(context, str, null, 1), t7.n.f10348a, cVar);
        return C == u6.a.f10762a ? C : p6.x.f8463a;
    }

    public static g2.d j(q1.a aVar) {
        return new g2.d(System.currentTimeMillis() + 3600000, new g2.c(8), new g2.b(true, false, false), 10.0d, 1.2d, 60);
    }

    public static long k(File file) {
        File[] fileArr;
        file.getClass();
        if (!file.isDirectory()) {
            return file.length();
        }
        try {
            fileArr = file.listFiles();
        } catch (SecurityException e10) {
            e10.printStackTrace();
            fileArr = null;
        }
        long j = 0;
        if (fileArr == null) {
            return 0L;
        }
        int i = 0;
        while (true) {
            if (!(i < fileArr.length)) {
                return j;
            }
            int i6 = i + 1;
            try {
                j += k(fileArr[i]);
                i = i6;
            } catch (ArrayIndexOutOfBoundsException e11) {
                androidx.privacysandbox.ads.adservices.customaudience.a.s(e11.getMessage());
                return 0L;
            }
        }
    }

    public static ArrayList m(Context context, File file) {
        context.getClass();
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            String packageName = context.getPackageName();
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    String absolutePath = file2.getAbsolutePath();
                    absolutePath.getClass();
                    if (!l7.u.k0(absolutePath, "Android/data/" + packageName, false)) {
                        String name = file2.getName();
                        name.getClass();
                        if (!l7.m.q0(name, "Backups", true)) {
                            arrayList.addAll(m(context, file2));
                        }
                    }
                } else {
                    String name2 = file2.getName();
                    name2.getClass();
                    if ((l7.u.k0(name2, ".apk", false) || l7.u.k0(name2, ".xapk", true) || l7.u.k0(name2, ".apks", true) || l7.u.k0(name2, ".apkm", true) || l7.u.k0(name2, ".zip", true)) && !l7.u.p0(name2, ".", false)) {
                        arrayList.add(file2);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean n(java.io.File r4) {
        /*
            r0 = 0
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch: java.lang.Exception -> L2b
            r1.<init>(r4)     // Catch: java.lang.Exception -> L2b
            java.util.Enumeration r4 = r1.entries()     // Catch: java.lang.Exception -> L2b
            r1 = r0
        Lb:
            boolean r2 = r4.hasMoreElements()     // Catch: java.lang.Exception -> L29
            if (r2 == 0) goto L30
            java.lang.Object r2 = r4.nextElement()     // Catch: java.lang.Exception -> L29
            java.util.zip.ZipEntry r2 = (java.util.zip.ZipEntry) r2     // Catch: java.lang.Exception -> L29
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Exception -> L29
            r2.getClass()     // Catch: java.lang.Exception -> L29
            java.lang.String r3 = ".apk"
            boolean r2 = l7.u.k0(r2, r3, r0)     // Catch: java.lang.Exception -> L29
            if (r2 == 0) goto Lb
            int r1 = r1 + 1
            goto Lb
        L29:
            r4 = move-exception
            goto L2d
        L2b:
            r4 = move-exception
            r1 = r0
        L2d:
            r4.printStackTrace()
        L30:
            if (r1 <= 0) goto L33
            r0 = 1
        L33:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.c0.n(java.io.File):boolean");
    }

    public static ArrayList t(Context context) {
        context.getClass();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList G = a.a.G(context);
        if (G.size() > 0) {
            Iterator it = G.iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                File file = new File(((l4.o) next).f7125a);
                if (file.exists() && file.isDirectory()) {
                    arrayList2.addAll(m(context, file));
                }
            }
        } else {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            externalStorageDirectory.getClass();
            arrayList2.addAll(m(context, externalStorageDirectory));
        }
        arrayList.addAll(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        packageManager.getClass();
        Iterator it2 = arrayList.iterator();
        it2.getClass();
        while (it2.hasNext()) {
            Object next2 = it2.next();
            next2.getClass();
            File file2 = (File) next2;
            String name = file2.getName();
            name.getClass();
            boolean z9 = false;
            if (!l7.u.p0(name, ".", false)) {
                String name2 = file2.getName();
                name2.getClass();
                if (l7.u.k0(name2, ".apk", false)) {
                    String absolutePath = file2.getAbsolutePath();
                    absolutePath.getClass();
                    PackageInfo d10 = n4.i.d(packageManager, absolutePath, 128);
                    if (d10 != null) {
                        try {
                            ApplicationInfo applicationInfo = d10.applicationInfo;
                            if ((applicationInfo != null ? applicationInfo.metaData : null) != null) {
                                applicationInfo.getClass();
                                if (applicationInfo.metaData.containsKey("com.android.vending.splits.required")) {
                                    ApplicationInfo applicationInfo2 = d10.applicationInfo;
                                    applicationInfo2.getClass();
                                    z9 = applicationInfo2.metaData.getBoolean("com.android.vending.splits.required");
                                }
                            }
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                        if (!z9) {
                            arrayList3.add(file2);
                        }
                    } else {
                        String name3 = file2.getName();
                        name3.getClass();
                        if (!l7.u.p0(name3, "split_config", false)) {
                            arrayList3.add(file2);
                        }
                    }
                } else {
                    String name4 = file2.getName();
                    name4.getClass();
                    if (l7.u.k0(name4, ".xapk", true) || l7.u.k0(name4, ".apks", true) || l7.u.k0(name4, ".apkm", true) || l7.u.k0(name4, ".zip", true)) {
                        arrayList3.add(file2);
                    }
                }
            }
        }
        return arrayList3;
    }

    public static boolean u(File file, File file2) {
        try {
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                name.getClass();
                if (l7.u.k0(name, ".apk", false)) {
                    if (nextElement.getSize() >= file2.getUsableSpace()) {
                        return false;
                    }
                    File file3 = new File(file2, name);
                    InputStream inputStream = zipFile.getInputStream(nextElement);
                    inputStream.getClass();
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    try {
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                        } finally {
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            }
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    @Override // e1.v
    public Object a() {
        switch (this.f3842a) {
            case 0:
                List list = f0.f3913a;
                Boolean bool = (Boolean) k8.f2694a.b();
                bool.getClass();
                return bool;
            case 1:
                List list2 = f0.f3913a;
                f7.f2585b.get();
                return Integer.valueOf((int) ((Long) g7.n0.b()).longValue());
            case 2:
                List list3 = f0.f3913a;
                f7.f2585b.get();
                Long l10 = (Long) g7.f2604a.b();
                l10.getClass();
                return l10;
            case 3:
                return new Boolean(((Boolean) y7.f2920a.b()).booleanValue());
            case 4:
                return new Boolean(((Boolean) a8.f2504a.b()).booleanValue());
            case 5:
                return new Boolean(((Boolean) i8.f2666a.b()).booleanValue());
            default:
                return new Boolean(((Boolean) q8.f2770a.b()).booleanValue());
        }
    }

    @Override // w4.f
    public void b(long j) {
        int i = this.f3842a;
    }

    @Override // w4.f
    public void c(x4.j jVar) {
        int i = this.f3842a;
    }

    @Override // h2.a
    public StackTraceElement[] d(StackTraceElement[] stackTraceElementArr) {
        int i;
        switch (this.f3842a) {
            case 13:
                if (stackTraceElementArr.length <= 1024) {
                    return stackTraceElementArr;
                }
                StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[1024];
                System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, 512);
                System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - 512, stackTraceElementArr2, 512, 512);
                return stackTraceElementArr2;
            default:
                HashMap hashMap = new HashMap();
                StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[stackTraceElementArr.length];
                int i6 = 0;
                int i10 = 0;
                int i11 = 1;
                while (i6 < stackTraceElementArr.length) {
                    StackTraceElement stackTraceElement = stackTraceElementArr[i6];
                    Integer num = (Integer) hashMap.get(stackTraceElement);
                    if (num != null) {
                        int intValue = num.intValue();
                        int i12 = i6 - intValue;
                        if (i6 + i12 <= stackTraceElementArr.length) {
                            for (int i13 = 0; i13 < i12; i13++) {
                                if (stackTraceElementArr[intValue + i13].equals(stackTraceElementArr[i6 + i13])) {
                                }
                            }
                            int intValue2 = i6 - num.intValue();
                            if (i11 < 10) {
                                System.arraycopy(stackTraceElementArr, i6, stackTraceElementArr3, i10, intValue2);
                                i10 += intValue2;
                                i11++;
                            }
                            i = (intValue2 - 1) + i6;
                            hashMap.put(stackTraceElement, Integer.valueOf(i6));
                            i6 = i + 1;
                        }
                    }
                    stackTraceElementArr3[i10] = stackTraceElementArr[i6];
                    i10++;
                    i11 = 1;
                    i = i6;
                    hashMap.put(stackTraceElement, Integer.valueOf(i6));
                    i6 = i + 1;
                }
                StackTraceElement[] stackTraceElementArr4 = new StackTraceElement[i10];
                System.arraycopy(stackTraceElementArr3, 0, stackTraceElementArr4, 0, i10);
                return i10 < stackTraceElementArr.length ? stackTraceElementArr4 : stackTraceElementArr;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a0, code lost:
    
        if (r14 == r9) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a4, code lost:
    
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
    
        if (h(r19, r0, r7) == r9) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d0, code lost:
    
        if (h(r19, r0, r7) == r9) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x010f, code lost:
    
        if (r14 == r9) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0123, code lost:
    
        if (h(r19, r0, r7) == r9) goto L51;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object i(java.lang.Object r17, java.lang.String r18, android.content.Context r19, final d7.a r20, v6.c r21) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.c0.i(java.lang.Object, java.lang.String, android.content.Context, d7.a, v6.c):java.lang.Object");
    }

    public synchronized j5.g l(Context context) {
        j5.g gVar;
        try {
            context.getClass();
            if (j5.g.E == null) {
                j5.g.E = new j5.g(context.getApplicationContext());
            }
            gVar = j5.g.E;
            gVar.getClass();
        } catch (Throwable th) {
            throw th;
        }
        return gVar;
    }

    public List s(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (s1.a aVar : componentRegistrar.getComponents()) {
            String str = aVar.f9113a;
            if (str != null) {
                aVar = new s1.a(str, aVar.f9114b, aVar.f9115c, aVar.f9116d, aVar.f9117e, new a3.e(3, str, aVar), aVar.g);
            }
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public /* synthetic */ c0(int i) {
        this.f3842a = i;
    }

    private final void o(long j) {
    }

    private final void p(long j) {
    }

    private final void q(x4.j jVar) {
    }

    private final void r(x4.j jVar) {
    }

    @Override // c.b
    public void e(c.i iVar) {
    }

    @Override // c.b
    public void f(c.i iVar) {
    }
}
