package simon.logger.versioncheck;

public interface IMyServiceUnderVersionChecking {

    void foo();

    @VersionCheck
    void bar();

    @VersionCheck(major = 12, minor = 0, patch = 0)
    void baz();

    @VersionCheck(major = 43, minor = 2, patch = 1)
    void qux();

    @VersionCheck
    void test(int i);
}
