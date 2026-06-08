package t1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class b implements g, z.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9506a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9507b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f9508l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f9509m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f9510n;

    public /* synthetic */ b(x.g gVar, Iterable iterable, r.j jVar, long j) {
        this.f9506a = 2;
        this.f9507b = gVar;
        this.f9510n = iterable;
        this.f9509m = jVar;
        this.f9508l = j;
    }

    @Override // t1.g
    public ScheduledFuture a(g5.g gVar) {
        switch (this.f9506a) {
            case 0:
                f fVar = (f) this.f9507b;
                Runnable runnable = (Runnable) this.f9510n;
                return fVar.f9525b.schedule(new e(fVar, runnable, gVar, 1), this.f9508l, (TimeUnit) this.f9509m);
            default:
                f fVar2 = (f) this.f9507b;
                Callable callable = (Callable) this.f9510n;
                return fVar2.f9525b.schedule(new androidx.work.impl.b(fVar2, callable, gVar, 1), this.f9508l, (TimeUnit) this.f9509m);
        }
    }

    @Override // z.b
    public Object execute() {
        x.g gVar = (x.g) this.f9507b;
        Iterable iterable = (Iterable) this.f9510n;
        r.j jVar = (r.j) this.f9509m;
        y.h hVar = (y.h) gVar.f11030c;
        hVar.getClass();
        if (iterable.iterator().hasNext()) {
            String concat = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ".concat(y.h.i(iterable));
            SQLiteDatabase b7 = hVar.b();
            b7.beginTransaction();
            try {
                b7.compileStatement(concat).execute();
                Cursor rawQuery = b7.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", null);
                while (rawQuery.moveToNext()) {
                    try {
                        hVar.f(rawQuery.getInt(0), u.c.MAX_RETRIES_REACHED, rawQuery.getString(1));
                    } catch (Throwable th) {
                        rawQuery.close();
                        throw th;
                    }
                }
                rawQuery.close();
                b7.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                b7.setTransactionSuccessful();
            } finally {
                b7.endTransaction();
            }
        }
        hVar.d(new y.e(gVar.g.f() + this.f9508l, jVar));
        return null;
    }

    public /* synthetic */ b(f fVar, Object obj, long j, TimeUnit timeUnit, int i) {
        this.f9506a = i;
        this.f9507b = fVar;
        this.f9510n = obj;
        this.f9508l = j;
        this.f9509m = timeUnit;
    }
}
