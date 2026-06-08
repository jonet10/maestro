package t2;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f9554b = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* renamed from: c, reason: collision with root package name */
    public static j f9555c;

    /* renamed from: a, reason: collision with root package name */
    public final q1.a f9556a;

    public j(q1.a aVar) {
        this.f9556a = aVar;
    }

    public final boolean a(u2.b bVar) {
        if (TextUtils.isEmpty(bVar.f10406c)) {
            return true;
        }
        long j = bVar.f + bVar.f10408e;
        this.f9556a.getClass();
        return j < (System.currentTimeMillis() / 1000) + 3600;
    }
}
