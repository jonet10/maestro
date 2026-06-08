package e1;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.SystemClock;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p0 extends h0 {

    /* renamed from: n, reason: collision with root package name */
    public static final String[] f4183n = {"app_version", "ALTER TABLE messages ADD COLUMN app_version TEXT;", "app_version_int", "ALTER TABLE messages ADD COLUMN app_version_int INTEGER;"};

    /* renamed from: l, reason: collision with root package name */
    public final l f4184l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4185m;

    public p0(t1 t1Var) {
        super(t1Var);
        this.f4184l = new l(this, this.f3875a.f4259a);
    }

    @Override // e1.h0
    public final boolean j() {
        return false;
    }

    public final void k() {
        int delete;
        t1 t1Var = this.f3875a;
        g();
        try {
            SQLiteDatabase m10 = m();
            if (m10 == null || (delete = m10.delete("messages", null, null)) <= 0) {
                return;
            }
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4346w.c(Integer.valueOf(delete), "Reset local analytics data. records");
        } catch (SQLiteException e10) {
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4339o.c(e10, "Error resetting local analytics data. error");
        }
    }

    public final boolean l() {
        g();
        if (!this.f4185m) {
            t1 t1Var = this.f3875a;
            if (t1Var.f4259a.getDatabasePath("google_app_measurement_local.db").exists()) {
                int i = 0;
                int i6 = 5;
                while (true) {
                    if (i >= 5) {
                        w0 w0Var = t1Var.f4264o;
                        t1.m(w0Var);
                        w0Var.f4342r.b("Error deleting app launch break from local database in reasonable time");
                        break;
                    }
                    SQLiteDatabase sQLiteDatabase = null;
                    try {
                        try {
                            SQLiteDatabase m10 = m();
                            if (m10 != null) {
                                m10.beginTransaction();
                                m10.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                                m10.setTransactionSuccessful();
                                m10.endTransaction();
                                m10.close();
                                return true;
                            }
                            this.f4185m = true;
                        } catch (SQLiteException e10) {
                            if (0 != 0) {
                                try {
                                    if (sQLiteDatabase.inTransaction()) {
                                        sQLiteDatabase.endTransaction();
                                    }
                                } catch (Throwable th) {
                                    if (0 != 0) {
                                        sQLiteDatabase.close();
                                    }
                                    throw th;
                                }
                            }
                            w0 w0Var2 = t1Var.f4264o;
                            t1.m(w0Var2);
                            w0Var2.f4339o.c(e10, "Error deleting app launch break from local database");
                            this.f4185m = true;
                            if (0 != 0) {
                                sQLiteDatabase.close();
                            }
                        }
                    } catch (SQLiteDatabaseLockedException unused) {
                        SystemClock.sleep(i6);
                        i6 += 20;
                        if (0 == 0) {
                        }
                        sQLiteDatabase.close();
                    } catch (SQLiteFullException e11) {
                        w0 w0Var3 = t1Var.f4264o;
                        t1.m(w0Var3);
                        w0Var3.f4339o.c(e11, "Error deleting app launch break from local database");
                        this.f4185m = true;
                        if (0 == 0) {
                        }
                        sQLiteDatabase.close();
                    }
                    i++;
                }
            }
        }
        return false;
    }

    public final SQLiteDatabase m() {
        if (this.f4185m) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f4184l.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f4185m = true;
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x016e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x016e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011e A[Catch: all -> 0x0152, TRY_ENTER, TryCatch #9 {all -> 0x0152, blocks: (B:95:0x0086, B:97:0x008c, B:65:0x00ac, B:67:0x00cd, B:70:0x00d4, B:73:0x00dc, B:74:0x00f6, B:42:0x011e, B:44:0x0124, B:45:0x0127, B:33:0x0159, B:21:0x0142), top: B:94:0x0086 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x016e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n(int r19, byte[] r20) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.p0.n(int, byte[]):boolean");
    }
}
