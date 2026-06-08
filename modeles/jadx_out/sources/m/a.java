package m;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import h9.d;
import m9.c;
import o6.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class a extends BottomSheetDialogFragment {

    /* renamed from: a, reason: collision with root package name */
    public d f7263a;

    /* renamed from: b, reason: collision with root package name */
    public n9.a f7264b;

    /* renamed from: l, reason: collision with root package name */
    public n9.a f7265l;

    /* renamed from: m, reason: collision with root package name */
    public n9.a f7266m;

    public final void a() {
        FragmentActivity activity;
        if (!isAdded() || (activity = getActivity()) == null) {
            return;
        }
        activity.isFinishing();
    }

    public abstract void b(ViewStub viewStub);

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface.getClass();
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 2132017668);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View inflate = layoutInflater.inflate(2131558445, viewGroup, false);
        inflate.getClass();
        ViewStub viewStub = (ViewStub) inflate.findViewById(2131362047);
        if (viewStub == null) {
            return inflate;
        }
        b(viewStub);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        Resources resources;
        DisplayMetrics displayMetrics;
        super.onResume();
        View view = getView();
        if (view == null) {
            return;
        }
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 == null) {
            return;
        }
        BottomSheetBehavior from = BottomSheetBehavior.from(view2);
        from.getClass();
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return;
        }
        int i = displayMetrics.heightPixels;
        from.setPeekHeight(i);
        ViewStub viewStub = (ViewStub) view2.findViewById(2131362047);
        if (viewStub == null) {
            return;
        }
        viewStub.inflate().setMinimumHeight((int) (i * 0.25d));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        this.f7263a = c.f7860d;
        this.f7264b = e.f8225b;
        this.f7265l = e.f8228e;
        this.f7266m = e.f8227d;
    }
}
