package ai.openfabric.api.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity()
public class Worker extends Datable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "of-uuid")
    @GenericGenerator(name = "of-uuid", strategy = "ai.openfabric.api.model.IDGenerator")
    @Getter
    @Setter
    public String id;

    private String name;

//    private Integer port;
//
//    private Boolean status;
//
//
//    public Worker(String name, Integer port, Boolean status) {
//        this.name = name;
//        this.port = port;
//        this.status = status;
//    }
//
//    public Worker() {
//    }
//
//    public Worker(String id, String name, Integer port, Boolean status) {
//        this.id = id;
//        this.name = name;
//        this.port = port;
//        this.status = status;
//    }
//
//    public Boolean getStatus() {
//        return status;
//    }
//
//    public void setStatus(Boolean status) {
//        this.status = status;
//    }
//
//    public Integer getPort() {
//        return port;
//    }
//
//    public void setPort(Integer port) {
//        this.port = port;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Worker{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", port=" + port +
//                ", status=" + status +
//                '}';
//    }
}
