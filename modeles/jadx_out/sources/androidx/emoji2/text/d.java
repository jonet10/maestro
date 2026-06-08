package androidx.emoji2.text;

import androidx.emoji2.text.FontRequestEmojiCompatConfig;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f416a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FontRequestEmojiCompatConfig.FontRequestMetadataLoader f417b;

    public /* synthetic */ d(FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader, int i) {
        this.f416a = i;
        this.f417b = fontRequestMetadataLoader;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f416a) {
            case 0:
                this.f417b.createMetadata();
                break;
            default:
                this.f417b.loadInternal();
                break;
        }
    }
}
