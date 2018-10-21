package sample.environment.base;

public class IntegerOperation {



    public static IntHolder swap(int A, int B) {
        A = A ^ B;
        B = B ^ A;
        A = A ^ B;
        return new IntHolder(A, B);
    }
}
