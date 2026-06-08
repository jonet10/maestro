package n5;

import android.content.Context;
import android.view.View;
import c4.k0;
import m8.q;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8062a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k0 f8063b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ d f8064l;

    public /* synthetic */ a(k0 k0Var, d dVar) {
        this.f8062a = 1;
        this.f8063b = k0Var;
        this.f8064l = dVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f8062a) {
            case 0:
                d dVar = this.f8064l;
                x4.g gVar = dVar.f8069a;
                long j = gVar.f11158a;
                String str = gVar.F;
                k0 k0Var = this.f8063b;
                d0.b.t(j, k0Var, str);
                dVar.c(k0Var);
                break;
            case 1:
                Context context = view.getContext();
                context.getClass();
                d dVar2 = this.f8064l;
                x4.g gVar2 = dVar2.f8069a;
                k0 k0Var2 = this.f8063b;
                d0.b.j(context, k0Var2, new q(2, dVar2, k0Var2), gVar2, true);
                break;
            default:
                this.f8064l.c(this.f8063b);
                break;
        }
    }

    public /* synthetic */ a(d dVar, k0 k0Var, int i) {
        this.f8062a = i;
        this.f8064l = dVar;
        this.f8063b = k0Var;
    }
}
