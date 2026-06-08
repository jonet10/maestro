package a4;

import android.net.Uri;
import com.google.android.gms.internal.measurement.z3;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class t0 {

    /* renamed from: a, reason: collision with root package name */
    public static final StringBuilder f177a = new StringBuilder();

    /* renamed from: b, reason: collision with root package name */
    public static final w8.k f178b;

    /* renamed from: c, reason: collision with root package name */
    public static final w8.k f179c;

    static {
        w8.k kVar = w8.k.f10970m;
        f178b = z3.m("RIFF");
        f179c = z3.m("WEBP");
    }

    public static String a(k0 k0Var, StringBuilder sb) {
        List list = (List) k0Var.i;
        Uri uri = (Uri) k0Var.f127b;
        if (uri != null) {
            String uri2 = uri.toString();
            sb.ensureCapacity(uri2.length() + 50);
            sb.append(uri2);
        } else {
            sb.ensureCapacity(50);
            sb.append(k0Var.f128c);
        }
        sb.append('\n');
        if (k0Var.b()) {
            sb.append("resize:");
            sb.append(k0Var.f129d);
            sb.append('x');
            sb.append(k0Var.f130e);
            sb.append('\n');
        }
        if (k0Var.f) {
            sb.append("centerCrop:");
            sb.append(k0Var.g);
            sb.append('\n');
        }
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(((q0) list.get(i)).b());
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}
