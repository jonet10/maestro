package androidx.room.support;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PrePackagedCopyOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final String copyFromAssetPath;
    private final File copyFromFile;
    private final Callable<InputStream> copyFromInputStream;
    private final SupportSQLiteOpenHelper.Factory delegate;

    public PrePackagedCopyOpenHelperFactory(String str, File file, Callable<InputStream> callable, SupportSQLiteOpenHelper.Factory factory) {
        factory.getClass();
        this.copyFromAssetPath = str;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.delegate = factory;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        configuration.getClass();
        return new PrePackagedCopyOpenHelper(configuration.context, this.copyFromAssetPath, this.copyFromFile, this.copyFromInputStream, configuration.callback.version, this.delegate.create(configuration));
    }
}
