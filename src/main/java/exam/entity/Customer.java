package exam.entity;

/**
 * Created by ASpiralMoon on 2016/12/19.
 * 用户实体类
 */
public class Customer {

    private short customer_id;
    private String first_name;

    public short getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(short customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Override
    public String toString() {
        return "customer{" +
                "customer_id=" + customer_id +
                ", first_name='" + first_name + '\'' +
                '}';
    }
}
