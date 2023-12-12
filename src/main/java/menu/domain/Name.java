package menu.domain;

import java.util.Objects;

public class Name {

    private final String value;

    public Name(String value) {
        if (value.length() < 2 || value.length() > 4) {
            throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자입니다.");
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(value, name1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
