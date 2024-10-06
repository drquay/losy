package utils;

import java.net.URL;
import java.util.Optional;

public class OtherUtil {

    public static Optional<URL> getFileFromResource(Class clazz, String pathToFile) {
        final ClassLoader classLoader = clazz.getClassLoader();
        final URL resource = classLoader.getResource(pathToFile);
        return Optional.ofNullable(resource);
    }
}
