package j$.util;

import java.security.PrivilegedAction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class u1 implements PrivilegedAction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6471a;

    @Override // java.security.PrivilegedAction
    public final Object run() {
        switch (this.f6471a) {
            case 0:
                return Boolean.valueOf(Boolean.getBoolean("org.openjdk.java.util.stream.tripwire"));
            case 1:
                return Boolean.valueOf(Boolean.getBoolean("java.util.secureRandomSeed"));
            default:
                return Boolean.valueOf(Boolean.getBoolean("org.openjdk.java.util.stream.tripwire"));
        }
    }
}
