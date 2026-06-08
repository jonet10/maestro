package a4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t extends b {
    public i h;

    @Override // a4.b
    public final void a() {
        this.g = true;
        if (this.h != null) {
            this.h = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a4.b
    public final void b(Bitmap bitmap, int i) {
        if (bitmap == null) {
            throw new AssertionError("Attempted to complete action with no result!\n" + this);
        }
        ImageView imageView = (ImageView) this.f70c.get();
        if (imageView == null) {
            return;
        }
        Context context = this.f68a.f97c;
        int i6 = h0.f116e;
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        imageView.setImageDrawable(new h0(context, bitmap, drawable, i));
        i iVar = this.h;
        if (iVar != null) {
            iVar.onSuccess();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a4.b
    public final void c(Exception exc) {
        ImageView imageView = (ImageView) this.f70c.get();
        if (imageView == null) {
            return;
        }
        Object drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        i iVar = this.h;
        if (iVar != null) {
            iVar.h(exc);
        }
    }
}
