package e1;

import java.util.Calendar;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p extends e2 {

    /* renamed from: l, reason: collision with root package name */
    public long f4181l;

    /* renamed from: m, reason: collision with root package name */
    public String f4182m;

    @Override // e1.e2
    public final boolean h() {
        Calendar calendar = Calendar.getInstance();
        this.f4181l = (calendar.get(16) + calendar.get(15)) / 60000;
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        this.f4182m = a4.x.o(new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length()), lowerCase, "-", lowerCase2);
        return false;
    }

    public final long k() {
        i();
        return this.f4181l;
    }

    public final String l() {
        i();
        return this.f4182m;
    }
}
