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
public class AllGraphGenerator {
    //parameters: file_name filter
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File(args[0]));
        GraphFilter filter = getCorrectFilter(args[1]);
        FileWriter fw = new FileWriter(new File(args[0].substring(0,args[0].indexOf(".")) + "_" +args[1] ));
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            GraphModel g = G6Format.stringToGraphModel(line);
            if(filter.filter(g)) {
                fw.write(G6Format.graphToG6(g) + "\n");
                fw.flush();
            }
        }
        fw.close();
    }

    private static GraphFilter getCorrectFilter(String filter) {
        GraphFilter gf = null;
        switch (filter) {
            case Filters.Integral:
                gf = new IntegralFilter();
                break;
            case Filters.LaplacianIntegral:
                gf = new LaplacianIntegralFilter();
                break;
            case Filters.QIntegral:
                gf = new QIntegralFilter();
                break;
            case Filters.ChemTree:
                gf = new ChemTreeFilter();
                break;
            case Filters.MinDeg2:
                gf = new MinDeg2Filter();
                break;
            case Filters.Unicyclic:
                gf = new UnicyclicGraph();
                break;
            case Filters.Bicyclic:
                gf = new BicyclicGraph();
                break;
            case Filters.Tricyclic:
                gf = new TricyclicGraph();
                break;
            case Filters.Tetracyclic:
                gf = new TetracyclicGraph();
                break;
            case Filters.Pentacyclic:
                gf = new PentacyclicGraph();
                break;
        }
        return gf;
    }}
