package c4;

import com.uptodown.UptodownApp;
import com.uptodown.activities.SearchActivity;
import java.io.File;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q9 implements w4.g, w4.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchActivity f2022a;

    public /* synthetic */ q9(SearchActivity searchActivity) {
        this.f2022a = searchActivity;
    }

    @Override // w4.g
    public void A(String str) {
        this.f2022a.N(str);
    }

    @Override // w4.c
    public void d(x4.g gVar) {
        gVar.getClass();
        float f = UptodownApp.I;
        if (b4.d.t()) {
            this.f2022a.i0(gVar.f11158a);
        }
    }

    @Override // w4.g
    public void g(x4.r rVar) {
        float f = UptodownApp.I;
        File g = rVar.g();
        g.getClass();
        b4.d.q(this.f2022a, null, g);
    }

    @Override // w4.g
    public void p(String str) {
        str.getClass();
        j5.c.e(this.f2022a, str, null);
    }

    @Override // w4.g
    public void u(x4.r rVar) {
        this.f2022a.D0(rVar != null ? rVar.f11355b : null);
    }
}
