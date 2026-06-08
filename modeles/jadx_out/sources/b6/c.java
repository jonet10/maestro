package b6;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.model.ChoiceError;
import com.uptodown.activities.InformationActivity;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1069a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1070b;

    public /* synthetic */ c(Object obj, int i) {
        this.f1069a = i;
        this.f1070b = obj;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        switch (this.f1069a) {
            case 0:
                view.getClass();
                FragmentActivity activity = ((f) this.f1070b).getActivity();
                if (activity == null) {
                    return;
                }
                activity.getSupportFragmentManager().beginTransaction().add(new s5.c(), "e0.a").add(new z5.c(), "h0.c").commit();
                return;
            case 1:
                f fVar = (f) this.f1070b;
                view.getClass();
                try {
                    h hVar = fVar.f1086y;
                    if (hVar == null) {
                        l.i("viewModel");
                        throw null;
                    }
                    if (hVar.h.g.length() > 0) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        h hVar2 = fVar.f1086y;
                        if (hVar2 == null) {
                            l.i("viewModel");
                            throw null;
                        }
                        Uri parse = Uri.parse(hVar2.h.g);
                        parse.getClass();
                        intent.setData(parse);
                        fVar.startActivity(intent);
                        return;
                    }
                    return;
                } catch (ActivityNotFoundException unused) {
                    ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
                    if (callback == null) {
                        return;
                    }
                    callback.onCmpError(ChoiceError.INVALID_URL);
                    return;
                }
            default:
                view.getClass();
                return;
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        switch (this.f1069a) {
            case 2:
                textPaint.getClass();
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor((InformationActivity) this.f1070b, 2131100500));
                textPaint.setTypeface(f4.c.f4882w);
                break;
            default:
                super.updateDrawState(textPaint);
                break;
        }
    }
}
