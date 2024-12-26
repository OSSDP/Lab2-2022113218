import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 测试用例设计总体原则：
 * 1. 等价类划分：将输入分为可以二分和无法二分的两大类，分别测试。
 * 2. 边界值分析：测试最小人数、最大人数和极限输入。
 * 3. 特殊输入：无不喜欢关系、环形不喜欢关系。
 */
public class L2022113218_9_Test {

    /**
     * 测试目的：
     * 验证在存在可行的二分方案时，函数是否正确返回 true。
     *
     * 测试用例：
     * 输入：n = 4, dislikes = {{1, 2}, {1, 3}, {2, 4}}
     * 期望输出：true
     */
    @Test
    public void testPossibleBipartition_True() {
        Solution9 solution = new Solution9();
        int n = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        assertTrue("Case: Possible bipartition", solution.possibleBipartition(n, dislikes));
    }

    /**
     * 测试目的：
     * 验证在无可能的二分方案时，函数是否正确返回 false。
     *
     * 测试用例：
     * 输入：n = 3, dislikes = {{1, 2}, {1, 3}, {2, 3}}
     * 期望输出：false
     */
    @Test
    public void testPossibleBipartition_False() {
        Solution9 solution = new Solution9();
        int n = 3;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 3}};
        assertFalse("Case: Impossible bipartition", solution.possibleBipartition(n, dislikes));
    }

    /**
     * 测试目的：
     * 验证在无不喜欢关系的情况下，函数是否正确返回 true。
     *
     * 测试用例：
     * 输入：n = 5, dislikes = {}
     * 期望输出：true
     */
    @Test
    public void testNoDislikes() {
        Solution9 solution = new Solution9();
        int n = 5;
        int[][] dislikes = {};
        assertTrue("Case: No dislikes, always possible", solution.possibleBipartition(n, dislikes));
    }

    /**
     * 测试目的：
     * 验证在大规模输入的情况下，函数能否正常工作。
     *
     * 测试用例：
     * 输入：n = 2000, dislikes = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}
     * 期望输出：false
     */
    @Test
    public void testEdgeCase_LargeN() {
        Solution9 solution = new Solution9();
        int n = 2000;
        int[][] dislikes = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        assertFalse("Case: Large input, impossible bipartition", solution.possibleBipartition(n, dislikes));
    }

    /**
     * 测试目的：
     * 验证函数能否正确处理最小输入规模的情况。
     *
     * 测试用例：
     * 输入：n = 1, dislikes = {}
     * 期望输出：true
     */
    @Test
    public void testMinimumInput() {
        Solution9 solution = new Solution9();
        int n = 1;
        int[][] dislikes = {};
        assertTrue("Case: Minimum input, always possible", solution.possibleBipartition(n, dislikes));
    }
}
