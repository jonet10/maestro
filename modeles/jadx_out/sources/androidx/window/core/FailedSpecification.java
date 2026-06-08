package androidx.window.core;

import a.a;
import a4.x;
import androidx.window.core.SpecificationComputer;
import d7.l;
import java.util.ArrayList;
import java.util.Collection;
import q6.j;
import q6.t;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class FailedSpecification<T> extends SpecificationComputer<T> {
    private final WindowStrictModeException exception;
    private final Logger logger;
    private final String message;
    private final String tag;
    private final T value;
    private final SpecificationComputer.VerificationMode verificationMode;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpecificationComputer.VerificationMode.values().length];
            iArr[SpecificationComputer.VerificationMode.STRICT.ordinal()] = 1;
            iArr[SpecificationComputer.VerificationMode.LOG.ordinal()] = 2;
            iArr[SpecificationComputer.VerificationMode.QUIET.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FailedSpecification(T t9, String str, String str2, Logger logger, SpecificationComputer.VerificationMode verificationMode) {
        Collection collection;
        t9.getClass();
        str.getClass();
        str2.getClass();
        logger.getClass();
        verificationMode.getClass();
        this.value = t9;
        this.tag = str;
        this.message = str2;
        this.logger = logger;
        this.verificationMode = verificationMode;
        WindowStrictModeException windowStrictModeException = new WindowStrictModeException(createMessage(t9, str2));
        StackTraceElement[] stackTrace = windowStrictModeException.getStackTrace();
        stackTrace.getClass();
        int length = stackTrace.length - 2;
        length = length < 0 ? 0 : length;
        if (length < 0) {
            o.o(x.g(length, "Requested element count ", " is less than zero."));
            throw null;
        }
        if (length == 0) {
            collection = t.f8724a;
        } else {
            int length2 = stackTrace.length;
            if (length >= length2) {
                collection = j.m0(stackTrace);
            } else if (length == 1) {
                collection = a.H(stackTrace[length2 - 1]);
            } else {
                ArrayList arrayList = new ArrayList(length);
                for (int i = length2 - length; i < length2; i++) {
                    arrayList.add(stackTrace[i]);
                }
                collection = arrayList;
            }
        }
        Object[] array = collection.toArray(new StackTraceElement[0]);
        if (array == null) {
            com.google.gson.internal.a.i("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            throw null;
        }
        windowStrictModeException.setStackTrace((StackTraceElement[]) array);
        this.exception = windowStrictModeException;
    }

    @Override // androidx.window.core.SpecificationComputer
    public T compute() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.verificationMode.ordinal()];
        if (i == 1) {
            throw this.exception;
        }
        if (i == 2) {
            this.logger.debug(this.tag, createMessage(this.value, this.message));
            return null;
        }
        if (i == 3) {
            return null;
        }
        com.google.gson.internal.a.b();
        return null;
    }

    public final WindowStrictModeException getException() {
        return this.exception;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final String getMessage() {
        return this.message;
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
        return this;
    }
}
