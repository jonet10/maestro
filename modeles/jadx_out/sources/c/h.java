package c;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class h extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f1155a;

    /* renamed from: b, reason: collision with root package name */
    public final b f1156b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1157c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1158d;

    /* renamed from: e, reason: collision with root package name */
    public final Integer f1159e;
    public final Integer f;
    public final Integer g;
    public final Integer h;
    public final n9.a i;
    public final n9.a j;

    public /* synthetic */ h(ArrayList arrayList, b bVar, String str, Integer num, Integer num2, Integer num3, Integer num4, n9.a aVar, n9.a aVar2, int i) {
        this(arrayList, bVar, (i & 4) != 0 ? "" : str, "", num, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : num3, num4, aVar, aVar2);
    }

    public final void a() {
        this.f1155a.add(0, new i(new h8.d(), null, 2, 0, null, null, 122));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f1155a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return j.c(((i) this.f1155a.get(i)).f1162c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Float f;
        Typeface typeface;
        Float f10;
        Typeface typeface2;
        Float f11;
        Typeface typeface3;
        Float f12;
        Typeface typeface4;
        Float f13;
        Typeface typeface5;
        viewHolder.getClass();
        if (viewHolder instanceof g) {
            final g gVar = (g) viewHolder;
            final i iVar = (i) this.f1155a.get(i);
            SwitchCompat switchCompat = gVar.f1153q;
            Integer num = gVar.f1147b;
            n9.a aVar = gVar.f1151o;
            iVar.getClass();
            final String str = this.f1158d;
            str.getClass();
            TextView textView = gVar.f1152p;
            h8.d dVar = iVar.f1160a;
            String str2 = dVar.f5466b;
            Integer num2 = iVar.g;
            String str3 = iVar.f;
            str2.getClass();
            str3.getClass();
            if (num2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(" (");
                sb.append(num2);
                sb.append(' ');
                String lowerCase = str3.toLowerCase(Locale.ROOT);
                lowerCase.getClass();
                sb.append(lowerCase);
                sb.append(')');
                str2 = sb.toString();
            }
            textView.setText(str2);
            if (num != null) {
                textView.setTextColor(num.intValue());
            }
            textView.setOnClickListener(new e(0, gVar, iVar));
            if (aVar != null && (typeface5 = aVar.f8119a) != null) {
                textView.setTypeface(typeface5);
            }
            if (aVar != null && (f13 = aVar.f8120b) != null) {
                textView.setTextSize(f13.floatValue());
            }
            if (iVar.f1161b == null) {
                switchCompat.setVisibility(8);
            } else {
                switchCompat.setVisibility(0);
                Boolean bool = iVar.f1161b;
                switchCompat.setChecked(bool == null ? false : bool.booleanValue());
            }
            switchCompat.setContentDescription(dVar.f5466b);
            switchCompat.setText((switchCompat.isChecked() || !iVar.f1164e) ? "" : str);
            switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: c.f
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z9) {
                    g gVar2 = gVar;
                    gVar2.getClass();
                    String str4 = str;
                    str4.getClass();
                    Boolean valueOf = Boolean.valueOf(z9);
                    i iVar2 = i.this;
                    iVar2.f1161b = valueOf;
                    gVar2.f1146a.f(iVar2);
                    boolean z10 = iVar2.f1164e;
                    SwitchCompat switchCompat2 = gVar2.f1153q;
                    if (switchCompat2.isChecked() || !z10) {
                        str4 = "";
                    }
                    switchCompat2.setText(str4);
                }
            });
            Integer num3 = gVar.f1148l;
            if (num3 != null) {
                int intValue = num3.intValue();
                Integer num4 = gVar.f1149m;
                if (num4 != null) {
                    int intValue2 = num4.intValue();
                    switchCompat.setThumbTintList(new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[0]}, new int[]{intValue, intValue2}));
                    switchCompat.setTrackTintList(new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[0]}, new int[]{ColorUtils.setAlphaComponent(intValue, 128), ColorUtils.setAlphaComponent(intValue2, 128)}));
                }
            }
            if (num != null) {
                switchCompat.setTextColor(num.intValue());
            }
            if (aVar != null && (typeface4 = aVar.f8119a) != null) {
                switchCompat.setTypeface(typeface4);
            }
            if (aVar != null && (f12 = aVar.f8120b) != null) {
                switchCompat.setTextSize(f12.floatValue());
            }
            Integer num5 = gVar.f1150n;
            if (num5 == null) {
                return;
            }
            gVar.f1154r.setBackgroundColor(num5.intValue());
            return;
        }
        if (viewHolder instanceof c) {
            c cVar = (c) viewHolder;
            n9.a aVar2 = cVar.f1133l;
            String str4 = this.f1157c;
            str4.getClass();
            TextView textView2 = cVar.f1134m;
            textView2.setText(str4);
            Integer num6 = cVar.f1131a;
            if (num6 != null) {
                textView2.setTextColor(num6.intValue());
            }
            if (aVar2 != null && (typeface3 = aVar2.f8119a) != null) {
                textView2.setTypeface(typeface3);
            }
            if (aVar2 != null && (f11 = aVar2.f8120b) != null) {
                textView2.setTextSize(f11.floatValue());
            }
            Integer num7 = cVar.f1132b;
            if (num7 == null) {
                return;
            }
            int intValue3 = num7.intValue();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(2.0f);
            gradientDrawable.setStroke(4, intValue3);
            textView2.setBackground(gradientDrawable);
            return;
        }
        if (viewHolder instanceof d) {
            d dVar2 = (d) viewHolder;
            n9.a aVar3 = dVar2.f1137l;
            String str5 = ((i) this.f1155a.get(i)).f;
            str5.getClass();
            TextView textView3 = dVar2.f1138m;
            textView3.setText(str5);
            Integer num8 = dVar2.f1135a;
            if (num8 != null) {
                textView3.setTextColor(num8.intValue());
            }
            if (aVar3 != null && (typeface2 = aVar3.f8119a) != null) {
                textView3.setTypeface(typeface2);
            }
            if (aVar3 != null && (f10 = aVar3.f8120b) != null) {
                textView3.setTextSize(f10.floatValue());
            }
            Integer num9 = dVar2.f1136b;
            if (num9 == null) {
                return;
            }
            dVar2.f1139n.setBackgroundColor(num9.intValue());
            return;
        }
        if (viewHolder instanceof a) {
            a aVar4 = (a) viewHolder;
            n9.a aVar5 = aVar4.f1128l;
            String str6 = ((i) this.f1155a.get(i)).f;
            str6.getClass();
            TextView textView4 = aVar4.f1129m;
            textView4.setText(str6);
            Integer num10 = aVar4.f1126a;
            if (num10 != null) {
                textView4.setTextColor(num10.intValue());
            }
            if (aVar5 != null && (typeface = aVar5.f8119a) != null) {
                textView4.setTypeface(typeface);
            }
            if (aVar5 != null && (f = aVar5.f8120b) != null) {
                textView4.setTextSize(f.floatValue());
            }
            Integer num11 = aVar4.f1127b;
            if (num11 == null) {
                return;
            }
            aVar4.f1130n.setBackgroundColor(num11.intValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        n9.a aVar = this.j;
        Integer num = this.h;
        Integer num2 = this.f1159e;
        if (i == 1) {
            View b7 = j.b(viewGroup, 2131558668, viewGroup, false);
            b7.getClass();
            return new c(b7, num2, num, aVar);
        }
        if (i == 2) {
            View b10 = j.b(viewGroup, 2131558669, viewGroup, false);
            b10.getClass();
            return new d(b10, num2, num, this.i);
        }
        if (i == 3) {
            View b11 = j.b(viewGroup, 2131558665, viewGroup, false);
            b11.getClass();
            return new a(b11, num2, num, aVar);
        }
        View b12 = j.b(viewGroup, 2131558667, viewGroup, false);
        b12.getClass();
        return new g(b12, this.f1156b, this.f1159e, this.f, this.g, this.h, this.j);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        viewHolder.getClass();
        if (viewHolder instanceof g) {
            ((g) viewHolder).f1153q.setOnCheckedChangeListener(null);
        }
        super.onViewRecycled(viewHolder);
    }

    public h(ArrayList arrayList, b bVar, String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, n9.a aVar, n9.a aVar2) {
        str.getClass();
        str2.getClass();
        this.f1155a = arrayList;
        this.f1156b = bVar;
        this.f1157c = str;
        this.f1158d = str2;
        this.f1159e = num;
        this.f = num2;
        this.g = num3;
        this.h = num4;
        this.i = aVar;
        this.j = aVar2;
        if (str.length() > 0) {
            a();
        }
    }
}
