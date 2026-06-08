package androidx.window.core;

import d7.l;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class SpecificationComputer<T> {
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public enum VerificationMode {
        STRICT,
        LOG,
        QUIET
    }

    public abstract T compute();

    public final String createMessage(Object obj, String str) {
        obj.getClass();
        str.getClass();
        return str + " value: " + obj;
    }

    public abstract SpecificationComputer<T> require(String str, l lVar);

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public static /* synthetic */ SpecificationComputer startSpecification$default(Companion companion, Object obj, String str, VerificationMode verificationMode, Logger logger, int i, Object obj2) {
            if ((i & 2) != 0) {
                verificationMode = BuildConfig.INSTANCE.getVerificationMode();
            }
            if ((i & 4) != 0) {
                logger = AndroidLogger.INSTANCE;
            }
            return companion.startSpecification(obj, str, verificationMode, logger);
        }

        public final <T> SpecificationComputer<T> startSpecification(T t9, String str, VerificationMode verificationMode, Logger logger) {
            t9.getClass();
            str.getClass();
            verificationMode.getClass();
            logger.getClass();
            return new ValidSpecification(t9, str, verificationMode, logger);
        }

        private Companion() {
        }
    }
}
