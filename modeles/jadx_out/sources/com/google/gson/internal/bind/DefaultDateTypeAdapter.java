package com.google.gson.internal.bind;

import a4.x;
import com.google.gson.i;
import com.google.gson.internal.g;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends i {

    /* renamed from: c, reason: collision with root package name */
    public static final j f3137c = new j() { // from class: com.google.gson.internal.bind.DefaultDateTypeAdapter.1
        @Override // com.google.gson.j
        public final i a(com.google.gson.b bVar, TypeToken typeToken) {
            if (typeToken.f3266a == Date.class) {
                return new DefaultDateTypeAdapter();
            }
            return null;
        }

        public final String toString() {
            return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final a f3138a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3139b;

    public DefaultDateTypeAdapter() {
        ArrayList arrayList = new ArrayList();
        this.f3139b = arrayList;
        this.f3138a = b.f3183a;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (g.f3219a >= 9) {
            arrayList.add(new SimpleDateFormat(x.k("MMM d, yyyy", " ", "h:mm:ss a"), locale));
        }
    }

    @Override // com.google.gson.i
    public final Object b(k3.a aVar) {
        Date b7;
        if (aVar.H() == 9) {
            aVar.D();
            return null;
        }
        String F = aVar.F();
        synchronized (this.f3139b) {
            try {
                ArrayList arrayList = this.f3139b;
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        try {
                            b7 = i3.a.b(F, new ParsePosition(0));
                            break;
                        } catch (ParseException e10) {
                            StringBuilder v = x.v("Failed parsing '", F, "' as Date; at path ");
                            v.append(aVar.j(true));
                            throw new com.google.gson.e(v.toString(), e10);
                        }
                    }
                    Object obj = arrayList.get(i);
                    i++;
                    DateFormat dateFormat = (DateFormat) obj;
                    TimeZone timeZone = dateFormat.getTimeZone();
                    try {
                        try {
                            b7 = dateFormat.parse(F);
                            break;
                        } finally {
                            dateFormat.setTimeZone(timeZone);
                        }
                    } catch (ParseException unused) {
                        dateFormat.setTimeZone(timeZone);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f3138a.getClass();
        return b7;
    }

    @Override // com.google.gson.i
    public final void c(k3.b bVar, Object obj) {
        String format;
        Date date = (Date) obj;
        if (date == null) {
            bVar.n();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f3139b.get(0);
        synchronized (this.f3139b) {
            format = dateFormat.format(date);
        }
        bVar.C(format);
    }

    public final String toString() {
        DateFormat dateFormat = (DateFormat) this.f3139b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }
}
