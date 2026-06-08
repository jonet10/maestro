package c4;

import android.text.Editable;
import android.text.TextWatcher;
import com.uptodown.activities.UsernameEditActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class cd implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1486a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UsernameEditActivity f1487b;

    public /* synthetic */ cd(UsernameEditActivity usernameEditActivity, int i) {
        this.f1486a = i;
        this.f1487b = usernameEditActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        int i = this.f1486a;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i6, int i10) {
        int i11 = this.f1486a;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i6, int i10) {
        int i11 = this.f1486a;
        UsernameEditActivity usernameEditActivity = this.f1487b;
        switch (i11) {
            case 0:
                int i12 = UsernameEditActivity.R;
                usernameEditActivity.y0().F.setText(charSequence);
                usernameEditActivity.y0().G.setText(charSequence);
                usernameEditActivity.y0().H.setText(charSequence);
                usernameEditActivity.y0().I.setText(charSequence);
                break;
            default:
                if (charSequence != null) {
                    String obj = charSequence.toString();
                    int i13 = UsernameEditActivity.R;
                    usernameEditActivity.z0(obj);
                    break;
                }
                break;
        }
    }

    private final void a(Editable editable) {
    }

    private final void b(Editable editable) {
    }

    private final void c(CharSequence charSequence, int i, int i6, int i10) {
    }

    private final void d(CharSequence charSequence, int i, int i6, int i10) {
    }
}
