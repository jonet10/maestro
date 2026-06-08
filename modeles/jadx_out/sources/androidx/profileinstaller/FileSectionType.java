package androidx.profileinstaller;

import a4.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
enum FileSectionType {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);

    private final long mValue;

    FileSectionType(long j) {
        this.mValue = j;
    }

    public static FileSectionType fromValue(long j) {
        FileSectionType[] values = values();
        for (int i = 0; i < values.length; i++) {
            if (values[i].getValue() == j) {
                return values[i];
            }
        }
        com.google.gson.internal.a.p(x.h(j, "Unsupported FileSection Type "));
        return null;
    }

    public long getValue() {
        return this.mValue;
    }
}
