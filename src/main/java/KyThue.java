import java.util.List;

/**
 * Created by bean on 18/07/2017.
 */
public class KyThue {
    private String ID;
    private String Name;
    private List<ttno> thongTNo;

    public List<ttno> getThongTNo() {
        return thongTNo;
    }

    public void setThongTNo(List<ttno> thongTNo) {
        this.thongTNo = thongTNo;
    }

    public KyThue() {
    }

    public KyThue(String ID, String name) {
        this.ID = ID;
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
