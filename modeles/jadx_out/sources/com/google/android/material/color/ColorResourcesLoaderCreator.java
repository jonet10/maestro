package com.google.android.material.color;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import android.content.res.loader.ResourcesProvider;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
final class ColorResourcesLoaderCreator {
    private static final String TAG = "ColorResLoaderCreator";

    private ColorResourcesLoaderCreator() {
    }

    @Nullable
    public static ResourcesLoader create(@NonNull Context context, @NonNull Map<Integer, Integer> map) {
        FileDescriptor fileDescriptor;
        try {
            byte[] create = ColorResourcesTableCreator.create(context, map);
            Log.i(TAG, "Table created, length: " + create.length);
            if (create.length != 0) {
                try {
                    fileDescriptor = Os.memfd_create("temp.arsc", 0);
                    try {
                        if (fileDescriptor != null) {
                            FileOutputStream fileOutputStream = new FileOutputStream(fileDescriptor);
                            try {
                                fileOutputStream.write(create);
                                ParcelFileDescriptor dup = ParcelFileDescriptor.dup(fileDescriptor);
                                try {
                                    ResourcesLoader resourcesLoader = new ResourcesLoader();
                                    resourcesLoader.addProvider(ResourcesProvider.loadFromTable(dup, null));
                                    if (dup != null) {
                                        dup.close();
                                    }
                                    fileOutputStream.close();
                                    Os.close(fileDescriptor);
                                    return resourcesLoader;
                                } finally {
                                }
                            } finally {
                            }
                        }
                        Log.w(TAG, "Cannot create memory file descriptor.");
                        if (fileDescriptor != null) {
                            Os.close(fileDescriptor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileDescriptor != null) {
                            Os.close(fileDescriptor);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileDescriptor = null;
                }
            }
            return null;
        } catch (Exception e10) {
            Log.e(TAG, "Failed to create the ColorResourcesTableCreator.", e10);
            return null;
        }
    }
}
