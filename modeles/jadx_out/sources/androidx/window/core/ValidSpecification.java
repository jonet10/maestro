package androidx.window.core;

import androidx.window.core.SpecificationComputer;
import d7.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class ValidSpecification<T> extends SpecificationComputer<T> {
    private final Logger logger;
    private final String tag;
    private final T value;
    private final SpecificationComputer.VerificationMode verificationMode;

    public ValidSpecification(T t9, String str, SpecificationComputer.VerificationMode verificationMode, Logger logger) {
        t9.getClass();
        str.getClass();
        verificationMode.getClass();
        logger.getClass();
        this.value = t9;
        this.tag = str;
        this.verificationMode = verificationMode;
        this.logger = logger;
    }

    @Override // androidx.window.core.SpecificationComputer
    public T compute() {
        return this.value;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final String getTag() {
        return this.tag;
    }

    public final T getValue() {
        return this.value;
    }

    public final SpecificationComputer.VerificationMode getVerificationMode() {
        return this.verificationMode;
    }

    @Override // androidx.window.core.SpecificationComputer
    public SpecificationComputer<T> require(String str, l lVar) {
        str.getClass();
        lVar.getClass();
        return ((Boolean) lVar.invoke(this.value)).booleanValue() ? this : new FailedSpecification(this.value, this.tag, str, this.logger, this.verificationMode);
    }
}
