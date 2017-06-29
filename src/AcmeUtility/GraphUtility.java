package AcmeUtility;



import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class GraphUtility {

    private List<Vertex> nodes;
    private List<Edge> edges;
    private Map<String, Integer> map = new Hashtable<String,Integer>();

    public static void main(String a[]){
    	GraphUtility t = new GraphUtility();
    	//t.testExcute();
    	//t.findPath();
    	t.populateAndFind("3rd avenue and A Street","5th avenue and D Street");
    }
    
    public LinkedList<Vertex> populateAndFind(String s, String d) {
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
//        for (int i = 0; i < 11; i++) {
//            Vertex location0 = new Vertex("1st avenue and A street" + i, "Node_" + i);
//            //Vertex location = new Vertex(""+ i, "A street 1st Ave");
//            nodes.add(location0);
//        }
        Vertex location0 = new Vertex( "0", "1st avenue and A street");
        nodes.add(location0);
        map.put("1st avenue and A street", 0);
        
        Vertex location1 = new Vertex("1", "1st avenue and B street");
        nodes.add(location1);
        map.put("1st avenue and B street", 1);
        
        Vertex location2 = new Vertex("2", "1st avenue and C street");
        nodes.add(location2);
        map.put("1st avenue and C street", 2);
       
        Vertex location3 = new Vertex("3", "1st avenue and D Street");
        nodes.add(location3);
        map.put("1st avenue and D Street", 3);
        
        Vertex location4 = new Vertex("4", "1st avenue and E Street");
        nodes.add(location4);
        map.put("1st avenue and E Street", 4);

        Vertex location5 = new Vertex("5","1st avenue and F Street");
        nodes.add(location5);
        map.put("1st avenue and F Street", 5);

        Vertex location6 = new Vertex("6","1st avenue and G Street");
        nodes.add(location6);
        map.put("1st avenue and G Street", 6);

        Vertex location7 = new Vertex("7", "2nd avenue and A Street");
        nodes.add(location7);
        map.put("2nd avenue and A Street", 7);

        Vertex location8 = new Vertex("8", "2nd avenue and B Street");
        nodes.add(location8);
        map.put("2nd avenue and B Street", 8);

        Vertex location9 = new Vertex("9", "2nd avenue and C Street");
        nodes.add(location9);
        map.put("2nd avenue and C Street", 9);

        Vertex location10 = new Vertex("10", "2nd avenue and D Street");
        nodes.add(location10);
        map.put ("2nd avenue and D Street", 10);

        Vertex location11 = new Vertex("11", "2nd avenue and E Street");
        nodes.add(location11);
        map.put ("2nd avenue and E Street", 11);

        Vertex location12 = new Vertex("12", "2nd avenue and F Street");
        nodes.add(location12);
        map.put ("2nd avenue and F Street", 12);

        Vertex location13 = new Vertex("13", "2nd avenue and G Street");
        nodes.add(location13);
        map.put ("2nd avenue and G Street", 13);

        Vertex location14 = new Vertex("14", "3rd avenue and A Street");
        nodes.add(location14);
        map.put ("3rd avenue and A Street", 14);

        Vertex location15 = new Vertex("15", "3rd avenue and B Street");
        nodes.add(location15);
        map.put ("3rd avenue and B Street", 15);

        Vertex location16 = new Vertex("16", "3rd avenue and C Street");
        nodes.add(location16);
        map.put ("3rd avenue and C Street", 16);

        Vertex location17 = new Vertex("17", "3rd avenue and D Street");
        nodes.add(location17);
        map.put ("3rd avenue and D Street", 17);

        Vertex location18 = new Vertex("18", "3rd avenue and E Street");
        nodes.add(location18);
        map.put ("3rd avenue and E Street", 18);

        Vertex location19 = new Vertex("19", "3rd avenue and F Street");
        nodes.add(location19);
        map.put ("3rd avenue and F Street", 19);

        Vertex location20 = new Vertex("20", "3rd avenue and G Street");
        nodes.add(location20);
        map.put ("3rd avenue and G Street", 20);

        Vertex location21 = new Vertex("21", "4th avenue and A Street");
        nodes.add(location21);
        map.put ("4th avenue and A Street", 21 );

        Vertex location22 = new Vertex("22", "4th avenue and B Street");
        nodes.add(location22);
        map.put ("4th avenue and B Street", 22 );

        Vertex location23 = new Vertex("23", "4th avenue and C Street");
        nodes.add(location23);
        map.put ("4th avenue and C Street", 23 );

        Vertex location24 = new Vertex("24" , "4th and avenue D Street" );
        nodes.add(location24);
        map.put ("4th avenue and D Street", 24 );

        Vertex location25 = new Vertex("25", "4th avenue and E Street");
        nodes.add(location25);
        map.put ("4th avenue and E Street", 25 );

        Vertex location26 = new Vertex("26", "4th avenue and F Street");
        nodes.add(location26);
        map.put ("4th avenue and F Street", 26 );

        Vertex location27 = new Vertex("27", "4th avenue and G Street");
        nodes.add(location27);
        map.put ("4th avenue and G Street", 27 );

        Vertex location28 = new Vertex("28", "5th avenue and A Street");
        nodes.add(location28);
        map.put ("5th avenue and A Street", 28 );

        Vertex location29 = new Vertex("29", "5th avenue and B Street");
        nodes.add(location29);
        map.put ("5th avenue and B Street", 29 );

        Vertex location30 = new Vertex("30", "5th avenue and C Street");
        nodes.add(location30);
        map.put ("5th avenue and C Street", 30 );

        Vertex location31 = new Vertex("31", "5th avenue and D Street");
        nodes.add(location31);
        map.put ("5th avenue and D Street", 31 );

        Vertex location32 = new Vertex("32", "5th avenue and E Street");
        nodes.add(location32);
        map.put ("5th avenue and E Street", 32 );

        Vertex location33 = new Vertex("33", "5th avenue and F Street");
        nodes.add(location33);
        map.put ("5th avenue and F Street", 33 );

        Vertex location34 = new Vertex("34","5th avenue and G Street");
        nodes.add(location34);
        map.put ("6th avenue and G Street", 34 );

        Vertex location35 = new Vertex("35", "6th avenue and A Street");
        nodes.add(location35);
        map.put ("6th avenue and A Street", 35 );

        Vertex location36 = new Vertex("36", "6th avenue and B Street");
        nodes.add(location36);
        map.put ("6th avenue and B Street", 36 );

        Vertex location37 = new Vertex("37", "6th avenue and C Street");
        nodes.add(location37);
        map.put ("6th avenue and C Street", 37 );

        Vertex location38 = new Vertex("38",  "6th avenue and D Street");
        nodes.add(location38);
        map.put ("6th avenue and D Street", 38 );

        Vertex location39 = new Vertex("39",   "6th avenue and E Street");
        nodes.add(location39);
        map.put ("6th avenue and E Street", 39 );

        Vertex location40 = new Vertex("40" , "6th avenue and F Street" );
        nodes.add(location40);
        map.put ("6th avenue and F Street", 40 );

        Vertex location41 = new Vertex("41", "6th avenue and G Street");
        nodes.add(location41);
        map.put ("6th avenue and G Street", 41 );

        Vertex location42 = new Vertex("42", "7th avenue and A Street");
        nodes.add(location42);
        map.put ("7th avenue and A Street", 42 );

        Vertex location43 = new Vertex("43", "7th avenue and B Street");
        nodes.add(location43);
        map.put ("7th avenue and B Street", 43 );

        Vertex location44 = new Vertex("44", "7th avenue and C Street");
        nodes.add(location44);
        map.put ("7th avenue and C Street", 44 );

        Vertex location45 = new Vertex("45", "7th avenue and D Street");
        nodes.add(location45);
        map.put ("7th avenue and D Street", 45 );

        Vertex location46 = new Vertex("46", "7th avenue and E Street");
        nodes.add(location46);
        map.put ("7th avenue and E Street", 46 );

        Vertex location47 = new Vertex("47", "7th avenue and F Street");
        nodes.add(location47);
        map.put ("7th avenue and F Street", 47 );

        Vertex location48 = new Vertex("48", "7th avenue and G Street");
        nodes.add(location48);
        map.put ("7th avenue and G Street", 48 );

       
        
        
          addLane("Edge_0_1", 0, 1,  1); // edge_o_1 line betn 0 vertex and 1 verte addLane("Edge_o_1",0,1,1)
          addLane("Edge_1_2", 1, 2,  1); // edge_1_2 lane btwn 1 and 2 nodes addLane("Edge_1_2",1,2,1)
          addLane("Edge_2_3", 2, 3,  1);
          addLane("Edge_3_4", 3, 4,  1);
          addLane("Edge_4_5", 4, 4,  1);
          addLane("Edge_5_6", 5, 6,  1);
          addLane("Edge_14_15", 14, 15,  1);
          addLane("Edge_15_16", 15, 16,  1);
          addLane("Edge_16_17", 16, 17,  1);
          addLane("Edge_17_18", 17, 18,  1);
          addLane("Edge_18_19", 18, 19,  1);
          addLane("Edge_19_20", 20, 21, 1);
          addLane("Edge_21_22", 21, 22, 1);
          addLane("Edge_22_23", 22, 23, 1);
          addLane("Edge_23_24", 23, 24, 1);
          addLane("Edge_24_25", 24, 25, 1);
          addLane("Edge_25_26", 25, 26, 1);
          addLane("Edge_26_27", 26, 27, 1);
          addLane("Edge_28_29", 28, 29, 1);
          addLane("Edge_29_30", 29, 30, 1);
          addLane("Edge_30_31", 30, 31, 1);
          addLane("Edge_31_32", 31, 32, 1);
          addLane("Edge_32_33", 32, 33, 1);
          addLane("Edge_33_34", 33, 34, 1);
          addLane("Edge_42_43", 42, 43, 1);
          addLane("Edge_43_44", 43, 44, 1);
          addLane("Edge_44_45", 44, 45, 1);
          addLane("Edge_45_46", 45, 46, 1);
          addLane("Edge_46_47", 46, 47, 1);
          addLane("Edge_47_48", 47, 48, 1);
          
          // vertical edges
          addLane("Edge_0_7", 0, 7, 1);
          addLane("Edge_1_8", 1, 8, 1);
          addLane("Edge_2_9", 2, 9, 1);
          addLane("Edge_3_10", 3, 10, 1);
          addLane("Edge_4_11", 4, 11, 1);
          addLane("Edge_5_12", 5, 12, 1);
          addLane("Edge_6_13", 6, 13, 1);
          addLane("Edge_7_14", 7, 14, 1);
          addLane("Edge_8_15", 8, 15, 1);
          addLane("Edge_9_16", 9, 16, 1);
          addLane("Edge_10_17", 10, 17, 85);
          addLane("Edge_11_18", 11, 18, 1);
          addLane("Edge_12_19", 12, 19, 1);
          addLane("Edge_13_20", 13, 20, 1);
          addLane("Edge_14_21", 14, 21, 1);
          addLane("Edge_15_22", 15, 22, 1);
          addLane("Edge_16_23", 16, 23, 1);
          addLane("Edge_17_24", 17, 24, 1);
          addLane("Edge_18_25", 18, 25, 1);
          addLane("Edge_19_26", 19, 26, 1);
          addLane("Edge_20_27", 20, 27, 1);
          addLane("Edge_21_28", 21, 28, 1);
          addLane("Edge_22_29", 22, 29, 1);
          addLane("Edge_23_30", 23, 30, 1);
          addLane("Edge_24_31", 24, 31, 1);
          addLane("Edge_25_32", 25, 32, 1);
          addLane("Edge_26_33", 26, 33, 1);
          addLane("Edge_27_34", 27, 34, 1);
          addLane("Edge_28_35", 28, 35, 1);
          addLane("Edge_29_36", 29, 36, 1);
          addLane("Edge_30_37", 30, 37, 1);
          addLane("Edge_31_38", 31, 38, 1);
          addLane("Edge_32_39", 32, 39, 1);
          addLane("Edge_33_40", 33, 40, 1);
          addLane("Edge_34_41", 34, 41, 1);
          addLane("Edge_35_42", 35, 42, 1);
          addLane("Edge_36_43", 36, 43, 1);
          addLane("Edge_37_44", 37, 44, 1);
          addLane("Edge_38_45", 38, 45, 1);
          addLane("Edge_39_46", 39, 46, 1);
          addLane("Edge_40_47", 40, 47, 1);
          addLane("Edge_41_48", 41, 48, 1);
          
          //two way roads
          addLane("Edge_7_8", 7, 8,  1);
          addLane("Edge_8_7", 8, 7,  1);
          addLane("Edge_8_9", 8, 9,  1);           
          addLane("Edge_9_8", 9, 8, 1);
          addLane("Edge_9_10",9, 10, 1);
          addLane("Edge_10_9",10, 9, 1);
          addLane("Edge_10_11", 10, 11, 1);
          addLane("Edge_11_10", 11, 10, 1);
          addLane("Edge_11_12", 11, 12, 1);
          addLane("Edge_12_11", 11, 12, 1);
          addLane("Edge_12_13", 12, 13,  1);
          addLane("Edge_13_12", 13, 12,  1);
          addLane("Edge_35_36", 35, 36, 1);
          addLane("Edge_36_35", 36, 35, 1);
          addLane("Edge_37_36", 37, 36, 1);
          addLane("Edge_36_37", 36, 37, 1);
          addLane("Edge_37_38", 37, 38, 1);
          addLane("Edge_38_37", 38, 37, 1);
          addLane("Edge_38_39", 38, 39, 1);
          addLane("Edge_39_38", 39, 38, 1);
          addLane("Edge_39_40", 39, 40, 1);
          addLane("Edge_40_39", 40, 39, 1);
          addLane("Edge_40_41", 40, 41, 1);
          addLane("Edge_41_40", 41, 40, 1);
          addLane("Edge_3_10", 3, 10, 1);
          addLane("Edge_10_3", 10, 3, 1);
          addLane("Edge_10_17", 10, 17, 1);
          addLane("Edge_17_10", 17, 10, 1);
          addLane("Edge_17_24", 17, 24, 1);
          addLane("Edge_24_17", 24, 17, 1);
          addLane("Edge_24_31", 24, 31, 1);
          addLane("Edge_31_24", 31, 24, 1);
          addLane("Edge_38_31", 38, 31, 1);
          addLane("Edge_31_38", 31, 38, 1);
          addLane("Edge_38_45", 38, 45, 1);
          addLane("Edge_45_38", 45, 38, 1);
          




        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        int source , destination =0;
//        source= Integer.parseInt(s);
//        destination = Integer.parseInt(d);
        destination =  map.get(d);
        System.out.println("the dest"+ destination);
//        for (String key : map.keySet()) {
//        	System.out.println("from map:"+ key);
//        }
        source = map.get(s);
        System.out.println("the vertices:"+ source +","+destination);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(source));
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(destination));

//        assertNotNull(path);
//        assertTrue(path.size() > 0);
        for (Vertex vertex : path) {
            System.out.println(vertex);
        }
       
        return path;

    }
    
    public LinkedList<Vertex> findPath(){
    	 Graph graph = new Graph(nodes, edges);
         DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
         dijkstra.execute(nodes.get(15));
         LinkedList<Vertex> path = dijkstra.getPath(nodes.get(25));

//         assertNotNull(path);
//         assertTrue(path.size() > 0);

         for (Vertex vertex : path) {
             System.out.println(vertex);
         }
         return path;
    }

    private void addLane(String laneId, int sourceLocNo, int destLocNo,
            int duration) {
        Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration );
        edges.add(lane);
    }
}