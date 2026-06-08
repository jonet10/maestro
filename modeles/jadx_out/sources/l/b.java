package l;

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
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import b2.t1;
import b6.i;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import com.inmobi.cmp.model.DisplayInfo;
import com.inmobi.cmp.model.Regulations;
import kotlin.jvm.internal.l;
import o7.c0;
import o7.m0;
import o7.z0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class b extends p9.a implements c.b {
    public static final /* synthetic */ int D = 0;
    public Button A;
    public NestedScrollView B;
    public c C;

    /* renamed from: z, reason: collision with root package name */
    public TextView f7028z;

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface.getClass();
        super.onCancel(dialogInterface);
        c cVar = this.C;
        if (cVar == null) {
            l.i("viewModel");
            throw null;
        }
        DisplayInfo displayInfo = new DisplayInfo(DisplayStatus.DISMISSED, "User dismissed GBC screen", Regulations.NA, true);
        ChoiceCmpCallback choiceCmpCallback = cVar.f7030b;
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
        this.C = (c) new ViewModelProvider(viewModelStore, new i(1)).get(c.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View inflate = layoutInflater.inflate(2131558564, viewGroup, false);
        inflate.getClass();
        return inflate;
    }

    @Override // p9.a, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        TextView textView;
        view.getClass();
        super.onViewCreated(view, bundle);
        this.f7028z = (TextView) view.findViewById(2131363888);
        this.A = (Button) view.findViewById(2131361990);
        this.B = (NestedScrollView) view.findViewById(2131363480);
        getChildFragmentManager().beginTransaction().add(2131362202, new d(), "d").addToBackStack(null).commit();
        TextView textView2 = this.f8494b;
        if (textView2 != null) {
            c cVar = this.C;
            if (cVar == null) {
                l.i("viewModel");
                throw null;
            }
            String str = cVar.f7031c.f6983b.f6976a;
            if (str.length() == 0) {
                str = getString(2131952804);
                str.getClass();
            }
            textView2.setText(str);
        }
        TextView textView3 = this.f7028z;
        if (textView3 != null) {
            c cVar2 = this.C;
            if (cVar2 == null) {
                l.i("viewModel");
                throw null;
            }
            String str2 = cVar2.f7031c.f6983b.f6978c;
            if (str2.length() == 0) {
                str2 = getString(2131952038);
                str2.getClass();
            }
            textView3.setText(str2);
        }
        TextView textView4 = this.f7028z;
        if (textView4 != null) {
            textView4.setMovementMethod(LinkMovementMethod.getInstance());
        }
        Context context = getContext();
        if (context != null && (textView = this.f7028z) != null) {
            textView.setLinkTextColor(ContextCompat.getColor(context, 2131099738));
        }
        Button button = this.A;
        if (button != null) {
            c cVar3 = this.C;
            if (cVar3 == null) {
                l.i("viewModel");
                throw null;
            }
            String str3 = cVar3.f7031c.f6983b.f6979d;
            if (str3.length() == 0) {
                str3 = getString(2131952554);
                str3.getClass();
            }
            button.setText(str3);
        }
        ImageView imageView = this.f8495l;
        final int i = 0;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: l.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b f7027b;

                {
                    this.f7027b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i6 = i;
                    b bVar = this.f7027b;
                    switch (i6) {
                        case 0:
                            c cVar4 = bVar.C;
                            if (cVar4 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            DisplayInfo displayInfo = new DisplayInfo(DisplayStatus.DISMISSED, "User dismissed GBC screen", Regulations.NA, true);
                            ChoiceCmpCallback choiceCmpCallback = cVar4.f7030b;
                            if (choiceCmpCallback != null) {
                                choiceCmpCallback.onCMPUIStatusChanged(displayInfo);
                            }
                            bVar.dismiss();
                            FragmentActivity activity = bVar.getActivity();
                            if (activity == null) {
                                return;
                            }
                            activity.finish();
                            return;
                        default:
                            Fragment findFragmentByTag = bVar.getChildFragmentManager().findFragmentByTag("d");
                            d dVar = findFragmentByTag instanceof d ? (d) findFragmentByTag : null;
                            if (dVar != null) {
                                dVar.a();
                            }
                            if (bVar.C == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            v7.e eVar = m0.f8288a;
                            c0.s(z0.f8335a, v7.d.f10884a, null, new b.d(2, null, 5), 2);
                            bVar.dismiss();
                            FragmentActivity activity2 = bVar.getActivity();
                            if (activity2 == null) {
                                return;
                            }
                            activity2.finish();
                            return;
                    }
                }
            });
        }
        Button button2 = this.A;
        final int i6 = 1;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener(this) { // from class: l.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b f7027b;

                {
                    this.f7027b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i62 = i6;
                    b bVar = this.f7027b;
                    switch (i62) {
                        case 0:
                            c cVar4 = bVar.C;
                            if (cVar4 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            DisplayInfo displayInfo = new DisplayInfo(DisplayStatus.DISMISSED, "User dismissed GBC screen", Regulations.NA, true);
                            ChoiceCmpCallback choiceCmpCallback = cVar4.f7030b;
                            if (choiceCmpCallback != null) {
                                choiceCmpCallback.onCMPUIStatusChanged(displayInfo);
                            }
                            bVar.dismiss();
                            FragmentActivity activity = bVar.getActivity();
                            if (activity == null) {
                                return;
                            }
                            activity.finish();
                            return;
                        default:
                            Fragment findFragmentByTag = bVar.getChildFragmentManager().findFragmentByTag("d");
                            d dVar = findFragmentByTag instanceof d ? (d) findFragmentByTag : null;
                            if (dVar != null) {
                                dVar.a();
                            }
                            if (bVar.C == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            v7.e eVar = m0.f8288a;
                            c0.s(z0.f8335a, v7.d.f10884a, null, new b.d(2, null, 5), 2);
                            bVar.dismiss();
                            FragmentActivity activity2 = bVar.getActivity();
                            if (activity2 == null) {
                                return;
                            }
                            activity2.finish();
                            return;
                    }
                }
            });
        }
        h9.d dVar = this.f8502s;
        if (dVar != null) {
            Integer num = dVar.g;
            if (num != null) {
                view.setBackgroundColor(num.intValue());
            }
            Integer num2 = dVar.f5495a;
            if (num2 != null) {
                int intValue = num2.intValue();
                NestedScrollView nestedScrollView = this.B;
                if (nestedScrollView != null) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(2.0f);
                    gradientDrawable.setStroke(4, intValue);
                    nestedScrollView.setBackground(gradientDrawable);
                }
            }
            Integer num3 = dVar.i;
            if (num3 != null) {
                int intValue2 = num3.intValue();
                TextView textView5 = this.f7028z;
                if (textView5 != null) {
                    textView5.setTextColor(intValue2);
                }
            }
            Integer num4 = dVar.f5504o;
            if (num4 != null) {
                int intValue3 = num4.intValue();
                Button button3 = this.A;
                if (button3 != null) {
                    button3.setBackgroundColor(intValue3);
                }
            }
            Integer num5 = dVar.f5502m;
            if (num5 != null) {
                int intValue4 = num5.intValue();
                Button button4 = this.A;
                if (button4 != null) {
                    button4.setTextColor(intValue4);
                }
            }
        }
        t1.f(this.f8504u, this.A);
        t1.f(this.v, this.f7028z);
    }

    @Override // c.b
    public final void e(c.i iVar) {
    }

    @Override // c.b
    public final void f(c.i iVar) {
    }
}
