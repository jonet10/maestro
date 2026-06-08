package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.text.Html;
import android.text.SpannableString;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class j4 {

    /* renamed from: a, reason: collision with root package name */
    public static volatile k1.b f2668a;

    public static SpannableString a(String str) {
        return Build.VERSION.SDK_INT >= 24 ? new SpannableString(Html.fromHtml(str, 0)) : new SpannableString(Html.fromHtml(str));
    }

    public static n4.a b(Context context, Locale locale) {
        Context createConfigurationContext;
        context.getClass();
        Configuration configuration = context.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            configuration.setLocale(locale);
            LocaleList localeList = new LocaleList(locale);
            LocaleList.setDefault(localeList);
            configuration.setLocales(localeList);
            createConfigurationContext = context.createConfigurationContext(configuration);
            createConfigurationContext.getClass();
        } else {
            configuration.setLocale(locale);
            createConfigurationContext = context.createConfigurationContext(configuration);
            createConfigurationContext.getClass();
        }
        return new n4.a(createConfigurationContext);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:8|(4:10|(1:12)|13|14)|15|(4:17|(1:19)|13|14)|20|(1:89)(1:24)|25|26|27|28|29|30|31|(1:33)(1:81)|34|(9:36|37|38|39|40|(2:41|(3:43|(3:58|59|60)(7:45|46|(2:48|(1:51))|52|(1:54)|55|56)|57)(1:61))|62|63|64)(1:80)|65|14) */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0075, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0076, code lost:
    
        android.util.Log.e("HermeticFileOverrides", "no data dir", r0);
        r5 = k1.a.f6940a;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static k1.b c(android.content.Context r16) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.j4.c(android.content.Context):k1.b");
    }
}
