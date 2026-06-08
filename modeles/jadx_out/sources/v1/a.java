package v1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import b2.k1;
import k0.k;
import r.j;
import x.g;
import y.e;
import y.f;
import y.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a implements s2.a, z.b, f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f10785a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10786b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f10787l;

    public /* synthetic */ a(long j, Object obj, Object obj2) {
        this.f10786b = obj;
        this.f10787l = obj2;
        this.f10785a = j;
    }

    @Override // y.f
    public Object apply(Object obj) {
        String str = (String) this.f10786b;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        int i = ((u.c) this.f10787l).f10383a;
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i)});
        try {
            boolean z9 = rawQuery.getCount() > 0;
            rawQuery.close();
            long j = this.f10785a;
            if (z9) {
                sQLiteDatabase.execSQL(k.g(j, "UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + ", " WHERE log_source = ? AND reason = ?"), new String[]{str, Integer.toString(i)});
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(i));
            contentValues.put("events_dropped_count", Long.valueOf(j));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
            return null;
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    @Override // s2.a
    public void b(s2.b bVar) {
        ((b) bVar.get()).d((String) this.f10786b, this.f10785a, (k1) this.f10787l);
    }

    @Override // z.b
    public Object execute() {
        g gVar = (g) this.f10786b;
        j jVar = (j) this.f10787l;
        y.d dVar = gVar.f11030c;
        long f = gVar.g.f() + this.f10785a;
        h hVar = (h) dVar;
        hVar.getClass();
        hVar.d(new e(f, jVar));
        return null;
    }

    public /* synthetic */ a(String str, long j, k1 k1Var) {
        this.f10786b = str;
        this.f10785a = j;
        this.f10787l = k1Var;
    }
}
