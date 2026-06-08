package com.google.gson.internal.sql;

import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
class SqlTimestampTypeAdapter extends i {

    /* renamed from: b, reason: collision with root package name */
    public static final j f3259b = new j() { // from class: com.google.gson.internal.sql.SqlTimestampTypeAdapter.1
        @Override // com.google.gson.j
        public final i a(com.google.gson.b bVar, TypeToken typeToken) {
            if (typeToken.f3266a != Timestamp.class) {
                return null;
            }
            bVar.getClass();
            return new SqlTimestampTypeAdapter(bVar.c(new TypeToken(Date.class)));
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final i f3260a;

    public SqlTimestampTypeAdapter(i iVar) {
        this.f3260a = iVar;
    }

    @Override // com.google.gson.i
    public final Object b(k3.a aVar) {
        Date date = (Date) this.f3260a.b(aVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // com.google.gson.i
    public final void c(k3.b bVar, Object obj) {
        this.f3260a.c(bVar, (Timestamp) obj);
    }
}
