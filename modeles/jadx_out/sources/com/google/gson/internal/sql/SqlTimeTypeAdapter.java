package com.google.gson.internal.sql;

import com.google.gson.e;
import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
final class SqlTimeTypeAdapter extends i {

    /* renamed from: b, reason: collision with root package name */
    public static final j f3257b = new j() { // from class: com.google.gson.internal.sql.SqlTimeTypeAdapter.1
        @Override // com.google.gson.j
        public final i a(com.google.gson.b bVar, TypeToken typeToken) {
            if (typeToken.f3266a == Time.class) {
                return new SqlTimeTypeAdapter(0);
            }
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f3258a;

    private SqlTimeTypeAdapter() {
        this.f3258a = new SimpleDateFormat("hh:mm:ss a");
    }

    @Override // com.google.gson.i
    public final Object b(k3.a aVar) {
        Time time;
        if (aVar.H() == 9) {
            aVar.D();
            return null;
        }
        String F = aVar.F();
        synchronized (this) {
            TimeZone timeZone = this.f3258a.getTimeZone();
            try {
                try {
                    time = new Time(this.f3258a.parse(F).getTime());
                } catch (ParseException e10) {
                    throw new e("Failed parsing '" + F + "' as SQL Time; at path " + aVar.j(true), e10);
                }
            } finally {
                this.f3258a.setTimeZone(timeZone);
            }
        }
        return time;
    }

    @Override // com.google.gson.i
    public final void c(k3.b bVar, Object obj) {
        String format;
        Time time = (Time) obj;
        if (time == null) {
            bVar.n();
            return;
        }
        synchronized (this) {
            format = this.f3258a.format((Date) time);
        }
        bVar.C(format);
    }

    public /* synthetic */ SqlTimeTypeAdapter(int i) {
        this();
    }
}
