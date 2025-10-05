package bootstrap;

import java.util.*;
import java.util.function.*;

public class DIContainer {
    private Map<Class<?>, Supplier<?>> registrations;

    public DIContainer(){
        this.registrations = new HashMap<>();
    }

    <T> void register(Class<T> clazz, Supplier<? extends T> supplier) {
        registrations.put(clazz, supplier);
    }

    public <T> T resolve(Class<T> clazz) {
        Supplier<? extends T> supplier = (Supplier<? extends T>) registrations.get(clazz);
        if (supplier == null)
            throw new RuntimeException("No registration found for " + clazz.getName());
        return supplier.get();
    }
}
