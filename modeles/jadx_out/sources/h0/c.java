package h0;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class c extends DialogFragment {

    /* renamed from: a, reason: collision with root package name */
    public Dialog f5399a;

    /* renamed from: b, reason: collision with root package name */
    public DialogInterface.OnCancelListener f5400b;

    /* renamed from: l, reason: collision with root package name */
    public AlertDialog f5401l;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f5400b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f5399a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f5401l == null) {
            Activity activity = getActivity();
            y.g(activity);
            this.f5401l = new AlertDialog.Builder(activity).create();
        }
        return this.f5401l;
    }
}
