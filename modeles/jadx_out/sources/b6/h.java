package b6;

import androidx.lifecycle.ViewModel;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import j9.j;
import j9.x;
import kotlin.jvm.internal.l;
import l8.n;
import u5.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final m f1092a;

    /* renamed from: b, reason: collision with root package name */
    public final n f1093b;

    /* renamed from: c, reason: collision with root package name */
    public final u5.d f1094c;

    /* renamed from: d, reason: collision with root package name */
    public final h8.i f1095d;

    /* renamed from: e, reason: collision with root package name */
    public final x f1096e;
    public final j9.h f;
    public final boolean g;
    public final h9.i h;
    public final k6.c i;
    public final j j;

    public h(m mVar, n nVar, u5.d dVar, h8.i iVar, x xVar, j9.h hVar, boolean z9, h9.i iVar2, k6.c cVar, j jVar) {
        dVar.getClass();
        xVar.getClass();
        hVar.getClass();
        jVar.getClass();
        this.f1092a = mVar;
        this.f1093b = nVar;
        this.f1094c = dVar;
        this.f1095d = iVar;
        this.f1096e = xVar;
        this.f = hVar;
        this.g = z9;
        this.h = iVar2;
        this.i = cVar;
        this.j = jVar;
    }

    public final String a() {
        String str;
        boolean C = d0.b.C();
        h9.i iVar = this.h;
        if (C) {
            str = iVar.i.f5509d;
        } else if (d0.b.s()) {
            str = iVar.j.f5485c;
            if (str.length() == 0) {
                str = iVar.f5538b;
            }
        } else {
            str = iVar.f5538b;
        }
        return l.g.f7044a ? l.g(this.i.f6983b.f6978c, str) : str;
    }

    public final void b() {
        n nVar = this.f1093b;
        String str = nVar.f7239n.f7198a;
        j9.h hVar = this.f;
        if (str != null) {
            PrivacyEncodingMode privacyEncodingMode = PrivacyEncodingMode.GPP;
            if (str.equals(privacyEncodingMode.getValue())) {
                hVar.b(privacyEncodingMode, true, true);
                return;
            }
        }
        String str2 = nVar.f7239n.f7198a;
        if (str2 != null) {
            PrivacyEncodingMode privacyEncodingMode2 = PrivacyEncodingMode.TCF;
            if (str2.equals(privacyEncodingMode2.getValue())) {
                hVar.b(privacyEncodingMode2, true, true);
                return;
            }
        }
        hVar.b(PrivacyEncodingMode.TCF_AND_GPP, true, true);
    }
}
