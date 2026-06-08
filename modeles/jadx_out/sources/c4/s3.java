package c4;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s3 extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2073a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f2074b;

    public /* synthetic */ s3(int i, MainActivity mainActivity) {
        this.f2073a = i;
        this.f2074b = mainActivity;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        int i = this.f2073a;
        view.getClass();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        int i = this.f2073a;
        MainActivity mainActivity = this.f2074b;
        textPaint.getClass();
        switch (i) {
            case 0:
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(mainActivity, 2131100500));
                textPaint.setTypeface(f4.c.f4882w);
                textPaint.setUnderlineText(false);
                break;
            default:
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(mainActivity, 2131100802));
                textPaint.setTypeface(f4.c.f4882w);
                textPaint.setUnderlineText(false);
                break;
        }
    }
}
