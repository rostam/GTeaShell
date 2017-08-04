package gteashell;

import graphtea.extensions.G6Format;
import graphtea.graph.graph.GraphModel;
import graphtea.plugins.main.core.AlgorithmUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by rostam on 21.02.17.
 * @author M. Ali Rostami
 */
public class MergeCSVOnID {
    public static void main(String[] args) throws IOException {
        int n = 10;
        FileWriter fw = new FileWriter("out.csv");
        int id_cnt = 1;
        for(int i=1;i<=n;i++) {
            Scanner sc = new Scanner(new File("out"+i+".csv"));
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                line = id_cnt + line.substring(line.indexOf(","));
                GraphModel g = G6Format.stringToGraphModel(line.substring(line.lastIndexOf(",")+1));
                ArrayList<Integer> al = AlgorithmUtils.getDegreesList(g);
                Collections.sort(al);
                line=line.replace(',',' ');
                fw.write(line+" "+al.toString().replace(" ","")+"\n");
                id_cnt++;
            }
        }
        fw.flush();
        fw.close();
    }
}
