package e4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.UptodownApp;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final w4.c f4621a;

    /* renamed from: b, reason: collision with root package name */
    public final w4.a f4622b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f4623c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4624d;

    public m(w4.j jVar, w4.a aVar) {
        jVar.getClass();
        aVar.getClass();
        this.f4621a = jVar;
        this.f4622b = aVar;
        this.f4623c = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4623c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        viewHolder.getClass();
        if (!(viewHolder instanceof k)) {
            if (viewHolder instanceof l) {
                int i6 = i + 1;
                if (kotlin.jvm.internal.l.a(this.f4623c.get(i), q6.l.y0(this.f4623c))) {
                    Object obj = this.f4623c.get(i);
                    obj.getClass();
                    ((l) viewHolder).g((x4.g) obj, i6, i, true);
                    return;
                } else {
                    Object obj2 = this.f4623c.get(i);
                    obj2.getClass();
                    ((l) viewHolder).g((x4.g) obj2, i6, i, false);
                    return;
                }
            }
            return;
        }
        k kVar = (k) viewHolder;
        Object obj3 = this.f4623c.get(i);
        obj3.getClass();
        x4.g gVar = (x4.g) obj3;
        ImageView imageView = kVar.f4579n;
        TextView textView = kVar.f4582q;
        ImageView imageView2 = kVar.f4578m;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        View view = kVar.itemView;
        Context context = view.getContext();
        context.getClass();
        m5.e.a(layoutParams, context, i + 1, 20);
        view.setLayoutParams(layoutParams);
        String e10 = gVar.e();
        if (e10 == null || e10.length() == 0) {
            androidx.lifecycle.l.A(kVar.itemView, 2131231216, imageView2);
        } else {
            a4.l0 e11 = a4.g0.d().e(gVar.f());
            float f = UptodownApp.I;
            Context context2 = kVar.itemView.getContext();
            context2.getClass();
            e11.h(b4.d.w(context2));
            a4.k0 k0Var = e11.f135b;
            k0Var.f = true;
            k0Var.g = 17;
            e11.f136c = true;
            Context context3 = imageView2.getContext();
            context3.getClass();
            e11.g(b4.d.f(context3));
            e11.e(imageView2, null);
        }
        View view2 = kVar.itemView;
        view2.getClass();
        m5.e.b(view2, kVar.f4576b, gVar);
        kVar.itemView.setOnLongClickListener(new d4.d(kVar, gVar, i, 2));
        TextView textView2 = kVar.f4581p;
        textView2.getClass();
        textView.getClass();
        m5.e.f(gVar, textView2, textView);
        imageView.getClass();
        kVar.e(imageView, gVar.i());
        kVar.c(gVar, kVar.f4580o, imageView, textView, kVar.f4584s, kVar.f4583r, kVar.f4585t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        boolean z9 = this.f4624d;
        w4.a aVar = this.f4622b;
        w4.c cVar = this.f4621a;
        if (z9) {
            View b7 = c.j.b(viewGroup, 2131558569, viewGroup, false);
            b7.getClass();
            return new l(b7, cVar, aVar);
        }
        View b10 = c.j.b(viewGroup, 2131558568, viewGroup, false);
        b10.getClass();
        return new k(b10, cVar, aVar);
    }
}
