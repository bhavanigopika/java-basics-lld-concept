package designPattern.prototype;

public interface Prototype<T> {
    //clone is copy method...Return type is generic type not Student type because
    //tmrw, a class says that it want to implement prototype, then it implement prototype interface with its own return type.
    T clone();

}
