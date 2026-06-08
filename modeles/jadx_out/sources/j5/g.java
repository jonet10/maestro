package j5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import e1.c0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import x4.a2;
import x4.b1;
import x4.e1;
import x4.h2;
import x4.j0;
import x4.k0;
import x4.q2;
import x4.x1;
import x4.z1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g extends SQLiteOpenHelper {
    public static final c0 D = new c0(20);
    public static g E;
    public final String[] A;
    public final String[] B;
    public final AtomicInteger C;

    /* renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f6673a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f6674b;

    /* renamed from: l, reason: collision with root package name */
    public final String[] f6675l;

    /* renamed from: m, reason: collision with root package name */
    public final String[] f6676m;

    /* renamed from: n, reason: collision with root package name */
    public final String[] f6677n;

    /* renamed from: o, reason: collision with root package name */
    public final String[] f6678o;

    /* renamed from: p, reason: collision with root package name */
    public final String[] f6679p;

    /* renamed from: q, reason: collision with root package name */
    public final String[] f6680q;

    /* renamed from: r, reason: collision with root package name */
    public final String[] f6681r;

    /* renamed from: s, reason: collision with root package name */
    public final String[] f6682s;

    /* renamed from: t, reason: collision with root package name */
    public final String[] f6683t;

    /* renamed from: u, reason: collision with root package name */
    public final String[] f6684u;
    public final String[] v;

    /* renamed from: w, reason: collision with root package name */
    public final String[] f6685w;

    /* renamed from: x, reason: collision with root package name */
    public final String[] f6686x;

    /* renamed from: y, reason: collision with root package name */
    public final String[] f6687y;

    /* renamed from: z, reason: collision with root package name */
    public final String[] f6688z;

    public g(Context context) {
        super(context, "Uptodown.db", (SQLiteDatabase.CursorFactory) null, 723);
        this.f6674b = new String[]{"id", "name", "packagename", "versionCode", "issystemapp", "isSystemService", "urlFicha", "md5signature", "exclude", "size", "excludeFromTracking", "defaultName", "sha256", "positiveNotified", "appID", "hasOldVersions", "trackInfoRegistered"};
        this.f6675l = new String[]{"id", "app_id", "sha256", "size", "path"};
        this.f6676m = new String[]{"id", "packagename", "versionCode", "versionName", "notified", "ignoreVersion", "isPartialUpdate", "newFeatures", "installationAttempts"};
        this.f6677n = new String[]{"id", "packagename", "checked", "incomplete", "versioncode", "versionname", "attempts", "idPrograma", "downloadAnyway", "md5signature", "supportedAbis", "minsdk", "urlIcon", "appName", "nextAttemptTimeStamp", "updateId", "deeplink", "is_rollback"};
        this.f6678o = new String[]{"id", "downloadId", "fileId", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "size", "size_downloaded", "filehash", "absolutePath", "attempts", "nextAttemptTimeStamp"};
        this.f6679p = new String[]{"id", "appId", "categoryFrom", "promotedIndex"};
        this.f6680q = new String[]{"search", "timestamp"};
        this.f6681r = new String[]{"id", "path"};
        this.f6682s = new String[]{"id", "timestamp", "title", NotificationCompat.CATEGORY_MESSAGE, "actions", "extra_info"};
        this.f6683t = new String[]{"appId", "automaticDownload"};
        this.f6684u = new String[]{"appId"};
        this.v = new String[]{"path", "date"};
        this.f6685w = new String[]{"id", "notificationId", "packagename", "versioncode", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY};
        this.f6686x = new String[]{"id", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "json", "timestamp"};
        this.f6687y = new String[]{"id", "json", "timestamp"};
        this.f6688z = new String[]{"id", "json", "timestamp"};
        this.A = new String[]{"name"};
        this.B = new String[]{"id", "appId", "sourceDeviceName", "downloadId"};
        this.C = new AtomicInteger();
    }

    public static void d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS updates(id integer primary key autoincrement, packagename text, versionCode text, versionName text, notified integer default 0, ignoreVersion integer default 0, isPartialUpdate integer default 0, newFeatures text, installationAttempts integer default 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS apps( id integer primary key autoincrement, name text, packagename text, versionCode text, issystemapp integer default 0, isSystemService integer default 0, urlFicha text, md5signature text, exclude integer default 0, size text, excludeFromTracking integer default 0, defaultName text, sha256 text, positiveNotified integer default 0, appID integer default 0, hasOldVersions integer default 0, trackInfoRegistered integer default 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS app_files( id integer primary key autoincrement, app_id integer, sha256 text, size text, path text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS downloads(id integer primary key autoincrement, packagename text, checked integer default 0, incomplete integer default 0, versioncode integer default 0, versionname text, attempts integer default 0, idPrograma integer default 0, downloadAnyway integer default 0, md5signature text, supportedAbis text, minsdk integer default 0, urlIcon text, appName text, nextAttemptTimeStamp integer default 0, updateId integer default 0, deeplink integer default 0, is_rollback integer default 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS download_files(id integer primary key autoincrement, downloadId integer default 0, fileId integer default 0, type text, size integer default 0, size_downloaded integer default 0, filehash text, absolutePath text, attempts integer default 0, nextAttemptTimeStamp integer default 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS download_promoted(id integer primary key autoincrement, appId integer default 0, categoryFrom text, promotedIndex integer default 1);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS recent_searches(id integer primary key autoincrement, search text unique, timestamp text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS installable_files(id integer primary key autoincrement, path text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS notifications(id integer primary key autoincrement, timestamp text, title text, msg text, actions text, extra_info text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS deep_link_files(id integer primary key autoincrement, path text, date text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS active_notifications(id integer primary key autoincrement, notificationId integer, packagename text, versioncode integer, type integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS responses(id integer primary key autoincrement, type integer, json text, timestamp text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events(id integer primary key autoincrement, json text, timestamp integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preregistrations(id integer primary key autoincrement, appId integer, automaticDownload integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preregistrations_to_notify(id integer primary key autoincrement, appId integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS errors(id integer primary key autoincrement, json text, timestamp integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS download_required_features(id integer primary key autoincrement, name text, downloadId text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS remote_installs(id integer primary key autoincrement, appId integer, sourceDeviceName text, downloadId integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS app_installers(id integer primary key autoincrement, packagename text, installer_packagename text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS device_status(id integer primary key autoincrement, timestamp integer, batteryLevel integer, isCharging integer, isWifiConnected integer, uploadSpeedKbps integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS data_usage(id integer primary key autoincrement, date text, type integer, connection_type integer default 0, bytes integer, UNIQUE(date, type, connection_type));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS pending_system_messages(id integer primary key autoincrement, title text, body text, url text, action_button_text text, timestamp integer);");
    }

    public static x4.b f0(Cursor cursor) {
        x4.a aVar;
        int i = cursor.getInt(0);
        int i6 = cursor.getInt(1);
        String string = cursor.getString(2);
        String string2 = cursor.getString(3);
        string.getClass();
        string2.getClass();
        x4.b bVar = new x4.b(string, Long.parseLong(string2));
        bVar.f11053c = i;
        bVar.f11054d = i6;
        int i10 = cursor.getInt(4);
        if (i10 == 0) {
            aVar = x4.a.f11038a;
        } else {
            if (i10 != 1) {
                s1.o.n();
                return null;
            }
            aVar = x4.a.f11039b;
        }
        bVar.f11055e = aVar;
        return bVar;
    }

    public static x4.e g0(Cursor cursor) {
        x4.e eVar = new x4.e();
        eVar.f11121a = cursor.getLong(0);
        eVar.f11122b = cursor.getString(1);
        eVar.f11123l = cursor.getString(2);
        String string = cursor.getString(3);
        string.getClass();
        eVar.f11124m = Long.parseLong(string);
        eVar.f11128q = cursor.getInt(4);
        eVar.f11129r = cursor.getInt(5);
        eVar.f11126o = cursor.getString(6);
        eVar.f11132u = cursor.getString(7);
        eVar.v = cursor.getInt(8);
        String string2 = cursor.getString(9);
        string2.getClass();
        eVar.f11133w = Long.parseLong(string2);
        eVar.f11135y = cursor.getInt(10);
        eVar.f11136z = cursor.getString(11);
        eVar.B = cursor.getString(12);
        eVar.C = cursor.getInt(13);
        eVar.F = cursor.getLong(14);
        eVar.G = cursor.getInt(15);
        eVar.H = cursor.getInt(16);
        return eVar;
    }

    public static e1 h0(Cursor cursor) {
        cursor.getInt(0);
        cursor.getInt(1);
        e1 e1Var = new e1();
        e1Var.f11138a = cursor.getString(2);
        String string = cursor.getString(3);
        string.getClass();
        e1Var.f11139b = Long.parseLong(string);
        e1Var.f11140c = cursor.getString(4);
        return e1Var;
    }

    public static x4.r i0(Cursor cursor) {
        x4.r rVar = new x4.r();
        rVar.f11354a = cursor.getInt(0);
        rVar.f11355b = cursor.getString(1);
        rVar.f11356l = cursor.getInt(2);
        rVar.f11357m = cursor.getInt(3);
        rVar.f11358n = cursor.getLong(4);
        rVar.f11359o = cursor.getString(5);
        rVar.f11360p = cursor.getInt(6);
        rVar.f11361q = cursor.getLong(7);
        rVar.f11362r = cursor.getInt(8);
        rVar.f11363s = cursor.getString(9);
        rVar.f11364t = cursor.getString(10);
        rVar.f11365u = cursor.getInt(11);
        rVar.v = cursor.getString(12);
        rVar.f11366w = cursor.getString(13);
        rVar.f11367x = cursor.getLong(14);
        rVar.f11369z = cursor.getLong(15);
        rVar.A = cursor.getInt(16);
        rVar.B = cursor.getInt(17);
        return rVar;
    }

    public static j0 j0(Cursor cursor) {
        j0 j0Var = new j0();
        j0Var.f11233a = cursor.getLong(0);
        j0Var.f11234b = cursor.getLong(1);
        j0Var.f11235l = cursor.getLong(2);
        j0Var.f11236m = cursor.getString(3);
        j0Var.f11237n = cursor.getLong(4);
        j0Var.f11238o = cursor.getLong(5);
        j0Var.f11239p = cursor.getString(6);
        j0Var.f11240q = cursor.getString(7);
        j0Var.f11241r = cursor.getInt(8);
        j0Var.f11242s = cursor.getLong(9);
        return j0Var;
    }

    public static b1 k0(Cursor cursor) {
        b1 b1Var = new b1();
        b1Var.f11057a = cursor.getLong(0);
        b1Var.f11058b = cursor.getString(1);
        cursor.getLong(2);
        return b1Var;
    }

    public static q2 l0(Cursor cursor) {
        long j = cursor.getLong(0);
        String string = cursor.getString(1);
        string.getClass();
        q2 q2Var = new q2(string);
        q2Var.f11343a = j;
        String string2 = cursor.getString(2);
        string2.getClass();
        q2Var.f11345l = Long.parseLong(string2);
        q2Var.f11346m = cursor.getString(3);
        q2Var.f11347n = cursor.getInt(4);
        q2Var.f11348o = cursor.getInt(5);
        q2Var.f11349p = cursor.getInt(6);
        q2Var.f11350q = cursor.getString(7);
        q2Var.f11351r = cursor.getInt(8);
        return q2Var;
    }

    public final x4.b A(int i) {
        Cursor cursor;
        try {
            String[] strArr = {String.valueOf(i)};
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("active_notifications", this.f6685w, "id=?", strArr, null, null, null);
        } catch (Exception e10) {
            e = e10;
            cursor = null;
        }
        try {
            x4.b f02 = cursor.moveToFirst() ? f0(cursor) : null;
            cursor.close();
            return f02;
        } catch (Exception e11) {
            e = e11;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final x4.e B(String str) {
        Cursor cursor;
        str.getClass();
        try {
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("apps", this.f6674b, "packagename=?", new String[]{str}, null, null, null);
        } catch (Exception e10) {
            e = e10;
            cursor = null;
        }
        try {
            x4.e g02 = cursor.moveToFirst() ? g0(cursor) : null;
            cursor.close();
            return g02;
        } catch (Exception e11) {
            e = e11;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final ArrayList C(long j) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            String[] strArr = {String.valueOf(j)};
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("app_files", this.f6675l, "app_id=?", strArr, null, null, null);
            if (cursor.moveToFirst()) {
                arrayList.add(h0(cursor));
                while (cursor.moveToNext()) {
                    arrayList.add(h0(cursor));
                }
            }
            cursor.close();
            return arrayList;
        } catch (Exception e10) {
            e10.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final ArrayList D(x4.e eVar) {
        x4.e B;
        long j = eVar.f11121a;
        if (j >= 0) {
            return C(j);
        }
        String str = eVar.f11123l;
        if (str == null || (B = B(str)) == null) {
            return null;
        }
        return C(B.f11121a);
    }

    public final ArrayList E() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("apps", this.f6674b, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                arrayList.add(g0(cursor));
                while (cursor.moveToNext()) {
                    arrayList.add(g0(cursor));
                }
            }
            cursor.close();
            return arrayList;
        } catch (Exception e10) {
            e10.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final ArrayList F() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("deep_link_files", this.v, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                x4.k kVar = new x4.k();
                kVar.f11247a = cursor.getString(0);
                kVar.f11248b = cursor.getString(1);
                arrayList.add(kVar);
            }
            while (cursor.moveToNext()) {
                x4.k kVar2 = new x4.k();
                kVar2.f11247a = cursor.getString(0);
                kVar2.f11248b = cursor.getString(1);
                arrayList.add(kVar2);
            }
            cursor.close();
            return arrayList;
        } catch (Exception e10) {
            e10.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final x4.r G(String str) {
        Iterator it = P().iterator();
        it.getClass();
        x4.r rVar = null;
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            x4.r rVar2 = (x4.r) next;
            Iterator it2 = rVar2.F.iterator();
            it2.getClass();
            while (it2.hasNext()) {
                Object next2 = it2.next();
                next2.getClass();
                j0 j0Var = (j0) next2;
                if (j0Var.f11240q != null) {
                    String str2 = j0Var.f11240q;
                    str2.getClass();
                    if (l7.u.m0(new File(str2).getName(), str, true)) {
                        rVar = rVar2;
                    }
                }
            }
        }
        return rVar;
    }

    public final x4.r H(String str) {
        Iterator it = P().iterator();
        it.getClass();
        x4.r rVar = null;
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            x4.r rVar2 = (x4.r) next;
            if (!rVar2.F.isEmpty()) {
                Iterator it2 = rVar2.F.iterator();
                it2.getClass();
                while (true) {
                    if (it2.hasNext()) {
                        Object next2 = it2.next();
                        next2.getClass();
                        j0 j0Var = (j0) next2;
                        if (j0Var.f11240q != null) {
                            String str2 = j0Var.f11240q;
                            str2.getClass();
                            File parentFile = new File(str2).getParentFile();
                            if (parentFile != null && l7.u.m0(parentFile.getAbsolutePath(), str, true)) {
                                rVar = rVar2;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return rVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final x4.r I(java.lang.String r12) {
        /*
            r11 = this;
            r12.getClass()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.f6673a     // Catch: java.lang.Exception -> L30
            r2.getClass()     // Catch: java.lang.Exception -> L30
            java.lang.String r3 = "download_files"
            java.lang.String[] r4 = r11.f6678o     // Catch: java.lang.Exception -> L30
            java.lang.String r5 = "fileId=?"
            java.lang.String[] r6 = new java.lang.String[]{r12}     // Catch: java.lang.Exception -> L30
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L30
            boolean r0 = r12.moveToFirst()     // Catch: java.lang.Exception -> L26
            if (r0 == 0) goto L29
            x4.j0 r0 = j0(r12)     // Catch: java.lang.Exception -> L26
            r2 = r0
            goto L2a
        L26:
            r0 = move-exception
            r2 = r1
            goto L33
        L29:
            r2 = r1
        L2a:
            r12.close()     // Catch: java.lang.Exception -> L2e
            goto L41
        L2e:
            r0 = move-exception
            goto L33
        L30:
            r0 = move-exception
            r12 = r1
            r2 = r12
        L33:
            r0.printStackTrace()
            if (r12 == 0) goto L41
            boolean r0 = r12.isClosed()
            if (r0 != 0) goto L41
            r12.close()
        L41:
            if (r2 == 0) goto L4a
            long r3 = r2.f11234b
            java.lang.Long r12 = java.lang.Long.valueOf(r3)
            goto L4b
        L4a:
            r12 = r1
        L4b:
            if (r12 == 0) goto L98
            android.database.sqlite.SQLiteDatabase r3 = r11.f6673a     // Catch: java.lang.Exception -> L88
            r3.getClass()     // Catch: java.lang.Exception -> L88
            java.lang.String r4 = "downloads"
            java.lang.String[] r5 = r11.f6677n     // Catch: java.lang.Exception -> L88
            java.lang.String r6 = "id=?"
            long r7 = r2.f11234b     // Catch: java.lang.Exception -> L88
            java.lang.String r12 = java.lang.String.valueOf(r7)     // Catch: java.lang.Exception -> L88
            java.lang.String[] r7 = new java.lang.String[]{r12}     // Catch: java.lang.Exception -> L88
            r9 = 0
            r10 = 0
            r8 = 0
            android.database.Cursor r12 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L88
            boolean r0 = r12.moveToFirst()     // Catch: java.lang.Exception -> L74
            if (r0 == 0) goto L76
            x4.r r0 = i0(r12)     // Catch: java.lang.Exception -> L74
            goto L77
        L74:
            r0 = move-exception
            goto L8a
        L76:
            r0 = r1
        L77:
            r12.close()     // Catch: java.lang.Exception -> L74
            if (r0 == 0) goto L86
            int r2 = r0.f11354a     // Catch: java.lang.Exception -> L74
            if (r2 < 0) goto L86
            java.util.ArrayList r2 = r11.N(r2)     // Catch: java.lang.Exception -> L74
            r0.F = r2     // Catch: java.lang.Exception -> L74
        L86:
            r1 = r0
            goto L98
        L88:
            r0 = move-exception
            r12 = r1
        L8a:
            r0.printStackTrace()
            if (r12 == 0) goto L98
            boolean r0 = r12.isClosed()
            if (r0 != 0) goto L98
            r12.close()
        L98:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.g.I(java.lang.String):x4.r");
    }

    public final x4.r J(int i) {
        Cursor cursor;
        int i6;
        try {
            String[] strArr = {String.valueOf(i)};
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("downloads", this.f6677n, "id=?", strArr, null, null, null);
        } catch (Exception e10) {
            e = e10;
            cursor = null;
        }
        try {
            x4.r i02 = cursor.moveToFirst() ? i0(cursor) : null;
            cursor.close();
            if (i02 != null && (i6 = i02.f11354a) >= 0) {
                i02.F = N(i6);
            }
            return i02;
        } catch (Exception e11) {
            e = e11;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final x4.r K(String str) {
        Cursor cursor;
        int i;
        str.getClass();
        try {
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("downloads", this.f6677n, "packagename=?", new String[]{str}, null, null, "versioncode DESC");
        } catch (Exception e10) {
            e = e10;
            cursor = null;
        }
        try {
            x4.r i02 = cursor.moveToFirst() ? i0(cursor) : null;
            cursor.close();
            if (i02 != null && (i = i02.f11354a) >= 0) {
                i02.F = N(i);
            }
            return i02;
        } catch (Exception e11) {
            e = e11;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final x4.r L(long j, String str) {
        Exception exc;
        Cursor cursor;
        int i;
        str.getClass();
        try {
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("downloads", this.f6677n, "packagename=? AND versioncode=?", new String[]{str, String.valueOf(j)}, null, null, null);
        } catch (Exception e10) {
            exc = e10;
            cursor = null;
        }
        try {
            x4.r i02 = cursor.moveToFirst() ? i0(cursor) : null;
            cursor.close();
            if (i02 != null && (i = i02.f11354a) >= 0) {
                i02.F = N(i);
            }
            return i02;
        } catch (Exception e11) {
            exc = e11;
            exc.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final x4.r M(long j) {
        Exception exc;
        Cursor cursor;
        int i;
        try {
            String[] strArr = {String.valueOf(j)};
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("downloads", this.f6677n, "updateId=?", strArr, null, null, null);
        } catch (Exception e10) {
            exc = e10;
            cursor = null;
        }
        try {
            x4.r i02 = cursor.moveToFirst() ? i0(cursor) : null;
            cursor.close();
            if (i02 != null && (i = i02.f11354a) >= 0) {
                i02.F = N(i);
            }
            return i02;
        } catch (Exception e11) {
            exc = e11;
            exc.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final ArrayList N(int i) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("download_files", this.f6678o, "downloadId=?", new String[]{String.valueOf(i)}, null, null, null);
            if (cursor.moveToFirst()) {
                arrayList.add(j0(cursor));
            }
            while (cursor.moveToNext()) {
                arrayList.add(j0(cursor));
            }
            cursor.close();
            return arrayList;
        } catch (Exception e10) {
            e10.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final k0 O(long j) {
        Exception exc;
        Cursor cursor;
        k0 k0Var;
        try {
            String[] strArr = {String.valueOf(j)};
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("download_promoted", this.f6679p, "appId=?", strArr, null, null, null);
            try {
                if (cursor.moveToFirst()) {
                    k0Var = new k0();
                    k0Var.f11252a = -1;
                    k0Var.f11255m = 1;
                    k0Var.f11252a = cursor.getInt(0);
                    k0Var.f11253b = cursor.getLong(1);
                    k0Var.f11254l = cursor.getString(2);
                    k0Var.f11255m = cursor.getInt(3);
                } else {
                    k0Var = null;
                }
                cursor.close();
                return k0Var;
            } catch (Exception e10) {
                exc = e10;
                exc.printStackTrace();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return null;
            }
        } catch (Exception e11) {
            exc = e11;
            cursor = null;
        }
    }

    public final ArrayList P() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("downloads", this.f6677n, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                x4.r i02 = i0(cursor);
                int i = i02.f11354a;
                if (i >= 0) {
                    i02.F = N(i);
                }
                arrayList.add(i02);
            }
            while (cursor.moveToNext()) {
                x4.r i03 = i0(cursor);
                int i6 = i03.f11354a;
                if (i6 >= 0) {
                    i03.F = N(i6);
                }
                arrayList.add(i03);
            }
            cursor.close();
            return arrayList;
        } catch (Exception e10) {
            e10.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final ArrayList Q() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            String valueOf = String.valueOf(100);
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("events", this.f6687y, null, null, null, null, null, valueOf);
            if (cursor.moveToFirst()) {
                arrayList.add(k0(cursor));
                while (cursor.moveToNext()) {
                    arrayList.add(k0(cursor));
                }
            }
            cursor.close();
            return arrayList;
        } catch (Exception e10) {
            e10.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final ArrayList R() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            String valueOf = String.valueOf(100);
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("errors", this.f6688z, null, null, null, null, null, valueOf);
            if (cursor.moveToFirst()) {
                arrayList.add(k0(cursor));
                while (cursor.moveToNext()) {
                    arrayList.add(k0(cursor));
                }
            }
            cursor.close();
            return arrayList;
        } catch (Exception e10) {
            e10.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final ArrayList S() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("installable_files", this.f6681r, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                arrayList.add(cursor.getString(1));
            }
            while (cursor.moveToNext()) {
                arrayList.add(cursor.getString(1));
            }
            cursor.close();
            return arrayList;
        } catch (Exception e10) {
            e10.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final ArrayList T() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.f6673a;
        sQLiteDatabase.getClass();
        Cursor query = sQLiteDatabase.query("remote_installs", this.B, "downloadId < 0", null, null, null, null);
        query.getClass();
        if (query.moveToFirst()) {
            a2 a2Var = new a2();
            a2Var.a(query);
            arrayList.add(a2Var);
            while (query.moveToNext()) {
                a2 a2Var2 = new a2();
                a2Var2.a(query);
                arrayList.add(a2Var2);
            }
        }
        query.close();
        return arrayList;
    }

    public final x1 U(long j) {
        Exception exc;
        Cursor cursor;
        x1 x1Var;
        try {
            String[] strArr = {String.valueOf(j)};
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("preregistrations", this.f6683t, "appId=?", strArr, null, null, null);
        } catch (Exception e10) {
            exc = e10;
            cursor = null;
        }
        try {
            if (cursor.moveToFirst()) {
                x1Var = new x1();
                x1Var.f11448a = cursor.getLong(0);
                x1Var.f11452e = cursor.getInt(1);
            } else {
                x1Var = null;
            }
            cursor.close();
            return x1Var;
        } catch (Exception e11) {
            exc = e11;
            exc.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final ArrayList V() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("recent_searches", this.f6680q, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                z1 z1Var = new z1();
                z1Var.f11479a = cursor.getString(0);
                z1Var.f11480b = cursor.getString(1);
                arrayList.add(z1Var);
            }
            while (cursor.moveToNext()) {
                z1 z1Var2 = new z1();
                z1Var2.f11479a = cursor.getString(0);
                z1Var2.f11480b = cursor.getString(1);
                arrayList.add(z1Var2);
            }
            cursor.close();
            return arrayList;
        } catch (Exception e10) {
            e10.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final ArrayList W(long j) {
        String[] strArr = {String.valueOf(j)};
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.f6673a;
        sQLiteDatabase.getClass();
        Cursor query = sQLiteDatabase.query("remote_installs", this.B, "appId=?", strArr, null, null, null);
        query.getClass();
        if (query.moveToFirst()) {
            a2 a2Var = new a2();
            a2Var.a(query);
            arrayList.add(a2Var);
            while (query.moveToNext()) {
                a2 a2Var2 = new a2();
                a2Var2.a(query);
                arrayList.add(a2Var2);
            }
        }
        query.close();
        return arrayList;
    }

    public final h2 X(String str) {
        h2 h2Var;
        Cursor query;
        Cursor cursor = null;
        r1 = null;
        h2 h2Var2 = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            query = sQLiteDatabase.query("responses", this.f6686x, "type=?", new String[]{str}, null, null, null);
        } catch (Exception e10) {
            e = e10;
            h2Var = null;
        }
        try {
            if (query.moveToFirst()) {
                query.getInt(0);
                String string = query.getString(1);
                String string2 = query.getString(2);
                String string3 = query.getString(3);
                string.getClass();
                string2.getClass();
                h2 h2Var3 = new h2(string, string2);
                string3.getClass();
                h2Var3.f11213c = Long.parseLong(string3);
                h2Var2 = h2Var3;
            }
            query.close();
            return h2Var2;
        } catch (Exception e11) {
            e = e11;
            h2 h2Var4 = h2Var2;
            cursor = query;
            h2Var = h2Var4;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return h2Var;
        }
    }

    public final q2 Y(String str) {
        Cursor cursor;
        q2 q2Var;
        str.getClass();
        try {
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("updates", this.f6676m, "packagename=?", new String[]{str}, null, null, null);
        } catch (Exception e10) {
            e = e10;
            cursor = null;
        }
        try {
            if (cursor.moveToFirst()) {
                q2Var = l0(cursor);
                x4.r M = M(q2Var.f11343a);
                q2Var.f11352s = M;
                q2Var.f11353t = Z(M);
            } else {
                q2Var = null;
            }
            cursor.close();
            return q2Var;
        } catch (Exception e11) {
            e = e11;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final ArrayList Z(x4.r rVar) {
        ArrayList arrayList = new ArrayList();
        if (rVar != null) {
            Cursor cursor = null;
            try {
                int i = rVar.f11354a;
                if (i >= 0) {
                    String[] strArr = {String.valueOf(i)};
                    SQLiteDatabase sQLiteDatabase = this.f6673a;
                    sQLiteDatabase.getClass();
                    cursor = sQLiteDatabase.query("download_required_features", this.A, "downloadId=?", strArr, null, null, null);
                    if (cursor.moveToFirst()) {
                        arrayList.add(cursor.getString(0));
                        while (cursor.moveToNext()) {
                            arrayList.add(cursor.getString(0));
                        }
                    }
                    cursor.close();
                    return arrayList;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        }
        return arrayList;
    }

    public final ArrayList a0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("updates", this.f6676m, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                q2 l02 = l0(cursor);
                arrayList.add(l02);
                x4.r M = M(l02.f11343a);
                l02.f11352s = M;
                l02.f11353t = Z(M);
            }
            while (cursor.moveToNext()) {
                q2 l03 = l0(cursor);
                arrayList.add(l03);
                x4.r M2 = M(l03.f11343a);
                l03.f11352s = M2;
                l03.f11353t = Z(M2);
            }
            cursor.close();
            return arrayList;
        } catch (Exception e10) {
            e10.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final synchronized void b() {
        if (this.C.incrementAndGet() == 1) {
            g gVar = E;
            gVar.getClass();
            gVar.f6673a = gVar.getWritableDatabase();
        }
    }

    public final void b0(x4.r rVar) {
        rVar.getClass();
        ContentValues contentValues = new ContentValues();
        contentValues.put("packagename", rVar.f11355b);
        contentValues.put("checked", Integer.valueOf(rVar.f11356l));
        contentValues.put("incomplete", Integer.valueOf(rVar.f11357m));
        contentValues.put("versioncode", Long.valueOf(rVar.f11358n));
        contentValues.put("versionname", rVar.f11359o);
        contentValues.put("attempts", Integer.valueOf(rVar.f11360p));
        contentValues.put("idPrograma", Long.valueOf(rVar.f11361q));
        contentValues.put("downloadAnyway", Integer.valueOf(rVar.f11362r));
        contentValues.put("md5signature", rVar.f11363s);
        contentValues.put("supportedAbis", rVar.f11364t);
        contentValues.put("minsdk", Integer.valueOf(rVar.f11365u));
        contentValues.put("urlIcon", rVar.v);
        contentValues.put("appName", rVar.f11366w);
        contentValues.put("nextAttemptTimeStamp", Long.valueOf(rVar.f11367x));
        contentValues.put("updateId", Long.valueOf(rVar.f11369z));
        contentValues.put("deeplink", Integer.valueOf(rVar.A));
        contentValues.put("is_rollback", Integer.valueOf(rVar.B));
        SQLiteDatabase sQLiteDatabase = this.f6673a;
        sQLiteDatabase.getClass();
        long insert = sQLiteDatabase.insert("downloads", null, contentValues);
        rVar.f11354a = (int) insert;
        Iterator it = rVar.F.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            c0((j0) next, insert);
        }
    }

    public final synchronized void c() {
        try {
            if (this.C.decrementAndGet() == 0) {
                g gVar = E;
                gVar.getClass();
                gVar.close();
            } else if (this.C.get() < 0) {
                this.C.set(0);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void c0(j0 j0Var, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("downloadId", Long.valueOf(j));
        contentValues.put("fileId", Long.valueOf(j0Var.f11235l));
        contentValues.put("size", Long.valueOf(j0Var.f11237n));
        contentValues.put("size_downloaded", Long.valueOf(j0Var.f11238o));
        contentValues.put("filehash", j0Var.f11239p);
        contentValues.put("absolutePath", j0Var.f11240q);
        contentValues.put("attempts", Integer.valueOf(j0Var.f11241r));
        contentValues.put("nextAttemptTimeStamp", Long.valueOf(j0Var.f11242s));
        SQLiteDatabase sQLiteDatabase = this.f6673a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.insert("download_files", null, contentValues);
    }

    public final void d0(String str, String str2, String str3, String str4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", str);
        contentValues.put("body", str2);
        contentValues.put("url", str3);
        contentValues.put("action_button_text", str4);
        contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        SQLiteDatabase sQLiteDatabase = this.f6673a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.insert("pending_system_messages", null, contentValues);
    }

    public final void e(String str) {
        str.getClass();
        x4.e B = B(str);
        if (B != null) {
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            sQLiteDatabase.delete("apps", "packagename=?", new String[]{str});
            String[] strArr = {String.valueOf(B.f11121a)};
            SQLiteDatabase sQLiteDatabase2 = this.f6673a;
            sQLiteDatabase2.getClass();
            sQLiteDatabase2.delete("app_files", "app_id=?", strArr);
        }
    }

    public final void e0(q2 q2Var) {
        x4.r rVar;
        x4.r rVar2 = q2Var.f11352s;
        if (rVar2 != null) {
            b0(rVar2);
            q2Var.f11352s = rVar2;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("packagename", q2Var.f11344b);
        contentValues.put("versionCode", Long.valueOf(q2Var.f11345l));
        contentValues.put("versionName", q2Var.f11346m);
        contentValues.put("notified", Integer.valueOf(q2Var.f11347n));
        contentValues.put("ignoreVersion", Integer.valueOf(q2Var.f11348o));
        contentValues.put("isPartialUpdate", Integer.valueOf(q2Var.f11349p));
        contentValues.put("newFeatures", q2Var.f11350q);
        contentValues.put("installationAttempts", Integer.valueOf(q2Var.f11351r));
        SQLiteDatabase sQLiteDatabase = this.f6673a;
        sQLiteDatabase.getClass();
        long insert = sQLiteDatabase.insert("updates", null, contentValues);
        x4.r rVar3 = q2Var.f11352s;
        if (rVar3 != null) {
            if (insert < 0) {
                j(rVar3);
                return;
            }
            rVar3.f11369z = insert;
            ArrayList arrayList = q2Var.f11353t;
            if (arrayList != null && !arrayList.isEmpty() && (rVar = q2Var.f11352s) != null && rVar.f11354a >= 0) {
                ArrayList arrayList2 = q2Var.f11353t;
                arrayList2.getClass();
                Iterator it = arrayList2.iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("name", (String) next);
                    x4.r rVar4 = q2Var.f11352s;
                    rVar4.getClass();
                    contentValues2.put("downloadId", Integer.valueOf(rVar4.f11354a));
                    SQLiteDatabase sQLiteDatabase2 = this.f6673a;
                    sQLiteDatabase2.getClass();
                    sQLiteDatabase2.insert("download_required_features", null, contentValues2);
                }
            }
            x4.r rVar5 = q2Var.f11352s;
            rVar5.getClass();
            q0(rVar5);
        }
    }

    public final void f(x4.e eVar) {
        if (eVar.f11121a < 0) {
            String str = eVar.f11123l;
            str.getClass();
            x4.e B = B(str);
            if (B != null) {
                eVar.f11121a = B.f11121a;
            }
        }
        String[] strArr = {eVar.f11123l};
        SQLiteDatabase sQLiteDatabase = this.f6673a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.delete("apps", "packagename=?", strArr);
        String[] strArr2 = {String.valueOf(eVar.f11121a)};
        SQLiteDatabase sQLiteDatabase2 = this.f6673a;
        sQLiteDatabase2.getClass();
        sQLiteDatabase2.delete("app_files", "app_id=?", strArr2);
    }

    public final void h(e1 e1Var) {
        String str = e1Var.f11138a;
        if (str != null) {
            String[] strArr = {str};
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            sQLiteDatabase.delete("app_files", "sha256=?", strArr);
            return;
        }
        String str2 = e1Var.f11140c;
        if (str2 != null) {
            SQLiteDatabase sQLiteDatabase2 = this.f6673a;
            sQLiteDatabase2.getClass();
            sQLiteDatabase2.delete("app_files", "path=?", new String[]{str2});
        }
    }

    public final void i(String str) {
        SQLiteDatabase sQLiteDatabase = this.f6673a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.delete("app_installers", "packagename=?", new String[]{str});
    }

    public final int j(x4.r rVar) {
        if (rVar == null) {
            return 0;
        }
        String[] strArr = {String.valueOf(rVar.f11354a)};
        SQLiteDatabase sQLiteDatabase = this.f6673a;
        sQLiteDatabase.getClass();
        int delete = sQLiteDatabase.delete("downloads", "id=?", strArr);
        String[] strArr2 = {String.valueOf(rVar.f11354a)};
        SQLiteDatabase sQLiteDatabase2 = this.f6673a;
        sQLiteDatabase2.getClass();
        sQLiteDatabase2.delete("download_files", "downloadId=?", strArr2);
        return delete;
    }

    public final void m0(x4.e eVar) {
        eVar.getClass();
        ContentValues contentValues = new ContentValues();
        contentValues.put("exclude", Integer.valueOf(eVar.v));
        String[] strArr = {eVar.f11123l};
        SQLiteDatabase sQLiteDatabase = this.f6673a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.update("apps", contentValues, "packagename=?", strArr);
    }

    public final void n(long j) {
        String[] strArr = {String.valueOf(j)};
        SQLiteDatabase sQLiteDatabase = this.f6673a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.delete("remote_installs", "appId=?", strArr);
    }

    public final void n0(x4.e eVar) {
        eVar.getClass();
        ContentValues contentValues = new ContentValues();
        String str = eVar.f11122b;
        if (str != null) {
            contentValues.put("name", str);
        }
        long j = eVar.f11124m;
        if (j > 0) {
            contentValues.put("versionCode", Long.valueOf(j));
        }
        contentValues.put("issystemapp", Integer.valueOf(eVar.f11128q));
        contentValues.put("isSystemService", Integer.valueOf(eVar.f11129r));
        String str2 = eVar.f11126o;
        if (str2 != null) {
            contentValues.put("urlFicha", str2);
        }
        String str3 = eVar.f11132u;
        if (str3 != null) {
            contentValues.put("md5signature", str3);
        }
        contentValues.put("exclude", Integer.valueOf(eVar.v));
        contentValues.put("size", String.valueOf(eVar.f11133w));
        contentValues.put("excludeFromTracking", Integer.valueOf(eVar.f11135y));
        String str4 = eVar.f11136z;
        if (str4 != null) {
            contentValues.put("defaultName", str4);
        }
        String str5 = eVar.B;
        if (str5 != null) {
            contentValues.put("sha256", str5);
        }
        contentValues.put("positiveNotified", Integer.valueOf(eVar.C));
        contentValues.put("appID", Long.valueOf(eVar.F));
        contentValues.put("hasOldVersions", Integer.valueOf(eVar.G));
        String[] strArr = {eVar.f11123l};
        SQLiteDatabase sQLiteDatabase = this.f6673a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.update("apps", contentValues, "packagename=?", strArr);
    }

    public final void o0(x4.e eVar) {
        eVar.getClass();
        ContentValues contentValues = new ContentValues();
        contentValues.put("excludeFromTracking", Integer.valueOf(eVar.f11135y));
        String[] strArr = {eVar.f11123l};
        SQLiteDatabase sQLiteDatabase = this.f6673a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.update("apps", contentValues, "packagename=?", strArr);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.getClass();
        this.f6673a = sQLiteDatabase;
        d(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i6) {
        sQLiteDatabase.getClass();
        if (i < 656) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS updates");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS apps");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS app_files");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_files");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_promoted");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS recent_searches");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS installable_files");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS notifications");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS deep_link_files");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS active_notifications");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS responses");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preregistrations");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preregistrations_to_notify");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS errors");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_required_features");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS remote_installs");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS app_installers");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS device_status");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS data_usage");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS pending_system_messages");
        } else {
            if (i < 687) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_files");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_required_features");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS updates");
            }
            if (i < 712) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_promoted");
            }
            if (i < 715) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS data_usage");
            }
            if (i < 718) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS pending_system_messages(id integer primary key autoincrement, title text, body text, url text, action_button_text text, timestamp integer);");
                if (i >= 687) {
                    sQLiteDatabase.execSQL("ALTER TABLE downloads ADD COLUMN is_rollback integer default 0");
                }
            }
            if (i < 723 && i >= 718) {
                sQLiteDatabase.execSQL("ALTER TABLE pending_system_messages ADD COLUMN action_button_text text");
            }
        }
        d(sQLiteDatabase);
    }

    public final void p0(q2 q2Var) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("versionCode", Long.valueOf(q2Var.f11345l));
        contentValues.put("versionName", q2Var.f11346m);
        contentValues.put("notified", Integer.valueOf(q2Var.f11347n));
        contentValues.put("ignoreVersion", Integer.valueOf(q2Var.f11348o));
        contentValues.put("isPartialUpdate", Integer.valueOf(q2Var.f11349p));
        contentValues.put("newFeatures", q2Var.f11350q);
        contentValues.put("installationAttempts", Integer.valueOf(q2Var.f11351r));
        String[] strArr = {q2Var.f11344b};
        SQLiteDatabase sQLiteDatabase = this.f6673a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.update("updates", contentValues, "packagename=?", strArr);
    }

    public final void q0(x4.r rVar) {
        rVar.getClass();
        ContentValues contentValues = new ContentValues();
        contentValues.put("packagename", rVar.f11355b);
        contentValues.put("checked", Integer.valueOf(rVar.f11356l));
        contentValues.put("incomplete", Integer.valueOf(rVar.f11357m));
        contentValues.put("versioncode", Long.valueOf(rVar.f11358n));
        contentValues.put("versionname", rVar.f11359o);
        contentValues.put("attempts", Integer.valueOf(rVar.f11360p));
        contentValues.put("idPrograma", Long.valueOf(rVar.f11361q));
        contentValues.put("downloadAnyway", Integer.valueOf(rVar.f11362r));
        contentValues.put("md5signature", rVar.f11363s);
        contentValues.put("supportedAbis", rVar.f11364t);
        contentValues.put("minsdk", Integer.valueOf(rVar.f11365u));
        contentValues.put("urlIcon", rVar.v);
        contentValues.put("appName", rVar.f11366w);
        contentValues.put("nextAttemptTimeStamp", Long.valueOf(rVar.f11367x));
        contentValues.put("updateId", Long.valueOf(rVar.f11369z));
        contentValues.put("deeplink", Integer.valueOf(rVar.A));
        contentValues.put("is_rollback", Integer.valueOf(rVar.B));
        int i = rVar.f11354a;
        if (i >= 0) {
            String[] strArr = {String.valueOf(i)};
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            sQLiteDatabase.update("downloads", contentValues, "id=?", strArr);
            return;
        }
        String str = rVar.f11355b;
        if (str != null) {
            long j = rVar.f11358n;
            if (j > 0) {
                String[] strArr2 = {str, String.valueOf(j)};
                SQLiteDatabase sQLiteDatabase2 = this.f6673a;
                sQLiteDatabase2.getClass();
                sQLiteDatabase2.update("downloads", contentValues, "packagename=? AND versioncode=?", strArr2);
            }
        }
    }

    public final void r(String str) {
        SQLiteDatabase sQLiteDatabase = this.f6673a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.delete("responses", "type=?", new String[]{str});
    }

    public final void r0(j0 j0Var) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("size_downloaded", Long.valueOf(j0Var.f11238o));
        contentValues.put("absolutePath", j0Var.f11240q);
        contentValues.put("attempts", Integer.valueOf(j0Var.f11241r));
        contentValues.put("nextAttemptTimeStamp", Long.valueOf(j0Var.f11242s));
        String[] strArr = {String.valueOf(j0Var.f11233a)};
        SQLiteDatabase sQLiteDatabase = this.f6673a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.update("download_files", contentValues, "id=?", strArr);
    }

    public final void s(String str) {
        int i;
        str.getClass();
        String[] strArr = {str};
        q2 Y = Y(str);
        if (Y != null) {
            x4.r rVar = Y.f11352s;
            if (rVar != null && (i = rVar.f11354a) >= 0) {
                String[] strArr2 = {String.valueOf(i)};
                SQLiteDatabase sQLiteDatabase = this.f6673a;
                sQLiteDatabase.getClass();
                sQLiteDatabase.delete("download_required_features", "downloadId=?", strArr2);
            }
            j(Y.f11352s);
        }
        SQLiteDatabase sQLiteDatabase2 = this.f6673a;
        sQLiteDatabase2.getClass();
        sQLiteDatabase2.delete("updates", "packagename=?", strArr);
    }

    public final void s0(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("automaticDownload", Integer.valueOf(i));
        String[] strArr = {String.valueOf(j)};
        SQLiteDatabase sQLiteDatabase = this.f6673a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.update("preregistrations", contentValues, "appId=?", strArr);
    }

    public final void t0(a2 a2Var) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("downloadId", Integer.valueOf(a2Var.f11045d));
        String[] strArr = {String.valueOf(a2Var.f11043b)};
        SQLiteDatabase sQLiteDatabase = this.f6673a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.update("remote_installs", contentValues, "appId=?", strArr);
    }

    public final void u() {
        Iterator it = a0().iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            s(((q2) next).f11344b);
        }
    }

    public final void u0(String str, int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("appID", Long.valueOf(j));
        contentValues.put("hasOldVersions", Integer.valueOf(i));
        contentValues.put("trackInfoRegistered", (Integer) 1);
        SQLiteDatabase sQLiteDatabase = this.f6673a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.update("apps", contentValues, "packagename=?", new String[]{str});
    }

    public final x4.b y(int i) {
        Cursor cursor;
        try {
            String[] strArr = {String.valueOf(i)};
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("active_notifications", this.f6685w, "notificationId=?", strArr, null, null, null);
        } catch (Exception e10) {
            e = e10;
            cursor = null;
        }
        try {
            x4.b f02 = cursor.moveToFirst() ? f0(cursor) : null;
            cursor.close();
            return f02;
        } catch (Exception e11) {
            e = e11;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final x4.b z(long j, String str) {
        Exception exc;
        Cursor cursor;
        str.getClass();
        try {
            String[] strArr = {str, String.valueOf(j)};
            SQLiteDatabase sQLiteDatabase = this.f6673a;
            sQLiteDatabase.getClass();
            cursor = sQLiteDatabase.query("active_notifications", this.f6685w, "packagename=? AND versioncode=?", strArr, null, null, null);
            try {
                x4.b f02 = cursor.moveToFirst() ? f0(cursor) : null;
                cursor.close();
                return f02;
            } catch (Exception e10) {
                exc = e10;
                exc.printStackTrace();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return null;
            }
        } catch (Exception e11) {
            exc = e11;
            cursor = null;
        }
    }
}
