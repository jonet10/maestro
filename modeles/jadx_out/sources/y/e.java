package y;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class e implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f11582a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r.j f11583b;

    public /* synthetic */ e(long j, r.j jVar) {
        this.f11582a = j;
        this.f11583b = jVar;
    }

    @Override // y.f
    public final Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(this.f11582a));
        r.j jVar = this.f11583b;
        String str = jVar.f8831a;
        o.d dVar = jVar.f8833c;
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, String.valueOf(b0.a.a(dVar))}) < 1) {
            contentValues.put("backend_name", str);
            contentValues.put("priority", Integer.valueOf(b0.a.a(dVar)));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }
}
