package y;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import r.p;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class h implements d, z.c, c {

    /* renamed from: o, reason: collision with root package name */
    public static final o.c f11586o = new o.c("proto");

    /* renamed from: a, reason: collision with root package name */
    public final j f11587a;

    /* renamed from: b, reason: collision with root package name */
    public final q2.e f11588b;

    /* renamed from: l, reason: collision with root package name */
    public final q2.e f11589l;

    /* renamed from: m, reason: collision with root package name */
    public final a f11590m;

    /* renamed from: n, reason: collision with root package name */
    public final m6.a f11591n;

    public h(q2.e eVar, q2.e eVar2, a aVar, j jVar, m6.a aVar2) {
        this.f11587a = jVar;
        this.f11588b = eVar;
        this.f11589l = eVar2;
        this.f11590m = aVar;
        this.f11591n = aVar2;
    }

    public static Long c(SQLiteDatabase sQLiteDatabase, p pVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        r.j jVar = (r.j) pVar;
        ArrayList arrayList = new ArrayList(Arrays.asList(jVar.f8831a, String.valueOf(b0.a.a(jVar.f8833c))));
        byte[] bArr = jVar.f8832b;
        if (bArr != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(bArr, 0));
        } else {
            sb.append(" and extras is null");
        }
        Cursor query = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            return !query.moveToNext() ? null : Long.valueOf(query.getLong(0));
        } finally {
            query.close();
        }
    }

    public static String i(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((b) it.next()).f11579a);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static Object j(Cursor cursor, f fVar) {
        try {
            return fVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public final SQLiteDatabase b() {
        j jVar = this.f11587a;
        Objects.requireNonNull(jVar);
        q2.e eVar = this.f11589l;
        long f = eVar.f();
        while (true) {
            try {
                return jVar.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e10) {
                if (eVar.f() >= this.f11590m.f11576c + f) {
                    throw new z.a("Timed out while trying to open db.", e10);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f11587a.close();
    }

    public final Object d(f fVar) {
        SQLiteDatabase b7 = b();
        b7.beginTransaction();
        try {
            Object apply = fVar.apply(b7);
            b7.setTransactionSuccessful();
            return apply;
        } finally {
            b7.endTransaction();
        }
    }

    public final ArrayList e(SQLiteDatabase sQLiteDatabase, r.j jVar, int i) {
        ArrayList arrayList = new ArrayList();
        Long c9 = c(sQLiteDatabase, jVar);
        if (c9 == null) {
            return arrayList;
        }
        j(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline", "product_id", "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{c9.toString()}, null, null, null, String.valueOf(i)), new androidx.transition.a(this, arrayList, jVar, 5));
        return arrayList;
    }

    public final void f(long j, u.c cVar, String str) {
        d(new v1.a(j, str, cVar));
    }

    public final Object h(z.b bVar) {
        SQLiteDatabase b7 = b();
        q2.e eVar = this.f11589l;
        long f = eVar.f();
        while (true) {
            try {
                b7.beginTransaction();
                try {
                    Object execute = bVar.execute();
                    b7.setTransactionSuccessful();
                    return execute;
                } finally {
                    b7.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e10) {
                if (eVar.f() >= this.f11590m.f11576c + f) {
                    throw new z.a("Timed out while trying to acquire the lock.", e10);
                }
                SystemClock.sleep(50L);
            }
        }
    }
}
