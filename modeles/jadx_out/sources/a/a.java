package a;

import a4.x;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.text.HtmlCompat;
import b2.t1;
import b8.b;
import b8.e;
import c4.j1;
import com.inmobi.cmp.core.model.Vector;
import d7.p;
import d8.w0;
import e1.c0;
import g4.z;
import j5.g;
import j7.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.l;
import l4.o;
import l7.k;
import l7.m;
import l7.u;
import m8.q;
import n4.i;
import org.json.JSONArray;
import org.json.JSONObject;
import t6.f;
import t6.h;
import x4.g2;
import x4.j;
import x4.j0;
import x4.n;
import x4.o2;
import x4.p2;
import x4.q2;
import x4.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f0a = true;

    public static final c A(e eVar) {
        eVar.getClass();
        if (eVar instanceof b) {
            return ((b) eVar).f1104b;
        }
        if (eVar instanceof w0) {
            return A(((w0) eVar).f3719a);
        }
        return null;
    }

    public static ArrayList B(String str) {
        File[] listFiles;
        str.getClass();
        ArrayList arrayList = new ArrayList();
        File file = new File(x.k(Environment.getExternalStorageDirectory().getAbsolutePath(), "/Android/Obb/", str));
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            int i = 0;
            while (i < listFiles.length) {
                int i6 = i + 1;
                try {
                    File file2 = listFiles[i];
                    if (file2.isFile()) {
                        String name = file2.getName();
                        name.getClass();
                        if (u.k0(name, ".obb", false)) {
                            arrayList.add(file2);
                        }
                    }
                    i = i6;
                } catch (ArrayIndexOutOfBoundsException e10) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.s(e10.getMessage());
                    return null;
                }
            }
        }
        return arrayList;
    }

    public static String C(String str) {
        int A0;
        str.getClass();
        if (!u.p0(str, "uptodown-", false) || m.G0(str, new String[]{"-"}).size() != 2) {
            return null;
        }
        int y02 = m.y0(str, " ", 0, false, 6);
        if (y02 > 0) {
            str = str.substring(0, y02).concat(".apk");
        }
        if (m.q0(str, "(", false) && u.k0(str, ").apk", true)) {
            return str.substring(0, m.y0(str, "(", 0, false, 6)).substring(9);
        }
        if (u.k0(str, ".apk", true) && (A0 = m.A0(".apk", str, 6)) > 0 && str.length() == A0 + 4) {
            return str.substring(0, A0).substring(9);
        }
        return null;
    }

    public static String D(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return "TRuntime.".concat(str);
        }
        String concat = "TRuntime.".concat(str);
        return concat.length() > 23 ? concat.substring(0, 23) : concat;
    }

    public static ArrayList E(Context context) {
        context.getClass();
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        if (externalStoragePublicDirectory.exists() && externalStoragePublicDirectory.canRead() && externalStoragePublicDirectory.isDirectory()) {
            Iterator it = c0.m(context, externalStoragePublicDirectory).iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                File file = (File) next;
                String name = file.getName();
                name.getClass();
                if (u.k0(name, ".apk", true)) {
                    packageManager.getClass();
                    String absolutePath = file.getAbsolutePath();
                    absolutePath.getClass();
                    PackageInfo d10 = i.d(packageManager, absolutePath, 128);
                    if (d10 != null && d10.packageName.equals("com.uptodown")) {
                        arrayList.add(file);
                    }
                }
            }
        }
        return arrayList;
    }

    public static long F(Context context, File file) {
        context.getClass();
        ArrayList arrayList = new ArrayList();
        g l10 = g.D.l(context);
        l10.b();
        Iterator it = l10.P().iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            r rVar = (r) next;
            if (rVar.m()) {
                arrayList.add(rVar);
            }
        }
        l10.c();
        int size = arrayList.size();
        long j = 0;
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            j += ((r) obj).k();
        }
        return file.getUsableSpace() - j;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006e A[Catch: IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00c7, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00c7, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00c7, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00c7, TRY_ENTER, TryCatch #4 {IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00c7, blocks: (B:3:0x0016, B:5:0x003b, B:9:0x0040, B:9:0x0040, B:9:0x0040, B:11:0x0050, B:11:0x0050, B:11:0x0050, B:34:0x0056, B:34:0x0056, B:34:0x0056, B:36:0x0066, B:36:0x0066, B:36:0x0066, B:14:0x006e, B:14:0x006e, B:14:0x006e, B:14:0x006e, B:16:0x0080, B:16:0x0080, B:16:0x0080, B:16:0x0080, B:18:0x0086, B:18:0x0086, B:18:0x0086, B:18:0x0086, B:23:0x00c0, B:23:0x00c0, B:23:0x00c0, B:23:0x00c0), top: B:2:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList G(android.content.Context r14) {
        /*
            java.lang.Class<android.os.storage.StorageManager> r0 = android.os.storage.StorageManager.class
            r14.getClass()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r2 = "storage"
            java.lang.Object r14 = r14.getSystemService(r2)
            r14.getClass()
            android.os.storage.StorageManager r14 = (android.os.storage.StorageManager) r14
            r2 = 0
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> Lc7
            java.lang.String r4 = "getVolumeList"
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r2)     // Catch: java.lang.Throwable -> Lc7
            java.lang.Class[] r3 = (java.lang.Class[]) r3     // Catch: java.lang.Throwable -> Lc7
            java.lang.reflect.Method r3 = r0.getMethod(r4, r3)     // Catch: java.lang.Throwable -> Lc7
            r4 = 1
            r3.setAccessible(r4)     // Catch: java.lang.Throwable -> Lc7
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lc7
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r2)     // Catch: java.lang.Throwable -> Lc7
            java.lang.Object r3 = r3.invoke(r14, r5)     // Catch: java.lang.Throwable -> Lc7
            r3.getClass()     // Catch: java.lang.Throwable -> Lc7
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch: java.lang.Throwable -> Lc7
            int r5 = r3.length     // Catch: java.lang.Throwable -> Lc7
            r6 = r2
        L39:
            if (r6 >= r5) goto Lc7
            r7 = r3[r6]     // Catch: java.lang.Throwable -> Lc7
            if (r7 == 0) goto Lc3
            r8 = 0
            java.lang.Class r9 = r7.getClass()     // Catch: java.lang.NoSuchMethodException -> L53 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7
            java.lang.String r10 = "getPath"
            java.lang.reflect.Method r9 = r9.getMethod(r10, r8)     // Catch: java.lang.NoSuchMethodException -> L53 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7
            java.lang.Object r9 = r9.invoke(r7, r8)     // Catch: java.lang.NoSuchMethodException -> L53 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7
            if (r9 == 0) goto L53
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.NoSuchMethodException -> L53 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7
            goto L54
        L53:
            r9 = r8
        L54:
            if (r9 != 0) goto L6c
            java.lang.Class r10 = r7.getClass()     // Catch: java.lang.NoSuchMethodException -> L6c java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7
            java.lang.String r11 = "getDirectory"
            java.lang.reflect.Method r10 = r10.getMethod(r11, r8)     // Catch: java.lang.NoSuchMethodException -> L6c java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7
            java.lang.Object r10 = r10.invoke(r7, r8)     // Catch: java.lang.NoSuchMethodException -> L6c java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7
            if (r10 == 0) goto L6c
            java.io.File r10 = (java.io.File) r10     // Catch: java.lang.NoSuchMethodException -> L6c java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7
            java.lang.String r9 = r10.getAbsolutePath()     // Catch: java.lang.NoSuchMethodException -> L6c java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7
        L6c:
            if (r9 == 0) goto Lc3
            l4.o r10 = new l4.o     // Catch: java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7
            r10.<init>()     // Catch: java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7
            r10.f7125a = r9     // Catch: java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7
            java.io.File r11 = new java.io.File     // Catch: java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7
            r11.<init>(r9)     // Catch: java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7
            boolean r12 = r11.exists()     // Catch: java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7
            if (r12 == 0) goto Lc3
            boolean r12 = r11.isDirectory()     // Catch: java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7
            if (r12 == 0) goto Lc3
            long r11 = r11.getUsableSpace()     // Catch: java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7
            r10.f7128d = r11     // Catch: java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7
            java.lang.String r11 = "getVolumeState"
            java.lang.Class[] r12 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> La7
            java.lang.Class<java.lang.String> r13 = java.lang.String.class
            r12[r2] = r13     // Catch: java.lang.Exception -> La7
            java.lang.reflect.Method r11 = r0.getMethod(r11, r12)     // Catch: java.lang.Exception -> La7
            java.lang.Object[] r12 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> La7
            r12[r2] = r9     // Catch: java.lang.Exception -> La7
            java.lang.Object r9 = r11.invoke(r14, r12)     // Catch: java.lang.Exception -> La7
            r9.getClass()     // Catch: java.lang.Exception -> La7
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Exception -> La7
            r10.f7126b = r9     // Catch: java.lang.Exception -> La7
        La7:
            java.lang.Class r9 = r7.getClass()     // Catch: java.lang.Exception -> Lc0
            java.lang.String r11 = "isRemovable"
            java.lang.reflect.Method r9 = r9.getMethod(r11, r8)     // Catch: java.lang.Exception -> Lc0
            java.lang.Object r7 = r9.invoke(r7, r8)     // Catch: java.lang.Exception -> Lc0
            r7.getClass()     // Catch: java.lang.Exception -> Lc0
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Exception -> Lc0
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Exception -> Lc0
            r10.f7127c = r7     // Catch: java.lang.Exception -> Lc0
        Lc0:
            r1.add(r10)     // Catch: java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7 java.lang.Throwable -> Lc7
        Lc3:
            int r6 = r6 + 1
            goto L39
        Lc7:
            r1.trimToSize()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.G(android.content.Context):java.util.ArrayList");
    }

    public static List H(Object obj) {
        List singletonList = Collections.singletonList(obj);
        singletonList.getClass();
        return singletonList;
    }

    public static ArrayList I(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            ArrayList G = G(context);
            int size = G.size();
            for (int i = 0; i < size; i++) {
                if (!m.q0(((o) G.get(i)).f7125a, "/emulated/", false) && ((o) G.get(i)).f7127c && "mounted".equals(((o) G.get(i)).f7126b)) {
                    String str = "/Android/data/" + context.getPackageName();
                    File file = new File(((o) G.get(i)).f7125a + str);
                    if (file.exists()) {
                        if (file.canWrite()) {
                            arrayList.add(G.get(i));
                        }
                    } else if (file.mkdirs()) {
                        arrayList.add(G.get(i));
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static p2 J(g2 g2Var, j jVar) {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        jVar.getClass();
        p2 p2Var = new p2(null, null, 7);
        p2Var.f11329a = jVar;
        JSONObject jSONObject = g2Var.f11206d;
        if (jSONObject != null) {
            int optInt = !jSONObject.isNull("success") ? jSONObject.optInt("success") : 0;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("data");
            if (optJSONObject3 != null) {
                if (!optJSONObject3.isNull("category") && (optJSONObject2 = optJSONObject3.optJSONObject("category")) != null && !optJSONObject2.isNull("description")) {
                    p2Var.f11329a.f11226l = optJSONObject2.optString("description");
                }
                if (!optJSONObject3.isNull("title")) {
                    p2Var.f11329a.f11225b = optJSONObject3.optString("title");
                }
                if (!optJSONObject3.isNull("description")) {
                    p2Var.f11329a.f11226l = optJSONObject3.optString("description");
                }
                if (jVar.f11227m) {
                    o2 o2Var = new o2();
                    o2Var.f11307a = -1L;
                    o2Var.f11308b = -1;
                    o2Var.f11309c = -1;
                    o2Var.f11310d = null;
                    o2Var.f11311e = null;
                    o2Var.f = null;
                    o2Var.g = null;
                    p2Var.f11332d = o2Var;
                    if (!optJSONObject3.isNull("lastUpdate")) {
                        o2 o2Var2 = p2Var.f11332d;
                        o2Var2.getClass();
                        o2Var2.f11307a = optJSONObject3.optLong("lastUpdate");
                    }
                    if (!optJSONObject3.isNull("totalApps")) {
                        o2 o2Var3 = p2Var.f11332d;
                        o2Var3.getClass();
                        o2Var3.f11308b = optJSONObject3.optInt("totalApps");
                    }
                    if (!optJSONObject3.isNull("url")) {
                        o2 o2Var4 = p2Var.f11332d;
                        o2Var4.getClass();
                        o2Var4.g = optJSONObject3.optString("url");
                    }
                    if (!optJSONObject3.isNull("editor") && (optJSONObject = optJSONObject3.optJSONObject("editor")) != null) {
                        if (!optJSONObject.isNull("editorID")) {
                            o2 o2Var5 = p2Var.f11332d;
                            o2Var5.getClass();
                            o2Var5.f11309c = optJSONObject.optInt("editorID");
                        }
                        if (!optJSONObject.isNull("name")) {
                            o2 o2Var6 = p2Var.f11332d;
                            o2Var6.getClass();
                            o2Var6.f11310d = optJSONObject.optString("name");
                        }
                        if (!optJSONObject.isNull("avatar")) {
                            o2 o2Var7 = p2Var.f11332d;
                            o2Var7.getClass();
                            o2Var7.f11311e = optJSONObject.optString("avatar");
                        }
                        if (!optJSONObject.isNull("jobTitle")) {
                            o2 o2Var8 = p2Var.f11332d;
                            o2Var8.getClass();
                            o2Var8.f = optJSONObject.optString("jobTitle");
                        }
                    }
                }
                if (!optJSONObject3.isNull("floatingCategoryRelated") && (optJSONArray = optJSONObject3.optJSONArray("floatingCategoryRelated")) != null) {
                    p2Var.f11333e = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject4 = optJSONArray.optJSONObject(i);
                        optJSONObject4.getClass();
                        j jVar2 = new j(0, (String) null, 7);
                        if (!optJSONObject4.isNull("id")) {
                            jVar2.f11224a = optJSONObject4.optInt("id");
                        }
                        if (!optJSONObject4.isNull("name")) {
                            jVar2.f11225b = optJSONObject4.optString("name");
                        }
                        jVar2.f11227m = true;
                        ArrayList arrayList = p2Var.f11333e;
                        arrayList.getClass();
                        arrayList.add(jVar2);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject3.optJSONArray("apps");
                if (optJSONArray2 != null && optInt == 1 && optJSONArray2.length() > 0) {
                    int length2 = optJSONArray2.length();
                    for (int i6 = 0; i6 < length2; i6++) {
                        JSONObject optJSONObject5 = optJSONArray2.optJSONObject(i6);
                        optJSONObject5.getClass();
                        x4.g gVar = new x4.g();
                        gVar.a(null, optJSONObject5);
                        p2Var.f11330b.add(gVar);
                    }
                }
            }
        }
        return p2Var;
    }

    public static h K(f fVar, t6.g gVar) {
        gVar.getClass();
        return l.a(fVar.getKey(), gVar) ? t6.i.f10314a : fVar;
    }

    public static h L(f fVar, h hVar) {
        hVar.getClass();
        return hVar == t6.i.f10314a ? fVar : (h) hVar.fold(fVar, new j1(14));
    }

    public static SpannableStringBuilder M(String str, Context context, w4.f fVar) {
        str.getClass();
        fVar.getClass();
        int i = 0;
        String o02 = u.o0(u.o0(str, "<br />", "\n", false), "<br/>", "\n", false);
        List<x4.o> w2 = w(o02);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(o02);
        int i6 = 0;
        for (x4.o oVar : w2) {
            int i10 = oVar.f11300a;
            String str2 = oVar.f11304e;
            String str3 = oVar.f11303d;
            int i11 = i10 - i6;
            int length = str3.length() + i11;
            str2.getClass();
            spannableStringBuilder = spannableStringBuilder.replace(i11, str2.length() + i11, (CharSequence) str3);
            spannableStringBuilder.getClass();
            String str4 = oVar.f11301b;
            int hashCode = str4.hashCode();
            int i12 = 1;
            if (hashCode != 98) {
                if (hashCode != 105) {
                    if (hashCode != 117) {
                        if (hashCode != 93028092) {
                            if (hashCode != 1524339519) {
                                if (hashCode != 3274) {
                                    if (hashCode == 3275 && str4.equals("h3")) {
                                        float dimension = context.getResources().getDimension(2131166539);
                                        Typeface typeface = f4.c.f4882w;
                                        typeface.getClass();
                                        spannableStringBuilder.setSpan(new j5.e(dimension, typeface, ContextCompat.getColor(context, 2131100787)), i11, length, 33);
                                    }
                                } else if (str4.equals("h2")) {
                                    float dimension2 = context.getResources().getDimension(2131166538);
                                    Typeface typeface2 = f4.c.f4882w;
                                    typeface2.getClass();
                                    spannableStringBuilder.setSpan(new j5.e(dimension2, typeface2, ContextCompat.getColor(context, 2131100787)), i11, length, 33);
                                }
                            } else if (str4.equals("floatingCategoryID")) {
                                spannableStringBuilder.setSpan(new n(oVar, fVar, context, i12), i11, length, 33);
                            }
                        } else if (str4.equals("appID")) {
                            spannableStringBuilder.setSpan(new n(oVar, fVar, context, i), i11, length, 33);
                        }
                    } else if (str4.equals("u")) {
                        spannableStringBuilder.setSpan(new UnderlineSpan(), i11, length, 33);
                    }
                } else if (str4.equals("i")) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), i11, length, 33);
                }
            } else if (str4.equals("b")) {
                spannableStringBuilder.setSpan(new StyleSpan(1), i11, length, 33);
            }
            i6 = (str2.length() + i6) - str3.length();
        }
        return spannableStringBuilder;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0077 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int N(int r7, java.lang.CharSequence r8) {
        /*
            int r0 = r8.length()
            r1 = -1
            if (r7 < r0) goto L8
            return r1
        L8:
            char r0 = r8.charAt(r7)
            r2 = 92
            r3 = 60
            if (r0 != r3) goto L39
        L12:
            int r7 = r7 + 1
            int r0 = r8.length()
            if (r7 >= r0) goto L38
            char r0 = r8.charAt(r7)
            r4 = 10
            if (r0 == r4) goto L38
            if (r0 == r3) goto L38
            r4 = 62
            if (r0 == r4) goto L35
            if (r0 == r2) goto L2b
            goto L12
        L2b:
            int r0 = r7 + 1
            boolean r4 = b2.t1.A(r0, r8)
            if (r4 == 0) goto L12
            r7 = r0
            goto L12
        L35:
            int r7 = r7 + 1
            return r7
        L38:
            return r1
        L39:
            r0 = 0
            r3 = r7
        L3b:
            int r4 = r8.length()
            if (r3 >= r4) goto L79
            char r4 = r8.charAt(r3)
            if (r4 == 0) goto L75
            r5 = 32
            if (r4 == r5) goto L75
            if (r4 == r2) goto L69
            r6 = 40
            if (r4 == r6) goto L64
            r5 = 41
            if (r4 == r5) goto L5e
            boolean r4 = java.lang.Character.isISOControl(r4)
            if (r4 == 0) goto L72
            if (r3 == r7) goto L78
            goto L77
        L5e:
            if (r0 != 0) goto L61
            goto L77
        L61:
            int r0 = r0 + (-1)
            goto L72
        L64:
            int r0 = r0 + 1
            if (r0 <= r5) goto L72
            goto L78
        L69:
            int r4 = r3 + 1
            boolean r5 = b2.t1.A(r4, r8)
            if (r5 == 0) goto L72
            r3 = r4
        L72:
            int r3 = r3 + 1
            goto L3b
        L75:
            if (r3 == r7) goto L78
        L77:
            return r3
        L78:
            return r1
        L79:
            int r7 = r8.length()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.N(int, java.lang.CharSequence):int");
    }

    public static int O(int i, CharSequence charSequence) {
        while (i < charSequence.length()) {
            switch (charSequence.charAt(i)) {
                case '[':
                    return -1;
                case '\\':
                    int i6 = i + 1;
                    if (!t1.A(i6, charSequence)) {
                        break;
                    } else {
                        i = i6;
                        break;
                    }
                case ']':
                    return i;
            }
            i++;
        }
        return charSequence.length();
    }

    public static int P(CharSequence charSequence, int i, char c9) {
        while (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            if (charAt == '\\') {
                int i6 = i + 1;
                if (t1.A(i6, charSequence)) {
                    i = i6;
                    i++;
                }
            }
            if (charAt == c9) {
                return i;
            }
            if (c9 == ')' && charAt == '(') {
                return -1;
            }
            i++;
        }
        return charSequence.length();
    }

    public static void Q(int i, Bundle bundle, Parcel parcel) {
        if (bundle == null) {
            return;
        }
        int Y = Y(parcel, i);
        parcel.writeBundle(bundle);
        a0(parcel, Y);
    }

    public static void R(Parcel parcel, int i, IBinder iBinder) {
        if (iBinder == null) {
            return;
        }
        int Y = Y(parcel, i);
        parcel.writeStrongBinder(iBinder);
        a0(parcel, Y);
    }

    public static void S(Parcel parcel, int i, Parcelable parcelable, int i6) {
        if (parcelable == null) {
            return;
        }
        int Y = Y(parcel, i);
        parcelable.writeToParcel(parcel, i6);
        a0(parcel, Y);
    }

    public static void T(Parcel parcel, int i, String str) {
        if (str == null) {
            return;
        }
        int Y = Y(parcel, i);
        parcel.writeString(str);
        a0(parcel, Y);
    }

    public static void U(Parcel parcel, int i, Parcelable[] parcelableArr, int i6) {
        if (parcelableArr == null) {
            return;
        }
        int Y = Y(parcel, i);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int dataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int dataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i6);
                int dataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(dataPosition);
                parcel.writeInt(dataPosition3 - dataPosition2);
                parcel.setDataPosition(dataPosition3);
            }
        }
        a0(parcel, Y);
    }

    public static void V(Parcel parcel, int i, List list) {
        if (list == null) {
            return;
        }
        int Y = Y(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            Parcelable parcelable = (Parcelable) list.get(i6);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int dataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int dataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int dataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(dataPosition);
                parcel.writeInt(dataPosition3 - dataPosition2);
                parcel.setDataPosition(dataPosition3);
            }
        }
        a0(parcel, Y);
    }

    public static int W(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i != 3) {
            return i != 4 ? 0 : 5;
        }
        return 4;
    }

    public static void X(Parcel parcel, int i, int i6) {
        parcel.writeInt(i | (i6 << 16));
    }

    public static int Y(Parcel parcel, int i) {
        parcel.writeInt(i | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static Object Z(Class cls, String str, q... qVarArr) {
        int length = qVarArr.length;
        Class<?>[] clsArr = new Class[length];
        Object[] objArr = new Object[length];
        for (int i = 0; i < qVarArr.length; i++) {
            q qVar = qVarArr[i];
            qVar.getClass();
            clsArr[i] = (Class) qVar.f7780b;
            objArr[i] = qVarArr[i].f7781l;
        }
        return cls.getDeclaredMethod(str, clsArr).invoke(null, objArr);
    }

    public static final Spanned a(String str) {
        str.getClass();
        Spanned fromHtml = HtmlCompat.fromHtml(u.o0(u.o0(u.o0(u.o0(u.o0(u.o0(str, "<ul>", "<customUl>", true), "</ul>", "</customUl>", true), "<ol>", "<customOl>", true), "<ol>", "</customOl>", true), "<li>", "<customLi>", true), "</li>", "</customLi>", true), 0, null, new i8.a());
        fromHtml.getClass();
        return fromHtml;
    }

    public static void a0(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Vector b(int i, String str) {
        if (str.length() != i) {
            throw new w5.e(l.g(": bitfield encoding length mismatch", "h.e"));
        }
        int i6 = 1;
        Vector vector = new Vector(null, i6, 0 == true ? 1 : 0);
        if (1 <= i) {
            while (true) {
                int i10 = i6 + 1;
                String valueOf = String.valueOf(str.charAt(i6 - 1));
                valueOf.getClass();
                if (valueOf.equals("1")) {
                    vector.set(i6);
                }
                if (i6 == i) {
                    break;
                }
                i6 = i10;
            }
        }
        vector.setBitLength(str.length());
        return vector;
    }

    public static boolean b0(byte b7) {
        return b7 > -65;
    }

    public static /* synthetic */ String c(int i) {
        switch (i) {
            case 1:
                return "FEATURE";
            case 2:
                return "NON_IAB";
            case 3:
                return "PURPOSES";
            case 4:
                return "LEGITIMATE_PURPOSES";
            case 5:
                return "LEGITIMATE_VENDORS";
            case 6:
                return "SPECIAL_PURPOSES";
            case 7:
                return "SPECIAL_FEATURES";
            case 8:
                return "VENDORS";
            case 9:
                return "STACKS";
            case 10:
                return "GOOGLE";
            default:
                return "null";
        }
    }

    public static void d(int i, String str, String str2, Throwable th, Boolean bool) {
        if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
            throw null;
        }
        if (l.a(bool, Boolean.TRUE)) {
            if (i == 0) {
                throw null;
            }
            int i6 = i - 1;
            if (i6 == 0) {
                Log.v(str, str2, th);
                return;
            }
            if (i6 == 1) {
                Log.d(str, str2, th);
                return;
            }
            if (i6 == 2) {
                Log.i(str, str2, th);
            } else if (i6 == 3) {
                Log.w(str, str2, th);
            } else {
                if (i6 != 4) {
                    return;
                }
                Log.e(str, str2, th);
            }
        }
    }

    public static void e(ImageView imageView, Context context) {
        Bitmap bitmap;
        imageView.getClass();
        File file = new File(context.getCacheDir(), "im_cmp_image_cache");
        file.mkdirs();
        File file2 = new File(file, l.g(".bin", "inmobi_branding_logo"));
        if (!file2.exists() || file2.length() == 0) {
            h("ImageLoader", l.g("inmobi_branding_logo", "Slot file missing or empty: "), null, 12);
            bitmap = null;
        } else {
            bitmap = BitmapFactory.decodeFile(file2.getAbsolutePath());
        }
        if (bitmap != null) {
            h("ImageLoader", l.g("inmobi_branding_logo", "Loaded image from slot: "), null, 12);
            imageView.setImageBitmap(bitmap);
        } else {
            h("ImageLoader", l.g("inmobi_branding_logo", "Falling back to resource for slot: "), null, 12);
            imageView.setImageResource(2131230981);
        }
    }

    public static void f(String str) {
        d(2, "FontManager", str, null, Boolean.FALSE);
    }

    public static void g(String str, String str2) {
        str2.getClass();
        d(3, str, str2, null, Boolean.FALSE);
    }

    public static void h(String str, String str2, Exception exc, int i) {
        Boolean bool = Boolean.TRUE;
        if ((i & 1) != 0) {
            str = "Inmobi Cmp";
        }
        if ((i & 4) != 0) {
            exc = null;
        }
        if ((i & 8) != 0) {
            bool = Boolean.FALSE;
        }
        str2.getClass();
        d(5, str, str2, exc, bool);
    }

    public static void i(StringBuilder sb, Object obj, d7.l lVar) {
        if (lVar != null) {
            sb.append((CharSequence) lVar.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) obj.toString());
        }
    }

    public static float j(float f) {
        float f10 = f / 2.0f;
        if (f10 < 0.5d) {
            return 0.5f;
        }
        return f10;
    }

    public static final boolean k(byte[] bArr, int i, byte[] bArr2, int i6, int i10) {
        bArr.getClass();
        bArr2.getClass();
        for (int i11 = 0; i11 < i10; i11++) {
            if (bArr[i11 + i] != bArr2[i11 + i6]) {
                return false;
            }
        }
        return true;
    }

    public static String l(int i, int i6, String str) {
        if (i < 0) {
            return t1.F("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i6 >= 0) {
            return t1.F("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i6));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i6);
        throw new IllegalArgumentException(sb.toString());
    }

    public static r6.c m(r6.c cVar) {
        cVar.k();
        cVar.f8922l = true;
        return cVar.f8921b > 0 ? cVar : r6.c.f8919m;
    }

    public static void n(int i, int i6) {
        String F;
        if (i < 0 || i >= i6) {
            if (i < 0) {
                F = t1.F("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else {
                if (i6 < 0) {
                    StringBuilder sb = new StringBuilder(26);
                    sb.append("negative size: ");
                    sb.append(i6);
                    throw new IllegalArgumentException(sb.toString());
                }
                F = t1.F("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i6));
            }
            throw new IndexOutOfBoundsException(F);
        }
    }

    public static final void o(long j, long j6, long j10) {
        if ((j6 | j10) < 0 || j6 > j || j - j6 < j10) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j6 + " byteCount=" + j10);
        }
    }

    public static void p(int i, int i6) {
        if (i < 0 || i > i6) {
            com.google.gson.internal.a.r(l(i, i6, "index"));
        }
    }

    public static void q(int i, int i6, int i10) {
        if (i < 0 || i6 < i || i6 > i10) {
            throw new IndexOutOfBoundsException((i < 0 || i > i10) ? l(i, i10, "start index") : (i6 < 0 || i6 > i10) ? l(i6, i10, "end index") : t1.F("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i)));
        }
    }

    public static void r(Context context) {
        File externalFilesDir;
        r rVar;
        context.getClass();
        g l10 = g.D.l(context);
        l10.b();
        ArrayList a0 = l10.a0();
        l10.c();
        h4.a aVar = new h4.a(context);
        if (aVar.d()) {
            File[] externalFilesDirs = context.getExternalFilesDirs(null);
            if (externalFilesDirs.length > 1) {
                externalFilesDir = externalFilesDirs[1];
            } else {
                File externalFilesDir2 = context.getExternalFilesDir(null);
                aVar.g();
                aVar.f();
                externalFilesDir = externalFilesDir2;
            }
        } else {
            externalFilesDir = context.getExternalFilesDir(null);
        }
        File file = new File(externalFilesDir, "Updates");
        if (!file.exists()) {
            file.mkdirs();
        }
        Iterator it = c0.m(context, file).iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            File file2 = (File) next;
            Iterator it2 = a0.iterator();
            it2.getClass();
            boolean z9 = false;
            while (it2.hasNext()) {
                Object next2 = it2.next();
                next2.getClass();
                q2 q2Var = (q2) next2;
                if (!q2Var.c() && (rVar = q2Var.f11352s) != null && !rVar.F.isEmpty()) {
                    r rVar2 = q2Var.f11352s;
                    rVar2.getClass();
                    Iterator it3 = rVar2.F.iterator();
                    it3.getClass();
                    while (true) {
                        if (it3.hasNext()) {
                            Object next3 = it3.next();
                            next3.getClass();
                            if (u.m0(((j0) next3).f11240q, file2.getAbsolutePath(), false)) {
                                z9 = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (!z9) {
                file2.delete();
            }
        }
    }

    public static s1.a s(String str, String str2) {
        a3.a aVar = new a3.a(str, str2);
        j9.u a8 = s1.a.a(a3.a.class);
        a8.f6816b = 1;
        a8.f = new androidx.core.view.inputmethod.a(aVar, 25);
        return a8.d();
    }

    public static r6.c t() {
        return new r6.c(10);
    }

    public static void u(String str, String str2, Object obj) {
        String D = D(str);
        if (Log.isLoggable(D, 3)) {
            Log.d(D, String.format(str2, obj));
        }
    }

    public static void v(String str, String str2, Exception exc) {
        String D = D(str);
        if (Log.isLoggable(D, 6)) {
            Log.e(D, str2, exc);
        }
    }

    public static List w(String str) {
        ArrayList arrayList = new ArrayList();
        k7.e eVar = new k7.e(k.a(new k("\\[(\\w+)=([\\w\\d]*)](.*?)\\[/(\\w+)]"), str));
        while (eVar.hasNext()) {
            l7.i iVar = (l7.i) eVar.next();
            int i = iVar.b().f5695a;
            String str2 = (String) ((l7.h) iVar.a()).get(1);
            long parseLong = Long.parseLong((String) ((l7.h) iVar.a()).get(2));
            String str3 = (String) ((l7.h) iVar.a()).get(3);
            Long valueOf = Long.valueOf(parseLong);
            String group = iVar.f7172a.group();
            group.getClass();
            arrayList.add(new x4.o(i, str2, valueOf, str3, group));
        }
        k7.e eVar2 = new k7.e(k.a(new k("\\[url=([^\\]]+)](.*?)\\[/url]"), str));
        while (eVar2.hasNext()) {
            l7.i iVar2 = (l7.i) eVar2.next();
            int i6 = iVar2.b().f5695a;
            String str4 = (String) ((l7.h) iVar2.a()).get(0);
            String str5 = (String) ((l7.h) iVar2.a()).get(1);
            String str6 = (String) ((l7.h) iVar2.a()).get(2);
            String group2 = iVar2.f7172a.group();
            group2.getClass();
            x4.o oVar = new x4.o(str4, str6, group2, i6);
            oVar.f = str5;
            arrayList.add(oVar);
        }
        k7.e eVar3 = new k7.e(k.a(new k("<(\\w+)>(.*?)</(\\w+)>"), str));
        while (eVar3.hasNext()) {
            l7.i iVar3 = (l7.i) eVar3.next();
            int i10 = iVar3.b().f5695a;
            String str7 = (String) ((l7.h) iVar3.a()).get(1);
            String str8 = (String) ((l7.h) iVar3.a()).get(2);
            String group3 = iVar3.f7172a.group();
            group3.getClass();
            arrayList.add(new x4.o(str7, str8, group3, i10));
        }
        return q6.l.C0(arrayList, new z(12));
    }

    public static Object x(f fVar, Object obj, p pVar) {
        pVar.getClass();
        return pVar.invoke(obj, fVar);
    }

    public static s1.a y(String str, com.google.gson.internal.a aVar) {
        j9.u a8 = s1.a.a(a3.a.class);
        a8.f6816b = 1;
        a8.c(s1.i.a(Context.class));
        a8.f = new a3.e(0, str, aVar);
        return a8.d();
    }

    public static f z(f fVar, t6.g gVar) {
        gVar.getClass();
        if (l.a(fVar.getKey(), gVar)) {
            return fVar;
        }
        return null;
    }
}
