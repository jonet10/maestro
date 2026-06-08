package androidx.work;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class InputMergerKt {
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("InputMerger");
        tagWithPrefix.getClass();
        TAG = tagWithPrefix;
    }

    public static final InputMerger fromClassName(String str) {
        str.getClass();
        try {
            Object newInstance = Class.forName(str).getDeclaredConstructor(null).newInstance(null);
            newInstance.getClass();
            return (InputMerger) newInstance;
        } catch (Exception e10) {
            Logger.get().error(TAG, "Trouble instantiating ".concat(str), e10);
            return null;
        }
    }
}
