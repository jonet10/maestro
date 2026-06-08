package l5;

import android.graphics.Typeface;
import android.text.Editable;
import android.text.Html;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.uptodown.activities.UsernameEditActivity;
import java.util.ArrayList;
import org.xml.sax.XMLReader;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m implements Html.TagHandler {

    /* renamed from: a, reason: collision with root package name */
    public final UsernameEditActivity f7143a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f7144b = new ArrayList();

    public m(UsernameEditActivity usernameEditActivity) {
        this.f7143a = usernameEditActivity;
    }

    @Override // android.text.Html.TagHandler
    public final void handleTag(boolean z9, String str, Editable editable, XMLReader xMLReader) {
        str.getClass();
        editable.getClass();
        xMLReader.getClass();
        if (str.equalsIgnoreCase("turbo")) {
            ArrayList arrayList = this.f7144b;
            if (z9) {
                arrayList.add(Integer.valueOf(editable.length()));
                return;
            }
            if (arrayList.isEmpty()) {
                return;
            }
            int intValue = ((Number) arrayList.remove(arrayList.size() - 1)).intValue();
            int length = editable.length();
            editable.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.f7143a, 2131100801)), intValue, length, 33);
            if (f4.c.f4882w != null) {
                Typeface typeface = f4.c.f4882w;
                typeface.getClass();
                editable.setSpan(new j5.f(typeface, 1), intValue, length, 33);
            }
        }
    }
}
