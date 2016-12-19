package exam.entity;

/**
 * Created by ASpiralMoon on 2016/12/19.
 * 语言实体类
 */
public class Language {

    private short language_id;
    private String name;

    public short getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(short language_id) {
        this.language_id = language_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "language{" +
                "language_id=" + language_id +
                ", name='" + name + '\'' +
                '}';
    }
}
