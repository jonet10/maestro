package j$.util;

import java.security.AccessController;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class v1 {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f6472a = ((Boolean) AccessController.doPrivileged(new u1(0))).booleanValue();

    public static void a(Class cls, String str) {
        throw new UnsupportedOperationException(cls + " tripwire tripped but logging not supported: " + str);
    }
}
