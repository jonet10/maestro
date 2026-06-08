package e4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.Iterator;
import x4.x1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4508a;

    /* renamed from: b, reason: collision with root package name */
    public final f0.i f4509b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f4510c;

    public d0(ArrayList arrayList, Context context, f0.i iVar) {
        arrayList.getClass();
        iVar.getClass();
        this.f4508a = context;
        this.f4509b = iVar;
        this.f4510c = new ArrayList();
        a(arrayList);
    }

    public final void a(ArrayList arrayList) {
        this.f4510c = new ArrayList();
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            this.f4510c.add((x1) next);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4510c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return i == this.f4510c.size() ? 4 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        viewHolder.getClass();
        if (!(viewHolder instanceof m5.o0)) {
            if (viewHolder instanceof m5.b1) {
                ((m5.b1) viewHolder).a();
                return;
            } else {
                if (viewHolder instanceof m5.c0) {
                    return;
                }
                com.google.gson.internal.a.p("ViewHolder unknown!!");
                return;
            }
        }
        m5.o0 o0Var = (m5.o0) viewHolder;
        Object obj = this.f4510c.get(i);
        obj.getClass();
        x1 x1Var = (x1) obj;
        a4.l0 e10 = a4.g0.d().e(x1Var.f11450c);
        float f = UptodownApp.I;
        Context context = o0Var.f7491b;
        e10.g(b4.d.f(context));
        e10.h(b4.d.x(context));
        g4.v vVar = o0Var.f7490a;
        ImageView imageView = (ImageView) vVar.f5279o;
        TextView textView = (TextView) vVar.f5275b;
        e10.e(imageView, null);
        ((TextView) vVar.f5277m).setText(x1Var.f11449b);
        ((TextView) vVar.f5276l).setText(x1Var.f11451d);
        if (!o0Var.f7493m) {
            textView.setText(context.getString(2131952477));
            z3.J(textView);
        } else {
            textView.setText(context.getString(2131951768));
            textView.setVisibility(0);
            textView.setBackground(ContextCompat.getDrawable(textView.getContext(), 2131231149));
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), 2131100824));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        if (i != 0) {
            if (i != 4) {
                com.google.gson.internal.a.p("viewType unknown");
                return null;
            }
            View b7 = c.j.b(viewGroup, 2131558768, viewGroup, false);
            b7.getClass();
            return new m5.c0(b7);
        }
        Context context = this.f4508a;
        View inflate = LayoutInflater.from(context).inflate(2131558794, viewGroup, false);
        int i6 = 2131362389;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362389);
        if (imageView != null) {
            i6 = 2131362756;
            if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362756)) != null) {
                i6 = 2131363150;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363150);
                if (relativeLayout != null) {
                    i6 = 2131363624;
                    TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363624);
                    if (textView != null) {
                        i6 = 2131363666;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363666);
                        if (textView2 != null) {
                            i6 = 2131364058;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364058);
                            if (textView3 != null) {
                                return new m5.o0(new g4.v((RelativeLayout) inflate, imageView, relativeLayout, textView, textView2, textView3, 6), context, this.f4509b);
                            }
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i6)));
        return null;
    }
}
