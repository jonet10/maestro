package k0;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6919a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f6920b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f6921l;

    public /* synthetic */ q(Intent intent, Object obj, int i) {
        this.f6919a = i;
        this.f6920b = intent;
        this.f6921l = obj;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [j0.f, java.lang.Object] */
    public final void a() {
        switch (this.f6919a) {
            case 0:
                Intent intent = this.f6920b;
                if (intent != null) {
                    ((GoogleApiActivity) this.f6921l).startActivityForResult(intent, 2);
                    break;
                }
                break;
            default:
                Intent intent2 = this.f6920b;
                if (intent2 != null) {
                    this.f6921l.a(intent2, 2);
                    break;
                }
                break;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            try {
                a();
            } catch (ActivityNotFoundException e10) {
                Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e10);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
