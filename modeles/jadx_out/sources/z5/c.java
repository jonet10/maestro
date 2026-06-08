package z5;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b2.t1;
import c.h;
import c.i;
import f9.q;
import j9.f;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;
import kotlin.jvm.internal.l;
import m5.u0;
import o7.a0;
import o7.c0;
import o7.m0;
import u5.m;
import v7.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends p9.a implements c.b {
    public RecyclerView A;
    public d B;
    public h C;

    /* renamed from: z, reason: collision with root package name */
    public ConstraintLayout f11974z;

    public final void a() {
        CharSequence query;
        SearchView searchView = this.f8497n;
        if (searchView == null || (query = searchView.getQuery()) == null) {
            return;
        }
        h hVar = this.C;
        if (hVar == null) {
            l.i("switchAdapter");
            throw null;
        }
        d dVar = this.B;
        if (dVar == null) {
            l.i("viewModel");
            throw null;
        }
        ArrayList c9 = dVar.c(query.toString());
        boolean z9 = query.length() > 0;
        hVar.f1155a = c9;
        if (!z9) {
            hVar.a();
        }
        hVar.notifyDataSetChanged();
    }

    @Override // c.b
    public final void e(i iVar) {
        String str;
        String str2;
        String str3;
        h8.d dVar = iVar.f1160a;
        FragmentActivity activity = getActivity();
        if (activity != null && (dVar instanceof h8.i) && activity.getSupportFragmentManager().findFragmentByTag("d") == null) {
            String str4 = dVar.f5466b;
            h8.i iVar2 = (h8.i) dVar;
            Set set = iVar2.f5481p;
            String str5 = iVar2.j;
            String str6 = iVar2.f5473c;
            d dVar2 = this.B;
            if (dVar2 == null) {
                l.i("viewModel");
                throw null;
            }
            String a8 = dVar2.a(iVar2.f5474d, 1);
            d dVar3 = this.B;
            if (dVar3 == null) {
                l.i("viewModel");
                throw null;
            }
            String a10 = dVar3.a(iVar2.g, 2);
            d dVar4 = this.B;
            if (dVar4 == null) {
                l.i("viewModel");
                throw null;
            }
            String a11 = dVar4.a(iVar2.h, 3);
            d dVar5 = this.B;
            if (dVar5 == null) {
                l.i("viewModel");
                throw null;
            }
            String a12 = dVar5.a(iVar2.i, 4);
            d dVar6 = this.B;
            if (dVar6 == null) {
                l.i("viewModel");
                throw null;
            }
            String a13 = dVar6.a(iVar2.f5479n, 5);
            if (str5.length() == 0) {
                h8.h hVar = (h8.h) q6.l.s0(set);
                str5 = hVar == null ? "" : hVar.f5471a;
            }
            d dVar7 = this.B;
            if (dVar7 == null) {
                l.i("viewModel");
                throw null;
            }
            f fVar = dVar7.f11975a;
            int i = iVar2.f5477l;
            if (i < 0) {
                str = "";
            } else {
                float f = i / 86400.0f;
                if (f >= 1.0f) {
                    StringBuilder sb = new StringBuilder();
                    if (Float.isNaN(f)) {
                        com.google.gson.internal.a.p("Cannot round NaN value.");
                        return;
                    }
                    sb.append(Math.round(f));
                    sb.append(' ');
                    sb.append(fVar.g().i);
                    str = sb.toString();
                } else {
                    str = i + ' ' + fVar.g().j;
                }
            }
            d dVar8 = this.B;
            if (dVar8 == null) {
                l.i("viewModel");
                throw null;
            }
            f fVar2 = dVar8.f11975a;
            String str7 = str;
            Boolean bool = iVar2.f5478m;
            String str8 = l.a(bool, Boolean.TRUE) ? fVar2.g().f5579m : l.a(bool, Boolean.FALSE) ? fVar2.g().f5580n : "";
            d dVar9 = this.B;
            if (dVar9 == null) {
                l.i("viewModel");
                throw null;
            }
            g2.c cVar = iVar2.f5480o;
            if (cVar == null || (str2 = Integer.valueOf(cVar.f5111a).toString()) == null) {
                str2 = "";
            }
            if (str2.length() == 0) {
                str3 = str8;
            } else {
                str3 = str8;
                str2 = str2 + ' ' + dVar9.f11975a.g().i;
            }
            int i6 = dVar.f5465a;
            int i10 = iVar.f1163d;
            String str9 = iVar2.f5482q;
            String string = getString(2131952763);
            string.getClass();
            h8.h hVar2 = (h8.h) q6.l.s0(set);
            x5.b bVar = new x5.b(str4, str6, a8, null, a10, a11, a12, a13, str5, str7, str3, str2, i6, i10, str9, string, hVar2 != null ? hVar2.f5472b : "", 8);
            x5.d dVar10 = new x5.d();
            Bundle bundle = new Bundle();
            bundle.putParcelable("partner_detail_args", bVar);
            dVar10.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction().add(dVar10, "d").commit();
        }
    }

    @Override // c.b
    public final void f(i iVar) {
        int i = iVar.f1163d;
        h8.d dVar = iVar.f1160a;
        d dVar2 = this.B;
        if (dVar2 == null) {
            l.i("viewModel");
            throw null;
        }
        m mVar = dVar2.f11976b;
        if (i == 2) {
            Boolean bool = iVar.f1161b;
            Boolean bool2 = Boolean.TRUE;
            if (l.a(bool, bool2)) {
                mVar.A.set(dVar.f5465a);
                UUID uuid = q.f5065a;
                String str = "Non IAB_" + dVar.f5465a;
                String valueOf = String.valueOf(l.a(iVar.f1161b, bool2));
                valueOf.getClass();
                q.f5066b.h(str, valueOf);
                return;
            }
        }
        if (i == 2 && l.a(iVar.f1161b, Boolean.FALSE)) {
            mVar.A.unset(dVar.f5465a);
            UUID uuid2 = q.f5065a;
            String str2 = "Non IAB_" + dVar.f5465a;
            String valueOf2 = String.valueOf(l.a(iVar.f1161b, Boolean.TRUE));
            valueOf2.getClass();
            q.f5066b.h(str2, valueOf2);
            return;
        }
        if (i == 1) {
            Boolean bool3 = iVar.f1161b;
            Boolean bool4 = Boolean.TRUE;
            if (l.a(bool3, bool4)) {
                mVar.f10756z.set(dVar.f5465a);
                UUID uuid3 = q.f5065a;
                String str3 = "Vendors_" + dVar.f5465a;
                String valueOf3 = String.valueOf(l.a(iVar.f1161b, bool4));
                valueOf3.getClass();
                q.f5066b.h(str3, valueOf3);
                return;
            }
        }
        if (i == 1 && l.a(iVar.f1161b, Boolean.FALSE)) {
            mVar.f10756z.unset(dVar.f5465a);
            UUID uuid4 = q.f5065a;
            String str4 = "Vendors_" + dVar.f5465a;
            String valueOf4 = String.valueOf(l.a(iVar.f1161b, Boolean.TRUE));
            valueOf4.getClass();
            q.f5066b.h(str4, valueOf4);
            return;
        }
        if (i == 3) {
            Boolean bool5 = iVar.f1161b;
            Boolean bool6 = Boolean.TRUE;
            if (l.a(bool5, bool6)) {
                mVar.B.set(dVar.f5465a);
                UUID uuid5 = q.f5065a;
                String str5 = "Google_" + dVar.f5465a;
                String valueOf5 = String.valueOf(l.a(iVar.f1161b, bool6));
                valueOf5.getClass();
                q.f5066b.h(str5, valueOf5);
                return;
            }
        }
        if (i == 3 && l.a(iVar.f1161b, Boolean.FALSE)) {
            mVar.B.unset(dVar.f5465a);
            UUID uuid6 = q.f5065a;
            String str6 = "Google_" + dVar.f5465a;
            String valueOf6 = String.valueOf(l.a(iVar.f1161b, Boolean.TRUE));
            valueOf6.getClass();
            q.f5066b.h(str6, valueOf6);
            return;
        }
        if (i == 4) {
            Boolean bool7 = iVar.f1161b;
            Boolean bool8 = Boolean.TRUE;
            if (l.a(bool7, bool8)) {
                mVar.f10751t.set(dVar.f5465a);
                mVar.v.setItems(q6.l.J0(((h8.i) dVar).f5474d));
                UUID uuid7 = q.f5065a;
                String str7 = "Vendors_" + dVar.f5465a;
                String valueOf7 = String.valueOf(l.a(iVar.f1161b, bool8));
                valueOf7.getClass();
                q.f5066b.h(str7, valueOf7);
                return;
            }
        }
        if (i == 4 && l.a(iVar.f1161b, Boolean.FALSE)) {
            mVar.f10751t.unset(dVar.f5465a);
            mVar.v.unset(q6.l.J0(((h8.i) dVar).f5474d));
            UUID uuid8 = q.f5065a;
            String str8 = "Vendors_" + dVar.f5465a;
            String valueOf8 = String.valueOf(l.a(iVar.f1161b, Boolean.TRUE));
            valueOf8.getClass();
            q.f5066b.h(str8, valueOf8);
        }
    }

    @Override // p9.a, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() == null) {
            return;
        }
        ViewModelStore viewModelStore = getViewModelStore();
        viewModelStore.getClass();
        this.B = (d) new ViewModelProvider(viewModelStore, new b6.i(9)).get(d.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View inflate = layoutInflater.inflate(2131558517, viewGroup, false);
        inflate.getClass();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        d dVar = this.B;
        if (dVar == null) {
            l.i("viewModel");
            throw null;
        }
        SearchView searchView = this.f8497n;
        dVar.f11980k = searchView == null ? false : searchView.hasFocus();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p9.a, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Throwable th;
        Float f;
        Typeface typeface;
        SearchView searchView;
        Integer num;
        view.getClass();
        super.onViewCreated(view, bundle);
        this.f11974z = (ConstraintLayout) view.findViewById(2131362986);
        this.A = (RecyclerView) view.findViewById(2131363335);
        d dVar = this.B;
        if (dVar == null) {
            l.i("viewModel");
            throw null;
        }
        a0 viewModelScope = ViewModelKt.getViewModelScope(dVar);
        e eVar = m0.f8288a;
        v7.d dVar2 = v7.d.f10884a;
        p9.c cVar = new p9.c(dVar, (t6.c) null, 13);
        final int i = 2;
        c0.s(viewModelScope, dVar2, null, cVar, 2);
        TextView textView = this.f8494b;
        if (textView != null) {
            d dVar3 = this.B;
            if (dVar3 == null) {
                l.i("viewModel");
                throw null;
            }
            textView.setText(t1.d(dVar3.f11975a.f().f5584a));
        }
        ImageView imageView = this.f8495l;
        if (imageView != null) {
            imageView.setOnClickListener(new u0(this, 11));
            d dVar4 = this.B;
            if (dVar4 == null) {
                l.i("viewModel");
                throw null;
            }
            imageView.setContentDescription(dVar4.f11975a.f().g);
        }
        d dVar5 = this.B;
        if (dVar5 == null) {
            l.i("viewModel");
            throw null;
        }
        int i6 = 0;
        if (dVar5.e().isEmpty() && dVar5.b().isEmpty()) {
            th = null;
        } else {
            Toolbar toolbar = this.f8493a;
            final ImageView imageView2 = toolbar == null ? null : (ImageView) toolbar.findViewById(2131363547);
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            View inflate = LayoutInflater.from(getContext()).inflate(2131558671, (ViewGroup) null);
            final CardView cardView = (CardView) inflate.findViewById(2131362071);
            final TextView textView2 = (TextView) inflate.findViewById(2131363987);
            final TextView textView3 = (TextView) inflate.findViewById(2131363989);
            final TextView textView4 = (TextView) inflate.findViewById(2131363990);
            final TextView textView5 = (TextView) inflate.findViewById(2131363988);
            textView2.getClass();
            textView3.getClass();
            textView4.getClass();
            textView5.getClass();
            n9.a aVar = this.v;
            th = null;
            TextView[] textViewArr = {textView2, textView3, textView4, textView5};
            if (aVar != null && (typeface = aVar.f8119a) != null) {
                while (i6 < 4) {
                    TextView textView6 = textViewArr[i6];
                    i6++;
                    if (textView6 != null) {
                        textView6.setTypeface(typeface);
                    }
                }
            }
            if (aVar != null && (f = aVar.f8120b) != null) {
                float floatValue = f.floatValue();
                int i10 = 0;
                while (i10 < 4) {
                    TextView textView7 = textViewArr[i10];
                    i10++;
                    if (textView7 != null) {
                        textView7.setTextSize(2, floatValue);
                    }
                }
            }
            d dVar6 = this.B;
            if (dVar6 == null) {
                l.i("viewModel");
                throw null;
            }
            if (dVar6.e().isEmpty()) {
                textView4.setVisibility(8);
            }
            d dVar7 = this.B;
            if (dVar7 == null) {
                l.i("viewModel");
                throw null;
            }
            if (dVar7.b().isEmpty()) {
                textView5.setVisibility(8);
            }
            final int i11 = 1;
            final PopupWindow popupWindow = new PopupWindow(inflate, 600, -2, true);
            popupWindow.setElevation(10.0f);
            final int i12 = 0;
            textView2.setOnClickListener(new View.OnClickListener() { // from class: z5.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i13 = i12;
                    c cVar2 = this;
                    PopupWindow popupWindow2 = popupWindow;
                    switch (i13) {
                        case 0:
                            popupWindow2.dismiss();
                            TextView textView8 = cVar2.f8494b;
                            if (textView8 != null) {
                                textView8.setText(cVar2.getString(2131951674));
                            }
                            d dVar8 = cVar2.B;
                            if (dVar8 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar8.j = 1;
                            cVar2.a();
                            return;
                        case 1:
                            popupWindow2.dismiss();
                            TextView textView9 = cVar2.f8494b;
                            if (textView9 != null) {
                                textView9.setText(cVar2.getString(2131952067));
                            }
                            d dVar9 = cVar2.B;
                            if (dVar9 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar9.j = 2;
                            cVar2.a();
                            return;
                        case 2:
                            popupWindow2.dismiss();
                            TextView textView10 = cVar2.f8494b;
                            if (textView10 != null) {
                                textView10.setText(cVar2.getString(2131952393));
                            }
                            d dVar10 = cVar2.B;
                            if (dVar10 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar10.j = 3;
                            cVar2.a();
                            return;
                        default:
                            popupWindow2.dismiss();
                            TextView textView11 = cVar2.f8494b;
                            if (textView11 != null) {
                                textView11.setText(cVar2.getString(2131952055));
                            }
                            d dVar11 = cVar2.B;
                            if (dVar11 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar11.j = 4;
                            cVar2.a();
                            return;
                    }
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: z5.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i13 = i11;
                    c cVar2 = this;
                    PopupWindow popupWindow2 = popupWindow;
                    switch (i13) {
                        case 0:
                            popupWindow2.dismiss();
                            TextView textView8 = cVar2.f8494b;
                            if (textView8 != null) {
                                textView8.setText(cVar2.getString(2131951674));
                            }
                            d dVar8 = cVar2.B;
                            if (dVar8 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar8.j = 1;
                            cVar2.a();
                            return;
                        case 1:
                            popupWindow2.dismiss();
                            TextView textView9 = cVar2.f8494b;
                            if (textView9 != null) {
                                textView9.setText(cVar2.getString(2131952067));
                            }
                            d dVar9 = cVar2.B;
                            if (dVar9 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar9.j = 2;
                            cVar2.a();
                            return;
                        case 2:
                            popupWindow2.dismiss();
                            TextView textView10 = cVar2.f8494b;
                            if (textView10 != null) {
                                textView10.setText(cVar2.getString(2131952393));
                            }
                            d dVar10 = cVar2.B;
                            if (dVar10 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar10.j = 3;
                            cVar2.a();
                            return;
                        default:
                            popupWindow2.dismiss();
                            TextView textView11 = cVar2.f8494b;
                            if (textView11 != null) {
                                textView11.setText(cVar2.getString(2131952055));
                            }
                            d dVar11 = cVar2.B;
                            if (dVar11 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar11.j = 4;
                            cVar2.a();
                            return;
                    }
                }
            });
            textView4.setOnClickListener(new View.OnClickListener() { // from class: z5.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i13 = i;
                    c cVar2 = this;
                    PopupWindow popupWindow2 = popupWindow;
                    switch (i13) {
                        case 0:
                            popupWindow2.dismiss();
                            TextView textView8 = cVar2.f8494b;
                            if (textView8 != null) {
                                textView8.setText(cVar2.getString(2131951674));
                            }
                            d dVar8 = cVar2.B;
                            if (dVar8 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar8.j = 1;
                            cVar2.a();
                            return;
                        case 1:
                            popupWindow2.dismiss();
                            TextView textView9 = cVar2.f8494b;
                            if (textView9 != null) {
                                textView9.setText(cVar2.getString(2131952067));
                            }
                            d dVar9 = cVar2.B;
                            if (dVar9 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar9.j = 2;
                            cVar2.a();
                            return;
                        case 2:
                            popupWindow2.dismiss();
                            TextView textView10 = cVar2.f8494b;
                            if (textView10 != null) {
                                textView10.setText(cVar2.getString(2131952393));
                            }
                            d dVar10 = cVar2.B;
                            if (dVar10 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar10.j = 3;
                            cVar2.a();
                            return;
                        default:
                            popupWindow2.dismiss();
                            TextView textView11 = cVar2.f8494b;
                            if (textView11 != null) {
                                textView11.setText(cVar2.getString(2131952055));
                            }
                            d dVar11 = cVar2.B;
                            if (dVar11 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar11.j = 4;
                            cVar2.a();
                            return;
                    }
                }
            });
            final int i13 = 3;
            textView5.setOnClickListener(new View.OnClickListener() { // from class: z5.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i132 = i13;
                    c cVar2 = this;
                    PopupWindow popupWindow2 = popupWindow;
                    switch (i132) {
                        case 0:
                            popupWindow2.dismiss();
                            TextView textView8 = cVar2.f8494b;
                            if (textView8 != null) {
                                textView8.setText(cVar2.getString(2131951674));
                            }
                            d dVar8 = cVar2.B;
                            if (dVar8 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar8.j = 1;
                            cVar2.a();
                            return;
                        case 1:
                            popupWindow2.dismiss();
                            TextView textView9 = cVar2.f8494b;
                            if (textView9 != null) {
                                textView9.setText(cVar2.getString(2131952067));
                            }
                            d dVar9 = cVar2.B;
                            if (dVar9 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar9.j = 2;
                            cVar2.a();
                            return;
                        case 2:
                            popupWindow2.dismiss();
                            TextView textView10 = cVar2.f8494b;
                            if (textView10 != null) {
                                textView10.setText(cVar2.getString(2131952393));
                            }
                            d dVar10 = cVar2.B;
                            if (dVar10 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar10.j = 3;
                            cVar2.a();
                            return;
                        default:
                            popupWindow2.dismiss();
                            TextView textView11 = cVar2.f8494b;
                            if (textView11 != null) {
                                textView11.setText(cVar2.getString(2131952055));
                            }
                            d dVar11 = cVar2.B;
                            if (dVar11 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar11.j = 4;
                            cVar2.a();
                            return;
                    }
                }
            });
            if (imageView2 != null) {
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: z5.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Integer num2;
                        Integer num3;
                        c cVar2 = c.this;
                        h9.d dVar8 = cVar2.f8502s;
                        if (dVar8 != null && (num3 = dVar8.g) != null) {
                            cardView.setBackgroundTintList(ColorStateList.valueOf(num3.intValue()));
                        }
                        h9.d dVar9 = cVar2.f8502s;
                        if (dVar9 != null && (num2 = dVar9.f5500k) != null) {
                            int intValue = num2.intValue();
                            textView2.setTextColor(ColorStateList.valueOf(intValue));
                            textView3.setTextColor(ColorStateList.valueOf(intValue));
                            textView4.setTextColor(ColorStateList.valueOf(intValue));
                            textView5.setTextColor(ColorStateList.valueOf(intValue));
                        }
                        popupWindow.showAsDropDown(imageView2);
                    }
                });
            }
        }
        SearchView searchView2 = this.f8497n;
        if (searchView2 != null) {
            searchView2.setVisibility(0);
        }
        SearchView searchView3 = this.f8497n;
        if (searchView3 != null) {
            d dVar8 = this.B;
            if (dVar8 == null) {
                l.i("viewModel");
                throw th;
            }
            searchView3.setQueryHint(dVar8.f11975a.f().f5586c);
        }
        SearchView searchView4 = this.f8497n;
        if (searchView4 != null) {
            searchView4.setOnQueryTextListener(new g5.f(this, 20));
        }
        d dVar9 = this.B;
        if (dVar9 == null) {
            l.i("viewModel");
            throw th;
        }
        ArrayList c9 = dVar9.c("");
        d dVar10 = this.B;
        if (dVar10 == null) {
            l.i("viewModel");
            throw th;
        }
        String str = dVar10.f11975a.f().f5585b;
        h9.d dVar11 = this.f8502s;
        this.C = new h(c9, (c.b) this, str, (Integer) (dVar11 == null ? th : dVar11.i), (Integer) (dVar11 == null ? th : dVar11.f5499e), (Integer) (dVar11 == null ? th : dVar11.f), (Integer) (dVar11 == null ? th : dVar11.f5495a), this.f8503t, this.v, 8);
        RecyclerView recyclerView = this.A;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            h hVar = this.C;
            if (hVar == null) {
                l.i("switchAdapter");
                throw th;
            }
            recyclerView.setAdapter(hVar);
        }
        h9.d dVar12 = this.f8502s;
        if (dVar12 != null && (num = dVar12.g) != null) {
            int intValue = num.intValue();
            ConstraintLayout constraintLayout = this.f11974z;
            if (constraintLayout != null) {
                constraintLayout.setBackgroundColor(intValue);
            }
        }
        d dVar13 = this.B;
        if (dVar13 == null) {
            l.i("viewModel");
            throw th;
        }
        if (!dVar13.f11980k || (searchView = this.f8497n) == null) {
            return;
        }
        searchView.requestFocus();
    }
}
