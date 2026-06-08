package q5;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import b2.t1;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.model.ChoiceError;
import com.inmobi.cmp.model.DisplayInfo;
import com.inmobi.cmp.model.Regulations;
import f9.q;
import g4.b0;
import j9.j;
import java.util.Iterator;
import kotlin.jvm.internal.l;
import l8.n;
import l8.r;
import p6.m;
import y2.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends p9.a {
    public static final /* synthetic */ int L = 0;
    public TextView A;
    public TextView B;
    public Button C;
    public Button D;
    public CardView E;
    public TextView F;
    public TextView G;
    public NestedScrollView H;
    public TextView I;
    public o9.e J;
    public i K;

    /* renamed from: z, reason: collision with root package name */
    public LinearLayout f8701z;

    public final void a(TextView textView, String str, String str2, boolean z9) {
        if (textView == null) {
            return;
        }
        textView.setText(str2);
        textView.setVisibility(z9 ? 0 : 8);
        textView.setOnClickListener(new b0(26, this, str));
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface.getClass();
        super.onCancel(dialogInterface);
        i iVar = this.K;
        if (iVar == null) {
            l.i("mspaViewModel");
            throw null;
        }
        DisplayInfo displayInfo = new DisplayInfo(DisplayStatus.DISMISSED, "User dismissed US regulations screen", Regulations.MSPA, l.g.f7044a);
        ChoiceCmpCallback choiceCmpCallback = iVar.f8711c;
        if (choiceCmpCallback != null) {
            choiceCmpCallback.onCMPUIStatusChanged(displayInfo);
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    @Override // p9.a, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() == null) {
            return;
        }
        ViewModelStore viewModelStore = getViewModelStore();
        viewModelStore.getClass();
        this.J = (o9.e) new ViewModelProvider(viewModelStore, new b6.i(4)).get(o9.e.class);
        ViewModelStore viewModelStore2 = getViewModelStore();
        viewModelStore2.getClass();
        this.K = (i) new ViewModelProvider(viewModelStore2, new b6.i(5)).get(i.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View inflate = layoutInflater.inflate(2131558514, viewGroup, false);
        inflate.getClass();
        return inflate;
    }

    @Override // p9.a, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        n nVar;
        r rVar;
        r rVar2;
        n nVar2;
        r rVar3;
        r rVar4;
        n nVar3;
        r rVar5;
        r rVar6;
        r rVar7;
        TextView textView;
        view.getClass();
        super.onViewCreated(view, bundle);
        this.f8701z = (LinearLayout) view.findViewById(2131362044);
        this.A = (TextView) view.findViewById(2131364182);
        this.B = (TextView) view.findViewById(2131363760);
        this.G = (TextView) view.findViewById(2131363612);
        this.E = (CardView) view.findViewById(2131361953);
        this.F = (TextView) view.findViewById(2131363708);
        this.H = (NestedScrollView) view.findViewById(2131363480);
        this.C = (Button) view.findViewById(2131361987);
        this.D = (Button) view.findViewById(2131361982);
        this.I = (TextView) view.findViewById(2131364178);
        boolean z9 = m9.c.e().f7246u;
        Button button = this.C;
        final int i = 0;
        if (z9) {
            if (button != null) {
                button.setVisibility(0);
            }
        } else if (button != null) {
            button.setVisibility(8);
        }
        i iVar = this.K;
        if (iVar == null) {
            l.i("mspaViewModel");
            throw null;
        }
        j8.e.i(iVar.f8709a);
        TextView textView2 = this.f8494b;
        if (textView2 != null) {
            o9.e eVar = this.J;
            if (eVar == null) {
                l.i("ccpaViewModel");
                throw null;
            }
            String str = eVar.f8382c.f5488a;
            if (str.length() == 0) {
                str = getString(2131951776);
                str.getClass();
            }
            textView2.setText(str);
        }
        o9.e eVar2 = this.J;
        if (eVar2 == null) {
            l.i("ccpaViewModel");
            throw null;
        }
        int length = eVar2.b().length();
        TextView textView3 = this.F;
        if (length > 0) {
            if (textView3 != null) {
                o9.e eVar3 = this.J;
                if (eVar3 == null) {
                    l.i("ccpaViewModel");
                    throw null;
                }
                textView3.setText(a.a.a(eVar3.b()));
            }
        } else if (textView3 != null) {
            textView3.setText(2131951775);
        }
        TextView textView4 = this.F;
        String str2 = "";
        if (textView4 != null) {
            o9.e eVar4 = this.J;
            if (eVar4 == null) {
                l.i("ccpaViewModel");
                throw null;
            }
            textView4.append(l.g.f7044a ? eVar4.f.f6983b.f6978c : "");
        }
        TextView textView5 = this.F;
        if (textView5 != null) {
            textView5.setMovementMethod(LinkMovementMethod.getInstance());
        }
        Context context = getContext();
        if (context != null && (textView = this.F) != null) {
            textView.setLinkTextColor(ContextCompat.getColor(context, 2131099738));
        }
        LinearLayout linearLayout = this.f8701z;
        final int i6 = 1;
        if (linearLayout != null) {
            o9.e eVar5 = this.J;
            if (eVar5 == null) {
                l.i("ccpaViewModel");
                throw null;
            }
            n nVar4 = eVar5.f8383d;
            linearLayout.setVisibility((nVar4 == null || (rVar7 = nVar4.f7243r) == null || !rVar7.f7257a) ? 0 : 8);
        }
        TextView textView6 = this.B;
        o9.e eVar6 = this.J;
        if (eVar6 == null) {
            l.i("ccpaViewModel");
            throw null;
        }
        n nVar5 = eVar6.f8383d;
        String str3 = (nVar5 == null || (rVar6 = nVar5.f7243r) == null) ? "" : rVar6.g;
        String c9 = eVar6.c();
        o9.e eVar7 = this.J;
        if (eVar7 == null) {
            l.i("ccpaViewModel");
            throw null;
        }
        a(textView6, str3, c9, eVar7.c().length() > 0 && (nVar3 = eVar7.f8383d) != null && (rVar5 = nVar3.f7243r) != null && rVar5.g.length() > 0);
        TextView textView7 = this.G;
        o9.e eVar8 = this.J;
        if (eVar8 == null) {
            l.i("ccpaViewModel");
            throw null;
        }
        n nVar6 = eVar8.f8383d;
        String str4 = (nVar6 == null || (rVar4 = nVar6.f7243r) == null) ? "" : rVar4.h;
        String a8 = eVar8.a();
        o9.e eVar9 = this.J;
        if (eVar9 == null) {
            l.i("ccpaViewModel");
            throw null;
        }
        a(textView7, str4, a8, eVar9.a().length() > 0 && (nVar2 = eVar9.f8383d) != null && (rVar3 = nVar2.f7243r) != null && rVar3.h.length() > 0);
        TextView textView8 = this.A;
        o9.e eVar10 = this.J;
        if (eVar10 == null) {
            l.i("ccpaViewModel");
            throw null;
        }
        n nVar7 = eVar10.f8383d;
        if (nVar7 != null && (rVar2 = nVar7.f7243r) != null) {
            str2 = rVar2.i;
        }
        String d10 = eVar10.d();
        o9.e eVar11 = this.J;
        if (eVar11 == null) {
            l.i("ccpaViewModel");
            throw null;
        }
        a(textView8, str2, d10, eVar11.d().length() > 0 && (nVar = eVar11.f8383d) != null && (rVar = nVar.f7243r) != null && rVar.i.length() > 0);
        ImageView imageView = this.f8495l;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: q5.b

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ d f8698b;

                {
                    this.f8698b = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Iterable, java.lang.Object, java.util.List] */
                /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Iterable, java.lang.Object, java.util.List] */
                /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Iterable, java.lang.Object] */
                /* JADX WARN: Type inference failed for: r6v12, types: [java.lang.Iterable, java.lang.Object] */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentManager supportFragmentManager;
                    FragmentTransaction beginTransaction;
                    FragmentTransaction add;
                    int i10 = i;
                    final int i11 = 0;
                    final d dVar = this.f8698b;
                    final int i12 = 1;
                    switch (i10) {
                        case 0:
                            i iVar2 = dVar.K;
                            if (iVar2 == null) {
                                l.i("mspaViewModel");
                                throw null;
                            }
                            DisplayInfo displayInfo = new DisplayInfo(DisplayStatus.DISMISSED, "User dismissed US regulations screen", Regulations.MSPA, l.g.f7044a);
                            ChoiceCmpCallback choiceCmpCallback = iVar2.f8711c;
                            if (choiceCmpCallback != null) {
                                choiceCmpCallback.onCMPUIStatusChanged(displayInfo);
                            }
                            dVar.dismiss();
                            FragmentActivity activity = dVar.getActivity();
                            if (activity == null) {
                                return;
                            }
                            activity.finish();
                            return;
                        case 1:
                            i iVar3 = dVar.K;
                            if (iVar3 == null) {
                                l.i("mspaViewModel");
                                throw null;
                            }
                            if (l.g.f7044a) {
                                j jVar = iVar3.f8710b;
                                jVar.getClass();
                                if (l.g.f7044a) {
                                    Vector vector = l.g.f7045b;
                                    vector.setAllOwnedItems();
                                    l9.a aVar = jVar.f6768a;
                                    Vector k5 = aVar.k(40);
                                    if (k5 != null) {
                                        k5.forEach(new l.e(0, vector));
                                    }
                                    aVar.e(40, vector);
                                    ChoiceCmpCallback choiceCmpCallback2 = jVar.f6769b;
                                    if (choiceCmpCallback2 != null) {
                                        choiceCmpCallback2.onGoogleBasicConsentChange(l.g.a());
                                    }
                                }
                            }
                            j8.a aVar2 = iVar3.f8709a;
                            h hVar = new h(iVar3, 0);
                            aVar2.getClass();
                            s sVar = j8.e.g;
                            if (sVar != 0) {
                                ?? r02 = aVar2.f6719d;
                                if (r02 != 0) {
                                    b6.b bVar = new b6.b(hVar, i12);
                                    for (j8.b bVar2 : r02) {
                                        bVar2.f6722c = Boolean.FALSE;
                                        ?? r32 = bVar2.f;
                                        if (r32 != 0) {
                                            Iterator it = r32.iterator();
                                            while (it.hasNext()) {
                                                ((j8.c) it.next()).f6728d = Boolean.FALSE;
                                            }
                                        }
                                    }
                                    sVar.h(r02, true, bVar);
                                }
                            } else {
                                a.a.h(null, ChoiceError.UNEXPECTED_ERROR_OCCURRED.getMessage(), null, 5);
                                hVar.invoke(null);
                            }
                            q.b(6, 1).observe(dVar, new Observer() { // from class: q5.c
                                @Override // androidx.lifecycle.Observer
                                public final void onChanged(Object obj) {
                                    int i13 = i12;
                                    d dVar2 = dVar;
                                    switch (i13) {
                                        case 0:
                                            FragmentActivity activity2 = dVar2.getActivity();
                                            if (activity2 != null) {
                                                t0.f.b(activity2, new a(dVar2, 1));
                                                break;
                                            }
                                            break;
                                        default:
                                            FragmentActivity activity3 = dVar2.getActivity();
                                            if (activity3 != null) {
                                                t0.f.b(activity3, new a(dVar2, 0));
                                                break;
                                            }
                                            break;
                                    }
                                }
                            });
                            return;
                        case 2:
                            i iVar4 = dVar.K;
                            if (iVar4 == null) {
                                l.i("mspaViewModel");
                                throw null;
                            }
                            if (l.g.f7044a) {
                                iVar4.f8710b.a();
                            }
                            j8.a aVar3 = iVar4.f8709a;
                            h hVar2 = new h(iVar4, 1);
                            aVar3.getClass();
                            s sVar2 = j8.e.g;
                            if (sVar2 != 0) {
                                ?? r03 = aVar3.f6719d;
                                if (r03 != 0) {
                                    b6.b bVar3 = new b6.b(hVar2, 2);
                                    for (j8.b bVar4 : r03) {
                                        bVar4.f6722c = Boolean.TRUE;
                                        ?? r62 = bVar4.f;
                                        if (r62 != 0) {
                                            Iterator it2 = r62.iterator();
                                            while (it2.hasNext()) {
                                                ((j8.c) it2.next()).f6728d = Boolean.TRUE;
                                            }
                                        }
                                    }
                                    sVar2.h(r03, true, bVar3);
                                }
                            } else {
                                a.a.h(null, ChoiceError.UNEXPECTED_ERROR_OCCURRED.getMessage(), null, 5);
                                hVar2.invoke(null);
                            }
                            q.b(7, 3).observe(dVar, new Observer() { // from class: q5.c
                                @Override // androidx.lifecycle.Observer
                                public final void onChanged(Object obj) {
                                    int i13 = i11;
                                    d dVar2 = dVar;
                                    switch (i13) {
                                        case 0:
                                            FragmentActivity activity2 = dVar2.getActivity();
                                            if (activity2 != null) {
                                                t0.f.b(activity2, new a(dVar2, 1));
                                                break;
                                            }
                                            break;
                                        default:
                                            FragmentActivity activity3 = dVar2.getActivity();
                                            if (activity3 != null) {
                                                t0.f.b(activity3, new a(dVar2, 0));
                                                break;
                                            }
                                            break;
                                    }
                                }
                            });
                            return;
                        default:
                            FragmentActivity activity2 = dVar.getActivity();
                            if (activity2 == null || (supportFragmentManager = activity2.getSupportFragmentManager()) == null || (beginTransaction = supportFragmentManager.beginTransaction()) == null || (add = beginTransaction.add(new g(), "d0.e")) == null) {
                                return;
                            }
                            add.commit();
                            return;
                    }
                }
            });
            o9.e eVar12 = this.J;
            if (eVar12 == null) {
                l.i("ccpaViewModel");
                throw null;
            }
            imageView.setContentDescription(eVar12.f8382c.f);
        }
        Button button2 = this.D;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener(this) { // from class: q5.b

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ d f8698b;

                {
                    this.f8698b = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Iterable, java.lang.Object, java.util.List] */
                /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Iterable, java.lang.Object, java.util.List] */
                /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Iterable, java.lang.Object] */
                /* JADX WARN: Type inference failed for: r6v12, types: [java.lang.Iterable, java.lang.Object] */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentManager supportFragmentManager;
                    FragmentTransaction beginTransaction;
                    FragmentTransaction add;
                    int i10 = i6;
                    final int i11 = 0;
                    final d dVar = this.f8698b;
                    final int i12 = 1;
                    switch (i10) {
                        case 0:
                            i iVar2 = dVar.K;
                            if (iVar2 == null) {
                                l.i("mspaViewModel");
                                throw null;
                            }
                            DisplayInfo displayInfo = new DisplayInfo(DisplayStatus.DISMISSED, "User dismissed US regulations screen", Regulations.MSPA, l.g.f7044a);
                            ChoiceCmpCallback choiceCmpCallback = iVar2.f8711c;
                            if (choiceCmpCallback != null) {
                                choiceCmpCallback.onCMPUIStatusChanged(displayInfo);
                            }
                            dVar.dismiss();
                            FragmentActivity activity = dVar.getActivity();
                            if (activity == null) {
                                return;
                            }
                            activity.finish();
                            return;
                        case 1:
                            i iVar3 = dVar.K;
                            if (iVar3 == null) {
                                l.i("mspaViewModel");
                                throw null;
                            }
                            if (l.g.f7044a) {
                                j jVar = iVar3.f8710b;
                                jVar.getClass();
                                if (l.g.f7044a) {
                                    Vector vector = l.g.f7045b;
                                    vector.setAllOwnedItems();
                                    l9.a aVar = jVar.f6768a;
                                    Vector k5 = aVar.k(40);
                                    if (k5 != null) {
                                        k5.forEach(new l.e(0, vector));
                                    }
                                    aVar.e(40, vector);
                                    ChoiceCmpCallback choiceCmpCallback2 = jVar.f6769b;
                                    if (choiceCmpCallback2 != null) {
                                        choiceCmpCallback2.onGoogleBasicConsentChange(l.g.a());
                                    }
                                }
                            }
                            j8.a aVar2 = iVar3.f8709a;
                            h hVar = new h(iVar3, 0);
                            aVar2.getClass();
                            s sVar = j8.e.g;
                            if (sVar != 0) {
                                ?? r02 = aVar2.f6719d;
                                if (r02 != 0) {
                                    b6.b bVar = new b6.b(hVar, i12);
                                    for (j8.b bVar2 : r02) {
                                        bVar2.f6722c = Boolean.FALSE;
                                        ?? r32 = bVar2.f;
                                        if (r32 != 0) {
                                            Iterator it = r32.iterator();
                                            while (it.hasNext()) {
                                                ((j8.c) it.next()).f6728d = Boolean.FALSE;
                                            }
                                        }
                                    }
                                    sVar.h(r02, true, bVar);
                                }
                            } else {
                                a.a.h(null, ChoiceError.UNEXPECTED_ERROR_OCCURRED.getMessage(), null, 5);
                                hVar.invoke(null);
                            }
                            q.b(6, 1).observe(dVar, new Observer() { // from class: q5.c
                                @Override // androidx.lifecycle.Observer
                                public final void onChanged(Object obj) {
                                    int i13 = i12;
                                    d dVar2 = dVar;
                                    switch (i13) {
                                        case 0:
                                            FragmentActivity activity2 = dVar2.getActivity();
                                            if (activity2 != null) {
                                                t0.f.b(activity2, new a(dVar2, 1));
                                                break;
                                            }
                                            break;
                                        default:
                                            FragmentActivity activity3 = dVar2.getActivity();
                                            if (activity3 != null) {
                                                t0.f.b(activity3, new a(dVar2, 0));
                                                break;
                                            }
                                            break;
                                    }
                                }
                            });
                            return;
                        case 2:
                            i iVar4 = dVar.K;
                            if (iVar4 == null) {
                                l.i("mspaViewModel");
                                throw null;
                            }
                            if (l.g.f7044a) {
                                iVar4.f8710b.a();
                            }
                            j8.a aVar3 = iVar4.f8709a;
                            h hVar2 = new h(iVar4, 1);
                            aVar3.getClass();
                            s sVar2 = j8.e.g;
                            if (sVar2 != 0) {
                                ?? r03 = aVar3.f6719d;
                                if (r03 != 0) {
                                    b6.b bVar3 = new b6.b(hVar2, 2);
                                    for (j8.b bVar4 : r03) {
                                        bVar4.f6722c = Boolean.TRUE;
                                        ?? r62 = bVar4.f;
                                        if (r62 != 0) {
                                            Iterator it2 = r62.iterator();
                                            while (it2.hasNext()) {
                                                ((j8.c) it2.next()).f6728d = Boolean.TRUE;
                                            }
                                        }
                                    }
                                    sVar2.h(r03, true, bVar3);
                                }
                            } else {
                                a.a.h(null, ChoiceError.UNEXPECTED_ERROR_OCCURRED.getMessage(), null, 5);
                                hVar2.invoke(null);
                            }
                            q.b(7, 3).observe(dVar, new Observer() { // from class: q5.c
                                @Override // androidx.lifecycle.Observer
                                public final void onChanged(Object obj) {
                                    int i13 = i11;
                                    d dVar2 = dVar;
                                    switch (i13) {
                                        case 0:
                                            FragmentActivity activity2 = dVar2.getActivity();
                                            if (activity2 != null) {
                                                t0.f.b(activity2, new a(dVar2, 1));
                                                break;
                                            }
                                            break;
                                        default:
                                            FragmentActivity activity3 = dVar2.getActivity();
                                            if (activity3 != null) {
                                                t0.f.b(activity3, new a(dVar2, 0));
                                                break;
                                            }
                                            break;
                                    }
                                }
                            });
                            return;
                        default:
                            FragmentActivity activity2 = dVar.getActivity();
                            if (activity2 == null || (supportFragmentManager = activity2.getSupportFragmentManager()) == null || (beginTransaction = supportFragmentManager.beginTransaction()) == null || (add = beginTransaction.add(new g(), "d0.e")) == null) {
                                return;
                            }
                            add.commit();
                            return;
                    }
                }
            });
        }
        Button button3 = this.C;
        final int i10 = 2;
        if (button3 != null) {
            button3.setOnClickListener(new View.OnClickListener(this) { // from class: q5.b

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ d f8698b;

                {
                    this.f8698b = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Iterable, java.lang.Object, java.util.List] */
                /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Iterable, java.lang.Object, java.util.List] */
                /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Iterable, java.lang.Object] */
                /* JADX WARN: Type inference failed for: r6v12, types: [java.lang.Iterable, java.lang.Object] */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentManager supportFragmentManager;
                    FragmentTransaction beginTransaction;
                    FragmentTransaction add;
                    int i102 = i10;
                    final int i11 = 0;
                    final d dVar = this.f8698b;
                    final int i12 = 1;
                    switch (i102) {
                        case 0:
                            i iVar2 = dVar.K;
                            if (iVar2 == null) {
                                l.i("mspaViewModel");
                                throw null;
                            }
                            DisplayInfo displayInfo = new DisplayInfo(DisplayStatus.DISMISSED, "User dismissed US regulations screen", Regulations.MSPA, l.g.f7044a);
                            ChoiceCmpCallback choiceCmpCallback = iVar2.f8711c;
                            if (choiceCmpCallback != null) {
                                choiceCmpCallback.onCMPUIStatusChanged(displayInfo);
                            }
                            dVar.dismiss();
                            FragmentActivity activity = dVar.getActivity();
                            if (activity == null) {
                                return;
                            }
                            activity.finish();
                            return;
                        case 1:
                            i iVar3 = dVar.K;
                            if (iVar3 == null) {
                                l.i("mspaViewModel");
                                throw null;
                            }
                            if (l.g.f7044a) {
                                j jVar = iVar3.f8710b;
                                jVar.getClass();
                                if (l.g.f7044a) {
                                    Vector vector = l.g.f7045b;
                                    vector.setAllOwnedItems();
                                    l9.a aVar = jVar.f6768a;
                                    Vector k5 = aVar.k(40);
                                    if (k5 != null) {
                                        k5.forEach(new l.e(0, vector));
                                    }
                                    aVar.e(40, vector);
                                    ChoiceCmpCallback choiceCmpCallback2 = jVar.f6769b;
                                    if (choiceCmpCallback2 != null) {
                                        choiceCmpCallback2.onGoogleBasicConsentChange(l.g.a());
                                    }
                                }
                            }
                            j8.a aVar2 = iVar3.f8709a;
                            h hVar = new h(iVar3, 0);
                            aVar2.getClass();
                            s sVar = j8.e.g;
                            if (sVar != 0) {
                                ?? r02 = aVar2.f6719d;
                                if (r02 != 0) {
                                    b6.b bVar = new b6.b(hVar, i12);
                                    for (j8.b bVar2 : r02) {
                                        bVar2.f6722c = Boolean.FALSE;
                                        ?? r32 = bVar2.f;
                                        if (r32 != 0) {
                                            Iterator it = r32.iterator();
                                            while (it.hasNext()) {
                                                ((j8.c) it.next()).f6728d = Boolean.FALSE;
                                            }
                                        }
                                    }
                                    sVar.h(r02, true, bVar);
                                }
                            } else {
                                a.a.h(null, ChoiceError.UNEXPECTED_ERROR_OCCURRED.getMessage(), null, 5);
                                hVar.invoke(null);
                            }
                            q.b(6, 1).observe(dVar, new Observer() { // from class: q5.c
                                @Override // androidx.lifecycle.Observer
                                public final void onChanged(Object obj) {
                                    int i13 = i12;
                                    d dVar2 = dVar;
                                    switch (i13) {
                                        case 0:
                                            FragmentActivity activity2 = dVar2.getActivity();
                                            if (activity2 != null) {
                                                t0.f.b(activity2, new a(dVar2, 1));
                                                break;
                                            }
                                            break;
                                        default:
                                            FragmentActivity activity3 = dVar2.getActivity();
                                            if (activity3 != null) {
                                                t0.f.b(activity3, new a(dVar2, 0));
                                                break;
                                            }
                                            break;
                                    }
                                }
                            });
                            return;
                        case 2:
                            i iVar4 = dVar.K;
                            if (iVar4 == null) {
                                l.i("mspaViewModel");
                                throw null;
                            }
                            if (l.g.f7044a) {
                                iVar4.f8710b.a();
                            }
                            j8.a aVar3 = iVar4.f8709a;
                            h hVar2 = new h(iVar4, 1);
                            aVar3.getClass();
                            s sVar2 = j8.e.g;
                            if (sVar2 != 0) {
                                ?? r03 = aVar3.f6719d;
                                if (r03 != 0) {
                                    b6.b bVar3 = new b6.b(hVar2, 2);
                                    for (j8.b bVar4 : r03) {
                                        bVar4.f6722c = Boolean.TRUE;
                                        ?? r62 = bVar4.f;
                                        if (r62 != 0) {
                                            Iterator it2 = r62.iterator();
                                            while (it2.hasNext()) {
                                                ((j8.c) it2.next()).f6728d = Boolean.TRUE;
                                            }
                                        }
                                    }
                                    sVar2.h(r03, true, bVar3);
                                }
                            } else {
                                a.a.h(null, ChoiceError.UNEXPECTED_ERROR_OCCURRED.getMessage(), null, 5);
                                hVar2.invoke(null);
                            }
                            q.b(7, 3).observe(dVar, new Observer() { // from class: q5.c
                                @Override // androidx.lifecycle.Observer
                                public final void onChanged(Object obj) {
                                    int i13 = i11;
                                    d dVar2 = dVar;
                                    switch (i13) {
                                        case 0:
                                            FragmentActivity activity2 = dVar2.getActivity();
                                            if (activity2 != null) {
                                                t0.f.b(activity2, new a(dVar2, 1));
                                                break;
                                            }
                                            break;
                                        default:
                                            FragmentActivity activity3 = dVar2.getActivity();
                                            if (activity3 != null) {
                                                t0.f.b(activity3, new a(dVar2, 0));
                                                break;
                                            }
                                            break;
                                    }
                                }
                            });
                            return;
                        default:
                            FragmentActivity activity2 = dVar.getActivity();
                            if (activity2 == null || (supportFragmentManager = activity2.getSupportFragmentManager()) == null || (beginTransaction = supportFragmentManager.beginTransaction()) == null || (add = beginTransaction.add(new g(), "d0.e")) == null) {
                                return;
                            }
                            add.commit();
                            return;
                    }
                }
            });
        }
        TextView textView9 = this.I;
        final int i11 = 3;
        if (textView9 != null) {
            textView9.setOnClickListener(new View.OnClickListener(this) { // from class: q5.b

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ d f8698b;

                {
                    this.f8698b = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Iterable, java.lang.Object, java.util.List] */
                /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Iterable, java.lang.Object, java.util.List] */
                /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Iterable, java.lang.Object] */
                /* JADX WARN: Type inference failed for: r6v12, types: [java.lang.Iterable, java.lang.Object] */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentManager supportFragmentManager;
                    FragmentTransaction beginTransaction;
                    FragmentTransaction add;
                    int i102 = i11;
                    final int i112 = 0;
                    final d dVar = this.f8698b;
                    final int i12 = 1;
                    switch (i102) {
                        case 0:
                            i iVar2 = dVar.K;
                            if (iVar2 == null) {
                                l.i("mspaViewModel");
                                throw null;
                            }
                            DisplayInfo displayInfo = new DisplayInfo(DisplayStatus.DISMISSED, "User dismissed US regulations screen", Regulations.MSPA, l.g.f7044a);
                            ChoiceCmpCallback choiceCmpCallback = iVar2.f8711c;
                            if (choiceCmpCallback != null) {
                                choiceCmpCallback.onCMPUIStatusChanged(displayInfo);
                            }
                            dVar.dismiss();
                            FragmentActivity activity = dVar.getActivity();
                            if (activity == null) {
                                return;
                            }
                            activity.finish();
                            return;
                        case 1:
                            i iVar3 = dVar.K;
                            if (iVar3 == null) {
                                l.i("mspaViewModel");
                                throw null;
                            }
                            if (l.g.f7044a) {
                                j jVar = iVar3.f8710b;
                                jVar.getClass();
                                if (l.g.f7044a) {
                                    Vector vector = l.g.f7045b;
                                    vector.setAllOwnedItems();
                                    l9.a aVar = jVar.f6768a;
                                    Vector k5 = aVar.k(40);
                                    if (k5 != null) {
                                        k5.forEach(new l.e(0, vector));
                                    }
                                    aVar.e(40, vector);
                                    ChoiceCmpCallback choiceCmpCallback2 = jVar.f6769b;
                                    if (choiceCmpCallback2 != null) {
                                        choiceCmpCallback2.onGoogleBasicConsentChange(l.g.a());
                                    }
                                }
                            }
                            j8.a aVar2 = iVar3.f8709a;
                            h hVar = new h(iVar3, 0);
                            aVar2.getClass();
                            s sVar = j8.e.g;
                            if (sVar != 0) {
                                ?? r02 = aVar2.f6719d;
                                if (r02 != 0) {
                                    b6.b bVar = new b6.b(hVar, i12);
                                    for (j8.b bVar2 : r02) {
                                        bVar2.f6722c = Boolean.FALSE;
                                        ?? r32 = bVar2.f;
                                        if (r32 != 0) {
                                            Iterator it = r32.iterator();
                                            while (it.hasNext()) {
                                                ((j8.c) it.next()).f6728d = Boolean.FALSE;
                                            }
                                        }
                                    }
                                    sVar.h(r02, true, bVar);
                                }
                            } else {
                                a.a.h(null, ChoiceError.UNEXPECTED_ERROR_OCCURRED.getMessage(), null, 5);
                                hVar.invoke(null);
                            }
                            q.b(6, 1).observe(dVar, new Observer() { // from class: q5.c
                                @Override // androidx.lifecycle.Observer
                                public final void onChanged(Object obj) {
                                    int i13 = i12;
                                    d dVar2 = dVar;
                                    switch (i13) {
                                        case 0:
                                            FragmentActivity activity2 = dVar2.getActivity();
                                            if (activity2 != null) {
                                                t0.f.b(activity2, new a(dVar2, 1));
                                                break;
                                            }
                                            break;
                                        default:
                                            FragmentActivity activity3 = dVar2.getActivity();
                                            if (activity3 != null) {
                                                t0.f.b(activity3, new a(dVar2, 0));
                                                break;
                                            }
                                            break;
                                    }
                                }
                            });
                            return;
                        case 2:
                            i iVar4 = dVar.K;
                            if (iVar4 == null) {
                                l.i("mspaViewModel");
                                throw null;
                            }
                            if (l.g.f7044a) {
                                iVar4.f8710b.a();
                            }
                            j8.a aVar3 = iVar4.f8709a;
                            h hVar2 = new h(iVar4, 1);
                            aVar3.getClass();
                            s sVar2 = j8.e.g;
                            if (sVar2 != 0) {
                                ?? r03 = aVar3.f6719d;
                                if (r03 != 0) {
                                    b6.b bVar3 = new b6.b(hVar2, 2);
                                    for (j8.b bVar4 : r03) {
                                        bVar4.f6722c = Boolean.TRUE;
                                        ?? r62 = bVar4.f;
                                        if (r62 != 0) {
                                            Iterator it2 = r62.iterator();
                                            while (it2.hasNext()) {
                                                ((j8.c) it2.next()).f6728d = Boolean.TRUE;
                                            }
                                        }
                                    }
                                    sVar2.h(r03, true, bVar3);
                                }
                            } else {
                                a.a.h(null, ChoiceError.UNEXPECTED_ERROR_OCCURRED.getMessage(), null, 5);
                                hVar2.invoke(null);
                            }
                            q.b(7, 3).observe(dVar, new Observer() { // from class: q5.c
                                @Override // androidx.lifecycle.Observer
                                public final void onChanged(Object obj) {
                                    int i13 = i112;
                                    d dVar2 = dVar;
                                    switch (i13) {
                                        case 0:
                                            FragmentActivity activity2 = dVar2.getActivity();
                                            if (activity2 != null) {
                                                t0.f.b(activity2, new a(dVar2, 1));
                                                break;
                                            }
                                            break;
                                        default:
                                            FragmentActivity activity3 = dVar2.getActivity();
                                            if (activity3 != null) {
                                                t0.f.b(activity3, new a(dVar2, 0));
                                                break;
                                            }
                                            break;
                                    }
                                }
                            });
                            return;
                        default:
                            FragmentActivity activity2 = dVar.getActivity();
                            if (activity2 == null || (supportFragmentManager = activity2.getSupportFragmentManager()) == null || (beginTransaction = supportFragmentManager.beginTransaction()) == null || (add = beginTransaction.add(new g(), "d0.e")) == null) {
                                return;
                            }
                            add.commit();
                            return;
                    }
                }
            });
        }
        h9.d dVar = this.f8502s;
        if (dVar != null) {
            Integer num = dVar.g;
            if (num != null) {
                int intValue = num.intValue();
                view.setBackgroundColor(intValue);
                CardView cardView = this.E;
                if (cardView != null) {
                    cardView.setCardBackgroundColor(intValue);
                }
            }
            Integer num2 = dVar.f5495a;
            if (num2 != null) {
                int intValue2 = num2.intValue();
                NestedScrollView nestedScrollView = this.H;
                if (nestedScrollView != null) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(2.0f);
                    gradientDrawable.setStroke(4, intValue2);
                    nestedScrollView.setBackground(gradientDrawable);
                }
            }
            Integer num3 = dVar.i;
            if (num3 != null) {
                int intValue3 = num3.intValue();
                TextView textView10 = this.F;
                if (textView10 != null) {
                    textView10.setTextColor(intValue3);
                }
            }
            Integer num4 = dVar.f5501l;
            if (num4 != null) {
                int intValue4 = num4.intValue();
                TextView textView11 = this.F;
                if (textView11 != null) {
                    textView11.setLinkTextColor(intValue4);
                }
                TextView textView12 = this.G;
                if (textView12 != null) {
                    textView12.setTextColor(intValue4);
                }
                TextView textView13 = this.B;
                if (textView13 != null) {
                    textView13.setTextColor(intValue4);
                }
                TextView textView14 = this.A;
                if (textView14 != null) {
                    textView14.setTextColor(intValue4);
                }
                TextView textView15 = this.I;
                if (textView15 != null) {
                    textView15.setTextColor(intValue4);
                }
            }
            Integer num5 = dVar.f5504o;
            if (num5 != null) {
                int intValue5 = num5.intValue();
                Button button4 = this.C;
                if (button4 != null) {
                    button4.setBackgroundColor(intValue5);
                }
                Button button5 = this.D;
                if (button5 != null) {
                    button5.setBackgroundColor(intValue5);
                }
            }
            Integer num6 = dVar.f5502m;
            if (num6 != null) {
                int intValue6 = num6.intValue();
                Button button6 = this.C;
                if (button6 != null) {
                    button6.setTextColor(intValue6);
                }
                Button button7 = this.D;
                if (button7 != null) {
                    button7.setTextColor(intValue6);
                }
            }
        }
        t1.f(this.v, this.G, this.B, this.A, this.F, this.I);
        t1.f(this.f8504u, this.D, this.C);
        i iVar2 = this.K;
        if (iVar2 == null) {
            l.i("mspaViewModel");
            throw null;
        }
        if (!j8.e.f6734d) {
            iVar2.b();
        }
        j8.e.f6734d = true;
        m mVar = m9.c.v;
        ((l9.a) mVar.getValue()).g(67, true);
        if (this.K == null) {
            l.i("mspaViewModel");
            throw null;
        }
        if (l.g.f7044a) {
            l9.a aVar = (l9.a) mVar.getValue();
            aVar.getClass();
            aVar.g(92, true);
        }
    }
}
