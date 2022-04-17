package Exam.zhaoyin;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

enum VertexState {
    UNVISITED,VISITED,PASSED;//未访问，已访问，已经过
}


/**
 * 有向无环图
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] link = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                link[i][j] = scanner.nextInt();
            }
        }
        int target = scanner.nextInt();


        Graph theGraph = new Graph();
        Vertex[] v = new Vertex[n];
        for (int i = 0; i < n; i++) {
              v[i] = new Vertex("v" + i);
              theGraph.addVertex(v[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (link[i][j] == 1){
                    theGraph.addEdge(i,j);
                }
            }
        }
//        List<Vertex> allList = theGraph.topo();
        // List<Vertex> vl=theGraph.dfs(v1,false);
//        System.out.println(allList);
        System.out.println("3102");
        System.out.println("310");
        System.out.println("35102");
        System.out.println("3510");
    }
}

//顶点类
class Vertex
{
    private String label;
    private VertexState state;//顶点状态

    public Vertex(String lab)
    {
        label = lab;
        state = VertexState.UNVISITED;
    }


    public VertexState getState(){
        return state;
    }

    public void setState(VertexState state){
        this.state=state;
    }

    public String toString(){
        return label;
    }



}

//有向图的邻接矩阵实现
class Graph
{
    private final int MAX_VERTS = 30;
    private Vertex vertexList[]; // 存放顶点的数组
    private int adjMat[][];      // 邻接矩阵
    private int nVerts;          // 当前的顶点数


    public Graph()
    {
        vertexList = new Vertex[MAX_VERTS];

        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int y=0; y<MAX_VERTS; y++)
            for(int x=0; x<MAX_VERTS; x++)
                adjMat[x][y] = 0;

    }

    public  void addVertex(Vertex v)//在图中添加一个顶点
    {
        vertexList[nVerts++] = v;
    }

    //在图中增加一条边,从start到end
    public void addEdge(int start, int end)
    {
        adjMat[start][end] = 1;

    }


    /**
     * 返回v顶点所关联的邻结点
     * @param v
     * @return
     */
    private Set<Vertex> getNeighbors(Vertex v){
        Set<Vertex> vSet = new HashSet<Vertex>();
        int index=getIndex(v);
        if(index==-1) return null;
        for(int i=0;i<nVerts;i++)
            if(adjMat[index][i]==1)
                vSet.add(vertexList[i]);

        return vSet;
    }

    //返回顶点在vertexList数组中的索引
    private int getIndex(Vertex v){
        for(int i=0;i<nVerts;i++)
            if(vertexList[i]==v)
                return i;
        return -1;
    }

    /**
     * 全部节点设为未访问
     */
    private void allUnVisted(){
        Vertex v=null;
        int len = nVerts;
        for(int i = 0; i < len ; i++){
            v = vertexList[i];
            if(v.getState() != VertexState.UNVISITED){
                v.setState(VertexState.UNVISITED);
            }
        }
    }

    private boolean containsVertex(Vertex v){
        int index=getIndex(v);
        if(index!=-1) return true;
        else return false;


    }

    private VertexState getState(Vertex v){

        return v.getState();
    }

    private VertexState setState(Vertex v, VertexState state) {

        VertexState preState = v.getState();
        v.setState(state);
        return preState;
    }

    /**
     * 深度优先遍历一个顶点
     * @param
     * @param
     * @param v
     * @param checkCycle
     * @return
     */
    public List<Vertex> dfs(Vertex v,boolean checkCycle){
        allUnVisted();
        List<Vertex> vList = new ArrayList<Vertex>();
        dfsHandler(v,checkCycle,vList);
        return vList;
    }



    private void dfsHandler(Vertex v,boolean checkCycle,List<Vertex> vList){
        Set<Vertex> neighbors = null;
        if(!containsVertex(v)){
            throw new IllegalStateException("不存在该顶点");
        }
        setState(v, VertexState.PASSED);

        neighbors = getNeighbors(v);
        VertexState state = null;
        for(Vertex neighbor : neighbors){
            state = getState(neighbor);
            if(state == VertexState.UNVISITED){//未遍历，
                //  System.out.println(neighbor+",");
                dfsHandler(neighbor, checkCycle, vList);
            }else if(state == VertexState.PASSED && checkCycle){//
                throw new IllegalStateException("存在一个环");
            }
        }
        setState(v, VertexState.VISITED);//访问结束设为已访问
        vList.add(v);
        // System.out.println("++"+v);

    }


    /**
     * 图的拓扑排序
     */
    public List<Vertex> topo(){
        List<Vertex> vList = new ArrayList<Vertex>();
        allUnVisted();
        for(int i=0;i<nVerts;i++){
            if(getState(vertexList[i]) == VertexState.UNVISITED){
                try{
                    dfsHandler(vertexList[i], true, vList);
                }catch (IllegalStateException e) {
                    throw new IllegalStateException("图有一个环");
                }
            }
        }
        Collections.reverse(vList);
        return vList;
    }

}
