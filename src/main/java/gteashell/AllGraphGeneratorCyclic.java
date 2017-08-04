package gteashell;

import graphtea.extensions.G6Format;
import graphtea.extensions.reports.boundcheck.forall.GraphFilter;
import graphtea.extensions.reports.boundcheck.forall.filters.*;
import graphtea.graph.graph.GraphModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by rostam on 2/27/17.
 * @author M. Ali Rostami
 */
public class AllGraphGeneratorCyclic {
    //parameters: file_name filter
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File(args[0]));
        FileWriter fw1 = new FileWriter(new File(args[0].substring(0,args[0].indexOf(".")) + "_Unicyclic"));
        FileWriter fw2 = new FileWriter(new File(args[0].substring(0,args[0].indexOf(".")) + "_Bicyclic" ));
        FileWriter fw3 = new FileWriter(new File(args[0].substring(0,args[0].indexOf(".")) + "_Tricyclic" ));
        FileWriter fw4 = new FileWriter(new File(args[0].substring(0,args[0].indexOf(".")) + "_Tetracyclic" ));
        FileWriter fw5 = new FileWriter(new File(args[0].substring(0,args[0].indexOf(".")) + "_Pentacyclic"));
        GraphFilter f1 = new UnicyclicGraph();
        GraphFilter f2 = new BicyclicGraph();
        GraphFilter f3 = new TricyclicGraph();
        GraphFilter f4 = new TetracyclicGraph();
        GraphFilter f5 = new PentacyclicGraph();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            GraphModel g = G6Format.stringToGraphModel(line);
            if(f1.filter(g))  {fw1.write(G6Format.graphToG6(g) + "\n");fw1.flush();}
            if(f2.filter(g))  {fw2.write(G6Format.graphToG6(g) + "\n");fw1.flush();}
            if(f3.filter(g))  {fw3.write(G6Format.graphToG6(g) + "\n");fw1.flush();}
            if(f4.filter(g))  {fw4.write(G6Format.graphToG6(g) + "\n");fw1.flush();}
            if(f5.filter(g))  {fw5.write(G6Format.graphToG6(g) + "\n");fw1.flush();}
        }
        fw1.close();fw2.close();fw3.close();fw4.close();fw5.close();

    }
}
