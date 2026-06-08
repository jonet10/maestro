package e1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.f8;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m extends p4 {

    /* renamed from: o, reason: collision with root package name */
    public static final String[] f4093o = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* renamed from: p, reason: collision with root package name */
    public static final String[] f4094p = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};

    /* renamed from: q, reason: collision with root package name */
    public static final String[] f4095q = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* renamed from: r, reason: collision with root package name */
    public static final String[] f4096r = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;", "gmp_version_for_remote_config", "ALTER TABLE apps ADD COLUMN gmp_version_for_remote_config INTEGER;"};

    /* renamed from: s, reason: collision with root package name */
    public static final String[] f4097s = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* renamed from: t, reason: collision with root package name */
    public static final String[] f4098t = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* renamed from: u, reason: collision with root package name */
    public static final String[] f4099u = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] v = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: w, reason: collision with root package name */
    public static final String[] f4100w = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* renamed from: x, reason: collision with root package name */
    public static final String[] f4101x = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};

    /* renamed from: y, reason: collision with root package name */
    public static final String[] f4102y = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    /* renamed from: m, reason: collision with root package name */
    public final l f4103m;

    /* renamed from: n, reason: collision with root package name */
    public final s0 f4104n;

    public m(u4 u4Var) {
        super(u4Var);
        this.f4104n = new s0(this.f3875a.f4269t);
        this.f3875a.getClass();
        this.f4103m = new l(this, this.f3875a.f4259a);
    }

    public static final String J(List list) {
        return list.isEmpty() ? "" : androidx.lifecycle.l.w(" AND (upload_type IN (", TextUtils.join(", ", list), "))");
    }

    public static final void P(ContentValues contentValues, Object obj) {
        k0.y.d("value");
        k0.y.g(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
            return;
        }
        if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put("value", (Double) obj);
        } else {
            com.google.gson.internal.a.p("Invalid value type");
        }
    }

    public final void A(String str, j4 j4Var) {
        g();
        h();
        k0.y.d(str);
        t1 t1Var = this.f3875a;
        p0.a aVar = t1Var.f4269t;
        w0 w0Var = t1Var.f4264o;
        aVar.getClass();
        long currentTimeMillis = System.currentTimeMillis();
        e0 e0Var = f0.f3960w0;
        long longValue = currentTimeMillis - ((Long) e0Var.a(null)).longValue();
        long j = j4Var.f4063b;
        if (j < longValue || j > ((Long) e0Var.a(null)).longValue() + currentTimeMillis) {
            t1.m(w0Var);
            w0Var.f4342r.e("Storing trigger URI outside of the max retention time span. appId, now, timestamp", w0.o(str), Long.valueOf(currentTimeMillis), Long.valueOf(j));
        }
        t1.m(w0Var);
        w0Var.f4346w.b("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", j4Var.f4062a);
        contentValues.put("source", Integer.valueOf(j4Var.f4064l));
        contentValues.put("timestamp_millis", Long.valueOf(j));
        try {
            if (V().insert("trigger_uris", null, contentValues) == -1) {
                t1.m(w0Var);
                w0Var.f4339o.c(w0.o(str), "Failed to insert trigger URI (got -1). appId");
            }
        } catch (SQLiteException e10) {
            t1.m(w0Var);
            w0Var.f4339o.d(w0.o(str), "Error storing trigger URI. appId", e10);
        }
    }

    public final void B(String str, j2 j2Var) {
        k0.y.g(str);
        k0.y.g(j2Var);
        g();
        h();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", j2Var.g());
        contentValues.put("consent_source", Integer.valueOf(j2Var.f4056b));
        D(contentValues);
    }

    public final String C(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                cursor = V().rawQuery(str, strArr);
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return "";
                }
                String string = cursor.getString(0);
                cursor.close();
                return string;
            } catch (SQLiteException e10) {
                w0 w0Var = this.f3875a.f4264o;
                t1.m(w0Var);
                w0Var.f4339o.d(str, "Database error", e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void D(ContentValues contentValues) {
        t1 t1Var = this.f3875a;
        try {
            SQLiteDatabase V = V();
            if (contentValues.getAsString("app_id") == null) {
                w0 w0Var = t1Var.f4264o;
                t1.m(w0Var);
                w0Var.f4341q.c(w0.o("app_id"), "Value of the primary key is not set.");
                return;
            }
            new StringBuilder(10).append("app_id = ?");
            if (V.update("consent_settings", contentValues, r6.toString(), new String[]{r5}) == 0 && V.insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                w0 w0Var2 = t1Var.f4264o;
                t1.m(w0Var2);
                w0Var2.f4339o.d(w0.o("consent_settings"), "Failed to insert/update table (got -1). key", w0.o("app_id"));
            }
        } catch (SQLiteException e10) {
            w0 w0Var3 = t1Var.f4264o;
            t1.m(w0Var3);
            w0Var3.f4339o.e("Error storing into table. key", w0.o("consent_settings"), w0.o("app_id"), e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final e1.r E(java.lang.String r31, java.lang.String r32, java.lang.String r33) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.m.E(java.lang.String, java.lang.String, java.lang.String):e1.r");
    }

    public final void F(String str, r rVar) {
        t1 t1Var = this.f3875a;
        k0.y.g(rVar);
        g();
        h();
        ContentValues contentValues = new ContentValues();
        String str2 = rVar.f4223a;
        contentValues.put("app_id", str2);
        contentValues.put("name", rVar.f4224b);
        contentValues.put("lifetime_count", Long.valueOf(rVar.f4225c));
        contentValues.put("current_bundle_count", Long.valueOf(rVar.f4226d));
        contentValues.put("last_fire_timestamp", Long.valueOf(rVar.f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(rVar.g));
        contentValues.put("last_bundled_day", rVar.h);
        contentValues.put("last_sampled_complex_event_id", rVar.i);
        contentValues.put("last_sampling_rate", rVar.j);
        contentValues.put("current_session_count", Long.valueOf(rVar.f4227e));
        Boolean bool = rVar.f4228k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (V().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                w0 w0Var = t1Var.f4264o;
                t1.m(w0Var);
                w0Var.f4339o.c(w0.o(str2), "Failed to insert/update event aggregates (got -1). appId");
            }
        } catch (SQLiteException e10) {
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4339o.d(w0.o(str2), "Error storing event aggregates. appId", e10);
        }
    }

    public final void G(String str, String str2) {
        k0.y.d(str2);
        g();
        h();
        try {
            V().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e10) {
            w0 w0Var = this.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.d(w0.o(str2), "Error deleting snapshot. appId", e10);
        }
    }

    public final w4 H(String str, long j, byte[] bArr, String str2, String str3, int i, int i6, long j6, long j10, long j11) {
        w4 w4Var;
        t1 t1Var;
        i3 i3Var;
        boolean isEmpty = TextUtils.isEmpty(str2);
        t1 t1Var2 = this.f3875a;
        if (isEmpty) {
            w0 w0Var = t1Var2.f4264o;
            t1.m(w0Var);
            w0Var.v.b("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            com.google.android.gms.internal.measurement.g3 g3Var = (com.google.android.gms.internal.measurement.g3) a1.T(com.google.android.gms.internal.measurement.h3.v(), bArr);
            i3[] values = i3.values();
            int length = values.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    i3Var = i3.UNKNOWN;
                    break;
                }
                i3Var = values[i10];
                if (i3Var.f4046a == i) {
                    break;
                }
                i10++;
            }
            i3 i3Var2 = i3Var;
            if (i3Var2 != i3.GOOGLE_SIGNAL && i3Var2 != i3.GOOGLE_SIGNAL_PENDING && i6 > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = DesugarCollections.unmodifiableList(((com.google.android.gms.internal.measurement.h3) g3Var.f2687b).o()).iterator();
                while (it.hasNext()) {
                    com.google.android.gms.internal.measurement.i3 i3Var3 = (com.google.android.gms.internal.measurement.i3) ((com.google.android.gms.internal.measurement.j3) it.next()).h();
                    i3Var3.b();
                    ((com.google.android.gms.internal.measurement.j3) i3Var3.f2687b).S0(i6);
                    arrayList.add((com.google.android.gms.internal.measurement.j3) i3Var3.d());
                }
                g3Var.b();
                ((com.google.android.gms.internal.measurement.h3) g3Var.f2687b).A();
                g3Var.b();
                ((com.google.android.gms.internal.measurement.h3) g3Var.f2687b).z(arrayList);
            }
            HashMap hashMap = new HashMap();
            if (str3 != null) {
                String[] split = str3.split("\r\n");
                int length2 = split.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length2) {
                        break;
                    }
                    String str4 = split[i11];
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] split2 = str4.split("=", 2);
                    if (split2.length != 2) {
                        w0 w0Var2 = t1Var2.f4264o;
                        t1.m(w0Var2);
                        w0Var2.f4339o.c(str4, "Invalid upload header: ");
                        break;
                    }
                    hashMap.put(split2[0], split2[1]);
                    i11++;
                }
            }
            w4Var = null;
            t1Var = t1Var2;
            try {
                return new w4(j, (com.google.android.gms.internal.measurement.h3) g3Var.d(), str2, hashMap, i3Var2, j6, j10, j11, i6);
            } catch (IOException e10) {
                e = e10;
                w0 w0Var3 = t1Var.f4264o;
                t1.m(w0Var3);
                w0Var3.f4339o.d(str, "Failed to queued MeasurementBatch from upload_queue. appId", e);
                return w4Var;
            }
        } catch (IOException e11) {
            e = e11;
            w4Var = null;
            t1Var = t1Var2;
        }
    }

    public final String I() {
        this.f3875a.f4269t.getClass();
        long currentTimeMillis = System.currentTimeMillis();
        Locale locale = Locale.US;
        Long l10 = (Long) f0.T.a(null);
        l10.getClass();
        String str = "(upload_type = 1 AND ABS(creation_timestamp - " + currentTimeMillis + ") > " + l10 + ")";
        long longValue = ((Long) f0.S.a(null)).longValue();
        StringBuilder sb = new StringBuilder("(upload_type != 1 AND ABS(creation_timestamp - ");
        sb.append(currentTimeMillis);
        sb.append(") > ");
        String l11 = a4.x.l(sb, longValue, ")");
        StringBuilder sb2 = new StringBuilder(str.length() + 5 + l11.length() + 1);
        a4.x.B(sb2, "(", str, " OR ", l11);
        sb2.append(")");
        return sb2.toString();
    }

    public final void K(String str, j2 j2Var) {
        k0.y.g(str);
        g();
        h();
        B(str, z(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", j2Var.g());
        D(contentValues);
    }

    public final j2 L(String str) {
        k0.y.g(str);
        g();
        h();
        return j2.c(100, C("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}));
    }

    public final r M(String str, com.google.android.gms.internal.measurement.b3 b3Var, String str2) {
        r E = E("events", str, b3Var.r());
        if (E != null) {
            long j = E.f4227e + 1;
            long j6 = E.f4226d + 1;
            return new r(E.f4223a, E.f4224b, E.f4225c + 1, j6, j, E.f, E.g, E.h, E.i, E.j, E.f4228k);
        }
        t1 t1Var = this.f3875a;
        w0 w0Var = t1Var.f4264o;
        t1.m(w0Var);
        w0Var.f4342r.d(w0.o(str), "Event aggregate wasn't created during raw event logging. appId, event", t1Var.f4268s.a(str2));
        return new r(str, b3Var.r(), 1L, 1L, 1L, b3Var.t(), 0L, null, null, null, null);
    }

    public final boolean N() {
        return this.f3875a.f4259a.getDatabasePath("google_app_measurement.db").exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O(java.lang.String r21, long r22, long r24, e1.f1 r26) {
        /*
            Method dump skipped, instructions count: 591
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.m.O(java.lang.String, long, long, e1.f1):void");
    }

    public final long Q(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = V().rawQuery(str, strArr);
                if (!rawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = rawQuery.getLong(0);
                rawQuery.close();
                return j;
            } catch (SQLiteException e10) {
                w0 w0Var = this.f3875a.f4264o;
                t1.m(w0Var);
                w0Var.f4339o.d(str, "Database error", e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long R(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            try {
                cursor = V().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    j = cursor.getLong(0);
                }
                cursor.close();
                return j;
            } catch (SQLiteException e10) {
                w0 w0Var = this.f3875a.f4264o;
                t1.m(w0Var);
                w0Var.f4339o.d(str, "Database error", e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void S() {
        h();
        V().beginTransaction();
    }

    public final void T() {
        h();
        V().setTransactionSuccessful();
    }

    public final void U() {
        h();
        V().endTransaction();
    }

    public final SQLiteDatabase V() {
        g();
        try {
            return this.f4103m.getWritableDatabase();
        } catch (SQLiteException e10) {
            w0 w0Var = this.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4342r.c(e10, "Error opening database");
            throw e10;
        }
    }

    public final void W(String str) {
        r E;
        G("events_snapshot", str);
        Cursor cursor = null;
        try {
            try {
                cursor = V().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        String string = cursor.getString(0);
                        if (string != null && (E = E("events", str, string)) != null) {
                            F("events_snapshot", E);
                        }
                    } while (cursor.moveToNext());
                }
            } catch (SQLiteException e10) {
                w0 w0Var = this.f3875a.f4264o;
                t1.m(w0Var);
                w0Var.f4339o.d(w0.o(str), "Error creating snapshot. appId", e10);
            }
            if (cursor != null) {
                cursor.close();
            }
        } finally {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0059, code lost:
    
        if (r8 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005b, code lost:
    
        F("events", r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bf, code lost:
    
        if (r8 != null) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void X(java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.m.X(java.lang.String):void");
    }

    public final void Y(String str, String str2) {
        k0.y.d(str);
        k0.y.d(str2);
        g();
        h();
        try {
            V().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            t1 t1Var = this.f3875a;
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.e("Error deleting user property. appId", w0.o(str), t1Var.f4268s.c(str2), e10);
        }
    }

    public final boolean Z(y4 y4Var) {
        String str = y4Var.f4426b;
        g();
        h();
        String str2 = y4Var.f4425a;
        String str3 = y4Var.f4427c;
        y4 a0 = a0(str2, str3);
        t1 t1Var = this.f3875a;
        if (a0 == null) {
            if (a5.f0(str3)) {
                if (Q("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str2}) >= Math.max(Math.min(t1Var.f4262m.o(str2, f0.W), 100), 25)) {
                    return false;
                }
            } else if (!"_npa".equals(str3)) {
                long Q = Q("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str2, str});
                t1Var.getClass();
                if (Q >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str2);
        contentValues.put("origin", str);
        contentValues.put("name", str3);
        contentValues.put("set_timestamp", Long.valueOf(y4Var.f4428d));
        P(contentValues, y4Var.f4429e);
        try {
            if (V().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.c(w0.o(str2), "Failed to insert/update user property (got -1). appId");
            return true;
        } catch (SQLiteException e10) {
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4339o.d(w0.o(str2), "Error storing user property. appId", e10);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final e1.y4 a0(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            e1.t1 r1 = r11.f3875a
            k0.y.d(r12)
            k0.y.d(r13)
            r11.g()
            r11.h()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r11.V()     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L77
            java.lang.String r4 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r5 = "value"
            java.lang.String r6 = "origin"
            java.lang.String[] r5 = new java.lang.String[]{r0, r5, r6}     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L77
            java.lang.String r6 = "app_id=? and name=?"
            java.lang.String[] r7 = new java.lang.String[]{r12, r13}     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L77
            r9 = 0
            r10 = 0
            r8 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L77
            boolean r0 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L6e
            if (r0 != 0) goto L34
            goto L92
        L34:
            r0 = 0
            long r8 = r3.getLong(r0)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L6e
            r0 = 1
            java.lang.Object r10 = r11.t(r3, r0)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L6e
            if (r10 != 0) goto L41
            goto L92
        L41:
            r0 = 2
            java.lang.String r6 = r3.getString(r0)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L6e
            e1.y4 r4 = new e1.y4     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L6e
            r5 = r12
            r7 = r13
            r4.<init>(r5, r6, r7, r8, r10)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            boolean r12 = r3.moveToNext()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            if (r12 == 0) goto L6a
            e1.w0 r12 = r1.f4264o     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            e1.t1.m(r12)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            e1.u0 r12 = r12.f4339o     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            java.lang.String r13 = "Got multiple records for user property, expected one. appId"
            e1.v0 r0 = e1.w0.o(r5)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            r12.c(r0, r13)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteException -> L67
            goto L6a
        L64:
            r0 = move-exception
            r12 = r0
            goto L72
        L67:
            r0 = move-exception
        L68:
            r12 = r0
            goto L7c
        L6a:
            r3.close()
            return r4
        L6e:
            r0 = move-exception
            r5 = r12
            r7 = r13
            goto L68
        L72:
            r2 = r3
            goto L98
        L74:
            r0 = move-exception
            r12 = r0
            goto L98
        L77:
            r0 = move-exception
            r5 = r12
            r7 = r13
            r12 = r0
            r3 = r2
        L7c:
            e1.w0 r13 = r1.f4264o     // Catch: java.lang.Throwable -> L64
            e1.t1.m(r13)     // Catch: java.lang.Throwable -> L64
            e1.u0 r13 = r13.f4339o     // Catch: java.lang.Throwable -> L64
            java.lang.String r0 = "Error querying user property. appId"
            e1.v0 r4 = e1.w0.o(r5)     // Catch: java.lang.Throwable -> L64
            e1.q0 r1 = r1.f4268s     // Catch: java.lang.Throwable -> L64
            java.lang.String r1 = r1.c(r7)     // Catch: java.lang.Throwable -> L64
            r13.e(r0, r4, r1, r12)     // Catch: java.lang.Throwable -> L64
        L92:
            if (r3 == 0) goto L97
            r3.close()
        L97:
            return r2
        L98:
            if (r2 == 0) goto L9d
            r2.close()
        L9d:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.m.a0(java.lang.String, java.lang.String):e1.y4");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List b0(java.lang.String r13) {
        /*
            r12 = this;
            e1.t1 r1 = r12.f3875a
            k0.y.d(r13)
            r12.g()
            r12.h()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r10 = "1000"
            r11 = 0
            android.database.sqlite.SQLiteDatabase r2 = r12.V()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L84
            java.lang.String r3 = "user_attributes"
            java.lang.String r4 = "name"
            java.lang.String r5 = "origin"
            java.lang.String r6 = "set_timestamp"
            java.lang.String r7 = "value"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7}     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L84
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[]{r13}     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L84
            java.lang.String r9 = "rowid"
            r1.getClass()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L84
            r7 = 0
            r8 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L84
            boolean r2 = r11.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            if (r2 == 0) goto L99
        L3c:
            r2 = 0
            java.lang.String r6 = r11.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            r2 = 1
            java.lang.String r2 = r11.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            if (r2 != 0) goto L4a
            java.lang.String r2 = ""
        L4a:
            r5 = r2
            goto L4f
        L4c:
            r0 = move-exception
            r4 = r13
            goto L87
        L4f:
            r2 = 2
            long r7 = r11.getLong(r2)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            r2 = 3
            java.lang.Object r9 = r12.t(r11, r2)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            if (r9 != 0) goto L70
            e1.w0 r2 = r1.f4264o     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            e1.t1.m(r2)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            e1.u0 r2 = r2.f4339o     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            java.lang.String r3 = "Read invalid user property value, ignoring it. appId"
            e1.v0 r4 = e1.w0.o(r13)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            r2.c(r4, r3)     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            r4 = r13
            goto L79
        L6d:
            r0 = move-exception
            r13 = r0
            goto L9f
        L70:
            e1.y4 r3 = new e1.y4     // Catch: android.database.sqlite.SQLiteException -> L4c java.lang.Throwable -> L6d
            r4 = r13
            r3.<init>(r4, r5, r6, r7, r9)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L82
            r0.add(r3)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L82
        L79:
            boolean r13 = r11.moveToNext()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L82
            if (r13 != 0) goto L80
            goto L99
        L80:
            r13 = r4
            goto L3c
        L82:
            r0 = move-exception
            goto L87
        L84:
            r0 = move-exception
            r4 = r13
            r13 = r0
        L87:
            e1.w0 r13 = r1.f4264o     // Catch: java.lang.Throwable -> L6d
            e1.t1.m(r13)     // Catch: java.lang.Throwable -> L6d
            e1.u0 r13 = r13.f4339o     // Catch: java.lang.Throwable -> L6d
            java.lang.String r1 = "Error querying user properties. appId"
            e1.v0 r2 = e1.w0.o(r4)     // Catch: java.lang.Throwable -> L6d
            r13.d(r2, r1, r0)     // Catch: java.lang.Throwable -> L6d
            java.util.List r0 = java.util.Collections.EMPTY_LIST     // Catch: java.lang.Throwable -> L6d
        L99:
            if (r11 == 0) goto L9e
            r11.close()
        L9e:
            return r0
        L9f:
            if (r11 == 0) goto La4
            r11.close()
        La4:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.m.b0(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00af, code lost:
    
        e1.t1.m(r13);
        r13.f4339o.c(1000, "Read more than the max allowed user properties, ignoring excess");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012c  */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List c0(java.lang.String r23, java.lang.String r24, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.m.c0(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final boolean d0(e eVar) {
        g();
        h();
        String str = eVar.f3882a;
        k0.y.g(str);
        y4 a0 = a0(str, eVar.f3884l.f4402b);
        t1 t1Var = this.f3875a;
        if (a0 == null) {
            long Q = Q("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            t1Var.getClass();
            if (Q >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", eVar.f3883b);
        contentValues.put("name", eVar.f3884l.f4402b);
        Object c9 = eVar.f3884l.c();
        k0.y.g(c9);
        P(contentValues, c9);
        contentValues.put("active", Boolean.valueOf(eVar.f3886n));
        contentValues.put("trigger_event_name", eVar.f3887o);
        contentValues.put("trigger_timeout", Long.valueOf(eVar.f3889q));
        u uVar = eVar.f3888p;
        a5 a5Var = t1Var.f4267r;
        w0 w0Var = t1Var.f4264o;
        t1.k(a5Var);
        contentValues.put("timed_out_event", a5.L(uVar));
        contentValues.put("creation_timestamp", Long.valueOf(eVar.f3885m));
        t1.k(a5Var);
        contentValues.put("triggered_event", a5.L(eVar.f3890r));
        contentValues.put("triggered_timestamp", Long.valueOf(eVar.f3884l.f4403l));
        contentValues.put("time_to_live", Long.valueOf(eVar.f3891s));
        contentValues.put("expired_event", a5.L(eVar.f3892t));
        try {
            if (V().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            t1.m(w0Var);
            w0Var.f4339o.c(w0.o(str), "Failed to insert/update conditional user property (got -1)");
            return true;
        } catch (SQLiteException e10) {
            t1.m(w0Var);
            w0Var.f4339o.d(w0.o(str), "Error storing conditional user property", e10);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final e1.e e0(java.lang.String r27, java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.m.e0(java.lang.String, java.lang.String):e1.e");
    }

    public final void f0(String str, String str2) {
        k0.y.d(str);
        k0.y.d(str2);
        g();
        h();
        try {
            V().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            t1 t1Var = this.f3875a;
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.e("Error deleting conditional property", w0.o(str), t1Var.f4268s.c(str2), e10);
        }
    }

    public final List g0(String str, String str2, String str3) {
        k0.y.d(str);
        g();
        h();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return h0(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        r3 = r2.f4264o;
        e1.t1.m(r3);
        r3.f4339o.c(1000, "Read more than the max allowed conditional properties, ignoring extra");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List h0(java.lang.String r29, java.lang.String[] r30) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.m.h0(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x03cc: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:973), block:B:124:0x03cc */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x03e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final e1.b1 i0(java.lang.String r53) {
        /*
            Method dump skipped, instructions count: 1006
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.m.i0(java.lang.String):e1.b1");
    }

    public final void j0(b1 b1Var, boolean z9) {
        t1 t1Var = b1Var.f3784a;
        g();
        h();
        String D = b1Var.D();
        k0.y.g(D);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", D);
        i2 i2Var = i2.ANALYTICS_STORAGE;
        u4 u4Var = this.f4092b;
        if (z9) {
            contentValues.put("app_instance_id", (String) null);
        } else if (u4Var.d(D).i(i2Var)) {
            contentValues.put("app_instance_id", b1Var.E());
        }
        contentValues.put("gmp_app_id", b1Var.G());
        if (u4Var.d(D).i(i2.AD_STORAGE)) {
            q1 q1Var = t1Var.f4265p;
            t1.m(q1Var);
            q1Var.g();
            contentValues.put("resettable_device_id_hash", b1Var.f3788e);
        }
        q1 q1Var2 = t1Var.f4265p;
        t1.m(q1Var2);
        q1Var2.g();
        contentValues.put("last_bundle_index", Long.valueOf(b1Var.g));
        q1 q1Var3 = t1Var.f4265p;
        t1.m(q1Var3);
        q1Var3.g();
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(b1Var.h));
        q1 q1Var4 = t1Var.f4265p;
        t1.m(q1Var4);
        q1Var4.g();
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(b1Var.i));
        contentValues.put("app_version", b1Var.N());
        q1 q1Var5 = t1Var.f4265p;
        t1.m(q1Var5);
        q1Var5.g();
        contentValues.put("app_store", b1Var.f3790l);
        q1 q1Var6 = t1Var.f4265p;
        t1.m(q1Var6);
        q1Var6.g();
        contentValues.put("gmp_version", Long.valueOf(b1Var.f3791m));
        q1 q1Var7 = t1Var.f4265p;
        t1.m(q1Var7);
        q1Var7.g();
        contentValues.put("dev_cert_hash", Long.valueOf(b1Var.f3792n));
        q1 q1Var8 = t1Var.f4265p;
        t1.m(q1Var8);
        q1Var8.g();
        contentValues.put("measurement_enabled", Boolean.valueOf(b1Var.f3793o));
        q1 q1Var9 = t1Var.f4265p;
        q1 q1Var10 = t1Var.f4265p;
        t1.m(q1Var9);
        q1Var9.g();
        contentValues.put("day", Long.valueOf(b1Var.J));
        t1.m(q1Var10);
        q1Var10.g();
        contentValues.put("daily_public_events_count", Long.valueOf(b1Var.K));
        t1.m(q1Var10);
        q1Var10.g();
        contentValues.put("daily_events_count", Long.valueOf(b1Var.L));
        t1.m(q1Var10);
        q1Var10.g();
        contentValues.put("daily_conversions_count", Long.valueOf(b1Var.M));
        q1 q1Var11 = t1Var.f4265p;
        t1.m(q1Var11);
        q1Var11.g();
        contentValues.put("config_fetched_time", Long.valueOf(b1Var.R));
        q1 q1Var12 = t1Var.f4265p;
        t1.m(q1Var12);
        q1Var12.g();
        contentValues.put("failed_config_fetch_time", Long.valueOf(b1Var.S));
        contentValues.put("app_version_int", Long.valueOf(b1Var.P()));
        contentValues.put("firebase_instance_id", b1Var.J());
        t1.m(q1Var10);
        q1Var10.g();
        contentValues.put("daily_error_events_count", Long.valueOf(b1Var.N));
        t1.m(q1Var10);
        q1Var10.g();
        contentValues.put("daily_realtime_events_count", Long.valueOf(b1Var.O));
        t1.m(q1Var10);
        q1Var10.g();
        contentValues.put("health_monitor_sample", b1Var.P);
        contentValues.put("android_id", (Long) 0L);
        q1 q1Var13 = t1Var.f4265p;
        t1.m(q1Var13);
        q1Var13.g();
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(b1Var.f3794p));
        contentValues.put("dynamite_version", Long.valueOf(b1Var.b()));
        if (u4Var.d(D).i(i2Var)) {
            q1 q1Var14 = t1Var.f4265p;
            t1.m(q1Var14);
            q1Var14.g();
            contentValues.put("session_stitching_token", b1Var.f3798t);
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(b1Var.y()));
        q1 q1Var15 = t1Var.f4265p;
        t1.m(q1Var15);
        q1Var15.g();
        contentValues.put("target_os_version", Long.valueOf(b1Var.v));
        q1 q1Var16 = t1Var.f4265p;
        t1.m(q1Var16);
        q1Var16.g();
        contentValues.put("session_stitching_token_hash", Long.valueOf(b1Var.f3800w));
        f8.a();
        t1 t1Var2 = this.f3875a;
        g gVar = t1Var2.f4262m;
        w0 w0Var = t1Var2.f4264o;
        if (gVar.q(D, f0.Q0)) {
            q1 q1Var17 = t1Var.f4265p;
            t1.m(q1Var17);
            q1Var17.g();
            contentValues.put("ad_services_version", Integer.valueOf(b1Var.f3801x));
            q1 q1Var18 = t1Var.f4265p;
            t1.m(q1Var18);
            q1Var18.g();
            contentValues.put("attribution_eligibility_status", Long.valueOf(b1Var.B));
        }
        q1 q1Var19 = t1Var.f4265p;
        t1.m(q1Var19);
        q1Var19.g();
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(b1Var.f3802y));
        contentValues.put("npa_metadata_value", b1Var.w());
        q1 q1Var20 = t1Var.f4265p;
        t1.m(q1Var20);
        q1Var20.g();
        contentValues.put("bundle_delivery_index", Long.valueOf(b1Var.F));
        contentValues.put("sgtm_preview_key", b1Var.C());
        t1.m(q1Var10);
        q1Var10.g();
        contentValues.put("dma_consent_state", Integer.valueOf(b1Var.D));
        t1.m(q1Var10);
        q1Var10.g();
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(b1Var.E));
        contentValues.put("serialized_npa_metadata", b1Var.s());
        contentValues.put("client_upload_eligibility", Integer.valueOf(b1Var.t()));
        q1 q1Var21 = t1Var.f4265p;
        t1.m(q1Var21);
        q1Var21.g();
        ArrayList arrayList = b1Var.f3797s;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                t1.m(w0Var);
                w0Var.f4342r.c(D, "Safelisted events should not be an empty list. appId");
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", arrayList));
            }
        }
        if (t1Var2.f4262m.q(null, f0.L0) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        q1 q1Var22 = t1Var.f4265p;
        t1.m(q1Var22);
        q1Var22.g();
        contentValues.put("unmatched_pfo", b1Var.f3803z);
        q1 q1Var23 = t1Var.f4265p;
        t1.m(q1Var23);
        q1Var23.g();
        contentValues.put("unmatched_uwa", b1Var.A);
        q1 q1Var24 = t1Var.f4265p;
        t1.m(q1Var24);
        q1Var24.g();
        contentValues.put("ad_campaign_info", b1Var.H);
        try {
            SQLiteDatabase V = V();
            if (V.update("apps", contentValues, "app_id = ?", new String[]{D}) == 0 && V.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                t1.m(w0Var);
                w0Var.f4339o.c(w0.o(D), "Failed to insert/update app (got -1). appId");
            }
        } catch (SQLiteException e10) {
            t1.m(w0Var);
            w0Var.f4339o.d(w0.o(D), "Error storing app. appId", e10);
        }
    }

    public final long k(String str, com.google.android.gms.internal.measurement.h3 h3Var, String str2, Map map, i3 i3Var, Long l10) {
        int delete;
        g();
        h();
        k0.y.g(h3Var);
        k0.y.d(str);
        g();
        h();
        boolean N = N();
        t1 t1Var = this.f3875a;
        if (N) {
            u4 u4Var = this.f4092b;
            long a8 = u4Var.f4313r.f4420o.a();
            p0.a aVar = t1Var.f4269t;
            w0 w0Var = t1Var.f4264o;
            aVar.getClass();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (Math.abs(elapsedRealtime - a8) > ((Long) f0.N.a(null)).longValue()) {
                u4Var.f4313r.f4420o.b(elapsedRealtime);
                g();
                h();
                if (N() && (delete = V().delete("upload_queue", I(), new String[0])) > 0) {
                    t1.m(w0Var);
                    w0Var.f4346w.c(Integer.valueOf(delete), "Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted");
                }
                k0.y.d(str);
                g();
                h();
                try {
                    int o10 = t1Var.f4262m.o(str, f0.A);
                    if (o10 > 0) {
                        V().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(o10)});
                    }
                } catch (SQLiteException e10) {
                    t1.m(w0Var);
                    w0Var.f4339o.d(w0.o(str), "Error deleting over the limit queued batches. appId", e10);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str4).length());
            sb.append(str3);
            sb.append("=");
            sb.append(str4);
            arrayList.add(sb.toString());
        }
        byte[] a10 = h3Var.a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", a10);
        contentValues.put("upload_uri", str2);
        StringBuilder sb2 = new StringBuilder();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            while (true) {
                sb2.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb2.append((CharSequence) "\r\n");
            }
        }
        contentValues.put("upload_headers", sb2.toString());
        contentValues.put("upload_type", Integer.valueOf(i3Var.f4046a));
        p0.a aVar2 = t1Var.f4269t;
        w0 w0Var2 = t1Var.f4264o;
        aVar2.getClass();
        contentValues.put("creation_timestamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("retry_count", (Integer) 0);
        if (l10 != null) {
            contentValues.put("associated_row_id", l10);
        }
        try {
            long insert = V().insert("upload_queue", null, contentValues);
            if (insert != -1) {
                return insert;
            }
            t1.m(w0Var2);
            w0Var2.f4339o.c(str, "Failed to insert MeasurementBatch (got -1) to upload_queue. appId");
            return -1L;
        } catch (SQLiteException e11) {
            t1.m(w0Var2);
            w0Var2.f4339o.d(str, "Error storing MeasurementBatch to upload_queue. appId", e11);
            return -1L;
        }
    }

    public final j k0(long j, String str, boolean z9, boolean z10, boolean z11, boolean z12) {
        return l0(j, str, 1L, false, false, z9, false, z10, z11, z12);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List l(java.lang.String r19, e1.n4 r20, int r21) {
        /*
            r18 = this;
            k0.y.d(r19)
            r18.g()
            r18.h()
            java.lang.String r0 = " AND NOT "
            java.lang.String r1 = "app_id=?"
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r18.V()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.lang.String r4 = "upload_queue"
            java.lang.String r5 = "rowId"
            java.lang.String r6 = "app_id"
            java.lang.String r7 = "measurement_batch"
            java.lang.String r8 = "upload_uri"
            java.lang.String r9 = "upload_headers"
            java.lang.String r10 = "upload_type"
            java.lang.String r11 = "retry_count"
            java.lang.String r12 = "creation_timestamp"
            java.lang.String r13 = "associated_row_id"
            java.lang.String r14 = "last_upload_timestamp"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14}     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r6 = r20
            java.util.List r6 = r6.f4166a     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.lang.String r6 = J(r6)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.lang.String r7 = r18.I()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            int r8 = r6.length()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            int r8 = r8 + 17
            int r9 = r7.length()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            int r8 = r8 + r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r9.<init>(r8)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r9.append(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r9.append(r6)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r9.append(r0)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r9.append(r7)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.lang.String r6 = r9.toString()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.lang.String[] r7 = new java.lang.String[]{r19}     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.lang.String r10 = "creation_timestamp ASC"
            if (r21 <= 0) goto L66
            java.lang.String r0 = java.lang.String.valueOf(r21)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r11 = r0
            goto L67
        L66:
            r11 = r2
        L67:
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r0.<init>()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
        L72:
            boolean r1 = r2.moveToNext()     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            if (r1 == 0) goto Lb9
            r1 = 0
            long r5 = r2.getLong(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 2
            byte[] r7 = r2.getBlob(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 3
            java.lang.String r8 = r2.getString(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 4
            java.lang.String r9 = r2.getString(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 5
            int r10 = r2.getInt(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 6
            int r11 = r2.getInt(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 7
            long r12 = r2.getLong(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 8
            long r14 = r2.getLong(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r1 = 9
            long r16 = r2.getLong(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            r3 = r18
            r4 = r19
            e1.w4 r1 = r3.H(r4, r5, r7, r8, r9, r10, r11, r12, r14, r16)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            if (r1 == 0) goto L72
            r0.add(r1)     // Catch: java.lang.Throwable -> Lb5 android.database.sqlite.SQLiteException -> Lb7
            goto L72
        Lb5:
            r0 = move-exception
            goto Lbc
        Lb7:
            r0 = move-exception
            goto Lbf
        Lb9:
            r3 = r18
            goto Ld3
        Lbc:
            r3 = r18
            goto Lda
        Lbf:
            r3 = r18
            e1.t1 r1 = r3.f3875a     // Catch: java.lang.Throwable -> Ld9
            e1.w0 r1 = r1.f4264o     // Catch: java.lang.Throwable -> Ld9
            e1.t1.m(r1)     // Catch: java.lang.Throwable -> Ld9
            e1.u0 r1 = r1.f4339o     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r4 = "Error to querying MeasurementBatch from upload_queue. appId"
            r5 = r19
            r1.d(r5, r4, r0)     // Catch: java.lang.Throwable -> Ld9
            java.util.List r0 = java.util.Collections.EMPTY_LIST     // Catch: java.lang.Throwable -> Ld9
        Ld3:
            if (r2 == 0) goto Ld8
            r2.close()
        Ld8:
            return r0
        Ld9:
            r0 = move-exception
        Lda:
            if (r2 == 0) goto Ldf
            r2.close()
        Ldf:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.m.l(java.lang.String, e1.n4, int):java.util.List");
    }

    public final j l0(long j, String str, long j6, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        t1 t1Var = this.f3875a;
        k0.y.d(str);
        g();
        h();
        String[] strArr = {str};
        j jVar = new j();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase V = V();
                cursor = V.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (cursor.moveToFirst()) {
                    if (cursor.getLong(0) == j) {
                        jVar.f4049b = cursor.getLong(1);
                        jVar.f4048a = cursor.getLong(2);
                        jVar.f4050c = cursor.getLong(3);
                        jVar.f4051d = cursor.getLong(4);
                        jVar.f4052e = cursor.getLong(5);
                        jVar.f = cursor.getLong(6);
                        jVar.g = cursor.getLong(7);
                    }
                    if (z9) {
                        jVar.f4049b += j6;
                    }
                    if (z10) {
                        jVar.f4048a += j6;
                    }
                    if (z11) {
                        jVar.f4050c += j6;
                    }
                    if (z12) {
                        jVar.f4051d += j6;
                    }
                    if (z13) {
                        jVar.f4052e += j6;
                    }
                    if (z14) {
                        jVar.f += j6;
                    }
                    if (z15) {
                        jVar.g += j6;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(jVar.f4048a));
                    contentValues.put("daily_events_count", Long.valueOf(jVar.f4049b));
                    contentValues.put("daily_conversions_count", Long.valueOf(jVar.f4050c));
                    contentValues.put("daily_error_events_count", Long.valueOf(jVar.f4051d));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(jVar.f4052e));
                    contentValues.put("daily_realtime_dcu_count", Long.valueOf(jVar.f));
                    contentValues.put("daily_registered_triggers_count", Long.valueOf(jVar.g));
                    V.update("apps", contentValues, "app_id=?", strArr);
                } else {
                    w0 w0Var = t1Var.f4264o;
                    t1.m(w0Var);
                    w0Var.f4342r.c(w0.o(str), "Not updating daily counts, app is not known. appId");
                }
            } catch (SQLiteException e10) {
                w0 w0Var2 = t1Var.f4264o;
                t1.m(w0Var2);
                w0Var2.f4339o.d(w0.o(str), "Error updating daily counts. appId", e10);
            }
            if (cursor != null) {
                cursor.close();
            }
            return jVar;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final boolean m(String str) {
        i3[] i3VarArr = {i3.GOOGLE_SIGNAL};
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(i3VarArr[0].f4046a));
        String J = J(arrayList);
        String I = I();
        StringBuilder sb = new StringBuilder(J.length() + 61 + I.length());
        sb.append("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?");
        sb.append(J);
        sb.append(" AND NOT ");
        sb.append(I);
        return Q(sb.toString(), new String[]{str}) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b5.m m0(java.lang.String r12) {
        /*
            r11 = this;
            e1.t1 r1 = r11.f3875a
            k0.y.d(r12)
            r11.g()
            r11.h()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r11.V()     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6d
            java.lang.String r4 = "apps"
            java.lang.String r0 = "remote_config"
            java.lang.String r5 = "config_last_modified_time"
            java.lang.String r6 = "e_tag"
            java.lang.String[] r5 = new java.lang.String[]{r0, r5, r6}     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6d
            java.lang.String r6 = "app_id=?"
            java.lang.String[] r7 = new java.lang.String[]{r12}     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6d
            r9 = 0
            r10 = 0
            r8 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6d
            boolean r0 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            if (r0 != 0) goto L30
            goto L7f
        L30:
            r0 = 0
            byte[] r0 = r3.getBlob(r0)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            r4 = 1
            java.lang.String r4 = r3.getString(r4)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            r5 = 2
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            boolean r6 = r3.moveToNext()     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            if (r6 == 0) goto L5b
            e1.w0 r6 = r1.f4264o     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            e1.t1.m(r6)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            e1.u0 r6 = r6.f4339o     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            java.lang.String r7 = "Got multiple records for app config, expected one. appId"
            e1.v0 r8 = e1.w0.o(r12)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            r6.c(r8, r7)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            goto L5b
        L56:
            r0 = move-exception
            r12 = r0
            goto L68
        L59:
            r0 = move-exception
            goto L6f
        L5b:
            if (r0 != 0) goto L5e
            goto L7f
        L5e:
            b5.m r6 = new b5.m     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            r7 = 7
            r6.<init>(r0, r4, r5, r7)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteException -> L59
            r3.close()
            return r6
        L68:
            r2 = r3
            goto L85
        L6a:
            r0 = move-exception
            r12 = r0
            goto L85
        L6d:
            r0 = move-exception
            r3 = r2
        L6f:
            e1.w0 r1 = r1.f4264o     // Catch: java.lang.Throwable -> L56
            e1.t1.m(r1)     // Catch: java.lang.Throwable -> L56
            e1.u0 r1 = r1.f4339o     // Catch: java.lang.Throwable -> L56
            java.lang.String r4 = "Error querying remote config. appId"
            e1.v0 r12 = e1.w0.o(r12)     // Catch: java.lang.Throwable -> L56
            r1.d(r12, r4, r0)     // Catch: java.lang.Throwable -> L56
        L7f:
            if (r3 == 0) goto L84
            r3.close()
        L84:
            return r2
        L85:
            if (r2 == 0) goto L8a
            r2.close()
        L8a:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.m.m0(java.lang.String):b5.m");
    }

    public final void n(Long l10) {
        t1 t1Var = this.f3875a;
        g();
        h();
        try {
            if (V().delete("upload_queue", "rowid=?", new String[]{l10.toString()}) != 1) {
                w0 w0Var = t1Var.f4264o;
                t1.m(w0Var);
                w0Var.f4342r.b("Deleted fewer rows from upload_queue than expected");
            }
        } catch (SQLiteException e10) {
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4339o.c(e10, "Failed to delete a MeasurementBatch in a upload_queue table");
            throw e10;
        }
    }

    public final void n0(com.google.android.gms.internal.measurement.j3 j3Var, boolean z9) {
        g();
        h();
        k0.y.d(j3Var.o());
        if (!j3Var.a2()) {
            throw new IllegalStateException();
        }
        q();
        t1 t1Var = this.f3875a;
        p0.a aVar = t1Var.f4269t;
        w0 w0Var = t1Var.f4264o;
        aVar.getClass();
        long currentTimeMillis = System.currentTimeMillis();
        long b22 = j3Var.b2();
        e0 e0Var = f0.S;
        if (b22 < currentTimeMillis - ((Long) e0Var.a(null)).longValue() || j3Var.b2() > ((Long) e0Var.a(null)).longValue() + currentTimeMillis) {
            t1.m(w0Var);
            w0Var.f4342r.e("Storing bundle outside of the max uploading time span. appId, now, timestamp", w0.o(j3Var.o()), Long.valueOf(currentTimeMillis), Long.valueOf(j3Var.b2()));
        }
        byte[] a8 = j3Var.a();
        try {
            a1 a1Var = this.f4092b.f4311p;
            u4.U(a1Var);
            byte[] S = a1Var.S(a8);
            t1.m(w0Var);
            w0Var.f4346w.c(Integer.valueOf(S.length), "Saving bundle, size");
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", j3Var.o());
            contentValues.put("bundle_end_timestamp", Long.valueOf(j3Var.b2()));
            contentValues.put("data", S);
            contentValues.put("has_realtime", Integer.valueOf(z9 ? 1 : 0));
            if (j3Var.o0()) {
                contentValues.put("retry_count", Integer.valueOf(j3Var.p0()));
            }
            try {
                if (V().insert("queue", null, contentValues) == -1) {
                    t1.m(w0Var);
                    w0Var.f4339o.c(w0.o(j3Var.o()), "Failed to insert bundle (got -1). appId");
                }
            } catch (SQLiteException e10) {
                t1.m(w0Var);
                w0Var.f4339o.d(w0.o(j3Var.o()), "Error storing bundle. appId", e10);
            }
        } catch (IOException e11) {
            t1.m(w0Var);
            w0Var.f4339o.d(w0.o(j3Var.o()), "Data loss. Failed to serialize bundle. appId", e11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String o() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.V()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L22 android.database.sqlite.SQLiteException -> L24
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            if (r2 == 0) goto L35
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            r0.close()
            return r1
        L1a:
            r1 = move-exception
            goto L1e
        L1c:
            r2 = move-exception
            goto L27
        L1e:
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3b
        L22:
            r0 = move-exception
            goto L3b
        L24:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L27:
            e1.t1 r3 = r6.f3875a     // Catch: java.lang.Throwable -> L1a
            e1.w0 r3 = r3.f4264o     // Catch: java.lang.Throwable -> L1a
            e1.t1.m(r3)     // Catch: java.lang.Throwable -> L1a
            e1.u0 r3 = r3.f4339o     // Catch: java.lang.Throwable -> L1a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.c(r2, r4)     // Catch: java.lang.Throwable -> L1a
        L35:
            if (r0 == 0) goto L3a
            r0.close()
        L3a:
            return r1
        L3b:
            if (r1 == 0) goto L40
            r1.close()
        L40:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.m.o():java.lang.String");
    }

    public final void p(long j) {
        g();
        h();
        try {
            if (V().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) == 1) {
            } else {
                throw new SQLiteException("Deleted fewer rows from queue than expected");
            }
        } catch (SQLiteException e10) {
            w0 w0Var = this.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.c(e10, "Failed to delete a bundle in a queue table");
            throw e10;
        }
    }

    public final void q() {
        g();
        h();
        if (N()) {
            u4 u4Var = this.f4092b;
            long a8 = u4Var.f4313r.f4419n.a();
            t1 t1Var = this.f3875a;
            t1Var.f4269t.getClass();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (Math.abs(elapsedRealtime - a8) > ((Long) f0.N.a(null)).longValue()) {
                u4Var.f4313r.f4419n.b(elapsedRealtime);
                g();
                h();
                if (N()) {
                    SQLiteDatabase V = V();
                    t1Var.f4269t.getClass();
                    int delete = V.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(System.currentTimeMillis()), String.valueOf(((Long) f0.S.a(null)).longValue())});
                    if (delete > 0) {
                        w0 w0Var = t1Var.f4264o;
                        t1.m(w0Var);
                        w0Var.f4346w.c(Integer.valueOf(delete), "Deleted stale rows. rowsDeleted");
                    }
                }
            }
        }
    }

    public final void r(ArrayList arrayList) {
        g();
        h();
        k0.y.g(arrayList);
        if (arrayList.size() == 0) {
            com.google.gson.internal.a.p("Given Integer is zero");
            return;
        }
        if (N()) {
            String join = TextUtils.join(",", arrayList);
            String o10 = a4.x.o(new StringBuilder(String.valueOf(join).length() + 2), "(", join, ")");
            long Q = Q(a4.x.o(new StringBuilder(o10.length() + 80), "SELECT COUNT(1) FROM queue WHERE rowid IN ", o10, " AND retry_count =  2147483647 LIMIT 1"), null);
            t1 t1Var = this.f3875a;
            if (Q > 0) {
                w0 w0Var = t1Var.f4264o;
                t1.m(w0Var);
                w0Var.f4342r.b("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase V = V();
                StringBuilder sb = new StringBuilder(o10.length() + 127);
                sb.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb.append(o10);
                sb.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                V.execSQL(sb.toString());
            } catch (SQLiteException e10) {
                w0 w0Var2 = t1Var.f4264o;
                t1.m(w0Var2);
                w0Var2.f4339o.c(e10, "Error incrementing retry count. error");
            }
        }
    }

    public final void s(Long l10) {
        g();
        h();
        if (N()) {
            StringBuilder sb = new StringBuilder(l10.toString().length() + 86);
            sb.append("SELECT COUNT(1) FROM upload_queue WHERE rowid = ");
            sb.append(l10);
            sb.append(" AND retry_count =  2147483647 LIMIT 1");
            long Q = Q(sb.toString(), null);
            t1 t1Var = this.f3875a;
            if (Q > 0) {
                w0 w0Var = t1Var.f4264o;
                t1.m(w0Var);
                w0Var.f4342r.b("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase V = V();
                t1Var.f4269t.getClass();
                long currentTimeMillis = System.currentTimeMillis();
                StringBuilder sb2 = new StringBuilder(String.valueOf(currentTimeMillis).length() + 60);
                sb2.append(" SET retry_count = retry_count + 1, last_upload_timestamp = ");
                sb2.append(currentTimeMillis);
                String sb3 = sb2.toString();
                StringBuilder sb4 = new StringBuilder(sb3.length() + 34 + l10.toString().length() + 29);
                sb4.append("UPDATE upload_queue");
                sb4.append(sb3);
                sb4.append(" WHERE rowid = ");
                sb4.append(l10);
                sb4.append(" AND retry_count < 2147483647");
                V.execSQL(sb4.toString());
            } catch (SQLiteException e10) {
                w0 w0Var2 = t1Var.f4264o;
                t1.m(w0Var2);
                w0Var2.f4339o.c(e10, "Error incrementing retry count. error");
            }
        }
    }

    public final Object t(Cursor cursor, int i) {
        int type = cursor.getType(i);
        t1 t1Var = this.f3875a;
        if (type == 0) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.b("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type != 4) {
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4339o.c(Integer.valueOf(type), "Loaded invalid unknown value type, ignoring it");
            return null;
        }
        w0 w0Var3 = t1Var.f4264o;
        t1.m(w0Var3);
        w0Var3.f4339o.b("Loaded invalid blob type value, ignoring it");
        return null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(3:2|3|4)|(2:6|(3:8|9|10)(1:14))|15|16|(1:18)(2:21|22)|19|9|10|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a2, code lost:
    
        r1 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a9, code lost:
    
        r4 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00aa, code lost:
    
        r0 = r0.f4264o;
        e1.t1.m(r0);
        r0.f4339o.e("Error inserting column. appId", e1.w0.o(r14), "first_open_count", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ba, code lost:
    
        r7 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long u(java.lang.String r14) {
        /*
            r13 = this;
            e1.t1 r0 = r13.f3875a
            java.lang.String r1 = "select first_open_count from app2 where app_id=?"
            k0.y.d(r14)
            java.lang.String r2 = "first_open_count"
            k0.y.d(r2)
            r13.g()
            r13.h()
            android.database.sqlite.SQLiteDatabase r3 = r13.V()
            r3.beginTransaction()
            r4 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r7 = 48
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r6.append(r1)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r1 = r6.toString()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String[] r6 = new java.lang.String[]{r14}     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r7 = -1
            long r9 = r13.R(r1, r6, r7)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            java.lang.String r6 = "app2"
            java.lang.String r11 = "app_id"
            if (r1 != 0) goto L70
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r1.<init>()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r1.put(r11, r14)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r9 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r1.put(r2, r9)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r10 = "previous_install_count"
            r1.put(r10, r9)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r9 = 0
            r10 = 5
            long r9 = r3.insertWithOnConflict(r6, r9, r1, r10)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 != 0) goto L6f
            e1.w0 r1 = r0.f4264o     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            e1.t1.m(r1)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            e1.u0 r1 = r1.f4339o     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r6 = "Failed to insert column (got -1). appId"
            e1.v0 r9 = e1.w0.o(r14)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r1.d(r9, r6, r2)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            goto Lbb
        L6b:
            r14 = move-exception
            goto Lbf
        L6d:
            r1 = move-exception
            goto Laa
        L6f:
            r9 = r4
        L70:
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            r1.<init>()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            r1.put(r11, r14)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            r11 = 1
            long r11 = r11 + r9
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            r1.put(r2, r11)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            java.lang.String r11 = "app_id = ?"
            java.lang.String[] r12 = new java.lang.String[]{r14}     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            int r1 = r3.update(r6, r1, r11, r12)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            long r11 = (long) r1     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            int r1 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r1 != 0) goto La4
            e1.w0 r1 = r0.f4264o     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            e1.t1.m(r1)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            e1.u0 r1 = r1.f4339o     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            java.lang.String r4 = "Failed to update column (got 0). appId"
            e1.v0 r5 = e1.w0.o(r14)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            r1.d(r5, r4, r2)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            goto Lbb
        La2:
            r1 = move-exception
            goto La9
        La4:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> La2
            r7 = r9
            goto Lbb
        La9:
            r4 = r9
        Laa:
            e1.w0 r0 = r0.f4264o     // Catch: java.lang.Throwable -> L6b
            e1.t1.m(r0)     // Catch: java.lang.Throwable -> L6b
            e1.u0 r0 = r0.f4339o     // Catch: java.lang.Throwable -> L6b
            java.lang.String r6 = "Error inserting column. appId"
            e1.v0 r14 = e1.w0.o(r14)     // Catch: java.lang.Throwable -> L6b
            r0.e(r6, r14, r2, r1)     // Catch: java.lang.Throwable -> L6b
            r7 = r4
        Lbb:
            r3.endTransaction()
            return r7
        Lbf:
            r3.endTransaction()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.m.u(java.lang.String):long");
    }

    public final boolean v(String str, String str2) {
        return Q("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0;
    }

    public final long w(String str) {
        k0.y.d(str);
        return R("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final void x(String str, Long l10, long j, com.google.android.gms.internal.measurement.b3 b3Var) {
        g();
        h();
        k0.y.g(b3Var);
        k0.y.d(str);
        byte[] a8 = b3Var.a();
        t1 t1Var = this.f3875a;
        w0 w0Var = t1Var.f4264o;
        w0 w0Var2 = t1Var.f4264o;
        t1.m(w0Var);
        w0Var.f4346w.d(t1Var.f4268s.a(str), "Saving complex main event, appId, data size", Integer.valueOf(a8.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l10);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", a8);
        try {
            if (V().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                t1.m(w0Var2);
                w0Var2.f4339o.c(w0.o(str), "Failed to insert complex main event (got -1). appId");
            }
        } catch (SQLiteException e10) {
            t1.m(w0Var2);
            w0Var2.f4339o.d(w0.o(str), "Error storing complex main event. appId", e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0114 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0287 A[Catch: SQLiteException -> 0x02a3, TRY_LEAVE, TryCatch #3 {SQLiteException -> 0x02a3, blocks: (B:79:0x026c, B:81:0x0287), top: B:78:0x026c }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(java.lang.String r25, java.lang.Long r26, java.lang.String r27, android.os.Bundle r28) {
        /*
            Method dump skipped, instructions count: 706
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.m.y(java.lang.String, java.lang.Long, java.lang.String, android.os.Bundle):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
    
        if (r5 == 0) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v9, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final e1.j2 z(java.lang.String r5) {
        /*
            r4 = this;
            e1.t1 r0 = r4.f3875a
            k0.y.g(r5)
            r4.g()
            r4.h()
            java.lang.String[] r5 = new java.lang.String[]{r5}
            java.lang.String r1 = "select consent_state, consent_source from consent_settings where app_id=? limit 1;"
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r4.V()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L48
            android.database.Cursor r5 = r3.rawQuery(r1, r5)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L48
            boolean r1 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            if (r1 != 0) goto L34
            e1.w0 r1 = r0.f4264o     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            e1.t1.m(r1)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            e1.u0 r1 = r1.f4346w     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            java.lang.String r3 = "No data found"
            r1.b(r3)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
        L2c:
            r5.close()
            goto L5a
        L30:
            r0 = move-exception
            goto L43
        L32:
            r1 = move-exception
            goto L4b
        L34:
            r1 = 0
            java.lang.String r1 = r5.getString(r1)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            r3 = 1
            int r3 = r5.getInt(r3)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            e1.j2 r2 = e1.j2.c(r3, r1)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L32
            goto L2c
        L43:
            r2 = r5
            goto L60
        L45:
            r5 = move-exception
            r0 = r5
            goto L60
        L48:
            r5 = move-exception
            r1 = r5
            r5 = r2
        L4b:
            e1.w0 r0 = r0.f4264o     // Catch: java.lang.Throwable -> L30
            e1.t1.m(r0)     // Catch: java.lang.Throwable -> L30
            e1.u0 r0 = r0.f4339o     // Catch: java.lang.Throwable -> L30
            java.lang.String r3 = "Error querying database."
            r0.c(r1, r3)     // Catch: java.lang.Throwable -> L30
            if (r5 == 0) goto L5a
            goto L2c
        L5a:
            if (r2 != 0) goto L5f
            e1.j2 r5 = e1.j2.f4054c
            return r5
        L5f:
            return r2
        L60:
            if (r2 == 0) goto L65
            r2.close()
        L65:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.m.z(java.lang.String):e1.j2");
    }

    @Override // e1.p4
    public final void j() {
    }
}
