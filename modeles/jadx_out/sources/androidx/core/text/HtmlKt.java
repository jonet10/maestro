package androidx.core.text;

import android.text.Html;
import android.text.Spanned;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class HtmlKt {
    public static final Spanned parseAsHtml(String str, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        return HtmlCompat.fromHtml(str, i, imageGetter, tagHandler);
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String str, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = 0;
        }
        if ((i6 & 2) != 0) {
            imageGetter = null;
        }
        if ((i6 & 4) != 0) {
            tagHandler = null;
        }
        return HtmlCompat.fromHtml(str, i, imageGetter, tagHandler);
    }

    public static final String toHtml(Spanned spanned, int i) {
        return HtmlCompat.toHtml(spanned, i);
    }

    public static /* synthetic */ String toHtml$default(Spanned spanned, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = 0;
        }
        return HtmlCompat.toHtml(spanned, i);
    }
}
