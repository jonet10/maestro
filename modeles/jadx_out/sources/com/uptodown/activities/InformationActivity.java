package com.uptodown.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.room.g;
import c4.k0;
import com.uptodown.activities.InformationActivity;
import f4.c;
import java.util.List;
import k7.d;
import k7.i;
import l7.k;
import p6.m;
import t4.r;
import x4.l;
import x4.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class InformationActivity extends k0 {
    public static final /* synthetic */ int P = 0;
    public final m O = new m(new g(this, 18));

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = y0().f10078a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        if (drawable != null) {
            y0().f10079b.setNavigationIcon(drawable);
            y0().f10079b.setNavigationContentDescription(getString(2131951735));
        }
        final int i = 0;
        y0().f10079b.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: c4.u1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InformationActivity f2149b;

            {
                this.f2149b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i6 = i;
                InformationActivity informationActivity = this.f2149b;
                switch (i6) {
                    case 0:
                        int i10 = InformationActivity.P;
                        informationActivity.finish();
                        break;
                    default:
                        int i11 = InformationActivity.P;
                        String string = informationActivity.getString(2131952727);
                        string.getClass();
                        String string2 = informationActivity.getString(2131952633);
                        string2.getClass();
                        j5.c.e(informationActivity, string, string2);
                        break;
                }
            }
        });
        y0().f10086r.setTypeface(c.f4882w);
        y0().f10080l.setTypeface(c.f4883x);
        y0().f10081m.setTypeface(c.f4883x);
        y0().f10082n.setTypeface(c.f4883x);
        y0().f10084p.setTypeface(c.f4883x);
        y0().f10085q.setTypeface(c.f4883x);
        y0().f10083o.setTypeface(c.f4883x);
        TextView textView = y0().f10083o;
        String string = getString(2131952076);
        string.getClass();
        List<o> i02 = i.i0(new d(k.a(new k("\\[a](.*?)\\[/a]"), string), new l(0)));
        final int i6 = 1;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new k("\\[a](.*?)\\[/a]").b(string, new l(1)));
        for (o oVar : i02) {
            int y02 = l7.m.y0(spannableStringBuilder, oVar.f11303d, 0, false, 6);
            int length = oVar.f11303d.length() + y02;
            if (y02 >= 0) {
                spannableStringBuilder.setSpan(new b6.c(this, 2), y02, length, 33);
            }
        }
        textView.setText(spannableStringBuilder);
        y0().f10083o.setOnClickListener(new View.OnClickListener(this) { // from class: c4.u1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InformationActivity f2149b;

            {
                this.f2149b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i62 = i6;
                InformationActivity informationActivity = this.f2149b;
                switch (i62) {
                    case 0:
                        int i10 = InformationActivity.P;
                        informationActivity.finish();
                        break;
                    default:
                        int i11 = InformationActivity.P;
                        String string2 = informationActivity.getString(2131952727);
                        string2.getClass();
                        String string22 = informationActivity.getString(2131952633);
                        string22.getClass();
                        j5.c.e(informationActivity, string2, string22);
                        break;
                }
            }
        });
    }

    public final r y0() {
        return (r) this.O.getValue();
    }
}
