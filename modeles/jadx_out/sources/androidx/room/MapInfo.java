package androidx.room;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public @interface MapInfo {
    String keyColumn() default "";

    String keyTable() default "";

    String valueColumn() default "";

    String valueTable() default "";
}
