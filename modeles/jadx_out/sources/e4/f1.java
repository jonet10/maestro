package e4;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import c4.c6;
import java.util.ArrayList;
import m5.z1;
import x4.b3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f1 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4530a;

    /* renamed from: b, reason: collision with root package name */
    public final t4.n0 f4531b;

    public f1(ArrayList arrayList, t4.n0 n0Var) {
        arrayList.getClass();
        this.f4530a = arrayList;
        this.f4531b = n0Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4530a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        z1 z1Var = (z1) viewHolder;
        z1Var.getClass();
        Object obj = this.f4530a.get(i);
        obj.getClass();
        b3 b3Var = (b3) obj;
        int i6 = b3Var.f11067l;
        y2.s sVar = z1Var.f7653a;
        if (i6 == 1) {
            ((TextView) sVar.f11757m).setText(((RelativeLayout) sVar.f11755b).getContext().getString(2131951887));
        } else {
            ((TextView) sVar.f11757m).setText(b3Var.f11066b);
        }
        if (b3Var.f11068m == 1) {
            RelativeLayout relativeLayout = (RelativeLayout) sVar.f11755b;
            CheckBox checkBox = (CheckBox) sVar.f11756l;
            TextView textView = (TextView) sVar.f11758n;
            relativeLayout.setAlpha(1.0f);
            checkBox.setVisibility(8);
            textView.setVisibility(0);
            textView.setText(relativeLayout.getContext().getString(2131951713));
            textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(relativeLayout.getContext(), 2131231352), (Drawable) null, (Drawable) null, (Drawable) null);
            relativeLayout.setOnClickListener(null);
            checkBox.setOnCheckedChangeListener(null);
            return;
        }
        if (b3Var.f11069n != 1) {
            RelativeLayout relativeLayout2 = (RelativeLayout) sVar.f11755b;
            CheckBox checkBox2 = (CheckBox) sVar.f11756l;
            TextView textView2 = (TextView) sVar.f11758n;
            relativeLayout2.setAlpha(0.3f);
            checkBox2.setVisibility(8);
            textView2.setVisibility(0);
            textView2.setText(relativeLayout2.getContext().getString(2131951923));
            textView2.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(relativeLayout2.getContext(), 2131231348), (Drawable) null, (Drawable) null, (Drawable) null);
            relativeLayout2.setOnClickListener(null);
            checkBox2.setOnCheckedChangeListener(null);
            return;
        }
        CheckBox checkBox3 = (CheckBox) sVar.f11756l;
        TextView textView3 = (TextView) sVar.f11758n;
        RelativeLayout relativeLayout3 = (RelativeLayout) sVar.f11755b;
        checkBox3.setVisibility(0);
        if (b3Var.f11070o != 1) {
            relativeLayout3.setAlpha(1.0f);
            checkBox3.setClickable(true);
            checkBox3.setChecked(false);
            textView3.setVisibility(8);
            textView3.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            relativeLayout3.setOnClickListener(new m5.u0(z1Var, 5));
            checkBox3.setOnCheckedChangeListener(new c6(z1Var, 4));
            return;
        }
        relativeLayout3.setAlpha(0.3f);
        checkBox3.setClickable(false);
        checkBox3.setChecked(true);
        textView3.setVisibility(0);
        textView3.setText(relativeLayout3.getContext().getString(2131952084));
        textView3.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(relativeLayout3.getContext(), 2131231406), (Drawable) null, (Drawable) null, (Drawable) null);
        relativeLayout3.setOnClickListener(null);
        checkBox3.setOnCheckedChangeListener(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558875, viewGroup, false);
        int i6 = 2131362006;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(s6, 2131362006);
        if (checkBox != null) {
            i6 = 2131362460;
            if (((ImageView) ViewBindings.findChildViewById(s6, 2131362460)) != null) {
                i6 = 2131362723;
                if (((LinearLayout) ViewBindings.findChildViewById(s6, 2131362723)) != null) {
                    i6 = 2131364222;
                    TextView textView = (TextView) ViewBindings.findChildViewById(s6, 2131364222);
                    if (textView != null) {
                        i6 = 2131364224;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(s6, 2131364224);
                        if (textView2 != null) {
                            return new z1(new y2.s((RelativeLayout) s6, checkBox, textView, textView2, 17), this.f4531b);
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(s6.getResources().getResourceName(i6)));
        return null;
    }
}
