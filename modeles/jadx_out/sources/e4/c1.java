package e4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.UptodownApp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import m5.u1;
import x4.y2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c1 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f4503a;

    /* renamed from: b, reason: collision with root package name */
    public final w4.b f4504b;

    public c1(ArrayList arrayList, w4.b bVar) {
        arrayList.getClass();
        bVar.getClass();
        this.f4503a = arrayList;
        this.f4504b = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4503a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        u1 u1Var = (u1) viewHolder;
        u1Var.getClass();
        Object obj = this.f4503a.get(i);
        obj.getClass();
        y2 y2Var = (y2) obj;
        t4.c1 c1Var = u1Var.f7604a;
        c1Var.f9676o.setText(y2Var.f11472a);
        TextView textView = c1Var.f9675n;
        long j = y2Var.f11474c;
        textView.setText(j <= 0 ? null : new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date(j)));
        a4.l0 e10 = a4.g0.d().e(y2Var.f11475d);
        float f = UptodownApp.I;
        Context context = u1Var.itemView.getContext();
        context.getClass();
        e10.h(b4.d.x(context));
        Context context2 = u1Var.itemView.getContext();
        context2.getClass();
        e10.g(b4.d.f(context2));
        e10.e(c1Var.f9674m, null);
        c1Var.f9673l.setVisibility(y2Var.f11476e == 1 ? 0 : 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558868, viewGroup, false);
        int i6 = 2131362288;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(s6, 2131362288);
        if (imageView != null) {
            i6 = 2131362391;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(s6, 2131362391);
            if (imageView2 != null) {
                i6 = 2131362671;
                if (((LinearLayout) ViewBindings.findChildViewById(s6, 2131362671)) != null) {
                    i6 = 2131363152;
                    if (((RelativeLayout) ViewBindings.findChildViewById(s6, 2131363152)) != null) {
                        i6 = 2131363949;
                        TextView textView = (TextView) ViewBindings.findChildViewById(s6, 2131363949);
                        if (textView != null) {
                            i6 = 2131364060;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(s6, 2131364060);
                            if (textView2 != null) {
                                return new u1(new t4.c1((RelativeLayout) s6, imageView, imageView2, textView, textView2, 0), this.f4504b);
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
