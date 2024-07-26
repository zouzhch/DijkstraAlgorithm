import java.util.HashMap;
import java.util.Map;

public class WeightGraph {
    //to store the whole graph, including the node name and its neighbours,
    //each neighbour includes name and its cost to the node
    private static final Map<String, Map<String, Integer>> nodesMap = new HashMap<String, Map<String, Integer>>();
    //to store the lowest cost of to the specific node
    private static final Map<String, Integer> costMap = new HashMap<String, Integer>();
    //to store the parents node of the lowest cost path
    private static final Map<String, String> parentsMap = new HashMap<String, String>();
    //to store the nodes have been processed
    private static final String[] processed=new String[6];

    public static void main(String[] args) {
        Map<String, Integer> neighboursMapS = new HashMap<String, Integer>();
        neighboursMapS.put("A",5);
        neighboursMapS.put("B",2);
        Map<String, Integer> neighboursMapA = new HashMap<String, Integer>();
        neighboursMapA.put("C",4);
        neighboursMapA.put("D",2);
        Map<String, Integer> neighboursMapB = new HashMap<String, Integer>();
        neighboursMapB.put("A",8);
        neighboursMapB.put("D",7);
        Map<String, Integer> neighboursMapC = new HashMap<String, Integer>();
        neighboursMapC.put("D",6);
        neighboursMapC.put("E",3);
        Map<String, Integer> neighboursMapD = new HashMap<String, Integer>();
        neighboursMapD.put("E",1);
        Map<String, Integer> neighboursMapE = new HashMap<String, Integer>();
        nodesMap.put("S",neighboursMapS);   //---S means the Start node
        nodesMap.put("A", neighboursMapA);
        nodesMap.put("B", neighboursMapB);
        nodesMap.put("C", neighboursMapC);
        nodesMap.put("D", neighboursMapD);
        nodesMap.put("E", neighboursMapE);  //---E means the End node
        costMap.put("A",5);
        costMap.put("B",2);
        costMap.put("C",1000);
        costMap.put("D",1000);
        costMap.put("E",1000);
        parentsMap.put("A","S");
        parentsMap.put("B","S");
        parentsMap.put("C",null);
        parentsMap.put("D",null);
        parentsMap.put("E",null);

        int index=0;    //---The index of the processed array
        /**--------The Core Algorithm------
         *      Dijkstra Algorithm
         *  ---find the lowest cost path in a weight graph
         */
        String processingNode=findLowestNode(); //---get the lowest cost node from the costMap
        while (processingNode!=null){   //---process all the nodes on the costMap
            int cost=costMap.get(processingNode);   //---get the present cost to this node
            Map<String, Integer> theNeighbours=nodesMap.get(processingNode);    //---get the neighbours of the node
            for (Map.Entry < String,Integer > entry: theNeighbours.entrySet()) {    //---process each of its neighbours
                int newCost=cost+entry.getValue();  //---get the cost from the present node to the processing node
                if(costMap.get(entry.getKey())>newCost){    //---if it costs less than the record on the costMap
                    costMap.replace(entry.getKey(),newCost);    //---then update the cost on the costMap
                    parentsMap.replace(entry.getKey(),processingNode);  //---and define this node as the neighbour's parents
                }
            }
            processed[index++]=processingNode;  //---after process above,put the node into the processed array
            processingNode=findLowestNode();    //---get the second-lowest cost from the costMap, and go on...
        }

        //output result
        System.out.println("The Lowest Cost Path is:\t"+getPath("E"));
        System.out.println("The Lowest Cost is:\t"+costMap.get("E"));

        //can observe the processing order of the nodes from the processed array
        System.out.print("The processed array is:\t");
        for (int i = 0; i < index; i++) {
            System.out.print(processed[i]+"-->");
        }

    }

    public static String findLowestNode() {
        int lowestCost=1000;    //---define 1000 as the largest cost
        String lowestCostNode=null;
        for (Map.Entry < String,Integer > entry: costMap.entrySet()) {
            boolean flag=false;
            for (String s : processed) {    //---determine if the node has been processed by comparing each of items
                if (entry.getKey().equals(s)) {
                    flag = true;
                    break;
                }
            }
            if(!flag && entry.getValue()<lowestCost){   //if the node hasn't been processed and the cost less than the lowest cost
                lowestCost=entry.getValue();    //assign it to the lowest cost
                lowestCostNode=entry.getKey();  //assign it to the lowest cost node
            }
        }
        return lowestCostNode;  //return the final lowest cost node
    }

    public static String getPath(String node){
        if("S".equals(node))return "Start";
        return getPath(parentsMap.get(node))+"-->"+node;
    }

}
