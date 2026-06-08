package c4;

import com.uptodown.activities.PublicProfileActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m7 implements w4.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1869a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f1870b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ j5.s f1871l;

    public /* synthetic */ m7(PublicProfileActivity publicProfileActivity, j5.s sVar, int i) {
        this.f1869a = i;
        this.f1870b = publicProfileActivity;
        this.f1871l = sVar;
    }

    @Override // w4.b
    public final void b(int i) {
        switch (this.f1869a) {
            case 0:
                j5.r rVar = (j5.r) this.f1871l;
                this.f1870b.j0(((x4.g) ((u7) rVar.f6707a).f2168a.get(i)).f11158a, ((x4.g) ((u7) rVar.f6707a).f2168a.get(i)).f11174n);
                break;
            default:
                j5.r rVar2 = (j5.r) this.f1871l;
                this.f1870b.j0(((x4.g) ((ArrayList) rVar2.f6707a).get(i)).f11158a, ((x4.g) ((ArrayList) rVar2.f6707a).get(i)).f11174n);
                break;
        }
    }
}
