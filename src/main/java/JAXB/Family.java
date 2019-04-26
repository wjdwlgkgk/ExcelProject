package JAXB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

public class Family {

    private String description;
    @XmlElementWrapper(name = "persons")
    @XmlElement
    private List<Person> members = new ArrayList<Person>();

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }


    public List<Person> getMembers(){
        return members;
    }


}
