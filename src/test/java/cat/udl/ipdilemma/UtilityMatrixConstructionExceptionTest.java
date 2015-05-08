package cat.udl.ipdilemma;

import org.junit.Test;

public class UtilityMatrixConstructionExceptionTest {

    @Test(expected = IllegalArgumentException.class)
    public void test_T_less_than_or_equals_R_exception() {
        UtilityMatrix umatrix = new UtilityMatrix(5, 5, 1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_R_less_than_or_equals_P_exception() {
        UtilityMatrix umatrix = new UtilityMatrix(5, 4, 4, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_P_less_than_or_equals_S_exception() {
        UtilityMatrix umatrix = new UtilityMatrix(5, 4, 3, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_R_less_than_or_equals_T_plus_S_div_2() {
        UtilityMatrix umatrix = new UtilityMatrix(5, 3, 2, 1);
    }

}
