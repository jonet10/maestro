package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.ItemBridgeAdapter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ItemBridgeAdapterShadowOverlayWrapper extends ItemBridgeAdapter.Wrapper {
    private final ShadowOverlayHelper mHelper;

    public ItemBridgeAdapterShadowOverlayWrapper(ShadowOverlayHelper shadowOverlayHelper) {
        this.mHelper = shadowOverlayHelper;
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.Wrapper
    public View createWrapper(View view) {
        return this.mHelper.createShadowOverlayContainer(view.getContext());
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.Wrapper
    public void wrap(View view, View view2) {
        ((ShadowOverlayContainer) view).wrap(view2);
    }
}
