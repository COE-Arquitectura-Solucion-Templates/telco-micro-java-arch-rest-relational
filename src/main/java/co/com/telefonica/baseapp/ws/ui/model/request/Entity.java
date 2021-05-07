package co.com.telefonica.baseapp.ws.ui.model.request;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@javax.persistence.Entity
@Table(name = "entity")
//@Table(name = "\"Entity\"")

public class Entity {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "parameter1")

    public Long parameter1;


    @Column(name = "parameter2")

    public String parameter2;


    @Column(name = "parameter3")

    public String parameter3;


    public Entity() {}

    public Entity(long parameter1, String parameter2, String parameter3) {

        this.parameter1 = parameter1;

        this.parameter2 = parameter2;

        this.parameter3 = parameter3;

    }
    
    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(String.valueOf(parameter1));
        builder.append(", ");
        builder.append(parameter2);
        builder.append(", ");
        builder.append(parameter3);

        return builder.toString();
    }

}
