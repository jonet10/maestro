package j$.util.stream;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class e8 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f6185a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f6186b;

    public e8(Runnable runnable, Runnable runnable2) {
        this.f6185a = runnable;
        this.f6186b = runnable2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f6185a.run();
            this.f6186b.run();
        } catch (Throwable th) {
            try {
                this.f6186b.run();
            } catch (Throwable th2) {
                try {
                    th.addSuppressed(th2);
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }
}
