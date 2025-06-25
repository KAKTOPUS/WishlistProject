package exceptions;

public class DriverNotSupportedScreenshotException extends RuntimeException {

    public DriverNotSupportedScreenshotException() {
        super("driver is not supported screenshot");
    }

}
