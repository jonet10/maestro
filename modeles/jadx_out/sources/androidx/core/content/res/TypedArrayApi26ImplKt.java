package androidx.core.content.res;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(26)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class TypedArrayApi26ImplKt {
    public static final TypedArrayApi26ImplKt INSTANCE = new TypedArrayApi26ImplKt();

    private TypedArrayApi26ImplKt() {
    }

    @DoNotInline
    public static final Typeface getFont(TypedArray typedArray, @StyleableRes int i) {
        Typeface font = typedArray.getFont(i);
        font.getClass();
        return font;
    }
}
