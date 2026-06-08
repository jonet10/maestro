package kotlin.jvm.internal;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class j extends d implements i, j7.e {
    private final int arity;
    private final int flags;

    public j(int i, Object obj, Class cls, String str, String str2, int i6) {
        super(obj, cls, str, str2, (i6 & 1) == 1);
        this.arity = i;
        this.flags = 0;
    }

    @Override // kotlin.jvm.internal.d
    public j7.b computeReflected() {
        y.f7025a.getClass();
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            return getName().equals(jVar.getName()) && getSignature().equals(jVar.getSignature()) && this.flags == jVar.flags && this.arity == jVar.arity && l.a(getBoundReceiver(), jVar.getBoundReceiver()) && l.a(getOwner(), jVar.getOwner());
        }
        if (obj instanceof j7.e) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.i
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.jvm.internal.d
    public j7.e getReflected() {
        j7.b compute = compute();
        if (compute != this) {
            return (j7.e) compute;
        }
        throw new c7.a("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    @Override // j7.e
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // j7.e
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // j7.e
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // j7.e
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.d, j7.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        j7.b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }
}
