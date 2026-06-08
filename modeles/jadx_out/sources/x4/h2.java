package x4;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Log;
import com.uptodown.UptodownApp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f11211a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11212b;

    /* renamed from: c, reason: collision with root package name */
    public long f11213c;

    public h2(e1.m mVar, String str, long j) {
        this.f11212b = mVar;
        k0.y.d(str);
        this.f11211a = str;
        this.f11213c = mVar.R("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j)}, -1L);
    }

    public static String b(long j, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j);
            return jSONObject.toString();
        } catch (JSONException e10) {
            Log.w("FirebaseMessaging", "Failed to encode token: " + e10);
            return null;
        }
    }

    public static h2 d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new h2(0L, str, (String) null);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new h2(jSONObject.getLong("timestamp"), jSONObject.getString("token"), jSONObject.getString("appVersion"));
        } catch (JSONException e10) {
            Log.w("FirebaseMessaging", "Failed to parse token: " + e10);
            return null;
        }
    }

    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis() - this.f11213c;
        float f = UptodownApp.I;
        String str = this.f11211a;
        return currentTimeMillis < ((long) ((str.equalsIgnoreCase("new_releases") || str.equalsIgnoreCase("last_updates")) ? 600000 : 1800000));
    }

    public g2 c() {
        g2 g2Var = new g2();
        String str = (String) this.f11212b;
        g2Var.f11203a = str;
        g2Var.f11204b = 200;
        g2Var.f11206d = new JSONObject(str);
        return g2Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    public List e() {
        ArrayList arrayList;
        e1.m mVar = (e1.m) this.f11212b;
        ArrayList arrayList2 = new ArrayList();
        String valueOf = String.valueOf(this.f11213c);
        String str = this.f11211a;
        Cursor cursor = null;
        try {
            try {
                cursor = mVar.V().query("raw_events", new String[]{"rowid", "name", "timestamp", "metadata_fingerprint", "data", "realtime"}, "app_id = ? and rowid > ?", new String[]{str, valueOf}, null, null, "rowid", "1000");
                if (cursor.moveToFirst()) {
                    do {
                        long j = cursor.getLong(0);
                        long j6 = cursor.getLong(3);
                        boolean z9 = cursor.getLong(5) == 1;
                        byte[] blob = cursor.getBlob(4);
                        if (j > this.f11213c) {
                            this.f11213c = j;
                        }
                        try {
                            com.google.android.gms.internal.measurement.a3 a3Var = (com.google.android.gms.internal.measurement.a3) e1.a1.T(com.google.android.gms.internal.measurement.b3.y(), blob);
                            String string = cursor.getString(1);
                            if (string == null) {
                                string = "";
                            }
                            a3Var.b();
                            ((com.google.android.gms.internal.measurement.b3) a3Var.f2687b).E(string);
                            long j10 = cursor.getLong(2);
                            a3Var.b();
                            ((com.google.android.gms.internal.measurement.b3) a3Var.f2687b).F(j10);
                            arrayList2.add(new e1.k(j, j6, z9, (com.google.android.gms.internal.measurement.b3) a3Var.d()));
                        } catch (IOException e10) {
                            e1.w0 w0Var = mVar.f3875a.f4264o;
                            e1.t1.m(w0Var);
                            w0Var.f4339o.d(e1.w0.o(str), "Data loss. Failed to merge raw event. appId", e10);
                        }
                    } while (cursor.moveToNext());
                } else {
                    arrayList = Collections.EMPTY_LIST;
                }
            } catch (SQLiteException e11) {
                e1.w0 w0Var2 = mVar.f3875a.f4264o;
                e1.t1.m(w0Var2);
                w0Var2.f4339o.d(e1.w0.o(str), "Data loss. Error querying raw events batch. appId", e11);
                arrayList = arrayList2;
            }
            return arrayList;
        } finally {
            if (0 != 0) {
                cursor.close();
            }
        }
    }

    public h2(e1.m mVar, String str) {
        this.f11212b = mVar;
        k0.y.d(str);
        this.f11211a = str;
        this.f11213c = -1L;
    }

    public h2(String str, String str2) {
        this.f11211a = str;
        this.f11212b = str2;
        this.f11213c = System.currentTimeMillis();
    }

    public h2(long j, String str, String str2) {
        this.f11211a = str;
        this.f11212b = str2;
        this.f11213c = j;
    }
}
