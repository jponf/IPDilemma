package cat.udl.ipdilemma;

import org.junit.Test;

public class UtilityMatrixConstructionExceptionTest {


    /**
     * Flow Control Test: Exception situation because T isn't bigger than R.
     * The utility matrix has to comply two conditions:
     *    1. (T > R > P > S)
     *    2. (R > (T+S)/2)
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_T_less_than_or_equals_R_exception() {
        UtilityMatrix umatrix = new UtilityMatrix(5, 5, 1, 0);
    }

    /**
     * Flow Control Test: Exception situation because R isn't bigger than P.
     * The utility matrix has to comply two conditions:
     *    1. (T > R > P > S)
     *    2. (R > (T+S)/2)
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_R_less_than_or_equals_P_exception() {
        UtilityMatrix umatrix = new UtilityMatrix(5, 4, 4, 0);
    }

    /**
     * Flow Control Test: Exception situation because P isn't bigger than S.
     * The utility matrix has to comply two conditions:
     *    1. (T > R > P > S)
     *    2. (R > (T+S)/2)
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_P_less_than_or_equals_S_exception() {
        UtilityMatrix umatrix = new UtilityMatrix(5, 4, 3, 3);
    }

    /**
     * Flow Control Test: Exception situation because R isn't bigger than average of T and S.
     * The utility matrix has to comply two conditions:
     *    1. (T > R > P > S)
     *    2. (R > (T+S)/2)
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_R_less_than_or_equals_T_plus_S_div_2() {
        UtilityMatrix umatrix = new UtilityMatrix(5, 3, 2, 1);
    }

}
