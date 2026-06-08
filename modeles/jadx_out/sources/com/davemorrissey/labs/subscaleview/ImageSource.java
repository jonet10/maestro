package com.davemorrissey.labs.subscaleview;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.google.gson.internal.a;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ImageSource {
    static final String ASSET_SCHEME = "file:///android_asset/";
    static final String FILE_SCHEME = "file:///";
    private final Bitmap bitmap;
    private boolean cached;
    private final Integer resource;
    private int sHeight;
    private Rect sRegion;
    private int sWidth;
    private boolean tile;
    private final Uri uri;

    private ImageSource(Uri uri) {
        String uri2 = uri.toString();
        if (uri2.startsWith(FILE_SCHEME) && !new File(uri2.substring(7)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(uri2, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        this.bitmap = null;
        this.uri = uri;
        this.resource = null;
        this.tile = true;
    }

    public static ImageSource asset(String str) {
        if (str != null) {
            return uri(ASSET_SCHEME.concat(str));
        }
        a.i("Asset name must not be null");
        return null;
    }

    public static ImageSource bitmap(Bitmap bitmap) {
        if (bitmap != null) {
            return new ImageSource(bitmap, false);
        }
        a.i("Bitmap must not be null");
        return null;
    }

    public static ImageSource cachedBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            return new ImageSource(bitmap, true);
        }
        a.i("Bitmap must not be null");
        return null;
    }

    public static ImageSource resource(int i) {
        return new ImageSource(i);
    }

    private void setInvariants() {
        Rect rect = this.sRegion;
        if (rect != null) {
            this.tile = true;
            this.sWidth = rect.width();
            this.sHeight = this.sRegion.height();
        }
    }

    public static ImageSource uri(String str) {
        if (str == null) {
            a.i("Uri must not be null");
            return null;
        }
        if (!str.contains("://")) {
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            str = FILE_SCHEME.concat(str);
        }
        return new ImageSource(Uri.parse(str));
    }

    public ImageSource dimensions(int i, int i6) {
        if (this.bitmap == null) {
            this.sWidth = i;
            this.sHeight = i6;
        }
        setInvariants();
        return this;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final Integer getResource() {
        return this.resource;
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final Rect getSRegion() {
        return this.sRegion;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final boolean getTile() {
        return this.tile;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final boolean isCached() {
        return this.cached;
    }

    public ImageSource region(Rect rect) {
        this.sRegion = rect;
        setInvariants();
        return this;
    }

    public ImageSource tiling(boolean z9) {
        this.tile = z9;
        return this;
    }

    public ImageSource tilingDisabled() {
        return tiling(false);
    }

    public ImageSource tilingEnabled() {
        return tiling(true);
    }

    public static ImageSource uri(Uri uri) {
        if (uri != null) {
            return new ImageSource(uri);
        }
        a.i("Uri must not be null");
        return null;
    }

    private ImageSource(Bitmap bitmap, boolean z9) {
        this.bitmap = bitmap;
        this.uri = null;
        this.resource = null;
        this.tile = false;
        this.sWidth = bitmap.getWidth();
        this.sHeight = bitmap.getHeight();
        this.cached = z9;
    }

    private ImageSource(int i) {
        this.bitmap = null;
        this.uri = null;
        this.resource = Integer.valueOf(i);
        this.tile = true;
    }
}
