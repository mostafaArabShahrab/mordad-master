package ir.mordad.entity;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Scope("prototype")
// @Scope("prototype"): the opposite of singleton
@Component("studentEntity")
public class StudentEntity {
    private int id;
    private String name;

//    First Attempt: (does not work)
//    @Autowired
//    private Logger logger;

    // Second Attempt (worx)
    // made the Logger the argument of the constructor
    @Autowired
    public StudentEntity(Logger logger) {
        setId(new Random().nextInt(100_000));
        setName("Kaaalim" + id);
        logger.info("new student entity born");
    }

    public StudentEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
