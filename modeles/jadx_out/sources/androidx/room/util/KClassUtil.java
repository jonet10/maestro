package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.customaudience.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class KClassUtil {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <T, C> T findAndInstantiateDatabaseImpl(Class<C> cls, String str) {
        String str2;
        String str3;
        cls.getClass();
        str.getClass();
        Package r02 = cls.getPackage();
        if (r02 == null || (str2 = r02.getName()) == null) {
            str2 = "";
        }
        String canonicalName = cls.getCanonicalName();
        canonicalName.getClass();
        if (str2.length() != 0) {
            canonicalName = canonicalName.substring(str2.length() + 1);
        }
        StringBuilder sb = new StringBuilder();
        String replace = canonicalName.replace('.', '_');
        replace.getClass();
        sb.append(replace);
        sb.append(str);
        String sb2 = sb.toString();
        try {
            if (str2.length() == 0) {
                str3 = sb2;
            } else {
                str3 = str2 + '.' + sb2;
            }
            Class<?> cls2 = Class.forName(str3, true, cls.getClassLoader());
            cls2.getClass();
            return (T) cls2.getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("Cannot find implementation for " + cls.getCanonicalName() + ". " + sb2 + " does not exist. Is Room annotation processor correctly configured?", e10);
        } catch (IllegalAccessException e11) {
            a.l("Cannot access the constructor ", cls.getCanonicalName(), e11);
            return null;
        } catch (InstantiationException e12) {
            a.l("Failed to create an instance of ", cls.getCanonicalName(), e12);
            return null;
        }
    }

    public static /* synthetic */ Object findAndInstantiateDatabaseImpl$default(Class cls, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "_Impl";
        }
        return findAndInstantiateDatabaseImpl(cls, str);
    }
}
