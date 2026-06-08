package j$.util.stream;

import java.security.AccessController;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class h8 {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f6218a = ((Boolean) AccessController.doPrivileged(new j$.util.u1(2))).booleanValue();

    public static void a(Class cls, String str) {
        throw new UnsupportedOperationException(cls + " tripwire tripped but logging not supported: " + str);
    }
}
