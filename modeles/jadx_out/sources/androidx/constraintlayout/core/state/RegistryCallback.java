package androidx.constraintlayout.core.state;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface RegistryCallback {
    String currentLayoutInformation();

    String currentMotionScene();

    long getLastModified();

    void onDimensions(int i, int i6);

    void onNewMotionScene(String str);

    void onProgress(float f);

    void setDrawDebug(int i);

    void setLayoutInformationMode(int i);
}
