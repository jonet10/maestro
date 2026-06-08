package w8;

import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w extends v {
    public static Long i(FileTime fileTime) {
        long millis = fileTime.toMillis();
        Long valueOf = Long.valueOf(millis);
        if (millis != 0) {
            return valueOf;
        }
        return null;
    }

    @Override // w8.v, w8.o
    public final void a(y yVar, y yVar2) {
        yVar2.getClass();
        try {
            Path path = Paths.get(yVar.f11005a.t(), new String[0]);
            path.getClass();
            Path path2 = Paths.get(yVar2.f11005a.t(), new String[0]);
            path2.getClass();
            Files.move(path, path2, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (UnsupportedOperationException unused) {
            com.google.gson.internal.a.n("atomic move not supported");
        } catch (NoSuchFileException e10) {
            throw new FileNotFoundException(e10.getMessage());
        }
    }

    @Override // w8.v, w8.o
    public final n e(y yVar) {
        yVar.getClass();
        Path path = Paths.get(yVar.f11005a.t(), new String[0]);
        path.getClass();
        try {
            BasicFileAttributes readAttributes = Files.readAttributes(path, (Class<BasicFileAttributes>) BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            Path readSymbolicLink = readAttributes.isSymbolicLink() ? Files.readSymbolicLink(path) : null;
            boolean isRegularFile = readAttributes.isRegularFile();
            boolean isDirectory = readAttributes.isDirectory();
            if (readSymbolicLink != null) {
                String str = y.f11004b;
                q1.a.j(readSymbolicLink.toString(), false);
            }
            Long valueOf = Long.valueOf(readAttributes.size());
            FileTime creationTime = readAttributes.creationTime();
            Long i = creationTime != null ? i(creationTime) : null;
            FileTime lastModifiedTime = readAttributes.lastModifiedTime();
            Long i6 = lastModifiedTime != null ? i(lastModifiedTime) : null;
            FileTime lastAccessTime = readAttributes.lastAccessTime();
            return new n(isRegularFile, isDirectory, valueOf, i, i6, lastAccessTime != null ? i(lastAccessTime) : null);
        } catch (NoSuchFileException | FileSystemException unused) {
            return null;
        }
    }

    @Override // w8.v
    public final String toString() {
        return "NioSystemFileSystem";
    }
}
