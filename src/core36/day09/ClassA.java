package core36.day09;

import java.util.Objects;

public class ClassA {
    public String name;

    public ClassA(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassA classA = (ClassA) o;
        return Objects.equals(name, classA.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
