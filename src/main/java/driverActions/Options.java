package driverActions;

import java.time.Duration;

public interface Options {
    void setImplicitTimeout(Duration duration);
    void maximizeWindow();
}
