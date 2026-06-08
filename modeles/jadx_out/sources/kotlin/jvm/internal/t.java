package kotlin.jvm.internal;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class t extends d implements j7.k {
    private final boolean syntheticJavaProperty;

    public t(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.syntheticJavaProperty = false;
    }

    @Override // kotlin.jvm.internal.d
    public j7.b compute() {
        return this.syntheticJavaProperty ? this : super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            return getOwner().equals(tVar.getOwner()) && getName().equals(tVar.getName()) && getSignature().equals(tVar.getSignature()) && l.a(getBoundReceiver(), tVar.getBoundReceiver());
        }
        if (obj instanceof j7.k) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.d
    public j7.k getReflected() {
        if (this.syntheticJavaProperty) {
            a3.b.r("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
            return null;
        }
        j7.b compute = compute();
        if (compute != this) {
            return (j7.k) compute;
        }
        throw new c7.a("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    @Override // j7.k
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // j7.k
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        j7.b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
