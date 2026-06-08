package androidx.core.graphics;

import android.graphics.Picture;
import d7.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PictureKt {
    public static final Picture record(Picture picture, int i, int i6, l lVar) {
        try {
            lVar.invoke(picture.beginRecording(i, i6));
            return picture;
        } finally {
            picture.endRecording();
        }
    }
}
