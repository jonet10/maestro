package androidx.resourceinspection.annotation;

import androidx.annotation.NonNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public @interface Attribute {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @Target({})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IntMap {
        int mask() default 0;

        @NonNull
        String name();

        int value();
    }

    @NonNull
    IntMap[] intMapping() default {};

    @NonNull
    String value();
}
