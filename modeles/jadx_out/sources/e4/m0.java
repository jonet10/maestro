package e4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f4625a;

    /* renamed from: b, reason: collision with root package name */
    public final w4.e f4626b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4627c;

    public m0(ArrayList arrayList, w4.e eVar) {
        eVar.getClass();
        this.f4625a = arrayList;
        this.f4626b = eVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4625a.size() + (this.f4627c ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return i == this.f4625a.size() ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        viewHolder.getClass();
        if (viewHolder instanceof m5.a1) {
            Object obj = this.f4625a.get(i);
            obj.getClass();
            final x4.j jVar = (x4.j) obj;
            final m5.a1 a1Var = (m5.a1) viewHolder;
            y2.s sVar = a1Var.f7305b;
            ArrayList arrayList = jVar.f11232r;
            final int i6 = 0;
            if (arrayList != null && !arrayList.isEmpty()) {
                ArrayList arrayList2 = jVar.f11232r;
                arrayList2.getClass();
                LinearLayout linearLayout = (LinearLayout) sVar.f11756l;
                RelativeLayout relativeLayout = (RelativeLayout) sVar.f11755b;
                linearLayout.removeAllViews();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMarginStart((int) relativeLayout.getResources().getDimension(2131166252));
                Iterator it = arrayList2.iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    int i11 = i10 + 1;
                    final x4.j jVar2 = (x4.j) it.next();
                    View inflate = LayoutInflater.from(relativeLayout.getContext()).inflate(2131558874, (ViewGroup) null);
                    inflate.getClass();
                    TextView textView = (TextView) inflate;
                    textView.setText(jVar2.f11225b);
                    textView.setTypeface(f4.c.f4883x);
                    final int i12 = 1;
                    textView.setAllCaps(true);
                    LinearLayout linearLayout2 = (LinearLayout) sVar.f11756l;
                    if (i10 > 0) {
                        linearLayout2.addView(inflate, layoutParams);
                    } else {
                        linearLayout2.addView(inflate);
                    }
                    textView.setOnClickListener(new View.OnClickListener() { // from class: m5.z0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            switch (i12) {
                                case 0:
                                    a1Var.f7306l.a(jVar2);
                                    break;
                                default:
                                    a1Var.f7306l.a(jVar2);
                                    break;
                            }
                        }
                    });
                    i10 = i11;
                }
            }
            ((TextView) sVar.f11758n).setText(jVar.f11225b);
            ((TextView) sVar.f11757m).setText(jVar.f11226l);
            ((RelativeLayout) sVar.f11755b).setOnClickListener(new View.OnClickListener() { // from class: m5.z0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i6) {
                        case 0:
                            a1Var.f7306l.a(jVar);
                            break;
                        default:
                            a1Var.f7306l.a(jVar);
                            break;
                    }
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        if (i != 0) {
            if (i != 1) {
                com.google.gson.internal.a.p("viewType unknown");
                return null;
            }
            View b7 = c.j.b(viewGroup, 2131558768, viewGroup, false);
            b7.getClass();
            return new m5.c0(b7);
        }
        View b10 = c.j.b(viewGroup, 2131558814, null, false);
        int i6 = 2131361801;
        if (((LinearLayout) ViewBindings.findChildViewById(b10, 2131361801)) != null) {
            i6 = 2131362257;
            if (((HorizontalScrollView) ViewBindings.findChildViewById(b10, 2131362257)) != null) {
                i6 = 2131362387;
                if (((ImageView) ViewBindings.findChildViewById(b10, 2131362387)) != null) {
                    i6 = 2131362722;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(b10, 2131362722);
                    if (linearLayout != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) b10;
                        i6 = 2131363778;
                        TextView textView = (TextView) ViewBindings.findChildViewById(b10, 2131363778);
                        if (textView != null) {
                            i6 = 2131364057;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(b10, 2131364057);
                            if (textView2 != null) {
                                return new m5.a1(new y2.s(relativeLayout, linearLayout, textView, textView2, 15), this.f4626b);
                            }
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(b10.getResources().getResourceName(i6)));
        return null;
    }
}
