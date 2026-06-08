package o3;

import java.util.function.Predicate;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h implements b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8158a;

    /* renamed from: b, reason: collision with root package name */
    public Predicate f8159b;

    /* renamed from: c, reason: collision with root package name */
    public Object f8160c;

    public h(Predicate predicate) {
        this.f8158a = 0;
        this.f8160c = null;
        this.f8159b = predicate;
        setValue('-');
    }

    @Override // o3.b
    public final Object getValue() {
        switch (this.f8158a) {
            case 0:
                return (Character) this.f8160c;
            default:
                return (Integer) this.f8160c;
        }
    }

    @Override // o3.b
    public final void setValue(Object obj) {
        switch (this.f8158a) {
            case 0:
                Character valueOf = Character.valueOf(obj.toString().charAt(0));
                if (this.f8159b.test(valueOf)) {
                    this.f8160c = valueOf;
                    return;
                }
                throw new q3.c("Invalid value '" + valueOf + "'");
            default:
                ((i) this.f8159b).getClass();
                this.f8160c = (Integer) obj;
                return;
        }
    }
}
