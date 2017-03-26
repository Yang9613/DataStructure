package Graph;

/**
 * Created by MOMO on 2017/3/17.
 */
public class AdjacencyMatrix {
    private char[] Vexs;       // 顶点集合
    private int[][] Matrix;    // 邻接矩阵
    public AdjacencyMatrix(char[] vexs, char[][] edges) {

        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;
        int elen = edges.length;

        // 初始化"顶点"
        Vexs = new char[vlen];
        for (int i = 0; i < Vexs.length; i++){
            Vexs[i] = vexs[i];
        }

        // 初始化"边"
        Matrix = new int[vlen][vlen];
        for (int i = 0; i < elen; i++) {
            // 读取边的起始顶点和结束顶点
            int p1 = getPosition(edges[i][0]);//以顶点找到A点
            int p2 = getPosition(edges[i][1]);//以顶点找到B点
            Matrix[p1][p2] = 1;//A到B的边即存在
        }
    }

    /*
     * 返回ch位置
     */
    private int getPosition(char ch) {
        for(int i=0; i<Vexs.length; i++){
            if(Vexs[i]==ch){//顶点的值和
                return i;
            }
        }
        return -1;
    }

    //
    /*
     * 打印矩阵队列图
     */
    public void print() {
        System.out.printf("有向Martix Graph:\n");
        for (int i = 0; i < Vexs.length; i++) {
            for (int j = 0; j < Vexs.length; j++){
                System.out.printf("%d ", Matrix[i][j]);
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D'};

        char[][] edges = new char[][]{//边是个二维数组
                {'A', 'D'},
                {'B', 'A'},
                {'C', 'A'},
                {'C', 'B'},
                {'B', 'C'}
        };
        // 采用已有的"图"
        AdjacencyMatrix pG = new AdjacencyMatrix(vexs, edges);

        pG.print();   // 打印图
    }
}
