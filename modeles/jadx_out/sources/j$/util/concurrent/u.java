package j$.util.concurrent;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class u extends ThreadLocal {
    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        return new ThreadLocalRandom(0);
    }
}
