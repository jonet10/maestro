package e4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.gms.internal.measurement.i5;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public w4.c f4727a;

    /* renamed from: b, reason: collision with root package name */
    public Context f4728b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f4729c;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4729c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        y yVar = (y) viewHolder;
        yVar.getClass();
        Object obj = this.f4729c.get(i);
        obj.getClass();
        x4.g gVar = (x4.g) obj;
        View view = yVar.itemView;
        view.getClass();
        m5.e.b(view, yVar.f4721l, gVar);
        e2.d dVar = yVar.f4720b;
        TextView textView = (TextView) dVar.f4470o;
        TextView textView2 = (TextView) dVar.f4468m;
        m5.e.f(gVar, textView, textView2);
        yVar.d(gVar.F, (TextView) dVar.f4471p, textView2);
        yVar.e((ImageView) dVar.f4467l, gVar.h());
        ((TextView) dVar.f4472q).setText(String.valueOf(gVar.f11194y / 10.0d));
        ((TextView) dVar.f4469n).setText(yVar.f4722m.f4728b.getString(2131951973, i5.D(gVar.f11181r)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558765, viewGroup, false);
        int i6 = 2131362518;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(s6, 2131362518);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) s6;
            i6 = 2131364458;
            TextView textView = (TextView) ViewBindings.findChildViewById(s6, 2131364458);
            if (textView != null) {
                i6 = 2131364460;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(s6, 2131364460);
                if (textView2 != null) {
                    i6 = 2131364461;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(s6, 2131364461);
                    if (textView3 != null) {
                        i6 = 2131364462;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(s6, 2131364462);
                        if (textView4 != null) {
                            i6 = 2131364464;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(s6, 2131364464);
                            if (textView5 != null) {
                                return new y(this, new e2.d(relativeLayout, imageView, textView, textView2, textView3, textView4, textView5, 9), this.f4727a, this.f4728b);
                            }
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(s6.getResources().getResourceName(i6)));
        return null;
    }
}
