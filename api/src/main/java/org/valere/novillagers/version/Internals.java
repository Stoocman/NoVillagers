package org.valere.novillagers.version;

import java.util.List;

public class Internals<T> {

    private final List<Class<? extends T>> internals;

    public Internals(List<Class<? extends T>> internals){
        this.internals = internals;
    }

    private static Boolean matchVersion(Class<?> clazz) {
        String name = clazz.getSimpleName();
        String version = clazz.getSimpleName().substring(name.indexOf("_"));
        return version.equals(Version.getVersion());
    }

    public T get(){
        try {
            Class<? extends T> internal = internals.stream().filter(Internals::matchVersion)
                    .findFirst()
                    .orElseThrow(RuntimeException::new);
            return internal.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}