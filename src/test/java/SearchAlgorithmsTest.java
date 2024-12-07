import com.search.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchAlgorithmsTest {

    @Test
    public void testLinearSearch() {
        int[] array = {10, 20, 30, 40, 50};
        assertEquals(2, LinearSearch.search(array, 30));
        assertEquals(-1, LinearSearch.search(array, 35));
    }

    @Test
    public void testBinarySearch() {
        int[] array = {10, 20, 30, 40, 50};
        assertEquals(2, BinarySearch.search(array, 30));
        assertEquals(-1, BinarySearch.search(array, 35));
    }

    @Test
    public void testJumpSearch() {
        int[] array = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        assertEquals(10, JumpSearch.search(array, 55));
        assertEquals(-1, JumpSearch.search(array, 56));
    }

    @Test
    public void testExponentialSearch() {
        int[] array = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        assertEquals(10, ExponentialSearch.search(array, 55));
        assertEquals(-1, ExponentialSearch.search(array, 56));
    }

    @Test
    public void testInterpolationSearch() {
        int[] array = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47};
        assertEquals(4, InterpolationSearch.search(array, 18));
        assertEquals(-1, InterpolationSearch.search(array, 180));
    }
}
