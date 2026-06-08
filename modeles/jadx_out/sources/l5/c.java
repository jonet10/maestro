package l5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.uptodown.UptodownApp;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends w3.a {

    /* renamed from: a, reason: collision with root package name */
    public final View f7130a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f7131b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f7132c;

    public c(View view, v3.e eVar) {
        eVar.getClass();
        this.f7130a = view;
        View findViewById = view.findViewById(2131364636);
        findViewById.getClass();
        View findViewById2 = view.findViewById(2131362450);
        findViewById2.getClass();
        ImageView imageView = (ImageView) findViewById2;
        this.f7131b = imageView;
        View findViewById3 = view.findViewById(2131362449);
        findViewById3.getClass();
        this.f7132c = (ImageView) findViewById3;
        ((z3.g) eVar).a(new y3.f());
        imageView.setOnClickListener(new c4.d(eVar, 24));
        findViewById.setOnClickListener(new c4.d(eVar, 24));
    }

    @Override // w3.a
    public final void d(v3.e eVar, v3.d dVar) {
        eVar.getClass();
        ImageView imageView = this.f7132c;
        v3.d dVar2 = v3.d.f10835m;
        ImageView imageView2 = this.f7131b;
        if (dVar == dVar2) {
            imageView2.setVisibility(8);
            imageView.setVisibility(8);
            return;
        }
        imageView2.setVisibility(0);
        float f = UptodownApp.I;
        Context context = this.f7130a.getContext();
        context.getClass();
        if (b4.d.e(context)) {
            return;
        }
        imageView.setVisibility(0);
    }
}
