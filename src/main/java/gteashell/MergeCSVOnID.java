package gteashell;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by rostam on 21.02.17.
 * @author M. Ali Rostami
 */
public class MergeCSVOnID {
    public static void main(String[] args) throws IOException {
        int n = 2;
        FileWriter fw = new FileWriter("out.csv");
        int id_cnt = 1;
        for(int i=1;i<=n;i++) {
            Scanner sc = new Scanner(new File("out"+i+".csv"));
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                line = id_cnt + line.substring(line.indexOf(","));
                fw.write(line+"\n");
                id_cnt++;
            }
        }
        fw.flush();
        fw.close();
    }
}
