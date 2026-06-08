package a4;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends ThreadLocal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f79a;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f79a) {
            case 0:
                return new StringBuilder("Picasso-");
            case 1:
                return new Random();
            case 2:
                return Boolean.FALSE;
            case 3:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(n8.c.f8118e);
                return simpleDateFormat;
            default:
                return 0L;
        }
    }
}
