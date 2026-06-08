package j$.util;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class g extends RuntimeException {
    public static void a(Object obj, String str) {
        throw new g("Unsupported " + str + " :" + obj);
    }
}
