package androidx.emoji2.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@AnyThread
@RequiresApi(19)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MetadataRepo {
    private static final int DEFAULT_ROOT_SIZE = 1024;
    private static final String S_TRACE_CREATE_REPO = "EmojiCompat.MetadataRepo.create";

    @NonNull
    private final char[] mEmojiCharArray;

    @NonNull
    private final MetadataList mMetadataList;

    @NonNull
    private final Node mRootNode = new Node(1024);

    @NonNull
    private final Typeface mTypeface;

    private MetadataRepo(@NonNull Typeface typeface, @NonNull MetadataList metadataList) {
        this.mTypeface = typeface;
        this.mMetadataList = metadataList;
        this.mEmojiCharArray = new char[metadataList.listLength() * 2];
        constructIndex(metadataList);
    }

    private void constructIndex(MetadataList metadataList) {
        int listLength = metadataList.listLength();
        for (int i = 0; i < listLength; i++) {
            TypefaceEmojiRasterizer typefaceEmojiRasterizer = new TypefaceEmojiRasterizer(this, i);
            Character.toChars(typefaceEmojiRasterizer.getId(), this.mEmojiCharArray, i * 2);
            put(typefaceEmojiRasterizer);
        }
    }

    @NonNull
    public static MetadataRepo create(@NonNull AssetManager assetManager, @NonNull String str) throws IOException {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            return new MetadataRepo(Typeface.createFromAsset(assetManager, str), MetadataListReader.read(assetManager, str));
        } finally {
            TraceCompat.endSection();
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public char[] getEmojiCharArray() {
        return this.mEmojiCharArray;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public MetadataList getMetadataList() {
        return this.mMetadataList;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getMetadataVersion() {
        return this.mMetadataList.version();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Node getRootNode() {
        return this.mRootNode;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Typeface getTypeface() {
        return this.mTypeface;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public void put(@NonNull TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        Preconditions.checkNotNull(typefaceEmojiRasterizer, "emoji metadata cannot be null");
        Preconditions.checkArgument(typefaceEmojiRasterizer.getCodepointsLength() > 0, "invalid metadata codepoint length");
        this.mRootNode.put(typefaceEmojiRasterizer, 0, typefaceEmojiRasterizer.getCodepointsLength() - 1);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class Node {
        private final SparseArray<Node> mChildren;
        private TypefaceEmojiRasterizer mData;

        public Node(int i) {
            this.mChildren = new SparseArray<>(i);
        }

        public Node get(int i) {
            SparseArray<Node> sparseArray = this.mChildren;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i);
        }

        public final TypefaceEmojiRasterizer getData() {
            return this.mData;
        }

        public void put(@NonNull TypefaceEmojiRasterizer typefaceEmojiRasterizer, int i, int i6) {
            Node node = get(typefaceEmojiRasterizer.getCodepointAt(i));
            if (node == null) {
                node = new Node();
                this.mChildren.put(typefaceEmojiRasterizer.getCodepointAt(i), node);
            }
            if (i6 > i) {
                node.put(typefaceEmojiRasterizer, i + 1, i6);
            } else {
                node.mData = typefaceEmojiRasterizer;
            }
        }

        private Node() {
            this(1);
        }
    }

    @NonNull
    public static MetadataRepo create(@NonNull Typeface typeface, @NonNull InputStream inputStream) throws IOException {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            return new MetadataRepo(typeface, MetadataListReader.read(inputStream));
        } finally {
            TraceCompat.endSection();
        }
    }

    @NonNull
    public static MetadataRepo create(@NonNull Typeface typeface, @NonNull ByteBuffer byteBuffer) throws IOException {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            return new MetadataRepo(typeface, MetadataListReader.read(byteBuffer));
        } finally {
            TraceCompat.endSection();
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static MetadataRepo create(@NonNull Typeface typeface) {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            return new MetadataRepo(typeface, new MetadataList());
        } finally {
            TraceCompat.endSection();
        }
    }
}
