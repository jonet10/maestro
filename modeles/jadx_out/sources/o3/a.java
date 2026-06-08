package o3;

import a4.x;
import j$.util.Collection;
import j$.util.stream.Collectors;
import java.util.Collection;
import java.util.function.Predicate;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f8148a;

    /* renamed from: b, reason: collision with root package name */
    public Predicate f8149b = null;

    /* renamed from: c, reason: collision with root package name */
    public Object f8150c;

    public a(boolean z9) {
        this.f8148a = z9;
    }

    public abstract void a(String str);

    public abstract String b();

    public abstract String c(int i, String str);

    @Override // o3.b
    public Object getValue() {
        return this.f8150c;
    }

    @Override // o3.b
    public void setValue(Object obj) {
        Predicate predicate = this.f8149b;
        if (predicate == null || predicate.test(obj)) {
            this.f8150c = obj;
        } else {
            if (obj instanceof Collection) {
                throw new q3.c(x.n(new StringBuilder("Invalid value '"), (String) Collection.EL.stream((java.util.Collection) obj).map(new m3.a(1)).collect(Collectors.joining(",")), "'"));
            }
            throw new q3.c("Invalid value '" + obj + "'");
        }
    }
}
