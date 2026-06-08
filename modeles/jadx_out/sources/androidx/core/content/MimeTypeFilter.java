package androidx.core.content;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MimeTypeFilter {
    private MimeTypeFilter() {
    }

    @Nullable
    public static String matches(@Nullable String str, @NonNull String[] strArr) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("/");
        for (String str2 : strArr) {
            if (mimeTypeAgainstFilter(split, str2.split("/"))) {
                return str2;
            }
        }
        return null;
    }

    @NonNull
    public static String[] matchesMany(@Nullable String[] strArr, @NonNull String str) {
        if (strArr == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        String[] split = str.split("/");
        for (String str2 : strArr) {
            if (mimeTypeAgainstFilter(str2.split("/"), split)) {
                arrayList.add(str2);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static boolean mimeTypeAgainstFilter(@NonNull String[] strArr, @NonNull String[] strArr2) {
        if (strArr2.length != 2) {
            com.google.gson.internal.a.p("Ill-formatted MIME type filter. Must be type/subtype.");
            return false;
        }
        if (strArr2[0].isEmpty() || strArr2[1].isEmpty()) {
            com.google.gson.internal.a.p("Ill-formatted MIME type filter. Type or subtype empty.");
            return false;
        }
        if (strArr.length != 2) {
            return false;
        }
        if ("*".equals(strArr2[0]) || strArr2[0].equals(strArr[0])) {
            return "*".equals(strArr2[1]) || strArr2[1].equals(strArr[1]);
        }
        return false;
    }

    public static boolean matches(@Nullable String str, @NonNull String str2) {
        if (str == null) {
            return false;
        }
        return mimeTypeAgainstFilter(str.split("/"), str2.split("/"));
    }

    @Nullable
    public static String matches(@Nullable String[] strArr, @NonNull String str) {
        if (strArr == null) {
            return null;
        }
        String[] split = str.split("/");
        for (String str2 : strArr) {
            if (mimeTypeAgainstFilter(str2.split("/"), split)) {
                return str2;
            }
        }
        return null;
    }
}
