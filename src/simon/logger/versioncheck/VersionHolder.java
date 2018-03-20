package simon.logger.versioncheck;

import com.sun.istack.internal.NotNull;

public class VersionHolder {
    private final int major;
    private final int minor;
    private final int patch;

    public VersionHolder(int major, int minor, int patch) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
    }

    boolean isSameVersion(int major, int minor, int patch) {
        return ((this.major == major) && (this.minor == minor) && (this.patch == patch));
    }
}
