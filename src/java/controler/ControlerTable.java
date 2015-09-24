/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package controler;

import Beans.Student;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Arthur
 */
@ManagedBean(name = "controlerTableMB")
@SessionScoped
public class ControlerTable implements Serializable {

    private List<Student> list;
    private Student student;
    private Boolean save;

    /**
     * Creates a new instance of controlerTable
     */
    public ControlerTable() {
        list = new ArrayList();
        save = true;
    }

    public String remove(Student student) {
        list.remove(student);
        return "index?faces-redirect=true";
    }

    public String newStudent() {
        student = new Student();
        save = true;
        return "FormStudent?faces-redirect=true";
    }

    public String insert() {
        list.add(student);
        return "index?faces-redirect=true";
    }

    public String edit(Student student) {
        this.student = student;
        save = false;
        return "FormStudent?faces-redirect=true";
    }

    public String makeChange() {
        if (list.contains(this)) {
            list.add(student.getId(), student);
        }
        return "index?faces-redirect=true";
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Boolean getSave() {
        return save;
    }

    public void setSave(Boolean save) {
        this.save = save;
    }
       
}
