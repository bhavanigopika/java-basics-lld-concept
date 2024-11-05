package prototype;

public interface Prototype<T> {
    //return type would be Generic so that no compile time issue occur...
    // If we call object, it will not do compile time check, so use Generic data type T -> so make it as public interface Prototype<T>
    T clone();
}
