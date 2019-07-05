package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: mz
 * Date: 2019/7/5 15:06
 * Description:  最小生成树
 *
 */
public class LeastGenTree {

    final static int INF = Integer.MAX_VALUE;

    /**
     *  以图的顶点为基础，从一个初始顶点开始，寻找触达其他顶点权值最小的边，并把该顶点加入到已触达顶点的集合中。
     *  当全部顶点都加入到集合时，算法的工作就完成了。
     *  Prim算法的本质，是基于贪心算法。
     *
     * @param matrix
     * @return
     */
    public static int[]  prim(int[][] matrix){
        List<Integer> reachedVertexList = new ArrayList<Integer>();

        // 选择顶点0为初始顶点，放入已触达顶点集合
        reachedVertexList.add(0);

        // 创建最小生成树数组，首元素设为 -1
        int[] parents = new int[matrix.length];
        parents[0] = -1;

        int weight;          // 边的权重
        int fromIndex = 0;   // 源顶点下标
        int toIndex = 0;     // 目标顶点下标

        while(reachedVertexList.size() < matrix.length){
            weight = INF;
            //在已触达的顶点中，寻找到达新顶点的最短边
            for(Integer vertexIndex:reachedVertexList){
                for(int i = 0;i < matrix.length;i++){
                    if(!reachedVertexList.contains(i)){
                        if(matrix[vertexIndex][i] < weight){
                            fromIndex = vertexIndex;
                            toIndex = i;
                            weight = matrix[vertexIndex][i];
                        }
                    }
                }
            }
            //确定了权值最小的目标顶点，放入已触达顶点集合
            reachedVertexList.add(toIndex);

            //放入最小生成树的数组
            parents[toIndex] = fromIndex;
        }
        return parents;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 4, 3, INF, INF},
                {4, 0, 8, 7, INF},
                {3, 8, 0, INF, 1},
                {INF, 7, INF, 0 ,9},
                {INF, INF, 1, 9, 0}
        };

        int[] parents = prim(matrix);
        System.out.println(Arrays.toString(parents));
    }
}
