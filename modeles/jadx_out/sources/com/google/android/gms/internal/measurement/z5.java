package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z5 implements k1.d, d6 {

    /* renamed from: b, reason: collision with root package name */
    public static final j5 f2933b = new j5(3);

    /* renamed from: a, reason: collision with root package name */
    public final Object f2934a;

    public z5(int i) {
        switch (i) {
            case 1:
                this.f2934a = new HashMap();
                break;
            default:
                j6 j6Var = j6.f2671c;
                z5 z5Var = new z5(new d6[]{j5.f2669b, f2933b});
                Charset charset = r5.f2778a;
                this.f2934a = z5Var;
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.d6
    public boolean a(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (((d6[]) this.f2934a)[i].a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.d6
    public l6 b(Class cls) {
        for (int i = 0; i < 2; i++) {
            d6 d6Var = ((d6[]) this.f2934a)[i];
            if (d6Var.a(cls)) {
                return d6Var.b(cls);
            }
        }
        a3.b.r("No factory is available for message type: ".concat(cls.getName()));
        return null;
    }

    public /* synthetic */ Object c() {
        f4 f4Var = (f4) this.f2934a;
        ContentResolver contentResolver = f4Var.f2571a;
        Uri uri = f4Var.f2572b;
        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        try {
            if (acquireUnstableContentProviderClient == null) {
                Log.w("ConfigurationContentLdr", "Unable to acquire ContentProviderClient, using default values");
                return Collections.EMPTY_MAP;
            }
            Cursor query = acquireUnstableContentProviderClient.query(uri, f4.j, null, null, null);
            try {
                if (query == null) {
                    Log.w("ConfigurationContentLdr", "ContentProvider query returned null cursor, using default values");
                    return Collections.EMPTY_MAP;
                }
                int count = query.getCount();
                if (count == 0) {
                    Map map = Collections.EMPTY_MAP;
                    query.close();
                    return map;
                }
                Map arrayMap = count <= 256 ? new ArrayMap(count) : new HashMap(count, 1.0f);
                while (query.moveToNext()) {
                    arrayMap.put(query.getString(0), query.getString(1));
                }
                if (query.isAfterLast()) {
                    query.close();
                    return arrayMap;
                }
                Log.w("ConfigurationContentLdr", "Cursor read incomplete (ContentProvider dead?), using default values");
                Map map2 = Collections.EMPTY_MAP;
                query.close();
                return map2;
            } finally {
            }
        } catch (RemoteException e10) {
            Log.w("ConfigurationContentLdr", "ContentProvider query failed, using default values", e10);
            return Collections.EMPTY_MAP;
        } finally {
            acquireUnstableContentProviderClient.release();
        }
    }

    public void d(int i, Object obj, m6 m6Var) {
        s4 s4Var = (s4) obj;
        b5 b5Var = (b5) this.f2934a;
        b5Var.m((i << 3) | 2);
        b5Var.m(s4Var.b(m6Var));
        m6Var.d(s4Var, b5Var.f2512a);
    }

    public void e(int i, Object obj, m6 m6Var) {
        b5 b5Var = (b5) this.f2934a;
        b5Var.c(i, 3);
        m6Var.d((s4) obj, b5Var.f2512a);
        b5Var.c(i, 4);
    }

    @Override // k1.d
    public /* synthetic */ Object get() {
        Object obj = n4.g;
        return j4.c((Context) this.f2934a);
    }

    public /* synthetic */ z5(Object obj) {
        this.f2934a = obj;
    }

    public z5(b5 b5Var) {
        Charset charset = r5.f2778a;
        this.f2934a = b5Var;
        b5Var.f2512a = this;
    }
}
