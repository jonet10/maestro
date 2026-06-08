package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class d implements j7.b, Serializable {
    public static final Object NO_RECEIVER = c.f7016a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient j7.b reflected;
    private final String signature;

    public d(Object obj, Class cls, String str, String str2, boolean z9) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z9;
    }

    @Override // j7.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // j7.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public j7.b compute() {
        j7.b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        j7.b computeReflected = computeReflected();
        this.reflected = computeReflected;
        return computeReflected;
    }

    public abstract j7.b computeReflected();

    @Override // j7.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // j7.b
    public String getName() {
        return this.name;
    }

    public j7.d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (!this.isTopLevel) {
            return y.a(cls);
        }
        y.f7025a.getClass();
        return new p(cls);
    }

    @Override // j7.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public abstract j7.b getReflected();

    @Override // j7.b
    public j7.l getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // j7.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // j7.b
    public j7.m getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // j7.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // j7.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // j7.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // j7.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
