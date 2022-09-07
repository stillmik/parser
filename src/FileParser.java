import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileParser {
    private ArrayList<V> vList = new ArrayList<>();
    private ArrayList<VT> vtList = new ArrayList<>();
    private ArrayList<VN> vnList = new ArrayList<>();
    private ArrayList<F> fList = new ArrayList<>();

    public void initParameters(String filePath) {

        ArrayList<String> lines = readFile(filePath);
        for (String line : lines) {
            if (line.startsWith("v ")) {
                line = line.substring(2);
                vList.add(infV(line));
            } else if (line.startsWith("vt ")) {
                line = line.substring(3);
                vtList.add(infVT(line));
            } else if (line.startsWith("vn ")) {
                line = line.substring(3);
                vnList.add(infVN(line));
            } else if (line.startsWith("f ")) {
                line = line.substring(2);
                fList.add(infF(line));
            }
        }

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < fList.get(i).v_vn.size(); j++) {
                System.out.println(fList.get(i).v_vn.get(j).v + " " + fList.get(i).v_vn.get(j).vn);
            }
            System.out.println('\n');
        }
    }

    private ArrayList<String> readFile(String filePath) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines.add(data);
            }
            myReader.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return lines;
    }

    private V infV(String vString) {
        V v = new V();
        vString = vString.trim();
        String[] nums = vString.split(" ");
        v.x = Double.parseDouble(nums[0].trim());
        v.y = Double.parseDouble(nums[1].trim());
        v.z = Double.parseDouble(nums[2].trim());
        if (nums.length == 3) {
            v.w_ = 1;
        } else {
            v.w_ = Double.parseDouble(nums[3].trim());
        }
        return v;
    }

    private VN infVN(String vnString) {
        VN vn = new VN();
        vnString = vnString.trim();
        String[] nums = vnString.split(" ");
        vn.i = Double.parseDouble(nums[0].trim());
        vn.j = Double.parseDouble(nums[1].trim());
        vn.k = Double.parseDouble(nums[2].trim());
        return vn;
    }

    private VT infVT(String vtString) {
        VT vt = new VT();
        vtString = vtString.trim();
        String[] nums = vtString.split(" ");
        vt.u = Double.parseDouble(nums[0].trim());
        if (nums.length == 1) {
            vt.w_ = 0;
            vt.v_ = 0;
        } else {
            vt.w_ = Double.parseDouble(nums[1].trim());
            vt.v_ = Double.parseDouble(nums[2].trim());
        }
        return vt;
    }

    private F infF(String fString) {
        F f = new F();
        fString = fString.trim();
        String[] nums = fString.split(" ");
        for (String num : nums) {
            if (num.contains("//")) {
                V_VN v_vn = new V_VN();
                v_vn.v = Double.parseDouble(num.trim().substring(0, num.indexOf("//")));
                v_vn.vn = Double.parseDouble(num.trim().substring(num.indexOf("//") + 2));
                f.v_vn.add(v_vn);
            } else if (num.contains("/")) {
                if (num.indexOf('/') == num.lastIndexOf('/')) {
                    V_VT v_vt = new V_VT();
                    v_vt.v = Double.parseDouble(num.trim().substring(0, num.indexOf("/")));
                    v_vt.vt = Double.parseDouble(num.trim().substring(num.indexOf("/") + 1));
                    f.v_vt.add(v_vt);
                } else {
                    V_VT_VN v_vt_vn = new V_VT_VN();
                    v_vt_vn.v = Double.parseDouble(num.trim().substring(0, num.indexOf("/")));
                    v_vt_vn.vt = Double.parseDouble(num.trim().substring(num.indexOf("/") + 1, num.lastIndexOf('/')));
                    v_vt_vn.vt = Double.parseDouble(num.trim().substring(num.lastIndexOf('/') + 1));
                    f.v_vt_vn.add(v_vt_vn);
                }
            } else {
                f.v.add(Double.parseDouble(num));
            }
        }
        return f;
    }

    public ArrayList<V> getvList() {
        return vList;
    }

    public ArrayList<VT> getVtList() {
        return vtList;
    }

    public ArrayList<VN> getVnList() {
        return vnList;
    }

    public ArrayList<F> getfList() {
        return fList;
    }
}
