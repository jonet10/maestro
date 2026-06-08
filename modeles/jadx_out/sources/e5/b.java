package e5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import e1.c0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends Presenter {

    /* renamed from: a, reason: collision with root package name */
    public final w4.f f4733a;

    /* renamed from: b, reason: collision with root package name */
    public i5.b f4734b;

    public b(w4.f fVar) {
        this.f4733a = fVar;
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        viewHolder.getClass();
        if (obj != null) {
            x4.g gVar = (x4.g) obj;
            i5.b bVar = (i5.b) viewHolder;
            this.f4734b = bVar;
            Context context = viewHolder.view.getContext();
            context.getClass();
            TextView textView = bVar.f5662b;
            bVar.f5661a.setText(gVar.f11159b);
            String str = gVar.f11175o;
            w4.f fVar = this.f4733a;
            if (str == null || str.length() == 0 || fVar == null) {
                textView.setText(gVar.f11175o);
            } else {
                String str2 = gVar.f11175o;
                str2.getClass();
                textView.setText(a.a.M(str2, context, fVar));
            }
            String str3 = gVar.f11192x;
            if (str3 != null) {
                TextView textView2 = bVar.f5663l;
                if (fVar != null) {
                    textView2.setText(a.a.M(str3, context, fVar));
                } else {
                    textView2.setText(a.a.M(str3, context, new c0(17)));
                }
            }
            bVar.a(0);
            bVar.f5665n.setText(gVar.f11170l);
            bVar.f5666o.setText(gVar.f11190w);
            int i = gVar.f11194y;
            RelativeLayout relativeLayout = bVar.f5669r;
            if (i == 0) {
                relativeLayout.setVisibility(8);
                return;
            }
            TextView textView3 = (TextView) relativeLayout.findViewById(2131364539);
            textView3.setTypeface(f4.c.f4883x);
            textView3.setText(String.valueOf(gVar.f11194y / 10.0d));
            TextView textView4 = (TextView) relativeLayout.findViewById(2131364105);
            textView4.setTypeface(f4.c.f4883x);
            textView4.setText(String.valueOf(gVar.f11196z));
            View findViewById = relativeLayout.findViewById(2131362483);
            findViewById.getClass();
            ImageView imageView = (ImageView) findViewById;
            View findViewById2 = relativeLayout.findViewById(2131362489);
            findViewById2.getClass();
            ImageView imageView2 = (ImageView) findViewById2;
            View findViewById3 = relativeLayout.findViewById(2131362495);
            findViewById3.getClass();
            ImageView imageView3 = (ImageView) findViewById3;
            View findViewById4 = relativeLayout.findViewById(2131362501);
            findViewById4.getClass();
            ImageView imageView4 = (ImageView) findViewById4;
            View findViewById5 = relativeLayout.findViewById(2131362507);
            findViewById5.getClass();
            ImageView imageView5 = (ImageView) findViewById5;
            imageView.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
            imageView2.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
            imageView3.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
            imageView4.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
            imageView5.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
            if (gVar.f11194y > 5) {
                imageView.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
            }
            if (gVar.f11194y > 15) {
                imageView2.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
            }
            if (gVar.f11194y > 25) {
                imageView3.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
            }
            if (gVar.f11194y > 35) {
                imageView4.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
            }
            if (gVar.f11194y > 45) {
                imageView5.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
            }
        }
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558833, viewGroup, false);
        s6.getClass();
        return new i5.b(s6);
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        viewHolder.getClass();
    }
}
