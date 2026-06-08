package com.google.android.gms.internal.measurement;

import android.net.Uri;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n4 {
    public static final Object g = new Object();
    public static volatile d4 h;
    public static final AtomicInteger i;

    /* renamed from: a, reason: collision with root package name */
    public final a2.i f2721a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2722b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f2723c;

    /* renamed from: d, reason: collision with root package name */
    public volatile int f2724d = -1;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f2725e;
    public final /* synthetic */ int f;

    static {
        new AtomicReference();
        i = new AtomicInteger();
    }

    public /* synthetic */ n4(a2.i iVar, String str, Object obj, int i6) {
        this.f = i6;
        if (((Uri) iVar.f23b) == null) {
            com.google.gson.internal.a.p("Must pass a valid SharedPreferences file name or ContentProvider URI");
            throw null;
        }
        this.f2721a = iVar;
        this.f2722b = str;
        this.f2723c = obj;
    }

    public final Object a(Object obj) {
        switch (this.f) {
            case 0:
                if (!(obj instanceof Long)) {
                    if (obj instanceof String) {
                        try {
                            break;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    String obj2 = obj.toString();
                    String str = this.f2722b;
                    StringBuilder sb = new StringBuilder(str.length() + 25 + obj2.length());
                    sb.append("Invalid long value for ");
                    sb.append(str);
                    sb.append(": ");
                    sb.append(obj2);
                    Log.e("PhenotypeFlag", sb.toString());
                    break;
                } else {
                    break;
                }
            case 1:
                if (!(obj instanceof Boolean)) {
                    if (obj instanceof String) {
                        String str2 = (String) obj;
                        if (!y3.f2910b.matcher(str2).matches()) {
                            if (y3.f2911c.matcher(str2).matches()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    String obj3 = obj.toString();
                    String str3 = this.f2722b;
                    StringBuilder sb2 = new StringBuilder(str3.length() + 28 + obj3.length());
                    sb2.append("Invalid boolean value for ");
                    sb2.append(str3);
                    sb2.append(": ");
                    sb2.append(obj3);
                    Log.e("PhenotypeFlag", sb2.toString());
                    break;
                } else {
                    break;
                }
            case 2:
                if (!(obj instanceof Double)) {
                    if (!(obj instanceof Float)) {
                        if (obj instanceof String) {
                            try {
                                break;
                            } catch (NumberFormatException unused2) {
                            }
                        }
                        String obj4 = obj.toString();
                        String str4 = this.f2722b;
                        StringBuilder sb3 = new StringBuilder(str4.length() + 27 + obj4.length());
                        sb3.append("Invalid double value for ");
                        sb3.append(str4);
                        sb3.append(": ");
                        sb3.append(obj4);
                        Log.e("PhenotypeFlag", sb3.toString());
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            default:
                if (obj instanceof String) {
                    break;
                }
                break;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0062 A[Catch: all -> 0x0055, TryCatch #0 {all -> 0x0055, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0016, B:11:0x0024, B:13:0x0034, B:16:0x0048, B:21:0x0062, B:23:0x006a, B:25:0x0072, B:27:0x0082, B:29:0x0090, B:32:0x00b5, B:35:0x00bd, B:36:0x00c0, B:37:0x00c4, B:38:0x0099, B:40:0x009d, B:42:0x00ab, B:44:0x00b1, B:48:0x00c9, B:49:0x00cb, B:51:0x00cc, B:52:0x00d1, B:54:0x0041, B:56:0x00d2), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0099 A[Catch: all -> 0x0055, TryCatch #0 {all -> 0x0055, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0016, B:11:0x0024, B:13:0x0034, B:16:0x0048, B:21:0x0062, B:23:0x006a, B:25:0x0072, B:27:0x0082, B:29:0x0090, B:32:0x00b5, B:35:0x00bd, B:36:0x00c0, B:37:0x00c4, B:38:0x0099, B:40:0x009d, B:42:0x00ab, B:44:0x00b1, B:48:0x00c9, B:49:0x00cb, B:51:0x00cc, B:52:0x00d1, B:54:0x0041, B:56:0x00d2), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cc A[Catch: all -> 0x0055, TryCatch #0 {all -> 0x0055, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0016, B:11:0x0024, B:13:0x0034, B:16:0x0048, B:21:0x0062, B:23:0x006a, B:25:0x0072, B:27:0x0082, B:29:0x0090, B:32:0x00b5, B:35:0x00bd, B:36:0x00c0, B:37:0x00c4, B:38:0x0099, B:40:0x009d, B:42:0x00ab, B:44:0x00b1, B:48:0x00c9, B:49:0x00cb, B:51:0x00cc, B:52:0x00d1, B:54:0x0041, B:56:0x00d2), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b() {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.n4.b():java.lang.Object");
    }
}
