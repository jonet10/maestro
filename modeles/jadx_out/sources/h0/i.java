package h0;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class i extends DialogFragment {

    /* renamed from: a, reason: collision with root package name */
    public Dialog f5418a;

    /* renamed from: b, reason: collision with root package name */
    public DialogInterface.OnCancelListener f5419b;

    /* renamed from: l, reason: collision with root package name */
    public AlertDialog f5420l;

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f5419b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f5418a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f5420l == null) {
            Context context = getContext();
            y.g(context);
            this.f5420l = new AlertDialog.Builder(context).create();
        }
        return this.f5420l;
    }
}
