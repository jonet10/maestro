package j$.util.stream;

import j$.util.Spliterator;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class l extends i5 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6269b = 2;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6270c;

    /* renamed from: d, reason: collision with root package name */
    public Object f6271d;

    public /* synthetic */ l(m5 m5Var) {
        super(m5Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(i8 i8Var, m5 m5Var) {
        super(m5Var);
        this.f6271d = i8Var;
        this.f6270c = true;
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public final void c(long j) {
        switch (this.f6269b) {
            case 0:
                this.f6270c = false;
                this.f6271d = null;
                this.f6224a.c(-1L);
                break;
            case 1:
                this.f6224a.c(-1L);
                break;
            default:
                this.f6224a.c(-1L);
                break;
        }
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final void n(Object obj) {
        switch (this.f6269b) {
            case 0:
                m5 m5Var = this.f6224a;
                if (obj == null) {
                    if (this.f6270c) {
                        return;
                    }
                    this.f6270c = true;
                    this.f6271d = null;
                    m5Var.n((m5) null);
                    return;
                }
                Object obj2 = this.f6271d;
                if (obj2 == null || !obj.equals(obj2)) {
                    this.f6271d = obj;
                    m5Var.n((m5) obj);
                    return;
                }
                return;
            case 1:
                Stream stream = (Stream) ((j$.util.q) ((r) this.f6271d).f6336m).apply((j$.util.q) obj);
                if (stream != null) {
                    try {
                        boolean z9 = this.f6270c;
                        m5 m5Var2 = this.f6224a;
                        if (!z9) {
                            ((Stream) stream.sequential()).forEach(m5Var2);
                        } else {
                            Spliterator spliterator = ((Stream) stream.sequential()).spliterator();
                            while (!m5Var2.e() && spliterator.tryAdvance(m5Var2)) {
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            stream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (stream != null) {
                    stream.close();
                    return;
                }
                return;
            default:
                if (this.f6270c) {
                    boolean test = ((i8) this.f6271d).f6231m.test(obj);
                    this.f6270c = test;
                    if (test) {
                        this.f6224a.n((m5) obj);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public boolean e() {
        switch (this.f6269b) {
            case 1:
                this.f6270c = true;
                return this.f6224a.e();
            case 2:
                return !this.f6270c || this.f6224a.e();
            default:
                return super.e();
        }
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public void end() {
        switch (this.f6269b) {
            case 0:
                this.f6270c = false;
                this.f6271d = null;
                this.f6224a.end();
                break;
            default:
                super.end();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(r rVar, m5 m5Var) {
        super(m5Var);
        this.f6271d = rVar;
    }
}
