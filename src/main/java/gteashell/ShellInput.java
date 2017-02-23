package gteashell;

import graphtea.extensions.G6Format;
import graphtea.extensions.reports.energy.UpperBounds;
import graphtea.graph.graph.GraphModel;
import graphtea.graph.graph.RenderTable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by rostam on 19.02.17.
 * @author M. Ali Rostami
 */
public class ShellInput {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File(args[0]));
        FileWriter fw = new FileWriter(new File("output.csv"));
        int cnt = 1;
        while(sc.hasNextLine()) {
            String g6 = sc.nextLine();
            GraphModel g  = G6Format.stringToGraphModel(g6);
            UpperBounds ub = new UpperBounds();
            RenderTable rt = (RenderTable) ub.calculate(g);
            if(Double.parseDouble(rt.element().get(0).toString()) == 20) {
                String tmp = cnt + ",";
                tmp +=  rt.element().get(0).toString() + "," + g6;
                fw.write(tmp + "\n");
                fw.flush();
                cnt++;
            }
        }
        fw.close();
    }
}
