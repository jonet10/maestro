package k0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.ConfigurationCompat;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final SimpleArrayMap f6917a = new SimpleArrayMap();

    /* renamed from: b, reason: collision with root package name */
    public static Locale f6918b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            Context context2 = r0.c.a(context).f8855a;
            return context2.getPackageManager().getApplicationLabel(context2.getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context, int i) {
        Resources resources = context.getResources();
        String a8 = a(context);
        if (i == 1) {
            return resources.getString(2131951803, a8);
        }
        if (i == 2) {
            return p0.b.c(context) ? resources.getString(2131951813) : resources.getString(2131951810, a8);
        }
        if (i == 3) {
            return resources.getString(2131951800, a8);
        }
        if (i == 5) {
            return d(context, "common_google_play_services_invalid_account_text", a8);
        }
        if (i == 7) {
            return d(context, "common_google_play_services_network_error_text", a8);
        }
        if (i == 9) {
            return resources.getString(2131951808, a8);
        }
        if (i == 20) {
            return d(context, "common_google_play_services_restricted_profile_text", a8);
        }
        switch (i) {
            case 16:
                return d(context, "common_google_play_services_api_unavailable_text", a8);
            case 17:
                return d(context, "common_google_play_services_sign_in_failed_text", a8);
            case 18:
                return resources.getString(2131951812, a8);
            default:
                return resources.getString(2131951807, a8);
        }
    }

    public static String c(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(2131951804);
            case 2:
                return resources.getString(2131951811);
            case 3:
                return resources.getString(2131951801);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return e(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return e(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return e(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return e(context, "common_google_play_services_restricted_profile_title");
        }
    }

    public static String d(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String e10 = e(context, str);
        if (e10 == null) {
            e10 = resources.getString(2131951807);
        }
        return String.format(resources.getConfiguration().locale, e10, str2);
    }

    public static String e(Context context, String str) {
        Resources resources;
        SimpleArrayMap simpleArrayMap = f6917a;
        synchronized (simpleArrayMap) {
            try {
                Locale locale = ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0);
                if (!locale.equals(f6918b)) {
                    simpleArrayMap.clear();
                    f6918b = locale;
                }
                String str2 = (String) simpleArrayMap.get(str);
                if (str2 != null) {
                    return str2;
                }
                AtomicBoolean atomicBoolean = h0.g.f5410a;
                try {
                    resources = context.getPackageManager().getResourcesForApplication("com.google.android.gms");
                } catch (PackageManager.NameNotFoundException unused) {
                    resources = null;
                }
                if (resources != null) {
                    int identifier = resources.getIdentifier(str, TypedValues.Custom.S_STRING, "com.google.android.gms");
                    if (identifier == 0) {
                        Log.w("GoogleApiAvailability", "Missing resource: ".concat(str));
                    } else {
                        String string = resources.getString(identifier);
                        if (!TextUtils.isEmpty(string)) {
                            f6917a.put(str, string);
                            return string;
                        }
                        Log.w("GoogleApiAvailability", "Got empty resource: ".concat(str));
                    }
                }
                return null;
            } finally {
            }
        }
    }
}
