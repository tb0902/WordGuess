// Trey Bruton

package com.github.zipcodewilmington.sample;

public interface PersonInterface {
    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    Integer getAge();

    void setAge(Integer age);

    @Override
    String toString();
}
