package exceptions;

public class OddNumberException extends Exception{

}

/*
Only Run time Exception gets inherited from RunTimeException class and Runtime Exception coming from Exception
checked exception are inherited from directly Exception

Exception - run time -> run time are directly inherited from runtime exception and explicitly mention as extends run time exception
            compile time -> compile  time are directly inherited from exception class and mention explicitly as Exception instead of runtime exception
            ofcourse, runtime exception is the child of Exception class. But while writing runtime Exception ->then it means handle it by developer
            if it is checked exception (not mention runtime exception explicitly)-> then, either it(Caller) will handle otherwise called method will throw an exception.

 */
